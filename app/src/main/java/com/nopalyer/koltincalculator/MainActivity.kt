package com.nopalyer.koltincalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Number listeners
        btn00.setOnClickListener { appendOnClick(true, "00") }
        btn0.setOnClickListener { appendOnClick(true, "0") }
        btn1.setOnClickListener { appendOnClick(true, "1") }
        btn2.setOnClickListener { appendOnClick(true, "2") }
        btn3.setOnClickListener { appendOnClick(true, "3") }
        btn4.setOnClickListener { appendOnClick(true, "4") }
        btn5.setOnClickListener { appendOnClick(true, "5") }
        btn6.setOnClickListener { appendOnClick(true, "6") }
        btn7.setOnClickListener { appendOnClick(true, "7") }
        btn8.setOnClickListener { appendOnClick(true, "8") }
        btn9.setOnClickListener { appendOnClick(true, "9") }
        btnDot.setOnClickListener { appendOnClick(true, ".") }


        //Operator Listeners
        btnPlus.setOnClickListener { appendOnClick(false, "+") }
        btnMinus.setOnClickListener { appendOnClick(false, "-") }
        btnMultiply.setOnClickListener { appendOnClick(false, "*") }
        btnDivide.setOnClickListener { appendOnClick(false, "/") }
        btnLeftB.setOnClickListener { appendOnClick(false, "(") }
        btnRightB.setOnClickListener { appendOnClick(false, ")") }


        btnClear.setOnClickListener {
            clear()
        }

        btnEqual.setOnClickListener {
            calculate()
        }


    }

    //now create methods

    private fun appendOnClick(clear: Boolean, string: String) {

        if (clear) {
            tvOutput.text = ""
            tvInput.append(string)
        } else {
            tvInput.append(tvOutput.text)
            tvInput.append(string)
            tvOutput.text = ""
        }
    }

    private fun clear() {
        tvInput.text = ""
        tvOutput.text = ""

    }

    private fun calculate() {

        try {

            val input = ExpressionBuilder(tvInput.text.toString()).build()
            val output = input.evaluate()
            val longOutput = output.toLong()
            if (output == longOutput.toDouble()){
                tvOutput.text = longOutput.toString()
            }else{
                tvOutput.text = output.toString()
            }

        }catch (e:Exception){
            Toast.makeText(this@MainActivity,e.message,Toast.LENGTH_LONG).show()
        }
    }
}
