package com.ebenezer.gana.mediatorlivedata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ebenezer.gana.mediatorlivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.currentScore.observe(this) { score ->
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