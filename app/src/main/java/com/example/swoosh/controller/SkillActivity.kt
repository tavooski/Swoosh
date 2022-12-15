package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.swoosh.utilities.EXTRA_LEAGUE
import com.example.swoosh.utilities.EXTRA_SKILL
import com.example.swoosh.databinding.ActivitySkillBinding

class SkillActivity : BaseActivity() {

    private lateinit var binding: ActivitySkillBinding

    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkillBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        league = intent.getStringExtra(EXTRA_LEAGUE).toString()

        binding.skillFinishBttn.setOnClickListener { onSkillFinishClicked() }
        binding.ballerSkillBttn.setOnClickListener { onBallerClick() }
        binding.beginnerSkillBttn.setOnClickListener { onBeginnerClick() }
    }

    private fun onBallerClick() {
        binding.beginnerSkillBttn.isChecked = false
        skill = "baller"
    }

    private fun onBeginnerClick() {
        binding.ballerSkillBttn.isChecked = false
        skill = "beginner"
    }

    private fun onSkillFinishClicked() {
        if (skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, skill)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level.", Toast.LENGTH_SHORT).show()
        }
    }
}