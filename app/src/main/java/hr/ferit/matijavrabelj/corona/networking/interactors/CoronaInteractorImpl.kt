package hr.ferit.matijavrabelj.corona.networking.interactors

import hr.ferit.matijavrabelj.corona.model.CountryDetails
import hr.ferit.matijavrabelj.corona.model.response.*
import hr.ferit.matijavrabelj.corona.networking.CoronaApiService
import retrofit2.Callback

class CoronaInteractorImpl(private val apiService: CoronaApiService) : CoronaInteractor {
    override fun getSummary(getSummaryReponse: Callback<GetSummaryResponse>) {
        apiService.getSummaryResponse().enqueue(getSummaryReponse)
    }

    override fun getItemsByCountry(slug: String, getCountryReponse: Callback<List<CountryDetails>>) {
        apiService.getCountryReponse(slug).enqueue(getCountryReponse)
    }

}