package com.example.ecogotas.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbCont extends DbEco{

    Context context;


    public DbCont(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long inserteUsuario(String nombre, String apellidos, String email, int EDAD, String password) {
        long id = 0;

        try {
            SQLiteDatabase db = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("nombre", nombre);
            contentValues.put("apellidos", apellidos);
            contentValues.put("email", email);
            contentValues.put("EDAD", EDAD);
            contentValues.put("password", password);

            id = db.insert(TABLE_USUARIO, null, contentValues);

            db.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return id;
    }
    public long insertarDatosUsuario(int idUsuario, double cantidadAgua, String otroDato) {
        long id = 0;

        try {
            SQLiteDatabase db = getWritableDatabase();

            ContentValues contentValues = new ContentValues();
            contentValues.put("id_usuario", idUsuario);
            contentValues.put("cantidad_agua", cantidadAgua);
            contentValues.put("otro_dato", otroDato);

            id = db.insert(TABLE_REGISTRO_DATOS, null, contentValues);

            db.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return id;
    }
    @SuppressLint("Range")
    public int obtenerIdUsuarioPorEmail(String email) {
        int idUsuario = -1;

        try {
            SQLiteDatabase db = getReadableDatabase();

            String[] projection = {"id"};
            String selection = "email = ?";
            String[] selectionArgs = {email};

            Cursor cursor = db.query("t_usuarios", projection, selection, selectionArgs, null, null, null);

            if (cursor.moveToFirst()) {
                idUsuario = cursor.getInt(cursor.getColumnIndex("id"));
            }

            cursor.close();
            db.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return idUsuario;
    }


}
