package com.example.aplikasiresepmakanan.MakananPadang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasiresepmakanan.R;

public class MainMakananPadang extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_kue);
    }

    public void btn_create(View view){
        Intent c = new Intent(MainMakananPadang.this, MainCreate.class);
        startActivity(c);
    }
    public void btn_read(View view) {
        Intent b = new Intent(MainMakananPadang.this, MainRead.class);
        startActivity(b);
    }


}
