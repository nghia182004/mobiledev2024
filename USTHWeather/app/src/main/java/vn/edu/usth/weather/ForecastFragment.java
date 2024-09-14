package vn.edu.usth.weather;

import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ForecastFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ForecastFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ForecastFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ForecastFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ForecastFragment newInstance(String param1, String param2) {
        ForecastFragment fragment = new ForecastFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Create a new LinearLayout
//        LinearLayout linearLayout = new LinearLayout(getActivity());
//        linearLayout.setOrientation(LinearLayout.VERTICAL); // Set the orientation to vertical
//        linearLayout.setBackgroundColor(0x2000F0FF); // Set background color
//
//        // Create a TextView to display "Thursday"
//        TextView textView = new TextView(getActivity());
//        textView.setText("Thursday");
//        textView.setTextSize(20); // Set the text size
//        textView.setTextColor(Color.BLACK); // Set the text color
//
//        // Create an ImageView to display a weather icon
//        ImageView imageView = new ImageView(getActivity());
//        imageView.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.nt_chancerain));
//
//        // Add the TextView and ImageView to the LinearLayout
//        linearLayout.addView(textView);
//        linearLayout.addView(imageView);
//
//        // Return the LinearLayout as the fragment's view
//        return linearLayout;
        View v = inflater.inflate(R.layout.fragment_forecast, container, false);
        return v;
    }
}
