package com.nyp.sit.dit.it1207.a171440q_movie_rater

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import com.nyp.sit.dit.it1207.a171440q_movie_rater.movieEntity
import android.content.Intent
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkbox1.setOnClickListener(View.OnClickListener {
            if(checkbox1.isChecked == true) {
                radioGroup2.visibility = View.VISIBLE
            } else {
                radioGroup2.visibility = View.INVISIBLE
            }
        })

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.miAdd)
        {
            var inputName: String = etName.text.toString()
            var inputDate: String = etDate.text.toString()
            var inputDespt: String = etDescription.text.toString()
            var langChoice  = radioGroup1.checkedRadioButtonId

            var inputLanguageRadio = ""
            var inputSuitable = ""
            var inputReason1 = ""
            var inputReason2 = ""

            // inputLanguageRadio Check
            if (rbtnButton1.isChecked){
                inputLanguageRadio = "English"
            }
            else if (rbtnButton2.isChecked){
                inputLanguageRadio = "Chinese"
            }
            else if (rbtnButton3.isChecked){
                inputLanguageRadio = "Malay"
            }
            else if (rbtnButton4.isChecked){
                inputLanguageRadio = "Tamil"
            }

            // Check suitability for audience
            if (checkbox1.isChecked){
                inputSuitable = "No"
            }
            else {
                inputSuitable = "Yes"
            }

            // Reasons for not being suitable for audience
            if (checkbox2.isChecked) {
                inputReason1 = "Violence"
            }
            if (checkbox3.isChecked) {
                inputReason2 = "Language"
            }
            if (checkbox2.isChecked && checkbox3.isChecked) {
                inputReason1 = "Violence, "
                inputReason2 = "Language"
            }

            var isValid: Boolean = true
            var violenceChecked = checkbox2.isChecked
            var languageChecked = checkbox3.isChecked

            // Validation and Create Toast
            if (inputName.isBlank()) {
                etName.setError("Field empty")
                isValid = false
            }
            if (inputDespt.isBlank()) {
                etDescription.setError("Field empty")
                isValid = false
            }
            if (inputDate.isBlank()) {
                etDate.setError("Field empty")
                isValid = false
            }
            if (langChoice == -1 )
            {
                rbtnValidate.setError("Please choose language")
                isValid = false
            } else {
                rbtnValidate.setError(null)
            }
            if (violenceChecked == false && languageChecked == false) {
                suitValidate.setError("Please choose reason")
                isValid = false
            } else {
                suitValidate.setError(null)
            }

            instanceMovie.reviewName = inputName
            instanceMovie.reviewDesc = inputDespt
            instanceMovie.reviewRelDate = inputDate
            instanceMovie.reviewLang = inputLanguageRadio
            instanceMovie.reviewSuitAudience = "$inputSuitable($inputReason1$inputReason2)"

            if (isValid == true) {
                var addedMovie = Intent(applicationContext, movie_review::class.java)
                startActivity(addedMovie)
            }
        }

        if (item?.itemId == R.id.miClear) {
            etName.setText("")
            etDescription.setText("")
            radioGroup1.clearCheck()
            etDate.setText("")
            checkbox1.isChecked = false
            checkbox2.isChecked = false
            checkbox3.isChecked = false
        }
        return super.onOptionsItemSelected(item)
    }
}
