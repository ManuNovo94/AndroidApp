package com.example.cementerioalbacete.Usuarios;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cementerioalbacete.R;

public class RegistroActivity extends AppCompatActivity {
    EditText nom, ap1,ap2,fecha,patio,pabellon,fila,numero;
    Button back,registr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nom = findViewById(R.id.idnomreg);
        ap1=findViewById(R.id.idsurname1reg);
        ap2=findViewById(R.id.idsurname2regis);
        fecha= findViewById(R.id.idfecharegis);
        patio=findViewById(R.id.idpatioregis);
        pabellon= findViewById(R.id.idpabellonregis);
        fila= findViewById(R.id.idfilaregis);
        numero=findViewById(R.id.idnumeroregis);
        back = findViewById(R.id.btn_RegistrotoMain);
        registr= findViewById(R.id.idbotregis);


        registr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = nom.getText().toString().toUpperCase().trim();
                String apellido= ap1.getText().toString().toUpperCase().trim();
                String apellido2= ap2.getText().toString().toUpperCase().trim();
                String anio = fecha.getText().toString();
                String pat = patio.getText().toString();
                String pab= pabellon.getText().toString();
                String row = fila.getText().toString();
                String num= numero.getText().toString();
if(name.isEmpty() || apellido.isEmpty() || anio.isEmpty() || pat.isEmpty() || pab.isEmpty() || row.isEmpty() || num.isEmpty() ){

    Toast.makeText(RegistroActivity.this, "Todos los campos deben estar llenos", Toast.LENGTH_SHORT).show();
}
else {
    Dbfallecidos fallecidos = new Dbfallecidos(RegistroActivity.this);
    long id = fallecidos.Insertadato(name, apellido, apellido2, anio, pat, pab, row, num);
    if (id > 0) {

        Toast.makeText(RegistroActivity.this, "Datos insertados", Toast.LENGTH_SHORT).show();
        limpiar();
    } else {
        Toast.makeText(RegistroActivity.this, "Error al guardar Registro", Toast.LENGTH_SHORT).show();
    }

}


            }
        });
        back.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                Intent ba = new Intent(RegistroActivity.this , MainActivity.class);

                startActivity(ba);


            }
        });
    }
    private void limpiar (){
        nom.setText("");
        ap1.setText("");
        ap2.setText("");
        fecha.setText("");
        patio.setText("");
        pabellon.setText("");
        fila.setText("");
        numero.setText("");

    }

}