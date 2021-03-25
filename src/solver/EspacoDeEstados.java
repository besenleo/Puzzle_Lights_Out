package solver;

import entity.Estado;
import entity.Tabuleiro;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import entity.estruturas.EstadoAbertos;
import entity.estruturas.Fila;

public class EspacoDeEstados {
	
    Estado inicial;
    EstadoAbertos estadosAbertos;
    Set<Estado> estadosFechados;
	 
	 
    public EspacoDeEstados(Estado aInicial, EstadoAbertos aEstruturaAbertos) {
        this.inicial = aInicial;
	this.estadosAbertos = aEstruturaAbertos;
        estadosAbertos.push(this.inicial);
	estadosFechados = new HashSet<>();
    }		 
	 
    public Estado solve() {
	 
        while(estadosAbertos.size()>0) {
            Estado e = estadosAbertos.pop();
	    System.out.println("TESTANDO ESTADO");
	    System.out.println(e);
            System.out.println("Estados abertos: " + this.estadosAbertos.size());
            System.out.println("Estados fechados: " + this.estadosFechados.size());
	    if(e.isObjetivo()) {
                System.out.println("-------------ENCONTROU SOLUCAO----------");
                System.out.println(e);
                return e;
	    }
            estadosFechados.add(e);
	    Collection<Estado> filhos = e.geraFilhos();
	    for(Estado filho: filhos) {
		if(!estadosFechados.contains(filho))
                    estadosAbertos.push(filho);
            }    
        }
		 
        System.out.println("nao encontrou solucao");
		 
        return null;
    }
        
    public static final Estado geraObjetivo(int tamanho){
        Estado objetivo;
        int[][] pecas = new int[tamanho][tamanho];
	for(int i=0; i<tamanho; i++) {
            for(int j=0; j<tamanho; j++) {
		pecas[i][j] = 0;
            }
        }
        objetivo = new Estado(new Tabuleiro(tamanho, pecas));
            
        return objetivo;
    }
}
