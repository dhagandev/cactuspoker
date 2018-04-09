package com.example.austin.cactuspoker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

public class Upgrades extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView navigation;
    private TextView mTextMessage;

    protected Intent activityThatCalled;
    private ListView upgrade_cards;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upgrades_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mTextMessage = (TextView) findViewById(R.id.message);

        MenuItem home = navigation.getMenu().getItem(0);
        home.setTitle(R.string.action_home);
        home.setIcon(R.drawable.ic_home_black_24dp);
        setUpUpgradeMain();

        activityThatCalled = getIntent();
        Bundle callingBundle = activityThatCalled.getExtras();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            settingsPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    protected void settingsPressed() {
        Intent settingsIntent = new Intent(this, Settings.class);
        Bundle extras = new Bundle();
        settingsIntent.putExtras(extras);
        final int result = 1;
        startActivityForResult(settingsIntent, result);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_buy_count:
//                    mTextMessage.setText(R.string.action_home);
                    homePressed();
                    return true;
                case R.id.navigation_managers:
//                    mTextMessage.setText(R.string.action_managers);
                    managersPressed();
                    return true;
                case R.id.navigation_upgrades:
//                    mTextMessage.setText(R.string.action_upgrades);
                    upgradesPressed();
                    return true;
            }
            return false;
        }
    };

    protected void homePressed() {
        Intent homeIntent = new Intent(this, MainActivity.class);
        Bundle extras = new Bundle();
        homeIntent.putExtras(extras);
        final int result = 1;
        startActivityForResult(homeIntent, result);
    }

    protected void managersPressed() {
        Intent managersIntent = new Intent(this, Managers.class);
        Bundle extras = new Bundle();
        managersIntent.putExtras(extras);
        final int result = 1;
        startActivityForResult(managersIntent, result);
    }

    protected void upgradesPressed() {
        Intent upgradesIntent = new Intent(this, Upgrades.class);
        Bundle extras = new Bundle();
        upgradesIntent.putExtras(extras);
        final int result = 1;
        startActivityForResult(upgradesIntent, result);
    }

    protected void setUpUpgradeMain() {
        upgrade_cards = (ListView) findViewById(R.id.upgrade_card_listview);
        UpgradeAdapter adapter = new UpgradeAdapter(this);
        adapter.addAll(UpgradeCard.upgrade_collection);
        upgrade_cards.setAdapter(adapter);
    }

}
