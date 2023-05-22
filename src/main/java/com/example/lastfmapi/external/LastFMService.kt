package com.example.lastfmapi.external

import retrofit2.Response


interface LastFMService {
    fun getArtistBiography(artistName: String): ArtistBiography?
}

class LastFMServiceImpl(
    private val lastFMAPIToBiographyResolver: LastFMAPIToBiographyResolver,
    private val lastFMAPI: LastFMAPI
): LastFMService {

    override fun getArtistBiography(artistName: String): ArtistBiography? {
        val callResponse = getArtistFromLastFMAPI(artistName)
        return lastFMAPIToBiographyResolver.getArtistBiography(callResponse)
    }

    private fun getArtistFromLastFMAPI(artistName: String): Response<String> {
        return lastFMAPI.getArtistInfo(artistName).execute()
    }
}

