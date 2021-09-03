package com.tech.spftest1_sep

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.et_password
import kotlinx.android.synthetic.main.activity_main.et_username


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var spf = getSharedPreferences("spf_sept3", Context.MODE_PRIVATE)

        //will read the data from spf
        btn_signin.setOnClickListener {


            var username = et_username.text.toString()
            var password = et_password.text.toString()

            var un = spf.getString("uname", "admin")
            var ps = spf.getString("pass", "admin")

            Log.d("USER",un.toString())
            Log.d("PASS",ps.toString())

            if(un.equals(username)&&ps.equals(password))
            {
                var intent = Intent(this, WelcomeActivity::class.java)
                intent.putExtra("user",username)
                startActivity(intent)

            }else
            {
                Toast.makeText(this,"invalid username or password",Toast.LENGTH_SHORT).show()
            }

        }

        text_register.setOnClickListener {
            startActivity(Intent(this,RegisterActivity::class.java))
        }
    }
}