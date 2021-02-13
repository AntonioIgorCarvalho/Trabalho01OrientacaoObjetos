package projeto;

public class Dados {
	
	
	int dias[] = new int[13]; //Aqui contem o total de dias do mes -> Ex: janeiro tem 31 dias, então dias[1] == 31
	double med[] = new double[13]; //Aqui contem a temperatura media do mes
	double min[] = new double[13]; //Temperatura minima
	double max[] = new double[13]; //Temperatura maxima
	double temperaturas[][] = new double[13][32]; //Temperatura de cada dia do mes : mes/dia
	int cadastrado[] = new int[13];  //Para checar se já foi cadastrado
	
	
}

