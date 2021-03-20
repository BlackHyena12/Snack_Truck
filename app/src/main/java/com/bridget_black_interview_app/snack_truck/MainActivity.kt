package com.bridget_black_interview_app.snack_truck

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Concatenate the order items into a message to be displayed in the orderSummary TextView.
    private var orderItems: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Locally hold the status of each checkbox to build orderItems String with.
        val checkboxFrenchFrie = findViewById<CheckBox>(R.id.checkBox_french_frie)
        val checkboxVeggieburger = findViewById<CheckBox>(R.id.checkBox_veggieburger)
        val checkboxCarrot = findViewById<CheckBox>(R.id.checkBox_carrot)
        val checkboxApple = findViewById<CheckBox>(R.id.checkBox_apple)
        val checkboxBanana = findViewById<CheckBox>(R.id.checkBox_banana)
        val checkboxMilkshake = findViewById<CheckBox>(R.id.checkBox_milkshake)
        val checkboxCheeseburger = findViewById<CheckBox>(R.id.checkBox_cheeseburger)
        val checkboxHamburger = findViewById<CheckBox>(R.id.checkBox_hamburger)
        val checkboxHotDog = findViewById<CheckBox>(R.id.checkBox_hot_dog)

        // Locally hold the orderSummary TextView Widget to insert the orderItem String in later.
        val orderSummary = findViewById<TextView>(R.id.textView_order_summary)

        val orderSubmit = findViewById<Button>(R.id.button_order)
        orderSubmit.setOnClickListener {
            if (checkboxFrenchFrie.isChecked) {
                orderItems += "French Fries\n"
            }
            if (checkboxVeggieburger.isChecked) {
                orderItems += "Veggieburger\n"
            }
            if (checkboxCarrot.isChecked) {
                orderItems += "Carrots\n"
            }
            if (checkboxApple.isChecked) {
                orderItems += "Apple\n"
            }
            if (checkboxBanana.isChecked) {
                orderItems += "Banana\n"
            }
            if (checkboxMilkshake.isChecked) {
                orderItems += "Milkshake\n"
            }
            if (checkboxCheeseburger.isChecked) {
                orderItems += "Cheeseburger\n"
            }
            if (checkboxHamburger.isChecked) {
                orderItems += "Hamburger\n"
            }
            if (checkboxHotDog.isChecked) {
                orderItems += "Hot Dog\n"
            }

            // Display the orderSummary to the user when the orderSubmit Button is clicked.
            orderSummary.text = "Your order contains:\n$orderItems"
        }
    }
}

