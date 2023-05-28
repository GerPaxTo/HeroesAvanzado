package com.gerpax.heroesavanzado.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.gerpax.heroesavanzado.databinding.FragmentHeroListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

@AndroidEntryPoint
class
HeroListFragment : Fragment() {

    private var _binding: FragmentHeroListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: SuperHeroViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHeroListBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = HeroeListaAdapter(){
            findNavController().navigate(
                HeroListFragmentDirections.actionListFragmentToDetailFragment(it)
            )
        }

        binding.superheroList.adapter = adapter
        viewModel.getHeros()

        viewModel.heros.observe(viewLifecycleOwner) { heros ->
            adapter.submitList(heros)}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}