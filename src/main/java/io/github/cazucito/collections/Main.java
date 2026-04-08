/**
 * Copyright 2024 cazucito
 * SPDX-License-Identifier: Apache-2.0
 *
 * <p>Ejemplos del API Java Collections con enfoque BDD/TDD
 *
 * @author cazucito
 * @version 0.1.0-SNAPSHOT
 */

package io.github.cazucito.collections;

/**
 * Clase principal del proyecto.
 *
 * <p>Proporciona información básica sobre el proyecto.
 */
public final class Main {

  /** Constructor privado para prevenir instanciación. */
  private Main() {
    throw new AssertionError("Utility class");
  }

  /**
   * Punto de entrada principal del programa.
   *
   * @param args argumentos de línea de comandos
   */
  public static void main(final String[] args) {
    System.out.println("Java Collections Examples");
    System.out.println("Ejecutar: mvn test");
  }
}
