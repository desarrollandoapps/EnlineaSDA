package com.desarrollandoapps.enlineasda;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.desarrollandoapps.enlineasda.entidades.Clinica;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView nav;
    private ClinicaService clinicaService;
    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nav = findViewById(R.id.bottomNav);
        contador = 0;
        obtenerClinicas();

        if (savedInstanceState == null)
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).commit();
        }

        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

                switch (item.getItemId())
                {
                    case R.id.home:
                        fragment = new HomeFragment();
                        transaction.addToBackStack(null);
                        break;
                    case R.id.ver_pedidos:
                        fragment = new PedidosFragment();
                        transaction.addToBackStack(null);
                        break;
                    case R.id.nuevo_pedido:
                        fragment = new NuevoPedidoFragment();
                        transaction.addToBackStack(null);
                        break;
                    case R.id.cocina:
                        fragment = new CocinaFragment();
                        transaction.addToBackStack(null);
                        break;
                    case R.id.registros:
                        fragment = new RegistrosHomeFragment();
                        transaction.addToBackStack(null);
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
                return false;
            }
        });
    }

    public void obtenerClinicas( )
    {
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
                    //Toast.makeText(MainActivity.this, clinica.getNombre(), Toast.LENGTH_SHORT).show();
                    Log.i("En Línea","Clínica:" + clinica.getNombre());
                }
            }

            @Override
            public void onFailure(Call<List<Clinica>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        nav.setSelectedItemId(R.id.home);
    }
}
