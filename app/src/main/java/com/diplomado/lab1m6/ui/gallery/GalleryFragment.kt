package com.diplomado.lab1m6.ui.gallery

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.diplomado.lab1m6.databinding.FragmentGalleryBinding



class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(


        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.tvNombre
        val email: EditText = binding.tvCorreo
        val clave: TextView = binding.tvClave

        val btnReg: Button = binding.btnReg

        btnReg.setOnClickListener { view ->
            if(validaEmail(email.text.toString())) {
                mensaje("Email Correcto")
            }
            else
            {mensaje("El email No tiene el formato adecuado")}
            if( validaClave(clave.text.toString()) ){
                mensaje("Clave Correcta")
            }
            else
            {mensaje("La Clave debe contener al menos 6 caracteres, una letra y un número")}
        }



       //galleryViewModel.text.observe(viewLifecycleOwner) {
       //     textView.text = it
       //}
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun clickReg(view: View) {
        val textView: TextView = binding.tvClave
        if (!validaClave(textView.text.toString())){

        }

    }
    fun mensaje(mensaje:String){
        val root: View = binding.root
        Toast.makeText(root.context, mensaje, Toast.LENGTH_SHORT).show()
    }
    fun validaEmail(email: String): Boolean {
        val pattern: String = "^\\w+([\\.-]?\\w+)@\\w+([\\.-]?\\w+)(\\.\\w{2,3})+\$"
        val regExp: Regex = Regex(pattern)
        return regExp.matches(email)
    }

    fun validaClave(password: String): Boolean{
        val pattern: String = "^[a-z0-9]{6}\$"
        val regExp: Regex = Regex(pattern)
        return regExp.matches(password)
    }
}