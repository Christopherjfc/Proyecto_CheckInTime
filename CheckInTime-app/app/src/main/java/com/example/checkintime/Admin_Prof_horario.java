package com.example.checkintime;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
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
import java.util.Calendar;
import java.util.List;

public class Admin_Prof_horario extends AppCompatActivity {
    private Spinner aula, curso, ciclo, grupo, fechaYhora;
    private ImageView btnMenu, imgFoto;
    private TextView perf, list, conf,main;
    private LinearLayout fondoMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_prof_horario);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnMenu = findViewById(R.id.menu);
        fondoMenu = findViewById(R.id.fondoMenu);
        aula = findViewById(R.id.aula);
        curso = findViewById(R.id.curso);
        ciclo = findViewById(R.id.ciclo);
        grupo = findViewById(R.id.grupo);
        fechaYhora = findViewById(R.id.FechaHora);

        perf = findViewById(R.id.perfilUsuario);
        list = findViewById(R.id.lista);
        conf = findViewById(R.id.configuracion);
        imgFoto = findViewById(R.id.foto);
        main = findViewById(R.id.mainAdmin);

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

        List<String> Hora = new ArrayList<>();
        Hora.add("Hora"); // Placeholder

        configurarSpinner(aula, aulas);
        configurarSpinner(curso, cursos);
        configurarSpinner(ciclo , ciclos);
        configurarSpinner(grupo , grupos);
        configurarSpinner(fechaYhora , Hora);


        fechaYhora.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mostrarTimePicker();
                    return true;
                }
                return false;
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
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Prof_horario.this, Admin_main.class);
                startActivity(intent);
            }
        });

        imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Prof_horario.this, Admin_Prof_perfil.class);
                startActivity(intent);
            }
        });

        perf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Prof_horario.this, Admin_Prof_perfil.class);
                startActivity(intent);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Prof_horario.this, Admin_Prof_lista.class);
                startActivity(intent);
            }
        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Prof_horario.this, Admin_Prof_configuraciones.class);
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

    private void mostrarTimePicker() {
        // Obtener la hora actual
        Calendar calendar = Calendar.getInstance();
        int horaActual = calendar.get(Calendar.HOUR_OF_DAY);
        int minutoActual = calendar.get(Calendar.MINUTE);

        // Crear y mostrar el TimePickerDialog
        TimePickerDialog timePicker = new TimePickerDialog(
                this,
                (view, hourOfDay, minute) -> {
                    String horaSeleccionada = String.format("%02d:%02d", hourOfDay, minute);
                    Toast.makeText(Admin_Prof_horario.this, horaSeleccionada, Toast.LENGTH_LONG).show();
                },
                horaActual,
                minutoActual,
                true // Mostrar formato 24 horas
        );
        timePicker.show();
    }
}