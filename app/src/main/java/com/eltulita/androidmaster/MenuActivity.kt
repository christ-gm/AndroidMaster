package com.eltulita.androidmaster

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.eltulita.androidmaster.firstapp.FirstAppActivity
import com.eltulita.androidmaster.imccalculator.ImcCalculatorActivity
import com.eltulita.androidmaster.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSaludApp = findViewById<AppCompatButton>(R.id.btnSaludApp)
        val btnIMCApp = findViewById<AppCompatButton>(R.id.btnIMCApp)
        val btnTODOApp = findViewById<AppCompatButton>(R.id.btnTODO)
        btnSaludApp.setOnClickListener { navigateToSaludAPP() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnTODOApp.setOnClickListener { navigateToTODOApp() }
    }

    private fun navigateToSaludAPP(){
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp(){
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTODOApp(){
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }
}