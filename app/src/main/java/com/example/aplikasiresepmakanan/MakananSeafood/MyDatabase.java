package com.example.aplikasiresepmakanan.MakananSeafood;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_makanan4";
    private static final String tb_makananseafood = "tb_makananseafood";
    private static final String tb_makanan_id = "id";
    private static final String tb_makanan_nama = "nama";
    private static final String tb_makanan_resep = "resep";
    private static final String tb_makanan_gambar = "gambar";
    private static final String CREATE_TABLE_MAKANANSEAFOOD = "CREATE TABLE " +
            tb_makananseafood + "("
            + tb_makanan_id + " INTEGER PRIMARY KEY ,"
            + tb_makanan_nama + " TEXT,"
            + tb_makanan_resep + " TEXT,"
            + tb_makanan_gambar + " TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_MAKANANSEAFOOD);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    public void CreateMakananSeafood (MakananSeafood mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_makanan_id, mdNotif.get_id());
        values.put(tb_makanan_nama, mdNotif.get_nama());
        values.put(tb_makanan_resep, mdNotif.get_resep());
        values.put(tb_makanan_gambar, mdNotif.get_gambar());
        db.insert(tb_makananseafood, null, values);
        db.close();
    }
    public List<MakananSeafood> ReadMakananSeafood() {
        List<MakananSeafood> judulModelList = new ArrayList<MakananSeafood>();
        String selectQuery = "SELECT * FROM " + tb_makananseafood;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                MakananSeafood mdKontak = new MakananSeafood();
                mdKontak.set_id(cursor.getString(0));
                mdKontak.set_nama(cursor.getString(1));
                mdKontak.set_resep(cursor.getString(2));
                mdKontak.set_gambar(cursor.getString(3));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateMakananSeafood (MakananSeafood mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_makanan_nama, mdNotif.get_nama());
        values.put(tb_makanan_resep, mdNotif.get_resep());
        values.put(tb_makanan_gambar, mdNotif.get_gambar());
        return db.update(tb_makananseafood, values, tb_makanan_id + " = ?",
                new String[] { String.valueOf(mdNotif.get_id())});
    }
    public void DeleteMakananSeafood (MakananSeafood mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_makananseafood, tb_makanan_id+ " = ?",
                new String[]{String.valueOf(mdNotif.get_id())});
        db.close();
    }
}
