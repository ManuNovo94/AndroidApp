package com.example.cementerioalbacete.Usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cementerioalbacete.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class AnotacionesFuncActivity extends AppCompatActivity {
    private Button b1;
    private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotaciones_func);

        et1=(EditText)findViewById(R.id.bitacora);
        String archivos [] = fileList();

        if(ArchivoExiste(archivos,"agenda.txt")){
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("agenda.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String bitacoracompleta = "";

                while(linea != null){

                    bitacoracompleta = bitacoracompleta + linea + "\n";
                    linea = br.readLine();

                }
                br.close();
                archivo.close();
                et1.setText(bitacoracompleta);
            }
            catch (IOException e){
            }
        }

    }
    private boolean ArchivoExiste(String archivos [],String NombreArchivo) {
        for (int i = 0; i < archivos.length; i++)
            if(NombreArchivo.equals(archivos[i]))
                return true;
        return false;
    }

    public void guardar (View view ){

        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("agenda.txt", Activity.MODE_PRIVATE));
            archivo.write(et1.getText().toString());
            archivo.flush();
            archivo.close();
        }
        catch (IOException e) {

        }
        Toast.makeText(this, "Guardado Correctamente", Toast.LENGTH_SHORT).show();
    }




}