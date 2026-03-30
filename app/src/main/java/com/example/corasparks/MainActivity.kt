package com.example.corasparks

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var editTextTime: EditText? = null
    private var btnSuggest: Button? = null
    private var btnReset: Button? = null
    private var textViewResult: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextTime = findViewById(R.id.editTextTime)
        btnSuggest = findViewById(R.id.btnSuggest)
        btnReset = findViewById(R.id.btnReset)
        textViewResult = findViewById(R.id.textViewResult)

        btnSuggest?.setOnClickListener {
            val input = editTextTime?.text.toString().trim().lowercase()

            if (input.isEmpty()) {
                Toast.makeText(this, "Please enter a time of day", Toast.LENGTH_SHORT).show()
            } else {
                textViewResult?.text = getSocialSparks(input)
            }
        }

        btnReset?.setOnClickListener {
            editTextTime?.text?.clear()
            textViewResult?.text = "Suggestions will appear here"
        }
    }

    private fun getSocialSparks(time: String): String {

        return if (time == "morning") {
            """
            Morning Sparks:
            • Send a good morning message
            • Share a motivational quote
            • Ask about someone's plans for the day
        """.trimIndent()

        } else if (time == "mid morning") {
            """
            Mid-Morning Sparks:
            • Check in with a friend
            • Share a quick update
            • Compliment someone
        """.trimIndent()

        } else if (time == "afternoon") {
            """
            Afternoon Sparks:
            • Ask how the day is going
            • Suggest a quick catch-up
            • Share something interesting
        """.trimIndent()

        } else if (time == "afternoon snack" || time == "snack time") {
            """
            Snack Time Sparks:
            • Ask what others are snacking on
            • Share a fun poll or question
            • Invite someone for coffee
        """.trimIndent()

        } else if (time == "dinner" || time == "dinner time") {
            """
            Dinner Sparks:
            • Ask about dinner plans
            • Share a meal photo
            • Invite someone to join you
        """.trimIndent()

        } else if (time == "after dinner" || time == "evening") {
            """
            Evening Sparks:
            • Reflect on the day
            • Share a story or joke
            • Ask about tomorrow’s plans
        """.trimIndent()

        } else {
            """
            Unknown time of day.
            Try: morning, mid morning, afternoon, snack time, dinner, evening
        """.trimIndent()
        }
    }
}
/*
====================================================================================================
REFERENCE
IMAD 5111_Module manuel Unit 4 page 61
https://play.google.com/store/apps/details?id=com.yoobic.pilitflyingj&hl=en_ZA - Task Pilot (App Name)
CodeWithCal (n.d.) Android App Tutorial (Kotlin)
https://youtu.be/r1P7slDbtd4
Accessed: 27 March 2026

Note: Code written independently. Video used for conceptual guidance only.

====================================================================================================
 */