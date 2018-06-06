//FERNANDO BOEIRA SALOMON
//BOEF061287 - 06/06/2018
package misc;

import java.util.HashMap;
import java.util.Map;

public class Player {
	private String name;
	private int quantiteQuestions = 0,quantiteQuestionCorrect = 0;
	private Map<String, Integer> quantiteQuestionsPerType = new HashMap<String, Integer>();
	private Map<String, Integer> quantiteQuestionsPerTypeTotal = new HashMap<String, Integer>();

	
	public Player(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantiteQuestions() {
		return quantiteQuestions;
	}
	public void setQuantiteQuestions(int quantiteQuestions) {
		this.quantiteQuestions = quantiteQuestions;
	}
	public int getQuantiteQuestionCorrect() {
		return quantiteQuestionCorrect;
	}
	public void setQuantiteQuestionCorrect(int quantiteQuestionCorrect) {
		this.quantiteQuestionCorrect = quantiteQuestionCorrect;
	}
	
	public void addTotalQuestions() {
		quantiteQuestions++;
	}
	
	public void addCorrectQuestions() {
		quantiteQuestionCorrect++;
	}
	
	public void printScore() {
		quantiteQuestions--;
		System.out.println("Your Score was: " + quantiteQuestionCorrect + "/" + quantiteQuestions);
	}
	
	public void scoreTypeBanque(String newString) {
		if (quantiteQuestionsPerType.containsKey(newString)) {
			Integer value = quantiteQuestionsPerType.get(newString) + 1;
			quantiteQuestionsPerType.replace(newString, value);	
		} else {
			quantiteQuestionsPerType.put(newString, 1);
		}
	}
	
	public void scoreTypeBanqueTotal(String newString) {
		if (quantiteQuestionsPerTypeTotal.containsKey(newString)) {
			Integer value = quantiteQuestionsPerTypeTotal.get(newString) + 1;
			quantiteQuestionsPerTypeTotal.replace(newString, value);	
		} else {
			quantiteQuestionsPerTypeTotal.put(newString, 1);
		}
	}
	
	public void scoreTypeBanquePrint() {
		System.out.println("Score per Fichier");
		for(String key: quantiteQuestionsPerTypeTotal.keySet()) {
			int valueCorrect = 0;
			if (quantiteQuestionsPerType.containsKey(key)) {
				valueCorrect = quantiteQuestionsPerType.get(key);
			}				
			Integer valueTotal = quantiteQuestionsPerTypeTotal.get(key);
			System.out.println("From the file : "+ key + " = " + valueCorrect + "/" + valueTotal);
		}
	}	
}
