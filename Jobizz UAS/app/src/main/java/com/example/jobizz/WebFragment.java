package com.example.jobizz;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;

import com.example.jobizz.databinding.FragmentWebBinding;


public class WebFragment extends Fragment {

    SharedPreferences sharedPreferences;
    FragmentWebBinding fragmentWebBinding;
    WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        sharedPreferences = getActivity().getSharedPreferences("Jobizz App.", MODE_PRIVATE);
        fragmentWebBinding = FragmentWebBinding.inflate(inflater, container, false);

        Bundle bundle = this.getArguments();
        //fragmentWebBinding.cek2.setText(bundle.getString("url"));
        //fragmentWebBinding.webviewUrl.loadUrl(bundle.getString("url"));
        webView = fragmentWebBinding.webView;
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(bundle.getString("url"));


        return fragmentWebBinding.getRoot();
    }
}