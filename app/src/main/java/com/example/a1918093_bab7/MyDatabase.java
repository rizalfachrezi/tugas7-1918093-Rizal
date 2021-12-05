package com.example.a1918093_bab7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_konveksi";
    private static final String tb_sablon = "tb_sablon";
    private static final String tb_sablon_id = "id";
    private static final String tb_sablon_jenis = "jenis";
    private static final String tb_sablon_harga = "harga";
    private static final String CREATE_TABLE_Sablon = "CREATE TABLE "
            + tb_sablon +"("
            + tb_sablon_id + " INTEGER PRIMARY KEY ,"
            + tb_sablon_jenis + " TEXT ,"
            + tb_sablon_harga + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_Sablon);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreateSablon(Sablon data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_sablon_id, data.get_id());
        values.put(tb_sablon_jenis, data.get_jenis());
        values.put(tb_sablon_harga, data.get_harga());
        db.insert(tb_sablon, null, values);
        db.close();
    }
    public List<Sablon> ReadSablon() {
        List<Sablon> listMhs = new ArrayList<Sablon>();
        String selectQuery = "SELECT * FROM " + tb_sablon;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Sablon data = new Sablon();
                data.set_id(cursor.getString(0));
                data.set_jenis(cursor.getString(1));
                data.set_harga(cursor.getString(2));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdateSablon (Sablon data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_sablon_jenis, data.get_jenis());
        values.put(tb_sablon_harga, data.get_harga());
        return db.update(tb_sablon, values, tb_sablon_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeleteSablon(Sablon data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_sablon,tb_sablon_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}
