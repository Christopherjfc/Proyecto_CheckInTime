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

public class Admin_gestionUsuario extends AppCompatActivity {
    private ImageView btnMenu;
    private Spinner usuario, aula, curso, ciclo, grupo;
    private LinearLayout lnProfesor, lnAlumno, fondoMenu;
    private TextView main, form, gestion, conf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_gestion_usuarios);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnMenu = findViewById(R.id.menu);
        fondoMenu = findViewById(R.id.fondoMenu);

        main = findViewById(R.id.mainAdmin);
        form = findViewById(R.id.formulario);
        gestion = findViewById(R.id.gestionUsuario);
        conf = findViewById(R.id.configuracion);

        usuario = findViewById(R.id.usuario);
        aula = findViewById(R.id.aula);
        curso = findViewById(R.id.curso);
        ciclo = findViewById(R.id.ciclo);
        grupo = findViewById(R.id.grupo);

        lnAlumno = findViewById(R.id.alumno);
        lnProfesor = findViewById(R.id.profesor);

        // Crear una lista de opciones con un texto inicial
        List<String> usuarios = new ArrayList<>();
        usuarios.add("Usuario"); // Placeholder
        usuarios.add("Profesor");
        usuarios.add("Alumno");

        List<String> aulas = new ArrayList<>();
        aulas.add("Aula"); // Placeholder
        aulas.add("A01");
        aulas.add("A02");
        aulas.add("A03");
        aulas.add("A04");
        aulas.add("A05");

        List<String> cursos = new ArrayList<>();
        cursos.add("Curso"); // Placeholder
        cursos.add("1");
        cursos.add("2");

        List<String> ciclos = new ArrayList<>();
        ciclos.add("Ciclo"); // Placeholder
        ciclos.add("DAM");
        ciclos.add("DAW");
        ciclos.add("ASIX");
        ciclos.add("SMX");
        ciclos.add("PFI");
        ciclos.add("CE");

        List<String> grupos = new ArrayList<>();
        grupos.add("Grupo"); // Placeholder
        grupos.add("A");
        grupos.add("B");
        grupos.add("C");

        configurarSpinner(usuario, usuarios);
        configurarSpinner(aula, aulas);
        configurarSpinner(curso, cursos);
        configurarSpinner(ciclo , ciclos);
        configurarSpinner(grupo , grupos);

        // Configurar listener para el spinner de usuario
        usuario.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Mostrar el LinearLayout correspondiente
                String seleccionado = parent.getItemAtPosition(position).toString();
                if (seleccionado.equals("Profesor")) {
                    lnAlumno.setVisibility(View.GONE);
                    lnProfesor.setVisibility(View.VISIBLE);
                } else if (seleccionado.equals("Alumno")) {
                    lnProfesor.setVisibility(View.GONE);
                    lnAlumno.setVisibility(View.VISIBLE);
                } else if (seleccionado.equals("Usuario")) {
                    // No se seleccionó nada, oculta ambos LinearLayout
                    lnProfesor.setVisibility(View.GONE);
                    lnAlumno.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

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
                Intent intent = new Intent(Admin_gestionUsuario.this, Admin_main.class);
                startActivity(intent);
            }
        });

        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_gestionUsuario.this, Admin_formulario.class);
                startActivity(intent);
            }
        });

        gestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_gestionUsuario.this, Admin_gestionUsuario.class);
                startActivity(intent);
            }
        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_gestionUsuario.this, Admin_configuracion.class);
                startActivity(intent);
            }
        });
    }


    // Método para configurar un Spinner (sin personalización)
    private void configurarSpinner(Spinner spinner, List<String> opciones) {
        // Usa un diseño predeterminado de Android
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
