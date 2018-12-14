package com.nyp.sit.dit.it1207.a171440q_movie_rater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_edit__movie.*

class Edit_Movie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit__movie)

        etName.setText(instanceMovie.reviewName)
        etDescription.setText(instanceMovie.reviewDesc)
        etDate.setText(instanceMovie.reviewRelDate)

        if (instanceMovie.reviewLang == "English")
        {
            rbtnButton1.isChecked = true
        }
        if (instanceMovie.reviewLang == "Chinese")
        {
            rbtnButton2.isChecked = true
        }
        if (instanceMovie.reviewLang == "Malay")
        {
            rbtnButton3.isChecked = true
        }
        if (instanceMovie.reviewLang == "Tamil")
        {
            rbtnButton4.isChecked = true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }
}
