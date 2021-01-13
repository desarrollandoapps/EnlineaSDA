package com.desarrollandoapps.enlineasda.entidades;

import com.google.gson.annotations.SerializedName;

public class Clinica {

    @SerializedName("id")
    private Integer id;

    @SerializedName("nombre")
    private String nombre;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("updated_at")
    private String updatedAt;

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}
