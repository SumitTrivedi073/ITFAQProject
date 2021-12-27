package com.itfaq.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.itfaq.R

class DashboardActivity : AppCompatActivity() {
	
	private var anagramProgremme: TextView? = null
	private var fibonacciNumberProgramme: TextView? = null
	private var currencyConverter: TextView? = null
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_dashboard)
		
		anagramProgremme = findViewById(R.id.anagramProgremme);
		fibonacciNumberProgramme = findViewById(R.id.fibonacciNumberProgramme);
		currencyConverter = findViewById(R.id.currencyConverter);
		
		with(anagramProgremme) {
			this?.setOnClickListener {
				startActivity(Intent(this@DashboardActivity, AnagramProgrammeActivity::class.java))
			}
		}
		
		with(fibonacciNumberProgramme) {
			this?.setOnClickListener {
				startActivity(Intent(this@DashboardActivity, FibonaciNumberActivity::class.java))
			}
		}
		
		with(currencyConverter) {
			this?.setOnClickListener {
				startActivity(Intent(this@DashboardActivity, MainActivity::class.java))
			}
		}
	}
}