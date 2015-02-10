package metier;

public class ModelStateMachine {
	private int id;
	private String nom;
	private ModelUser utilisateur;
	
	public ModelStateMachine(int id, String nom, ModelUser utilisateur){
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
	
	public ModelUser getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(ModelUser utilisateur) {
		this.utilisateur = utilisateur;
	}
}
