package com.example.aplikasiresepmakanan;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aplikasiresepmakanan.MakananPadang.MainReadPadangUser;
import com.example.aplikasiresepmakanan.MakananSeafood.MainReadSeafoodUser;
import com.example.aplikasiresepmakanan.MakananTradisional.MainReadTradisionalUser;
import com.example.aplikasiresepmakanan.MasakanKue.MainMakananKue;
import com.example.aplikasiresepmakanan.MasakanKue.MainReadKueUser;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth Auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dtlkue(View view){
        Intent a = new Intent(MainActivity.this, MainReadKueUser.class);
        startActivity(a);
    }
    public void dtltradi(View view){
        Intent a = new Intent(MainActivity.this, MainReadTradisionalUser.class);
        startActivity(a);
    }

    public void dtlsea(View view){
        Intent a = new Intent(MainActivity.this, MainReadSeafoodUser.class);
        startActivity(a);
    }

    public void dtlpadang(View view){
        Intent a = new Intent(MainActivity.this, MainReadPadangUser.class);
        startActivity(a);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.about){
            startActivity(new Intent(this, About.class));
        } else if (item.getItemId() == R.id.login) {
            startActivity(new Intent(this, Login.class));
        }
        return true;
    }
}

