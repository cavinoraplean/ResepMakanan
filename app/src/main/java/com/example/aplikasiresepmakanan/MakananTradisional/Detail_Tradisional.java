package com.example.aplikasiresepmakanan.MakananTradisional;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasiresepmakanan.R;

public class Detail_Tradisional extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sresep, Sgambar;
    private TextView Enama, Eresep, Egambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tradisional);
        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sresep = i.getStringExtra("Iresep");
        Sgambar = i.getStringExtra("Igambar");
        Enama = (TextView) findViewById(R.id.dtl_nama);
        Eresep = (TextView) findViewById(R.id.dtl_resep);
        Egambar = (TextView) findViewById(R.id.dtl_cara);
        Enama.setText(Snama);
        Eresep.setText(Sresep);
        Egambar.setText(Sgambar);
    }
}