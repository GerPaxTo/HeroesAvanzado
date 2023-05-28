package com.gerpax.heroesavanzado.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gerpax.heroesavanzado.R
import com.gerpax.heroesavanzado.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {
    var email : String = ""
    var password: String = ""
    var token = ""

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btLogin.setOnClickListener {
            email = binding.txUser.text.toString()
            password = binding.txPassword.text.toString()
            println("$email, $password")

            if (email.isNotEmpty()) {
                if (password.isNotEmpty()) {
                    token = viewModel.executeLogin(email, password)
                    println("token $token")
                }
            }
            findNavController().navigate(R.id.HeroListFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}