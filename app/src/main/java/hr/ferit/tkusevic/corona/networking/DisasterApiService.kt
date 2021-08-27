package hr.ferit.tkusevic.corona.networking

import RequestReq
import hr.ferit.tkusevic.corona.model.response.ResponseRes
import retrofit2.Call
import retrofit2.http.*


interface DisasterApiService {

    @Headers(
        "Accept: application/json",
        "Authorization: Bearer 472ATlkLfWUee0yaTp9EwCg1t+Gh1xyAODMIV6i6/c/P2f7j4h2R6xPRqk8VwyOFTCjROCOdIYiKM1yk0HK2Pw==",
        "Content-Type: application/json"
    )
    @POST("/workspaces/504782373e424b018d37767150b89756/services/c4a171b1fc3841e5882522711c39ccbf/execute?api-version=2.0&details=true")
    fun getSummaryResponse(@Body body: RequestReq): Call<ResponseRes>

}