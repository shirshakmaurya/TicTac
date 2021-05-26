package com.example.tictac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(),View.OnClickListener {
    var PLAYER = true
    var TURN_COUNT = 0
    lateinit var textView1:TextView;
    var boardStatus = Array(3){IntArray(3)}
    lateinit var board: Array<Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView1 = findViewById<TextView>(R.id.tV1)
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
       initializeBoardStatus()

        btnReset.setOnClickListener {
            PLAYER = true
            TURN_COUNT = 0
            initializeBoardStatus()
        }
    }

    private fun initializeBoardStatus() {

        for(i in 0..2){
            for(j in 0..2){
                boardStatus[i][j]=-1
                board[i][j].text = ""
                board[i][j].isEnabled = true;
            }
        }
    }


    override fun onClick(v: View) {
        when( v.id){
            R.id.btn1->{
                updateValue(row = 0, col = 0, player = PLAYER)
            }
            R.id.btn2->{
                updateValue(row = 0, col = 1, player = PLAYER)
            }
            R.id.btn3->{
                updateValue(row = 0, col = 2, player = PLAYER)
            }
            R.id.btn4->{
                updateValue(row = 1, col = 0, player = PLAYER)
            }
            R.id.btn5->{
                updateValue(row = 1, col = 1, player = PLAYER)
            }
            R.id.btn6->{
                updateValue(row = 1, col = 2, player = PLAYER)
            }
            R.id.btn7->{
                updateValue(row = 2, col = 0, player = PLAYER)
            }
            R.id.btn8->{
                updateValue(row = 2, col = 1, player = PLAYER)
            }
            R.id.btn9->{
                updateValue(row = 2, col = 2, player = PLAYER)
            }
        }


        TURN_COUNT++
        PLAYER = !PLAYER
        if(PLAYER){
            updateTextView("Player X turn")
        }
        else{
            updateTextView("Player O turn")
        }

        if(TURN_COUNT==9)
            updateTextView("MATCH DRAW")

        checkWinner()
    }

    private fun checkWinner() {
       //rows
        for(i in 0..2){
            if(boardStatus[i][0]==boardStatus[i][1] && boardStatus[i][0] == boardStatus[i][2]){
                if(boardStatus[i][0]==1) {
                    updateTextView("player X is winner")
                    break
                }
                else if(boardStatus[i][0]==0){
                    updateTextView("player O is winner")
                    break
                }
            }
        }
        //col
        for(i in 0..2) {
            if (boardStatus[0][i] == boardStatus[1][i] && boardStatus[0][i] == boardStatus[2][i]) {
                if (boardStatus[0][i] == 1) {
                    updateTextView("player X is winner")
                    break
                } else if (boardStatus[0][i] == 0) {
                    updateTextView("player O is winner")
                    break
                }
            }
        }

        //diagonal1
        if (boardStatus[0][0] == boardStatus[1][1] && boardStatus[0][0] == boardStatus[2][2]) {
            if (boardStatus[0][0] == 1) {
                updateTextView("player X is winner")

            } else if (boardStatus[0][0] == 0) {
                updateTextView("player O is winner")
            }
        }
        ///diagonal2
        if (boardStatus[0][2] == boardStatus[1][1] && boardStatus[0][2] == boardStatus[2][0]) {
            if (boardStatus[0][2] == 1) {
                updateTextView("player X is winner")

            } else if (boardStatus[0][2] == 0) {
                updateTextView("player O is winner")
            }
        }


    }

    private fun disableButton() {
        for(i in 0..2){
            for(j in 0..2){
                board[i][j].isEnabled = false
            }
        }
    }

    private fun updateTextView(s: String) {
               textView1.text = s
         if(s.contains("winner")){
             disableButton()
         }
    }

    private fun updateValue(row: Int, col: Int, player: Boolean) {
        val text = if(player == true)  "X" else "O"
        val value = if(player) 1 else 0
        board[row][col].setText(text)
        board[row][col].isEnabled = false

        boardStatus[row][col] = value
    }
}