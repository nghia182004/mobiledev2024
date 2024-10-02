package vn.edu.usth.weather;

import android.content.Intent;
import android.icu.util.Output;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.os.AsyncTask;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;

import java.io.InputStream;

public class WeatherActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);


        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);


        mediaPlayer = MediaPlayer.create(this, R.raw.hell);
        if (mediaPlayer != null) {
            mediaPlayer.start();

            // Release the MediaPlayer when audio is completed
            mediaPlayer.setOnCompletionListener(mp -> {
                mp.release();
                mediaPlayer = null;
            });
        }



//        ForecastFragment firstFragment = new ForecastFragment();
//        getFragmentManager().beginTransaction().add(
//            R.id.main, firstFragment).commit();
//        Log.i("Weather", "onCreate()");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_weather, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            new RefreshTask().execute();
            //Toast.makeText(this, "Refreshing weather...", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_settings) {
            Intent intent = new Intent(this, PrefActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }

    }

    private class RefreshTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Show toast indicating refresh started (optional)
            Toast.makeText(WeatherActivity.this, "Refreshing...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                // Simulate delay for network request (e.g., 3 seconds)
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Show toast indicating refresh is complete
            Toast.makeText(WeatherActivity.this, "Data refreshed!", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Weather", "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Weather", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Weather", "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Weather", "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Weather", "onDestroy()");
    }
}