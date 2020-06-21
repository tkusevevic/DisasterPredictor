package hr.ferit.matijavrabelj.corona.networking.interactors

import hr.ferit.matijavrabelj.corona.model.CountryDetails
import hr.ferit.matijavrabelj.corona.model.response.*
import retrofit2.Callback

interface CoronaInteractor {

    fun getSummary(getSummaryReponse: Callback<GetSummaryResponse>)

    fun getItemsByCountry(slug: String, getCountryReponse: Callback<List<CountryDetails>>)
}