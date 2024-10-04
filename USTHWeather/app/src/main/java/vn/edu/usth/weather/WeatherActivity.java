package vn.edu.usth.weather;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        ViewPager pager = findViewById(R.id.pager);
        HomeFragmentPagerAdapter adapter = new HomeFragmentPagerAdapter(getSupportFragmentManager());
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab);
        tabLayout.setupWithViewPager(pager);

        mediaPlayer = MediaPlayer.create(this, R.raw.hell);
        if (mediaPlayer != null) {
            mediaPlayer.start();
            mediaPlayer.setOnCompletionListener(mp -> {
                mp.release();
                mediaPlayer = null;
            });
        }

        downloadLogo("https://usth.edu.vn/wp-content/uploads/2021/11/logo.png");
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
            showToast("Refreshing...");
            downloadLogo("https://usth.edu.vn/wp-content/uploads/2021/11/logo.png");
            return true;
        } else if (id == R.id.action_settings) {
            Intent intent = new Intent(this, PrefActivity.class);
            startActivity(intent);
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void showAlertDialog(String title, String message) {
        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }

    private void downloadLogo(String url) {
        // Create an ImageRequest to fetch the image
        ImageRequest imageRequest = new ImageRequest(url,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        ForecastFragment.updateLogo(response); // Assuming you have a method to update the logo
                        showToast("Logo downloaded successfully!");
                    }
                },
                0, // Width
                0, // Height
                ImageView.ScaleType.CENTER_CROP,
                Bitmap.Config.ARGB_8888,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("USTHWeather", "Failed to download logo.", error);
                        showAlertDialog("Error", "Failed to download logo. Please try again.");
                    }
                });

        // Add the request to the RequestQueue
        Volley.newRequestQueue(this).add(imageRequest);
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
