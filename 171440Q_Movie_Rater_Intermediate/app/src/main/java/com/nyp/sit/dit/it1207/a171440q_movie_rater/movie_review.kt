package com.nyp.sit.dit.it1207.a171440q_movie_rater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
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

        registerForContextMenu(reviewMsg)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.reviewMsg) {
            menu?.add(1, 1001, 1, "Add Review")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1001) {
            var addReview = Intent(applicationContext, movie_rater::class.java)
            startActivity(addReview)
        }
        return super.onContextItemSelected(item)
    }
}
