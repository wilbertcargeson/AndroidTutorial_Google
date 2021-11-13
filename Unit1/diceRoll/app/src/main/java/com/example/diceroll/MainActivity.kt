package com.example.diceroll

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.diceroll.Dice

class MainActivity : AppCompatActivity() {

    private var dice: Dice = Dice(6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)

        rollButton.setOnClickListener {
            rollDice()
        }

        rollDice()
    }

    private fun rollDice() {

        // Display toast on click
        val toast = Toast.makeText(this, "Dice Rolled", Toast.LENGTH_SHORT)
        toast.show()

        // Display value of first dice roll
        val dice1ImageView: ImageView = findViewById(R.id.dice_image_1)
        var diceRoll = dice.roll()
        dice1ImageView.setImageResource(getDiceImage(diceRoll))
        dice1ImageView.contentDescription = diceRoll.toString()

        // Display value of second dice roll
        diceRoll = dice.roll()
        val dice2ImageView: ImageView = findViewById(R.id.dice_image_2)
        dice2ImageView.setImageResource(getDiceImage(diceRoll))
        dice2ImageView.contentDescription = diceRoll.toString()


    }

    private fun getDiceImage(num: Int): Int {
        return when (num) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6

            else -> R.drawable.dice_1
        }

    }
}
