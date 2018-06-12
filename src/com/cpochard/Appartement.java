package com.cpochard;

import javax.persistence.*;

@Entity
@Table (name="Appartement")
public class Appartement {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@Column (name = "nombre_pieces")
	private int nombrePieces;
	private int superficie;
	@Column (name = "couleur_murs")
	private String couleurMurs;
	
	@OneToOne (cascade = {CascadeType.ALL})
	@JoinColumn (name = "canape_id")
	private Canape canape;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNombrePieces() {
		return nombrePieces;
	}

	public void setNombrePieces(int nombrePieces) {
		this.nombrePieces = nombrePieces;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public String getCouleurMurs() {
		return couleurMurs;
	}

	public void setCouleurMurs(String couleurMurs) {
		this.couleurMurs = couleurMurs;
	}
	
	public Canape getCanape() {
		return canape;
	}

	public void setCanape(Canape canape) {
		this.canape = canape;
	}

	@Override
	public String toString() {
		return "Appartement [id=" + id + ", nombrePieces=" + nombrePieces + ", superficie=" + superficie
				+ ", couleurMurs=" + couleurMurs + ", canape=" + canape + "]";
	}
	
	public void addCanape(Canape canape) {
		canape.setAppartement(this);
		this.canape = canape;
		
	}

	public Appartement () {}
	
	public Appartement(int nombrePieces, int superficie, String couleurMurs) {
		this.nombrePieces = nombrePieces;
		this.superficie = superficie;
		this.couleurMurs = couleurMurs;
	}

	
	

}
