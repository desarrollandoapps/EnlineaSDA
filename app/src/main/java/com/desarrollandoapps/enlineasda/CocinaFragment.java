package com.desarrollandoapps.enlineasda;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CocinaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CocinaFragment extends Fragment {

    public CocinaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_cocina, container, false);
        WebView navegador = view.findViewById(R.id.navegadorCocina);
        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.setHorizontalScrollBarEnabled( true );
        navegador.loadUrl("https://prueba.enlinea-sda.com/cocina");
        navegador.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        return view;
    }
}
