package com.dicoding.myfavmakanan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class About : AppCompatActivity() {

    private lateinit var imgAbout: ImageView
    private lateinit var nameAbout: TextView
    private lateinit var emailAbout: TextView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val dataAbout = resources.getStringArray(R.array.data_about)

        imgAbout = findViewById(R.id.profilePic)
        nameAbout = findViewById(R.id.namaDiri)
        emailAbout = findViewById(R.id.email)

        Glide.with(this).load(dataAbout[0]).circleCrop().into(imgAbout)
        nameAbout.text = dataAbout[1]
        emailAbout.text = dataAbout[2]


    }
}