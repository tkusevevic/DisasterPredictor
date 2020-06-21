package hr.ferit.matijavrabelj.corona.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Global(
    @Expose @SerializedName("NewConfirmed") val newConfirmed: Number = 0,
    @Expose @SerializedName("TotalConfirmed") val totalConfirmed: Number = 0,
    @Expose @SerializedName("NewDeaths") val newDeaths: Number = 0,
    @Expose @SerializedName("NewRecovered") val newRecovered: Number = 0,
    @Expose @SerializedName("TotalRecovered") val totalRecovered: Number = 0
)