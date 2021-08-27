import com.google.gson.annotations.SerializedName

data class Input1(
    @SerializedName("ColumnNames") val columnNames: Array<String>,
    @SerializedName("Values") val values: Array<Any>
)