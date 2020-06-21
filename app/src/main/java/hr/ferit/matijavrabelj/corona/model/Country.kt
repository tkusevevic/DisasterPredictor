package hr.ferit.matijavrabelj.corona.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("Country") val country: String,
    @SerializedName("CountryCode") val countryCode: String,
    @SerializedName("Slug") val slug: String,
    @SerializedName("NewConfirmed") val newConfirmed: Number,
    @SerializedName("TotalConfirmed") val totalConfirmed: Number,
    @SerializedName("NewDeaths") val newDeaths: Number,
    @SerializedName("TotalDeaths") val totalDeaths: Number,
    @SerializedName("NewRecovered") val newRecovered: Number,
    @SerializedName("TotalRecovered") val totalRecovered: Number,
    @SerializedName("Date") val date: String
)