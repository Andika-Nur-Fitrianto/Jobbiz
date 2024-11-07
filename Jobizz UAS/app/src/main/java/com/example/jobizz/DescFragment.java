package com.example.jobizz;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.jobizz.databinding.FragmentDescBinding;


public class DescFragment extends Fragment {

    SharedPreferences sharedPreferences;
    FragmentDescBinding fragmentDescBinding;
    String jobdet_id, comp_url, web_url;
    JobDetAdapter pagerAdapter;
    String[] tabTitles = new String[] { "Description" , "Requirement", "About" };
    Bundle bundle;

    public DescFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentDescBinding = FragmentDescBinding.inflate(inflater, container, false);
        sharedPreferences = getActivity().getSharedPreferences("Jobizz App.", MODE_PRIVATE);

       // pagerAdapter = new JobDetAdapter(this);

        jobdet_id = sharedPreferences.getString("jobdet_id","").toString();
        //fragmentDescBinding.jdTvLocation.setText(jobdet_id);
        if (jobdet_id.contentEquals("cv1")) {
            fragmentDescBinding.jdTvJobrole.setText(sharedPreferences.getString("cv1jobrole",""));
            fragmentDescBinding.jdTvComp.setText(sharedPreferences.getString("cv1office",""));
            fragmentDescBinding.jdTvJobtype.setText(sharedPreferences.getString("cv1type",""));
            fragmentDescBinding.jdTvJobtime.setText(sharedPreferences.getString("cv1time",""));
            fragmentDescBinding.jdTvJunior.setText(sharedPreferences.getString("cv1junior",""));
            fragmentDescBinding.jdTvLocation.setText(sharedPreferences.getString("cv1location",""));
            fragmentDescBinding.jdTvSalary.setText(sharedPreferences.getString("cv1salary",""));
        }

        if (jobdet_id.contentEquals("cv2")) {
            fragmentDescBinding.jdTvJobrole.setText(sharedPreferences.getString("cv2jobrole",""));
            fragmentDescBinding.jdTvComp.setText(sharedPreferences.getString("cv2office",""));
            fragmentDescBinding.jdTvJobtype.setText(sharedPreferences.getString("cv2type",""));
            fragmentDescBinding.jdTvJobtime.setText(sharedPreferences.getString("cv2time",""));
            fragmentDescBinding.jdTvJunior.setText(sharedPreferences.getString("cv2junior",""));
            fragmentDescBinding.jdTvLocation.setText(sharedPreferences.getString("cv2location",""));
            fragmentDescBinding.jdTvSalary.setText(sharedPreferences.getString("cv2salary",""));
        }

        if (jobdet_id.contentEquals("cv3")) {
            fragmentDescBinding.jdTvJobrole.setText(sharedPreferences.getString("cv3jobrole",""));
            fragmentDescBinding.jdTvComp.setText(sharedPreferences.getString("cv3office",""));
            fragmentDescBinding.jdTvJobtype.setText(sharedPreferences.getString("cv3type",""));
            fragmentDescBinding.jdTvJobtime.setText(sharedPreferences.getString("cv3time",""));
            fragmentDescBinding.jdTvJunior.setText(sharedPreferences.getString("cv3junior",""));
            fragmentDescBinding.jdTvLocation.setText(sharedPreferences.getString("cv3location",""));
            fragmentDescBinding.jdTvSalary.setText(sharedPreferences.getString("cv3salary",""));
        }

        if (jobdet_id.contentEquals("pj1")) {
            fragmentDescBinding.jdTvJobrole.setText(sharedPreferences.getString("jp1jobrole",""));
            fragmentDescBinding.jdTvComp.setText(sharedPreferences.getString("jp1office",""));
            fragmentDescBinding.jdTvJobtype.setText(sharedPreferences.getString("jp1type",""));
            fragmentDescBinding.jdTvJobtime.setText(sharedPreferences.getString("jp1time",""));
            fragmentDescBinding.jdTvJunior.setText(sharedPreferences.getString("jp1junior",""));
            fragmentDescBinding.jdTvLocation.setText(sharedPreferences.getString("jp1location",""));
            fragmentDescBinding.jdTvSalary.setText(sharedPreferences.getString("jp1salary",""));
        }

        if (jobdet_id.contentEquals("pj2")) {
            fragmentDescBinding.jdTvJobrole.setText(sharedPreferences.getString("jp2jobrole",""));
            fragmentDescBinding.jdTvComp.setText(sharedPreferences.getString("jp2office",""));
            fragmentDescBinding.jdTvJobtype.setText(sharedPreferences.getString("jp2type",""));
            fragmentDescBinding.jdTvJobtime.setText(sharedPreferences.getString("jp2time",""));
            fragmentDescBinding.jdTvJunior.setText(sharedPreferences.getString("jp2junior",""));
            fragmentDescBinding.jdTvLocation.setText(sharedPreferences.getString("jp2location",""));
            fragmentDescBinding.jdTvSalary.setText(sharedPreferences.getString("jp2salary",""));
        }

        fragmentDescBinding.jdTvComp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle = new Bundle();
                comp_url = jobdet_id + "link";
                //fragmentDescBinding.jdTvLocation.setText(comp_url);
                web_url = sharedPreferences.getString(comp_url,"");
                bundle.putString("url", web_url);
                WebFragment webFragment = new WebFragment();
                webFragment.setArguments(bundle);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_home, webFragment).commit();
            }
        });
        
        return fragmentDescBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        fragmentDescBinding = null;
    }
}