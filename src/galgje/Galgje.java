package galgje;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Galgje {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random num = new Random();
		String[] woorden = { "top", "kaas", "rood", "hoofd", "hoed", "glass" };
		String woord = woorden[num.nextInt(woorden.length)];

		String[] letterVanWoord = new String[woord.length()];
		String[] gerradenLetters = new String[letterVanWoord.length];
		ArrayList<String> geprobeerdenLetters = new ArrayList<>();
		String feedback = "";
		String poging;
		int foutenPoging = 0;
		int controle = 0;
		String[] tekening= new String[8];
    	tekening[0] =" ";
    	tekening[1] =" ";
    	tekening[2] =" ";
    	tekening[3] =" ";
    	tekening[4] =" ";
    	tekening[5] =" ";
    	tekening[6] ="  ";
    	tekening[7] ="----------------";
		
//		woord radom generation
//		for testing
		System.out.println(woord);
		for (int idx = 0; idx < woord.length(); idx = idx + 1) {
			letterVanWoord[idx] = Character.toString(woord.charAt(idx));
		}

		for (int idx = 0; idx < letterVanWoord.length; idx = idx + 1) {
			gerradenLetters[idx] = "*";

		}

		do {
//usser in put
			do {
				switch (foutenPoging) {
	    		case 10:
	    			tekening[5] ="   |	/\\";
	    			break;
	    		case 9:
	    			tekening[5] ="   |	/";
	    			break;
	    		case 8:
	    			tekening[4] ="   |    []";
	    			break;
	    		case 7:
	    			tekening[3] ="   |   \\()/";
	    			break;
	    		case 6:
	    			tekening[3] ="   |   \\()";
	    			break;
	    		case 5:
	    			tekening[3] ="   |     ()";
	    			break;
	    		case 4:
	    	    	tekening[1] ="   | /  |";
	    	    	tekening[2] ="   |/   |";
	    			break;
	    		case 3:
	    			tekening[0] ="   ________";
	    			break;
	    		case 2:
	    	    	tekening[1] ="   | /";
	    	    	tekening[2] ="   |/	";
	    			break;
	    		case 1:
	    			tekening[1] ="   |";
	    	    	tekening[2] ="   |";
	    	    	tekening[3] ="   |";
	    	    	tekening[4] ="   |";
	    	    	tekening[5] ="   |";
	    	    	tekening[6] ="   |";
	    			break;
	    			default:;}
	    			for(int idx= 0;idx < tekening.length; idx++) {
	    	    		System.out.println(tekening[idx]);
	    			}
				
				
				System.out.println("je hebt " + foutenPoging + " fouten");
				System.out.println("vul in een letter");
				poging = sc.next();

				if (geprobeerdenLetters.contains(poging)) {
					foutenPoging = foutenPoging + 1;
				}

			} while (geprobeerdenLetters.contains(poging) && foutenPoging < 10);
			geprobeerdenLetters.add(poging);

//			controllen of letter goed is
			boolean zitLetterInWoord = false;
			for (int idx = 0; idx < letterVanWoord.length; idx = idx + 1) {
				if (letterVanWoord[idx].equals(poging)) {
					zitLetterInWoord = true;
				}
			}
			if (zitLetterInWoord) {
				for (int idx = 0; idx < letterVanWoord.length; idx = idx + 1) {
					if (letterVanWoord[idx].equals(poging)) {
						gerradenLetters[idx] = poging;
					}
				}
			} else {
				foutenPoging = foutenPoging + 1;
			}
//			winst controllen
			for (int idx = 0; idx < letterVanWoord.length; idx = idx + 1) {
				if (gerradenLetters[idx].equals(letterVanWoord[idx])) {
					controle = controle + 1;
				}
			}

			if (controle == letterVanWoord.length) {
				System.out.println("je hebt gewonnen");
				foutenPoging = 12;
			} else {
				controle = 0;
			}
//			feedback
			feedback = "";
			for (int idx = 0; idx < letterVanWoord.length; idx = idx + 1) {
				feedback = feedback + gerradenLetters[idx];
			}
			System.out.println(feedback);
			

		} while (foutenPoging < 10);
		sc.close();

	}

}
