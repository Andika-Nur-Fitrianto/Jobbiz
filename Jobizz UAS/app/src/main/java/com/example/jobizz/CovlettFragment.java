package com.example.jobizz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.jobizz.databinding.FragmentCovlettBinding;


public class CovlettFragment extends Fragment {

    FragmentCovlettBinding fragmentCovlettBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        fragmentCovlettBinding = FragmentCovlettBinding.inflate(inflater, container, false);

        fragmentCovlettBinding.tvCovletEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_home, new EditCovletFragment()).commit();
                //fragmentCovlettBinding.tv
                //Toast.makeText(getActivity(), "response", Toast.LENGTH_SHORT).show();

            }
        });

        // Inflate the layout for this fragment
        return fragmentCovlettBinding.getRoot();
    }
}