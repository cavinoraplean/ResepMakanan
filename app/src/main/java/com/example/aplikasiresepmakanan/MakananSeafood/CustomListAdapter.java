package com.example.aplikasiresepmakanan.MakananSeafood;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aplikasiresepmakanan.R;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<MakananSeafood> movieItems;
    public CustomListAdapter(Activity activity, List<MakananSeafood> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_resep_tradisional, null);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView resep = (TextView) convertView.findViewById(R.id.text_resep);
        TextView gambar = (TextView) convertView.findViewById(R.id.text_gambar);
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        MakananSeafood m = movieItems.get(position);
        nama.setText("Nama Masakan : "+ m.get_nama());
        resep.setText("Resep : "+ m.get_resep());
        gambar.setText("Cara Memasak : "+ m.get_gambar());
        return convertView;
    }
}

