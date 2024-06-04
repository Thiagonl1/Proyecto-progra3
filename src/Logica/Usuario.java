package Logica;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Usuario implements Juego{
    private int estrellas;
    // private int eleccionJuego; // Se cambiara en lo que descubra como hacer que elijan de alguna manera por api
    private String apodo;
    private ArrayList<Carta> cartas;

    public Usuario(){}

    public Usuario(int estrellas, String apodo, ArrayList<Carta> cartas) {
        this.estrellas = estrellas;
        this.apodo = apodo;
        this.cartas = cartas;
    }

    public Usuario(int estrellas, int eleccionJuego, String apodo, Carta[] cartas) {
    }

    public int getEstrellas() {
        return estrellas;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }

    public void setCartas(ArrayList<Carta> cartas) {
        this.cartas = cartas;
    }

    // verificar, verifica si se gana, empata o pierde el usuario y/o ia. modificando las estrellas correspondientes.

    public void verificar(Usuario ia, int desicionPlayer, int desicionIA){
        if(ia.cartas.get(desicionIA).getTipo().equals(this.cartas.get(desicionPlayer).getTipo())){
            System.out.println("Se empato");
        }else if(this.cartas.get(desicionPlayer).getTipo().equals("Piedra") || ia.cartas.get(desicionIA).getTipo().equals("Piedra")){
            if(ia.cartas.get(desicionIA).getTipo().equals("Papel")){
                this.setEstrellas(this.getEstrellas()-1);
                ia.setEstrellas(ia.getEstrellas()+1);
                System.out.println("Perdiste");
            }else if(this.cartas.get(desicionPlayer).getTipo().equals("Papel")){
                System.out.println("Ganaste");
                this.setEstrellas(this.getEstrellas()+1);
                ia.setEstrellas(ia.getEstrellas()-1);
            }
        }else if(ia.cartas.get(desicionIA).getTipo().equals("Papel") || this.cartas.get(desicionPlayer).getTipo().equals("Papel")){
            if(ia.cartas.get(desicionIA).getTipo().equals("Tijera")){
                this.setEstrellas(this.getEstrellas()-1);
                ia.setEstrellas(ia.getEstrellas()+1);
                System.out.println("Perdiste");
            }else if(this.cartas.get(desicionPlayer).getTipo().equals("Tijera")){
                System.out.println("Ganaste");
                this.setEstrellas(this.getEstrellas()+1);
                ia.setEstrellas(ia.getEstrellas()-1);
            }
        }else if(this.cartas.get(desicionPlayer).getTipo().equals("Tijera") || ia.cartas.get(desicionIA).getTipo().equals("Tijera")){
            if(ia.cartas.get(desicionIA).getTipo().equals("Piedra")){
                this.setEstrellas(this.getEstrellas()-1);
                ia.setEstrellas(ia.getEstrellas()+1);
                System.out.println("Perdiste");
            }else if(this.cartas.get(desicionPlayer).getTipo().equals("Piedra")){
                System.out.println("Ganaste");
                this.setEstrellas(this.getEstrellas()+1);
                ia.setEstrellas(ia.getEstrellas()-1);
            }
        }
    }


    public void juegoPreliminar(Usuario ia){
        Scanner scan = new Scanner(System.in);
        // Muestro las cartas primero
        for(int i = 0 ; i < this.cartas.size() ; i++){
            System.out.println(i+")"+this.cartas.get(i).getTipo());
        }
        // agrego desicion
        int desicion = scan.nextInt();
        //Implementar interfaz visual y no consola
        do{
            if(desicion > this.cartas.size() || desicion < 0){
                System.out.println("Elija una carta valida");
                for(int i = 0 ; i < this.cartas.size() ; i++){
                    System.out.println(i+")"+this.cartas.get(i).getTipo());
                }
                desicion = scan.nextInt();
            }else{
                juego(desicion, ia);
                this.cartas.remove(desicion);
            }

        }while(desicion > this.cartas.size() || desicion < 0);
    }


    @Override
    public void juego(int desicion, Usuario ia){
        Random random = new Random();
        int eleccionIA = random.nextInt(ia.cartas.size());
        // implementar win/loose
        System.out.println("El jugador ("+this.apodo+") eligio "+this.cartas.get(desicion).getTipo()+"\nLa ia eligio "+ ia.cartas.get(eleccionIA).getTipo());
        verificar(ia, desicion, eleccionIA);

        //
        ia.cartas.remove(eleccionIA);
    }

    @Override
    public ArrayList<Carta> inicializarCartas(){
        if(this.cartas == null) {
            this.cartas = new ArrayList<Carta>();
            this.cartas.add(new Carta("Piedra"));
            this.cartas.add(new Carta("Papel"));
            this.cartas.add(new Carta("Tijera"));
        }
        return this.cartas;
    }


}
