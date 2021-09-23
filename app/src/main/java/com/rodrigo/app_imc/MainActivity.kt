package com.rodrigo.app_imc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }
    private fun setListeners(){
        edtAltura?.doAfterTextChanged { text ->
            //Toast.makeText(this,text.toString(), Toast.LENGTH_SHORT).show()
        }
        edtPeso?.doOnTextChanged{ text, _, _, _ ->
            //txtTitle?.text = text
        }
        btnCalcular?.setOnClickListener {
            btnCalcular(edtPeso.text.toString(), edtAltura.text.toString())
        }
    }
    private fun btnCalcular(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura != null){
            val imc = peso / (altura * altura)
            if (imc <= 18.5){
                txtTitle.text = "Seu IMC é $imc, você está abaixo do peso ".format(imc)
            }else if (imc <= 24.9){
                txtTitle.text = "Seu IMC é $imc, peso normal".format(imc)
            }else if (imc <= 29.9){
                txtTitle.text = "Seu IMC é $imc, você está com sobrepeso".format(imc)
            }else if (imc <= 34.8){
                txtTitle.text = "Seu IMC é $imc, você está com obesidade I".format(imc)
            }else if (imc <= 39.9){
                txtTitle.text = "Seu IMC é $imc, você está com obesidade II".format(imc)
            }else{
                txtTitle.text = "Seu IMC é $imc, você está com obesidade III ou mórbida".format(imc)
            }
        }
    }
}