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

public class Alumno_perfil extends AppCompatActivity {
    private ImageView btnMenu, imgFoto;
    private TextView perf, asist, conf, tvCambiarContrasena;
    private LinearLayout fondoMenu;
    private Button guardar;
    private CardView cardViewCambiarContrasena;
    private boolean isExpanded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alumno_perfil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cardViewCambiarContrasena = findViewById(R.id.fill_contra);
        tvCambiarContrasena = findViewById(R.id.desplegar_contra);
        perf = findViewById(R.id.perfilUsuario);
        asist = findViewById(R.id.asistencia);
        conf = findViewById(R.id.configuracion);
        imgFoto = findViewById(R.id.foto);
        btnMenu = findViewById(R.id.menu);
        fondoMenu = findViewById(R.id.fondoMenu);
        guardar = findViewById(R.id.btn_guardar);

        // Acción del clic en el botón de menú
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
                Toast.makeText(Alumno_perfil.this, "Contraseña establecida", Toast.LENGTH_SHORT).show();
                cardViewCambiarContrasena.setVisibility(View.GONE);
                tvCambiarContrasena.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_flecha_derecha, 0);
            }
        });

        imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alumno_perfil.this, Alumno_perfil.class);
                startActivity(intent);
            }
        });

        perf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alumno_perfil.this, Alumno_perfil.class);
                startActivity(intent);
            }
        });

        asist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alumno_perfil.this, Alumno_asistencia.class);
                startActivity(intent);
            }
        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Alumno_perfil.this, Alumno_configuraciones.class);
                startActivity(intent);
            }
        });
    }
}