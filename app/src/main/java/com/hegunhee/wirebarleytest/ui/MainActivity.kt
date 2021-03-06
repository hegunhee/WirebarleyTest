package com.hegunhee.wirebarleytest.ui

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.hegunhee.wirebarleytest.R
import com.hegunhee.wirebarleytest.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            viewmodel = viewModel
            lifecycleOwner = this@MainActivity
        }
        viewModel.initData()
        observingSwitch()
    }

    private fun observingSwitch() = viewModel.event.observe(this) {
        when (it) {
            is Event.Uninitalized -> {

            }
            is Event.Clicked -> {
                setCountry()
            }

        }
    }

    private fun setCountry() {
        val countryArray = arrayOf<String>("한국(KRW)", "일본(JPY)", "필리핀(PHP)")
        AlertDialog.Builder(this)
            .setTitle("나라를 선택하세요")
            .setItems(countryArray,
                DialogInterface.OnClickListener { _, which ->
                    viewModel.country = when (which) {
                        0 -> Country.Korea
                        1 -> Country.Japan
                        2 -> Country.Philippines
                        else -> Country.Korea
                    }
                    viewModel.changeData()
                }
            ).create().show()

    }

}