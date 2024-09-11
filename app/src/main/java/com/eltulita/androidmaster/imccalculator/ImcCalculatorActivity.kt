package com.eltulita.androidmaster.imccalculator

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.text.DecimalFormat
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eltulita.androidmaster.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import kotlin.math.log

class ImcCalculatorActivity : AppCompatActivity() {

    //genero
    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView

    //slider
    private lateinit var tvHeight: TextView //altura en cm
    private lateinit var rsHeight: RangeSlider //slider

    //Peso
    private lateinit var tvWeight:TextView //peso
    private lateinit var btnSubstractWeight:FloatingActionButton //boton disminuir peso
    private lateinit var btnAddWeight:FloatingActionButton //boton aumentar peso

    //Edad
    private lateinit var tvAge:TextView //edad
    private lateinit var btnSubstractAge:FloatingActionButton //boton disminuir edad
    private lateinit var btnAddAge:FloatingActionButton //boton aumentar edad

    //Calculate

    private lateinit var btnCalculate:Button //boton calcular

    //Por defecto viene seleccionado en male
    private var isMaleSelected:Boolean = true
    private var isFemaleSelected:Boolean = false

    //peso por defecto
    private var currentWeight:Int = 60

    //edad por defecto

    private var currentAge:Int = 20

    //altura por defecto

    private var currentHeight:Int = 120

    companion object{
        const val IMC_KEY = "IMC_RESULT"
    }



    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imc_calculator)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        initComponents()
        initListeners()
        initUI()

    }



    private fun initComponents(){ //metodo para inicialiazar variables viewMale y viewFemale
        //generos
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)

        // altura
        tvHeight = findViewById(R.id.tvHeight) // num altura
        rsHeight = findViewById(R.id.rsHeight) //slider

        //peso
        tvWeight = findViewById(R.id.tvWeight) //num peso
        btnSubstractWeight = findViewById(R.id.btnSubstractWeight) //boton -
        btnAddWeight = findViewById(R.id.btnAddWeight)//boton +

        //Edad
        tvAge = findViewById(R.id.tvAge)//num edad
        btnAddAge = findViewById(R.id.btnAddAge) //boton + edad
        btnSubstractAge = findViewById(R.id.btnSubstractAge) //boton - edad

        //Calcular
        btnCalculate = findViewById(R.id.btnCalculate) //boton calculate



    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.N)
    private fun initListeners(){
        //listeners para presionar los generos
        viewMale.setOnClickListener {
            changeGender("male")
            setGenderColor() }

        viewFemale.setOnClickListener {
            changeGender("female")
            setGenderColor() }

        //listeners para la altura
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            currentHeight = df.format(value).toInt() //tira error porque currentHeight debe ser int y df.format retorna una string
            tvHeight.text = "$currentHeight cm"
        }

        //Listeners para el peso
        btnAddWeight.setOnClickListener {
            currentWeight +=  1
            setWeight()

        }
        btnSubstractWeight.setOnClickListener {
            currentWeight -= 1
            setWeight()
        }

        //Listeners para la edad
        btnAddAge.setOnClickListener {
            currentAge +=1 //se actualiza la current age, pero ahora se debe mostrar en la vista, y se hace con un set
            setAge()
        }

        btnSubstractAge.setOnClickListener {
            currentAge -=1
            setAge()
        }

        //listener para boton calculate
        btnCalculate.setOnClickListener {
            val result = calculateIMC()
            navigateToResult(result)
        }
    }


    private fun navigateToResult(result: Double){
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun calculateIMC(): Double{
        val df = DecimalFormat("#.##")
        val imc = currentWeight / (currentHeight.toDouble()/100 * currentHeight.toDouble()/100)
        //Log.i("eltulita", "el imc es: $imc")
        return df.format(imc).toDouble()


    }

    private fun setWeight(){ //FUncion para setear el peso
        tvWeight.text = currentWeight.toString()
    }

    private fun setAge(){
        tvAge.text = currentAge.toString()
    }

    // este codigo esta bien pero se puede optimizar
    /*private fun setGendercolor(){
        val maleColor = if(isMaleSelected){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }

        val femaleColor = if(isFemaleSelected){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }
    }*/

    private fun changeGender(selectedGender:String){
        when(selectedGender){
            "male" -> {
                isMaleSelected=true
                isFemaleSelected=false
            }
            "female" -> {
                isMaleSelected=false
                isFemaleSelected=true
            }
        }
    }


    private fun setGenderColor(){
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    //asi

    private fun getBackgroundColor(isSelectedComponent:Boolean): Int{
        val colorReference = if(isSelectedComponent){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }
}