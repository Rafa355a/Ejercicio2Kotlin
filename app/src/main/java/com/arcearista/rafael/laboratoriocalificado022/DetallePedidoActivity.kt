package com.arcearista.rafael.laboratoriocalificado022
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.arcearista.rafael.laboratoriocalificado022.databinding.ActivityDetallePedidoBinding
class DetallePedidoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetallePedidoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallePedidoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val nombreCliente = intent.getStringExtra("nombreCliente")
        val numeroCliente = intent.getStringExtra("numeroCliente")
        val productos = intent.getStringExtra("productos")
        val ciudad = intent.getStringExtra("ciudad")
        val direccion = intent.getStringExtra("direccion")
        binding.textNombreCliente.text = "Nombre Cliente: $nombreCliente"
        binding.textNumeroCliente.text = "Número Cliente: $numeroCliente"
        binding.textProductos.text = "Productos: $productos"
        binding.textCiudad.text = "Ciudad: $ciudad"
        binding.textDireccion.text = "Dirección: $direccion"
        binding.btnLlamar.setOnClickListener {
            val intentLlamar = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$numeroCliente"))
            startActivity(intentLlamar)
        }
        binding.btnWhatsapp.setOnClickListener {
            val intentWhatsapp = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("https://wa.me/$numeroCliente")
            }
            startActivity(intentWhatsapp)
        }
        binding.btnMaps.setOnClickListener {
            val direccionMapa = Uri.parse("geo:0,0?q=$direccion+$ciudad")
            val intentMaps = Intent(Intent.ACTION_VIEW, direccionMapa)
            startActivity(intentMaps)
        }
    }
}

