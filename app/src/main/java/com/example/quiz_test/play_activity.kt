package com.example.quiz_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quiz_test.databinding.ActivityMainBinding
import com.example.quiz_test.databinding.ActivityPlayBinding

class play_activity : AppCompatActivity() {
    lateinit var binding: ActivityPlayBinding

    val quizlist= listOf<Quiz>(

        Quiz("What is the big city in Bangladesh?",
            "Dinajpur",
            "Dhaka",
            "Rajshahi",
            "Hobiganj",
            "Dhaka"

        ),
        Quiz(
            "What is our national fruit?",
            "Banana",
            "Orange",
            "Apple",
            "JackFruit",
            "JackFruit"
        ),
        Quiz(
            "Victory day of Bangladesh?",
            "16th December",
            "21st February",
            "26th March",
            "15th August",
            "16th December"
        ),
        Quiz(
            "International mother language day?",
            "16th December",
            "21st February",
            "26th March",
            "15th August",
            "21st February"


               ),
        Quiz(
            "Independence day of Bangladesh ?",
            "16th December",
            "21st February",
            "26th March",
            "15th August",
            "26th March"


        ),
    )

    val index=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPlayBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initQuestion()
    }

    private fun initQuestion() {
       val quizQuestion=quizlist[index]
      binding.questonTv.text=quizQuestion.question

        //binding.apply{} >> if you can use it //

        binding.option1.text=quizQuestion.option1
        binding.option2.text=quizQuestion.option2
        binding.option3.text=quizQuestion.option3
        binding.option4.text=quizQuestion.option4
        binding.option3.text=quizQuestion.option3

    }
}