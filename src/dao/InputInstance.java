package dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import entity.Tabuleiro;
import static java.lang.System.exit;

public class InputInstance {
	
	public static Tabuleiro getInstance(String file) {
		
		Tabuleiro tabuleiro = null;
	
		InputStream is;
		InputStreamReader isr;
		BufferedReader br;
		
		try {
			
			is = new FileInputStream(file);
			isr = new InputStreamReader(is, StandardCharsets.UTF_8);
			br = new BufferedReader(isr);
                        int tamTabuleiro = 0;
			String line;
                        // Lê a primeira linha para definir o tamanha do tabuleiro
                        line = br.readLine();
                        try{
                            line.trim();
                            tamTabuleiro = Integer.parseInt(line);
                        }catch(Exception e){
                            System.out.println("Não foi possivel determinar o tamanho do tabuleiro! Por favor garanta que o valor seja: 3x3, 4x4 ou 5x5 e que a primeira linha do arquivo especifique o tamanho");
                            exit(0);
                        }
                        System.out.println(line);
                        // Coloca os valores das peças no tabuleiro
			int[][] pecas = new int[tamTabuleiro][tamTabuleiro];
			for(int i=0; i<tamTabuleiro; i++) {
				line = br.readLine();
				String[] valores = line.split(" ");
				for(int j=0; j<tamTabuleiro; j++) {
					pecas[i][j] = Integer.parseInt(valores[j]);
				}
			}
			tabuleiro = new Tabuleiro(tamTabuleiro, pecas);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return tabuleiro;
		
		
	}

}
