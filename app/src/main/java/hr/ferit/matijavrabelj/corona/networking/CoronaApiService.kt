package hr.ferit.matijavrabelj.corona.networking

import hr.ferit.matijavrabelj.corona.model.CountryDetails
import hr.ferit.matijavrabelj.corona.model.response.GetSummaryResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface CoronaApiService {

    @GET("/summary")
    fun getSummaryResponse(): Call<GetSummaryResponse>

    @GET("/country/{slug}")
    fun getCountryReponse(@Path("slug") slug: String): Call<List<CountryDetails>>

}