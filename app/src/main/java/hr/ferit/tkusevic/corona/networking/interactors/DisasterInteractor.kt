package hr.ferit.tkusevic.corona.networking.interactors

import hr.ferit.tkusevic.corona.model.response.*
import retrofit2.Callback

interface DisasterInteractor {

    fun getResults(text: String, key: String, getSummaryReponse: Callback<ResponseRes>)
}