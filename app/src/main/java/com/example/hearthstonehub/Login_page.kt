package com.example.hearthstonehub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Login_page : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val goSearch = findViewById<Button>(R.id.Signin)

        goSearch.setOnClickListener {
            val intent = Intent(this@Login_page, cards_main_types::class.java)
            //intent.putExtra("address", title)
            startActivity(intent)
        }


    }
}
