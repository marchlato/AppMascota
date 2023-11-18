package com.example.appmascotas.vista.fragment;


import com.example.appmascotas.Mascota;
import com.example.appmascotas.adapter.MascotaAdaptador;

import java.util.ArrayList;

public interface IRecyclerViewMascota {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador(MascotaAdaptador adaptador);

}
