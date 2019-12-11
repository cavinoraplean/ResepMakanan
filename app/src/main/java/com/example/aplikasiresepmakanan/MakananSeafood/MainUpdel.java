package com.example.aplikasiresepmakanan.MakananSeafood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasiresepmakanan.R;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid, Snama, Sresep, Sgambar;
    private EditText Enama, Eresep, Egambar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updel_tradisional);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Sresep = i.getStringExtra("Iresep");
        Sgambar = i.getStringExtra("Igambar");
        Enama = (EditText) findViewById(R.id.updel_nama);
        Eresep = (EditText) findViewById(R.id.updel_resep);
        Egambar = (EditText) findViewById(R.id.updel_gambar);
        Enama.setText(Snama);
        Eresep.setText(Sresep);
        Egambar.setText(Sgambar);
        Button btnUpdate = (Button) findViewById(R.id.btn_edit);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sresep = String.valueOf(Eresep.getText());
                Sgambar = String.valueOf(Egambar.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Sresep.equals("")){
                    Eresep.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi kelas",
                            Toast.LENGTH_SHORT).show();
                } else if (Sgambar.equals("")){
                    Egambar.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi kelas",
                            Toast.LENGTH_SHORT).show();
                } else {
                    db.UpdateMakananSeafood(new MakananSeafood(Sid, Snama, Sresep, Sgambar));
                    Toast.makeText(MainUpdel.this, "Data telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_hapus);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.UpdateMakananSeafood(new MakananSeafood(Sid, Snama, Sresep, Sgambar));
                Toast.makeText(MainUpdel.this, "Data telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}