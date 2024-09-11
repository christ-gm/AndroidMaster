package com.eltulita.androidmaster.imccalculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eltulita.androidmaster.R
import com.eltulita.androidmaster.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView
    private lateinit var btnReCalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }


    private fun initListeners(){
        btnReCalculate.setOnClickListener {
            // Ya sabemos que con un intent se pueden navegar a vistas hacia adelante. pero ahora lo haremos hacia la vista anterior
            onBackPressed()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun initUI(result: Double){
        tvIMC.text = result.toString()
        when(result){
            in 0.00..18.50 ->{ //bajo peso
                tvResult.text = getString(R.string.title_bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.bajo_peso))
                tvDescription.text = getString(R.string.description_bajo_peso)
            }

            in 18.51..24.99 ->{ //normal
                tvResult.text = getString(R.string.title_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.normal))
                tvDescription.text = getString(R.string.description_normal)
            }

            in 25.00..29.99 ->{ //sobrepeso
                tvResult.text = getString(R.string.title_sopbrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))
                tvDescription.text = getString(R.string.description_sobrepeso)
            }

            in 30.00..99.00 ->{ //obesidad
                tvResult.text = getString(R.string.title_obeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obeso))
                tvDescription.text = getString(R.string.description_obeso)
            }
            else -> { //error
                tvResult.text = getString(R.string.error)
                tvIMC.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }
        }
    }


    private fun initComponents(){
        tvIMC = findViewById(R.id.tvIMC)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }

}