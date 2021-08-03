package model;

import java.util.ArrayList;

/**
 * Classe responsável por armazenar os atributos e métodos do objeto Professor
 *
 * @author Diego Almeida da Silva
 * @since 23 de fev. de 2021
 */
public class Professor extends Funcionario{

	//declarando os atributos do professor
	private ArrayList<Materia> listaMaterias;
	
	//atributo para retorna a lista de materias
	public ArrayList<Materia> getListaMaterias() {
		return listaMaterias;
	}
	
	//atribuindo a materia a professor
	public void setListaMaterias(ArrayList<Materia> listaMaterias) {
		this.listaMaterias = listaMaterias;
	}
	
	
}
