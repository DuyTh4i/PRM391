package PRM391.getDriverLicense.activities;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import PRM391.getDriverLicense.R;

public class ViewStateAdapter extends FragmentStateAdapter {

    public ViewStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int resource = R.drawable.bienbaocam;
        switch (position)
        {
            case 0:
                resource = R.drawable.bienbaocam;
                break;
            case 1:
                resource = R.drawable.bienbaonguyhiem;
                break;
            case 2:
                resource = R.drawable.bienchidan;
                break;
            case 3:
                resource = R.drawable.bienhieulenh;
                break;
            case 4:
                resource = R.drawable.bienphu;
                break;
            case 5:
                resource = R.drawable.vachkeduong;
                break;
            default:
                break;
        }
        TrafficSignFragment showTrafficSign = new TrafficSignFragment().newInstance(resource);
        return showTrafficSign;
    }

    @Override
    public int getItemCount() {
        // Hardcoded, use lists
        return 6;
    }
}
