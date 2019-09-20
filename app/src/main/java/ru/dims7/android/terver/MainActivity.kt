package ru.dims7.android.terver

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    companion object {
        private const val KEY_RESULT = "key_result"
    }

    lateinit var editTextN: EditText
    lateinit var editTextK: EditText

    lateinit var btnA: Button
    lateinit var btnC: Button
    lateinit var btnP: Button

    lateinit var checkBoxRepeats: CheckBox

    lateinit var textResult: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        fun checkN(): Boolean {
            if (editTextN.text.toString() == "") {
                Toast.makeText(applicationContext, R.string.fieldPEmpty, Toast.LENGTH_SHORT).show()
                return false
            }
            try {
                editTextN.text.toString().toInt()
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, R.string.wrongFormatN, Toast.LENGTH_SHORT).show()
                return false
            }
            if (editTextN.text.toString().toInt() <= 0) {
                Toast.makeText(applicationContext, R.string.nMustBePositive, Toast.LENGTH_SHORT)
                    .show()
                return false
            }
            return true
        }

        fun checkNK(): Boolean {
            if (!checkN()) return false

            if (editTextK.text.toString() == "") {
                Toast.makeText(applicationContext, R.string.fieldKEmpty, Toast.LENGTH_SHORT).show()
                return false
            }
            try {
                editTextK.text.toString().toInt()
            } catch (e: NumberFormatException) {
                Toast.makeText(applicationContext, R.string.wrongFormatK, Toast.LENGTH_SHORT).show()
                return false
            }
            if (editTextK.text.toString().toInt() < 0) {
                Toast.makeText(applicationContext, R.string.kMustBeNonNegative, Toast.LENGTH_SHORT)
                    .show()
                return false
            }
            if (editTextK.text.toString().toInt() > editTextN.text.toString().toInt()) {
                Toast.makeText(applicationContext, R.string.exceptionKMoreThanN, Toast.LENGTH_SHORT)
                    .show()
                return false
            }
            return true
        }

        fun getN() = editTextN.text.toString().toInt()
        fun getK() = editTextK.text.toString().toInt()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editTextK = findViewById(R.id.editText_k)
        editTextN = findViewById(R.id.editText_n)
        btnP = findViewById(R.id.btn_p)
        btnA = findViewById(R.id.btn_a)
        btnC = findViewById(R.id.btn_c)
        checkBoxRepeats = findViewById(R.id.checkBox_repeats)
        textResult = findViewById(R.id.text_result)

        textResult.setText(savedInstanceState?.getString(KEY_RESULT, "") ?: "")

        btnP.setOnClickListener { _ ->
            if (checkN()) {
                if (checkBoxRepeats.isChecked)
                    Toast.makeText(
                        applicationContext,
                        R.string.pWithRepeatsNotWork,
                        Toast.LENGTH_SHORT
                    ).show()
                else
                    textResult.setText(pWithoutRepeats(getN()).toReadable())
            }
        }

        btnA.setOnClickListener { _ ->
            if (checkNK()) {
                textResult.setText(
                    when (checkBoxRepeats.isChecked) {
                        true -> aWithRepeats(getN(), getK()).toReadable()
                        false -> aWithoutRepeats(getN(), getK()).toReadable()
                    }.toString()
                )
            }
        }

        btnC.setOnClickListener { _ ->
            if (checkNK()) {
                textResult.setText(
                    when (checkBoxRepeats.isChecked) {
                        true -> cWithRepeats(getN(), getK()).toReadable()
                        false -> cWithoutRepeats(getN(), getK()).toReadable()
                    }.toString()
                )
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_RESULT, textResult.text.toString())
    }

}