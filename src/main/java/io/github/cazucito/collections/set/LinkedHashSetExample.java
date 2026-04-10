/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar el uso de LinkedHashSet.
 */
package io.github.cazucito.collections.set;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Ejemplifica el uso de LinkedHashSet para almacenar elementos únicos con orden de inserción.
 *
 * <p>Demuestra operaciones básicas de LinkedHashSet, destacando el mantenimiento del orden de
 * inserción y la eficiencia de acceso O(1) heredada de HashSet.
 */
public class LinkedHashSetExample {

  /** Separador para elementos en toString. */
  private static final String ELEMENT_SEPARATOR = ", ";

  /** LinkedHashSet interno para almacenar elementos ordenados. */
  private final Set<String> linkedHashSet;

  /** Constructor que inicializa el LinkedHashSet vacío. */
  public LinkedHashSetExample() {
    this.linkedHashSet = new LinkedHashSet<>();
  }

  /**
   * Agrega un elemento al linkedhashset.
   *
   * @param element el elemento a agregar (puede ser null)
   * @return true si se agregó exitosamente, false si ya existía
   */
  public boolean addElement(final String element) {
    return linkedHashSet.add(element);
  }

  /**
   * Elimina un elemento del linkedhashset.
   *
   * @param element el elemento a eliminar
   * @return true si se eliminó exitosamente
   */
  public boolean removeElement(final String element) {
    return linkedHashSet.remove(element);
  }

  /**
   * Obtiene el tamaño actual del linkedhashset.
   *
   * @return número de elementos
   */
  public int size() {
    return linkedHashSet.size();
  }

  /**
   * Verifica si el linkedhashset está vacío.
   *
   * @return true si no contiene elementos
   */
  public boolean isEmpty() {
    return linkedHashSet.isEmpty();
  }

  /** Elimina todos los elementos del linkedhashset. */
  public void clear() {
    linkedHashSet.clear();
  }

  /**
   * Verifica si un elemento existe en el linkedhashset.
   *
   * @param element el elemento a buscar
   * @return true si existe
   */
  public boolean contains(final String element) {
    return linkedHashSet.contains(element);
  }

  /**
   * Verifica si el linkedhashset contiene null.
   *
   * @return true si contiene null
   */
  public boolean containsNull() {
    return linkedHashSet.contains(null);
  }

  /**
   * Obtiene todos los elementos en orden de inserción.
   *
   * @return string con elementos separados por coma
   */
  public String getOrderedElements() {
    StringBuilder sb = new StringBuilder();
    for (String element : linkedHashSet) {
      if (sb.length() > 0) {
        sb.append(ELEMENT_SEPARATOR);
      }
      sb.append(element);
    }
    return sb.toString();
  }
}
