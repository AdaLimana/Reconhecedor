package Reconhecedor;


import java.util.Scanner;

public class Principal {
    
    public static void main(String[]args) {
        
        Maquina m;
        m = new Maquina();
        String palavra;
        Scanner in = new Scanner(System.in);
        
        System.out.printf("Digite uma palavra/simbolo para verificar\n\t\tOU\nDidite 0 para sair do programa\n");
       
        while(true){
            palavra = in.nextLine();
            
            if('0' == palavra.charAt(0)){
                break;
            }
        
            m.setFitaDeEntrada(palavra);
            m.verificaFitaDeEntrada();
        }
    }
    
}
