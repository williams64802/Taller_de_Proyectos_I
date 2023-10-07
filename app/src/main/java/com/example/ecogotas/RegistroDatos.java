package com.example.ecogotas;

import static com.example.ecogotas.db.DbEco.TABLE_USUARIO;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ecogotas.db.DbCont;

// RegistroDatos.java

public class RegistroDatos extends AppCompatActivity {

    private EditText etCantidadAgua, etOtroDato;
    private Button btnRegistrarDatos;
    private int idUsuario;
    private String email = "correo@ejemplo.com"; // Ajusta según tus datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_datos);

        etCantidadAgua = findViewById(R.id.etCantidadAgua);
        etOtroDato = findViewById(R.id.etxTanque);
        btnRegistrarDatos = findViewById(R.id.btnRegistrarDatos);

        idUsuario = obtenerIdUsuarioDesdeSesion();

        btnRegistrarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strCantidadAgua = etCantidadAgua.getText().toString();
                String strOtroDato = etOtroDato.getText().toString();

                if (!TextUtils.isEmpty(strCantidadAgua) && !TextUtils.isEmpty(strOtroDato)) {
                    insertarDatosEnBaseDeDatos(idUsuario, strCantidadAgua, strOtroDato);
                } else {
                    Toast.makeText(RegistroDatos.this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private int obtenerIdUsuarioDesdeSesion() {
        int idUsuario = -1;

        try {
            DbCont dbCont = new DbCont(this);
            idUsuario = dbCont.obtenerIdUsuarioPorEmail(email);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return idUsuario;
    }

    private void insertarDatosEnBaseDeDatos(int idUsuario, String cantidadAguaStr, String otroDato) {
        try {
            double cantidadAgua = Double.parseDouble(cantidadAguaStr);

            DbCont dbCont = new DbCont(this);
            long idInsercion = dbCont.insertarDatosUsuario(idUsuario, cantidadAgua, otroDato);

            if (idInsercion != -1) {
                Toast.makeText(RegistroDatos.this, "Datos registrados con éxito", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(RegistroDatos.this, Menu.class);
                startActivity(i);
            } else {
                Toast.makeText(RegistroDatos.this, "Error al registrar los datos", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
