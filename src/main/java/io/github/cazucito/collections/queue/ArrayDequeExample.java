/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar el uso de ArrayDeque.
 */
package io.github.cazucito.collections.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Ejemplifica el uso de ArrayDeque como pila (stack) y cola (queue).
 *
 * <p>Demuestra operaciones de doble extremo con ArrayDeque, destacando su eficiencia O(1) para
 * operaciones en ambos extremos y su uso versátil como pila LIFO o cola FIFO.
 */
public class ArrayDequeExample {

  /** Separador para elementos en toString. */
  private static final String ELEMENT_SEPARATOR = ", ";

  /** ArrayDeque interno para almacenar elementos. */
  private final Deque<String> arrayDeque;

  /** Constructor que inicializa el ArrayDeque vacío. */
  public ArrayDequeExample() {
    this.arrayDeque = new ArrayDeque<>();
  }

  /**
   * Agrega un elemento al inicio del deque (equivalente a push en pila).
   *
   * @param element el elemento a agregar
   */
  public void addFirst(final String element) {
    arrayDeque.addFirst(element);
  }

  /**
   * Agrega un elemento al final del deque (equivalente a add en cola).
   *
   * @param element el elemento a agregar
   */
  public void addLast(final String element) {
    arrayDeque.addLast(element);
  }

  /**
   * Push en pila (agrega al inicio).
   *
   * @param element el elemento a agregar
   */
  public void push(final String element) {
    arrayDeque.push(element);
  }

  /**
   * Pop de pila (elimina y retorna del inicio).
   *
   * @return el elemento del tope, o null si está vacío
   */
  public String pop() {
    if (arrayDeque.isEmpty()) {
      return null;
    }
    return arrayDeque.pop();
  }

  /**
   * Obtiene y elimina el primer elemento (pollFirst).
   *
   * @return el primer elemento, o null si está vacío
   */
  public String pollFirst() {
    return arrayDeque.pollFirst();
  }

  /**
   * Obtiene y elimina el último elemento (pollLast).
   *
   * @return el último elemento, o null si está vacío
   */
  public String pollLast() {
    return arrayDeque.pollLast();
  }

  /**
   * Obtiene sin eliminar el primer elemento (peekFirst).
   *
   * @return el primer elemento, o null si está vacío
   */
  public String peekFirst() {
    return arrayDeque.peekFirst();
  }

  /**
   * Obtiene sin eliminar el último elemento (peekLast).
   *
   * @return el último elemento, o null si está vacío
   */
  public String peekLast() {
    return arrayDeque.peekLast();
  }

  /**
   * Obtiene el tamaño actual del deque.
   *
   * @return número de elementos
   */
  public int size() {
    return arrayDeque.size();
  }

  /**
   * Verifica si el deque está vacío.
   *
   * @return true si no contiene elementos
   */
  public boolean isEmpty() {
    return arrayDeque.isEmpty();
  }

  /** Elimina todos los elementos del deque. */
  public void clear() {
    arrayDeque.clear();
  }

  /**
   * Verifica si un elemento existe en el deque.
   *
   * @param element el elemento a buscar
   * @return true si existe
   */
  public boolean contains(final String element) {
    return arrayDeque.contains(element);
  }

  /**
   * Obtiene todos los elementos en orden (para verificación).
   *
   * @return string con elementos separados por coma
   */
  public String getElementsInOrder() {
    StringBuilder sb = new StringBuilder();
    for (String element : arrayDeque) {
      if (sb.length() > 0) {
        sb.append(ELEMENT_SEPARATOR);
      }
      sb.append(element);
    }
    return sb.toString();
  }

  /**
   * Convierte el deque a representación de array.
   *
   * @return string en formato [element1, element2, ...]
   */
  public String toArrayString() {
    return arrayDeque.toString();
  }
}
