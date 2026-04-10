/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar el uso de LinkedList.
 */
package io.github.cazucito.collections.list;

import java.util.LinkedList;
import java.util.List;

/**
 * Ejemplifica el uso de LinkedList para almacenar y manipular elementos.
 *
 * <p>Demuestra operaciones básicas y específicas de LinkedList como agregar/eliminar al inicio y
 * final, destacando las ventajas de la estructura de lista doblemente enlazada.
 */
public class LinkedListExample {

  /** Lista enlazada interna para almacenar elementos de tipo String. */
  private final LinkedList<String> elements;

  /** Constructor que inicializa la lista vacía. */
  public LinkedListExample() {
    this.elements = new LinkedList<>();
  }

  /**
   * Agrega un elemento al final de la lista.
   *
   * @param element el elemento a agregar
   * @return true si se agregó correctamente
   */
  public boolean addElement(final String element) {
    return elements.add(element);
  }

  /**
   * Agrega un elemento al inicio de la lista.
   *
   * <p>Operación eficiente O(1) en LinkedList.
   *
   * @param element el elemento a agregar al inicio
   */
  public void addFirst(final String element) {
    elements.addFirst(element);
  }

  /**
   * Agrega un elemento al final de la lista.
   *
   * <p>Operación eficiente O(1) en LinkedList.
   *
   * @param element el elemento a agregar al final
   */
  public void addLast(final String element) {
    elements.addLast(element);
  }

  /**
   * Elimina y retorna el primer elemento de la lista.
   *
   * @return el primer elemento eliminado
   * @throws java.util.NoSuchElementException si la lista está vacía
   */
  public String removeFirst() {
    return elements.removeFirst();
  }

  /**
   * Elimina y retorna el último elemento de la lista.
   *
   * @return el último elemento eliminado
   * @throws java.util.NoSuchElementException si la lista está vacía
   */
  public String removeLast() {
    return elements.removeLast();
  }

  /**
   * Retorna el primer elemento sin eliminarlo.
   *
   * @return el primer elemento
   * @throws java.util.NoSuchElementException si la lista está vacía
   */
  public String getFirst() {
    return elements.getFirst();
  }

  /**
   * Retorna el último elemento sin eliminarlo.
   *
   * @return el último elemento
   * @throws java.util.NoSuchElementException si la lista está vacía
   */
  public String getLast() {
    return elements.getLast();
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

  /** Limpia todos los elementos de la lista. */
  public void clear() {
    elements.clear();
  }

  /**
   * Retorna una copia de la lista actual.
   *
   * @return lista con los mismos elementos
   */
  public List<String> getAllElements() {
    return new LinkedList<>(elements);
  }
}
