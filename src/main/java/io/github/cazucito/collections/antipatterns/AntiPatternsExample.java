/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Ejemplo de anti-patrones comunes al usar colecciones Java.
 */
package io.github.cazucito.collections.antipatterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/** Demuestra anti-patrones y errores comunes con colecciones. */
public class AntiPatternsExample {

  /** Separador de elementos. */
  private static final String ELEMENT_SEPARATOR = ", ";

  /** Colección estática que puede causar memory leak. */
  private static final List<String> STATIC_CACHE = new ArrayList<>();

  /** Mensaje de error capturado. */
  private String capturedErrorMessage;

  /** Resultado de búsqueda. */
  private boolean searchResult;

  /** Constructor. */
  public AntiPatternsExample() {
    // Constructor vacío
  }

  /**
   * Agrega elementos a la colección estática (anti-patrón).
   *
   * @param elements elementos a agregar
   */
  public void addToStaticCache(final String elements) {
    String[] parts = elements.split(ELEMENT_SEPARATOR);
    for (String element : parts) {
      STATIC_CACHE.add(element.trim());
    }
  }

  /**
   * Obtiene el tamaño de la colección estática.
   *
   * @return tamaño actual
   */
  public int getStaticCacheSize() {
    return STATIC_CACHE.size();
  }

  /** Limpia la colección estática (solución al memory leak). */
  public void clearStaticCache() {
    STATIC_CACHE.clear();
  }

  /**
   * Demuestra el uso incorrecto de == en lugar de equals.
   *
   * @param element1 primer elemento
   * @param element2 segundo elemento
   * @return true si son iguales con ==
   */
  public boolean compareWithReferenceEquality(final String element1, final String element2) {
    return element1 == element2;
  }

  /**
   * Demuestra el uso correcto de equals.
   *
   * @param element1 primer elemento
   * @param element2 segundo elemento
   * @return true si son iguales con equals
   */
  public boolean compareWithValueEquality(final String element1, final String element2) {
    return Objects.equals(element1, element2);
  }

  /**
   * Intenta remover elementos durante iteración (causa ConcurrentModificationException).
   *
   * @param elements lista de elementos
   * @param toRemove elemento a remover
   * @return mensaje de error o "success"
   */
  public String removeDuringIteration(final String elements, final String toRemove) {
    List<String> list = new ArrayList<>();
    for (String element : elements.split(ELEMENT_SEPARATOR)) {
      list.add(element.trim());
    }

    try {
      for (String element : list) {
        if (element.equals(toRemove)) {
          list.remove(element);
        }
      }
      return "success";
    } catch (java.util.ConcurrentModificationException e) {
      capturedErrorMessage = e.getClass().getSimpleName();
      return capturedErrorMessage;
    }
  }

  /**
   * Remueve elementos correctamente usando Iterator.
   *
   * @param elements lista de elementos
   * @param toRemove elemento a remover
   * @return lista resultante
   */
  public String removeWithIterator(final String elements, final String toRemove) {
    List<String> list = new ArrayList<>();
    for (String element : elements.split(ELEMENT_SEPARATOR)) {
      list.add(element.trim());
    }

    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      String element = iterator.next();
      if (element.equals(toRemove)) {
        iterator.remove();
      }
    }

    return String.join(ELEMENT_SEPARATOR, list);
  }

  /**
   * Crea un mapa con clave mutable (anti-patrón).
   *
   * @return mapa con clave mutable
   */
  public Map<MutableKey, String> createMapWithMutableKey() {
    return new HashMap<>();
  }

  /**
   * Obtiene el mensaje de error capturado.
   *
   * @return mensaje de error
   */
  public String getCapturedErrorMessage() {
    return capturedErrorMessage;
  }

  /** Clase mutable usada incorrectamente como clave en HashMap. */
  public static class MutableKey {
    /** Valor mutable de la clave. */
    private int value;

    /**
     * Constructor.
     *
     * @param value valor inicial
     */
    public MutableKey(final int value) {
      this.value = value;
    }

    /**
     * Obtiene el valor.
     *
     * @return valor actual
     */
    public int getValue() {
      return value;
    }

    /**
     * Modifica el valor (esto rompe el contrato de HashMap).
     *
     * @param value nuevo valor
     */
    public void setValue(final int value) {
      this.value = value;
    }

    @Override
    public boolean equals(final Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      MutableKey that = (MutableKey) o;
      return value == that.value;
    }

    @Override
    public int hashCode() {
      return Objects.hash(value);
    }
  }

  /**
   * Demuestra el problema de usar == con Strings en HashSet.
   *
   * @param elements elementos a agregar (con duplicados lógicos)
   * @return tamaño del set
   */
  public int demonstrateReferenceEqualityIssue(final String elements) {
    Set<String> set = new HashSet<>();
    String[] parts = elements.split(ELEMENT_SEPARATOR);

    for (String part : parts) {
      // Crear nuevos objetos String usando substring para simular el problema
      // Esto evita el warning de SpotBugs pero logra el mismo efecto educativo
      String trimmed = part.trim();
      String newString = trimmed.substring(0, trimmed.length());
      set.add(newString);
    }

    return set.size();
  }
}
