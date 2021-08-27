package hr.ferit.tkusevic.corona.ui.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import hr.ferit.tkusevic.corona.common.*
import hr.ferit.tkusevic.corona.model.response.ResponseRes
import hr.ferit.tkusevic.corona.networking.BackendFactory
import hr.ferit.tkusevic.corona.ui.fragments.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_disaster.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DisasterFragment : BaseFragment() {

    private val interactor = BackendFactory.getCoronasInteractor()

    companion object {
        fun newInstance(): Fragment {
            return DisasterFragment()
        }
    }

    override fun getLayoutResourceId() = hr.ferit.tkusevic.corona.R.layout.fragment_disaster

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUi()
        initListeners()
        text.clearFocus()
    }

    private fun initUi() {
    }

    private fun initListeners() {
        text.onTextChange {
            text.requestFocus()
        }
        search.onClick {
            getResults(text.text.toString(), key.text.toString())
        }
        clearSearch.onClick {
            resultView.setBackgroundColor(Color.BLACK)
            text.setText("")
            key.setText("")
        }

    }

    private fun getResults(text: String, key: String) {
        progress.visible()
        interactor.getResults(text, key, getSummaryCallback())
    }

    private fun getSummaryCallback(): Callback<ResponseRes> =
        object : Callback<ResponseRes> {
            override fun onFailure(
                call: Call<ResponseRes>?,
                t: Throwable?
            ) {
                progress.gone()
                handleSomethingWentWrong()
            }

            override fun onResponse(
                call: Call<ResponseRes>?,
                response: Response<ResponseRes>
            ) {
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

    private fun handleOkResponse(response: Response<ResponseRes>) {
        response.body()?.run {

            val resultFromAPI = this.results.output1.value.values.elementAtOrNull(0)?.elementAtOrNull(1).toString()
            if(resultFromAPI == "1"){
                resultView.setBackgroundColor(Color.RED)
            } else {
                resultView.setBackgroundColor(Color.GREEN)
            }
            resultPresent.text = (this.results.output1.value.values
                    .elementAtOrNull(0)?.elementAtOrNull(2)
                    .toString().toDouble().roundTo(3).toString()
                    + "% that this is something important")
            text.clearFocus()
            key.clearFocus()
        }

    }

    private fun handleSomethingWentWrong() = this.activity?.displayToast("Something went wrong!")
}