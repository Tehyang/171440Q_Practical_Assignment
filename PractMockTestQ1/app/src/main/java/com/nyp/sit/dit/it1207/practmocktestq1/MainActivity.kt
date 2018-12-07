package com.nyp.sit.dit.it1207.practmocktestq1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.nyp.sit.dit.it1207.practmocktestq1.entityInstance
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.miSave)
        {
            var genderChoice: String = ""
            if (radioMale.isChecked){
                genderChoice = "Male"
            }
            else if (radioFemale.isChecked){
                genderChoice = "Female"
            }
            
            entityInstance.nameEntered = etName.text.toString()
            entityInstance.phoneNoEntered = etPhoneNo.text.toString()
            entityInstance.radioEntered = genderChoice

            var callName: String = entityInstance.nameEntered
            var callPhoneNo: String = entityInstance.phoneNoEntered
            var callRadio: String = entityInstance.radioEntered

            Toast.makeText(this@MainActivity,
                ("Name: $callName" + "\nPhone: $callPhoneNo" + "\nGender: $callRadio"), Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
