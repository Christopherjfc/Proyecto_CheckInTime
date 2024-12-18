package com.example.checkintime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Admin_Alum_main extends AppCompatActivity {
    private ImageView btnMenu, imgFoto;
    private TextView perf, asist, conf, main;
    private LinearLayout fondoMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_alum_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnMenu = findViewById(R.id.menu);
        fondoMenu = findViewById(R.id.fondoMenu);
        perf = findViewById(R.id.perfilUsuario);
        asist = findViewById(R.id.asistencia);
        conf = findViewById(R.id.configuracion);
        imgFoto = findViewById(R.id.foto);
        main = findViewById(R.id.mainAdmin);

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fondoMenu.getVisibility() == View.GONE) {
                    fondoMenu.setVisibility(View.VISIBLE);
                } else {
                    fondoMenu.setVisibility(View.GONE);
                }
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_Alum_main.this, Admin_main.class);
                startActivity(intent);
            }
        });

        imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Alum_main.this, Admin_Alum_perfil.class);
                startActivity(intent);
            }
        });

        perf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Alum_main.this, Admin_Alum_perfil.class);
                startActivity(intent);
            }
        });

        asist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Alum_main.this, Admin_Alum_asistencia.class);
                startActivity(intent);
            }
        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Alum_main.this, Admin_Alum_configuraciones.class);
                startActivity(intent);
            }
        });
    }
}