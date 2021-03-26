package entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Tabuleiro {
	
	int tam; 
	int[][] pecas;
	
	public Tabuleiro(int tam, int[][] aPecas) {
		this.pecas = aPecas;
                this.tam = tam;
	}
        
        public int[][] getPecas() {
		return pecas;
	}
        
        public int getTam() {
            return tam;
        }
        
	private Boolean isAcaoValida(Posicao p){
            if (p.linha < 0 || p.linha >= this.tam){
                return false;
            }
            if (p.coluna < 0 || p.coluna >= this.tam){
                return false;
            }
            return true;
        }
        
        
        public Collection<Posicao> todasLuzesAcesas(){
            // Retorna um Map com as peças com mais luzes acesas adjacentes
            Collection<Posicao> posicoesComMaisLuzes = new ArrayList<>();
            
            for(int i=0; i<this.tam; i++) {
                for(int j=0; j<this.tam; j++) {
                    posicoesComMaisLuzes.add(new Posicao(i,j));
	        }
	    }           
            return posicoesComMaisLuzes;
        }
                    
        private void trocaValor(Posicao p){
            if (this.isAcaoValida(p) == true){
                if (this.pecas[p.linha][p.coluna] == 0){
                    this.pecas[p.linha][p.coluna] = 1;
                }else{
                    this.pecas[p.linha][p.coluna] = 0;
                }
            }
        }
        
	public void fazerAcao(Posicao p) {
            // Troca o valor da peça principal
            this.trocaValor(p); 
            // Troca o valor da peça acima
            this.trocaValor(new Posicao(p.linha-1, p.coluna));
             // Troca o valor da peça abaixo
            this.trocaValor(new Posicao(p.linha+1, p.coluna));
            // Troca o valor da peça a esquerda
            this.trocaValor(new Posicao(p.linha, p.coluna-1));
            // Troca o valor da peça a direita
            this.trocaValor(new Posicao(p.linha, p.coluna+1)); 
	}
	
	public Tabuleiro deepCopy() {
		int[][] novoPecas = new int[this.tam][this.tam];
		for(int i=0; i<this.tam; i++) {
			for(int j=0; j<this.tam; j++) {
				novoPecas[i][j] = this.pecas[i][j];
			}
		}
		return new Tabuleiro(this.tam, novoPecas);
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.deepHashCode(pecas);
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tabuleiro other = (Tabuleiro) obj;
		if (!Arrays.deepEquals(pecas, other.pecas))
			return false;
		return true;
	}



	@Override
	public String toString() {
		String res = "";
		
		for(int i=0; i<this.tam; i++) {
			for(int j=0; j<this.tam; j++) {
				res += this.pecas[i][j] + " ";
			}
			res += "\n";
		}
		return res;
	}
	
	

}
