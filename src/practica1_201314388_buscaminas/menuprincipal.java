
package practica1_201314388_buscaminas;

import java.util.Scanner;
import practica1_201314388_buscaminas.ModoDeJuego;


public class menuprincipal {
    private Scanner sc = new Scanner(System.in);
    private int num;
    public menuprincipal(){
        menup();
    }
    
    public void menup(){
        System.out.println("Randall Steve Loarca Dávila");
        System.out.println("201314388");
        System.out.println("IPC A Practica 1");
        System.out.println("Buscaminas en Consola");
        System.out.println("Presione Enter para Continuar");
        sc.nextLine();
        menudejuego();
        
    }
    
    public void menudejuego(){
        System.out.println("----------------------------------------------------");
        System.out.println("Buscaminas en Consola");
        System.out.println("1. Principiante");
        System.out.println("2. Intermedio");
        System.out.println("3. Experto");
        System.out.println("4. Salir");
        System.out.println("");
        System.out.println("Ingrese Opción");
        num = sc.nextInt();
        System.out.println("----------------------------------------------------");
        switch(num){
            case 1:
                ModoDeJuego facil = new ModoDeJuego(1);
            break;
            case 2:
                ModoDeJuego intermedio = new ModoDeJuego(2);
            break;
            case 3:
                ModoDeJuego difil = new ModoDeJuego(3);
            break;
            case 4:
            default:
            break;
        }
    }
    
}

