/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 *
 * @author Mauricio
 */
public class DepositoProductos {

    private static TreeSet<Producto> productos = new TreeSet<>();

    public static boolean altaProducto(Producto p) {
        return productos.add(p);
    }

    public static boolean bajaProducto(int codigo) {
        return productos.removeIf(p -> p.getCodigo() == codigo);
    }

    public static boolean modificarProducto(Producto updated) {
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            if (p.getCodigo() == updated.getCodigo()) {
                it.remove();
                productos.add(updated);
                return true;
            }
        }
        return false;
    }

    public static Producto buscarPorCodigo(int codigo) {
        for (Producto p : productos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

    public static List<Producto> buscarPorNombre(String texto) {
        String t = texto.toLowerCase();
        return productos.stream()
                .filter(p -> p.getDescripcion().toLowerCase().contains(t))
                .collect(Collectors.toList());
    }

    public static List<Producto> buscarPorRubro(String rubro) {
        return productos.stream()
                .filter(p -> p.getRubro().equalsIgnoreCase(rubro))
                .collect(Collectors.toList());
    }

    public static List<Producto> buscarPorPrecio(double min, double max) {
        return productos.stream()
                .filter(p -> p.getPrecio() >= min && p.getPrecio() <= max)
                .collect(Collectors.toList());
    }

    public static List<Producto> listarTodos() {
        return new ArrayList<>(productos);
    }
}
