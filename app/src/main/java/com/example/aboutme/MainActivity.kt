package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnDone.setOnClickListener{
            addNickname(it)
        }

        binding.tvNicknameText.setOnClickListener {
            updateNickname(it)
        }
    }


    private fun addNickname(view: View) {

        binding.tvNicknameText.apply {
            text = binding.etNickname.text
            visibility = View.VISIBLE
        }
        binding.etNickname.visibility = View.GONE
        view.visibility = View.GONE

        //Para ocultar el teclado
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


    private fun updateNickname (view: View) {

        binding.etNickname.apply {
            visibility = View.VISIBLE
            requestFocus()
            text.clear()
        }
        binding.btnDone.visibility = View.VISIBLE
        view.visibility = View.GONE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.etNickname, 0)

    }
}