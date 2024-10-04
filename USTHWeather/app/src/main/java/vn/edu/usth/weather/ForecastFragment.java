package vn.edu.usth.weather;

import android.graphics.Bitmap;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ForecastFragment extends Fragment {

    private static ImageView logo;

    public ForecastFragment() {
    }

    public static ForecastFragment newInstance(String param1, String param2) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle args = new Bundle();
        args.putString("param1", param1);
        args.putString("param2", param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_forecast, container, false);
        logo = v.findViewById(R.id.logo);
        return v;
    }

    // Method to update the logo ImageView
    public static void updateLogo(Bitmap bitmap) {
        if (logo != null) {
            logo.setImageBitmap(bitmap);
        }
    }
}