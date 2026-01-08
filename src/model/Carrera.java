package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@Getter
@NoArgsConstructor

public class Carrera {

    // Creamos los atributos de una carrera
    private ArrayList<Coche> participantes;
    private double kmObjetivo;
    private int numeroCarrera;


    // Creamos el constructor
    public Carrera (ArrayList<Coche> participantes, double kmObjetivo, int numeroCarrera){
        this.participantes=participantes;
        this.kmObjetivo=kmObjetivo;
        this.numeroCarrera=numeroCarrera;
    }

}
