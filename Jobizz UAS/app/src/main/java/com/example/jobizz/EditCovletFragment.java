package com.example.jobizz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.jobizz.databinding.FragmentEditCovletBinding;


public class EditCovletFragment extends Fragment {

    FragmentEditCovletBinding fragmentEditCovletBinding;
    int PICK_IMAGE_REQUEST = 99;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        fragmentEditCovletBinding = FragmentEditCovletBinding.inflate(inflater, container, false);

        fragmentEditCovletBinding.tvCovletChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                try {
//                    Intent intent = new Intent();
//                    intent.setType("image/*");
//                    intent.setAction(Intent.ACTION_GET_CONTENT);
//                    startActivityForResult(intent, PICK_IMAGE_REQUEST);
//
//                }
//                catch (Exception e) {
//                    Toast.makeText(getActivity().getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//                }
            }
        });

        // Inflate the layout for this fragment
        return fragmentEditCovletBinding.getRoot();
    }
}