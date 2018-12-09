package com.nyp.sit.dit.it1207.a171440q_movie_rater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.nyp.sit.dit.it1207.a171440q_movie_rater.R.id.ratingBar
import kotlinx.android.synthetic.main.activity_movie_rater.*

class movie_rater : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rater)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.rater, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.miSubmit)
        {
            var ratingStars = ratingBar.rating
            var ratingText = etReview.text.toString()

            instanceMovie.ratingBarForMovie = ratingStars
            instanceMovie.ratingTextForMovie = ratingText

            var addedRating = Intent(applicationContext, movie_review::class.java)
            startActivity(addedRating)
        }
        return super.onOptionsItemSelected(item)
    }
}
