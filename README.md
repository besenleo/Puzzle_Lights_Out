# Puzzle_Lights_Out

This project was developed as part of the semester grade for the Artificial Intelligence class on Computer Science graduation. Therefor all code and comments were written on Brazilian-Portuguese.

Segue abaixo uma breve descrição do espaço de estados do projeto:

# Espaço de Estados Lights Out

N = Dado um valor n entre 3 e 5, o conjunto de estados será todas as matrizes quadradas de tamanho n, apenas com combinações de valores 0 (que representam luzes apagas) ou 1 (que representam luzes ligadas).

A = Dado um estado e, gerar todos os estados, onde para cada quadrado selecionado a ação muda o estado das luzes adjacentes.

I = Qualquer matriz quadrada de tamanho 3x3, 4x4 ou 5x5, com n casas ligadas (representadas pelo valor 1) e n casas desligadas (representadas pelo valor 0).

DO = O conjunto de ações que resultam em uma matriz do mesmo tamanho da matriz de entrada, cujos valores são todos desligados (zero). Como a matriz exemplificada abaixo: 
'''
0 0 0
0 0 0
0 0 0
'''
