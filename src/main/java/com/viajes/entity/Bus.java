package com.viajes.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bus")
    private int idBus;

    // Muchos buses pertenecen a una marca
    @ManyToOne
    @JoinColumn(name = "id_marca_bus", nullable = false)
    @JsonIgnoreProperties({"listaBus"})
    private MarcaBus marcaBus;

    @Column(name = "modelo", nullable = false, length = 100)
    private String modelo;

    @Column(name = "placa", nullable = false, unique = true, length = 10)
    private String placa;

    @Column(name = "capacidad", nullable = false)
    private int capacidad;

    @Column(name = "estado", nullable = false, length = 20)
    private String estado;

    public Bus() {
    }

    public int getIdBus() {
        return idBus;
    }

    public void setIdBus(int idBus) {
        this.idBus = idBus;
    }

    public MarcaBus getMarcaBus() {
        return marcaBus;
    }

    public void setMarcaBus(MarcaBus marcaBus) {
        this.marcaBus = marcaBus;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

	public Bus(int idBus, MarcaBus marcaBus, String modelo, String placa, int capacidad, String estado) {
		super();
		this.idBus = idBus;
		this.marcaBus = marcaBus;
		this.modelo = modelo;
		this.placa = placa;
		this.capacidad = capacidad;
		this.estado = estado;
	}
    
    
    
}