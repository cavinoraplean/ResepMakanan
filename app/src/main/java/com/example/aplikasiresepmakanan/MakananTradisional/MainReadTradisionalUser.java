package com.example.aplikasiresepmakanan.MakananTradisional;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasiresepmakanan.R;

import java.util.ArrayList;
import java.util.List;

public class MainReadTradisionalUser extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<MakananTradisional> ListMakananKue = new ArrayList<MakananTradisional>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_tradisional_user);
        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListMakananKue);
        mListView = (ListView) findViewById(R.id.list_MakananTradisionalUser);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMakananKue.clear();
        List<MakananTradisional> contacts = db.ReadMakananTradisional();
        for (MakananTradisional cn : contacts) {
            MakananTradisional judulModel = new MakananTradisional();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_resep(cn.get_resep());
            judulModel.set_gambar(cn.get_gambar());
            ListMakananKue.add(judulModel);
            if ((ListMakananKue.isEmpty()))
                Toast.makeText(MainReadTradisionalUser.this, "Tidak ada data",
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
        Intent goUpdel = new Intent(MainReadTradisionalUser.this, Detail_Tradisional.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iresep", Sresep);
        goUpdel.putExtra("Igambar", Sgambar);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListMakananKue.clear();
        mListView.setAdapter(adapter_off);
        List<MakananTradisional> contacts = db.ReadMakananTradisional();
        for (MakananTradisional cn : contacts) {
            MakananTradisional judulModel = new MakananTradisional();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_resep(cn.get_resep());
            judulModel.set_gambar(cn.get_gambar());
            ListMakananKue.add(judulModel);
            if ((ListMakananKue.isEmpty()))
                Toast.makeText(MainReadTradisionalUser.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
