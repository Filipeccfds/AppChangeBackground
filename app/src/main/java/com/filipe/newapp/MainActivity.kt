package com.filipe.newapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    var textoTitulo :TextView? = null
    var numeroClique :TextView? = null
    var editorTexto : EditText? = null
    var tela :LinearLayoutCompat? = null
    var numClicks = 0



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textoTitulo = findViewById(R.id.texto)
        editorTexto = findViewById(R.id.textomodificavel)
        tela = findViewById(R.id.tela_principal)
        numeroClique = findViewById(R.id.numeroclick)



        textoTitulo?.text = "Seja Bem Vindo"
        val botao = findViewById<Button>(R.id.botaodeclique)


        botao.setOnClickListener {
                clique()
                numClicks++
                numeroDeClicks()

        }

        editorTexto?.addTextChangedListener {
            textoTitulo?.text = it?.toString()
        }

    }

    fun numeroDeClicks(){
        numeroClique?.text = "Numero de Clicks: ${numClicks}"
    }

    fun clique() {
        when{
            numClicks  % 2 == 0 -> tela?.background = getDrawable(R.drawable.img_03)
            numClicks  %3 == 0 -> tela?.background = getDrawable(R.drawable.img_02)
            else -> tela?.background = getDrawable(R.drawable.img_01)

        }
    }
}