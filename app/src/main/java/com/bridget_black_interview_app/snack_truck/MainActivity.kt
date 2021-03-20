package com.bridget_black_interview_app.snack_truck

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

// TODO: remove TAG after project completion.
private const val TAG = "MainActivity"

/**
 * MainActivity gathers a user's Snack Truck order and submits it to be processed.
 *
 * @author Bridget Black
 * 2021-03-19
 * Last Updated: 2021-03-20
 */
class MainActivity : AppCompatActivity() {
    // Concatenate the order items into a message to be displayed in the orderSummary TextView.
    private var _orderItems: String? = ""
    // Mutable list of the Checkboxes for deselecting after a completed or canceled order.
    private val checkedBoxes: MutableList<CheckBox> = mutableListOf()

    /**
     * Create [MainActivity] and listens for a user to submit an order, sends order for
     * completion and resets [MainActivity] for the next user order.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO: remove TAG after project completion.
        Log.d(TAG, "onCreate called")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val orderSubmit = findViewById<Button>(R.id.button_order)

        orderSubmit.setOnClickListener {
            // TODO: remove TAG after project completion.
            Log.d(TAG, "setOnClickListener called")

            // Build order summary.
            buildOrderSummary()
            // Show the AlertDialog and place order.
            showOrderSummary()
            // Clear order items/summary for next user.
            _orderItems = ""
        }
    }

    private fun buildOrderSummary() {
        // TODO: remove TAG after project completion.
        Log.d(TAG, "buildOrderSummary called")

        // Status of each checkbox to build orderItems String with.
        val checkboxFrenchFries: CheckBox = findViewById(R.id.checkBox_french_frie)
        val checkboxVeggieburger: CheckBox = findViewById(R.id.checkBox_veggieburger)
        val checkboxCarrot: CheckBox = findViewById(R.id.checkBox_carrot)
        val checkboxApple: CheckBox = findViewById(R.id.checkBox_apple)
        val checkboxBanana: CheckBox = findViewById(R.id.checkBox_banana)
        val checkboxMilkshake: CheckBox = findViewById(R.id.checkBox_milkshake)
        val checkboxCheeseburger: CheckBox = findViewById(R.id.checkBox_cheeseburger)
        val checkboxHamburger: CheckBox = findViewById(R.id.checkBox_hamburger)
        val checkboxHotDog: CheckBox = findViewById(R.id.checkBox_hot_dog)

        if (checkboxFrenchFries.isChecked) {
            _orderItems += "French Fries\n"
            checkedBoxes.add(checkboxFrenchFries)
        }
        if (checkboxVeggieburger.isChecked) {
            _orderItems += "Veggieburger\n"
            checkedBoxes.add(checkboxVeggieburger)
        }
        if (checkboxCarrot.isChecked) {
            _orderItems += "Carrots\n"
            checkedBoxes.add(checkboxCarrot)
        }
        if (checkboxApple.isChecked) {
            _orderItems += "Apple\n"
            checkedBoxes.add(checkboxApple)
        }
        if (checkboxBanana.isChecked) {
            _orderItems += "Banana\n"
            checkedBoxes.add(checkboxBanana)
        }
        if (checkboxMilkshake.isChecked) {
            _orderItems += "Milkshake\n"
            checkedBoxes.add(checkboxMilkshake)
        }
        if (checkboxCheeseburger.isChecked) {
            _orderItems += "Cheeseburger\n"
            checkedBoxes.add(checkboxCheeseburger)
        }
        if (checkboxHamburger.isChecked) {
            _orderItems += "Hamburger\n"
            checkedBoxes.add(checkboxHamburger)
        }
        if (checkboxHotDog.isChecked) {
            _orderItems += "Hot Dog\n"
            checkedBoxes.add(checkboxHotDog)
        }
    }

    private fun showOrderSummary() {
        // TODO: remove TAG after project completion.
        Log.d(TAG, "showOrderSummary called")

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Place an order for:")
        builder.setMessage(_orderItems)

        builder.setPositiveButton("Purchase") { dialog, which ->
            // Stub for sending the order.
            completeTransaction(_orderItems)

            /*
            After the order submission and checkbox deselect are successful, close the AlertDialog. If unsuccessful, alert
            the user and proceed with failure causes.
             */
            dialog.dismiss()
            // Clear the CheckBoxes.
            deselectCheckBoxes()
            // Clear the CheckBox List.
            checkedBoxes.clear()
        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            dialog.dismiss()
            // Clear the CheckBox List.
            checkedBoxes.clear()
        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }

    private fun deselectCheckBoxes() {
        // TODO: remove TAG after project completion.
        Log.d(TAG, "deselectCheckBoxes called")

        for (snack in checkedBoxes) {
            snack.toggle()
        }
    }

    private fun completeTransaction(_orderItems: String?) {
        // TODO: Network service for actually placing the order isn't built yet, place call here.
    }
}