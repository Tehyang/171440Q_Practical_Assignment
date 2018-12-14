package com.nyp.sit.dit.it1207.a171440q_movie_rater

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_landing_.*

class Landing_Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_)
        movieTitleList.clear()

        for (movieItems in movieArray)
        {
            movieTitleList.add(movieItems.reviewName)
        }
        val movieAdapt = ArrayAdapter(this, android.R.layout.simple_list_item_1, movieTitleList)
        landingList.adapter = movieAdapt
        registerForContextMenu(landingList)

        landingList.setOnItemClickListener{parent, view, position, id ->
            val entityObject = movieArray.get(position)
            instanceMovie = movieEntity(entityObject.reviewName, entityObject.reviewDesc, entityObject.reviewLang, entityObject.reviewRelDate, entityObject.reviewSuitAudience, entityObject.ratingBarForMovie, entityObject.ratingTextForMovie)
            val viewReview = Intent(applicationContext, movie_review::class.java)
            startActivity(viewReview)
        }
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (v?.id == R.id.landingList) {
            menu?.add(1, 1001, 1, "Edit")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == 1001) {
            var editReview = Intent(applicationContext, Edit_Movie::class.java)
            startActivity(editReview)
        }
        return super.onContextItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.add, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.landingAdd) {
            movieTitleList.clear()
            var addNewMovie = Intent(applicationContext, MainActivity::class.java)
            startActivity(addNewMovie)
        }
        return super.onOptionsItemSelected(item)
    }

//    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
//        super.onCreateContextMenu(menu, v, menuInfo)
//        if (v?.id == R.id.landingMsg) {
//            menu?.add(1, 1001, 1, "Add")
//        }
//    }
//
//    override fun onContextItemSelected(item: MenuItem?): Boolean {
//        if (item?.itemId == 1001) {
//            var addMovie = Intent(applicationContext, MainActivity::class.java)
//            startActivity(addMovie)
//        }
//        return super.onContextItemSelected(item)
//    }
//
}