package com.toporead.readtest

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView


class ReadFragment : Fragment() {


    private var isDisplay =true
    private val videoPath = "/storage/emulated/0/Movies/LTX.mp4"


    private lateinit var exoplayer1: ExoPlayer
    private lateinit var playerView1: PlayerView
    private lateinit var exoplayer2: ExoPlayer
    private lateinit var playerView2: PlayerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_read, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btn: Button =view.findViewById(R.id.close_btn)
        val play_pauseBTN : Button =view.findViewById(R.id.play_pause)

        playerView1 =view.findViewById(R.id.playerview_1)
        exoplayer1 =ExoPlayer.Builder(requireContext()).build()
        playerView1.player =exoplayer1

        playerView2 =view.findViewById(R.id.playerview_2)
        exoplayer2 =ExoPlayer.Builder(requireContext()).build()
        playerView2.player =exoplayer2

        val mediaItem1 = MediaItem.fromUri(Uri.parse(videoPath))

        exoplayer1.setMediaItem(mediaItem1)
        exoplayer1.prepare()
        exoplayer1.playWhenReady
        exoplayer2.setMediaItem(mediaItem1)
        exoplayer2.prepare()
        exoplayer2.playWhenReady

        btn.setOnClickListener {
            if (isDisplay){
                playerView2.visibility=View.GONE
                isDisplay =false
            }else{
                playerView2.visibility =View.VISIBLE
                isDisplay =true
            }
        }

        play_pauseBTN.setOnClickListener {

            if (exoplayer1.isPlaying){
                exoplayer1.pause()
            }
            else{
                exoplayer1.play()
            }
            if (exoplayer2.isPlaying){
                exoplayer2.pause()
            }
            else{
                exoplayer2.play()
            }
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        exoplayer1.release()
        exoplayer2.release()
    }

}