package controller;

import lombok.Getter;
import lombok.Setter;

import model.Carrera;
import model.Coche;

import java.util.ArrayList;
import java.util.Comparator;

@Setter
@Getter


public class CampeonatoController {
    private CarreraController carreraController = new CarreraController();
    private ArrayList<Coche> coches;

    public CampeonatoController (ArrayList<Coche> coches){
        this.coches=coches;
    }

    private void mostrarClasificacion() {
        coches.sort(Comparator.comparingInt(Coche::getPuntos).reversed());

        int posicion = 1;
        for (Coche coche : coches) {
            System.out.println(posicion + "º - " + coche.getModelo() + " - " + coche.getPuntos() + " puntos");
            posicion++;
        }
    }

    public void ejecutarCampeonato(ArrayList<Carrera> carreras) {
        for (Carrera carrera : carreras) {

            System.out.println("\n===CARRERA " + carrera.getNumeroCarrera() + " ===");
            carreraController.simularCarrera(carrera);

            System.out.println("\n=== CLASIFICACIÓN PROVISIONAL ===");
            mostrarClasificacion();
        }
        System.out.println("\n=== CLASIFICACIÓN FINAL ===");
        mostrarClasificacion();
    }
}
