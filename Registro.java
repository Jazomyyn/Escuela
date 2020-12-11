package com.example.profes;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.navigation.NavigationView;

public class Registro extends AppCompatActivity {
    private Spinner spinner;
    private Spinner spinner2;
    public NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        spinner= (Spinner)findViewById(R.id.spinner);

        String [] op= {"Seleccione tipo de usuario","Estudiante","Docente"};
        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, op);
        spinner.setAdapter(adapter);

        spinner2 = (Spinner) findViewById(R.id.spinner2);
        String [] grado= {"Seleccione su grado","1°","2°","3°","4°"};
        ArrayAdapter <String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, grado);
        spinner2.setAdapter(adapter2);


    }
    public void Continuar (View view){
        String tipo_usuario = spinner.getSelectedItem().toString();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
            if (tipo_usuario.equals("Estudiante")){
                navigationView.getMenu().clear();      //elimina anterior menu drawer
                navigationView.inflateMenu(R.menu.activity_main_drawer);
            Intent continuar = new Intent(this, MainActivity2.class);
            startActivity(continuar);
        }else  if (tipo_usuario.equals("Docente")){
            Intent continuar = new Intent(this, MainActivity.class);
            startActivity(continuar);
        }

    }



}