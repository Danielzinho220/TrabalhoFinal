
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Geral {

	
	public static <Atualizar> void main(String[] args) throws IOException {
		int opcao = 0;
		Scanner nr = new Scanner(System.in);
		Produto p = new  Produto ();
		do {
			System.out.println("+-----------------------------------------+");
			System.out.println("+--------- Escolha uma opção abaixo-------+");
			System.out.println("+                                         +");
			System.out.println("+  1- Cadastrar produto                   +");
			System.out.println("+  2- Buscar um produto                   +");
			System.out.println("+  3- Listar todos produtos               +");
			System.out.println("+  4- Atualizar produto                   +");
			System.out.println("+  5- sair                                +");
			System.out.println("+                                         +");
			System.out.println("+-----------------------------------------+");

			System.out.println("Escolha uma das opções acima:");
			opcao = nr.nextInt();
			System.out.println();

			switch (opcao) {
			case 1:

				FileOutputStream arquivo = null;
				// Criar o arquivo "Produtos.txt" na pasta do projeto
				arquivo = new FileOutputStream("Produtos.txt", true);

				// Criação de 3 objetos da classe
				Scanner sc = new Scanner(System.in);

				System.out.println("Digite o nome do Produto:");
				String nome = sc.next();

				System.out.println("Digite o preço:");
				double preco = sc.nextDouble();

				System.out.println("Digite a quantidade:");
				int quantidade = sc.nextInt();

				System.out.println("Digite o código:");
				int codigo = sc.nextInt();

				arquivo.write((nome + ";").getBytes());
				arquivo.write((preco + ";").getBytes());
				arquivo.write((quantidade + ";").getBytes());
				arquivo.write((codigo + ";").getBytes());
				arquivo.write(("\n").getBytes());
				System.out.println("Objetos gravados com sucesso no arquivo.");

				Produto tc = new Produto(nome, preco, quantidade, codigo);

				sc.close();

				break;

			case 2:

				FileInputStream leitura = null;
				BufferedReader convert = null;
				leitura = new FileInputStream("Produtos.txt");

				// Utilização da classe InputStreamReader para recuperar todo o
				// conteúdo escrito dentro do arquivo "agenda.txt"
				// import java.io.InputStreamReader;
				InputStreamReader todo = new InputStreamReader(leitura);

				convert = new BufferedReader(todo);

				Scanner ler = new Scanner(System.in);
				System.out.println("Qual nome deseja buscar?");
				nome = ler.next();

				// Variável para ver em qual linha está o nome
				int numeroLinha = 0;

				// Leitura de cada linha do arquivo
				while (convert.ready()) {
					// Recuperar o valor da linha
					String linha = convert.readLine();

					// Verificando se a linha possui o nome informado
					if (linha.contains(nome)) {
						// Separa cada posição da linha em um vetor
						String valores[] = linha.split(";");

						// Imprimindo os valores
						System.out.println("Nome: " + valores[0]);
						System.out.println("Preço: " + valores[1]);
						System.out.println("Quantidade: " + valores[2]);
						System.out.println("Código:" + valores[3]);
					} else {
						numeroLinha++;
					}
				}
				break;

			case 3:

				FileInputStream arquivo1 = null;
				// A classe BufferedReader é utilizada para recuperar o texto do arquivo e
				// converter
				// import java.io.BufferedReader;
				BufferedReader textoConvertido = null;

				// Comando para abrir o arquivo específico
				arquivo1 = new FileInputStream("Produtos.txt");

				// Para ler o conteúdo de dentro do arquivo, precisamos usar o InputStreamReader
				// import java.io.InputStreamReader;
				InputStreamReader texto = new InputStreamReader(arquivo1);

				// Recuperar o texto e converter
				textoConvertido = new BufferedReader(texto);

				// Utilização do comando "while" para percorrer o "textoConvertido" e verificar
				// cada linha presente nele. Enquanto houverem linhas, será impresso o seu valor
				// O método "ready" verifica se há uma linha nova ou não
				while (textoConvertido.ready()) {
					// Se há uma linha nova, então é impresso o valor da linha com o "readLine"
					System.out.println(textoConvertido.readLine());
				}

				arquivo1.close();
				textoConvertido.close();
				break;

			case 4:
				
				FileOutputStream arquivo2 = null;
				FileInputStream leitura1 = null;
				BufferedReader convert1 = null;
				arquivo2 = new FileOutputStream("Produtos.txt",true);

				// Utilização da classe InputStreamReader para recuperar todo o
				// conteúdo escrito dentro do arquivo "agenda.txt"
				// import java.io.InputStreamReader;
				leitura1 = new FileInputStream("Produtos.txt");
				InputStreamReader todo1 = new InputStreamReader(leitura1);

				convert1 = new BufferedReader(todo1);

				Scanner ner = new Scanner(System.in);
				System.out.println("Digite o Código:");
				codigo = ner.nextInt();

				// Variável para ver em qual linha está o nome
				int numeroLinha1 = 0;

				List<String> listaNovo1 = new ArrayList<String>();

				// Leitura de cada linha do arquivo
				while (convert1.ready()) {
					// Recuperar o valor da linha
					String linha = convert1.readLine();

					// Verificando se a linha possui o nome informado
					if (linha.contains("" + codigo)) {
						// Separa cada posição da linha em um vetor

						Scanner nerv = new Scanner(System.in);

						System.out.println("Digite o nome do Produto:");
						String nomeAtualizado = nerv.next();

						System.out.println("Digite o preço:");
						double precoAtualizado = nerv.nextDouble();

						System.out.println("Digite a quantidade:");
						int quantidadeAtualizado = nerv.nextInt();
						
						String linhaAtualizado = codigo + ";" + nomeAtualizado + ";" + precoAtualizado + ";"
								+ quantidadeAtualizado;
						

						linha = linhaAtualizado;
					}
					
					    listaNovo1.add(linha);
					
					
					arquivo2 = new FileOutputStream("Produtos.txt");

					for (String cadaLinha : listaNovo1) {
						byte[] linhaConvertida = cadaLinha.getBytes();
						arquivo2.write(linhaConvertida);
						arquivo2.write("\n".getBytes());
					}

					System.out.println("Produtos Atualizados.");
					}
				

				break;

			case 5:
				System.out.println("Você decidiu sair.");
				break;

			default:
				System.out.println("Voce escolheu sair. ");

				break;

			}

		} while (opcao != 5);

	}

}
