package com.desarrollandoapps.enlineasda;

import com.desarrollandoapps.enlineasda.entidades.Clinica;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClinicaService {

    @GET("clinicas")
    Call<List<Clinica>> listaClinicas();
}
