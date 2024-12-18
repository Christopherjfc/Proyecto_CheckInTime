package com.example.checkintime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class Admin_Alum_asistencia extends AppCompatActivity {
    private Spinner fechas, curso, grupo;
    private ImageView btnMenu, imgFoto;
    private TextView perf, asist, conf, main;
    private LinearLayout fondoMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_alum_asistencia);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar los elementos
        btnMenu = findViewById(R.id.menu);
        fondoMenu = findViewById(R.id.fondoMenu);
        perf = findViewById(R.id.perfilUsuario);
        asist = findViewById(R.id.asistencia);
        conf = findViewById(R.id.configuracion);
        imgFoto = findViewById(R.id.foto);
        main = findViewById(R.id.mainAdmin);

        fechas = findViewById(R.id.fecha);
        curso = findViewById(R.id.curso);
        grupo = findViewById(R.id.grupo);

        List<String> rangofecha = new ArrayList<>();
        rangofecha.add("Hoy"); // Placeholder
        rangofecha.add("Ayer");
        rangofecha.add("Últimos 7 días");
        rangofecha.add("Últimos 30 días");
        rangofecha.add("Sin filtrar");

        List<String> cursos = new ArrayList<>();
        cursos.add("Curso"); // Placeholder
        cursos.add("1");
        cursos.add("2");

        List<String> grupos = new ArrayList<>();
        grupos.add("Grupo"); // Placeholder
        grupos.add("A");
        grupos.add("B");
        grupos.add("C");

        configurarSpinner(fechas, rangofecha);
        configurarSpinner(curso, cursos);
        configurarSpinner(grupo, grupos);

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
                Intent intent = new Intent(Admin_Alum_asistencia.this, Admin_main.class);
                startActivity(intent);
            }
        });

        imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Alum_asistencia.this, Admin_Alum_perfil.class);
                startActivity(intent);
            }
        });

        perf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Alum_asistencia.this, Admin_Alum_perfil.class);
                startActivity(intent);
            }
        });

        asist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Alum_asistencia.this, Admin_Alum_asistencia.class);
                startActivity(intent);
            }
        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Alum_asistencia.this, Admin_Alum_configuraciones.class);
                startActivity(intent);
            }
        });
    }

    private void configurarSpinner(Spinner spinner, List<String> opciones) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // Dropdown predeterminado
        spinner.setAdapter(adapter);

        // Listener para manejar selecciones
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Evitar acción cuando se selecciona el placeholder (posición 0)
                if (position > 0) {
                    String seleccionado = parent.getItemAtPosition(position).toString();
                    Toast.makeText(getApplicationContext(), seleccionado, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}