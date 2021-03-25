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
        
        private Boolean isLuzAcessa(Posicao p){
            // Valida se a posição é valida
            if (this.isAcaoValida(p) == false){
                return false;
            }
            // Quando for valida, vai retornar true para aceso e false para apagado
            if(this.pecas[p.linha][p.coluna] == 1){
                return true;
            }else{
                return false;
            }
        }
        
        private int luzesAcesas(Posicao p){
            // Valida quantas luzes adjacentes estao acesas
            int luzesAcesas = 0;
            
            // Centro
            if (isLuzAcessa(p) == true){luzesAcesas += 1;}
            // Acima
            if (isLuzAcessa(new Posicao(p.linha-1, p.coluna)) == true){luzesAcesas += 1;}
            // Abaixo
            if (isLuzAcessa(new Posicao(p.linha+1, p.coluna)) == true){luzesAcesas += 1;}
            // Esquerda
            if (isLuzAcessa(new Posicao(p.linha, p.coluna-1)) == true){luzesAcesas += 1;}
            // Direita
            if (isLuzAcessa(new Posicao(p.linha, p.coluna+1)) == true){luzesAcesas += 1;}
            return luzesAcesas;
        }
        
        public Map<Posicao,Integer> todasLuzesAcesas(){
            // Retorna um Map com as peças com mais luzes acesas adjacentes
            Map<Posicao,Integer> posicoesComMaisLuzes = new HashMap<>();
            int maxLuzesAcessas = 0;
            int qtdLuzes;
            
            for(int i=0; i<this.tam; i++) {
                for(int j=0; j<this.tam; j++) {
                    qtdLuzes = this.luzesAcesas(new Posicao(i,j));
                    posicoesComMaisLuzes.put(new Posicao(i,j), qtdLuzes);
	        }
	    }           
            return posicoesComMaisLuzes;
        }
        
        private int luzesAdjacentes(Posicao p){
            // Valida quantas luzes estao adjacentes, independente do estado delas
            int luzesAdjacentes = 0;

            // Centro
            if (isAcaoValida(p) == true){luzesAdjacentes += 1;}
            // Acima
            if (isAcaoValida(new Posicao(p.linha-1, p.coluna)) == true){luzesAdjacentes += 1;}
            // Abaixo
            if (isAcaoValida(new Posicao(p.linha+1, p.coluna)) == true){luzesAdjacentes += 1;}
            // Esquerda
            if (isAcaoValida(new Posicao(p.linha, p.coluna-1)) == true){luzesAdjacentes += 1;}
            // Direita
            if (isAcaoValida(new Posicao(p.linha, p.coluna+1)) == true){luzesAdjacentes += 1;}
            return luzesAdjacentes;
        }
        
        public Map<Posicao,Integer> todasLuzesAdjacentes(){
            // Retorna um Map com todas as peças adjacentes de cada posição
            Map<Posicao,Integer> todasLuzesAdjacentes = new HashMap<>();
            int luzes; 
                    
            for(int i=0; i<this.tam; i++) {
                for(int j=0; j<this.tam; j++) {
                    luzes = luzesAdjacentes(new Posicao(i,j));
                    todasLuzesAdjacentes.put(new Posicao(i,j), luzes);
	        }
	    }           
            return todasLuzesAdjacentes;
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
