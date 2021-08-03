package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Contato;
import model.Endereco;
import model.Materia;
import model.Professor;
import model.Turma;
import util.Mensagem;
import util.Rotulo;
import util.Valida;

/**
 * Classe responsável por controlar o sistema de gerenciamento de gerenciamento
 * para cadastro de alunos, turmas, matérias e professores
 *
 * @author Diego Almeida da Silva
 * @since 23 de fev. de 2021
 */
public class GerenciaEscola {

	// declarando as listas para armazenar os conteúdos do sistema(ALUNOS,
	// PROFESSORES)
	private ArrayList<Aluno> alunos;
	private ArrayList<Professor> professores;
	private ArrayList<Materia> materias;
	private ArrayList<Turma> turmas;

	// construtor da classe
	public GerenciaEscola() {
		alunos = new ArrayList<Aluno>();
		professores = new ArrayList<Professor>();
		materias = new ArrayList<Materia>();
		turmas = new ArrayList<Turma>();
		menuPrincipal();
	}

	// método para criar um menu de opções
	public void menuPrincipal() {
		//mensagem do menu
		String menu = "INFORME A OPÇÃO DESEJADA\n\n" + "\n1 - CADASTRAR MATÉRIA" + "\n2 - CADASTRAR PROFESSOR"
				+ "\n3 - CADASTRAR ALUNO" + "\n4 - CADASTRAR TURMA" + "\n5 - LISTAR ALUNOS" + "\n6 - LISTAR PROFESSORES"
				+ "\n7 - LISTAR TURMAS" + "\n8 - CONSULTAR TURMA" + "\n9 - SAIR DO SISTEMA\n\n";

		//verificando a opcao do usuario
		while (true) {
			try {
				int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));
				processamentoPrincipal(opcao);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.sistemaEscola, 0);
			}
		}

	}

	// método para controlar o processamento
	public void processamentoPrincipal(int opcao) {
		switch (opcao) {
		case 1: {
			cadastrarMateria();
			break;
		}
		case 2: {
			cadastrarProfessor();
			break;
		}
		case 3: {
			cadastrarAluno();
			break;
		}
		case 4: {
			cadastrarTurma();
			break;
		}
		case 5: {
			listarALunos();
			break;
		}

		case 6: {
			listarProfessores();
			break;
		}

		case 7: {
			listarTurmas();
			break;
		}

		case 8: {
			consultarTurma();
			break;

		}
		case 9: {
			sair();
			break;
		}
		default:
			JOptionPane.showMessageDialog(null, Mensagem.opcaoInvalida, Rotulo.sistemaEscola, 0);
		}
	}

	// método para cadastrar matéria
	public void cadastrarMateria() {
		materias.add(getMateria());
		JOptionPane.showMessageDialog(null, Mensagem.materiaCadastrada, Rotulo.cadastroMateria, 1);
	}

	// método para cadastrar professor
	public void cadastrarProfessor() {
		if (materias.size() > 0) {
			professores.add(getProfessor());
			JOptionPane.showMessageDialog(null, Mensagem.professorCadastrada, Rotulo.cadastroProfessor, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.erroCadastroPorfessor, Rotulo.cadastroProfessor, 2);
		}
	}

	// método para cadastrar aluno
	public void cadastrarAluno() {
		alunos.add(getAluno());
		JOptionPane.showMessageDialog(null, Mensagem.alunoCadastrada, Rotulo.cadastroAluno, 1);
	}

	// método para cadastrar turma
	public void cadastrarTurma() {

		if (professores.size() > 0 && alunos.size() > 0) {
			turmas.add(getTurma());
			JOptionPane.showMessageDialog(null, Mensagem.turmaCadastrada, Rotulo.cadastroTurmas, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.erroCadastroTurma, Rotulo.cadastroTurmas, 2);
		}

	}

	// método para retornar um objeto do tipo turma
	private Turma getTurma() {
		// inicializando os objeto
		Turma turma = new Turma();

		//atribuindo o codigo da turma
		turma.setCodigo(getCodigoTurma());
		//atribuindo o ano da turma
		turma.setAno(getAno());
		//atribuindo em turma o professor cadastrado
		turma.setProfessor(getProfessorTurma());
		//atribuindo em turma a materia cadastrada
		turma.setMateria(getMateriaTurma());
		//atribuindo em turma o aluno cadastrado
		turma.setAlunos(getAlunosTurma());

		return turma;
	}

	// método para listar alunos
	public void listarALunos() {
		
		String mensagem = "Alunos cadastrados\n";
		boolean existe = false;
		
		//enquanto existe aluno sera exibido a lista 
		for (Aluno aluno : alunos) {
			existe = true;
			mensagem += "\ncódigo: " + aluno.getCodigo() + " - " + aluno.getNome();
		}

		//se existe aluno sera exibido
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroAluno, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.alunosVazio, Rotulo.cadastroAluno, 2);
		}
	}

	// método para listar porfessores
	public void listarProfessores() {

		String mensagem = "Professores cadastrados\n";
		boolean existe = false;

		//laço que verifica se existe professores
		for (Professor professor : professores) {
			existe = true;
			mensagem += "\nCódigo: " + professor.getCodigo() + " - " + professor.getNome();
		}

		//se existe sera exibido a mensagem
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroProfessor, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.porfessoresVazio, Rotulo.cadastroProfessor, 2);
		}
	}

	// método para listar turmas
	public void listarTurmas() {

		String mensagem = "Turmas cadastradas\n";
		boolean existe = false;

		//laço de turma para ate quando existir turma
		for (Turma turma : turmas) {
			existe = true;
			mensagem += "\nCódigo: " + turma.getCodigo() + " - " + turma.getAno() + " - "
					+ turma.getMateria().getNome();
		}

		//se existe turma sera exibido a mensagem
		if (existe) {
			JOptionPane.showMessageDialog(null, mensagem, Rotulo.cadastroTurmas, 1);
		} else {
			JOptionPane.showMessageDialog(null, Mensagem.turmasVazio, Rotulo.cadastroTurmas, 2);
		}
	}

	// método para consultar turmas cadastrardass
	public void consultarTurma() {

		// inicializando os objeto
		Turma turma = getConsultarTurma();

		//exibindo os detalhes de turma
		String mensagem = "Detalhes da Turma\n";
		mensagem += "\nCódigo: " + turma.getCodigo();
		mensagem += "\nAno: " + turma.getAno();
		mensagem += "\nProfessor: " + turma.getProfessor().getNome();
		mensagem += "\nMatéria: " + turma.getMateria().getNome();
		mensagem += "\n\nAlunos Matriculados:";

		//enquanto existe alunos na turma.getAlunos() sera exibido a mensagem
		for (Aluno aluno : turma.getAlunos()) {
			mensagem += "\nCódigo: " + aluno.getCodigo() + " - " + aluno.getNome();
		}
		JOptionPane.showMessageDialog(null, mensagem, Rotulo.consultaTurmas, 1);
	}

	// método para sair do sistema
	public void sair() {
		//recebendo a opcao do usuario e perguntando se ele realmente quer sair do sistema
		int opcao = JOptionPane.showConfirmDialog(null, "Encerrar o sistema?", "Atenção", JOptionPane.YES_OPTION,
				JOptionPane.CANCEL_OPTION);

		if (opcao == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	// método para retornar os atributos (valores) do aluno
	public Aluno getAluno() {
		// inicializando os objeto
		Aluno aluno = new Aluno();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();
		
		//recebendo os dados e atribuindo no aluno
		aluno.setCodigo(getCodigoAluno());
		aluno.setNome(getNomeAluno());
		aluno.setCpf(getCpfAluno());
		aluno.setRg(getRgAluno());

		//recebendo os dados e atribuindo em endereco
		endereco.setLogradouro(getLogradouro());
		endereco.setNome(getNomeLogradouro());
		endereco.setNumero(getNumero());
		endereco.setComplemento(getComplemento());
		endereco.setBairro(getBairro());
		endereco.setCidade(getCidade());
		endereco.setEstado(getEstado());
		endereco.setCep(getCep());

		//atribuindo os dados de contato
		contato.setCelular(getCelular());
		contato.setEmail(getEmail());

		//setando endereço em aluno
		aluno.setEndereco(endereco);
		//setando o contado em aluno
		aluno.setContato(contato);
		return aluno;
	}

	// método para retorna os atributos (valores) do professor
	private Professor getProfessor() {
		// inicializando os objeto
		Professor professor = new Professor();
		Endereco endereco = new Endereco();
		Contato contato = new Contato();

		//setando os dados em professor
		professor.setCodigo(getCodigoProfessor());
		professor.setNome(getNomeProfessor());
		professor.setCpf(getCpfProfessor());
		professor.setRg(getRgProfessor());

		//setando os dados de endereço
		endereco.setLogradouro(getLogradouro());
		endereco.setNome(getNomeLogradouro());
		endereco.setNumero(getNumero());
		endereco.setComplemento(getComplemento());
		endereco.setBairro(getBairro());
		endereco.setCidade(getCidade());
		endereco.setEstado(getEstado());
		endereco.setCep(getCep());

		//setando os dados de contato
		contato.setCelular(getCelular());
		contato.setEmail(getEmail());

		//atribuindo a lista de materias em professor
		professor.setListaMaterias(getMaterias());

		//setando o salario de professor
		professor.setSalario(getSalario());

		return professor;
	}

	// método para retornar um objeto materia
	private Materia getMateria() {
		// inicializando os objeto
		Materia materia = new Materia();
		
		//setando os dados de materia
		materia.setCodigo(getCodigoMateria());
		materia.setNome(getNomeMateria());

		return materia;
	}

	//método para retornar o codigo da matéria
	private int getCodigoMateria() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				//recebendo o codigo da matéria
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				//verificando se o código da matéria e vazio ou não
				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroMateria, 0);
					execute = true;
				} else {
					execute = false;
				}
				
			} catch (Exception e) { //caso de algum erro sera exibido o código inválido
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroMateria, 0);
				execute = true;
			}

		}
		return codigo;
	} // fim do metodo codigo materia

	//método para pegar o nome da matéria 
	private String getNomeMateria() {
		boolean execute = true;
		String nome = "";
		while (execute) {
			//recebendo o nome
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);

			//verificando se o nome e vazio ou não 
			if (Valida.isEmptyOrNull(nome)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroMateria, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nome;
	} // fim do metodo nome Materia

	//método para pegar o código do aluno
	private int getCodigoAluno() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				//recebendo o código do aluno
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));
				
				//verificando se o código é vazio ou não
				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroAluno, 0);
					execute = true;
				} else {
					execute = false;
				}

			} catch (Exception e) { // caso de algum erro informa que o código e inválido
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroAluno, 0);
				execute = true;
			}

		}
		return codigo;
	} // fim do metodo codigo aluno

	//método para pegar o nome do aluno
	private String getNomeAluno() {
		boolean execute = true;
		String nome = "";
		while (execute) {
			//recebendo o nome do aluno
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);

			//verificando se o código do aluno e vazio ou não
			if (Valida.isEmptyOrNull(nome)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nome;
	} // fim do metodo nome aluno

	//método para receber o cpf do aluno
	private String getCpfAluno() {
		boolean execute = true;
		String cpf = "";
		while (execute) {
			//recebendo o cpf do aluno
			cpf = JOptionPane.showInputDialog(Mensagem.informeCpf);

			//verificando se o cpf está vazio ou não
			if (Valida.isEmptyOrNull(cpf)) {
				JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cpf;
	} // fim do metodo cpf aluno

	//método para receber o RG do aluno
	private String getRgAluno() {
		boolean execute = true;
		String rg = "";
		while (execute) {
			//recebendo o rg do aluno
			rg = JOptionPane.showInputDialog(Mensagem.informeRg);

			//verificando se o rg esta vazio ou não
			if (Valida.isEmptyOrNull(rg)) {
				JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Rotulo.cadastroAluno, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return rg;
	} // fim do metodo rg aluno

	//método para receber o logradouro
	private String getLogradouro() {
		boolean execute = true;
		String logradouro = "";
		while (execute) {
			//recebendo o logradouro 
			logradouro = JOptionPane.showInputDialog(Mensagem.informeLogradouro);

			//verificando se o logradouro e vazio ou não 
			if (Valida.isEmptyOrNull(logradouro)) {
				JOptionPane.showMessageDialog(null, Mensagem.logradouroVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return logradouro;
	} // fim do metodo logradouro

	//método para o nome do logradouro
	private String getNomeLogradouro() {
		boolean execute = true;
		String nomeLogradouro = "";
		while (execute) {
			//recebendo o nome do logradouro
			nomeLogradouro = JOptionPane.showInputDialog(Mensagem.informeNomeLogradouro);

			//verificando se o nome do logradouro e vazio ou não
			if (Valida.isEmptyOrNull(nomeLogradouro)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeLogradouroVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nomeLogradouro;
	} // fim do metodo nomeLogradouro

	//método para receber o numero do endereço
	private int getNumero() {
		boolean execute = true;
		int numero = 0;
		while (execute) {
			try {
				//recebendo o número do endereço
				numero = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeNumero));

				//verficando se o número esta vazio ou não
				if (Valida.isIntZero(numero)) {
					JOptionPane.showMessageDialog(null, Mensagem.numeroVazio, Rotulo.cadastroEndereco, 0);
					execute = true;
				} else {
					execute = false;
				}

			} catch (Exception e) { //caso de algum erro exibi que o número esta inválido
				JOptionPane.showMessageDialog(null, Mensagem.numeroInvalido, Rotulo.cadastroEndereco, 0);
				execute = true;
			}

		}
		return numero;
	} // fim do metodo número do endereço

	//método para receber o complemento do endereço
	private String getComplemento() {
		String complemento = "";
		//recebendo o complemento e retornando
		complemento = JOptionPane.showInputDialog(Mensagem.informeComplemento);
		return complemento;
	} // fim do metodo complemento do endereço

	//método para receber o bairro do endereço
	private String getBairro() {
		boolean execute = true;
		String bairro = "";
		while (execute) {
			//recebendo o bairro
			bairro = JOptionPane.showInputDialog(Mensagem.informeBairro);

			//verificando se o bairro esta vazio ou não
			if (Valida.isEmptyOrNull(bairro)) {
				JOptionPane.showMessageDialog(null, Mensagem.bairroVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return bairro;
	} // fim do metodo bairro do endereço

	//método para receber a cidade
	private String getCidade() {
		boolean execute = true;
		String cidade = "";
		while (execute) {
			//recebendo a cidade
			cidade = JOptionPane.showInputDialog(Mensagem.informeCidade);

			//verificando se a cidade esta vazia ou não
			if (Valida.isEmptyOrNull(cidade)) {
				JOptionPane.showMessageDialog(null, Mensagem.cidadeVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cidade;
	} // fim do metodo cidade do endereço

	//método para receber estado
	private String getEstado() {
		boolean execute = true;
		String estado = "";
		while (execute) {
			//recebendo o estado
			estado = JOptionPane.showInputDialog(Mensagem.informeEstado);

			//verificando se o estado esta vazio ou não
			if (Valida.isEmptyOrNull(estado)) {
				JOptionPane.showMessageDialog(null, Mensagem.estadoVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return estado;
	} // fim do metodo estado do endereço

	//método para receber o CEP
	private String getCep() {
		boolean execute = true;
		String cep = "";
		while (execute) {
			//recebendo o cep 
			cep = JOptionPane.showInputDialog(Mensagem.informeCep);
			
			//verificando se o cep esta vazio ou não
			if (Valida.isEmptyOrNull(cep)) {
				JOptionPane.showMessageDialog(null, Mensagem.cepVazio, Rotulo.cadastroEndereco, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cep;
	} // fim do metodo cep do endereço

	//método para receber o celular de contato
	private String getCelular() {
		boolean execute = true;
		String celular = "";
		while (execute) {
			//recebendo o celular
			celular = JOptionPane.showInputDialog(Mensagem.informeCelular);

			//verificando se o celular esta vazio ou não
			if (Valida.isEmptyOrNull(celular)) {
				JOptionPane.showMessageDialog(null, Mensagem.celularVazio, Rotulo.cadastroContato, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return celular;
	} // fim do metodo celular de contato

	//método para receber o email de contato
	private String getEmail() {
		boolean execute = true;
		String email = "";
		while (execute) {
			//recebendo o email
			email = JOptionPane.showInputDialog(Mensagem.informeEmail);

			//verificando se o email esta vazio ou não
			if (Valida.isEmptyOrNull(email)) {
				JOptionPane.showMessageDialog(null, Mensagem.emailVazio, Rotulo.cadastroContato, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return email;
	} // fim do metodo email de contato

	//método para receber o codigo do professor
	private int getCodigoProfessor() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				//recebendo o codigo do professor
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				//verificando se o codigo esta vazio ou não
				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroProfessor, 0);
					execute = true;
				} else {
					execute = false;
				}

			} catch (Exception e) { //caso de algum erro informa que o codigo esta invalido
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroProfessor, 0);
				execute = true;
			}

		}
		return codigo;
	} // fim do método codigo Professor

	//método para receber o nome do professor
	private String getNomeProfessor() {
		boolean execute = true;
		String nome = "";
		while (execute) {
			//recebendo o nome do professor
			nome = JOptionPane.showInputDialog(Mensagem.informeNome);

			//verificando se o nome do professor esta vazio ou não
			if (Valida.isEmptyOrNull(nome)) {
				JOptionPane.showMessageDialog(null, Mensagem.nomeVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return nome;
	} // fim do metodo nome professor

	//método para receber o cpf do professor
	private String getCpfProfessor() {
		boolean execute = true;
		String cpf = "";
		while (execute) {
			//recebendo o cpf do professor
			cpf = JOptionPane.showInputDialog(Mensagem.informeCpf);

			//verificando se o cfp do professor esta vazio ou não
			if (Valida.isEmptyOrNull(cpf)) {
				JOptionPane.showMessageDialog(null, Mensagem.cpfVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return cpf;
	} // fim do metodo cpf professor

	//método para receber o rg do professor
	private String getRgProfessor() {
		boolean execute = true;
		String rg = "";
		while (execute) {
			//recebendo o rg do professor
			rg = JOptionPane.showInputDialog(Mensagem.informeRg);

			//verificando se o rg do professor esta vazio ou não
			if (Valida.isEmptyOrNull(rg)) {
				JOptionPane.showMessageDialog(null, Mensagem.rgVazio, Rotulo.cadastroProfessor, 0);
				execute = true;
			} else {
				execute = false;
			}
		}
		return rg;
	} // fim do metodo rg Professor

	//método do arrayLista de matérias
	private ArrayList<Materia> getMaterias() {
		ArrayList<Materia> materias = new ArrayList<Materia>();
		String mensagem = "Matérias cadastradas\n";

		//para todas as matérias, exibindo as matérias cadastradas
		for (Materia materia : this.materias) {
			mensagem += "\nCódigo: " + materia.getCodigo() + " - " + materia.getNome();
		}

		boolean aux = true;
		mensagem += "\n" + Mensagem.informeCodigo;
		while (aux) {
			try {
				//recebendo o código da materia que quer cadastrar para professor
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				materias.add(this.materias.get(codigo - 1));

				//verificando se quer cadastrar outra materia
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outra matéria?", "Atenção",
						JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);

				if (opcao == JOptionPane.YES_OPTION) {
					aux = true;
				} else {
					aux = false;
				}

			} catch (Exception e) { //caso de algum erro exibi que o código esta inválido
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroProfessor, 0);
			}
		}

		return materias;
	} // fim do método do arrayLista de matérias

	//método para receber o salário
	private double getSalario() {
		boolean execute = true;
		double salario = 0;
		while (execute) {
			try {
				//recebendo o salário
				salario = Double.parseDouble(JOptionPane.showInputDialog(Mensagem.informeSalario));

				//verificando se o salário esta vazio ou não
				if (Valida.isDoubleZero(salario)) {
					JOptionPane.showMessageDialog(null, Mensagem.salarioVazio, Rotulo.cadastroProfessor, 0);
					execute = true;
				} else {
					execute = false;
				}

			} catch (Exception e) { //caso de algum erro informa que o salário esta inválido
				JOptionPane.showMessageDialog(null, Mensagem.salarioInvalido, Rotulo.cadastroProfessor, 0);
				execute = true;
			}

		}
		return salario;
	} // fim do metodo salario

	//método para receber o codigo da turma
	private int getCodigoTurma() {
		boolean execute = true;
		int codigo = 0;
		while (execute) {
			try {
				//recebendo o códio da turma
				codigo = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeCodigo));

				//verificando se o codigo da turma esta vazio ou não
				if (Valida.isIntZero(codigo)) {
					JOptionPane.showMessageDialog(null, Mensagem.codigoVazio, Rotulo.cadastroTurmas, 0);
					execute = true;
				} else {
					execute = false;
				}

			} catch (Exception e) { //caso de algum erro informa que o código esta inválido
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurmas, 0);
				execute = true;
			}

		}
		return codigo;
	} // fim do metodo codigo turma

	//método para receber o ano
	private int getAno() {
		boolean execute = true;
		int ano = 0;
		while (execute) {
			try {
				//recendo do ano
				ano = Integer.parseInt(JOptionPane.showInputDialog(Mensagem.informeAno));

				//verificando se o ano esta vazio ou não 
				if (Valida.isIntZero(ano)) {
					JOptionPane.showMessageDialog(null, Mensagem.anoVazio, Rotulo.cadastroTurmas, 0);
					execute = true;
				} else {
					execute = false;
				}

			} catch (Exception e) { //caso de algum erro informa que o ano esta inválido
				JOptionPane.showMessageDialog(null, Mensagem.anoInvalido, Rotulo.cadastroTurmas, 0);
				execute = true;
			}

		}
		return ano;
	} // fim do metodo ano

	//método para atribuir professor as turmas
	private Professor getProfessorTurma() {
		Professor retorno = new Professor();
		String mensagem = "Professores cadastrados\n";

		//para todo os professores exibir a lista de professores
		for (Professor professor : professores) {
			mensagem += "\nCódigo: " + professor.getCodigo() + " - " + professor.getNome();
		}

		mensagem += "\n" + Mensagem.informeCodigo;
		try {
			//recebendo o codigo do professor
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			retorno = professores.get(codigo - 1);

		} catch (Exception e) { //caso de algum erro informa codigo invalido
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurmas, 0);
		}

		return retorno;
	} //fim do método para atribuir professor a turma

	//método para atribuir materia as turmas
	private Materia getMateriaTurma() {
		Materia retorno = new Materia();
		String mensagem = "Matérias cadastrados\n";

		//para todas as materias cadastrada exibir as materias
		for (Materia materia : materias) {
			mensagem += "\nCódigo: " + materia.getCodigo() + " - " + materia.getNome();
		}

		mensagem += "\n" + Mensagem.informeCodigo;
		try {
			//recebendo o codigo da materia que vai atribuir a turma
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			retorno = materias.get(codigo - 1);

		} catch (Exception e) { //caso der algum erro exibir codigo invalido
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurmas, 0);
		}

		return retorno;
	} //fim do método para atribuir materia a turma

	//método para atribuir aluno na turma
	private ArrayList<Aluno> getAlunosTurma() {
		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		String mensagem = "Alunos cadastradas\n";

		//para todos os alunos cadastrados exibir a lista de aluno e seu codigo
		for (Aluno aluno : this.alunos) {
			mensagem += "\nCódigo: " + aluno.getCodigo() + " - " + aluno.getNome();
		}

		boolean aux = true;
		mensagem += "\n" + Mensagem.informeCodigo;
		while (aux) {
			try {
				//recebendo o codigo de qual aluno vai para aquela turma
				int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
				alunos.add(this.alunos.get(codigo - 1));

				//verificando se quer cadastrar mais outro aluno naquela turma
				int opcao = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro aluno?", "Atenção",
						JOptionPane.YES_OPTION, JOptionPane.CANCEL_OPTION);

				if (opcao == JOptionPane.YES_OPTION) {
					aux = true;
				} else {
					aux = false;
				}

			} catch (Exception e) { //caso de algum erro informa código invalido
				JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurmas, 0);
			}
		}

		return alunos;
	} //fim do método de cadastra aluno na turma

	//método para consultar as turmas
	private Turma getConsultarTurma() {
		Turma retorno = new Turma();
		String mensagem = "Turmas cadastrados\n";

		//para todas as turmas que exite , exibe a lista de turmas
		for (Turma turma : turmas) {
			mensagem += "\nCódigo: " + turma.getCodigo() + " - " + turma.getAno() + " - "
					+ turma.getMateria().getNome();
		}

		mensagem += "\n" + Mensagem.informeCodigo;
		try {
			//recebendo o código de qual turma quer onsultar
			int codigo = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			retorno = turmas.get(codigo - 1);

		} catch (Exception e) { //caso de algum erro informa código invalido
			JOptionPane.showMessageDialog(null, Mensagem.codigoInvalido, Rotulo.cadastroTurmas, 0);
		}

		return retorno;
	} //fim do método para consultar turmas

} // fim da clasee
