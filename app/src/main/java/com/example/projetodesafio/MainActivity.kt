package com.example.projetodesafio

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val mainView = findViewById<View>(R.id.main)
        if (mainView != null)
        {
            ViewCompat.setOnApplyWindowInsetsListener(mainView) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }

    fun sortearNumeros(view: View)
    {
        val texto = findViewById<TextView>(R.id.textoResultado)

        val numerosSorteados = generateUniqueRandomNumbers(6, 1, 68)
        val numerosString = numerosSorteados.joinToString(", ")
        texto.text = "$numerosString"
    }

    private fun generateUniqueRandomNumbers(count: Int, min: Int, max: Int): List<Int>
    {
        val numbers = (min until max).toMutableList()
        numbers.shuffle()
        return numbers.take(count)
    }
}
