package com.example.cementerioalbacete.Usuarios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.cementerioalbacete.R;

public class MainActivity2 extends AppCompatActivity {
Button bot1,bot2,bot3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        bot1=findViewById(R.id.botonainvi);
        bot2=findViewById(R.id.botonfunc);
        bot3=findViewById(R.id.infobut);

        bot3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent infor = new Intent(MainActivity2.this , HelpActivity3.class);

                startActivity(infor);
            }
        });

        bot1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(MainActivity2.this , InvitadoActivity.class);

                startActivity(go);
            }
        });


        bot2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent go2 = new Intent(MainActivity2.this , LoginFuncActivity.class);

                startActivity(go2);
            }
        });
    }
}