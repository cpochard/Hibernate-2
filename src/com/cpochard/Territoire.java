package com.cpochard;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table (name = "Territoire")
public class Territoire {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	@Column (name = "type_territoire")
	private String type;
	private int superficie;
	@OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Animal> animaux = new ArrayList<>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public List<Animal> getAnimaux() {
		return animaux;
	}

	public void setAnimaux(List<Animal> animaux) {
		this.animaux = animaux;
	}
	
	@Override
	public String toString() {
		return "Territoire [id=" + id + ", type=" + type + ", superficie=" + superficie + ", list=" + animaux + "]";
	}
	
	public Territoire() {}
	
	public Territoire(String tmpType, int tmpSuperficie) {
		type = tmpType;
		superficie = tmpSuperficie;
	}
		
}
