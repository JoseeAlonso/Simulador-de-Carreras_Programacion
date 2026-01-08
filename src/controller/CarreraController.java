package controller;

import lombok.Getter;
import lombok.Setter;
import model.Carrera;
import model.Coche;

import java.util.Comparator;
import java.util.Random;

@Getter
@Setter

public class CarreraController {

    Random random = new Random();


    public void simularCarrera(Carrera carrera) {
        boolean carreraTerminada = false;

        for (Coche coche : carrera.getParticipantes()) {
            coche.resetearKm();
        }

        while (!carreraTerminada) {

            for (Coche coche : carrera.getParticipantes()) {
                double kmAleatorio = 20 + random.nextDouble() * 31;
                coche.sumarKm(kmAleatorio);
            }


            for (Coche coche : carrera.getParticipantes()) {
                if (coche.getKmRecorridos() >= carrera.getKmObjetivo()) {
                    carreraTerminada=true;
                }
            }
        }

        // Ordenar el ArrayList de mayor a menor
        carrera.getParticipantes().sort(Comparator.comparingDouble(Coche::getKmRecorridos).reversed());

        // Asignación de puntos según la posición en la carrera
        for (int i = 0; i < carrera.getParticipantes().size(); i++) {
            if (i==0){
                carrera.getParticipantes().get(i).sumarPuntos(10);
            }
            if (i==1){
                carrera.getParticipantes().get(i).sumarPuntos(8);
            }
            if (i==2){
                carrera.getParticipantes().get(i).sumarPuntos(6);
            }
        }

        System.out.println("El orden de los participantes es: ");
        for (int i = 0; i < carrera.getParticipantes().size(); i++) {
            System.out.println(carrera.getParticipantes().get(i).getModelo()+" "+String.format("%.2f",carrera.getParticipantes().get(i).getKmRecorridos())+" km "+carrera.getParticipantes().get(i).getPuntos()+" puntos");
        }
    }

}






