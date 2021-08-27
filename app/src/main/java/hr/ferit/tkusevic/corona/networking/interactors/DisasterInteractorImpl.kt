package hr.ferit.tkusevic.corona.networking.interactors

import Input1
import Inputs
import RequestReq
import hr.ferit.tkusevic.corona.model.response.*
import hr.ferit.tkusevic.corona.networking.DisasterApiService
import retrofit2.Callback

class DisasterInteractorImpl(private val apiService: DisasterApiService?) : DisasterInteractor {

    override fun getResults(text: String, key: String, getSummaryReponse: Callback<ResponseRes>) {
        val body = RequestReq(Inputs(Input1(arrayOf("keyword", "text", "target"), arrayOf(arrayOf(text, key, "0")))))
        apiService?.getSummaryResponse(body)?.enqueue(getSummaryReponse)
    }

}