package Reconhecedor;


public class Maquina {
    
    
    private final int V = -1; /*representa verdadeiro na tabela de transição, ou seja, quando não tem mais nenhum estado e a palavra for reconhecida*/
    private final int F = -2; /*representa falso na tabela de transição, ou seja, quando não tem mais nenhum estado na tabela de transição e a palavra não for reconhecida*/
    private final char B = ' ';/*representa o caracter branco*/    
    private final char alfabeto [] = {B,'i','e','y','n','t','g','r','x','p'}; /*Alfabeto pertencente a gramática*/ 
    
    private final int tabelaTransicao[][] ={
      /*0*/  { F,  1,  F,  F,  F, 10,  F,  F,  9,  F},
      /*1*/  { V,  F,  F,  F,  3,  F,  F,  F,  2,  F},
      /*2*/  { V,  F,  F,  F,  F,  F,  F,  F,  F,  F},
      /*3*/  { F,  F,  F,  F,  F,  4,  F,  F,  F,  F},
      /*4*/  { V,  F,  5,  F,  F,  F,  F,  F,  F,  F},
      /*5*/  { F,  F,  F,  F,  F,  F,  6,  F,  F,  F},
      /*6*/  { F,  F,  7,  F,  F,  F,  F,  F,  F,  F},
      /*7*/  { F,  F,  F,  F,  F,  F,  F,  8,  F,  F},
      /*8*/  { V,  F,  F,  F,  F,  F,  F,  F,  F,  F},
      /*9*/  { V,  2,  F,  F,  F,  F,  F,  F,  F,  F},
     /*10*/  { F,  F,  F, 11,  F,  F,  F,  F,  F,  F},
     /*11*/  { F,  F,  F,  F,  F,  F,  F,  F,  F, 12},
     /*12*/  { F,  F, 13,  F,  F,  F,  F,  F,  F,  F},
     /*13*/  { V,  F,  F,  F,  F,  F,  F,  F,  F,  F}
     
    }; 
    
    private String fitaDeEntrada;
    
    
    
    
    public Maquina(){};
    
    private int getIndiceAlfabeto(char caracter){/*retorna o indice que o simbolo encontra-se no alfabeto, para ser utilizado como coluna na tabela de transição*/

        for(int i = 0; i < alfabeto.length; i++){
            
            if(alfabeto[i] == caracter){
                return i; 
            }
        }
        return -1;
    }
    
    public void setFitaDeEntrada( String palavra){
    
        fitaDeEntrada = palavra;
        fitaDeEntrada = fitaDeEntrada + " ";
    }
    
    public String getFitaDeEntrada(){return fitaDeEntrada;}
    
    
    public void verificaFitaDeEntrada(){
    
        String fita = getFitaDeEntrada();
        int cabecaFita;
        int indiceCaracterAlfabeto;
        int estado = 0;
        int ultimoEstado;
        
        for(cabecaFita = 0; cabecaFita < fita.length(); cabecaFita++){
        
            indiceCaracterAlfabeto = getIndiceAlfabeto(fita.charAt(cabecaFita));
            
            if(indiceCaracterAlfabeto < 0){
            
                System.out.printf("\nSimbolo (%c) lido na posicao (%d) nao pertence ao Alfabeto. Palavra nao pertence a linguagem\n", fita.charAt(cabecaFita), cabecaFita);
                break;
            }
            
            ultimoEstado = estado;
            estado = tabelaTransicao[estado][indiceCaracterAlfabeto];
            
            if(estado < 0){
                
                if(estado == F){
                
                    System.out.printf("\nErro de transicao. Palavra nao pertence a linguagem\n");
                }
                else{
                    System.out.printf("\nPalavra pertence a linguagem, ultimo estado de transicao %d\n",ultimoEstado);
                }
                break;
            }
            
        
        }
        
    }
}
