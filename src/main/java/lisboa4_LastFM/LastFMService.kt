package lisboa4_LastFM

import retrofit2.Response


interface LastFMService {
    fun getArtistBiography(artistName: String): ArtistBiography?
}

class LastFMServiceImpl(
    private val lastFMAPIToBiographyResolver: LastFMAPIToBiographyResolver,
    private val lastFMAPI: LastFMAPI
): LastFMService {

    override fun getArtistBiography(artistName: String): ArtistBiography? =
        try {
            val callResponse = getArtistFromLastFMAPI(artistName)
            lastFMAPIToBiographyResolver.getArtistBiography(callResponse)
        }catch (e: Exception){
            null
        }

    private fun getArtistFromLastFMAPI(artistName: String): Response<String> {
        return lastFMAPI.getArtistInfo(artistName).execute()
    }
}

