package projetofinallp;

import java.util.Locale;
import java.util.Scanner;

public class projetotelefonia {

public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		// Declaração de Variaveis
		
		System.out.printf("Informe a quantidade de clientes:");
		 int N =  sc.nextInt();
		 String[] nomes = new String [N];
		 String [] tel = new String[N];
		 int [] tipo = new int[N];
		 int [] minutos = new int[N];
		 double [] conta = new double[N];
		 double[][] mat = new double[3][2];
		 int k=0, cont = 0;
		 double porcentagem, receita = 0, menor = 0, consumomum=0;
		 
		 
		 // Leitura dos dados cadastro cliente
		 
		for (int i=0; i<N; i++) {
			System.out.println("Dados do Cliente "+ (i+ 1)+"°");
			System.out.printf("Nome: ");
			sc.nextLine();
			nomes[i] = sc.nextLine();
			System.out.printf("Telefone: ");
			tel[i] = sc.nextLine();
			System.out.printf("Tipo: ");
			tipo[i] = sc.nextInt();
			System.out.printf("Minutos: ");
			minutos[i] = sc.nextInt();
			 
		 }
		
		//Leitura da matriz
		System.out.println("Informe o preco basico e excedente de cada tipo de conta: ");
		
		for (int m = 0; m < 3; m++) { 
			System.out.printf("Tipo "+ m + " ");
			for (int n= 0; n < 2; n++) {
				mat[m][n]= sc.nextDouble();
		}
		}
		
		// Calculo
		for (int i= 0; i < N; i++) {
			if (minutos[i] <= 90) {
				if (tipo[i]== 0) {
					conta[i] = mat[0][0];
				}
				else if (tipo[i]== 1) {
					conta[i] = mat[1][0];
					
				}
				else if (tipo[i]== 2) {
					conta[i] = mat[2][0];
					
				}	
			}
			else {
				if (tipo[i]== 0) {
					conta[i] = mat[0][0] + ((minutos[i] - 90)*mat[0][1]) ;
				}
				else if (tipo[i]== 1) {
					conta[i] = mat[1][0] + ((minutos[i] - 90)*mat[1][1]) ;
					
				}
				else if (tipo[i]== 2) {
					conta[i] = mat[2][0] + ((minutos[i] - 90)*mat[2][1]) ;
					
				}
				
			}
		}
		
		
		
		
		//Menu
		do {
			System.out.println("MENU DE OPCAO");
			System.out.println("1) Relatorio de clientes");
			System.out.println("2) Receita total");
			System.out.println("3) Conta foi mais barata");
			System.out.println("4) Consumo medio de clientes tipo 1");
			System.out.println("5) Clientes que consumiram acima de 120 pulsos");
			System.out.println("6) Porcentagem de clientes tipo 2");
			System.out.println("7) Sair");
			System.out.printf("Informe uma opcao: ");
			
			k = sc.nextInt();
			
			if (k == 1) {
					for (int i= 0; i < N; i++) {
						System.out.println(nomes[i] +" , " + tel[i] + " , Tipo" + tipo[i] + " , Minutos: "+ minutos[i] + " , Conta = R$ "+ conta[i]);

				}
				
			}
			else if (k==2){
				for (int i= 0; i < N; i++) {
					receita = receita + conta[i];
				}
				System.out.printf("Receita Total = R$ %.2f%n", receita);
			}
			
			else if (k==3) {
				for (int i= 0; i < (N-1); i++) {
					if (conta[i]< conta[i+1]) {
						menor = conta[i];
					}
				}
				System.out.printf("A conta mais barata foi de R$ %.2f%n", menor);
				
			}
			else if (k==4) {
				for (int i= 0; i < N; i++) {
					if (tipo[i] == 1) {
						consumomum = consumomum + conta[i];
						
					}
				}
				System.out.printf("O consumo medio dos clientes tipo 1 eh de R$ %.2f%n", consumomum);
			}
			else if (k==5){
				for (int i= 0; i < N; i++) {
					if (minutos[i] > 120) {
						System.out.println("Os clientes que usaram mais de 120 minutos foram:");
						System.out.println(nomes[i]);
						
					}
				}	
			}
			
			else if (k==6){
				for (int i= 0; i < N; i++) {
					if (tipo[i] == 2) {
						cont = cont + 1;
						
					}
				}
				porcentagem = cont*100/N;
				System.out.printf("A porcentagem de clientes do tipo 2 eh %.2f %%%n", porcentagem);
			}
			
		
			
		}while(k!=7);
		
		System.out.println("FIM DO PROGRAMA");
		
		
		
		
		sc.close();
	}
}

