package com.example.aplikasiresepmakanan.MakananTradisional;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasiresepmakanan.R;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<MakananTradisional> ListMakananTradisional = new ArrayList<MakananTradisional>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_tradisional);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListMakananTradisional );
        mListView = (ListView) findViewById(R.id.list_MakananTradisional);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMakananTradisional.clear();
        List<MakananTradisional> contacts = db.ReadMakananTradisional();
        for (MakananTradisional cn : contacts) {
            MakananTradisional judulModel = new MakananTradisional();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_resep(cn.get_resep());
            judulModel.set_gambar(cn.get_gambar());
            ListMakananTradisional.add(judulModel);
            if ((ListMakananTradisional.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        MakananTradisional obj_itemDetails = (MakananTradisional) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Sresep = obj_itemDetails.get_resep();
        String Sgambar = obj_itemDetails.get_gambar();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iresep", Sresep);
        goUpdel.putExtra("Igambar", Sgambar);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListMakananTradisional.clear();
        mListView.setAdapter(adapter_off);
        List<MakananTradisional> contacts = db.ReadMakananTradisional();
        for (MakananTradisional cn : contacts) {
            MakananTradisional judulModel = new MakananTradisional();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_resep(cn.get_resep());
            judulModel.set_gambar(cn.get_gambar());
            ListMakananTradisional.add(judulModel);
            if ((ListMakananTradisional.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
