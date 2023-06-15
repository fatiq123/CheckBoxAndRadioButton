package com.example.checkboxandradiobutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var questionView: TextView
    lateinit var radioGroup: RadioGroup
    lateinit var cheese: CheckBox
    lateinit var onion: CheckBox
    lateinit var salad: CheckBox
    private lateinit var orderButton: Button
    lateinit var answerView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        questionView = findViewById(R.id.tvQuestion)
        radioGroup = findViewById(R.id.rgMeat)
        cheese = findViewById(R.id.cbCheese)
        onion = findViewById(R.id.cbOnions)
        salad = findViewById(R.id.cbSalad)
        orderButton = findViewById(R.id.btnOrder)
        answerView = findViewById(R.id.tvOrder)



        orderButton.setOnClickListener {
            val checkedMeatRadioButtonId = radioGroup.checkedRadioButtonId      // it is to check whether the current radio button is checked or not checkedRadioButtonId is already in system
            val meat = findViewById<RadioButton>(checkedMeatRadioButtonId)      // we check radioButtonId from radioGroup of current context
            val cheese = cheese.isChecked
            val onion = onion.isChecked
            val salad = salad.isChecked
            val orderString = "You Ordered a ${meat.text} Burger with:\n" +
//                    "${meat.text}" +    instead i pass it above for good understanding
                    (if (cheese) "\ncheese" else "") +
                    (if (onion) "\nonion" else "")  +
                    (if (salad) "\nsalad" else "")
            answerView.text = orderString

        }


    }
}