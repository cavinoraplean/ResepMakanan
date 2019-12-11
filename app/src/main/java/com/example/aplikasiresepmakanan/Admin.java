package com.example.aplikasiresepmakanan;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.aplikasiresepmakanan.MakananPadang.MainMakananPadang;
import com.example.aplikasiresepmakanan.MakananSeafood.MainMakananSeafood;
import com.example.aplikasiresepmakanan.MakananTradisional.MainMakananTradisional;
import com.example.aplikasiresepmakanan.MasakanKue.MainMakananKue;

public class Admin extends AppCompatActivity {
    private Button btnlogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        btnlogout = (Button) findViewById(R.id.btnlogout);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        // set title dialog
        alertDialogBuilder.setTitle("Apakah Anda Ingin Logout?");

        // set pesan dari dialog
        alertDialogBuilder
                .setMessage("Klik Ya untuk Logout!")
                .setIcon(R.mipmap.logo3)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // jika tombol diklik, maka akan menutup activity ini
                        Admin.this.finish();
                        Toast.makeText(Admin.this,
                                "Anda Telah Logout"
                                , Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // jika tombol ini diklik, akan menutup dialog
                        // dan tidak terjadi apa2
                        dialog.cancel();
                    }
                });

        // membuat alert dialog dari builder
        AlertDialog alertDialog = alertDialogBuilder.create();

        // menampilkan alert dialog
        alertDialog.show();
    }

    public void logoutklik(View view){
        Intent a = new Intent(Admin.this, MainActivity.class);
        startActivity(a);
//        auth.signOut();
    }

    public void btnmakanantradisional(View view){
        Intent c = new Intent(Admin.this, MainMakananTradisional.class);
        startActivity(c);
    }

    public void btnseafood(View view){
        Intent c = new Intent(Admin.this, MainMakananSeafood.class);
        startActivity(c);
    }

    public void btnpadang(View view){
        Intent c = new Intent(Admin.this, MainMakananPadang.class);
        startActivity(c);
    }

    public void btnmakanankue(View view){
        Intent c = new Intent(Admin.this, MainMakananKue.class);
        startActivity(c);
    }
}
