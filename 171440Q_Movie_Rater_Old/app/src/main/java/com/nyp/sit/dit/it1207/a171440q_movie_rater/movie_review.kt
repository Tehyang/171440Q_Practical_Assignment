package com.nyp.sit.dit.it1207.a171440q_movie_rater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_movie_review.*

class movie_review : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_review)

        reviewTitle.text = instanceMovie.reviewName
        reviewOverview.text = instanceMovie.reviewDesc
        reviewLanguage.text = instanceMovie.reviewLang
        reviewRelDate.text = instanceMovie.reviewRelDate
        reviewSuitable.text = instanceMovie.reviewSuitAudience
    }
}
