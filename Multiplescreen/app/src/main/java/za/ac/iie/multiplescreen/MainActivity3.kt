package za.ac.iie.multiplescreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity3 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.Score_main5)

        val txtScore = findViewById<TextView>(R.id.txtScore)
        val txtFeedback2 = findViewById<TextView>(R.id.txtFeedback2)
        val btnReview = findViewById<Button>(R.id.btnReview)
        val btnExit = findViewById<Button>(R.id.btnExit)

        val score = intent.getIntExtra("finalScore", 0)
        txtScore.text = "You scored $score out of 5."

        txtFeedback2.text = if (score >= 3) "Great job!" else "Keep practicing"

        btnReview.setOnClickListener {
            val intent = Intent(this, ReviewActivity::class.java)
            startActivity() // Terminates the app
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    public fun startActivity() {
        TODO("Not yet implemented")
    }
}