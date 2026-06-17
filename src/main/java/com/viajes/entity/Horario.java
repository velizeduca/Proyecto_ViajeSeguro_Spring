package com.viajes.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_horario")
public class Horario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_horario")
	private int idHorario;

	// Muchos horarios pueden utilizar un mismo bus
	@ManyToOne
	@JoinColumn(name = "id_bus", nullable = false)
	private Bus bus;

	// Muchos horarios pueden utilizar una misma ruta
	@ManyToOne
	@JoinColumn(name = "id_ruta", nullable = false)
	private Ruta ruta;

	@Column(name = "fecha_salida", nullable = false)
	private LocalDate fechaSalida;

	@Column(name = "hora_salida", nullable = false)
	private LocalTime horaSalida;

	@Column(name = "estado", nullable = false, length = 20)
	private String estado;

	public Horario() {
	}

	public int getIdHorario() {
		return idHorario;
	}

	public void setIdHorario(int idHorario) {
		this.idHorario = idHorario;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

	public LocalDate getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDate fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalTime getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(LocalTime horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}