//FERNANDO BOEIRA SALOMON
//BOEF061287 - 06/06/2018
package quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import banques.Banque;
import misc.DossierReader;
import misc.Player;
import questions.Question;

import java.util.Scanner;

public class Quiz {
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

		List<Banque> banques = new ArrayList<Banque>();
		Scanner scan = new Scanner(System.in); //Creates a new scanner
		String input = "";
		
		
		File folder = new File("C:\\Users\\fbsal\\Desktop\\projetoPQP\\Files");
		File[] listOfFiles = folder.listFiles();
		for (int i =  0; i < listOfFiles.length; i++) {
			DossierReader dossierReader = new DossierReader(listOfFiles[i].toString());
			Banque newBanque = dossierReader.readFile();
			newBanque.setNom(listOfFiles[i].toString());
			banques.add(newBanque);
		}
		
		System.out.println("Bienvenue au Quiz !");
		System.out.println("Quel est votre nom ?");
		input = scan.nextLine();
		Player jogador = new Player(input);		
		
		System.out.println("Bonne Chance " + jogador.getName() +"!"+ "\nOn va commencer maintenant !!\n");
		System.out.println("Pour sortir, vous devez étriver << -1 >>\n");
		
		while(!input.equals("-1")) {
			int sorte = ThreadLocalRandom.current().nextInt(0, banques.size());
			Question prochaineQuestion = banques.get(sorte).prochaineQuestion();
			
			System.out.println(prochaineQuestion);
			input = scan.nextLine(); //Waits for input			
			if(prochaineQuestion.validateAwnser(input)) {
				System.out.println("Très bien!");
				jogador.scoreTypeBanque(banques.get(sorte).getNom());
				jogador.addCorrectQuestions();
			} else {
				System.out.println("Désole la bonne réponse est :" + prochaineQuestion.getReponse());
			}
			jogador.addTotalQuestions();
			if(!input.equals("-1")) {
				jogador.scoreTypeBanqueTotal(banques.get(sorte).getNom());
			}
			System.out.println();
		}
		scan.close();
		
		jogador.printScore();
		System.out.println();
		jogador.scoreTypeBanquePrint();
	}
}