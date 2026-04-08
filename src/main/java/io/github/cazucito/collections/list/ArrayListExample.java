/**
 * Copyright 2024 cazucito
 * SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar el uso de List.
 */
package io.github.cazucito.collections.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Ejemplifica el uso de ArrayList para almacenar y manipular elementos.
 *
 * <p>Demuestra operaciones básicas como agregar, eliminar, acceder y buscar
 * elementos en una lista.
 */
public class ArrayListExample {

  /** Lista interna para almacenar elementos de tipo String. */
  private final List<String> elements;

  /** Constructor que inicializa la lista vacía. */
  public ArrayListExample() {
    this.elements = new ArrayList<>();
  }

  /**
   * Agrega un elemento a la lista.
   *
   * @param element el elemento a agregar
   * @return true si se agregó correctamente
   */
  public boolean addElement(final String element) {
    return elements.add(element);
  }

  /**
   * Agrega un elemento solo si no existe previamente en la lista.
   *
   * @param element el elemento a agregar
   * @return true si se agregó, false si ya existía
   */
  public boolean addUniqueElement(final String element) {
    if (elements.contains(element)) {
      return false;
    }
    return elements.add(element);
  }

  /**
   * Elimina un elemento de la lista.
   *
   * @param element el elemento a eliminar
   * @return true si se eliminó, false si no existía
   */
  public boolean removeElement(final String element) {
    return elements.remove(element);
  }

  /**
   * Obtiene un elemento en la posición especificada.
   *
   * @param index índice del elemento
   * @return el elemento en esa posición
   * @throws IndexOutOfBoundsException si el índice es inválido
   */
  public String getElement(final int index) {
    return elements.get(index);
  }

  /**
   * Retorna el número de elementos en la lista.
   *
   * @return cantidad de elementos
   */
  public int size() {
    return elements.size();
  }

  /**
   * Verifica si la lista está vacía.
   *
   * @return true si no tiene elementos
   */
  public boolean isEmpty() {
    return elements.isEmpty();
  }

  /**
   * Verifica si un elemento existe en la lista.
   *
   * @param element el elemento a buscar
   * @return true si existe
   */
  public boolean contains(final String element) {
    return elements.contains(element);
  }

  /**
   * Limpia todos los elementos de la lista.
   */
  public void clear() {
    elements.clear();
  }

  /**
   * Retorna una copia de la lista actual.
   *
   * @return lista con los mismos elementos
   */
  public List<String> getAllElements() {
    return new ArrayList<>(elements);
  }
}
