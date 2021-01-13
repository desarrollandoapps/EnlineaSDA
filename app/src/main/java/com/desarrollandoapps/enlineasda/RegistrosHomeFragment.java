package com.desarrollandoapps.enlineasda;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegistrosHomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistrosHomeFragment extends Fragment {

    View vista;
    Button btnAgua;
    Button btnTemperatura;
    Button btnLimpieza;
    Button btnResiduos;

    public RegistrosHomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment RegistrosHomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistrosHomeFragment newInstance(String param1, String param2) {
        RegistrosHomeFragment fragment = new RegistrosHomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_registros_home, container, false);
        btnAgua = vista.findViewById(R.id.btnRegAgua);
        btnTemperatura = vista.findViewById(R.id.btnRegTemp);
        btnLimpieza = vista.findViewById(R.id.btnRegLimp);
        btnResiduos = vista.findViewById(R.id.btnRegRes);

        btnAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Agua", Toast.LENGTH_SHORT).show();
                FragmentManager fragmentManager;
                Fragment fragment = getParentFragment();
                fragment.getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new RegistroFragment()).commit();
            }
        });
        btnTemperatura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Temp", Toast.LENGTH_SHORT).show();
            }
        });
        btnLimpieza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Limp", Toast.LENGTH_SHORT).show();
            }
        });
        btnResiduos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "Res", Toast.LENGTH_SHORT).show();
            }
        });
        return vista;
    }

}