package com.example.ecogotas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecogotas.db.DbCont;

public class Login extends AppCompatActivity {

    private Button btnRegis;
    private Button btnIniciarSesion;
    private EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.edtUsuario);
        etPassword = findViewById(R.id.edtContra);

        btnRegis = findViewById(R.id.btnRegistrar);
        btnIniciarSesion = findViewById(R.id.btnInicio);

        btnRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Registro.class);
                startActivity(i);
            }
        });

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();

                int idUsuario = validarInicioSesion(email, password);

                if (idUsuario != -1) {
                    Toast.makeText(Login.this, "Bienvenido", Toast.LENGTH_SHORT).show();
                    Intent intentDatos = new Intent(Login.this, RegistroDatos.class);
                    startActivity(intentDatos);
                    finish();  // Esto cierra la actividad actual si el inicio de sesión es exitoso
                } else {
                    Toast.makeText(Login.this, "Inicio de sesión fallido. Verifica tus credenciales.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @SuppressLint("Range")
    private int validarInicioSesion(String email, String password) {
        int idUsuario = -1;

        try {
            DbCont dbCont = new DbCont(this);
            SQLiteDatabase db = dbCont.getReadableDatabase();

            String[] projection = {"id"};
            String selection = "email = ? AND password = ?";
            String[] selectionArgs = {email, password};

            Cursor cursor = db.query("t_usuarios", projection, selection, selectionArgs, null, null, null);

            if (cursor.moveToFirst()) {
                idUsuario = cursor.getInt(cursor.getColumnIndex("id"));
            }

            cursor.close();
            db.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return idUsuario;
    }
}
