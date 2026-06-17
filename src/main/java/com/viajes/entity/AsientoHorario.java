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
@Table(name = "tb_asiento_horario")
public class AsientoHorario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_asiento_horario")
	private int idAsientoHorario;

	@ManyToOne
	@JoinColumn(name = "id_horario", nullable = false)
	private Horario horario;

	@ManyToOne
	@JoinColumn(name = "id_asiento", nullable = false)
	private Asiento asiento;

	@Column(name = "estado", nullable = false, length = 20)
	private String estado;

	public AsientoHorario() {
	}

	public int getIdAsientoHorario() {
		return idAsientoHorario;
	}

	public void setIdAsientoHorario(int idAsientoHorario) {
		this.idAsientoHorario = idAsientoHorario;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public Asiento getAsiento() {
		return asiento;
	}

	public void setAsiento(Asiento asiento) {
		this.asiento = asiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}