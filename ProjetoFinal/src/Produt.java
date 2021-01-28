import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Produt {

	public static void main(String[] args) {
		// Classe FileOutputStream para criar o arquivo
		FileOutputStream arquivo = null;
		// Classe FileInputStream para ler o conte�do do arquivo
		FileInputStream leitura = null;
		// Classe BufferedReader para recuperar o conte�do em texto
		BufferedReader conversao = null;

		try {
			// Criar o arquivo "agenda.txt" na pasta do projeto
			arquivo = new FileOutputStream("agenda.txt");

			// Cria��o de 3 objetos da classe Agenda
			Agenda a1 = new Agenda("Douglas", "d@email", "985491589", 35);
			Agenda a2 = new Agenda("Gabriela", "gab@email", "98747774", 37);
			Agenda a3 = new Agenda("Bruno", "br@email", "96546532", 27);

			// Juntar todos os valores do objeto "a1" em uma String (texto) s�
			String valoresA1 = a1.getNome() + ";" + a1.getEmail() + ";" + a1.getTelefone() + ";" + a1.getIdade() + "\n";

			// Escrever os valores do objeto "a1" no "arquivo"
			arquivo.write(valoresA1.getBytes());
			// Ou, em duas etapas
			// byte[] val1 = valoresA1.getBytes();
			// arquivo.write(val1);

			// Juntar os valores do objeto "a2" em uma �nica String (texto)
			String valoresA2 = a2.getNome() + ";" + a2.getEmail() + ";" + a2.getTelefone() + ";" + a2.getIdade() + "\n";
			// Escrever os valores do objeto "a2" no "arquivo"
			arquivo.write(valoresA2.getBytes());

			// Juntar os valores do objeto "a3" em uma �nica String (texto)
			String valoresA3 = a3.getNome() + ";" + a3.getEmail() + ";" + a3.getTelefone() + ";" + a3.getIdade() + "\n";
			// Escrever os valores do objeto "a3" no "arquivo"
			arquivo.write(valoresA3.getBytes());

			System.out.println("Objetos gravados com sucesso no arquivo.");

			// In�cio da leitura dos valores de dentro do arquivo
			leitura = new FileInputStream("agenda.txt");

			// Utiliza��o da classe InputStreamReader para recuperar todo o
			// conte�do escrito dentro do arquivo "agenda.txt"
			// import java.io.InputStreamReader;
			InputStreamReader todoConteudo = new InputStreamReader(leitura);

			// Transformando "todoConteudo" do arquivo em um formato que �
			// poss�vel fazer a sua leitura na forma de String (texto)
			// bem como � poss�vel percorrer linha a linha. Isso � poss�vel
			// com a classe BufferedReader (criado no come�o do c�digo)
			conversao = new BufferedReader(todoConteudo);

			// Cria��o do Scanner para ler um valor pelo teclado
			Scanner sc = new Scanner(System.in);
			System.out.println("Qual nome deseja buscar?");
			String nome = sc.next();

			// Cria��o de um objeto String para armazenar uma c�pia do
			// valor da linha caso encontre o nome pesquisado
			String linhaCopia = ""; // Linha pode come�ar em branco para facilitar
									// a confer�ncia caso tenha encontrado ou n�o

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

				// Dividir a "linhaCopia" separando os valores com base no ;
				// Para separar iremos usar o m�todo split(). O resultado
				// do split � sempre um vetor de String
				String vet[] = linhaCopia.split(";");

				// Como os valores forem gravados na sequ�ncia: Nome, Email,
				// Telefone e Idade, estes estar�o nessa mesma sequ�ncia no vet
				System.out.println("Nome: " + vet[0]);
				System.out.println("E-mail: " + vet[1]);
				System.out.println("Telefone: " + vet[2]);
				System.out.println("Idade: " + vet[3]);
			}
			// Fechar (liberar recurso) do objeto "sc" (Scanner)
			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("N�o foi poss�vel criar o arquivo.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("N�o foi poss�vel escrever no arquivo.");
			e.printStackTrace();
		} finally {
			// Encerrar os recursos usados
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