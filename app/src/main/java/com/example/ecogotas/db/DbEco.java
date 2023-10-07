package com.example.ecogotas.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

// DbEco.java

public class DbEco extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NOMBRE = "EcoG.db";
    public static final String TABLE_USUARIO = "t_usuarios";
    public static final String TABLE_REGISTRO_DATOS = "t_registro_datos";

    public DbEco(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_USUARIO + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "apellidos TEXT NOT NULL," +
                "email TEXT NOT NULL," +
                "EDAD INT," +
                "password TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_REGISTRO_DATOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_usuario INTEGER," +
                "cantidad_agua REAL," +
                "otro_dato TEXT," +
                "FOREIGN KEY(id_usuario) REFERENCES " + TABLE_USUARIO + "(id))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTRO_DATOS);

        if (oldVersion < 2) {
            // Actualización a la versión 2
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_REGISTRO_DATOS);
            sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_REGISTRO_DATOS + "(" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "id_usuario INTEGER," +
                    "cantidad_agua REAL," +
                    "otro_dato TEXT," +
                    "FOREIGN KEY(id_usuario) REFERENCES " + TABLE_USUARIO + "(id))");
        }
    }
}