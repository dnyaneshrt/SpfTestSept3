package com.tech.spftest1_sep

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        //1.get the Sharedprefernces Object using getShareprefernces() method
     var spf= getSharedPreferences("spf_sept3", Context.MODE_PRIVATE)

        /*
        Context.MODE_PRIVATE
        Context.MODE_WORLD_READABLE
         */

        //2.to register the data into spf
        var spf_edit:SharedPreferences.Editor=spf.edit()


        //will store username and password into spf
        btn_register.setOnClickListener {

            var username=et_username.text.toString()
            var password=et_password.text.toString()

            spf_edit.putString("uname",username)
            spf_edit.putString("pass",password)

            if(spf_edit.commit())
            {

                Toast.makeText(this,"data registered suceesfully ",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
            }else
            {
                Toast.makeText(this,"failed to register data",Toast.LENGTH_SHORT).show()
            }

        }
    }
}