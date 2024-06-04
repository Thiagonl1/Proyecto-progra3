package Logica;

import Visual.Pantalla;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Pantalla pantalla = new Pantalla();
        pantalla.setVisible(true);
        pantalla.setSize(300,300);

        // INICIO AL USUARIO
        Usuario player = new Usuario();
        player.setCartas(player.inicializarCartas());
        player.setEstrellas(3);
        System.out.println("Nombre del Jugador");
        player.setApodo(scan.nextLine());

        // INICIO LAS IAS

        Usuario ia1 = new Usuario();
        ia1.setCartas(ia1.inicializarCartas());
        ia1.setEstrellas(3);
        ia1.setApodo("sucucho");

        while(player.getCartas().size() != 0){
            // Tratar de implementar algo mas visual que una consola
            // Tratar de hacer que pase el tiempo y las IA's interaccionen entre si
            System.out.println("Elige un oponente \n1)"+ ia1.getApodo());

            //eleccion de oponente
            int opcion =(scan.nextInt());
            switch (opcion){
                case 1:{
                    System.out.println(" ---Cartas disponibles actualmente ---");
                    System.out.println("--------------------------------------");
                    player.juegoPreliminar(ia1);
                }
            }
        }

    }
}