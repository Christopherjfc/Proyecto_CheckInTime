package com.example.checkintime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Profesor_perfil extends AppCompatActivity {
    private Button guardar;
    private ImageView btnMenu, imgFoto;
    private TextView perf, list, conf;
    private LinearLayout fondoMenu;
    private CardView cardViewCambiarContrasena;
    private TextView tvCambiarContrasena;
    private boolean isExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profesor_perfil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Inicializar los elementos
        btnMenu = findViewById(R.id.menu);
        fondoMenu = findViewById(R.id.fondoMenu);
        cardViewCambiarContrasena = findViewById(R.id.fill_contra);
        tvCambiarContrasena = findViewById(R.id.desplegar_contra);

        perf = findViewById(R.id.perfilUsuario);
        list = findViewById(R.id.lista);
        conf = findViewById(R.id.configuracion);
        imgFoto = findViewById(R.id.foto);
        guardar = findViewById(R.id.btn_guardar);


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cambiar la visibilidad del menú lateral
                if (fondoMenu.getVisibility() == View.GONE) {
                    // Si el menú está oculto, lo mostramos
                    fondoMenu.setVisibility(View.VISIBLE);
                } else {
                    // Si el menú está visible, lo ocultamos
                    fondoMenu.setVisibility(View.GONE);
                }
            }
        });

        tvCambiarContrasena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isExpanded){
                    // Oculta el cuadro
                    cardViewCambiarContrasena.setVisibility(View.GONE);
                    tvCambiarContrasena.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_flecha_derecha, 0);
                    isExpanded = false;
                }else {
                    // Muestra el cuadro
                    cardViewCambiarContrasena.setVisibility(View.VISIBLE);
                    tvCambiarContrasena.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_flecha_abajo, 0);
                    isExpanded = true;
                }
            }
        });

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Profesor_perfil.this, "Contraseña establecida", Toast.LENGTH_SHORT).show();
                cardViewCambiarContrasena.setVisibility(View.GONE);
                tvCambiarContrasena.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_flecha_derecha, 0);
            }
        });

        imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profesor_perfil.this, Profesor_perfil.class);
                startActivity(intent);
            }
        });

        perf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profesor_perfil.this, Profesor_perfil.class);
                startActivity(intent);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profesor_perfil.this, Profesor_lista.class);
                startActivity(intent);
            }
        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profesor_perfil.this, Profesor_configuraciones.class);
                startActivity(intent);
            }
        });
    }
}