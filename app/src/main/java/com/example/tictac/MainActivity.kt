package com.example.tictac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(),View.OnClickListener {

    lateinit var board: Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btnReset = findViewById<Button>(R.id.btnReset)
        board = arrayOf(
            arrayOf(btn1,btn2,btn3),
            arrayOf(btn4,btn5,btn6),
            arrayOf(btn7,btn8,btn9)
        )
        for(i in board){
            for (button in i){
                button.setOnClickListener(this)
            }
        }
        btnReset.setOnClickListener {

        }
    }

    override fun onClick(v: View) {
        when( v.id){
            R.id.btn1->{

            }
            R.id.btn2->{

            }
            R.id.btn3->{

            }
            R.id.btn4->{

            }
            R.id.btn5->{

            }
            R.id.btn6->{

            }
            R.id.btn7->{

            }
            R.id.btn8->{

            }
            R.id.btn9->{

            }
        }
    }
}