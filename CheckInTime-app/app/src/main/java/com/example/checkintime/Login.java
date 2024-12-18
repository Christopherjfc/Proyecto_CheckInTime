package com.example.checkintime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
    EditText correoText;
    Button iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inicializar los elementos
        correoText = findViewById(R.id.correo); // Referencia al EditText del correo
        iniciar = findViewById(R.id.login); // Referencia al botón de login

        // Acción al hacer clic en el botón de login
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String correo = correoText.getText().toString().trim();

                if (correo.isEmpty()) {
                    Toast.makeText(Login.this, "Por favor ingrese el correo", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Verificar el formato del correo y redirigir
                if (correo.matches("^\\d{4}_.+@iticbcn\\.cat$") && correo.compareTo("2018") >= 0 && correo.compareTo("2025") <= 0) {
                    // Si es un correo con año entre 2018 y 2024 (ejemplo: 2023_christopher.flores@iticbcn.cat)
                    Intent intent = new Intent(Login.this, Alumno_main.class);
                    startActivity(intent);
                } else if (correo.equals("admin@iticbcn.cat")) {
                    // Si empieza con admin (ejemplo: admin@iticbcn.cat)
                    Intent intent = new Intent(Login.this, Admin_main.class);
                    startActivity(intent);
                } else if (correo.matches("^[a-zA-Z]+\\.[a-zA-Z]+@iticbcn\\.cat$")) {
                    // Si el correo tiene formato de nombre.apellido (ejemplo: jorge.perez@iticbcn.cat)
                    Intent intent = new Intent(Login.this, Profesor_main.class);
                    startActivity(intent);
                } else {
                    // Si el correo no cumple con ninguno de los formatos
                    Toast.makeText(Login.this, "Correo no válido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}