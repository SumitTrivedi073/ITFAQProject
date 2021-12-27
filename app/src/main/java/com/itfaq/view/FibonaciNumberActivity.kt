package com.itfaq.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.itfaq.R

class FibonaciNumberActivity : AppCompatActivity() {
	
	private var fibonacNumber: EditText? = null
	private var applyBtn: TextView? = null
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_fibonacci_number)
		
		fibonacNumber = findViewById(R.id.fibonacNumber)
		
		applyBtn = findViewById(R.id.applyBtn);
		
		with(applyBtn) {
			this?.setOnClickListener {
				getFibonacNumber();
			}
		}
	}
	
	private fun getFibonacNumber() {
		val stringOne: String = fibonacNumber?.text.toString()
		if (stringOne.isEmpty()) {
			fibonacNumber?.error = getString(R.string.fill_all_field)
			fibonacNumber?.requestFocus()
			return
		} else {
			fibonacNumber?.error = null
		}
		println("fibonacci Recursive Number=======>"+getFibonacciRecursive(stringOne.toInt()))
		println("getFibonacci Iterative Number=======>"+getFibonacciIterative(stringOne.toLong()))
	}
	
	
	private fun getFibonacciRecursive(count: Int, first: Int = 0, second: Int = 1, result: MutableList<Int> = mutableListOf()): MutableList<Int> {
		return if (count > 0) {
			result.add(first)
			getFibonacciRecursive(count - 1, second, first + second, result)
		} else {
			result
		}
	}
	
	
	private fun getFibonacciIterative(n: Long): Long {
		if (n < 2) return n
		var minusOne: Long = 1
		var minusTwo: Long = 0
		var result = minusOne
		for (i in 2..n) {
			result = minusOne + minusTwo
			minusTwo = minusOne
			minusOne = result
		}
		return result
	}
	
	
}