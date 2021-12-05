package com.example.a1918093_bab7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<Sablon> listSablon = new
            ArrayList<Sablon>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, listSablon
        );
        mListView = (ListView) findViewById(R.id.list_sablon);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        listSablon.clear();
        List<Sablon> sablon = db.ReadSablon();
        for (Sablon mhs : sablon) {
            Sablon daftar = new Sablon();
            daftar.set_id(mhs.get_id());
            daftar.set_jenis(mhs.get_jenis());
            daftar.set_harga(mhs.get_harga());
            listSablon.add(daftar);
            if ((listSablon.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        Sablon detailMhs = (Sablon)o;
        String Sid = detailMhs.get_id();
        String Sjenis = detailMhs.get_jenis();
        String Sharga = detailMhs.get_harga();
        Intent goUpdel = new Intent(MainRead.this,
                MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Ijenis", Sjenis);
        goUpdel.putExtra("Iharga", Sharga);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        listSablon.clear();
        mListView.setAdapter(adapter_off);
        List<Sablon> sablon = db.ReadSablon();
        for (Sablon mhs : sablon) {
            Sablon daftar = new Sablon();
            daftar.set_id(mhs.get_id());
            daftar.set_jenis(mhs.get_jenis());
            daftar.set_harga(mhs.get_harga());
            listSablon.add(daftar);
            if ((listSablon.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
