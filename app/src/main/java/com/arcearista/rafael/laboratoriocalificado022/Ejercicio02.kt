package com.arcearista.rafael.laboratoriocalificado022

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arcearista.rafael.laboratoriocalificado022.databinding.ActivityEjercicio02Binding

class Ejercicio02 : AppCompatActivity() {
    private lateinit var binding: ActivityEjercicio02Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEjercicio02Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegistrar.setOnClickListener {
            val nombreCliente = binding.editNombreCliente.text.toString()
            val numeroCliente = binding.editNumeroCliente.text.toString()
            val productos = binding.editProductos.text.toString()
            val ciudad = binding.editCiudad.text.toString()
            val direccion = binding.editDireccion.text.toString()

            val intent = Intent(this, DetallePedidoActivity::class.java).apply {
                putExtra("nombreCliente", nombreCliente)
                putExtra("numeroCliente", numeroCliente)
                putExtra("productos", productos)
                putExtra("ciudad", ciudad)
                putExtra("direccion", direccion)
            }
            startActivity(intent)
        }
    }
}
