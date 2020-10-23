package com.runcode.baro.ui.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.runcode.baro.ui.CatalogFragment;
import com.runcode.baro.ui.HomeFragment;
import com.runcode.baro.ui.SettingsFragment;


public class PagerAdapter extends FragmentPagerAdapter {

    onChangeFragmentListener mListener;

    public void setListener(onChangeFragmentListener listener) {
        mListener = listener;
    }

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        mListener.onChange(position,"Home");
        Fragment main = new HomeFragment();
        switch (position) {
            case 0:
                if (mListener != null)
                    mListener.onChange(position, "Home");
                main = new HomeFragment();
                break;
            case 1:
                if (mListener != null)
                    mListener.onChange(position, "Explore");
                main = new CatalogFragment();
                break;
            case 2:
                if (mListener != null)
                    mListener.onChange(position, "Settings");
                main = new SettingsFragment();
                break;
        }
        return main;
    }

    @Override
    public int getCount() {
        return 3;
    }

    public interface onChangeFragmentListener {
        void onChange(int position, String title);
    }

}
