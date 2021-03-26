package teste;

import java.util.Collection;

import dao.InputInstance;
import solver.EspacoDeEstados;
import entity.Estado;
import entity.Tabuleiro;

public class TesteEstadoGeraFilhos {
	
    public static void main(String[] args) {
	Tabuleiro t = InputInstance.getInstance("files/inst02.in");
	Estado e = new Estado(t);
//		Tabuleiro tO = InputInstance.getInstance("files/inst_obj.in");
//		Estado eO = new Estado(tO);
		
	System.out.println("estado original");
	System.out.println(e);
		
	Collection<Estado> filhos = e.geraFilhos();
		
	System.out.println("filhos");
	for(Estado filho: filhos)
            System.out.println(filho);	
	}
}
