package model;

/**
 * Classe para armazenar os atributos e m�todos do objeto Materia
 *
 * @author Diego Almeida da Silva
 * @since 23 de fev. de 2021
 */
public class Materia {
	
	//declarando os atributos do objeto Materia
	private int codigo;
	private String nome;
	
	//m�todos para acessar os atributos
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

}
