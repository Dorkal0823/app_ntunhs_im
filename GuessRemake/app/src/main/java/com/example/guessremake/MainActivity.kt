package com.example.guessremake

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guessremake.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var handler: Handler

    private val gameModel = GameModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 使用 View Binding 初始化布局
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler = Handler(Looper.getMainLooper())

        setupButtons()
        scheduleToast()
    }

    private fun setupButtons() {
        binding.guessButton.setOnClickListener {
            val guess = binding.editText.text.toString().toIntOrNull()
            if (guess != null) {
                val feedback = gameModel.validateGuess(guess)
                binding.TextView.text = feedback
            }
        }

        binding.resetButton.setOnClickListener {
            gameModel.resetGame()
            binding.TextView.text = "再猜一次"
        }
    }

    private fun scheduleToast() {
        handler.postDelayed({
            Toast.makeText(this, "5秒後的操作執行了！", Toast.LENGTH_SHORT).show()
        }, 5000)
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }
}
