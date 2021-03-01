package com.example.fragmenttrialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmenttrialapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contactFragment = ContactFragment()
        val messageFragment = MessageFragment()
        val statusFragment = StatusFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, contactFragment)
            commit()
        }

        binding.btnContact.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, contactFragment)

                // function addToBackStack digunakan untuk menambah stack pada aplikasi
                addToBackStack(null)
                commit()
            }
        }

        binding.btnMessage.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, messageFragment)
                addToBackStack(null)
                commit()
            }
        }

        binding.btnStatus.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, statusFragment)
                addToBackStack(null)
                commit()
            }
        }
    }
}