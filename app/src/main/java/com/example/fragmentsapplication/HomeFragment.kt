package com.example.fragmentsapplication

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.fragmentsapplication.databinding.FragmentHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private var num1: Double =0.0
    private var num2: Double =0.0
    private var operacion: Int =0 // Indica que no hay operacion
    private var resultado = 0.0

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.boton1.setOnClickListener{botonClick("1")}
        binding.boton2.setOnClickListener{botonClick("2")}
        binding.boton3.setOnClickListener{botonClick("3")}
        binding.boton4.setOnClickListener{botonClick("4")}
        binding.boton5.setOnClickListener{botonClick("5")}
        binding.boton6.setOnClickListener{botonClick("6")}
        binding.boton7.setOnClickListener{botonClick("7")}
        binding.boton8.setOnClickListener{botonClick("8")}
        binding.boton9.setOnClickListener{botonClick("9")}
        binding.boton0.setOnClickListener{botonClick("0")}
        binding.botonDividir.setOnClickListener{realizarOperacion(4)}
        binding.botonMulti.setOnClickListener{realizarOperacion(3)}
        binding.botonResta.setOnClickListener{realizarOperacion(2)}
        binding.botonSuma.setOnClickListener{realizarOperacion(1)}
        binding.boton.setOnClickListener{botonClick(".")}


        // Borras los datos de la pantalla de la calculadora
        binding.botonDelete.setOnClickListener{
            num1=0.0
            num2=0.0
            binding.result.text=""
            operacion= no_operar
        }

        //Obtener el resultado de la operacion
        binding.botonIgual.setOnClickListener{
            var resultado = when(operacion){
                suma -> num1+num2
                resta -> num1-num2
                multi -> num1*num2
                dividir -> num1/num2
                else -> 0
            }
            binding.result.text = resultado.toString()

        }
        setHasOptionsMenu(true)

        return binding.root

    }


    private fun botonClick(digito:String){

        binding.result.text = "${binding.result.text}$digito"
        if (operacion == no_operar){
            num1= binding.result.text.toString().toDouble()

        }else{
            num2= binding.result.text.toString().toDouble()
        }
    }

    private fun realizarOperacion(operacion: Int){
        this.operacion = operacion
        binding.result.text=""
    }
    companion object {
        const val suma = 1
        const val resta = 2
        const val multi = 3
        const val dividir = 4
        const val no_operar = 0

        /*binding.button.setOnClickListener { view: View ->
            //view.findNavController().navigate(R.id.action_homeFragment_to_dataFragment)
            view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDataFragment())
        }*/

    }

    // Vamos a relacionar nuestra parte del menu que creamos
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        // el signo de ? sirve para el control de excepciones es como un try-catch embebido
        inflater?.inflate(R.menu.home_menu, menu)
    }

    // Cuando relacione con una de esas dos opciones relacione con el navigation controller
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            requireView().findNavController()) || super.onOptionsItemSelected(item)
    }


}