package com.example.ejercicio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textView = findViewById<TextView>(R.id.vista)
        var etA = findViewById<EditText>(R.id.etA)
        var etB = findViewById<EditText>(R.id.etB)
        var boton = findViewById<Button>(R.id.boton)


        etA.setOnFocusChangeListener(){_, focuseado ->
            if (focuseado)
                textView.setText(etA.tag.toString())
        }
        etB.setOnFocusChangeListener(){_, focuseado ->
            if (focuseado)
                textView.setText(etB.tag.toString())
        }
        boton.setOnFocusChangeListener(){_, focuseado ->
            if (focuseado)
                textView.setText(boton.tag.toString())
        }

        etA.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if((etA.length()>0) && (etB.length()>0)){
                    boton.isEnabled = true
                }else
                    boton.isEnabled = false
            } })

        etB.addTextChangedListener( object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if((etA.length()>0) && (etB.length()>0)){
                    boton.isEnabled = true
                }else
                    boton.isEnabled = false
            } })
        boton.setOnClickListener(){
            añadir()
            borrar()
        }

    }
    fun añadir(){

        var etA = findViewById<EditText>(R.id.etA)
        var etB = findViewById<EditText>(R.id.etB)


        etA.setText(etA.text.toString()+etB.text.toString())
    }

    fun borrar(){
        var etB = findViewById<EditText>(R.id.etB)

        etB.setText("")
    }
}