package model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor

// Creamos los atributos de un coche
public class Coche {

    private String marca;
    private String modelo;
    private double kmRecorridos;
    private int puntos;

    // Creamos el constructor
    public Coche(String marca, String modelo){
        this.marca=marca;
        this.modelo=modelo;
    }

    // Creamos los métodos del coche
    public void sumarKm(double km) {
        kmRecorridos += km;
    }

    public void resetearKm(){
        kmRecorridos=0;
    }

    public void  sumarPuntos(int puntos){
        this.puntos+= puntos;
    }
}

