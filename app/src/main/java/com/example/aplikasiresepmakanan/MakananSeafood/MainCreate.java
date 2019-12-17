package com.example.aplikasiresepmakanan.MakananSeafood;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasiresepmakanan.R;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama, Eresep, Egambar;
    private String Snama, Sresep, Sgambar;
    ImageView mImageView;
    final int REQUEST_CODE_GALLERY=999;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_tradisional);
        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        db = new MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Eresep = (EditText) findViewById(R.id.create_resep);
        Egambar = (EditText) findViewById(R.id.create_gambar);
        Button btnCreate = (Button) findViewById(R.id.btn_tambah);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sresep = String.valueOf(Eresep.getText());
                Sgambar = String.valueOf(Egambar.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Nama Masakan",
                            Toast.LENGTH_SHORT).show();
                } else if (Sresep.equals("")){
                    Eresep.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Resep",
                            Toast.LENGTH_SHORT).show();
                } else if (Sgambar.equals("")){
                    Egambar.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Gambar",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Enama.setText("");
                    Eresep.setText("");
                    Egambar.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateMakananSeafood(new MakananSeafood(null, Snama, Sresep, Sgambar));
                    Intent a = new Intent(MainCreate.this, MainMakananSeafood.class);
                    startActivity(a);
                }
            }
        });
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_GALLERY){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //gallery intent
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, REQUEST_CODE_GALLERY);
            }
            else {
                Toast.makeText(this, "Don't have permission to access file location", Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}

