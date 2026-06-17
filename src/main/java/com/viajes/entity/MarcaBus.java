package com.viajes.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_marca_bus")
public class MarcaBus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca_bus")
    private int idMarcaBus;

    @Column(name = "nombre", nullable = false, unique = true, length = 100)
    private String nombre;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    // Una marca tiene muchos buses
    @OneToMany(mappedBy = "marcaBus")
    @JsonIgnore
    private List<Bus> listaBus;

    public MarcaBus() {
    }

    public int getIdMarcaBus() {
        return idMarcaBus;
    }

    public void setIdMarcaBus(int idMarcaBus) {
        this.idMarcaBus = idMarcaBus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Bus> getListaBus() {
        return listaBus;
    }

    public void setListaBus(List<Bus> listaBus) {
        this.listaBus = listaBus;
    }
}