package com.example.youtube_android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment

class MainActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var youtubeFragment: YouTubePlayerSupportFragment = supportFragmentManager
            .findFragmentById(R.id.youtube_fragment) as YouTubePlayerSupportFragment

      var mOnInitializedListener = youtubeFragment.initialize(youtubeApiKey().getAPIKEY(), object : YouTubePlayer.OnInitializedListener{
            override fun onInitializationSuccess(
                provider: YouTubePlayer.Provider?,
                player: YouTubePlayer?,
                wasRestored: Boolean
            ) {
                if(player == null) return
                if(wasRestored)
                    player.play()
                else{

                    ///if want to play single selected youtube video
                    player.cueVideo("d_m5csmrf7I")
                    player.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT)

                    ///if want to play youtube playList video
                    //player.loadPlaylist("PLYYvs1qfE3J52rjAItJWZacUS-G9zNImX")
                }
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                TODO("Not yet implemented")
            }

        })

    }
}

