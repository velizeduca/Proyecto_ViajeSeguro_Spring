package com.viajes.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_asiento")
public class Asiento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_asiento")
	private int idAsiento;
	@ManyToOne
	@JoinColumn(name = "id_bus", nullable = false)
	private Bus bus;
	@Column(name = "nro_asiento", nullable = false, length = 5)
	private String nroAsiento;
	@Column(name = "piso", nullable = false)
	private int piso;
	@Column(name = "estado", nullable = false, length = 20)
	private String estado;

	public Asiento() {
	}
	
	public int getIdAsiento() {
		return idAsiento;
	}
	public void setIdAsiento(int idAsiento) {
		this.idAsiento = idAsiento;
	}
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
	public String getNroAsiento() {
		return nroAsiento;
	}
	public void setNroAsiento(String nroAsiento) {
		this.nroAsiento = nroAsiento;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}