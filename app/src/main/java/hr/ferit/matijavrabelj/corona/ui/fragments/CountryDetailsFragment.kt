package hr.ferit.matijavrabelj.corona.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import hr.ferit.matijavrabelj.corona.R
import hr.ferit.matijavrabelj.corona.common.EXTRA_SELECTED_SLUG
import hr.ferit.matijavrabelj.corona.common.RESPONSE_OK
import hr.ferit.matijavrabelj.corona.common.displayToast
import hr.ferit.matijavrabelj.corona.model.CountryDetails
import hr.ferit.matijavrabelj.corona.networking.BackendFactory
import hr.ferit.matijavrabelj.corona.ui.adapters.CountryDetailsAdapter
import hr.ferit.matijavrabelj.corona.ui.fragments.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_country_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryDetailsFragment : BaseFragment() {

    private var selectedSLUG: String = NO_SLUG
    private val adapter by lazy { CountryDetailsAdapter() }
    private val interactor = BackendFactory.getCoronasInteractor()


    override fun getLayoutResourceId(): Int {
        return R.layout.fragment_country_details
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(EXTRA_SELECTED_SLUG)?.let { selectedSLUG = it }
        tasksRecyclerViewDetails.layoutManager = LinearLayoutManager(context)
        tasksRecyclerViewDetails.adapter = adapter
        tryDisplayResults()
    }

    private fun tryDisplayResults() {
        interactor.getItemsByCountry(selectedSLUG, onCoronasCallback())
    }

    private fun onCoronasCallback(): Callback<List<CountryDetails>> = object : Callback<List<CountryDetails>> {
        override fun onFailure(call: Call<List<CountryDetails>>?, t: Throwable?) {
            handleSomethingWentWrong()
        }

        override fun onResponse(call: Call<List<CountryDetails>>?, response: Response<List<CountryDetails>>) {
            if (response.isSuccessful) {
                when (response.code()) {
                    RESPONSE_OK -> handleOkResponse(response)
                    else -> handleSomethingWentWrong()
                }
            }
        }
    }

    private fun handleOkResponse(response: Response<List<CountryDetails>>) {
        response.body()?.run {
            show(this.toMutableList())
        }
    }

    private fun show(countries: MutableList<CountryDetails>) {
        val result = (countries.asReversed()[0].confirmed.toInt() - countries.asReversed()[1].confirmed.toInt())
        if (result > 0) {
            newFieldInput.text = result.toString()
        } else {
            newFieldInput.text = "0"
        }

        countryNameFieldText.text = countries[0].country
        adapter.setData(countries.asReversed())
    }

    private fun handleSomethingWentWrong() = this.activity?.displayToast("Something went wrong!")

    companion object {
        const val NO_SLUG = "-1"

        fun newInstance(slug: String): CountryDetailsFragment {
            val bundle = Bundle().apply { putString(EXTRA_SELECTED_SLUG, slug) }
            return CountryDetailsFragment().apply { arguments = bundle }
        }
    }
}
