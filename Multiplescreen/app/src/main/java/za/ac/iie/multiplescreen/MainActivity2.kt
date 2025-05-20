package za.ac.iie.multiplescreen

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.HapticFeedbackConstantsCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat





class MainActivity2 : AppCompatActivity() {
    public val question = arrayOf(
        "NelsonMandela was the president in 19193.",
        "World War II ended in 1945.",
        "The Great Wall of China was built in a single year.",
        "The Roman Empire fell in 476 AD.",
        "The moon landing occured in 1969."
    )
    public val answers = booleanArrayOf(false, true, false, true, true)
    public var currentQuestionIndex = 0
    public var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.Quiz_main2)

        val btnTrue = findViewById<Button>(R.id.btnTrue)
        val btnFalse = findViewById<Button>(R.id.btnFalse)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val txtQuestion = findViewById<TextView>(R.id.txtQuestion)
        val txtFeedback = findViewById<TextView>(R.id.txtFeedback)

        txtQuestion.text = question[currentQuestionIndex]

        btnTrue.setOnClickListener { check(true, { txtFeedback }) }
        btnFalse.setOnClickListener { check(false, { txtFeedback }) }
        btnNext.setOnClickListener {
            question
        }
        val Public = Unit
        Public fun check(userAnswer: Boolean, feedbackTextView: TextView) {
            if (userAnswer == answers[currentQuestionIndex]) {
                score++
                feedbackTextView.text = "Correct!"
            } else {
                feedbackTextView.text = "Incorrect."

            }

        }

        fun nextQuestion(questionTextView: TextView) {
            currentQuestionIndex++
            if (currentQuestionIndex < question.size) {
                questionTextView.text = question[currentQuestionIndex]
            }else{
                val intent = Intent(this, Score_main5::class.java)
                intent.putExtras("finalScore", score)
                startActivity(intent)


            }



        }

    }
}