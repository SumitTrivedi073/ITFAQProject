package com.itfaq.view

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.itfaq.R
import java.util.*

class AnagramProgrammeActivity : AppCompatActivity() {
	
	private var valueOne: EditText? = null
	private var valueTwo: EditText? = null
	private var applyBtn: TextView? = null
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_anagram_programme)
		
		init()
	}
	fun init(){
		valueOne = findViewById(R.id.valueOne)
		valueTwo = findViewById(R.id.valueTwo);
		applyBtn = findViewById(R.id.applyBtn);
		
		with(applyBtn) {
			this?.setOnClickListener {
				anagramApply()
			}
		}
	}
	private fun anagramApply() {
		val stringOne: String = valueOne?.text.toString()
		if (stringOne.isEmpty()) {
			valueOne?.error = getString(R.string.fill_all_field)
			valueOne?.requestFocus()
			return
		} else {
			valueOne?.error = null
		}
		val StringTwo: String = valueTwo?.text.toString()
		if (StringTwo.isEmpty()) {
			valueTwo?.error = getString(R.string.fill_all_field)
			valueTwo?.requestFocus()
			return
		} else {
			valueTwo?.error = null
		}
		isAnagram(stringOne, StringTwo)
	}
	fun isAnagram(str1: String, str2: String) {
		val s1 = str1.replace("\\s".toRegex(), "")
		val s2 = str2.replace("\\s".toRegex(), "")
		var status = true
		status = if (s1.length != s2.length) {
			false
		} else {
			val ArrayS1 = s1.toLowerCase(Locale.getDefault()).toCharArray()
			val ArrayS2 = s2.toLowerCase(Locale.getDefault()).toCharArray()
			Arrays.sort(ArrayS1)
			Arrays.sort(ArrayS2)
			Arrays.equals(ArrayS1, ArrayS2)
		}
		if (status) {
			Toast.makeText(this,"$s1 and $s2 are anagrams",Toast.LENGTH_LONG).show()
			println("$s1 and $s2 are anagrams")
		} else {
			Toast.makeText(this,"$s1 and $s2 are not anagrams",Toast.LENGTH_LONG).show()
			println("$s1 and $s2 are not anagrams")
		}
	}
	
	override fun onBackPressed() {
		finish()
		super.onBackPressed()
	}
}