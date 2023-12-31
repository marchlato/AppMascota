package com.example.appmascotas.presentador;

import android.content.Context;


import com.example.appmascotas.ConstructorMascotas;
import com.example.appmascotas.Mascota;
import com.example.appmascotas.vista.fragment.IRecyclerViewMascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresentador implements IRecyclerViewFragmentPresentador {

    private IRecyclerViewMascota iRecyclerViewMascota;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresentador(IRecyclerViewMascota iRecyclerViewMascota, Context context) {
        this.iRecyclerViewMascota = iRecyclerViewMascota;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        this.mostrarMascotaRecyclerView();
    }

    @Override
    public void mostrarMascotaRecyclerView() {
        iRecyclerViewMascota.inicializarAdaptador(iRecyclerViewMascota.crearAdaptador(mascotas));
        iRecyclerViewMascota.generarLinearLayoutVertical();
    }
}
