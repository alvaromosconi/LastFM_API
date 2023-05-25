package lisboa4LastFM

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

private const val URL_BASE_API = "https://ws.audioscrobbler.com/2.0/"

object LastFMInjector {

    fun getLastFmService(): LastFMService {
        val retrofit = createRetrofit()
        val lastFMAPI = createLastFMAPI(retrofit)
        val lastFMAPIToBiographyResolver = LastFMAPIToBiographyResolverImpl()
        return LastFMServiceImpl(lastFMAPIToBiographyResolver, lastFMAPI)
    }

    private fun createRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BASE_API)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    private fun createLastFMAPI(retrofit: Retrofit): LastFMAPI {
        return retrofit.create(LastFMAPI::class.java)
    }

}