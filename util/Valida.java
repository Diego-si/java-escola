package util;

/**
 * Classe respons�vel por validar os dados inputadors pelo usuario
 *
 * @author Diego Almeida da Silva
 * @since 23 de fev. de 2021
 */
public class Valida {
	
	// varificando se o valor digitado e nulo ou vazio
	public static boolean isEmptyOrNull(String string) {
		return (string == null || string.trim().equals(""));
	}

	//verificando se o valor informado � zero
	public static boolean isIntZero(int args) {
		return (args == 0);
	}
	
	//verificando se o valor informado � zero (tipo double)
	public static boolean isDoubleZero(double args) {
		return (args == 0);
	}
}
