package com.example.cementerioalbacete.Usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cementerioalbacete.R;

public class LoginFuncActivity extends AppCompatActivity {
     EditText usertxt;
     EditText passtxt;
    Button Boton1;
TextView et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_func);
        usertxt = (EditText) findViewById(R.id.usuario);
        passtxt = (EditText) findViewById(R.id.contraseña);
        Boton1 = (Button) findViewById(R.id.botonloginacceso);
       // et1 = (TextView) findViewById(R.id.etq1);

        //llamamos al siguiente intem
        SharedPreferences obj = getSharedPreferences(getString(R.string.PrefLog), Context.MODE_PRIVATE);
        boolean isLogin = obj.getBoolean(getString(R.string.IsLogin), false);
        if (isLogin == true) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }


        Boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Usuario1 = usertxt.getText().toString().trim();
                String Password = passtxt.getText().toString().trim();
                //loggin
                if (Usuario1.equals("Administrador") && Password.equals("secreta")) {
                    Intent i1 = new Intent(LoginFuncActivity.this, MainActivity.class);
                    startActivity(i1);

                    //preferences
                   SharedPreferences obj = getSharedPreferences(getString(R.string.PrefLog),Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor =obj.edit();
                    editor.putString(getString(R.string.PrefLog),Usuario1 );
                    editor.putBoolean(getString(R.string.IsLogin),true);
                    editor.commit();


                } else {
                    //unloggin
                    Toast.makeText(LoginFuncActivity.this, "Error: contraseña o usuario incorrectos.", Toast.LENGTH_LONG).show();

                    SharedPreferences obj = getSharedPreferences(getString(R.string.PrefLog),Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor =obj.edit();
                    editor.putBoolean(getString(R.string.IsLogin),false);
                    editor.commit();
                }




            }
        });


    }

   /* public void clickVentanaLogin(View view) {
        String Usuario1 = usertxt.getText().toString();
        String Password = passtxt.getText().toString();
        if (Usuario1.equals("usuario") && Password.equals("secreta")) {
            Intent i1 = new Intent(this, MainActivity.class);
            startActivity(i1);

            //preferences
            SharedPreferences obj = getSharedPreferences(getString(R.string.PrefLog),Context.MODE_PRIVATE);
            SharedPreferences.Editor editor =obj.edit();
            editor.putString(getString(R.string.PrefLog),Usuario1 );
            editor.putBoolean(getString(R.string.IsLogin),true);
            editor.commit();
            // paso de usuario a etiqueta

            Intent i = new Intent(this,MainActivity.class);
            i.putExtra("dato",et1.getText().toString());//dato es el nombre que se le da para localizarla en otro activity
            startActivity(i);



        } else {
//unloggin
            Toast.makeText(this, "Error: contraseña o usuario incorrectos.", Toast.LENGTH_LONG).show();

            SharedPreferences obj = getSharedPreferences(getString(R.string.PrefLog),Context.MODE_PRIVATE);
            SharedPreferences.Editor editor =obj.edit();
            editor.putBoolean(getString(R.string.IsLogin),false);
            editor.commit();
        }

    }

*/
}