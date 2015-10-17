package com.example.caesar.pulltorefresh;

import android.app.Activity;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SwipeRefreshLayout swipeview = (SwipeRefreshLayout) findViewById(R.id.swipe);
        final TextView rndNum = (TextView) findViewById(R.id.lb1);
        final TextView swipingText = (TextView) findViewById(R.id.swipeinfo);


        swipeview.setColorSchemeResources(android.R.color.holo_blue_dark, android.R.color.holo_blue_light, android.R.color.holo_green_light, android.R.color.holo_green_dark);
        swipeview.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipingText.setVisibility(View.GONE);
                swipeview.setRefreshing(true);
                Log.d("swipe", "REfreshing number");
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeview.setRefreshing(false);
                        double f = Math.random();
                        rndNum.setText(String.valueOf(f));
                        // swipingText.setVisibility(View.VISIBLE);
                    }
                }, 3000);
            }
        });
    }

}
