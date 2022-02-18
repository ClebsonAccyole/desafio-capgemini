import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Desafio {
	
	public static String desafioDegraus(int qtdDegraus) {
		String degrau = "";
		StringBuilder escada = new StringBuilder();
		
		for (int i = qtdDegraus; i >= 1; i--) {
			if (i == qtdDegraus) {
				degrau = String.format("%" + i + "s", "*");
			} else {
				degrau = degrau.replace(" *", "**");
			}
			
			escada.append(degrau);
			
			if(i > 1) {
				escada.append("\n");
			}
		}
		
		return escada.toString();
	}
	
	public static int desafioSenhaForte(String senhaForte) throws Exception {
		int numeroEtapasValidas = 0;

		String regexLetrasMinusculas = "[a-z]";
		String regexLetrasMaiusculas = "[A-Z]";
		String regexNumeros = "[0-9]";
		String regexCaracteresEspecias = "[!@#$%^&*()\\-+]";
		
		if (senhaForte.length() < 3 ) {
			throw new Exception("Digite pelo menos 3 caracteres na senha!");
		}
		
		if (Pattern.compile(regexLetrasMinusculas).matcher(senhaForte).find()) {
			numeroEtapasValidas+=1;
		}
		
		if (Pattern.compile(regexLetrasMaiusculas).matcher(senhaForte).find()) {
			numeroEtapasValidas+=1;
		}
		
		if (Pattern.compile(regexNumeros).matcher(senhaForte).find()) {
			numeroEtapasValidas+=1;
		}
		
		if (Pattern.compile(regexCaracteresEspecias).matcher(senhaForte).find()) {
			numeroEtapasValidas+=1;
		}

		if (numeroEtapasValidas == 4) {
			if (senhaForte.length() >= 6) {
				return 0;
			} else {
				return 6 - numeroEtapasValidas;
			}
		} else {
			if (senhaForte.length() >= 6) {
				return 4 - numeroEtapasValidas;
			} else {
				return 6 - numeroEtapasValidas;
			}
		}
	}
	
	public static int imprimeAnagramas(String palavra) {
			List<String> resultado = new ArrayList<String>();
			int quantidadeAnagramas = 0;

		  for (int i = 0; i < palavra.length(); i++) {
		    for (int j = i + 1; j < palavra.length() + 1; j++) {
		    	resultado.add(palavra.substring(i, j));
		    }
		  }
		  
		  String[]a = new String[resultado.size()];
		  resultado.toArray(a);
		  
		  for (int i = 0; i <= a.length; i++) {
			  for (int j = (i + 1); j < a.length; j++) {
				  if (isAnagrama(a[i], a[j])) {
					  quantidadeAnagramas+=1;
				  }
			  }
			
		  }
		  
		  return quantidadeAnagramas;
	}
	
	private static boolean isAnagrama(String palavra1, String palavra2) {
		char[] tmpPalavra1 = palavra1.toCharArray();
		char[] tmpPalavra2 = palavra2.toCharArray();
		
		Arrays.sort(tmpPalavra1);
		Arrays.sort(tmpPalavra2);
		
		return Arrays.equals(tmpPalavra1, tmpPalavra2);
		
	}

}
