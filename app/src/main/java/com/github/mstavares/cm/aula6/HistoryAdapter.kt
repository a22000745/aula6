package com.github.mstavares.cm.aula6

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.mstavares.cm.aula6.databinding.ItemExpressionBinding

class HistoryAdapter(private val onOperationClick:(String)-> Unit,private var items: List<OperationUi> = listOf()) :
    RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    class HistoryViewHolder(val binding: ItemExpressionBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemExpressionBinding.inflate(
                LayoutInflater.from(parent.context),parent,false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onOperationClick(items[position].holeThing)
        }
        holder.binding.textExpression.text = items[position].expression
        holder.binding.textResult.text = items[position].result
    }

    override fun getItemCount() = items.size

    fun updateItems(items: List<OperationUi>) {
        this.items = items
        notifyDataSetChanged()
    }
}