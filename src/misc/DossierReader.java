//FERNANDO BOEIRA SALOMON
//BOEF061287 - 06/06/2018
package misc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import banques.Banque;
import banques.BanqueFixe;
import banques.BanquePaires;
import questions.Paire;

public class DossierReader {
	private String fileName;
	private Scanner sc;

	public DossierReader(String fileName) {
		super();
		this.fileName = fileName;
	}
	public Banque readFile() throws FileNotFoundException {

		File file = new File(fileName);
		sc = new Scanner(file);

		if(sc.hasNextLine()) {
			if (sc.nextLine().equals("0")) {
				BanquePaires banquePaires = new BanquePaires();
				
				String readQuestion = (sc.nextLine());
				String[] separatedQuestion = readQuestion.split(",");
				
				banquePaires.setQuestion(separatedQuestion[0]);
				banquePaires.setQuestionInverse(separatedQuestion[1]);
				
				
				while(sc.hasNext()) {
					String readPergunta = (sc.nextLine());
					String[] separatedPergunta = readPergunta.split(",");
					Paire paire = new Paire(separatedPergunta);
					banquePaires.ajouterPaire(paire);	
				}
				return banquePaires;
			} else {					
					BanqueFixe banqueFixe = new BanqueFixe();
					
					while(sc.hasNext()) {
						String readPergunta = (sc.nextLine());
						String[] separatedPergunta = readPergunta.split(",");
						Paire paire = new Paire(separatedPergunta);
						banqueFixe.ajouterPaire(paire);	
					}	
					return banqueFixe;
			}
		}
		return null;
	}
}