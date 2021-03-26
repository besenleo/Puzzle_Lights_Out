package entity;

import solver.EspacoDeEstados;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Estado {
	
	Tabuleiro tabuleiro;
	List<Posicao> acoes;
	
	public Estado(Tabuleiro aTabuleiro) {
		this.tabuleiro = aTabuleiro;
		this.acoes = new LinkedList<>();
	}
	
	public Estado(Tabuleiro aTabuleiro, List<Posicao> aAcoes) {
		this(aTabuleiro);
		this.acoes = aAcoes;
	}
        
        public Tabuleiro getTabuleiro() {
            return this.tabuleiro;
	}
        
        public int getNivel() {
            return this.acoes.size();
	}
	
	public boolean isObjetivo() {
            Estado objetivo = EspacoDeEstados.geraObjetivo(this.tabuleiro.tam);
            if(this.equals(objetivo))
            	return true;
            return false;
		
	}
	
	public void fazerAcao(Posicao p) {
		this.acoes.add(p);
		this.tabuleiro.fazerAcao(p);
	}
	
	public Collection<Estado> geraFilhos(){
		
            Collection<Estado> filhos = new ArrayList<>();
            Collection<Posicao> todasLuzes = this.tabuleiro.todasLuzesAcesas();
                
            for(Posicao p: todasLuzes) {
                Estado filho = this.deepCopy();
                filho.fazerAcao(p);
                filhos.add(filho);
            }
            
            return filhos;
	}
	
	public Estado deepCopy() {
            List<Posicao> novasAcoes = new LinkedList<>(this.acoes);
            return new Estado(this.tabuleiro.deepCopy(), novasAcoes);
	}
	
	
	@Override
	public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((tabuleiro == null) ? 0 : tabuleiro.hashCode());
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
            Estado other = (Estado) obj;
            if (tabuleiro == null) {
		if (other.tabuleiro != null)
                    return false;
		} else if (!tabuleiro.equals(other.tabuleiro))
                    return false;
            return true;
	}

	@Override
	public String toString() {
            String res = "\n";
            res += "nivel: " + this.acoes.size() + "\n";
            res += this.tabuleiro + "\n";
            for(Posicao acao: this.acoes) {
                res += acao + ", ";
            }
            res += "\n";
		
            return res;
	}

}
