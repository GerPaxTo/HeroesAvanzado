package com.gerpax.heroesavanzado.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.gerpax.heroesavanzado.R
import com.gerpax.heroesavanzado.data.Remote.LoginApi
import com.gerpax.heroesavanzado.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit

@AndroidEntryPoint
class LoginFragment : Fragment() {
    var email : String = ""
    var password: String = ""
    var Token = ""

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

        email = binding.textemail.text.toString()
        password = binding.txPassword.text.toString()

        binding.btLogin.setOnClickListener {
            if (email.isNotEmpty()) {
                if (password.isNotEmpty()) {
                    Token = viewModel.ExecuteLogin(email, password)
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