package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.swoosh.databinding.ActivityLeagueBinding
import com.example.swoosh.model.Player
import com.example.swoosh.utilities.EXTRA_PLAYER

class LeagueActivity : BaseActivity() {

    private lateinit var binding: ActivityLeagueBinding

    private var player = Player("","")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeagueBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.leagueNextBtn.setOnClickListener { leagueNextClicked() }
        binding.mensLeagueBttn.setOnClickListener { onMensClicked() }
        binding.womensLeagueBttn.setOnClickListener { onWomensClicked() }
        binding.coedLeagueBttn.setOnClickListener { onCoedClicked() }
    }

    private fun leagueNextClicked() {
        if (player.league != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onMensClicked() {
        binding.womensLeagueBttn.isChecked = false
        binding.coedLeagueBttn.isChecked = false

        player.league = "mens"
    }

    private fun onWomensClicked() {
        binding.mensLeagueBttn.isChecked = false
        binding.coedLeagueBttn.isChecked = false

        player.league = "womens"
    }

    private fun onCoedClicked() {
        binding.mensLeagueBttn.isChecked = false
        binding.womensLeagueBttn.isChecked = false

        player.league = "co-ed"
    }
}