package com.github.mstavares.cm.aula6

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mstavares.cm.aula6.databinding.FragmentCalculatorBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.time.*
import java.time.format.DateTimeFormatter

class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding
    private lateinit var viewModel: CalculatorViewModel
    private val adapter = HistoryAdapter(::onOperationsClick)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.calculator)
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)
        binding = FragmentCalculatorBinding.bind(view)
        return binding.root
    }
    override fun onCreateView(): LinearLayout{
        val view = inflater.inflate(
            R.layout.fragment_calculator, container, false
        )
        binding = FragmentCalculatorBinding.bind(view)
        viewModel = ViewModelProvider(this).get(CalculatorViewModel::class.java)
        binding.textVisor.text = viewModel.getDisplayValue()
        return binding.root
    }
    override fun onStart() {
        super.onStart()
        binding.button0.setOnClickListener { viewModel.onClickSymbol("0") }
        binding.button1.setOnClickListener { viewModel.onClickSymbol("1") }
        binding.button2.setOnClickListener { viewModel.onClickSymbol("2") }
        binding.button3.setOnClickListener { viewModel.onClickSymbol("3") }
        binding.button4.setOnClickListener { viewModel.onClickSymbol("4") }
        binding.button5.setOnClickListener { viewModel.onClickSymbol("5") }
        binding.button6.setOnClickListener { viewModel.onClickSymbol("6") }
        binding.button7.setOnClickListener { viewModel.onClickSymbol("7") }
        binding.button8.setOnClickListener { viewModel.onClickSymbol("8") }
        binding.button9.setOnClickListener { viewModel.onClickSymbol("9") }
        binding.buttonDot.setOnClickListener { viewModel.onClickSymbol(".") }
        binding.buttonAdition.setOnClickListener { viewModel.onClickSymbol("+") }
        binding.buttonMultiply.setOnClickListener { viewModel.onClickSymbol("*") }
        binding.buttonDevide.setOnClickListener { viewModel.onClickSymbol("/") }
        binding.buttonEquals.setOnClickListener { viewModel.onClickEquals() }
        binding.rvHistoric?.layoutManager = LinearLayoutManager(activity as Context)
        binding.rvHistoric?.adapter = adapter

    }

    private fun onOperationsClick(operation:String){
        Toast.makeText(activity as Context, operation,Toast.LENGTH_LONG).show()
    }
}