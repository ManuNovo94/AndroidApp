package com.example.cementerioalbacete.Usuarios;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.example.cementerioalbacete.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Creación del menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_usuario, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.idconsul:
                Intent iconsul = new Intent(this, ConsultaActivity.class);
                startActivity(iconsul);
                break;
            case R.id.idregis:
            Intent iregis = new Intent(this, RegistroActivity.class);
            startActivity(iregis);
            break;

            case R.id.Anotacionesid:
                Intent go = new Intent(MainActivity.this, AnotacionesFuncActivity.class);
                startActivity(go);
                break;


            case R.id.idsesionclose:

                SharedPreferences obj = getSharedPreferences(getString(R.string.PrefLog), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =obj.edit();
                editor.putBoolean(getString(R.string.IsLogin),false);
                editor.commit();

                Intent cerrarsesion = new Intent(this,MainActivity2.class);
                startActivity(cerrarsesion);

                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }








}