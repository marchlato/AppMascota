package com.example.appmascotas.vista.fragment;

import static android.os.Build.VERSION_CODES.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appmascotas.ConstructorMascotas;
import com.example.appmascotas.Mascota;
import com.example.appmascotas.adapter.PerfilAdaptador;

import java.util.ArrayList;
import java.util.zip.Inflater;




public class Perfil_Mascota extends Fragment {

    ArrayList<Mascota> mascotas;
    public RecyclerView listaMascotas;
    TextView tvNombrePerfil;
    private ConstructorMascotas constructorMascotas;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

      //  View v = inflater.inflate(R.layout.fragment_perfil__mascota, container, false);

        //listaMascotas = findViewById(R.id.rvPerfilMascota);
        //tvNombrePerfil = findViewById(R.id.tvNombrePerfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(glm);

        inicializarListaMascotas();
        inicializarAdaptador();

        // Usar un recurso de cadena en lugar de una cadena estática
        tvNombrePerfil.setText("Gato Y Perro");

        return null;
    }
    public void inicializarAdaptador () {
        PerfilAdaptador adaptador = new PerfilAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas () {
        mascotas = new ArrayList<Mascota>();
        constructorMascotas = new ConstructorMascotas(getContext());
        mascotas = constructorMascotas.obtenerPerfil();
    }
}