package teste;

import dao.InputInstance;
import entity.Tabuleiro;

public class TesteDao {
	
	public static void main(String[] args) {
		Tabuleiro t = InputInstance.getInstance("files/inst01.in");
		
		System.out.println(t);
	}

}
