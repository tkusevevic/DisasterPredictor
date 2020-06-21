package hr.ferit.matijavrabelj.corona.networking

import hr.ferit.matijavrabelj.corona.common.BASE_URL
import hr.ferit.matijavrabelj.corona.networking.interactors.CoronaInteractor
import hr.ferit.matijavrabelj.corona.networking.interactors.CoronaInteractorImpl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object BackendFactory {

    private var retrofit: Retrofit? = null
    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    private val httpClient =
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

    private val client: Retrofit? = if (retrofit == null) createRetrofit() else retrofit

    private fun createRetrofit(): Retrofit? {
        retrofit = Retrofit.Builder()
            .client(httpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }

    private fun getService(): CoronaApiService = this.client!!.create(CoronaApiService::class.java)

    fun getBeersInteractor(): CoronaInteractor = CoronaInteractorImpl(getService())
}
