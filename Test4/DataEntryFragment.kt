package com.example.assesment4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.assesment4.databinding.FragmentDataEntryBinding

class DataEntryFragment : Fragment() {
    private lateinit var binding : FragmentDataEntryBinding
    //private val args : SpecifyAmountFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
        binding = FragmentDataEntryBinding.inflate(
            inflater,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navCon = findNavController()

        //binding.textView5.text = "Sending Money to ${args.nm}"
        binding.btnSave.setOnClickListener {
            val n = binding.editNAme.text.toString()
            val amount = binding.editPrice.text.toString().toInt()
            val dt = binding.editDate.text.toString()

            val action = DataEntryFragmentDirections.actionDataEntryFragmentToMainFragment(name = n, price = amount,date = dt)

            navCon.navigate(action)

        }

    }

}