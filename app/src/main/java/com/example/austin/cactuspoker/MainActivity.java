package com.example.austin.cactuspoker;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    BottomNavigationView navigation;
    private TextView mTextMessage;

    private CharSequence buy_string;
    private int buy_count;
    private ListView cacti_cards;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_buy_count:
                    buy_string = item.getTitle();
                    if (buy_string.equals(getString(R.string.buy_1))) {
                        buy_count = 10;
                        buy_string = getString(R.string.buy_10);
                    }
                    else if (buy_string.equals(getString(R.string.buy_10))) {
                        buy_count = 100;
                        buy_string = getString(R.string.buy_100);
                    }
                    else if (buy_string.equals(getString(R.string.buy_100))) {
                        buy_count = 0;
                        buy_string = getString(R.string.buy_max);
                    }
                    else if (buy_string.equals(getString(R.string.buy_max))) {
                        buy_count = 1;
                        buy_string = getString(R.string.buy_1);
                    }
                    item.setTitle(buy_string);
                    return false;
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

    @Override
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
            Log.d(this.getClass().getSimpleName(), "=== Settings pressed, should transition to new page ===");
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //App navigation
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        mTextMessage = (TextView) findViewById(R.id.message);

        setUpContentMain();
    }

    protected void setUpContentMain() {
        buy_count = 0;
        cacti_cards = (ListView) findViewById(R.id.cactus_card_listview);
        CactiAdapter adapter = new CactiAdapter(this);
        adapter.addAll(CactusCard.cactus_collection);
        cacti_cards.setAdapter(adapter);
    }

    public int getBuy_count() {
        return buy_count;
    }
}
