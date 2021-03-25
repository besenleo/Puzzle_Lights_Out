package teste;

import java.util.Collection;

import dao.InputInstance;
import solver.EspacoDeEstados;
import entity.Estado;
import entity.Tabuleiro;
import entity.estruturas.Fila;
import entity.estruturas.Pilha;

public class TesteEstadoSolver {
	
	public static void main(String[] args) {
		Tabuleiro t = InputInstance.getInstance("files/insts/inst_3_0372.in");
		Estado e = new Estado(t);
		System.out.println("Começando com o estado ");
		System.out.println(e);
		
		EspacoDeEstados ee = new EspacoDeEstados(e, new Fila());
		Estado solucao = ee.solve();
		System.out.println(e);
	}

}
