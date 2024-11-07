package com.example.jobizz;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;


public class ResumeFragment extends Fragment {

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resume, container, false);

        WebView webView = view.findViewById(R.id.webView);

        // Enable JavaScript (if needed)
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        // Set a WebViewClient to handle redirects within the WebView
        webView.setWebViewClient(new WebViewClient());

        // Load the URL
        webView.loadUrl("https://www.cvmaker.co.id/?utm_medium=cpc&utm_source=google&utm_term=cv%20maker&utm_campaign=0.0+Merknaam+(INDO)+%5BID%5D&hsa_acc=7102626086&hsa_cam=11875392475&hsa_grp=110630109490&hsa_ad=487146017257&hsa_src=g&hsa_tgt=kwd-31268303&hsa_kw=cv%20maker&hsa_mt=b&hsa_net=adwords&hsa_ver=3&gclid=CjwKCAiAvoqsBhB9EiwA9XTWGe1Qc2yPcEbQwSkuDddsk9AcHioAA8KcQ15xdRCacUQF3hqhu8gEaxoCZX8QAvD_BwE");

        return view;
    }
}