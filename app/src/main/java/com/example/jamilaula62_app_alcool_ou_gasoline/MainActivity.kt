package com.example.jamilaula62_app_alcool_ou_gasoline

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcular(view: View) {

       // val precoAlcool = findViewById(R.id.edit_preco_alcool) as TextView
        val precoAlcool = edit_preco_alcool.text.toString()
        val precoGas: String = edit_preco_gas.text.toString()

        var validaCampos = validarCampos(precoAlcool, precoGas)

        if(validaCampos){
            calcularMelhorPreco(precoAlcool, precoGas)
        } else {
            text_display.setText("Prencha os preços primeiro")
        }




     //   Log.i("RESULTADO", "Texto recuperado: $precoAlcool")

    }

    fun validarCampos(precoAlcool:String, precoGas:String): Boolean{

        var camposValidados: Boolean = true
        if(precoAlcool == null || precoAlcool.equals("")){
            camposValidados = false
        } else if(precoGas == null || precoGas.equals("")){
            camposValidados = false
        }
        return camposValidados


    }

    fun calcularMelhorPreco(precoAlcool:String, precoGas:String){
        val valorAcool = precoAlcool.toDouble()
        val valorGas = precoGas.toDouble()

        val resultadoPreco = valorAcool/valorGas

        if(resultadoPreco >= 0.7){
            text_display.setText("A melhor opção é Gasolina")
        } else {
            text_display.setText("A melhor opção é Acool")
        }
    }
}
