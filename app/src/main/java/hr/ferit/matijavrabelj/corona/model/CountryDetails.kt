package hr.ferit.matijavrabelj.corona.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CountryDetails(
    @Expose @SerializedName("Country") val country: String,
    @Expose @SerializedName("CountryCode") val countryCode: String,
    @Expose @SerializedName("Confirmed") val confirmed: Number,
    @Expose @SerializedName("Deaths") val deaths: Number,
    @Expose @SerializedName("Recovered") val recovered: Number,
    @Expose @SerializedName("Active") val active: Number,
    @Expose @SerializedName("Date") val date: String
)