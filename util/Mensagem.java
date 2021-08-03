package util;

/**
 * Classe para armazenar as mensagens exibidas ao usuario
 *
 * @author Diego Almeida da Silva
 * @since 23 de fev. de 2021
 */
public class Mensagem {
	
	// mensagens exibidas ao usuario
	public static String informeCodigo = "Informe o codigo";
	public static String informeNome = "Informe o nome";
	public static String informeCpf = "Informe o CPF";
	public static String informeRg = "Informe o RG";
	
	//mensagens exibidas ao usuario do tipo ENDEREÇO
	public static String informeLogradouro = "Informe o Logradouro";
	public static String informeNomeLogradouro = "Informe o nome do logradouro";
	public static String informeNumero = "Informe o número";
	public static String informeComplemento = "Informe o complemento";
	public static String informeBairro = "Informe o bairro";
	public static String informeCidade = "Informe o cidade";
	public static String informeEstado = "Informe o estado";
	public static String informeCep = "Informe o CEP";

	//mensagens exibidas ao usuario DO TIPO CONTATO 
	public static String informeCelular = "Informe o Celular";
	public static String informeEmail = "Informe o EMAIL";

	// mensagens exibidas ao usuario DO TIPO SALARIO
	public static String informeSalario = "Informe o salário";
	
	//mensagens exibidas ao usuario DO TIPO ANO
	public static String informeAno = "Informe o Ano";
	
	//mensagens exibidas ao usuario do tipo vazio
	public static String codigoVazio = "Informe o código, campo obrigatorio!";
	public static String nomeVazio = "Informe o nome, campo obrigatorio!";
	public static String cpfVazio = "Informe o CPF, campo obrigatorio!";
	public static String rgVazio = "Informe o RG, campo obrigatorio!";

	//mensagens exibidas ao usuario do tipo vazio contato
	public static String celularVazio = "Informe o celular, campo obrigatorio!";
	public static String emailVazio = "Informe o email, campo obrigatorio!";

	//mensagens exibidas ao usuario do tipo vazio salario
	public static String salarioVazio = "Informe o salário, campo obrigatorio!";

	//mensagens exibidas ao usuario do tipo vazio ano
	public static String anoVazio = "Informe o ano, campo obrigatorio!";
	
	//mensagens exibidas ao usuario do tipo vazio ENDEREÇO
	public static String logradouroVazio = "Informe o logradouro, campo obrigatório"; 
	public static String nomeLogradouroVazio = "Informe o nome logradouro, campo obrigatório"; 
	public static String numeroVazio = "Informe o número, campo obrigatório"; 
	public static String bairroVazio = "Informe o bairro, campo obrigatório"; 
	public static String cidadeVazio = "Informe a cidade, campo obrigatório"; 
	public static String estadoVazio = "Informe o estado, campo obrigatório"; 
	public static String cepVazio = "Informe o CEP, campo obrigatório"; 
			
	//mensagens exibidas ao usuario do tipo invalido
	public static String codigoInvalido = "Informe um codigo válido";
	public static String nomeInvalido = "Informe um nome válido";
	public static String numeroInvalido =  "Informe um número válido";

	//mensagens exibidas ao usuario do tipo invalido
	public static String salarioInvalido =  "Informe um salário válido";
	public static String anoInvalido =  "Informe um ano válido";

	//mensagens exibidas ao usuario do tipo invalido opcao
	public static String opcaoInvalida = "Opção inválida!";

	//mensagens exibidas ao usuario do tipo vazio na verificação se exitem alunos professores e turmas
	public static String alunosVazio = "Não existem alunos cadastrados";
	public static String porfessoresVazio = "Não existem professores cadastrados";
	public static String turmasVazio = "Não existem turmas cadastradas";

	//mensagens exibidas ao usuario do tipo valido
	public static String materiaCadastrada = "Matéria cadastrada com sucesso!";
	public static String professorCadastrada = "Professor cadastrado com sucesso!";
	public static String alunoCadastrada = "Aluno cadastrado com sucesso!";
	public static String turmaCadastrada = "Turma cadastrada com sucesso!";

	//mensagens exibidas ao usuario do tipo erro ao cadastrar
	public static String erroCadastroPorfessor = "Para cadastrar um professor, cadastre primeiro a matéria!";
	public static String erroCadastroTurma = "Erro ao cadastrar turma";

	
}
