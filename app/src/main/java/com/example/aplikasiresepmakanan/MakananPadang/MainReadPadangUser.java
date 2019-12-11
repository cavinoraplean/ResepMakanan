package com.example.aplikasiresepmakanan.MakananPadang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasiresepmakanan.MakananTradisional.MakananTradisional;
import com.example.aplikasiresepmakanan.R;

import java.util.ArrayList;
import java.util.List;

public class MainReadPadangUser extends AppCompatActivity implements
        AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<MasakanPadang> ListMakananPadang = new ArrayList<MasakanPadang>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_padang_user);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListMakananPadang);
        mListView = (ListView) findViewById(R.id.list_MakananPadangUser);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListMakananPadang.clear();
        List<MasakanPadang> contacts = db.ReadMasakanPadang();
        for (MasakanPadang cn : contacts) {
            MasakanPadang judulModel = new MasakanPadang();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_resep(cn.get_resep());
            judulModel.set_gambar(cn.get_gambar());
            ListMakananPadang.add(judulModel);
            if ((ListMakananPadang.isEmpty()))
                Toast.makeText(MainReadPadangUser.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        MasakanPadang obj_itemDetails = (MasakanPadang) o;
        String Sid = obj_itemDetails.get_id();
        String Snama = obj_itemDetails.get_nama();
        String Sresep = obj_itemDetails.get_resep();
        String Sgambar = obj_itemDetails.get_gambar();
        Intent goUpdel = new Intent(MainReadPadangUser.this, Detail_Padang.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Iresep", Sresep);
        goUpdel.putExtra("Igambar", Sgambar);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListMakananPadang.clear();
        mListView.setAdapter(adapter_off);
        List<MasakanPadang> contacts = db.ReadMasakanPadang();
        for (MasakanPadang cn : contacts) {
            MasakanPadang judulModel = new MasakanPadang();
            judulModel.set_id(cn.get_id());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_resep(cn.get_resep());
            judulModel.set_gambar(cn.get_gambar());
            ListMakananPadang.add(judulModel);
            if ((ListMakananPadang.isEmpty()))
                Toast.makeText(MainReadPadangUser.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
