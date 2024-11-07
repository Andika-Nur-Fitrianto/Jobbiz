package com.example.jobizz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jobizz.databinding.FragmentPortfolioBinding;

import java.util.List;


public class PortfolioFragment extends Fragment {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ViewAdapter viewAdapter;
    List<String> listData;
    FragmentPortfolioBinding fragmentPortfolioBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentPortfolioBinding = FragmentPortfolioBinding.inflate(inflater, container, false);
//        recyclerView = fragmentPortfolioBinding.rvPortfolio;
//        listData = new ArrayList<>();
//
//        for(int i=0; i<10; i++) {
//            listData.add("Data ke "+i);
//        }

//        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerView.setLayoutManager(linearLayoutManager);
//
//        viewAdapter = new ViewAdapter(this, listData);
//        recyclerView.setAdapter(viewAdapter);
//        viewAdapter.notifyDataSetChanged();

        return fragmentPortfolioBinding.getRoot();
    }
}