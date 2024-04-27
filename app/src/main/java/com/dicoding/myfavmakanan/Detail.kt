package com.dicoding.myfavmakanan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class Detail : AppCompatActivity() {

    private lateinit var imgPhoto: ImageView
    private lateinit var tvDescription: TextView
    private lateinit var tvFoodName: TextView
    private lateinit var tvDescription2: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        imgPhoto = findViewById(R.id.imageView2)
        tvDescription = findViewById(R.id.isiDeskprisi)
        tvFoodName = findViewById(R.id.namaFood)
        tvDescription2 = findViewById(R.id.more_detail)

        val data = intent.getParcelableExtra<Food>("DATA")
        val dataMore = resources.getStringArray(R.array.kesukan_desc)

        Glide.with(this).load(data?.photo).into(imgPhoto)
        tvFoodName.text = data?.name
        tvDescription.text = data?.description
        tvDescription2.text = dataMore[0]
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.share_menu, menu)
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                val shareIntent = Intent()
                shareIntent.action = Intent.ACTION_SEND
                shareIntent.putExtra(Intent.EXTRA_TEXT, "Kiriman Data dari Hapis")
                shareIntent.type = "text/plain"

                startActivity(Intent.createChooser(shareIntent, "send to"))
            }
            R.id.action_about -> {
                val moveAbout = Intent(this@Detail, About::class.java)
                startActivity(moveAbout)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}