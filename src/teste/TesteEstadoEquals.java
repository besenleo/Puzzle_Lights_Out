package teste;

import dao.InputInstance;
import solver.EspacoDeEstados;
import entity.Estado;
import entity.Tabuleiro;

public class TesteEstadoEquals {
	
    public static void main(String[] args) {
	Tabuleiro t = InputInstance.getInstance("files/inst01.in");
	Estado e = new Estado(t);
	Tabuleiro tO = InputInstance.getInstance("files/inst_obj.in");
	Estado eO = new Estado(tO);
	
	System.out.println("estado inst01 eh objetivo?");
	System.out.println(e);
	System.out.println(e.isObjetivo());
	System.out.println("estado inst_obj eh objetivo?");
	System.out.println(eO);
	System.out.println(eO.isObjetivo());
		
    }

}
