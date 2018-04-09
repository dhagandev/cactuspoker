package com.example.austin.cactuspoker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class UpgradeAdapter extends ArrayAdapter<UpgradeCard.Upgrade> {
    private LayoutInflater theInflater = null;

    public UpgradeAdapter(Context context) {
        super(context, R.layout.upgrade_card);
        theInflater = LayoutInflater.from(getContext());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = theInflater.inflate(R.layout.upgrade_card, parent, false);
        }
        UpgradeCard.Upgrade upgrade = getItem(position);
        ImageButton upgradeImgButton = (ImageButton) convertView.findViewById(R.id.upgrade_image);
        upgradeImgButton.setImageResource(upgrade.upgrade_image);

        TextView upgrade_name_tv = (TextView) convertView.findViewById(R.id.upgrade_name);
        upgrade_name_tv.setText(upgrade.upgrade_name);

        TextView upgrade_price_tv = (TextView) convertView.findViewById(R.id.upgrade_price);
        upgrade_price_tv.setText("" + upgrade.upgrade_price);

        return convertView;
    }
}
