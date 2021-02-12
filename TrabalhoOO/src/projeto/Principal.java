package projeto;
import java.util.Scanner;
 
public class Principal {
	
	
	public static void main(String[] args) {
		
		
		int menuEscolha = menu();
		
		Dados[] todosAnos = new Dados[10]; //Objeto com todos os anos
		todosAnos[0] = new Dados();
		todosAnos[1] = new Dados();
		todosAnos[2] = new Dados();
		todosAnos[3] = new Dados();
		todosAnos[4] = new Dados();
		todosAnos[5] = new Dados();
		todosAnos[6] = new Dados();
		todosAnos[7] = new Dados();
		todosAnos[8] = new Dados();
		todosAnos[9] = new Dados();
		
		definirDados(todosAnos);
		todosAnos[2].dias[2] = 29;
		todosAnos[6].dias[2] = 29;
		todosAnos[0].dias[2] = 29;
		
		janeiroDados(todosAnos);
		
		while(menuEscolha > 0 && menuEscolha < 6) {
			
			switch(menuEscolha) {
			case 1 :
				entradas1(todosAnos);
				break;
			case 2 :
				calculo2(todosAnos);
				break;
			case 3 :
				calculo3(todosAnos);
				break;
			case 4 :
				calculo4(todosAnos);
				break;
			case 5 :
				calculo5(todosAnos);
				break;
			}
			
			
			menuEscolha = menu();
		} 
		
		
		System.out.println("Entrada de Menu Inválida, Encerrando Programa");	
	}
	
	
	
	
	
	public static int menu() {//#######################################################
		
	int menu;
		
		System.out.println("--------------------------------------------");
		System.out.println("DIGITE O NUMERO DE ACESSO DO MENU");
		
		System.out.println("1. Entrada das temperaturas:");
		System.out.println("2. Cálculo da temperatura média:");
		System.out.println("3. Cálculo da temperatura mínima:");
		System.out.println("4. Cálculo da temperatura máxima:");
		System.out.println("5. Relatório meteorológico:");
		System.out.println("--------------------------------------------");
		menu = lerInt();
		return menu;
	}//################################################################################
	
	
	public static void calculo2(Dados todosAnos[]) {//##################################
		int mes = 0, ano = 0;
		
		System.out.println("OPÇÃO 2!");
		
		mes = lerM();
		ano = lerA();
		
		if(todosAnos[ano].cadastrado[mes] != 2021202120) {
			System.out.println("Dados não cadastrados para a data digitada!!!");
			return;
		}
		
		System.out.println("A Media do mês " + mes + " foi de " + todosAnos[ano].med[mes]);
		
	}//#################################################################################
	
	public static void calculo3(Dados todosAnos[]) {//----------------------------------
		int mes = 0, ano = 0;
		
		System.out.println("OPÇÃO 3!");
		
		mes = lerM();
		ano = lerA();
		
		if(todosAnos[ano].cadastrado[mes] != 2021202120) {
			System.out.println("Dados não cadastrados para a data digitada!!!");
			return;
		}
		
		System.out.println("A minima do mês " + mes + " foi de " + todosAnos[ano].min[mes]);
		
	}//---------------------------------------------------------------------------------
	
	public static void calculo4(Dados todosAnos[]) {//***********************************
		int mes = 0, ano = 0;
		
		System.out.println("OPÇÃO 4!");
		
		mes = lerM();
		ano = lerA();
		
		if(todosAnos[ano].cadastrado[mes] != 2021202120) {
			System.out.println("Dados não cadastrados para a data digitada!!!");
			return;
		}
		
		System.out.println("A maxima do mês " + mes + " foi de " + todosAnos[ano].max[mes]);
		
	}//**********************************************************************************
	
	public static void calculo5(Dados todosAnos[]) {////////////////////////////////////
		int mes = 0, ano = 0;
		
		System.out.println("OPÇÃO 5!");
		
		mes = lerM();
		ano = lerA();
		
		if(todosAnos[ano].cadastrado[mes] != 2021202120) {
			System.out.println("Dados não cadastrados para a data digitada!!!");
			return;
		}
		
		System.out.println("Imprimindo relatório meteorológico:");
		
		for(int i = 1; i <= todosAnos[ano].dias[mes]; i++) {
			System.out.println("Dia " + i + ": " + todosAnos[ano].temperaturas[mes][i] + " graus!");
		}
		
		System.out.println("A Media foi de " + todosAnos[ano].med[mes]);
		System.out.println("A minima foi de " + todosAnos[ano].min[mes]);
		System.out.println("A maxima foi de " + todosAnos[ano].max[mes]);
		
		
	}///////////////////////////////////////////////////////////////////////////////////
	
	public static int lerInt() {//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		Scanner ler = new Scanner(System.in);
		
		int num = 0;
		
		num = ler.nextInt();;
		
		return num;
	}//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	public static void calculaMedia(int totalDias, int mes, int ano, Dados todosAnos[]) {//$$$$$$$$$$$$$$$$$$
		int media = 0, aux = 0, min = 0, max = 0;
		
		System.out.println("Você terá de digitar " + totalDias + " dias!");
		
		for(int i = 1; i <= totalDias; i++) {
			System.out.println("Digite o dia " + i);
			
			
			aux = lerInt();
			
			if(i == 1) {
				max = aux;
				min = aux;
			}
			
			todosAnos[ano].temperaturas[mes][i] = aux;
			
			media += aux;
			
			if(aux > max) {
				max = aux;
			}
			
			if( aux < min) {
				min = aux;
			}
			
		}
		
		media = media/totalDias;
		
		
		System.out.println("Registrado com sucesso");//A partir daqui faz o registro dos dados
		
				todosAnos[ano].med[mes] = media;
				todosAnos[ano].min[mes] = min;
				todosAnos[ano].max[mes] = max;	
				todosAnos[ano].cadastrado[mes] = 2021202120;
		
		
	}//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	
	
	public static void definirDados(Dados todosanos[]) {//*************************************
		
		for(int i = 0; i < 10; i++) {
		todosanos[i].dias[1] = 31;
		todosanos[i].dias[2] = 28;
		todosanos[i].dias[3] = 31;
		todosanos[i].dias[4] = 30;
		todosanos[i].dias[5] = 31;
		todosanos[i].dias[6] = 30;
		todosanos[i].dias[7] = 31;
		todosanos[i].dias[8] = 31;
		todosanos[i].dias[9] = 30;
		todosanos[i].dias[10] = 31;
		todosanos[i].dias[11] = 30;
		todosanos[i].dias[12] = 31;
		}
	}//****************************************************************************************

	public static int lerA() {//**********************************************************
		int ano = 0;
			
		while(ano <= 2010 || ano >= 2021) {
			System.out.println("Digite o ano");	
			ano = lerInt();
				if(ano <= 2010 || ano >= 2021) {
					System.out.println("Ano Inválido");
				}
			}
		
		ano = ano - 2010; //Esse calculo para trabalhar com os vetores de objetos
		if(ano == 10) {
			ano = 00;
		}//******************************************************************************
		
		return ano;
		}

		public static void entradas1(Dados todosAnos[]) {//-----------------------------------
			int mes = -1, ano = -1;

			
			System.out.println("OPÇÃO 1!");
			
			mes = lerM();
			ano = lerA();
			System.out.println("Digite a temperatura dos dias");
			
			calculaMedia(todosAnos[ano].dias[mes], mes, ano, todosAnos);//ALTERACAO
			
			
			
		}//---------------------------------------------------------------------------------
	
		public static int lerM() {//=======================================================
			int mes = 0;
			
			
			while(mes <= 0 || mes >= 13) {
				System.out.println("Digite o mês");		
				mes = lerInt();
					if(mes <= 0 || mes >= 13) {
						System.out.println("Mês Inválido");
					}
				}
			return mes;
		}//===============================================================================
		
		public static void janeiroDados(Dados todosAnos[]) {//Registra dados aleatorios em janeiro
			for(int i = 0; i < todosAnos[00].dias[12]; i++) {
				todosAnos[00].temperaturas[2][i] = (i*2);
			}
		}
		
}

