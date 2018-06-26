package com.harvey.coustomviewsample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.harvey.coustomviewsample.image.ImageLoader
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val imageUrl = "http://avatarcn-api-user.oss-cn-hangzhou.aliyuncs.com/head-portrait/84839b1b-b328-4c31-a715-af4904915ffe.jpg"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ImageLoader.displayCircleImage(this, imageUrl, mineAvatar)
    }
}
