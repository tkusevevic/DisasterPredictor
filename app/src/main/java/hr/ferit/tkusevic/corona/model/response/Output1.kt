package hr.ferit.tkusevic.corona.model.response

import com.google.gson.annotations.SerializedName

data class Output1 (

    @SerializedName("type") val type : String,
    @SerializedName("value") val value : Value
)