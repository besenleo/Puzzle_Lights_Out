package teste;

import entity.Posicao;

public class TestePosicaoEquals {
	
	public static void main(String[] args) {
		Posicao p = new Posicao(1,1);
		Posicao pO = new Posicao(1,1);
		
		System.out.println("A posicao (1,1) eh igual a ela msm?");
		System.out.println(p.equals(pO));
                
		
	}

}
