package com.example.appmascotas;

import static com.example.appmascotas.R.id.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.appmascotas.adapter.PageAdapter;
import com.example.appmascotas.vista.fragment.Perfil_Mascota;
import com.example.appmascotas.vista.fragment.RecyclerView_Fragment;
import com.google.android.material.tabs.TabLayout;


import java.util.ArrayList;
import java.util.Objects;

public class RecyclerViewMascota extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_mascota);
        Toolbar tootlbar = findViewById(toolBar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        setUpViewPager();

        if (tootlbar != null) {
            setSupportActionBar(tootlbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                int itemStrella = R.id.itemStrella;
                Intent intent = new Intent(RecyclerViewMascota.this,MascotasFavoritas.class);
                startActivity(intent);
                return true;
            case 2:
                int itemConatacto = R.id.itemConatacto;
                Intent contactoIntent = new Intent(this,Contacto.class);
                startActivity(contactoIntent);
                return true;
            case 3:
                int itemAcercaDe1 = R.id.itemAcercaDe;
                Intent acerca_de_Intent = new Intent(this,AcercaDe.class);
                startActivity(acerca_de_Intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerView_Fragment());
        fragments.add(new Perfil_Mascota());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        Objects.requireNonNull(tabLayout.getTabAt(0)).setIcon(R.mipmap.lista_mascotas);
        Objects.requireNonNull(tabLayout.getTabAt(1)).setIcon(R.mipmap.perfil_mascota);
    }
}