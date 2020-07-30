package main;

import controller.Controller;

import java.util.Scanner;

public class Main {
    //no me borre el comentario

    //yo borro lo que me de la gana

    //Otro comentario que me pidio Tray
    private static Scanner scan = new Scanner(System.in);
    public static Controller c = new Controller();

    public static void main(String[] args) {
        int option = 0;

        do {
            option = showMainMenu();
            processFunction(option);
        } while (option !=5 );

    }

    private static int showMainMenu() {

        printer("Menú principal");
        printer("Seleccione una opción");
        printer("1. Lanzar dados");
        printer("2. Invocar tropas");
        printer("3. Realizar movimientos");
        printer("4. Realizar ataques");
        printer("5. Salir");

        return scan.nextInt();
    }

    public static void processFunction(int option ) {
        switch (option) {
            case 1:
              c.throwDice();
                break;
            case 2:
               summonTroopsMenu();
                break;
            case 3:
              //TO DO Menu movement
                break;
            case 4:
                //TO DO Menu attacks
                break;
            case 5:
                printer("Gracias por usar el sistema");
                break;
            default:
                printer("Opcion invalida");
                break;
        }
    }

    public static void summonTroopsMenu() {
        printer(c.countInvocationDices());
        printer("Seleccione el tipo de unidad a invocar:");
        printer("1. Infantería");
        printer("2. Artillería");
        printer("3. Tanque");
        int option = scan.nextInt();

        c.summonUnitMain(option);
    }

    public static void printer(String pData) {
        System.out.println(pData);
    }

}
