package hr.ferit.matijavrabelj.corona.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import hr.ferit.matijavrabelj.corona.common.*
import hr.ferit.matijavrabelj.corona.model.Country
import hr.ferit.matijavrabelj.corona.model.Global
import hr.ferit.matijavrabelj.corona.model.response.GetSummaryResponse
import hr.ferit.matijavrabelj.corona.networking.BackendFactory
import hr.ferit.matijavrabelj.corona.ui.activities.ContainerActivity
import hr.ferit.matijavrabelj.corona.ui.adapters.CountryAdapter
import hr.ferit.matijavrabelj.corona.ui.fragments.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_corona.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CoronaFragment : BaseFragment() {

    private var global = Global()
    private val adapter by lazy { CountryAdapter { onItemSelected(it) } }
    private val interactor = BackendFactory.getBeersInteractor()

    companion object {
        fun newInstance(): Fragment {
            return CoronaFragment()
        }
    }

    override fun getLayoutResourceId() = hr.ferit.matijavrabelj.corona.R.layout.fragment_corona

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initListeners()
        searchInput.clearFocus()
    }

    private fun initUi() {
        progress.visible()
        noData.visible()
        tasksRecyclerView.layoutManager = LinearLayoutManager(context)
        tasksRecyclerView.adapter = adapter
        getAllBeers()
    }

    private fun initListeners() {
        openGlobal.onClick { openGlobal() }
        searchInput.onTextChange {
            searchInput.requestFocus()
            adapter.searchCountry(searchInput.text.toString())
            if (searchInput.text.toString().isEmpty() || searchInput.text.toString().isBlank()) {
                searchInput.clearFocus()
                adapter.setAllCountries()
            }
        }
        clearSearch.onClick {
            searchInput.setText("")
            adapter.setAllCountries()
        }

    }

    private fun onItemSelected(country: Country) {
        val detailsIntent = Intent(context, ContainerActivity::class.java).apply {
            putExtra(EXTRA_SCREEN_TYPE, ContainerActivity.SCREEN_COUNTRY_DETAILS)
            putExtra(EXTRA_SELECTED_SLUG, country.slug)
        }
        startActivity(detailsIntent)
        //val dialog = DatePickerDialog.newInstance(country.slug)
        //dialog.show(childFragmentManager, dialog.tag)

    }

    private fun openGlobal() {
        val dialog = GlobalDialog.newInstance(
            global.newConfirmed.toString(),
            global.totalConfirmed.toString(),
            global.newDeaths.toString(),
            global.newRecovered.toString(),
            global.totalRecovered.toString()
        )
        dialog.show(childFragmentManager, dialog.tag)
    }

    private fun getAllBeers() {
        progress.visible()
        interactor.getSummary(getSummaryCallback())
    }

    private fun getSummaryCallback(): Callback<GetSummaryResponse> = object : Callback<GetSummaryResponse> {
        override fun onFailure(call: Call<GetSummaryResponse>?, t: Throwable?) {
            progress.gone()
            handleSomethingWentWrong()
        }

        override fun onResponse(call: Call<GetSummaryResponse>?, response: Response<GetSummaryResponse>) {
            progress.gone()
            noData.gone()
            if (response.isSuccessful) {
                when (response.code()) {
                    RESPONSE_OK -> handleOkResponse(response)
                    TOO_MANY -> handleOkResponse(response)
                    else -> handleSomethingWentWrong()
                }
            }
        }
    }

    private fun handleOkResponse(response: Response<GetSummaryResponse>) {
        response.body()?.run {
            adapter.setData(this.Countries, true)
            global = this.Global
            searchInput.clearFocus()
        }

    }

    private fun handleSomethingWentWrong() = this.activity?.displayToast("Something went wrong!")
}