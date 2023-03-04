package com.example.androiddasarsatu

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveWithObjectActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_PERSON = "extra_person"
    }

    lateinit var tvObject: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_object)

        tvObject = findViewById(R.id.tv_Object_Received)
        val person = if (Build.VERSION.SDK_INT >=33){
            intent.getParcelableExtra(EXTRA_PERSON, Person::class.java)
        }else{
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_PERSON)
        }

        if (person != null){
            val text = "Name: ${person.name.toString()}, \n" +
                    "Email: ${person.email.toString()}, \n" +
                    "Age: ${person.age.toString()} \n" +
                    "Location : ${person.city.toString()}"
            tvObject.text = text
        }
    }
}