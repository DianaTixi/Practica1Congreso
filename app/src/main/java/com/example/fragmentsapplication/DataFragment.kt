package com.example.fragmentsapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.fragmentsapplication.databinding.FragmentDataBinding
//import com.example.fragmentsapplication.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [DataFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DataFragment : Fragment() {

    private  lateinit var binding:FragmentDataBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_data,container, false)

        val args: DataFragmentArgs by this.navArgs()
        //binding.editTextTextPersonName2.setText(args.nombre)

        /*binding.button2.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_dataFragment_to_homeFragment)

        }*/


        return binding.root
    }

}