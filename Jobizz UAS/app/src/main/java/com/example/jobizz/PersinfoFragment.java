package com.example.jobizz;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.jobizz.databinding.FragmentPersinfoBinding;


public class PersinfoFragment extends Fragment {

    SharedPreferences sharedPreferences;
    FragmentPersinfoBinding binding;
    String id;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sharedPreferences = getActivity().getSharedPreferences("Jobizz App.", MODE_PRIVATE);
        binding = FragmentPersinfoBinding.inflate(inflater, container,false);
        View view = binding.getRoot();

        binding.piUname.setText(sharedPreferences.getString("nama",""));
        binding.piWork.setText(sharedPreferences.getString("jr",""));

        //ambil data personal info
        binding.tvDetEdu.setText(Html.fromHtml(sharedPreferences.getString("ed", ""), Html.FROM_HTML_MODE_LEGACY));
        binding.tvDetEx.setText(Html.fromHtml(sharedPreferences.getString("ex",""), Html.FROM_HTML_MODE_LEGACY));

        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_persinfo, container, false);
    }
}