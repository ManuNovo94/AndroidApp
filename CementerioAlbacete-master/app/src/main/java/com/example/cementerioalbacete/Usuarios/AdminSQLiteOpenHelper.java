package com.example.cementerioalbacete.Usuarios;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NOMBRE= "cementerioab";
    public static final String TABLE_CEMENTERIO ="cementerio";

    public AdminSQLiteOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase BaseDeDatos) {

        BaseDeDatos.execSQL("CREATE TABLE "+TABLE_CEMENTERIO+ "("
                + "nombre text , primerapellido text ,segundoapellido text , anio text , patio text , pabellon  text , fila  text , numero text " +")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase BaseDeDatos, int oldVersion, int newVersion) {
        BaseDeDatos.execSQL("DROP TABLE "+ TABLE_CEMENTERIO);
        onCreate(BaseDeDatos);
    }
}
