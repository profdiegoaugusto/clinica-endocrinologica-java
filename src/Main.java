import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
	
	static final char MASCULINO = 'M';
	static final char FEMININO = 'F';

	public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		String nomeDoPaciente = "";
		char sexo = '\u0000';
		String dataDeNascimento = "";
		float altura = 0.0f;
		float massa = 0.0f;
		byte idade = 0;
		double imc = 0.0;
		String situacaoIMC = "";
		double pesoIdeal = 0.0;
		
		// ENTRADA
		System.out.println("CADASTRO DE PACIENTE");
		System.out.println();
		
		System.out.print("Nome:  ");
		nomeDoPaciente = console.nextLine();
		
		
		do {
			
			System.out.print("Sexo:  ");
			sexo = console.nextLine().toUpperCase().charAt(0);
			
		} while (sexo != MASCULINO && sexo != FEMININO);
		
		
		System.out.print("Nascimento (dd/mm/aaaa):  ");
		dataDeNascimento = console.nextLine();
		
		System.out.print("Altura (m):  ");
		altura = console.nextFloat();
		
		System.out.print("Peso (Kg):  ");
		massa = console.nextFloat();
		
		// PROCESSAMENTO
		LocalDate nascimento = LocalDate.parse(dataDeNascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		int anoAtual = LocalDate.now().getYear();
		int anoNascimento = nascimento.getYear();
		idade = (byte) (anoAtual - anoNascimento);
		
		
		idade = (byte) ChronoUnit.YEARS.between(nascimento, LocalDate.now());
		
		
		imc = massa / (altura * altura);
		
		
		if (imc < 17.00) {
			situacaoIMC = "Muito abaixo do peso";
		} else if (imc >= 17.00 && imc <= 18.49) {
			situacaoIMC = "Abaixo do peso";
		} else if (imc >= 18.5 && imc <= 24.99) {
			situacaoIMC = "Peso normal";
		} else if (imc >= 25.00 && imc <= 29.9) {
			situacaoIMC = "Acima do peso";
		} else if (imc >= 30.00 && imc <= 34.99) {
			situacaoIMC = "Obesidade I";
		} else if (imc >= 35.00 && imc <= 39.99) {
			situacaoIMC = "Obesidade II (severa)";
		} else if (imc >= 40.00) {
			situacaoIMC = "Obesidade III (mórbida)";
		}
		
		
		if(sexo == MASCULINO) {
			
			pesoIdeal = (72.7 * altura) - 58;
			
		} else {
			
			pesoIdeal = (62.7 * altura) - 44.7;
			
		}
		
		// SAÍDA
		System.out.println();
		System.out.println("RELATÓRIO MÉDICO");
		System.out.format("\nNome: %s", nomeDoPaciente);
		System.out.format("\nSexo: %s", sexo);
		System.out.format("\nNascimento: %s", dataDeNascimento);
		System.out.format("\nIdade: %d anos", idade);
		System.out.format("\nAltura: %.2f m", altura);
		System.out.format("\nPeso: %.2f Kgs", massa);
		System.out.format("\nIMC: %.2f - %s", imc, situacaoIMC);
		System.out.format("\nPeso Ideal: %.2f Kgs", pesoIdeal);


	} // Fim do método main

} // Fim da classe Main
