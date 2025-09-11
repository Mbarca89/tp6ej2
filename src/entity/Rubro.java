/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */
public class Rubro {
    private static final ArrayList<String> rubros = new ArrayList<>();

    static {
        rubros.add("Seleccione...");
        rubros.add("COMESTIBLE");
        rubros.add("LIMPIEZA");
        rubros.add("PERFUMERIA");        
    }

    public static ArrayList<String> getRubros() {
        return rubros;
    }

    public static boolean isValid(String rubro) {
        return rubros.contains(rubro.trim().toUpperCase());
    }
}
