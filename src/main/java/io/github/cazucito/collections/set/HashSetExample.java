/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar el uso de Set.
 */
package io.github.cazucito.collections.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Ejemplifica el uso de HashSet para almacenar elementos únicos.
 *
 * <p>Demuestra operaciones básicas como agregar, eliminar y verificar elementos, destacando la
 * característica principal de HashSet: no permite duplicados.
 */
public class HashSetExample {

  /** Set interno para almacenar elementos de tipo String. */
  private final Set<String> elements;

  /** Constructor que inicializa el set vacío. */
  public HashSetExample() {
    this.elements = new HashSet<>();
  }

  /**
   * Agrega un elemento al set.
   *
   * <p>Si el elemento ya existe, no se agrega y se retorna false.
   *
   * @param element el elemento a agregar
   * @return true si se agregó, false si ya existía
   */
  public boolean addElement(final String element) {
    return elements.add(element);
  }

  /**
   * Elimina un elemento del set.
   *
   * @param element el elemento a eliminar
   * @return true si se eliminó, false si no existía
   */
  public boolean removeElement(final String element) {
    return elements.remove(element);
  }

  /**
   * Retorna el número de elementos en el set.
   *
   * @return cantidad de elementos únicos
   */
  public int size() {
    return elements.size();
  }

  /**
   * Verifica si el set está vacío.
   *
   * @return true si no tiene elementos
   */
  public boolean isEmpty() {
    return elements.isEmpty();
  }

  /**
   * Verifica si un elemento existe en el set.
   *
   * @param element el elemento a buscar
   * @return true si existe
   */
  public boolean contains(final String element) {
    return elements.contains(element);
  }

  /** Limpia todos los elementos del set. */
  public void clear() {
    elements.clear();
  }

  /**
   * Retorna una copia del set actual.
   *
   * @return set con los mismos elementos
   */
  public Set<String> getAllElements() {
    return new HashSet<>(elements);
  }
}
