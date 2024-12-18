package com.example.checkintime;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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

public class Admin_Prof_lista extends AppCompatActivity {

    private Button guardar;
    private Spinner aula, curso, ciclo, grupo, fechaYhora;
    private ImageView btnMenu, imgFoto;
    private TextView perf, list, conf,main, modifAsis;
    private LinearLayout fondoMenu;
    private String fechaSeleccionada = "";
    private String horaSeleccionada = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_prof_lista);
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
        guardar = findViewById(R.id.btn_guardar);
        modifAsis = findViewById(R.id.modificarAsistencia);

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

        List<String> FechaYHora = new ArrayList<>();
        FechaYHora.add("Fecha y Hora"); // Placeholder

        configurarSpinner(aula, aulas);
        configurarSpinner(curso, cursos);
        configurarSpinner(ciclo , ciclos);
        configurarSpinner(grupo , grupos);
        configurarSpinner(fechaYhora , FechaYHora);


        fechaYhora.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mostrarSelectorFechaYHora();
                    return true; // Interceptar el clic
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

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Admin_Prof_lista.this, "Lista guardada", Toast.LENGTH_SHORT).show();
            }
        });

        modifAsis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Prof_lista.this, Admin_Prof_modificaAsistencia.class);
                startActivity(intent);
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Prof_lista.this, Admin_main.class);
                startActivity(intent);
            }
        });

        imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Prof_lista.this, Admin_Prof_perfil.class);
                startActivity(intent);
            }
        });

        perf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Prof_lista.this, Admin_Prof_perfil.class);
                startActivity(intent);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Prof_lista.this, Admin_Prof_lista.class);
                startActivity(intent);
            }
        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Admin_Prof_lista.this, Admin_Prof_configuraciones.class);
                startActivity(intent);
            }
        });
    }


    private void mostrarSelectorFechaYHora() {
        // Obtener fecha actual
        final Calendar calendar = Calendar.getInstance();
        int anio = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        // Mostrar DatePickerDialog para seleccionar la fecha
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
                fechaSeleccionada = dayOfMonth + "/" + (month + 1) + "/" + year;

                // Mostrar TimePickerDialog para seleccionar la hora
                int hora = calendar.get(Calendar.HOUR_OF_DAY);
                int minuto = calendar.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(Admin_Prof_lista.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(android.widget.TimePicker timeView, int hourOfDay, int minute) {
                        horaSeleccionada = String.format("%02d:%02d", hourOfDay, minute);

                        // Mostrar la fecha y hora seleccionadas en un Toast
                        String fechaHora = fechaSeleccionada + " " + horaSeleccionada;
                        Toast.makeText(getApplicationContext(), fechaHora, Toast.LENGTH_LONG).show();
                    }
                }, hora, minuto, true);

                timePickerDialog.show();
            }
        }, anio, mes, dia);

        datePickerDialog.show();
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