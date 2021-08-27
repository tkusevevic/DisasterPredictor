package hr.ferit.tkusevic.corona.model.response

import com.google.gson.annotations.SerializedName

data class Value (
    @SerializedName("ColumnNames") val columnNames : List<String>,
    @SerializedName("ColumnTypes") val columnTypes : List<String>,
    @SerializedName("Values") val values : List<List<Any>>
)