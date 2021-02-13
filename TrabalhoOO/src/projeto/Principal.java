package projeto;
import java.util.Scanner;
 
public class Principal {
	
	
	public static void main(String[] args) {
		
		
		int menuEscolha = menu();
		
		Dados[] todosAnos = new Dados[10]; //Objeto com todos os anos
		//Criando um objeto para cada ano
		todosAnos[0] = new Dados();//2020
		todosAnos[1] = new Dados();//2011
		todosAnos[2] = new Dados();//2012
		todosAnos[3] = new Dados();//...
		todosAnos[4] = new Dados();//...
		todosAnos[5] = new Dados();
		todosAnos[6] = new Dados();
		todosAnos[7] = new Dados();
		todosAnos[8] = new Dados();
		todosAnos[9] = new Dados();
		
		definirDados(todosAnos); //Colocando os dias para todos os anos
		
		todosAnos[2].dias[2] = 29;//Anos bissextos
		todosAnos[6].dias[2] = 29;
		todosAnos[0].dias[2] = 29;
		
		janeiroDados(todosAnos); //Colocando dados aleatorios em janeiro
		
		while(menuEscolha > 0 && menuEscolha < 6) {//Menu
			
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
	//Lendo o numero escolhido para menu
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
		//Mostra a temperatura media do mes desejado
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
		//Mostra a temperatura minima desejada
		int mes = 0, ano = 0;
		
		System.out.println("OPÇÃO 3!");
		
		mes = lerM();
		ano = lerA();
		
		if(todosAnos[ano].cadastrado[mes] != 2021202120) {
			System.out.println("Dados não cadastrados para a data digitada!!!");
			return;
		}
		
		System.out.println("A minima do mês " + mes + " foi de " + todosAnos[ano].min[mes]);
		System.out.println("E ocorreu nos seguintes dias:\n");
		
		for(int i = 1; i <= todosAnos[ano].dias[mes]; i++) {
			if(todosAnos[ano].min[mes] == todosAnos[ano].temperaturas[mes][i]) {
				System.out.println(i + "/" + mes);
			}
		}
		
	}//---------------------------------------------------------------------------------
	
	public static void calculo4(Dados todosAnos[]) {//***********************************
		//Mostra a temperatura maxima
		int mes = 0, ano = 0;
		
		System.out.println("OPÇÃO 4!");
		
		mes = lerM();
		ano = lerA();
		
		if(todosAnos[ano].cadastrado[mes] != 2021202120) {
			System.out.println("Dados não cadastrados para a data digitada!!!");
			return;
		}
		
		System.out.println("A maxima do mês " + mes + " foi de " + todosAnos[ano].max[mes]);
		System.out.println("E ocorreu nos seguintes dias:\n");
		for(int i = 1; i <= todosAnos[ano].dias[mes]; i++) {
			if(todosAnos[ano].max[mes] == todosAnos[ano].temperaturas[mes][i]) {
				System.out.println(i + "/" + mes);
			}
		}
		
	}//**********************************************************************************
	
	public static void calculo5(Dados todosAnos[]) {////////////////////////////////////
		//Imprime o relatorio meteorologico
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
		//Função para ler int de forma mais facil
		Scanner ler = new Scanner(System.in);
		
		int num = 0;
		
		num = ler.nextInt();;
		
		return num;
	}//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
	
	public static void entradas1(Dados todosAnos[]) {//-----------------------------------
		//Função anterior a calculaMedia, só para nao ficar muito grande
		
		int mes = -1, ano = -1;

		
		System.out.println("OPÇÃO 1!");
		
		mes = lerM();
		ano = lerA();
		System.out.println("Digite a temperatura dos dias");
		
		calculaMedia(todosAnos[ano].dias[mes], mes, ano, todosAnos);//ALTERACAO
		
		
		
	}//---------------------------------------------------------------------------------
	
	public static void calculaMedia(int totalDias, int mes, int ano, Dados todosAnos[]) {//$$$$$$$$$$$$$$$$$$
		//Aqui registra os dados da opção de menu == 1, já vai lendo os numeros,calculando e registrando os dados necessarios
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
		//Aqui vai registrar os dias para cada mes
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
		//Função para ler ano valido
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


	
		public static int lerM() {//=======================================================
			//Função para ler os meses validos
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
			
			int media = 0, aux = 0, min = 0, max = 0, mes = 1, ano = 0;
			
			
			for(int i = 1; i <= todosAnos[0].dias[1]; i++) {
					
				aux = i*2;
				
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
			
			media = todosAnos[0].dias[1];
			
					todosAnos[0].med[1] = media;
					todosAnos[0].min[1] = min;
					todosAnos[0].max[1] = max;	
					todosAnos[0].cadastrado[1] = 2021202120;
		}
					
}

