package com.example.aplikasiresepmakanan.MakananSeafood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasiresepmakanan.MakananTradisional.MakananTradisional;
import com.example.aplikasiresepmakanan.R;

import java.util.ArrayList;
import java.util.List;

public class MainReadSeafoodUser extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<MakananSeafood> ListMakananSeafood = new ArrayList<MakananSeafood>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_read_seafood_user);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListMakananSeafood);
        mListView = (ListView) findViewById(R.id.list_MakananSeafoodUser);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMakananSeafood.clear();
        List<MakananSeafood> contacts = db.ReadMakananSeafood();
        for (MakananSeafood cn : contacts) {
            MakananSeafood judulModel = new MakananSeafood();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_resep(cn.get_resep());
            judulModel.set_gambar(cn.get_gambar());
            ListMakananSeafood.add(judulModel);
            if ((ListMakananSeafood.isEmpty()))
                Toast.makeText(MainReadSeafoodUser.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        MakananSeafood obj_itemDetails = (MakananSeafood) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Sresep = obj_itemDetails.get_resep();
        String Sgambar = obj_itemDetails.get_gambar();
        Intent goUpdel = new Intent(MainReadSeafoodUser.this, Detail_Seafood.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iresep", Sresep);
        goUpdel.putExtra("Igambar", Sgambar);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListMakananSeafood.clear();
        mListView.setAdapter(adapter_off);
        List<MakananSeafood> contacts = db.ReadMakananSeafood();
        for (MakananSeafood cn : contacts) {
            MakananSeafood judulModel = new MakananSeafood();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_resep(cn.get_resep());
            judulModel.set_gambar(cn.get_gambar());
            ListMakananSeafood.add(judulModel);
            if ((ListMakananSeafood.isEmpty()))
                Toast.makeText(MainReadSeafoodUser.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
