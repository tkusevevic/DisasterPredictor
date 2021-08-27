package hr.ferit.tkusevic.corona.model.response

import com.google.gson.annotations.SerializedName

data class ResponseRes (
    @SerializedName("Results") val results : Results
)