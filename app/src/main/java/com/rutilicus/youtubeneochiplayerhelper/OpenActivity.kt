package com.rutilicus.youtubeneochiplayerhelper

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.net.URLEncoder

class OpenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        when (intent?.action) {
            Intent.ACTION_SEND -> {
                if (intent.type == "text/plain") {
                    intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
                        val uri = Uri.parse(
                            "https://rutilicus.github.io/youtube-neochi-player/?url="
                            + URLEncoder.encode(it, "UTF-8")
                        )
                        startActivity(Intent(Intent.ACTION_VIEW, uri))
                    }
                }
            }
        }

        this.finish()
    }
}
