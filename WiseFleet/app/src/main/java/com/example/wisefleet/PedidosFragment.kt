package com.example.wisefleet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.wisefleet.backend.apis.ApiPedidos
import com.example.wisefleet.backend.apis.ApiService
import com.example.wisefleet.backend.dataobjects.Pedidos
import com.example.wisefleet.backend.dataobjects.Usuario
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class PedidosFragment(usuariox: Usuario) : Fragment() {

    private var usuario: Usuario = usuariox
    private lateinit var pedidos: List<Pedidos>
    private var apiService = ApiService()
    private lateinit var apiPedidos: ApiPedidos;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        GlobalScope.launch(Dispatchers.IO) {
            try{
                apiPedidos = apiService.conectarApiPedidos();
                pedidos = apiPedidos.getPedidosUsuario("eq."+usuario.idempleadofk, apiService.apiKey)
                //pedidos = apiPedidos.getPedidos(apiService.apiKey)
                println(pedidos)
            }catch (error: Exception){
                println("HA OCURRIDO UN ERROR AL CONECTAR CON LA API DE PEDIDOS")
                error.printStackTrace()
            }
        }


        return inflater.inflate(R.layout.fragment_pedidos, container, false)
    }

}