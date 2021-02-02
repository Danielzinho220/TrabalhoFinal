import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Geral {

	public static void main(String[] args) {

		FileOutputStream arquivo = null;

		FileInputStream leitura = null;

		BufferedReader conversao = null;

		try {
			// Criar o arquivo "Produtos.txt" na pasta do projeto
			arquivo = new FileOutputStream("Produtos.txt");

			// Cria��o de 3 objetos da classe
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Digite o c�digo");
			int codigo = sc.nextInt();
			
			System.out.println("Digite o nome");
			String nome = sc.next();
			
			System.out.println("Digite o pre�o");
			double preco = sc.nextDouble();
			
			System.out.println("Digite a quantidade");
			int quantidade = sc.nextInt();
			
			Produto p = new Produto(nome, preco, quantidade, codigo);
			
			
			

			System.out.println("Objetos gravados com sucesso no arquivo.");
              
			// In�cio da leitura dos valores de dentro do arquivo
			leitura = new FileInputStream("Produtos.txt");

			// Utiliza��o da classe InputStreamReader para recuperar todo o
			// conte�do escrito dentro do arquivo "agenda.txt"
			// import java.io.InputStreamReader;
			InputStreamReader todoConteudo = new InputStreamReader(leitura);

			// Transformando "todoConteudo" do arquivo em um formato que �
			// poss�vel fazer a sua leitura na forma de String (texto)
			// bem como � poss�vel percorrer linha a linha. Isso � poss�vel
			// com a classe BufferedReader (criado no come�o do c�digo)
			conversao = new BufferedReader(todoConteudo);

			Scanner teclado = new Scanner(System.in);
			System.out.println("Qual nome deseja buscar?");
			 nome = sc.next();

			// Cria��o de um objeto String para armazenar uma c�pia do
			// valor da linha caso encontre o nome pesquisado
			String linhaCopia = ""; // Linha pode come�ar em branco para facilitar
			// a confer�ncia caso tenha encontrado ou n�o
			
			sc.close();
			
			// Utiliza��o da repeti��o "while" que ir� percorrer o arquivo
			// enquanto houverem linhas para serem lidas
			while (conversao.ready() == true) { // Enquanto houverem linhas
				// Pegamos o valor da linha atual que est� sendo lida
				String linha = conversao.readLine();
				
				// Verificar se (IF) nessa "linha" existe o "nome" procurado
				// O m�todo contains() indica se existe ou n�o o valor passado
				// como par�metro dentro do par�nteses
				if (linha.contains(nome)) {
					// Se a linha cont�m o nome procurado, copiamos a linha
					linhaCopia = linha;
				} else {
					// Caso n�o encontrou o nome informado
					// System.out.println("O nome " + nome + " n�o foi achado." );
				}
			}

			// Ap�s percorrer todo o conte�do do arquivo com o comando while
			// verificamos o que tem dentro da "linhaCopia"
			// Para comparar textos n�o � poss�vel usar o == mas sim o m�todo
			// equals() e passar um texto (String)
			if (linhaCopia.equals("")) {
				// Se "linhaCopia" for igual (equals) ""
				System.out.println("O nome " + nome + " n�o foi encontrado");
			} else {
				// Se "linhaCopia" n�o for igual a "", quer dizer que encontrou
				System.out.println(linhaCopia);

			}
			// Fechar (liberar recurso) do objeto "sc" (Scanner)
			teclado.close();

		} catch (FileNotFoundException e) {
			System.out.println("N�o foi poss�vel criar o arquivo.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel escrever no arquivo.");
			e.printStackTrace();
		} finally {

			try {
				arquivo.close();
				leitura.close();
				conversao.close();
			} catch (IOException e) {
				System.out.println("N�o foi poss�vel finalizar.");
				e.printStackTrace();
				
			}
		}
	}

}
