package com.cpochard;
import javax.persistence.*;

@Entity
@Table (name = "Canape")
public class Canape {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@Column (name = "nombre_places")
	private int nombrePlaces;
	private String couleur;
	
	@OneToOne
	@JoinColumn(name = "appartement_id")
	private Appartement appartement;
	
	public Appartement getAppartement() {
		return appartement;
	}

	public void setAppartement(Appartement appartement) {
		this.appartement = appartement;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNombrePlaces() {
		return nombrePlaces;
	}

	public void setNombrePlaces(int nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	@Override
	public String toString() {
		return "Canape [id=" + id + ", nombrePlaces=" + nombrePlaces + ", couleur=" + couleur + "]";
	}

	public Canape () {}
	
	public Canape(int nombrePlaces, String couleur) {
		this.nombrePlaces = nombrePlaces;
		this.couleur = couleur;
	}
}
