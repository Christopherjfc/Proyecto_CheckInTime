package com.example.checkintime;

import android.content.Intent;
import android.os.Bundle;
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
import java.util.List;

public class Profesor_configuraciones extends AppCompatActivity {
    private Spinner idioma, tamany;
    private ImageView btnMenu, imgFoto;
    private TextView perf, list, conf;
    private LinearLayout fondoMenu;
    private Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profesor_configuraciones);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnMenu = findViewById(R.id.menu);
        fondoMenu = findViewById(R.id.fondoMenu);
        idioma = findViewById(R.id.idioma);
        tamany = findViewById(R.id.size);
        guardar = findViewById(R.id.guardar_pref);

        perf = findViewById(R.id.perfilUsuario);
        list = findViewById(R.id.lista);
        conf = findViewById(R.id.configuracion);
        imgFoto = findViewById(R.id.foto);

        List<String> idiomas = new ArrayList<>();
        idiomas.add("ES"); // Placeholder
        idiomas.add("EN");
        idiomas.add("CA");


        List<String> size = new ArrayList<>();
        size.add("Tamaño"); // Placeholder
        size.add("12");
        size.add("14");
        size.add("16");
        size.add("18");

        configurarSpinner(idioma, idiomas);
        configurarSpinner(tamany, size);

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
                Toast.makeText(Profesor_configuraciones.this, "Preferencias guardadas", Toast.LENGTH_SHORT).show();
            }
        });

        imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profesor_configuraciones.this, Profesor_perfil.class);
                startActivity(intent);
            }
        });

        perf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profesor_configuraciones.this, Profesor_perfil.class);
                startActivity(intent);
            }
        });

        list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profesor_configuraciones.this, Profesor_lista.class);
                startActivity(intent);
            }
        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profesor_configuraciones.this, Profesor_configuraciones.class);
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