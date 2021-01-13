package com.desarrollandoapps.enlineasda;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.desarrollandoapps.enlineasda.entidades.Clinica;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PedidosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PedidosFragment extends Fragment {

    private ClinicaService clinicaService;

    public PedidosFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_pedidos, container, false);

        /*WebView navegador = view.findViewById(R.id.navegadorPedidos);
        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.setHorizontalScrollBarEnabled( true );
        navegador.loadUrl("https://prueba.enlinea-sda.com/clinicas");
        navegador.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });*/

        /*LinearLayout llBotones = view.findViewById(R.id.llBotones);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT );
        lp.setMargins(0, 0, 0, 10);

        // obtenerClinicas
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://enlinea-sda.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        clinicaService = retrofit.create(ClinicaService.class);
        Call<List<Clinica>> call = clinicaService.listaClinicas();

        call.enqueue(new Callback<List<Clinica>>() {
            @Override
            public void onResponse(Call<List<Clinica>> call, Response<List<Clinica>> response) {
                List<Clinica> clinicas = response.body();

                for (Clinica clinica : clinicas) {
                    Log.i("En Línea","Clínica: " + clinica.getNombre());
                    //Crear botones de cínicas
                    Button button = new Button(getContext());

                    button.setLayoutParams(lp);
                    button.setText( clinica.getNombre() );
                    llBotones.addView(button);
                }
            }

            @Override
            public void onFailure(Call<List<Clinica>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });*/

        WebView navegador = view.findViewById(R.id.navegadorClinicas);
        navegador.getSettings().setJavaScriptEnabled(true);
        navegador.setHorizontalScrollBarEnabled( true );
        navegador.loadUrl("https://prueba.enlinea-sda.com/clinicas");
        navegador.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

        return view;
    }



}
