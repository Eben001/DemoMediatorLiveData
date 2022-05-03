package com.ebenezer.gana.mediatorlivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ebenezer.gana.mediatorlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding

    private val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.currentScore.observe(this){score ->
            binding.previousPlayerScoreLabel.text = getString(
                R.string.previous_player_score, score
            )
        }

        binding.submitFirstPlayerScore.setOnClickListener {
            viewModel.setFirstPlayerScore(
                binding.firstPlayerScore.text.toString().toFloat()
            )
        }

        binding.secondPlayerScore.setOnClickListener {
            viewModel.setSecondPlayerScore(
                binding.secondPlayerScore.text.toString().toFloat()
            )
        }


    }
}