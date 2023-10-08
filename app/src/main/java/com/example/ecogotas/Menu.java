package com.example.ecogotas;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ecogotas.db.DbCont;

public class Menu extends AppCompatActivity {

    private TextView txtNombreUsuario;
    private TextView txtInformacion;
    private TextView txtInformeTanque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        txtNombreUsuario = findViewById(R.id.txtNombreUsuario);
        txtInformacion = findViewById(R.id.txtInformacion);
        txtInformeTanque=findViewById(R.id.txtInformeTanque);


        String nombreUsuario = obtenerNombreUsuario();
        txtNombreUsuario.setText("Bienvenido, " + nombreUsuario);

        double cantidadAgua = obtenerCantidadAgua();
        txtInformacion.setText("Usted consume al día alrededor de " + cantidadAgua + " litros de agua.");

        double tanqueAgua=obtenerCantidadTanque();
        txtInformeTanque.setText("El tamaño del tanque con el que cuenta es de "+ tanqueAgua + "galones de agua");

    }


    @SuppressLint("Range")
    private String obtenerNombreUsuario() {
        String nombreUsuario = ""; // Inicializamos con un valor vacío

        try {
            DbCont dbCont = new DbCont(this);
            SQLiteDatabase db = dbCont.getReadableDatabase();

            Cursor cursor = db.query("t_usuarios", new String[]{"nombre"}, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                nombreUsuario = cursor.getString(cursor.getColumnIndex("nombre"));
            }

            cursor.close();
            db.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return nombreUsuario;
    }

    @SuppressLint("Range")
    private double obtenerCantidadAgua() {
        double cantidadAgua = 0.0;

        try {
            DbCont dbCont = new DbCont(this);
            SQLiteDatabase db = dbCont.getReadableDatabase();


            Cursor cursor = db.query("t_registro_datos", new String[]{"cantidad_agua"}, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                cantidadAgua = cursor.getDouble(cursor.getColumnIndex("cantidad_agua"));
            }

            cursor.close();
            db.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return cantidadAgua;
    }
    @SuppressLint("Range")
    private double obtenerCantidadTanque() {
        double cantidadTanque = 0.0; //

        try {
            DbCont dbCont = new DbCont(this);
            SQLiteDatabase db = dbCont.getReadableDatabase();

            Cursor cursor = db.query("t_registro_datos", new String[]{"otro_dato"}, null, null, null, null, null);

            if (cursor.moveToFirst()) {
                cantidadTanque = cursor.getDouble(cursor.getColumnIndex("otro_dato"));
            }

            cursor.close();
            db.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return cantidadTanque;
    }


}
