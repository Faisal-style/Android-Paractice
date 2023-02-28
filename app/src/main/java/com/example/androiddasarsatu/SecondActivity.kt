package com.example.androiddasarsatu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnKembali: Button
    private lateinit var btnMoveActivity: Button
    private lateinit var btnWithMoveData: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btnKembali = findViewById(R.id.Kembali)
        btnMoveActivity = findViewById(R.id.btn_move2)
        btnWithMoveData = findViewById(R.id.btn_move_data)


        btnKembali.setOnClickListener(this)
        btnMoveActivity.setOnClickListener(this)
        btnWithMoveData.setOnClickListener(this)

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
        }
    }
}