package br.com.venutetech.app;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Generator {

	public static void main(String[] args) {
		int teto = 1000;
		int numero = 0;
		int base = 0;

		Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		int numero_aleatorio = rand.nextInt(teto);
		System.out.println("O sistema gerou um número aleatório, tente descobrir qual é? ");
		System.out.println(" ");
		System.out.println("Informe o número: ");
		numero = sc.nextInt();

		while (numero > 0) {
			boolean numeroEhMenorQueTotalBase = numero < base;
			boolean numeroEhMaiorQueTotalBase = numero > base;
			boolean numeroEhMenorNumeroAleatorio= numeroEhMaiorQueTotalBase && numero < numero_aleatorio;
			boolean numeroMaioreQueNumeroAleatorio = numeroEhMaiorQueTotalBase && numero > numero_aleatorio;
			
			if (numero != numero_aleatorio) {
				if(numeroEhMenorQueTotalBase) {
					base = numero;
					System.out.println("O número esperado está entre " + numero + " e " + teto);
				} else if(numeroMaioreQueNumeroAleatorio ) {
					teto = numero;
					System.out.println("O número esperado está entre " + base + " e " + teto);
				} else if(numeroEhMenorNumeroAleatorio) {
					base = numero;
					System.out.println("O número esperado está entre " + numero + " e " + teto);
				}

				System.out.println("Informe outro número: ");
				numero = sc.nextInt();
			} else {
				System.out.println("Você acertou!");
				sc.close();
				break;
			}
		}

		if (numero <= 0) {
			System.out.println("número inválido!");
			sc.close();
		}
	}

}
