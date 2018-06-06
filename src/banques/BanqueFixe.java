//FERNANDO BOEIRA SALOMON
//BOEF061287 - 06/06/2018
package banques;

import java.util.concurrent.ThreadLocalRandom;

import questions.Paire;
import questions.Question;

public class BanqueFixe extends Banque{

	
	public Question prochaineQuestion() {
		int randomPaire = ThreadLocalRandom.current().nextInt(0, paires.size());
		Paire paire = paires.get(randomPaire);	
		Question newQuestion = new Question(paire.getElementA(), paire.getElementB());
		
		return newQuestion;		
	}
	
}