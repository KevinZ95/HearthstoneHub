package com.example.hearthstonehub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val register = findViewById<Button>(R.id.NewUser)
        val signin = findViewById<Button>(R.id.ExistedUser)


        register.setOnClickListener {
            val intent = Intent(this, Register_page::class.java)
            startActivity(intent)
        }

        signin.setOnClickListener {
            val intent = Intent(this, Login_page::class.java)
            startActivity(intent)
        }


    }
}
