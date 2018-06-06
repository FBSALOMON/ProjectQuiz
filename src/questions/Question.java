//FERNANDO BOEIRA SALOMON
//BOEF061287 - 06/06/2018
package questions;

public class Question {
	private String question;
	private String reponse;	
	
	public Question(String question, String reponse) {
		super();
		this.question = question;
		this.reponse = reponse;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getReponse() {
		return reponse;
	}
	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	public boolean validateAwnser(String awnser) {
		if (this.reponse.equals(awnser)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		return question + "?";
	}	
}
