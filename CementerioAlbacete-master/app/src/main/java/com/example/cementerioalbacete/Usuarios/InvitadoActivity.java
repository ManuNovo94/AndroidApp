package com.example.cementerioalbacete.Usuarios;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.cementerioalbacete.R;

public class InvitadoActivity extends AppCompatActivity {
TextView label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invitado);

        label=findViewById(R.id.consultatelefono);

        label.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:" + 967596143)));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuinvi, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.idconsulinvi:
                Intent iconsul = new Intent(this, ConsultaActivity.class);
                startActivity(iconsul);
                break;


            case R.id.idlocinvi:
                Intent ifind = new Intent(this, LocalizacionActivity.class);
                startActivity(ifind);
                break;

            case R.id.idplano:
                Intent ifindplan = new Intent(this, PlanoActivity.class);
                startActivity(ifindplan);
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}