package com.nyp.sit.dit.it1207.a171440q_movie_rater

open class movieEntity(reviewName: String, reviewDesc: String, reviewLang: String, reviewRelDate: String, reviewSuitAudience: String, ratingBarForMovie: Float, ratingTextForMovie: String) {
    var reviewName: String = ""
    var reviewDesc: String = ""
    var reviewLang: String = ""
    var reviewRelDate: String = ""
    var reviewSuitAudience: String = ""
    var ratingBarForMovie: Float = -1F
    var ratingTextForMovie: String = ""

    init {
        this.reviewName = reviewName
        this.reviewDesc = reviewDesc
        this.reviewLang = reviewLang
        this.reviewRelDate = reviewRelDate
        this.reviewSuitAudience = reviewSuitAudience
        this.ratingBarForMovie = ratingBarForMovie
        this.ratingTextForMovie = ratingTextForMovie
    }
}

var movieArray = mutableListOf<movieEntity>()
var instanceMovie = movieEntity("", "", "", "", "", -1F, "" )
var movieTitleList = mutableListOf<String>()
