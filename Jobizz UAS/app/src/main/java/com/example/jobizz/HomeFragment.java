package com.example.jobizz;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.jobizz.databinding.FragmentHomeBinding;


public class HomeFragment extends Fragment {

    SharedPreferences sharedPreferences;
    FragmentHomeBinding fragmentHomeBinding;
    String fileimage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater, container, false);
        sharedPreferences = getActivity().getSharedPreferences("Jobizz App.", MODE_PRIVATE);
        fragmentHomeBinding.tvHomeUname.setText(sharedPreferences.getString("nama",""));
        
        //featured job card 1
        fragmentHomeBinding.cv1TvJobrole.setText(sharedPreferences.getString("cv1jobrole",""));
        fragmentHomeBinding.cv1TvComp.setText(sharedPreferences.getString("cv1office",""));
        fragmentHomeBinding.cv1TvJobtype.setText(sharedPreferences.getString("cv1type",""));
        fragmentHomeBinding.cv1TvJobtime.setText(sharedPreferences.getString("cv1time",""));
        fragmentHomeBinding.cv1TvJunior.setText(sharedPreferences.getString("cv1junior",""));
        fragmentHomeBinding.cv1TvLocation.setText(sharedPreferences.getString("cv1location",""));
        fragmentHomeBinding.cv1TvSalary.setText(sharedPreferences.getString("cv1salary",""));

        //featured job card 2
        fragmentHomeBinding.cv2TvJobrole.setText(sharedPreferences.getString("cv2jobrole",""));
        fragmentHomeBinding.cv2TvComp.setText(sharedPreferences.getString("cv2office",""));
        fragmentHomeBinding.cv2TvJobtype.setText(sharedPreferences.getString("cv2type",""));
        fragmentHomeBinding.cv2TvJobtime.setText(sharedPreferences.getString("cv2time",""));
        fragmentHomeBinding.cv2TvJunior.setText(sharedPreferences.getString("cv2junior",""));
        fragmentHomeBinding.cv2TvLocation.setText(sharedPreferences.getString("cv2location",""));
        fragmentHomeBinding.cv2TvSalary.setText(sharedPreferences.getString("cv2salary",""));

        //featured job card 3
        fragmentHomeBinding.cv3TvJobrole.setText(sharedPreferences.getString("cv3jobrole",""));
        fragmentHomeBinding.cv3TvComp.setText(sharedPreferences.getString("cv3office",""));
        fragmentHomeBinding.cv3TvJobtype.setText(sharedPreferences.getString("cv3type",""));
        fragmentHomeBinding.cv3TvJobtime.setText(sharedPreferences.getString("cv3time",""));
        fragmentHomeBinding.cv3TvJunior.setText(sharedPreferences.getString("cv3junior",""));
        fragmentHomeBinding.cv3TvLocation.setText(sharedPreferences.getString("cv3location",""));
        fragmentHomeBinding.cv3TvSalary.setText(sharedPreferences.getString("cv3salary",""));

        //popular job1
        fragmentHomeBinding.cpj1Tv1.setText(sharedPreferences.getString("jp1jobrole",""));
        fragmentHomeBinding.cpj1Tv2.setText(sharedPreferences.getString("jp1office",""));
        fragmentHomeBinding.cpj1TvLocation.setText(sharedPreferences.getString("jp1location",""));
        fragmentHomeBinding.cpj1TvSalary.setText(sharedPreferences.getString("jp1salary",""));

        //popular job2
        fragmentHomeBinding.cpj2Tv1.setText(sharedPreferences.getString("jp2jobrole",""));
        fragmentHomeBinding.cpj2Tv2.setText(sharedPreferences.getString("jp2office",""));
        fragmentHomeBinding.cpj2TvLocation.setText(sharedPreferences.getString("jp2location",""));
        fragmentHomeBinding.cpj2TvSalary.setText(sharedPreferences.getString("jp2salary",""));

        fragmentHomeBinding.card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_home, new DescFragment()).commit();
                //startActivity(new Intent(getActivity().getApplicationContext(), TabDetJobActivity.class));
                //finish();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("jobdet_id", "cv1");
                editor.apply();
            }
        });

        fragmentHomeBinding.card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_home, new DescFragment()).commit();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("jobdet_id", "cv2");
                editor.apply();
            }
        });

        fragmentHomeBinding.card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_home, new DescFragment()).commit();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("jobdet_id", "cv3");
                editor.apply();
            }
        });

        fragmentHomeBinding.cardPj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_home, new DescFragment()).commit();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("jobdet_id", "pj1");
                editor.apply();
            }
        });

        fragmentHomeBinding.cardPj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_home, new DescFragment()).commit();
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("jobdet_id", "pj2");
                editor.apply();
            }
        });

        return fragmentHomeBinding.getRoot();

//        View view = inflater.inflate(R.layout.fragment_home, container, false);
//        card1 = view.findViewById(R.id.card1);
//        card1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_home, new DescFragment()).commit();
//            }
//        });
//
//
//        return view;

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentHomeBinding = null;
    }
}