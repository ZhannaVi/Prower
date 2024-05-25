package com.example.pravilnonpravilno

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.pravilnonpravilno.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var correctEnsver:Int = 0
    var correctNotEnsver:Int = 0

    var firstNum:Int = 0
    var secondNum:Int = 0
    var answerNum:Int = 0
    var currectNum:Int = 0
    var indexSign:Int = 0
    var signArray:CharArray = charArrayOf('+','-','*','/')

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickStart(view: View)
    {
        newExpresion()
    }

    fun onClickNotRightCheck(view: View)
    {
        if (binding.txtAnswer.text != correctEnsver.toString())
        {
            correctEnsver++;
        }
        else
        {
            correctNotEnsver++
        }

        binding.txtCountCorrect.text = correctEnsver.toString()
        binding.txtCountNotCorrect.text = correctNotEnsver.toString()

        //var procent = ((correctEnsver / (correctEnsver + correctNotEnsver)) * 100)

        binding.txtAllEnsvers.text =  (correctEnsver + correctNotEnsver).toString()

        binding.txtProcent.text = ((correctEnsver.toFloat() / (correctEnsver + correctNotEnsver)) * 100f).toString() + "%"

        newExpresion()
    }

    fun onClickRightCheck(view: View)
    {
        if (binding.txtAnswer.text == correctEnsver.toString())
        {
            correctEnsver++;
        }
        else
        {
            correctNotEnsver++
        }

        binding.txtCountCorrect.text = correctEnsver.toString()
        binding.txtCountNotCorrect.text = correctNotEnsver.toString()

        //var procent = ((correctEnsver / (correctEnsver + correctNotEnsver)) * 100)

        binding.txtAllEnsvers.text =  (correctEnsver + correctNotEnsver).toString()

        binding.txtProcent.text = ((correctEnsver.toFloat() / (correctEnsver + correctNotEnsver)) * 100f).toString() + "%"

        newExpresion()
    }

    fun newExpresion()
    {
        firstNum = (0..99).random()
        secondNum = (0..99).random()
        indexSign = (0..3).random()

        var chanceInt:Int = (-2..2).random()

        if (signArray[indexSign] == '/')
        {
            var iterarionCount:Int = 0;
            while ((firstNum % secondNum) != 0)
            {
                firstNum = (1..99).random()
                secondNum = (1..99).random()
            }
            currectNum = firstNum/secondNum;
        }
        else if (signArray[indexSign] == '*')
        {
            currectNum = firstNum*secondNum;
        }
        else if (signArray[indexSign] == '-')
        {
            currectNum = firstNum-secondNum;
        }
        else if (signArray[indexSign] == '+')
        {
            currectNum = firstNum+secondNum;
        }

        answerNum = currectNum + chanceInt;

        binding.txtFirstNumber.text = firstNum.toString()
        binding.txtSecopndNumber.text = secondNum.toString()
        binding.txtSign.text = signArray[indexSign].toString()
        binding.txtAnswer.text = answerNum.toString();
    }
}