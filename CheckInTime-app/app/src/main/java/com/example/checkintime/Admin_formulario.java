package com.example.checkintime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Admin_formulario extends AppCompatActivity {
    private RadioButton rbAdministrador, rbProfesor, rbAlumno;
    private LinearLayout formularioAdmin, formularioProfesor, formularioAlumno, fondoMenu;
    private TextView main, form, gestion, conf;
    private Button guardaAdmin, guardaProf, guardaAlum;
    private ImageView btnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_admin_formulario);
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

        //botones de guardado de usuario
        guardaAdmin = findViewById(R.id.btn_guardar_admin);
        guardaProf = findViewById(R.id.btn_guardar_prof);
        guardaAlum = findViewById(R.id.btn_guardar_alum);

        // Enlazar los formularios
        formularioAdmin = findViewById(R.id.formulario_amdim);
        formularioProfesor = findViewById(R.id.formulario_profesor);
        formularioAlumno = findViewById(R.id.formulario_alumno);

        // Enlazar los RadioButtons
        rbAdministrador = findViewById(R.id.rb_administrador);
        rbProfesor = findViewById(R.id.rb_profesor);
        rbAlumno = findViewById(R.id.rb_alumno);


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

        // Configurar los listeners de clic para cada RadioButton
        rbAdministrador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manejarSeleccion(rbAdministrador);
                mostrarFormulario(formularioAdmin);
            }
        });

        rbProfesor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manejarSeleccion(rbProfesor);
                mostrarFormulario(formularioProfesor);
            }
        });

        rbAlumno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manejarSeleccion(rbAlumno);
                mostrarFormulario(formularioAlumno);
            }
        });


        guardaAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Admin_formulario.this, "Administrador registrado", Toast.LENGTH_SHORT).show();
            }
        });

        guardaProf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Admin_formulario.this, "Profesor registrado", Toast.LENGTH_SHORT).show();
            }
        });

        guardaAlum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Admin_formulario.this, "Alumno registrado", Toast.LENGTH_SHORT).show();
            }
        });

        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_formulario.this, Admin_main.class);
                startActivity(intent);
            }
        });

        form.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_formulario.this, Admin_formulario.class);
                startActivity(intent);
            }
        });

        gestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_formulario.this, Admin_gestionUsuario.class);
                startActivity(intent);
            }
        });

        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Admin_formulario.this, Admin_configuracion.class);
                startActivity(intent);
            }
        });
    }

    // Método para manejar la selección de los RadioButtons
    private void manejarSeleccion(RadioButton seleccionado) {
        // Desmarcar todos los botones
        rbAdministrador.setChecked(false);
        rbProfesor.setChecked(false);
        rbAlumno.setChecked(false);

        // Marcar el RadioButton seleccionado
        seleccionado.setChecked(true);
    }

    // Método para mostrar el formulario correspondiente
    private void mostrarFormulario(LinearLayout formularioVisible) {
        // Ocultar todos los formularios
        formularioAdmin.setVisibility(View.GONE);
        formularioProfesor.setVisibility(View.GONE);
        formularioAlumno.setVisibility(View.GONE);

        // Mostrar el formulario seleccionado
        formularioVisible.setVisibility(View.VISIBLE);
    }
}
