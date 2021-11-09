package PRM391.getDriverLicense.activities;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;

public class TrafficSignFragment extends Fragment {
    public static final String ARG_PAGE = "arg_page";

    public TrafficSignFragment() {
    }

    public TrafficSignFragment newInstance(int resource) {
        TrafficSignFragment fragment = new TrafficSignFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, resource);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        ImageView imageView = new ImageView(getActivity());
        imageView.setForegroundGravity(Gravity.CENTER);
        imageView.setImageResource(args.getInt(ARG_PAGE));
        return imageView;
    }
}
