package com.bridget_black_interview_app.snack_truck

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

/*
TODO: remove TAG after project completion.
*/
private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    // Concatenate the order items into a message to be displayed in the orderSummary TextView.
    private var orderItems: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate called")
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

        val orderSubmit = findViewById<Button>(R.id.button_order)
        orderSubmit.setOnClickListener {
            Log.d(TAG, "setOnClickListener called")
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
            showOrderSummary(this)
        }
    }

    fun showOrderSummary(view: MainActivity) {
        Log.d(TAG, "AppDialog called")
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Show Simple Dialog")
        builder.setMessage("Your order contains:\n$orderItems")
        builder.setIcon(R.drawable.ic_launcher_background)

        builder.setPositiveButton("positive", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })
        builder.setNegativeButton("negative", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })
        builder.setNeutralButton("neutral", DialogInterface.OnClickListener { dialog, which ->
            dialog.dismiss()
        })

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }
}

