package com.github.mstavares.cm.aula6

import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    private val model = Calculator()
    fun getDisplayValue() = model.display
    fun onClickSymbol(symbol:String) : String{
        return model.insertSymbol(symbol)
    }
    fun onClickEquals() : String{
        val result = model.performOperation()
        return result.toString()
    }
    fun getHistory(callback:(List<OperationUi>) -> Unit){
        val history = model.getHistory({operations -> operations.map {
                OperationUi(it.expression, it.result, it.timestamp)
            })
        CoroutineScope(Dispatchers.Main).launch {callback(history)}
        }
    }
}