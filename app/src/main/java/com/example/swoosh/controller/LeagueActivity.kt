package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.swoosh.utilities.EXTRA_LEAGUE
import com.example.swoosh.databinding.ActivityLeagueBinding

class LeagueActivity : BaseActivity() {

    private lateinit var binding: ActivityLeagueBinding

    private var selectedLeague = ""
    //private val mensLeagueBttn: Button = findViewById(R.id.mensLeagueBttn)
    //private val womensLeagueBttn: Button = findViewById(R.id.womensLeagueBttn)
    //private val coedLeagueBttn: Button = findViewById(R.id.coedLeagueBttn)

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
        if (selectedLeague != "") {
            val skillActivity = Intent(this, SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
            startActivity(skillActivity)
        } else {
            Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun onMensClicked() {
        binding.womensLeagueBttn.isChecked = false
        binding.coedLeagueBttn.isChecked = false

        selectedLeague = "mens"
    }

    private fun onWomensClicked() {
        binding.mensLeagueBttn.isChecked = false
        binding.coedLeagueBttn.isChecked = false

        selectedLeague = "womens"
    }

    private fun onCoedClicked() {
        binding.mensLeagueBttn.isChecked = false
        binding.womensLeagueBttn.isChecked = false

        selectedLeague = "co-ed"
    }
}