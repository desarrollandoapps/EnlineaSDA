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
 * Use the {@link NuevoPedidoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NuevoPedidoFragment extends Fragment {

    public NuevoPedidoFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_nuevo_pedido, container, false);
        WebView navegador = view.findViewById(R.id.navegadorNuevoPedido);
        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.setHorizontalScrollBarEnabled( true );
        navegador.loadUrl("https://prueba.enlinea-sda.com/pedidos");
        navegador.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });
        return view;
    }
}
