package com.learn.rva.presentation.view

import android.graphics.Color
import android.os.Bundle
import android.text.InputFilter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.learn.rva.data.model.Model
import com.learn.rva.databinding.ActivityMainBinding
import com.learn.rva.presentation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
        initObserver()
        initMainUi()
    }

    private fun initObserver() {
        mainViewModel.IsDateValid.observe(this) {
            if (it) {
                Snackbar.make(
                    binding.root,
                    "detail Submitted successfully",
                    Snackbar.LENGTH_SHORT
                ).show()
                Toast.makeText(
                    this@MainActivity, "detail Submitted successfully", Toast.LENGTH_SHORT
                ).show()
            } else {
                    Snackbar.make(
                        binding.root,
                        "A person can be in range between 18 to 70",
                        Snackbar.LENGTH_SHORT
                    ).show()
                    Toast.makeText(
                        this@MainActivity,
                        "A person can be in range between 18 to 70",
                        Toast.LENGTH_SHORT
                    ).show()
                }

        }
    }

    private fun initMainUi() {
        binding.apply {
            dontHavePant.setOnClickListener {
                finish()
            }
            editPanCard.filters = editPanCard.filters + InputFilter.AllCaps()

            editPanCard.addTextChangedListener {
                activateAndDeactivateButton()
            }
            day.addTextChangedListener {
                activateAndDeactivateButton()
            }
            month.addTextChangedListener {
                activateAndDeactivateButton()
            }
            year.addTextChangedListener {
                activateAndDeactivateButton()
            }
        }

    }

    private fun activateAndDeactivateButton() {
        binding.apply {
            if (editPanCard.text?.isEmpty()?.not() == true && day.text?.isEmpty()
                    ?.not() == true && month.text?.isEmpty()?.not() == true && year.text?.isEmpty()
                    ?.not() == true && editPanCard.text.toString().length == 10 &&
                day.text.toString().length == 2 && month.text.toString().length == 2 &&
                year.text.toString().length == 4
            ) {
                but.isClickable = true
                but.setBackgroundColor(Color.parseColor("#0000ff"));
                but.setOnClickListener {
                    mainViewModel.validateBirthDate(
                        Model(
                            day.text.toString().toInt(),
                            month.text.toString().toInt(),
                            year.text.toString().toInt()
                        )
                    )
                }


            } else {
                but.setBackgroundColor(Color.parseColor("#e0e0e0"));
                but.isClickable = false
            }
        }
    }

}