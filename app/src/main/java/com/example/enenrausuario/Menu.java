package com.example.enenrausuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Menu extends AppCompatActivity {

    Button button_contactos,button_monitorizarhumo,button_monitorizarollin,button_perfil,button_historial,Button_cerrarSesion;
    public static String userss = "names";
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mAuth = FirebaseAuth.getInstance();

        button_contactos=(Button)findViewById(R.id.button_contactos);
        button_contactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Menu.this,Mantenedores.class);
                startActivity(intent);
            }
        });

        button_monitorizarhumo=(Button)findViewById(R.id.button_monitorizarhumo);
        button_monitorizarhumo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =(new Intent(Menu.this,MonitorizaciondeHumo.class));
                startActivity(intent);
            }
        });

        button_monitorizarollin=(Button)findViewById(R.id.button_monitorizarollin);
        button_monitorizarollin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =(new Intent(Menu.this,MonitorizacionDeOllin.class));
                startActivity(intent);
            }
        });


        button_historial=(Button)findViewById(R.id.button_historial );
        button_historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =(new Intent(Menu.this,HistorialActivity.class));
                startActivity(intent);
            }
        });

        Button_cerrarSesion=(Button)findViewById(R.id.Button_cerrarSesion );
        Button_cerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(Menu.this,MainActivity.class));
                finish();
            }
        });

    }
}