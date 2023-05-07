package com.example.photo_gallery

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    // 0 1 2 3
    lateinit var image: ImageView
    var names = arrayOf("MS Dhoni", "Virat Kohli", "Rohit Sharma", "Suresh Raina")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val next = findViewById<ImageButton>(R.id.forward)
        val prev = findViewById<ImageButton>(R.id.backward)
        val text = findViewById<TextView>(R.id.name)

        prev.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            // convert stirng id into integer address associated with it
            val idcurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idcurrentImageInt)
            image.alpha=0f

            currentImage = (4+ currentImage-1)%4
            //calculation to go to the previous image.

            val idImageToShowString = "pic$currentImage"
            // convert stirng id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha=1f
            text.text = names[currentImage]

        }

        next.setOnClickListener {
            val idCurrentImageString = "pic$currentImage"
            // convert stirng id into integer address associated with it
            val idcurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            image = findViewById(idcurrentImageInt)
            image.alpha=0f

            currentImage = (4+ currentImage+1)%4
            //calculation to go to the next image.

            val idImageToShowString = "pic$currentImage"
            // convert stirng id into integer address associated with it
            val idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            image = findViewById(idImageToShowInt)
            image.alpha=1f
            text.text = names[currentImage]
        }
    }
}