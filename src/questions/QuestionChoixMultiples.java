//FERNANDO BOEIRA SALOMON
//BOEF061287 - 06/06/2018
package questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuestionChoixMultiples extends Question {
	
	private List<String> ChoixMultiple = new ArrayList<String>();

	public QuestionChoixMultiples(String question, String reponse) {
		super(question, reponse);
		// TODO Auto-generated constructor stub
	}
	
	public void addChoix (String choix) {
		getChoixMultiple().add(choix);
	}
	
	public boolean validateChoix(String choix) {
		if (getChoixMultiple().contains(choix)) {
			return false;
		}
		return true;
	}
				
	public String toString() {
		Collections.sort(getChoixMultiple());
		for (int i = 0; i< 5; i++) {
			setQuestion(getQuestion() + "\n" + i + ")" + getChoixMultiple().get(i));
		}
		return getQuestion();
	}
	
	public boolean validateAwnser(String awnser) {
		if (this.getReponse().equals(awnser)) {
			return true;
		} else if (awnser.equals("0") && getChoixMultiple().get(0).equals(getReponse())) {
			return true;
		} else if (awnser.equals("1") && getChoixMultiple().get(1).equals(getReponse())) {
			return true;
		} else if (awnser.equals("2") && getChoixMultiple().get(2).equals(getReponse())) {
			return true;
		} else if (awnser.equals("3") && getChoixMultiple().get(3).equals(getReponse())) {
			return true;
		} else if (awnser.equals("4") && getChoixMultiple().get(4).equals(getReponse())) {
			return true;
		}
		else {
			return false;
		}
	}

	public List<String> getChoixMultiple() {
		return ChoixMultiple;
	}

	public void setChoixMultiple(List<String> choixMultiple) {
		ChoixMultiple = choixMultiple;
	}	
}
