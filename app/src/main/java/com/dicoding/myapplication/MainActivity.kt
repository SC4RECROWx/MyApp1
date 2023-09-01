package com.dicoding.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtWidth: EditText
    private lateinit var edtHeight: EditText
    private lateinit var edtLength: EditText
    private lateinit var BtnCalculate: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        edtHeight = findViewById(R.id.edt_Height)
        edtLength = findViewById(R.id.edt_length)
        edtWidth = findViewById(R.id.edt_width)
        BtnCalculate = findViewById(R.id.btn_calculate)
        tvResult = findViewById(R.id.tv_result)
        BtnCalculate.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvResult.text.toString())
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.btn_calculate){
            val inputLength = edtLength.text.toString().trim()
            val inputWidth = edtWidth.text.toString().trim()
            val inputHeight = edtHeight.text.toString().trim()
            var isEmptyFields = false
            if (inputHeight.isEmpty()){
                isEmptyFields = true
                edtHeight.error = "Field ini tidak boleh Kosong"
            }
            if (inputLength.isEmpty()){
                isEmptyFields = true
                edtLength.error = "Field ini tidak boleh Kosong"
            }
            if (inputWidth.isEmpty()){
                isEmptyFields = true
                edtWidth.error = "Field ini tidak boleh Kosong"
            }
            if (!isEmptyFields) {
                val volume = inputHeight.toDouble() * inputLength.toDouble() * inputWidth.toDouble()
                tvResult.text = volume.toString()
            }
        }
    }
}