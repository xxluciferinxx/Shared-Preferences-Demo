package com.xxluciferinxx.preferences

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var s: SharedPreferConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        s = SharedPreferConfig(applicationContext)

        bnLogin.setOnClickListener {
            if (s.readPref()) s.writePref(false) else s.writePref(true)
            readPref()
        }

        readPref()
    }

    private fun readPref() {
        if (s.readPref()) {
            textView.text = resources.getString(R.string.logged_in)
            bnLogin.text = resources.getString(R.string.logout)
        } else {
            textView.text = resources.getString(R.string.logged_out)
            bnLogin.text = resources.getString(R.string.login)
        }
    }
}