package model;

/**
 * Classe para armazenar os atributos e métodos do objeto contato
 *
 * @author Diego Almeida da Silva
 * @since 23 de fev. de 2021
 */
public class Contato {

	//declarando os atributos do objeto contato
	private String celular;
	private String email;
	
	//métodos para acessar os atributos
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
