import controller.CampeonatoController;
import lombok.Setter;
import model.Carrera;
import model.Coche;

import java.util.ArrayList;
import java.util.Scanner;

@Setter

public class SimuladorCampeonato {

    static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        ArrayList<Coche> participantes = new ArrayList<>();
        ArrayList<Carrera> carreras = new ArrayList<>();
        int nCoches= 0;
        String modelo;
        String marca;
        int numeroCarrera;
        double kmObjetivo = 0;

        do {
            System.out.println("Introduce el número de coches: ");

            if (!scn.hasNextInt()){
                System.out.println("Inválido, vuelve a introducir un número de coches");
                scn.next();
                nCoches=-1;
                continue;
            }
            nCoches= scn.nextInt();

            if (nCoches<=0){
                System.out.println("El número de coches debe ser mayor que 0");
            }

        } while (nCoches<=0);

        scn.nextLine();

        for (int i = 1; i <= nCoches; i++) {
            System.out.println("Introduce la marca del coche nº "+i);
            marca = scn.nextLine();
            System.out.println("Introduce el modelo del coche nº "+i);
            modelo=scn.nextLine();

            participantes.add(new Coche(marca,modelo));
        }

        do {
            System.out.println("¿Cuantas carreras conformarán el campeonato?");

            if (!scn.hasNextInt()){
                System.out.println("Inválido, vuelve a introducir un número de carreras");
                scn.next();
                numeroCarrera=-1;
                continue;
            }
            numeroCarrera=scn.nextInt();

            if (numeroCarrera<=0){
                System.out.println("El número de carreras debe ser mayor que 0");
            }

        }while (numeroCarrera<=0);

        scn.nextLine();

            for (int i = 1; i <= numeroCarrera; i++) {

                do {
                System.out.println("De cuantos kilómetros será la carrera " + i);

                //Añadimos validador de datos
                    if (!scn.hasNextDouble()){
                        System.out.println("Inválido, vuelve a introducir un número de kilómetros");
                        scn.next();
                        kmObjetivo=-1;
                        continue;
                    }

                kmObjetivo = scn.nextDouble();

                    if (kmObjetivo <= 0) {
                    System.out.println("El número de kilómetros debe ser mayor que 0");
                    }

                } while(kmObjetivo<=0);

                Carrera carrera = new Carrera(participantes, kmObjetivo, i);
                carreras.add(carrera);
        }

        CampeonatoController campeonatoController = new CampeonatoController(participantes);
        campeonatoController.ejecutarCampeonato(carreras);
    }
}
