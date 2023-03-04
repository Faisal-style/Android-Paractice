package com.example.androiddasarsatu

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnKembali: Button
    private lateinit var btnMoveActivity: Button
    private lateinit var btnWithMoveData: Button
    private lateinit var btnActivityObject: Button
    private lateinit var btnDialNumber: Button
    private lateinit var btnMoveForResult: Button
    private lateinit var tvResult: TextView

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        result -> if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null){
            val selectedValue = result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE,0)
        tvResult.text = "Hasil : $selectedValue"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnKembali = findViewById(R.id.Kembali)
        btnMoveActivity = findViewById(R.id.btn_move2)
        btnWithMoveData = findViewById(R.id.btn_move_data)
        btnActivityObject = findViewById(R.id.btn_move_activity_object)
        btnDialNumber = findViewById(R.id.btn_dial_number)
        btnMoveForResult = findViewById(R.id.btn_move_for_result)
        tvResult = findViewById(R.id.tv_result_activity)


        btnKembali.setOnClickListener(this)
        btnMoveActivity.setOnClickListener(this)
        btnWithMoveData.setOnClickListener(this)
        btnActivityObject.setOnClickListener(this)
        btnDialNumber.setOnClickListener(this)
        btnMoveForResult.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.Kembali -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_move2 -> {
                val intent = Intent(this, MoveActivity::class.java)
                startActivity(intent)
            }
            R.id.btn_move_data -> {
                val moveDataIntent = Intent(this@SecondActivity, MoveWithDataActivity::class.java)
                moveDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Faisal Reza Rahmat")
                moveDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 22)
                startActivity(moveDataIntent)
            }
            R.id.btn_move_activity_object -> {
                val person = Person(
                    "Faisal Reza Rahmat",
                    5,
                    "faisalrezarahmat1@gmail.com",
                    "Jawa Tengah"
                )

                val moveWithObjectIntent = Intent(this@SecondActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person)
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_dial_number ->{
                val phoneNumber = "089601036313"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_for_result ->{
                val intent = Intent(this, MoveForResultActivity::class.java)
                resultLauncher.launch(intent)
            }
        }
    }
}