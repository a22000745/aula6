package com.github.mstavares.cm.aula6

import net.objecthunter.exp4j.ExpressionBuilder

class Calculator {
    var display: String = "0"
    private val history = mutableListOf<Operation>()

    fun insertSymbol(symbol:String): String {
        if (display == "0") {
            display = symbol
        } else {
            display += symbol
        }
        return  display
    }
    fun performOperation(): Double {
        val expressionBuilder = ExpressionBuilder(display).build()
        val result = expressionBuilder.evaluate()
        history.add(Operation(display,result))
        display = result.toString()
        CoroutineScope(Dispatchers.IO).launch {
            addToHistory(display, result)
        }
        return result
    }
    suspend fun addToHistory(expression: String, result:Double){
        Thread.sleep((30*1000).toLong())
        history.add(Operation(expression,result))
    }
}