package com.example.a1918093_bab7;

public class Sablon {
    private String _id, _jenis, _harga;
    public Sablon(String id, String jenis, String harga) {
        this._id = id;
        this._jenis = jenis;
        this._harga = harga;
    }
    public Sablon() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_jenis() {
        return _jenis;
    }
    public void set_jenis(String _jenis) {
        this._jenis = _jenis;
    }
    public String get_harga() {
        return _harga;
    }
    public void set_harga(String _harga) {
        this._harga = _harga;
    }
}
