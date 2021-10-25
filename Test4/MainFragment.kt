package com.example.assesment4

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.assesment4.databinding.FragmentMainBinding


class MainFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentMainBinding
    private val args : MainFragmentArgs by navArgs()
   // val dt : List<ItemData> = List<ItemData>(10)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(
            inflater,
            container,
            false
        )
        //dt.add(ItemData(args.name,args.date,args.price))
        val dataSource = listOf(
            ItemData("Abc", "11:00", "10"),
            ItemData("Pqr", "11:15", "10"),
            ItemData("Lmn", "12:15", "10"),
            ItemData("Tuv", "12:30", "10"),
        )

//        var dataSource = homeViewModel.data.value
//       homeViewModel.text.observe(viewLifecycleOwner, Observer {
//
//        })
        val linearLayoutManager = LinearLayoutManager(requireContext())
        val adapter = HomeAdopter(
            requireContext(),
            dataSource
        )
        binding.recView.layoutManager = linearLayoutManager
        binding.recView.adapter = adapter
        binding.recView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                linearLayoutManager.orientation
            )
        )
        adapter.clkPos.observe(viewLifecycleOwner) {
            val item = dataSource[it]
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToDetailsFragment(item.name.toString(),item.time.toString(),item.price.toString()))
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}