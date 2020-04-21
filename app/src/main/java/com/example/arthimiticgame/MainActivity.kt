package com.example.arthimiticgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.arthimiticgame.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private var value_one: Int = 0
    private var value_two: Int = 0
    private var clickCounter: Int = 0
    private var sum: Result = Result()


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
//        setContentView(R.layout.activity_main)
        setListeners()

        binding.doneButton.setOnClickListener{
            check_ans(it)
        }


    }

    private fun setListeners()
    {
//         These are all the views that are subject to change in the program.
        val clickableViews: List<View> = listOf(option_one, option_two, option_three, option_four)
        for (item in clickableViews)
        {
            item.setOnClickListener{ get_val(it) }
        }
    }

    private fun check_ans(view: View)
    {
//        binding.firstNumber.text = binding.optionOne.text

        // This means that two numbers have been selected.

        println("In the check ans function")
        value_one = sum.first
        value_two = sum.second
        println("Value_one: $value_one \nValue_two: $value_two")

        if (clickCounter == 2)
        {
            println("This is value one $value_one")
            println("This is value two $value_two")
            binding.result.text = (value_one + value_two).toString()
        }

    }

    private fun get_val(view: View)
    {

        if (clickCounter == 2)
        {
            sum.first = 0
            sum.second = 0
            clickCounter = 0
        }

        var temp :Int? = null
        var pseudoVal: TextView = findViewById(view.id)
        //binding.doneButton.text = pseudoVal.text.toString()
        // This will get the id of the button that is clicked.
        temp = findViewById<TextView>(view.id).text.toString().toInt()

        // Now check we can store the the value in either the first or second value.
        if (sum.first == 0)
        {
            println("First value was 0")
            sum.first = temp
        }
        else
        {
            println("Second val was 0")
            sum.second = temp
        }

        clickCounter++
        println(clickCounter)

    }

}
