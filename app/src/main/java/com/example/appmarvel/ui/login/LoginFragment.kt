package com.example.appmarvel.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.appmarvel.MainActivity
import com.example.appmarvel.R
import com.example.appmarvel.databinding.LoginFragmentBinding
import com.example.appmarvel.model.Result
import com.example.appmarvel.ui.clickImage.ClickImageFragment
import com.squareup.picasso.Picasso

class LoginFragment : Fragment(){

//    val buttonLogin by lazy { view?.findViewById<Button>(R.id.btn_login) }

//    companion object {
//        fun newInstance() = LoginFragment()
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                          savedInstanceState: Bundle?): View {

    val binding = LoginFragmentBinding.inflate(inflater, container, false)

    val navController = findNavController()

    binding.btnLogin.setOnClickListener {
        navController.navigate(R.id.action_loginFragment_to_listComicsFragment)
        }

    return binding.root
    }


//        return inflater.inflate(R.layout.login_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


//     buttonLogin?.setOnClickListener {
//         navController.navigate(R.id.action_loginFragment_to_listComicsFragment)
////         val intent = Intent(it.context, MainActivity::class.java)
////         activity?.startActivity(intent)
//        }

    }
}










