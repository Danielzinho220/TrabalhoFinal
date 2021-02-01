import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Produt {

	public static void main(String[] args) {
		// Classe FileOutputStream para criar o arquivo
		FileOutputStream arquivo = null;
		// Classe FileInputStream para ler o conteúdo do arquivo
		FileInputStream leitura = null;
		// Classe BufferedReader para recuperar o conteúdo em texto
		BufferedReader conversao = null;

		try {
			// Criar o arquivo "agenda.txt" na pasta do projeto
			arquivo = new FileOutputStream("agenda.txt");

			// Criação de 3 objetos da classe
			Scanner sc = new Scanner(System.in);
			   
			Produto a1 = new Produto();
			a1 = sc.nextLine();
			Produto a2 = new Produto();
			a2 = sc.nextLine();
			Produto a3 = new Produto();
			a3 = sc.nextLine();
			// Juntar todos os valores do objeto "a1" em uma String (texto) só
			String valoresA1 = a1.getNome() + ";" + "\n";

			// Escrever os valores do objeto "a1" no "arquivo"
			arquivo.write(valoresA1.getBytes());
			

			// Juntar os valores do objeto "a2" em uma única String (texto)
			String valoresA2 = a2.getPreco() + ";" + "\n";
			// Escrever os valores do objeto "a2" no "arquivo"
			arquivo.write(valoresA2.getBytes());

			// Juntar os valores do objeto "a3" em uma única String (texto)
			String valoresA3 = a3.getQuantidade () + ";" + "\n";
			// Escrever os valores do objeto "a3" no "arquivo"
			arquivo.write(valoresA3.getBytes());

			System.out.println("Objetos gravados com sucesso no arquivo.");

			// Início da leitura dos valores de dentro do arquivo
			leitura = new FileInputStream("agenda.txt");

			// Utilização da classe InputStreamReader para recuperar todo o
			// conteúdo escrito dentro do arquivo "agenda.txt"
			// import java.io.InputStreamReader;
			InputStreamReader todoConteudo = new InputStreamReader(leitura);

			// Transformando "todoConteudo" do arquivo em um formato que é
			// possível fazer a sua leitura na forma de String (texto)
			// bem como é possível percorrer linha a linha. Isso é possível
			// com a classe BufferedReader (criado no começo do código)
			conversao = new BufferedReader(todoConteudo);

			// Criação do Scanner para ler um valor pelo teclado
			Scanner sc = new Scanner(System.in);
			System.out.println("Qual nome deseja buscar?");
			String nome = sc.next();

			// Criação de um objeto String para armazenar uma cópia do
			// valor da linha caso encontre o nome pesquisado
			String linhaCopia = ""; // Linha pode começar em branco para facilitar
									// a conferência caso tenha encontrado ou não

			// Utilização da repetição "while" que irá percorrer o arquivo
			// enquanto houverem linhas para serem lidas
			while (conversao.ready() == true) { // Enquanto houverem linhas
				// Pegamos o valor da linha atual que está sendo lida
				String linha = conversao.readLine();

				// Verificar se (IF) nessa "linha" existe o "nome" procurado
				// O método contains() indica se existe ou não o valor passado
				// como parâmetro dentro do parênteses
				if (linha.contains(nome)) {
					// Se a linha contém o nome procurado, copiamos a linha
					linhaCopia = linha;
				} else {
					// Caso não encontrou o nome informado
					// System.out.println("O nome " + nome + " não foi achado." );
				}
			}

			// Após percorrer todo o conteúdo do arquivo com o comando while
			// verificamos o que tem dentro da "linhaCopia"
			// Para comparar textos não é possível usar o == mas sim o método
			// equals() e passar um texto (String)
			if (linhaCopia.equals("")) {
				// Se "linhaCopia" for igual (equals) ""
				System.out.println("O nome " + nome + " não foi encontrado");
			} else {
				// Se "linhaCopia" não for igual a "", quer dizer que encontrou
				System.out.println(linhaCopia);

				
			}
			// Fechar (liberar recurso) do objeto "sc" (Scanner)
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("Não foi possível criar o arquivo.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Não foi possível escrever no arquivo.");
			e.printStackTrace();
		} finally {
			// Encerrar os recursos usados
			try {
				arquivo.close();
				leitura.close();
				conversao.close();
			} catch (IOException e) {
				System.out.println("Não foi possível finalizar.");
				e.printStackTrace();
			}
		}
	}

}
