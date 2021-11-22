package com.example.cementerioalbacete.Usuarios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cementerioalbacete.R;

import java.util.ArrayList;

public class ConsultaActivity extends AppCompatActivity {
Button consul,volver ;
EditText nom,ap,ap2,anio;
RecyclerView list;
ArrayList <Cementerio> listaconsultacemen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);

        consul=findViewById(R.id.botoncontuls);
        nom=findViewById(R.id.nomconsul);
        ap=findViewById(R.id.ape1consul);
        ap2=findViewById(R.id.ap2consul);
        anio=findViewById(R.id.fechaconsul);

        list=findViewById(R.id.listaconsulta);
        list.setLayoutManager(new LinearLayoutManager(ConsultaActivity.this));





        consul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Datos="";
                String patio="";
                String pabellon= "";
                String filac = "";
                String numero = "";

                    String nombre = nom.getText().toString().toUpperCase().trim();
                    String apellido1 = ap.getText().toString().toUpperCase().trim();
                    String apellido2 = ap2.getText().toString().toUpperCase().trim();
                    String year = anio.getText().toString();

                    if(nombre.isEmpty() || apellido1.isEmpty() || apellido2.isEmpty() || year.isEmpty()){

                        Toast.makeText(ConsultaActivity.this, "Todos los campos deben estar llenos", Toast.LENGTH_SHORT).show();
                    }
                else {
                        Dbfallecidos fallecidos = new Dbfallecidos(ConsultaActivity.this);
                        listaconsultacemen = new ArrayList<>();
                        adaptador adapter = new adaptador( fallecidos.consultalist(nombre, apellido1, apellido2, year));
                        list.setAdapter(adapter);


                    }

            }
        });
    }


}