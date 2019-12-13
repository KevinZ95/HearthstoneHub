package com.example.hearthstonehub

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_register_page.*

class Register_page : AppCompatActivity() {
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)


        firebaseAuth = FirebaseAuth.getInstance()
        val signUp = findViewById<Button>(R.id.ComfirmReg)





        signUp.setOnClickListener {
            val newUserName: String = user_name.text.toString().trim()
            val newUserPassword: String = user_password.text.toString().trim()

            firebaseAuth
                .createUserWithEmailAndPassword(newUserName, newUserPassword)
                .addOnCompleteListener{ task ->
                    if (task.isSuccessful){
                        val currentUser: FirebaseUser? = firebaseAuth.currentUser
                        val email = currentUser?.email
                        Toast.makeText(this, "Registeration Successful as $email", Toast.LENGTH_SHORT).show()
                    }else {
                        val exception = task.exception
                        Toast.makeText(this, "Registeration Failed: $exception", Toast.LENGTH_SHORT).show()
                    }
                }

        }


    }
}
