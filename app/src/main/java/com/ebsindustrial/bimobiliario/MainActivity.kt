package com.ebsindustrial.bimobiliario

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.ebsindustrial.bimobiliario.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Criado uma barra toolbar
        val toolBar = binding.toolbar
        toolBar.title = "Maquininha"
        toolBar.setTitleTextColor(getColor(R.color.white))
        toolBar.setBackgroundColor(getColor(R.color.fundoDark))
        toolBar.setTitleMargin(360, 0, 200, 0)
    }
}