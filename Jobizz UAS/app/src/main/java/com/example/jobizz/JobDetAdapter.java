package com.example.jobizz;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class JobDetAdapter extends FragmentStateAdapter {

    String[] tabTitles = new String[] { "Description" , "Requirement", "About" };

    public JobDetAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position) {
            case 0:
                return new DescriptionFragment();

            case 1:
                return new RequirementFragment();

            case 2:
                return new AboutFragment();
        }


        return new DescriptionFragment();
    }

    @Override
    public int getItemCount() {
        return tabTitles.length;
    }
}
