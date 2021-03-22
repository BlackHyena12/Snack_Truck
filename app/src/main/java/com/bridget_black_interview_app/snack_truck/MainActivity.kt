package com.bridget_black_interview_app.snack_truck

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

/**
 * MainActivity gathers a user's Snack Truck order and submits it to be processed.
 *
 * @author Bridget Black
 * 2021-03-19
 * Last Updated: 2021-03-21
 */
class MainActivity : AppCompatActivity() {
    // Concatenate the order items into a message to be displayed in the orderSummary TextView.
    private val _orderSummary: MutableList<String> = mutableListOf()
    // Mutable list of the Checkboxes for deselecting after a completed or canceled order.
    private val _checkedBoxes: MutableList<CheckBox> = mutableListOf()

    /**
     * Create [MainActivity] and listens for a user to submit an order, sends order for
     * completion and resets [MainActivity] for the next user order.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val orderSubmit = findViewById<Button>(R.id.button_order)
        orderSubmit.setOnClickListener {
            // Build order summary.
            buildOrderSummary()
            // Show the AlertDialog and place order.
            showOrderSummary()
        }
    }

    private fun buildOrderSummary() {
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
            _orderSummary.add(checkboxFrenchFries.text.toString())
            _checkedBoxes.add(checkboxFrenchFries)
        }
        if (checkboxVeggieburger.isChecked) {
            _orderSummary.add(checkboxVeggieburger.text.toString())
            _checkedBoxes.add(checkboxVeggieburger)
        }
        if (checkboxCarrot.isChecked) {
            _orderSummary.add(checkboxCarrot.text.toString())
            _checkedBoxes.add(checkboxCarrot)
        }
        if (checkboxApple.isChecked) {
            _orderSummary.add(checkboxApple.text.toString())
            _checkedBoxes.add(checkboxApple)
        }
        if (checkboxBanana.isChecked) {
            _orderSummary.add(checkboxBanana.text.toString())
            _checkedBoxes.add(checkboxBanana)
        }
        if (checkboxMilkshake.isChecked) {
            _orderSummary.add(checkboxMilkshake.text.toString())
            _checkedBoxes.add(checkboxMilkshake)
        }
        if (checkboxCheeseburger.isChecked) {
            _orderSummary.add(checkboxCheeseburger.text.toString())
            _checkedBoxes.add(checkboxCheeseburger)
        }
        if (checkboxHamburger.isChecked) {
            _orderSummary.add(checkboxHamburger.text.toString())
            _checkedBoxes.add(checkboxHamburger)
        }
        if (checkboxHotDog.isChecked) {
            _orderSummary.add(checkboxHotDog.text.toString())
            _checkedBoxes.add(checkboxHotDog)
        }
    }

    private fun showOrderSummary() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("Place an order for:")
        builder.setMessage(listToString(_orderSummary))

        builder.setPositiveButton("Purchase") { dialog, which ->
            /*
            TODO: If the order submission is unsuccessful, alert the user and proceed with
             failure causes, try catch.
             */
            completeTransaction(_orderSummary)
            dialog.dismiss()
            deselectCheckBoxes()
            clearLists()
        }
        builder.setNegativeButton("Cancel") { dialog, which ->
            dialog.dismiss()
            deselectCheckBoxes()
            clearLists()
        }
//        builder.setNeutralButton("Edit") { dialog, which ->
//            dialog.dismiss()
//            clearLists()
//        }

        val alertDialog: AlertDialog = builder.create()
        alertDialog.show()
    }

    private fun listToString(order: MutableList<String>): String {
        var message = ""
        for (snack in order) {
            message += "$snack\n"
        }
        return message
    }

    private fun deselectCheckBoxes() {
        for (snack in _checkedBoxes) {
            snack.toggle()
        }
    }

    private fun clearLists() {
        _checkedBoxes.clear()
        _orderSummary.clear()
    }
    
    private fun completeTransaction(_orderItems: List<String>) {
        // TODO: Network service for actually placing the order isn't built yet, place call here.
    }
}