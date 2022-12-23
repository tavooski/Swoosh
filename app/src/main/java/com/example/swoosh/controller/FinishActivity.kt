package com.example.swoosh.controller

import android.os.Bundle
import com.example.swoosh.databinding.ActivityFinishBinding
import com.example.swoosh.model.Player
import com.example.swoosh.utilities.EXTRA_PLAYER

class FinishActivity : BaseActivity() {

    private lateinit var binding: ActivityFinishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)

        binding.searchLeaguesText.text = "Looking for ${player?.league} ${player?.skill} league near you..."
    }
}