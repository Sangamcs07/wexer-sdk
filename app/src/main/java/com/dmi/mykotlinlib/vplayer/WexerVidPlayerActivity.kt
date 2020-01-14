package com.dmi.mykotlinlib.vplayer

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.dmi.mykotlinlib.R
import com.dmi.mykotlinlib.sdklogger.WexerSdkLogger
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util


class WexerVidPlayerActivity : AppCompatActivity() {

    private var playWhenReady = true
    private var currentWindow = 0
    private var playbackPosition: Long = 0

    private var url: String? = null
    private var player: SimpleExoPlayer? = null
    private var playerView: PlayerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wexer_vid_player)

        playerView = findViewById(R.id.video_view)

        url = intent.getStringExtra("url")

        WexerSdkLogger.print("play url is $url")
    }

    fun initializePlayer() {
        player = ExoPlayerFactory.newSimpleInstance(this)
        playerView?.setPlayer(player)

        //var uri = Uri.parse(getString(R.string.media_url_mp3))
        // var uri = Uri.parse(getString(R.string.media_url_mp4));
        var uri = Uri.parse(url);
        var mediaSource = buildMediaSource(uri)

        player?.setPlayWhenReady(playWhenReady)
        player?.seekTo(currentWindow, playbackPosition)
        player?.prepare(mediaSource, false, false)
    }

    fun buildMediaSource(uri: Uri): MediaSource {
        var dataSourceFactory = DefaultDataSourceFactory(this, "exoplayer-wexer")
        return ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(uri)
    }

    fun hideSystemUi() {
        playerView?.setSystemUiVisibility(
            View.SYSTEM_UI_FLAG_LOW_PROFILE
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        )
    }

    private fun releasePlayer() {
        if (player != null) {
            playWhenReady = player!!.playWhenReady
            playbackPosition = player!!.currentPosition
            currentWindow = player!!.currentWindowIndex
            player!!.release()
            player = null
        }
    }

    override fun onStart() {
        super.onStart()
        if (Util.SDK_INT >= 24) {
            initializePlayer();
        }
    }

    override fun onResume() {
        super.onResume()
        hideSystemUi();
        if ((Util.SDK_INT < 24 || player == null)) {
            initializePlayer()
        }
    }

    override fun onPause() {
        super.onPause()
        if (Util.SDK_INT < 24) {
            releasePlayer();
        }
    }

    override fun onStop() {
        super.onStop()
        if (Util.SDK_INT >= 24) {
            releasePlayer();
        }
    }
}