package entity;

import java.util.Arrays;

public class Posicao {
	
    int linha;
    int coluna;
    public Posicao(int linha, int coluna) {
        super();
        this.linha = linha;
        this.coluna = coluna;
    }
        
    @Override
    public String toString() {
	return "(" + linha + ", " + coluna + ")";
    }
        
    @Override
    public int hashCode() {
        final int prime = 31;
    	int result = 1;
	result = prime * result + this.linha + this.coluna;
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
        Posicao other = (Posicao) obj;
        if (this.linha != other.linha){
            return false;
        }else if (this.coluna != other.coluna){
            return false;
        }
        return true;
    }
}
