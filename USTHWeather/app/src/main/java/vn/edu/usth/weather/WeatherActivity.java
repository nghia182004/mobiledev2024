package vn.edu.usth.weather;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

public class WeatherActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
//        ForecastFragment firstFragment = new ForecastFragment();
//        getFragmentManager().beginTransaction().add(
//                R.id.main, firstFragment).commit();
//        Log.i("Weather", "onCreate()");
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