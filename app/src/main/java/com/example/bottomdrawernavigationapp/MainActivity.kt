package com.example.bottomdrawernavigationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bnvInicio:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var inicioFragment = InicioFragment()
        var mensajesFragment = MensajesFragment()
        var perfilFragment = PerfilFragment()

        setFragmentoActual(inicioFragment)

        bnvInicio = findViewById(R.id.bnv_Menu)

        bnvInicio.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.miInicio->{
                    setFragmentoActual(inicioFragment)
                }
                R.id.miMensajes->{
                    setFragmentoActual(mensajesFragment)
                }
                R.id.miPerfil->{
                    setFragmentoActual(perfilFragment)
                }
            }
        }
    }

    private fun setFragmentoActual(fragment: Fragment) = supportFragmentManager.beginTransaction().apply {
        replace(R.id.fl_Fragmento, fragment)
        commit()
    }
}