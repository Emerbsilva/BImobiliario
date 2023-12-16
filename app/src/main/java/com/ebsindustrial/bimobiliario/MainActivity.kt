package com.ebsindustrial.bimobiliario

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.ebsindustrial.bimobiliario.databinding.ActivityMainBinding
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var sorteados = mutableListOf<Int>()
    private val maxMensagemSorte = 30
    private var soma = 0

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
        sorte()
        salvar()
        transferir()
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
    //
    private fun sorte(){
        binding.btSorte.setOnClickListener {
            var num = Random.nextInt(1..maxMensagemSorte)
            while (num in sorteados){
                num = Random.nextInt(1..maxMensagemSorte)
            }
            sorteados.add(num)
            when (num){
                1 -> binding.txtSorte.setText(R.string.sorte1)
                2 -> binding.txtSorte.setText(R.string.sorte2)
                3 -> binding.txtSorte.setText(R.string.sorte3)
                4 -> binding.txtSorte.setText(R.string.sorte4)
                5 -> binding.txtSorte.setText(R.string.sorte5)
                6 -> binding.txtSorte.setText(R.string.sorte6)
                7 -> binding.txtSorte.setText(R.string.sorte7)
                8 -> binding.txtSorte.setText(R.string.sorte8)
                9 -> binding.txtSorte.setText(R.string.sorte9)
                10 -> binding.txtSorte.setText(R.string.sorte10)
                11 -> binding.txtSorte.setText(R.string.sorte11)
                12 -> binding.txtSorte.setText(R.string.sorte12)
                13 -> binding.txtSorte.setText(R.string.sorte13)
                14 -> binding.txtSorte.setText(R.string.sorte14)
                15 -> binding.txtSorte.setText(R.string.sorte15)
                16 -> binding.txtSorte.setText(R.string.sorte16)
                17 -> binding.txtSorte.setText(R.string.sorte17)
                18 -> binding.txtSorte.setText(R.string.sorte18)
                19 -> binding.txtSorte.setText(R.string.sorte19)
                20 -> binding.txtSorte.setText(R.string.sorte20)
                21 -> binding.txtSorte.setText(R.string.sorte21)
                22 -> binding.txtSorte.setText(R.string.sorte22)
                23 -> binding.txtSorte.setText(R.string.sorte23)
                24 -> binding.txtSorte.setText(R.string.sorte24)
                25 -> binding.txtSorte.setText(R.string.sorte25)
                26 -> binding.txtSorte.setText(R.string.sorte26)
                27 -> binding.txtSorte.setText(R.string.sorte27)
                28 -> binding.txtSorte.setText(R.string.sorte28)
                29 -> binding.txtSorte.setText(R.string.sorte29)
                30 -> binding.txtSorte.setText(R.string.sorte30)
            }
            if (sorteados.size == maxMensagemSorte){
                sorteados.clear()
            }
        }
    }
    //
    private fun salvar(){

    }
    //
    private fun transferir(){
        soma = 0
        binding.btTransferir.setOnClickListener {
            val valor1: Int
            val valor2: Int
            val valorTransferencia: Int
            val verifica = binding.editValor.text.toString()
            if (verifica.isEmpty()){
                binding.txtSorte.setText(R.string.valorTrasferirVazio)
            }else if (binding.radio1Jog1.isChecked){
                if (binding.radio2Jog1.isChecked) {
                    binding.txtSorte.setText(R.string.mesmoJogador)
                }else if (binding.radio2Jog2.isChecked) {
                    valor1 = binding.vlJog1.text.toString().toInt()
                    valor2 = binding.vlJog2.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog1.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog2.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog1ToJog2)
                }else if (binding.radio2Jog3.isChecked) {
                    valor1 = binding.vlJog1.text.toString().toInt()
                    valor2 = binding.vlJog3.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog1.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog3.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog1ToJog3)
                }else if (binding.radio2Jog4.isChecked) {
                    valor1 = binding.vlJog1.text.toString().toInt()
                    valor2 = binding.vlJog4.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog1.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog4.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog1ToJog4)
                }else if (binding.radio2Jog5.isChecked) {
                    valor1 = binding.vlJog1.text.toString().toInt()
                    valor2 = binding.vlJog5.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog1.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog5.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog1ToJog5)
                }else if (binding.radio2Jog6.isChecked) {
                    valor1 = binding.vlJog1.text.toString().toInt()
                    valor2 = binding.vlJog6.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog1.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog6.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog1ToJog6)
                }else if (binding.banco2.isChecked) {
                    valor1 = binding.vlJog1.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    binding.vlJog1.text = (valor1 - valorTransferencia).toString()
                    binding.txtSorte.setText(R.string.jog1ToBanco)
                }else{
                    binding.txtSorte.setText(R.string.semDestino)
                }
            }else if (binding.radio1Jog2.isChecked){
                if (binding.radio2Jog2.isChecked) {
                    binding.txtSorte.setText(R.string.mesmoJogador)
                }else if (binding.radio2Jog1.isChecked) {
                    valor1 = binding.vlJog2.text.toString().toInt()
                    valor2 = binding.vlJog1.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog2.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog1.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog2ToJog1)
                }else if (binding.radio2Jog3.isChecked) {
                    valor1 = binding.vlJog2.text.toString().toInt()
                    valor2 = binding.vlJog3.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog2.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog3.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog2ToJog3)
                }else if (binding.radio2Jog4.isChecked) {
                    valor1 = binding.vlJog2.text.toString().toInt()
                    valor2 = binding.vlJog4.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog2.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog4.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog2ToJog4)
                }else if (binding.radio2Jog5.isChecked) {
                    valor1 = binding.vlJog2.text.toString().toInt()
                    valor2 = binding.vlJog5.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog2.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog5.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog2ToJog5)
                }else if (binding.radio2Jog6.isChecked) {
                    valor1 = binding.vlJog2.text.toString().toInt()
                    valor2 = binding.vlJog6.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog2.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog6.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog2ToJog6)
                }else if (binding.banco2.isChecked) {
                    valor1 = binding.vlJog2.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    binding.vlJog2.text = (valor1 - valorTransferencia).toString()
                    binding.txtSorte.setText(R.string.jog2ToBanco)
                }else{
                    binding.txtSorte.setText(R.string.semDestino)
                }
            }else if (binding.radio1Jog3.isChecked){
                if (binding.radio2Jog3.isChecked) {
                    binding.txtSorte.setText(R.string.mesmoJogador)
                }else if (binding.radio2Jog2.isChecked) {
                    valor1 = binding.vlJog3.text.toString().toInt()
                    valor2 = binding.vlJog2.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog3.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog2.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog3ToJog2)
                }else if (binding.radio2Jog1.isChecked) {
                    valor1 = binding.vlJog3.text.toString().toInt()
                    valor2 = binding.vlJog1.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog3.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog1.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog3ToJog1)
                }else if (binding.radio2Jog4.isChecked) {
                    valor1 = binding.vlJog3.text.toString().toInt()
                    valor2 = binding.vlJog4.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog3.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog4.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog3ToJog4)
                }else if (binding.radio2Jog5.isChecked) {
                    valor1 = binding.vlJog3.text.toString().toInt()
                    valor2 = binding.vlJog5.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog3.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog5.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog3ToJog5)
                }else if (binding.radio2Jog6.isChecked) {
                    valor1 = binding.vlJog3.text.toString().toInt()
                    valor2 = binding.vlJog6.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog3.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog6.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog3ToJog6)
                }else if (binding.banco2.isChecked) {
                    valor1 = binding.vlJog3.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    binding.vlJog1.text = (valor1 - valorTransferencia).toString()
                    binding.txtSorte.setText(R.string.jog3ToBanco)
                }else{
                    binding.txtSorte.setText(R.string.semDestino)
                }
            }else if (binding.radio1Jog4.isChecked){
                if (binding.radio2Jog4.isChecked) {
                    binding.txtSorte.setText(R.string.mesmoJogador)
                }else if (binding.radio2Jog2.isChecked) {
                    valor1 = binding.vlJog4.text.toString().toInt()
                    valor2 = binding.vlJog2.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog4.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog2.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog4ToJog2)
                }else if (binding.radio2Jog3.isChecked) {
                    valor1 = binding.vlJog4.text.toString().toInt()
                    valor2 = binding.vlJog3.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog4.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog3.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog4ToJog3)
                }else if (binding.radio2Jog1.isChecked) {
                    valor1 = binding.vlJog4.text.toString().toInt()
                    valor2 = binding.vlJog1.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog4.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog1.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog4ToJog1)
                }else if (binding.radio2Jog5.isChecked) {
                    valor1 = binding.vlJog4.text.toString().toInt()
                    valor2 = binding.vlJog5.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog4.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog5.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog4ToJog5)
                }else if (binding.radio2Jog6.isChecked) {
                    valor1 = binding.vlJog4.text.toString().toInt()
                    valor2 = binding.vlJog6.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog4.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog6.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog4ToJog6)
                }else if (binding.banco2.isChecked) {
                    valor1 = binding.vlJog4.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    binding.vlJog1.text = (valor1 - valorTransferencia).toString()
                    binding.txtSorte.setText(R.string.jog4ToBanco)
                }else{
                    binding.txtSorte.setText(R.string.semDestino)
                }
            }else if (binding.radio1Jog5.isChecked){
                if (binding.radio2Jog5.isChecked) {
                    binding.txtSorte.setText(R.string.mesmoJogador)
                }else if (binding.radio2Jog2.isChecked) {
                    valor1 = binding.vlJog5.text.toString().toInt()
                    valor2 = binding.vlJog2.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog5.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog2.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog5ToJog2)
                }else if (binding.radio2Jog3.isChecked) {
                    valor1 = binding.vlJog5.text.toString().toInt()
                    valor2 = binding.vlJog3.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog5.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog3.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog5ToJog3)
                }else if (binding.radio2Jog4.isChecked) {
                    valor1 = binding.vlJog5.text.toString().toInt()
                    valor2 = binding.vlJog4.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog5.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog4.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog5ToJog4)
                }else if (binding.radio2Jog1.isChecked) {
                    valor1 = binding.vlJog5.text.toString().toInt()
                    valor2 = binding.vlJog1.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog5.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog1.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog5ToJog1)
                }else if (binding.radio2Jog6.isChecked) {
                    valor1 = binding.vlJog5.text.toString().toInt()
                    valor2 = binding.vlJog6.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog5.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog6.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog5ToJog6)
                }else if (binding.banco2.isChecked) {
                    valor1 = binding.vlJog5.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    binding.vlJog1.text = (valor1 - valorTransferencia).toString()
                    binding.txtSorte.setText(R.string.jog5ToBanco)
                }else{
                    binding.txtSorte.setText(R.string.semDestino)
                }
            }else if (binding.radio1Jog6.isChecked){
                if (binding.radio2Jog6.isChecked) {
                    binding.txtSorte.setText(R.string.mesmoJogador)
                }else if (binding.radio2Jog2.isChecked) {
                    valor1 = binding.vlJog6.text.toString().toInt()
                    valor2 = binding.vlJog2.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog6.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog2.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog6ToJog2)
                }else if (binding.radio2Jog3.isChecked) {
                    valor1 = binding.vlJog6.text.toString().toInt()
                    valor2 = binding.vlJog3.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog6.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog3.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog6ToJog3)
                }else if (binding.radio2Jog4.isChecked) {
                    valor1 = binding.vlJog6.text.toString().toInt()
                    valor2 = binding.vlJog4.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog6.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog4.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog6ToJog4)
                }else if (binding.radio2Jog5.isChecked) {
                    valor1 = binding.vlJog6.text.toString().toInt()
                    valor2 = binding.vlJog5.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog6.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog5.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog6ToJog5)
                }else if (binding.radio2Jog1.isChecked) {
                    valor1 = binding.vlJog6.text.toString().toInt()
                    valor2 = binding.vlJog1.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog6.text = (valor1 - valorTransferencia).toString()
                    binding.vlJog1.text = soma.toString()
                    binding.txtSorte.setText(R.string.jog6ToJog1)
                }else if (binding.banco2.isChecked) {
                    valor1 = binding.vlJog6.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    binding.vlJog6.text = (valor1 - valorTransferencia).toString()
                    binding.txtSorte.setText(R.string.jog6ToBanco)
                }else{
                    binding.txtSorte.setText(R.string.semDestino)
                }
            }else if (binding.banco1.isChecked){
                if (binding.banco2.isChecked) {
                    binding.txtSorte.setText(R.string.mesmoJogador)
                }else if (binding.radio2Jog2.isChecked) {
                    valor2 = binding.vlJog2.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog2.text = soma.toString()
                    binding.txtSorte.setText(R.string.bancoToJog2)
                }else if (binding.radio2Jog3.isChecked) {
                    valor2 = binding.vlJog3.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog3.text = soma.toString()
                    binding.txtSorte.setText(R.string.bancoToJog3)
                }else if (binding.radio2Jog4.isChecked) {
                    valor2 = binding.vlJog4.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog4.text = soma.toString()
                    binding.txtSorte.setText(R.string.bancoToJog4)
                }else if (binding.radio2Jog5.isChecked) {
                    valor2 = binding.vlJog5.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog5.text = soma.toString()
                    binding.txtSorte.setText(R.string.bancoToJog5)
                }else if (binding.radio2Jog6.isChecked) {
                    valor2 = binding.vlJog6.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog6.text = soma.toString()
                    binding.txtSorte.setText(R.string.bancoToJog6)
                }else if (binding.radio2Jog1.isChecked) {
                    valor2 = binding.vlJog1.text.toString().toInt()
                    valorTransferencia = binding.editValor.text.toString().toInt()
                    soma = valor2 + valorTransferencia
                    binding.vlJog1.text = soma.toString()
                    binding.txtSorte.setText(R.string.bancoToJog1)
                }else{
                    binding.txtSorte.setText(R.string.semDestino)
                }
            }else{binding.txtSorte.setText(R.string.semEmissor)}
        }
    }
}