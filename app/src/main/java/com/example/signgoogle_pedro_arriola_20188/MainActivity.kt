package com.example.signgoogle_pedro_arriola_20188

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getWindow().getDecorView().setBackgroundColor(Color.rgb(229,255,229));

        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser

        Handler().postDelayed({
              if (user != null){
                  val dashboardIntent = Intent(this, DashboardActivity::class.java)
                  startActivity(dashboardIntent)

              } else {
                  val signInIntent = Intent(this,SignInActivity::class.java)
                  startActivity(signInIntent)
              }

        }, 2000)
    }
}