package lisboa4LastFM

data class ArtistBiography(
    var artistInfo: String,
    var url: String,
    var isLocallyStored: Boolean
){

    companion object {
        const val URL_LAST_FM_IMAGE = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Lastfm_logo.svg/320px-Lastfm_logo.svg.png"
    }

}
