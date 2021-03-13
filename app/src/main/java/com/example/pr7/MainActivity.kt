package com.example.pr7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.sql.Struct

class MainActivity : AppCompatActivity() {
    var simpleList = listOf<Int>(2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.calculateBtn).setOnClickListener {

            val number = findViewById<EditText>(R.id.inputNum).text.toString().toIntOrNull()

            if (number == null) Toast.makeText(applicationContext, "ВВЕДЕННОЕ ЧИСЛО СЛИШКОМ БОЛЬШОЕ!", Toast.LENGTH_SHORT).show()
            else findViewById<TextView>(R.id.output).text = claculate(number!!)
        }

        findViewById<Button>(R.id.clearBtn).setOnClickListener {
            findViewById<EditText>(R.id.inputNum).text.clear()
        }

    }

    // вычисление множителей
    fun claculate(number: Int):String{
        if(number <= 1) return "1"

        var number = number
        var multiples = ""
        var div = 2

        while (number > 1){
            var stufe = 0

            while (number % div == 0){
                stufe++
                number /= div
            }
            if(stufe>0){
                multiples += "$div"
                if(stufe > 1) multiples+="^$stufe"
                if(number > 1) multiples += " * "
            }

            if(div == 2) div++
            else div += 2
        }

        return multiples
    }
}

/*
2142324
123456789
7438742

while (n > 1) {
int k = 0;
while (n % div == 0) {
k++;
n = n / div;
}
if (k>0) {
   cout << div;
   if (k> 1) cout << "^" << k;
   if (n > 1) cout << "*";
}
if (div == 2) div++;
else div += 2;
}



*/