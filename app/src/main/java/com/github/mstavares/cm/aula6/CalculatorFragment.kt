package com.github.mstavares.cm.aula6

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.mstavares.cm.aula6.databinding.FragmentCalculatorBinding
import net.objecthunter.exp4j.ExpressionBuilder

class CalculatorFragment : Fragment() {

    private lateinit var binding: FragmentCalculatorBinding
    private val operations = mutableListOf<String>()
    private val adapter = HistoryAdapter(::onOperationsClick)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.calculator)
        val view = inflater.inflate(R.layout.fragment_calculator, container, false)
        binding = FragmentCalculatorBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.button0.setOnClickListener { onClickSymbol("0") }
        binding.button1.setOnClickListener { onClickSymbol("1") }
        binding.button2.setOnClickListener { onClickSymbol("2") }
        binding.button3.setOnClickListener { onClickSymbol("3") }
        binding.button4.setOnClickListener { onClickSymbol("4") }
        binding.button5.setOnClickListener { onClickSymbol("5") }
        binding.button6.setOnClickListener { onClickSymbol("6") }
        binding.button7.setOnClickListener { onClickSymbol("7") }
        binding.button8.setOnClickListener { onClickSymbol("8") }
        binding.button9.setOnClickListener { onClickSymbol("9") }
        binding.buttonDot.setOnClickListener { onClickSymbol(".") }
        binding.buttonAdition.setOnClickListener { onClickSymbol("+") }
        binding.buttonMultiply.setOnClickListener { onClickSymbol("*") }
        binding.buttonDevide.setOnClickListener { onClickSymbol("/") }
        binding.buttonEquals.setOnClickListener { onClickEquals() }
        binding.rvHistoric?.layoutManager = LinearLayoutManager(activity as Context)
        binding.rvHistoric?.adapter = adapter

    }

    private fun onClickSymbol(symbol: String) {
        if (binding.textVisor.text == "0") {
            binding.textVisor.text = symbol
        } else {
            binding.textVisor.append(symbol)
        }
    }

    private fun onClickEquals(){
        val textVisorData = binding.textVisor.text.toString()
        var resultado = textVisorData
        val expression = ExpressionBuilder(textVisorData).build()
        val result = expression.evaluate().toString()
        resultado += "=${result}"
        operations.add(resultado)
        adapter.updateItems(operations)
        binding.textVisor.text = result
    }
    private fun onOperationsClick(operation:String){
        Toast.makeText(activity as Context, operation,Toast.LENGTH_LONG).show()
    }
}