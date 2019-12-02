package com.example.androidqrcodereader

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.zxing.integration.android.IntentIntegrator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpListener()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        IntentIntegrator.parseActivityResult(requestCode, resultCode, data)?.let { result ->
            Toast.makeText(this, result.contents, Toast.LENGTH_SHORT).show()
        }

    }

    private fun setUpListener() {
        startButton.setOnClickListener {
            startQRCodeReader()
        }
    }

    private fun startQRCodeReader() {
        IntentIntegrator(this).apply {
            setBeepEnabled(false)
        }.initiateScan()
    }
}
