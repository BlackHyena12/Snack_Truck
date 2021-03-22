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
    // List of all the available snack items.
    private val _snackList: MutableList<CheckBox> = mutableListOf()
    // List of the String representations of snack items selected for purchase.
    private val _orderSummary: MutableList<String> = mutableListOf()
    // List of the Checkboxes for deselecting after a completed or canceled order.
    private val _checkedBoxes: MutableList<CheckBox> = mutableListOf()

    /**
     * Create [MainActivity] and listens for a user to submit an order, builds and sends order for
     * completion then resets [MainActivity] for the next user order.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val orderSubmit = findViewById<Button>(R.id.button_order)
        orderSubmit.setOnClickListener {
            buildSnackOptions()
            buildOrderSummary()
            showOrderSummary()
        }
    }

    private fun buildSnackOptions() {
        val checkboxFrenchFries: CheckBox = findViewById(R.id.checkBox_french_frie)
        val checkboxVeggieburger: CheckBox = findViewById(R.id.checkBox_veggieburger)
        val checkboxCarrot: CheckBox = findViewById(R.id.checkBox_carrot)
        val checkboxApple: CheckBox = findViewById(R.id.checkBox_apple)
        val checkboxBanana: CheckBox = findViewById(R.id.checkBox_banana)
        val checkboxMilkshake: CheckBox = findViewById(R.id.checkBox_milkshake)
        val checkboxCheeseburger: CheckBox = findViewById(R.id.checkBox_cheeseburger)
        val checkboxHamburger: CheckBox = findViewById(R.id.checkBox_hamburger)
        val checkboxHotDog: CheckBox = findViewById(R.id.checkBox_hot_dog)

        _snackList.add(checkboxFrenchFries)
        _snackList.add(checkboxVeggieburger)
        _snackList.add(checkboxCarrot)
        _snackList.add(checkboxApple)
        _snackList.add(checkboxBanana)
        _snackList.add(checkboxMilkshake)
        _snackList.add(checkboxCheeseburger)
        _snackList.add(checkboxHamburger)
        _snackList.add(checkboxHotDog)
    }

    private fun buildOrderSummary() {
        for (snack in _snackList) {
            if (snack.isChecked) {
                _orderSummary.add(snack.text.toString())
                _checkedBoxes.add(snack)
            }
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
        _snackList.clear()
    }

    private fun completeTransaction(_orderItems: List<String>) {
        // TODO: Network service for actually placing the order isn't built yet, place call here.
    }
}