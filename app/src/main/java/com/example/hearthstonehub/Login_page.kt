package com.example.hearthstonehub

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login_page.*
import kotlinx.android.synthetic.main.activity_register_page.*

class Login_page : AppCompatActivity() {


    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val goSearch = findViewById<Button>(R.id.Signin)


        firebaseAuth = FirebaseAuth.getInstance()



        goSearch.setOnClickListener {
            val userName: String = UserName.text.toString().trim()
            val userPassword: String = PassWord.text.toString().trim()

            firebaseAuth
                .signInWithEmailAndPassword(userName, userPassword)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful){

                        val intent = Intent(this@Login_page, cards_main_types::class.java)
                        //intent.putExtra("address", title)
                        startActivity(intent)

                    }else {
                        val exception = task.exception
                        Toast.makeText(this, "Registeration Failed: $exception", Toast.LENGTH_SHORT).show()
                    }
                }

        }


    }
}
