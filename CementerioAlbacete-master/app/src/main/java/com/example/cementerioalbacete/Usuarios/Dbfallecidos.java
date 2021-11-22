package com.example.cementerioalbacete.Usuarios;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Dbfallecidos extends AdminSQLiteOpenHelper {

    Context context;
    ArrayList<String> datoslista;

    public Dbfallecidos(@Nullable Context context) {
        super(context);
        this.context = context;
    }
    public long Insertadato(String nombre,String apellido1,String apellido2,String anio, String patio,String pabellon, String fila, String numero){
       long id=0;
        try {
            AdminSQLiteOpenHelper helper = new AdminSQLiteOpenHelper(context);
            SQLiteDatabase db = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombre", nombre.toUpperCase());
            values.put("primerapellido", apellido1.toUpperCase());
            values.put("segundoapellido", apellido2.toUpperCase());
            values.put("anio", anio);
            values.put("patio", patio);
            values.put("pabellon", pabellon);
            values.put("fila", fila);
            values.put("numero", numero);

             id = db.insert(TABLE_CEMENTERIO, null, values);
        }catch(Exception ex){
            ex.toString();
        }
        return  id ;

    }
    public String consulta (String nombre,String apellido,String apellido2,String anio){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context);
        SQLiteDatabase basededatos = admin.getWritableDatabase();

        String Datos="";
        String patio="";
        String pabellon= "";
        String filac = "";
        String numero = "";

            Cursor fila = basededatos.rawQuery("SELECT patio,pabellon,fila,numero FROM "+ TABLE_CEMENTERIO+ " WHERE primerapellido ="+"'" + apellido+
                    "'" +"AND segundoapellido="+"'"+apellido2+"'" +"AND nombre="+"'"+nombre+"'" +"AND anio="+"'"+anio+"'", null);

            if (fila.moveToFirst()) {
                patio=(fila.getString(0));
                pabellon=(fila.getString(1));
                filac=(fila.getString(2));
                numero=(fila.getString(3));

                Datos = " Patio: " + patio + "   Pabellón " + pabellon+ "   Fila: " + filac + "   Número: " + numero;



                basededatos.close();
             return Datos;
            }
            else


                Toast.makeText(context,"No existe",Toast.LENGTH_LONG).show();
            basededatos.close();

return "";

    }

    public ArrayList<Cementerio> consultalist (String nombre, String apellido, String apellido2, String anio){
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(context);
        SQLiteDatabase basededatos = admin.getWritableDatabase();
        ArrayList<Cementerio> datos = new ArrayList<>() ;
        Cementerio c = null;
        Cursor fila=null;


        fila=basededatos.rawQuery("SELECT patio,pabellon,fila,numero FROM "+ TABLE_CEMENTERIO+ " WHERE primerapellido ="+"'" + apellido+
                "'" +"AND segundoapellido="+"'"+apellido2+"'" +"AND nombre="+"'"+nombre+"'" +"AND anio="+"'"+anio+"'", null);



        if(fila.moveToFirst())
        {
            do
                {
                    c= new Cementerio();
                    c.setPatio(fila.getString(0));
                    c.setPabellon(fila.getString(1));
                    c.setFila(fila.getString(2));
                    c.setNumero(fila.getString(3));
                    datos.add(c);

                }
            while(fila.moveToNext());
        }

        else {
            Toast.makeText(context, "No existe", Toast.LENGTH_LONG).show();
            basededatos.close();

            return datos;
        }



        fila.close();



            return datos;


    }

}
