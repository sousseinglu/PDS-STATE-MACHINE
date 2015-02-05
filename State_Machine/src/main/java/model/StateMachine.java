package model;

public class StateMachine {
	private int id;
	private String nom;
	private User utilisateur;
	
	public StateMachine(int id, String nom, User utilisateur){
		this.id = id;
		this.nom = nom;
		this.utilisateur = utilisateur;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public User getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(User utilisateur) {
		this.utilisateur = utilisateur;
	}
}
