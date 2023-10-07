package application;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import entities.Pessoa;

public class Program {

	public static void main(String[] args) {
		Set<Pessoa> pessoas = new Pessoa().populaPessoas();
		System.out.println("==========================================");
		pessoas.forEach(System.out::println);
		System.out.println("==========================================");
		
		Stream<Pessoa> Brasileiros = pessoas.stream()
				.filter(p -> p.getNacionalidade().equals("Brasil"));
			//	.collect(Collectors.toList());
		Brasileiros.forEach(System.out::println);
		System.out.println("-------------------------------------------");
		IntStream idades = pessoas.stream()
				.filter(p -> p.getIdade() < 22)
				.mapToInt(Pessoa::getIdade);
		idades.forEach(System.out::println);
		
		System.out.println("-------------------------------------------");
		Stream<Pessoa> nameOrderBrasileiros = pessoas.stream()
				.filter(p -> p.getNacionalidade().equals("Brasil"))
				.sorted(Comparator.comparing(Pessoa::getNome).reversed());
		nameOrderBrasileiros.forEach(System.out::println);
		
		System.out.println("-------------------------------------------");
		 Stream<Pessoa> pessasUnicas = pessoas.stream()
				 .distinct();//Elimina elementos repetidos
		 pessasUnicas.forEach(System.out::println);
		 System.out.println("-------------------------------------------");
		
		 Stream<Pessoa> limitePessoas2 = pessoas.stream()
				 .limit(2);//Limita a quantidade de dados
		 limitePessoas2.forEach(System.out::println);
		 System.out.println("-------------------------------------------");
		 
		 //Operações terminais Esse tipo de operação pode ser identificado pelo tipo de retorno do método, 
		 //uma vez que uma operação terminal nunca retorna uma interface Stream, mas sim um resultado (List, String, Long, Integer, etc.) ou void. 
		 //A seguir, veremos em detalhes alguns dos métodos mais importantes e em quais situações eles podem ser empregados.
		 pessoas.stream().forEach(p -> System.out.println(p.getNacionalidade()));
		 System.out.println("-------------------------------------------");
		 
		 //Media da idade dos nascidos no braasil
		 double medIdade = pessoas.stream()
				 .filter(p -> p.getNacionalidade().equals("Brasil"))
				 .mapToInt(p -> p.getIdade())
				 .average()
				 .getAsDouble();
		 System.out.printf("Média dos nascido no Brasil: %.2f%n",medIdade);
		 
		 //Transformar o Set em List
		 System.out.println("Lista de pessoas:");
		 List<Pessoa> pessoasList = pessoas.stream()
				 .filter(p -> p.getNome().charAt(0) == 'M').collect(Collectors.toList());
		 pessoasList.forEach(System.out::println);
		

	}

}
