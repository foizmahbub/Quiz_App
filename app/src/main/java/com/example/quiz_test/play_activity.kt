package com.example.quiz_test

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
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

    )
    var updateQuestion= 1

    var index=0
    var hashFinished=false

    var skip=-1
    var correct=0
    var wrong=0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityPlayBinding.inflate(layoutInflater)

        setContentView(binding.root)
        initQuestion()
        binding.next.setOnClickListener {
            nextQuiz()
        }
    }

    private fun initQuestion() {
       val quizQuestion=quizlist[index]
      binding.questonTv.text=quizQuestion.question

        binding.apply{

        option1.text=quizQuestion.option1
        option2.text=quizQuestion.option2
        option3.text=quizQuestion.option3
        option4.text=quizQuestion.option4
        }

    }
    private fun nextQuiz(){
        checkAnswer()
        binding.apply {
            if (updateQuestion<quizlist.size){
                updateQuestion++
                initQuestion()
            }
            else if (index<=quizlist.size-1){
                index++
            }
            else{
                hashFinished=true

            }
            radioGroup.clearCheck()
      }
    }


    @SuppressLint("SuspiciousIndentation")
    private fun checkAnswer() {
        binding.apply {

            if (radioGroup.checkedRadioButtonId == -1) {
                skip++
            } else {
                val checkButton = findViewById<RadioButton>(radioGroup.checkedRadioButtonId)
                val checkAnswer=checkButton.text.toString()
                if (checkAnswer==quizlist[index].answer){
                    correct++
                  showAlertDialog  ("Correct Answer")
                }
                else{
                    wrong++
                    showAlertDialog("Wrong Answer")
            }


            }
            if (index<=quizlist.size-1)
            index++
    else{
   showAlertDialog("Finished")
            }
    }

   }

    fun showAlertDialog(message: String){
        val builder=AlertDialog.Builder(this)
        builder.setTitle(message)
        builder.setPositiveButton("ok",object :DialogInterface.OnClickListener{

            override fun onClick(dialog: DialogInterface?, which: Int) {
                if (message=="Finished"){
                   intent= Intent(this@play_activity,result_view::class.java)
                    intent.putExtra("skip",skip)
                    intent.putExtra("correct",correct)
                    intent.putExtra("wrong",wrong
                    )
                    startActivity(intent)
                }

            }

        })
        val alertDialog=builder.create()
        alertDialog.show()
    }

}