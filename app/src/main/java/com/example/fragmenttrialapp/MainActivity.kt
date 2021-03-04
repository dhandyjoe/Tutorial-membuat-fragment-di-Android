package com.example.fragmenttrialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmenttrialapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var viewPagerAdapter: ViewPagerAdapter = ViewPagerAdapter(getSupportFragmentManager())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tabLayout.setupWithViewPager(binding.viewPager)
        binding.viewPager.setAdapter(viewPagerAdapter)
        binding.viewPager.setCurrentItem(1) // digunakan untuk set first page saat pertama kali aplikasi dibuka
    }
}