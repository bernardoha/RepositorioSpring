package pe.edu.utp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SmartPhone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String marca;
	private String modelo;
	private String descripcion;
	public Long getId() {
		return id;
	}
	public SmartPhone() {
		// TODO Auto-generated constructor stub
	}
	
	public SmartPhone(Long id, String marca, String modelo, String descripcion) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.descripcion = descripcion;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// Getters y Setters
	
}