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

        desabilita()
        iniciar()
    }
    //
    private fun desabilita(){
        binding.btSorte.isEnabled = false
        binding.btSalvar.isEnabled = false
        binding.btTransferir.isEnabled = false
        binding.radio1Jog1.isEnabled = false
        binding.radio1Jog2.isEnabled = false
        binding.radio1Jog3.isEnabled = false
        binding.radio1Jog4.isEnabled = false
        binding.radio1Jog5.isEnabled = false
        binding.radio1Jog6.isEnabled = false
        binding.banco1.isEnabled = false
        binding.banco2.isEnabled = false
        binding.radio2Jog1.isEnabled = false
        binding.radio2Jog2.isEnabled = false
        binding.radio2Jog3.isEnabled = false
        binding.radio2Jog4.isEnabled = false
        binding.radio2Jog5.isEnabled = false
        binding.radio2Jog6.isEnabled = false
        binding.editValor.isEnabled = false
    }
    //
    private fun habilita(){
        binding.btSorte.isEnabled = true
        binding.btSalvar.isEnabled = true
        binding.btTransferir.isEnabled = true
        binding.radio1Jog1.isEnabled = true
        binding.radio1Jog2.isEnabled = true
        binding.radio1Jog3.isEnabled = true
        binding.radio1Jog4.isEnabled = true
        binding.radio1Jog5.isEnabled = true
        binding.radio1Jog6.isEnabled = true
        binding.banco1.isEnabled = true
        binding.banco2.isEnabled = true
        binding.radio2Jog1.isEnabled = true
        binding.radio2Jog2.isEnabled = true
        binding.radio2Jog3.isEnabled = true
        binding.radio2Jog4.isEnabled = true
        binding.radio2Jog5.isEnabled = true
        binding.radio2Jog6.isEnabled = true
        binding.editValor.isEnabled = true
    }
    //
    private fun iniciar(){
        binding.btIniciar.setOnClickListener {
            habilita()
            binding.vlJog1.setText(R.string.valorInicial)
            binding.vlJog2.setText(R.string.valorInicial)
            binding.vlJog3.setText(R.string.valorInicial)
            binding.vlJog4.setText(R.string.valorInicial)
            binding.vlJog5.setText(R.string.valorInicial)
            binding.vlJog6.setText(R.string.valorInicial)
            binding.txtSorte.setText(R.string.mensagemInicial)
        }
    }
}