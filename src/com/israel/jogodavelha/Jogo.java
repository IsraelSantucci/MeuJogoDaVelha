package com.israel.jogodavelha;
/**
 * 
 * @author Israel Santucci
 *
 */
public class Jogo {
	
	private Jogador jogador1;
	private Jogador jogador2;
	private char[][] tabela;
	
	public Jogo(Jogador jogador1, Jogador jogador2) {
		this.jogador1 = jogador1;
		this.jogador2 = jogador2;
		tabela = new char[3][3];
		montarTabela();
	}
	
	public void montarTabela() {
		int c = 1;
		for(int i = 0; i<tabela.length; i++) {
			for(int j = 0; j<tabela[i].length; j++) {
				this.tabela[i][j] =  Character.forDigit(c,10);
				c++;
			
			}
		}
	}
	
	public void mostrarTabela() {
		for(char[] i : tabela) {
			for(char j: i) {
				System.out.print(" | " + j);
			}
			System.out.println(" | " );
		}
	}
	
	//Consultar se o numero da jogada esta na tabela 
	private boolean consultar(int num, char simbolo) {
		int valor;
		for(int i = 0; i<tabela.length; i++) {
			for(int j = 0; j<tabela[i].length; j++) {
				valor = Character.getNumericValue(tabela[i][j]);
				if(valor == num) {
					tabela[i][j] = simbolo;
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean jogar(Jogador jogador, int campo) {
		if(campo >9 ||campo <1) {
			return false;
		}
		return consultar(campo, jogador.getSimbolo());
	}
	
	public boolean conferirGanhador(Jogador jogador) {
		if(this.verificar(jogador.getSimbolo())) {
			System.out.println("Parabéns "+ jogador.getNome());
			System.out.println("Você Ganhou");
			return true;
		}
		return false;
	}
	public boolean verificar(char simbolo) {
		//primeira linha
		if(tabela[0][0] == simbolo) {
			if(tabela[0][1] == simbolo) {
				if(tabela[0][2] == simbolo) {
					  return true;
				}	
			}
		}
		//segunda linha
		if(tabela[1][0] == simbolo) {
			if(tabela[1][1] == simbolo) {
				if(tabela[1][2] == simbolo) {
					 return true;
				}	
			}
		}
		//terceira linha
		if(tabela[2][0] == simbolo) {
			if(tabela[2][1] == simbolo) {
				if(tabela[2][2] == simbolo) {
					 return true;
				}	
			}
		}
		//primeira coluna
		if(tabela[0][0] == simbolo) {
			if(tabela[1][0] == simbolo) {
				if(tabela[2][0] == simbolo) {
					 return true;
				}	
			}
		}
		//segunda coluna
		if(tabela[0][1] == simbolo) {
			if(tabela[1][1] == simbolo) {
				if(tabela[2][1] == simbolo) {
					 return true;
				}	
			}
		}
		//terceira coluna
		if(tabela[0][2] == simbolo) {
			if(tabela[1][2] == simbolo) {
				if(tabela[2][2] == simbolo) {
					 return true;
				}	
			}
		}
		//diagonal principal
		if(tabela[0][0] == simbolo) {
			if(tabela[1][1] == simbolo) {
				if(tabela[2][2] == simbolo) {
					 return true;
				}	
			}
		}
		//diadonal secundaria
		if(tabela[2][0] == simbolo) {
			if(tabela[1][1] == simbolo) {
				if(tabela[0][2] == simbolo) {
					 return true;
				}	
			}
		}
		return false;
	}
	
	public void menu() {
		while(true) {
			
			
		}
	}
	public static void main(String[] args) {
		Jogador j1 =  new Jogador("israel", 'X');
		Jogador j2 =  new Jogador("josiel", 'O');
		Jogo velha = new Jogo(j1,j2);
		velha.mostrarTabela();
		velha.jogar(j1,3);
		velha.mostrarTabela();
		velha.jogar(j2,1);
		velha.mostrarTabela();
		
		
		
	}
}
