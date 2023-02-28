package com.example.androiddasarsatu

import android.app.Notification.Action
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView
    private lateinit var btnPindah : Button
    private lateinit var btnOpnCamera : Button

    companion object{
        private const val STATE_RESULT = "state_result"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtWidth = findViewById(R.id.edt_width)
        edtHeight = findViewById(R.id.edt_height)
        edtLength = findViewById(R.id.edit_length)
        btnCalculate = findViewById(R.id.btn_calculate)
        btnPindah = findViewById(R.id.pindah)
        btnOpnCamera = findViewById(R.id.opn_Camera)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)
        btnPindah.setOnClickListener(this)
        btnOpnCamera.setOnClickListener(this)

        if (savedInstanceState != null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvResult.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(p0: View?) {

        if (p0?.id == R.id.btn_calculate) {
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()

            var isEmptyField = false

            if (inputLength.isEmpty()){
                isEmptyField = true
                edtLength.error = "Field ini tidak boleh kosong"
            }

            if (inputWidth.isEmpty()){
                isEmptyField = true
                edtWidth.error = "Field ini tidak boleh kosong"
            }

            if (inputHeight.isEmpty()){
                isEmptyField = true
                edtHeight.error = "Field ini tidak boleh kosong"
            }

            if (!isEmptyField){
                val volume = inputLength.toDouble() * inputWidth.toDouble() * inputHeight.toDouble()
                tvResult.text = volume.toString()
            }
        }

        if (p0?.id == R.id.pindah){
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        if (p0?.id == R.id.opn_Camera){
            val phoneNumber = "089601036313"
            val dialPhoneNumber = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(dialPhoneNumber)
        }
    }
}