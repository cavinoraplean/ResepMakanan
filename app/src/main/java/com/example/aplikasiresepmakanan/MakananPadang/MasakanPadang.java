package com.example.aplikasiresepmakanan.MakananPadang;
public class MasakanPadang {
    private String _id, _nama, _resep, _gambar;
    public MasakanPadang(String id, String nama, String resep, String gambar) {
        this._id = id;
        this._nama = nama;
        this._resep = resep;
        this._gambar = gambar;
    }
    public MasakanPadang() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_resep() {
        return _resep;
    }
    public void set_resep(String _resep) {
        this._resep = _resep;
    }
    public String get_gambar() {
        return _gambar;
    }
    public void set_gambar(String _gambar) {
        this._gambar = _gambar;
    }
}