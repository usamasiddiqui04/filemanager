package com.fyp.sofittest.Adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.fyp.sofittest.Fragments.AudioFragment;
import com.fyp.sofittest.Fragments.DocumentsFragment;
import com.fyp.sofittest.Fragments.PhotiFragment;
import com.fyp.sofittest.Fragments.VideoFragment;

public class OrderPagerAdpaters extends FragmentStateAdapter {


    public OrderPagerAdpaters(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position)
        {
            case 0 :
                return new PhotiFragment();
            case 1 :
                return new AudioFragment();
            case 2 :
                return new VideoFragment();

                default:
                    return new DocumentsFragment();


        }
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
