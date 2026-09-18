package galgje;

import java.util.ArrayList;
import java.util.Scanner;

public class Galgje {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] letterVanWoord = { "t", "o", "p" };
		String[] gerradenLetters = new String[letterVanWoord.length];
		ArrayList<String> geprobeerdenLetters = new ArrayList<>();
		String poging;
		int foutenPoging = 0;
		boolean[] controle = new boolean[letterVanWoord.length];
		System.out.println("vul in een letter");

		for (int idx = 0; idx < letterVanWoord.length; idx = idx + 1) {
			gerradenLetters[idx] = "*";
			controle[idx] = false;
		}
		
		do {
			
			
			do {
				poging = sc.next();
				if(geprobeerdenLetters.contains(poging)) 
				{
					foutenPoging=foutenPoging +1;
				}
			} while(geprobeerdenLetters.contains(poging));
			geprobeerdenLetters.add(poging);
//		for (int idx = 0; idx < geprobeerdenLetters.length; idx = idx + 1) {
//			if(geprobeerdenLetters[idx].equals(poging)) {
//				foutenPoging = foutenPoging+1;
//			}else {
//				geprobeerdenLetters[idx] =poging;
//			}
//		}
		
		
			for (int idx = 0; idx < letterVanWoord.length; idx = idx + 1) {
				if (letterVanWoord[idx].equals(poging)) {
					gerradenLetters[idx] = poging;
					controle[idx] = true;
					
				} else {foutenPoging = foutenPoging +1;}

				}
			} while (foutenPoging < 10);
		sc.close();

	}

}
