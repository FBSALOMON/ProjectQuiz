//FERNANDO BOEIRA SALOMON
//BOEF061287 - 06/06/2018
package banques;

import java.util.concurrent.ThreadLocalRandom;

import questions.Paire;
import questions.Question;
import questions.QuestionChoixMultiples;

public class BanquePaires extends Banque {
	private String question,questionInverse;


	public Question prochaineQuestion() {
		int normalOuInverse = ThreadLocalRandom.current().nextInt(0, 2);
		int multipleOuPas = ThreadLocalRandom.current().nextInt(0, 2);
		int randomPaire = ThreadLocalRandom.current().nextInt(0, paires.size());
		Paire paire = paires.get(randomPaire);		

		if (multipleOuPas == 0) { 
			if(normalOuInverse == 0) {

				String questionBase = question + paire.getElementA();
				Question newQuestion = new Question(questionBase, paire.getElementB());
				return newQuestion;
			} else {
				String questionBase = questionInverse + paire.getElementB();
				Question newQuestion = new Question(questionBase, paire.getElementA());
				return newQuestion;
			}
		} else {
			if(normalOuInverse == 0) {
				String questionBase = question + paire.getElementA();
				QuestionChoixMultiples newQuestion = new QuestionChoixMultiples(questionBase, paire.getElementB());
				newQuestion.getChoixMultiple().add(paire.getElementB());
				while (newQuestion.getChoixMultiple().size() < 5) {
					int randomChoix = ThreadLocalRandom.current().nextInt(0, paires.size());
					if(newQuestion.validateChoix(paires.get(randomChoix).getElementB())) {
						newQuestion.addChoix(paires.get(randomChoix).getElementB());
					}
				}

				return newQuestion;
			} else {
				String questionBase = questionInverse + paire.getElementB();
				QuestionChoixMultiples newQuestion = new QuestionChoixMultiples(questionBase, paire.getElementA());
				newQuestion.getChoixMultiple().add(paire.getElementA());
				while (newQuestion.getChoixMultiple().size() < 5) {
					int randomChoix = ThreadLocalRandom.current().nextInt(0, paires.size());
					if(newQuestion.validateChoix(paires.get(randomChoix).getElementA())) {
						newQuestion.addChoix(paires.get(randomChoix).getElementA());
					}
				}
				return newQuestion;
			}
		}
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionInverse() {
		return questionInverse;
	}

	public void setQuestionInverse(String questionInverse) {
		this.questionInverse = questionInverse;
	}
	
}
