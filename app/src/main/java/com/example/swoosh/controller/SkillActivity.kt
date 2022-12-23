package com.example.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.swoosh.databinding.ActivitySkillBinding
import com.example.swoosh.model.Player
import com.example.swoosh.utilities.EXTRA_PLAYER

class SkillActivity : BaseActivity() {

    private lateinit var binding: ActivitySkillBinding

    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkillBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        player = intent.getParcelableExtra(EXTRA_PLAYER)!!

        binding.skillFinishBttn.setOnClickListener { onSkillFinishClicked() }
        binding.ballerSkillBttn.setOnClickListener { onBallerClick() }
        binding.beginnerSkillBttn.setOnClickListener { onBeginnerClick() }
    }

    private fun onBallerClick() {
        binding.beginnerSkillBttn.isChecked = false
        player.skill = "baller"
    }

    private fun onBeginnerClick() {
        binding.ballerSkillBttn.isChecked = false
        player.skill = "beginner"
    }

    private fun onSkillFinishClicked() {
        if (player.skill != "") {
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(finishActivity)
        } else {
            Toast.makeText(this, "Please select a skill level.", Toast.LENGTH_SHORT).show()
        }
    }
}