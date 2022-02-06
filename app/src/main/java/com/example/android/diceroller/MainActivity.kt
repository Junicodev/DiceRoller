package com.example.android.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * This activity allows the user to roll a dice and view the result
 * on the screen.
 */
class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView

    /**
     * This method is called when the Activity is created.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.roll_button)
        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener { rollDice() }

        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }


    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val dice2 = Dice(6)
        val diceRoll = dice.roll()

        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

        diceImage.setImageResource(getRandomDiceImage(dice))
        diceImage2.setImageResource(getRandomDiceImage(dice2))
    }

    private fun getRandomDiceImage(dice: Dice): Int {
        return when (dice.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    private fun reset() {
        diceImage.setImageResource(R.drawable.dice_1)
        diceImage2.setImageResource(R.drawable.dice_1)
    }
}

class Dice(private val numSides: Int) {

    /**
     * Roll the dice and update the screen with the result.
     */
    fun roll(): Int {
        return (1..numSides).random()
    }
}