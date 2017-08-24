
package practica1_201314388_buscaminas;

import java.util.Random;
import java.util.Scanner;


public class ModoDeJuego {
    private String[][] matriz_vacia ;
    private String[][] Matriz_Solucion ;
    private int tamañoFila,tamañoColumna;
    private int PosicionFila,  PosicionColumna;
    private int NumerodeMinas;
    private Scanner sc;
    
      //Constructor de la Clase
    public ModoDeJuego(int Nivel){
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        //nivel Facil
        if(Nivel==1)
        {
            this.tamañoFila=4;
            this.tamañoColumna=4;
            this.NumerodeMinas = 4;
            System.out.println("------------------------------------------------");
            System.out.println("                Nivel Facil                     ");
        
         //nivel Intermedio   
        }else if(Nivel==2)
        {
            this.tamañoFila = 6;
            this.tamañoColumna = 6;
            this.NumerodeMinas = 8;
            System.out.println("------------------------------------------------");
            System.out.println("                Nivel Intermedio                ");
        //nivel Dificl    
        }else if(Nivel==3)
        {
            this.tamañoFila = 8;
            this.tamañoColumna = 8;
            this.NumerodeMinas = 12;
            System.out.println("------------------------------------------------");
            System.out.println("                Nivel Dificl                    ");
            
        }
        matriz_vacia = new String[tamañoFila][tamañoColumna];
        Matriz_Solucion = new String[tamañoFila][tamañoColumna];
        
        menu();
    }
    
    //    metodo en el cual imprime la matriz que vera el jugador 
    public void TablerodeJuego(){
        LLenar_Matriz_De_Juego();
        System.out.println("");
        Llenar_Matriz_De_Minas();
    }
    
    //    menu principal del juego en el cual realiza todas la funciones del juego
    public void menu(){
        sc = new Scanner(System.in);
        String letras="";
        String salir="";
        
        System.out.println("----------------------------------------------------");
        
        do{
            TablerodeJuego();
            
            do{
            MenudeJuego();
            letras = sc.nextLine();
            
            switch(letras){
                case "V":
                    voltear_posicion();
                    break;
                case "R":
                    break;
                case "RES":
                    Matriz_Solucion();
                    break;
                case "M":
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    menuprincipal mp = new menuprincipal();
                   
                    break;
                case "S":
                    letras="R";
                        salir="S";
                        break;
                    default:
                        System.out.println("opcion invalida");
                    break;
                } 
            }while(letras != "R");
        }while(salir != "S");
    }
    
    //    menu que que ve el jugador 
    public void MenudeJuego(){
        System.out.println("----------------------------------------------------");
        System.out.println("Voltear: V");
        System.out.println("Reiniciar: R");
        System.out.println("Salir: S");
        System.out.println("Menu Principal: M");
        System.out.println("Para ver Respuestas escriba: RES");
        System.out.println("");
        System.out.println("----------------------------------------------------");
        System.out.println("Ingrese Opcion: ");   
    }
    
     //metodo para la matriz del juego con X
    public void LLenar_Matriz_De_Juego(){
        for(int i=0;i<tamañoFila;i++){
            for(int j=0;j<tamañoColumna;j++){
                matriz_vacia[i][j]="X";
                System.out.print("["+matriz_vacia[i][j]+"]");
            }
            System.out.println("");
        }
    }
    
     //metodo en el cual se llena con minas la matriz Matriz_Solucion
    public void Llenar_Matriz_De_Minas(){
        int aux1,aux2,cont;
        Random ran1 = new Random();
        cont = 1;
        for (int i = 0; i < tamañoFila; i++) 
        {
            for (int j = 0; j < tamañoColumna; j++) 
            {
                Matriz_Solucion[i][j]="X";
            }
        }
        while (cont != NumerodeMinas+1) {

            aux1 = ran1.nextInt(tamañoFila);
            aux2 = ran1.nextInt(tamañoColumna);
            if (Matriz_Solucion[aux1][aux2] == "X") {
                Matriz_Solucion[aux1][aux2] = "*";
                cont++;
                    }     
        }
        for(int i=0;i < tamañoFila; i++)
        {
            for(int j = 0; j < tamañoColumna; j++)
            {
                if(Matriz_Solucion[i][j]=="X")
                {
                    this.PosicionFila = i;
                    this.PosicionColumna = j;
                    Obtener_Numeros_Alrededor_de_Minas(2);
                }
                
            }
            
        }
    }
    
    
    //muestra la matriz con las minas en forma aleatoreo 
    public void Matriz_Solucion(){
        String cadena="";
        for (int i = 0; i < tamañoFila; i++) {
            for (int j = 0; j < tamañoColumna; j++) {
                cadena = cadena+ "[" + Matriz_Solucion[i][j]+"]";
            }
            System.out.println(cadena);
            cadena = "";
        }
    }
    
    
    //metodo en el cual voltea las cartas y compara las posiciones en donde hay minas 
    //Y verifica si es gana o pierde el jugador
        public void voltear_posicion(){
            String dato;
            System.out.println("Ingrese Fila , Columna");
            sc = new Scanner(System.in);
            dato = sc.nextLine();
            setFilaColumna(dato);
            System.out.println("Desea Confirmar datos Presione: Y ");
            System.out.println("Desea Cambiar datos Presione: N");
            sc = new Scanner(System.in);
            dato = sc.nextLine();
            
            if(Matriz_Solucion[PosicionFila][PosicionColumna]=="*")
            {
                System.out.println("Perdiste");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                menuprincipal mp = new menuprincipal();
                
            }
            if(matriz_vacia[PosicionFila][PosicionColumna]!="X")
            {
                System.out.println("La Posicion ya Fue volteada");
                return;
            }
            
            if(dato.equals("Y")){
               if((PosicionFila<tamañoFila&&PosicionFila>-1)&&(PosicionColumna<tamañoColumna&&PosicionColumna>-1))
                {
                    Obtener_Numeros_Alrededor_de_Minas(1);
                    Abrir_Camino();
                    Mostrar_Matriz_de_Juego();
                    if(Victoria()){
                        System.out.println("");
                        System.out.println("Ganaste El Juego");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        menuprincipal meprin = new menuprincipal();
                    }
                    
                }else{
                    System.out.println("Posicion Fuera de Rango");
                }    
                 
            }
            else if(dato.equals("N")){
                Mostrar_Matriz_de_Juego();                
            }else
            {
                System.out.println("Opcion Invalida");
            }
        }
        
        // metodo en el cual capturamos las posiciones por comas, le damos valor a los indices de la matriz
        public void setFilaColumna(String filacolumnarec){
            String[] datos = filacolumnarec.split(",");
            this.PosicionColumna= Integer.parseInt(datos[1])-1;
            this.PosicionFila = Integer.parseInt(datos[0])-1;
        }
        
        //funcion entera en el cual recibe las filas, columnas, y el contador de minas para imprimir en la matriz 
        //solucion el numero de minas que hay alrededor de la posicion que recibe
        public int Contador_Minas_Alrededor(int filarec, int columnarec, int contminas){
         if((filarec<tamañoFila&&filarec>-1)&&(columnarec<tamañoColumna&&columnarec>-1))
         {
             if(Matriz_Solucion[filarec][columnarec]=="*")
             {
                contminas= contminas+1; 
             }
         }
            return contminas;   
        }
        
        //metodo en el cual muestra la matriz del juego
        public void Mostrar_Matriz_de_Juego(){
        String cadena="";
        for (int i = 0; i < tamañoFila; i++) {
            for (int j = 0; j < tamañoColumna; j++) {
                cadena = cadena+ "[" + matriz_vacia[i][j]+"]";
            }
            System.out.println(cadena);
            cadena = "";
        }
    }
        
         //metodo en el cual evalua todas la posiciones alrededor del posicion ingresada, y coloca la cantidad de minas alrededor
        public void Obtener_Numeros_Alrededor_de_Minas(int tipoMatriz)
        {
            int auxFila, auxColumna;
                int cont=0;
                    for(int i=PosicionFila-1;i<=PosicionFila+1;i++)
                    {
                        if(i!=PosicionFila)
                        {
                            auxFila = i;
                            auxColumna= PosicionColumna +1;
                            cont = Contador_Minas_Alrededor(auxFila, auxColumna, cont);
                            auxColumna= PosicionColumna -1;
                            cont = Contador_Minas_Alrededor(auxFila, auxColumna, cont);
                            auxColumna= PosicionColumna;
                            cont = Contador_Minas_Alrededor(auxFila, auxColumna, cont);
                        }
                        else if(i==PosicionFila)
                        {
                            auxFila = i;
                            auxColumna= PosicionColumna +1;
                            cont = Contador_Minas_Alrededor(auxFila, auxColumna, cont);
                            auxColumna= PosicionColumna -1;
                            cont = Contador_Minas_Alrededor(auxFila, auxColumna, cont);
                        }
                    }
                    
                    if(tipoMatriz==1)
                    {
                        matriz_vacia[PosicionFila][PosicionColumna]=Integer.toString(cont);
                    }else{
                        Matriz_Solucion[PosicionFila][PosicionColumna]=Integer.toString(cont);
                    }
                        
        }
        
        //Muestra los numeros si son minas o numeros y los voltea si son numeros
        public void Abrir_Camino()
        {
            if(Evaluar_Posicion(PosicionFila+1, PosicionColumna))
            {
                matriz_vacia[PosicionFila+1][PosicionColumna]=Matriz_Solucion[PosicionFila+1][PosicionColumna];
            }
            if(Evaluar_Posicion(PosicionFila-1, PosicionColumna))
            {
                matriz_vacia[PosicionFila-1][PosicionColumna]=Matriz_Solucion[PosicionFila-1][PosicionColumna];
            }
            if(Evaluar_Posicion(PosicionFila, PosicionColumna+1))
            {
                matriz_vacia[PosicionFila][PosicionColumna+1]=Matriz_Solucion[PosicionFila][PosicionColumna+1];
            }
            if(Evaluar_Posicion(PosicionFila, PosicionColumna-1))
            {
                matriz_vacia[PosicionFila][PosicionColumna-1]=Matriz_Solucion[PosicionFila][PosicionColumna-1];
            }
        }
        
        //Funcion en la cual evalua si hay un numero o una mina
        public boolean Evaluar_Posicion(int filarec,  int columnarec)
        {
           if((filarec<tamañoFila&&filarec>-1)&&(columnarec<tamañoColumna&&columnarec>-1)){
               
                if(Matriz_Solucion[filarec][columnarec]!="*")
            {  
              return true;
            }else{
              return false;
            }
           }
           return false;
        }
        
        //metodo de ganar en le cual se realiza la opcion de ganar
        public boolean Victoria()
        {
            boolean bandera=false;
            int contador=0;
            for(int i= 0; i<tamañoFila;i++)
            {
                for(int j =0; j<tamañoColumna;j++)
                {
                    if(!Matriz_Solucion[i][j].equals(matriz_vacia[i][j])){
                        contador= contador+1;
                    }
                }
            }
            if(contador == NumerodeMinas){
                return bandera = true;
            }
            return bandera;
        }
    

    
}
