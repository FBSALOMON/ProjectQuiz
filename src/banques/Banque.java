//FERNANDO BOEIRA SALOMON
//BOEF061287 - 06/06/2018
package banques;

import java.util.ArrayList;
import java.util.List;

import questions.Paire;
import questions.Question;

public abstract class Banque {
	protected String nom;
	protected List<Paire> paires = new ArrayList<Paire>();
	
	public Question prochaineQuestion() {
		return null;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public void ajouterPaire(Paire paire) {
		paires.add(paire);
	}
}