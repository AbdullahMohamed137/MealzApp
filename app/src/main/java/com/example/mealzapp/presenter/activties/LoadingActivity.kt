package com.example.mealzapp.presenter.activties

import android.content.Intent
import android.graphics.Color
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.mealzapp.MainActivity
import com.example.mealzapp.databinding.ActivityLoadingBinding
import dagger.hilt.android.AndroidEntryPoint

@Suppress("DEPRECATION")
@AndroidEntryPoint
class LoadingActivity : AppCompatActivity() {
    private lateinit var i: Intent
    private lateinit var binding: ActivityLoadingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoadingBinding.inflate(layoutInflater)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding.root)

        val cm = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting

        if (isConnected) {
            Handler().postDelayed(Runnable {
                binding.idPBLoading.visibility = View.INVISIBLE
                binding.btnLoad.setBackgroundColor(Color.parseColor("#FF05C46B"))
                binding.btnLoad.isEnabled = true
            }, 2000)
        } else {
            Handler().postDelayed(Runnable {
                i = Intent(this, NoInternetActivity::class.java)
                startActivity(i)
                finish()
            }, 2000)
        }
        binding.btnLoad.setOnClickListener(View.OnClickListener {
            i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        })

    }
}