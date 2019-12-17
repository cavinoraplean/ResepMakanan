package com.example.aplikasiresepmakanan.MakananSeafood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasiresepmakanan.R;

public class MainMakananSeafood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_tradisional);
        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
    }

    public void btn_create(View view){
        Intent c = new Intent(MainMakananSeafood.this, MainCreate.class);
        startActivity(c);
    }
    public void btn_read(View view) {
        Intent b = new Intent(MainMakananSeafood.this, MainRead.class);
        startActivity(b);
    }


}
