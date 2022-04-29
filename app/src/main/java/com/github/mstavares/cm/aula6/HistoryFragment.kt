package com.github.mstavares.cm.aula6

import android.media.VolumeShaper
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.github.mstavares.cm.aula6.databinding.FragmentCalculatorBinding
import com.github.mstavares.cm.aula6.databinding.FragmentHistoryBinding

var ARG_OPERATIONS = ""

class HistoryFragment : Fragment() {

    private var operations = ArrayList<Parcelable>()
    private lateinit var binding: FragmentHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            operations = it.getParcelableArrayList(ARG_OPERATIONS)!!
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        (requireActivity() as AppCompatActivity).supportActionBar?.title = getString(R.string.history)
        val view = inflater.inflate(R.layout.fragment_history, container, false)
        binding = FragmentHistoryBinding.bind(view)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.getHistory({ history
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(operations: ArrayList<OperationUi>) =
            HistoryFragment().apply {
                arguments = Bundle().apply {
                    putParcelableArrayList(ARG_OPERATIONS, operations)
                }
            }
    }
}