package com.israel.jogodavelha;

import java.util.Scanner;

/**
 * Programa Jogo da Velha
 * @version 1.0 28-07-2018
 * @author israel santucci
 *
 */
public class Principal {
	
	Jogo jogo;
	
	
	//metodo privado usado  para exibir o titulo no programa.
	private void titulo() {
		System.out.println("================================");
		System.out.println("++++++++ JOGO DA VELHA +++++++++");
		System.out.println("================================");
	}
	
	//metodo para exibir Menu principal.
	public int menu() {
		Scanner teclado = new Scanner(System.in);
		while(true) {
			this.espaco();
			this.titulo();
			System.out.println("1 - jogar");
			System.out.println("2 - Placar");
			System.out.println("0 -Sair");
			try {
				System.out.print("Resposta: ");
				return Integer.parseInt(teclado.nextLine());
			}catch(NumberFormatException erro) {}
		}
	}
	
	//metodo privado para dar espaço entre as exibiçao de metodos.
	private void espaco() {
		int i = 0;
		while(i<100) {
			System.out.println("");
			i++;
		}
	}
	
	public void iniciar() {
		int opcao;
		while(true) {
			opcao = this.menu();
			switch (opcao){
				
			case 1: jogar();
				
			}
		}
	}
	
	
	public void jogar() {
		this.titulo();
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome do primeiro jogador: ");
		String nome = teclado.nextLine();
		Jogador jogador1 = new Jogador(nome,'X');
		System.out.println("Informe o nome do segundo jogador: ");
		nome = teclado.nextLine();
		Jogador jogador2 = new Jogador(nome,'O');

		Jogo velha = new Jogo(jogador1,jogador2);
		int jogadas = 0;  //variavel que controla a quantidade de jogadas para o jogo dar velha
		while(jogadas<9) {
			
			boolean turno  = false;
			boolean vencedor;
			Jogador jogadorVez;
			int valor;
			
			while(!turno) {
				
				this.espaco();
				this.titulo();
				velha.mostrarTabela();
				try {
					if((jogadas % 2) == 0) {
						jogadorVez = jogador1;
					}else {
						jogadorVez = jogador2;
					}
					System.out.println("Jogador " + jogadorVez.getNome() + ", faça a sua jogada:");
					valor = Integer.parseInt(teclado.nextLine());
					turno = velha.jogar(jogadorVez,valor);
					vencedor = velha.conferirGanhador(jogadorVez);
					if(vencedor) {
						jogadas = 10;
						break;
					}
				}catch(Exception erro) {
					continue;
				}
			}
			jogadas++;
		}
		if(jogadas == 9) {
			System.out.println("O jogo Deu Velha!!");
		}
	}
	public static void main(String[] args) {
		Principal p = new Principal();
		p.jogar();

	}

}
