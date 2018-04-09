package com.example.austin.cactuspoker;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class CactiAdapter extends ArrayAdapter<CactusCard.Cactus>{
    private LayoutInflater theInflater = null;

    public CactiAdapter(Context context) {
        super(context, R.layout.cactus_card);
        theInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = theInflater.inflate(R.layout.cactus_card, parent, false);
        }
        final CactusCard.Cactus cactus = getItem(position);
        ImageButton cactusImgButton = (ImageButton) convertView.findViewById(R.id.cactus_image);
        cactusImgButton.setImageResource(cactus.cactus_image);

        cactusImgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(this.getClass().getSimpleName(), "=== This cactus was clicked: " + cactus.cactus_name);
            }
        });

        TextView cactus_name_tv = (TextView) convertView.findViewById(R.id.cactus_name);
        cactus_name_tv.setText(cactus.cactus_name);

        TextView cactus_ps_tv = (TextView) convertView.findViewById(R.id.cactus_ps);
        cactus_ps_tv.setText("" + cactus.cactus_value);

        Button buy_Button = (Button) convertView.findViewById(R.id.buy_button);
        

        return convertView;
    }
}
