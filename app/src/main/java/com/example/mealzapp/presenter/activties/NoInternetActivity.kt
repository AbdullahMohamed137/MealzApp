package com.example.mealzapp.presenter.activties

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mealzapp.MainActivity
import com.example.mealzapp.databinding.ActivityNoInternetBinding
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")
@AndroidEntryPoint
class NoInternetActivity : AppCompatActivity() {
    private lateinit var intent: Intent
    private lateinit var binding : ActivityNoInternetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoInternetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Toast.makeText(this, "Check Connection", Toast.LENGTH_SHORT).show()

        binding.btnRefresh.setOnClickListener {
            val cm =
                getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            val isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting
            if (isConnected) {
                Handler().postDelayed(Runnable {
                    intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }, 20)
            } else {
                Toast.makeText(this,"No Internet", Toast.LENGTH_SHORT).show()
            }
        }
    }
}