package utiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
/**
 * Clase Menu
 * @author Javier Epifanio
 */

public class Menu {
  /**
   * titulo del menu
   */
  private String titulo;
  /**
   * opciones del menu
   */
  List<String> opciones;

  public Menu(String titulo, String... opciones) {
    
    this.titulo = titulo;
    this.opciones = new ArrayList<>(Arrays.asList(opciones));
  }
/**
 * elige una opcion del menu
 * @return numero de la opcion
 */
  public int elegir(Scanner s) {
    
    System.out.println(this.titulo);
    System.out.println("-".repeat(this.titulo.length()) +"\n");
    
    for (int i = 0; i < this.opciones.size(); i++) {
      System.out.println((i+1) + ". " + this.opciones.get(i));
    }
    System.out.print("\nIntroduce una opcion: ");
    

      int opcion = s.nextInt();

      
      while (opcion <= 0 || opcion > this.opciones.size()) {
        System.out.print("Opcion incorrecta, introduzca otra: ");
        opcion = s.nextInt();
      
      
      return opcion;
    }
      return opcion;
  }
/**
 * toString del menu
 */
  @Override
  public String toString() {
    return "Menu [titulo=" + titulo + ", opciones=" + opciones + "]";
  }

}
