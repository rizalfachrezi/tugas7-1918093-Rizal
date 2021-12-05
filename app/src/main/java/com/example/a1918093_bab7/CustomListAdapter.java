package com.example.a1918093_bab7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Sablon> Sablon;
    public CustomListAdapter(Activity activity, List<Sablon>
            Sablon) {
        this.activity = activity;
        this.Sablon = Sablon;
    }
    @Override
    public int getCount() {
        return Sablon.size();
    }
    @Override
    public Object getItem(int location) {
        return Sablon.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView jenis = (TextView)
                convertView.findViewById(R.id.text_jenis);
        TextView harga = (TextView)
                convertView.findViewById(R.id.text_harga);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Sablon m = Sablon.get(position);
        jenis.setText("Jenis : "+ m.get_jenis());
        harga.setText("Harga : "+ m.get_harga());
        return convertView;
    }
}
