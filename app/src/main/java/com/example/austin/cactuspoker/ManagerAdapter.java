package com.example.austin.cactuspoker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class ManagerAdapter extends ArrayAdapter<ManagerCard.Manager> {
    private LayoutInflater theInflater = null;

    public ManagerAdapter(Context context) {
        super(context, R.layout.manager_card);
        theInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = theInflater.inflate(R.layout.manager_card, parent, false);
        }
        ManagerCard.Manager manager = getItem(position);
        ImageButton managerImgButton = (ImageButton) convertView.findViewById(R.id.manager_image);
        managerImgButton.setImageResource(manager.manager_image);

        TextView manager_name_tv = (TextView) convertView.findViewById(R.id.manager_name);
        manager_name_tv.setText(manager.manager_name);

        TextView manager_price_tv = (TextView) convertView.findViewById(R.id.manager_price);
        manager_price_tv.setText("" + manager.manager_price);

        return convertView;
    }

}
