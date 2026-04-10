/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar el uso de PriorityQueue.
 */
package io.github.cazucito.collections.queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Ejemplifica el uso de PriorityQueue para procesar elementos por prioridad.
 *
 * <p>Demuestra operaciones básicas de cola con prioridad, destacando el ordenamiento automático por
 * prioridad natural (numérico para enteros, alfabético para strings) y las operaciones de
 * inspección (peek) y extracción (poll) del elemento de mayor prioridad.
 */
public class PriorityQueueExample {

  /** Separador para elementos en toString. */
  private static final String ELEMENT_SEPARATOR = ", ";

  /** PriorityQueue interno para almacenar enteros por prioridad. */
  private final Queue<Integer> priorityQueue;

  /** PriorityQueue para almacenar strings por orden alfabético. */
  private final Queue<String> stringQueue;

  /** Constructor que inicializa ambas colas vacías. */
  public PriorityQueueExample() {
    this.priorityQueue = new PriorityQueue<>();
    this.stringQueue = new PriorityQueue<>();
  }

  /**
   * Agrega un elemento entero a la cola de prioridad.
   *
   * @param element el elemento a agregar
   * @return true si se agregó exitosamente
   */
  public boolean addElement(final int element) {
    return priorityQueue.add(element);
  }

  /**
   * Agrega un string a la cola de strings.
   *
   * @param element el string a agregar
   * @return true si se agregó exitosamente
   */
  public boolean addStringElement(final String element) {
    return stringQueue.add(element);
  }

  /**
   * Obtiene y elimina el elemento de mayor prioridad.
   *
   * @return el elemento de mayor prioridad, o null si está vacía
   */
  public Integer pollElement() {
    return priorityQueue.poll();
  }

  /**
   * Obtiene y elimina el string de mayor prioridad.
   *
   * @return el string de mayor prioridad, o null si está vacía
   */
  public String pollStringElement() {
    return stringQueue.poll();
  }

  /**
   * Obtiene sin eliminar el elemento de mayor prioridad.
   *
   * @return el elemento de mayor prioridad, o null si está vacía
   */
  public Integer peekElement() {
    return priorityQueue.peek();
  }

  /**
   * Obtiene sin eliminar el string de mayor prioridad.
   *
   * @return el string de mayor prioridad, o null si está vacía
   */
  public String peekStringElement() {
    return stringQueue.peek();
  }

  /**
   * Obtiene el tamaño actual de la cola de enteros.
   *
   * @return número de elementos en la cola
   */
  public int size() {
    return priorityQueue.size();
  }

  /**
   * Obtiene el tamaño de la cola de strings.
   *
   * @return número de strings en la cola
   */
  public int stringQueueSize() {
    return stringQueue.size();
  }

  /**
   * Verifica si la cola de enteros está vacía.
   *
   * @return true si no contiene elementos
   */
  public boolean isEmpty() {
    return priorityQueue.isEmpty();
  }

  /**
   * Verifica si la cola de strings está vacía.
   *
   * @return true si no contiene strings
   */
  public boolean isStringQueueEmpty() {
    return stringQueue.isEmpty();
  }

  /** Elimina todos los elementos de ambas colas. */
  public void clear() {
    priorityQueue.clear();
    stringQueue.clear();
  }

  /**
   * Verifica si la cola contiene un elemento específico.
   *
   * @param element el elemento a buscar
   * @return true si existe en la cola
   */
  public boolean contains(final int element) {
    return priorityQueue.contains(element);
  }

  /**
   * Verifica si la cola de strings contiene un elemento específico.
   *
   * @param element el string a buscar
   * @return true si existe en la cola
   */
  public boolean containsString(final String element) {
    return stringQueue.contains(element);
  }

  /**
   * Elimina un elemento específico de la cola.
   *
   * @param element el elemento a eliminar
   * @return true si se eliminó exitosamente
   */
  public boolean removeElement(final int element) {
    return priorityQueue.remove(element);
  }

  /**
   * Obtiene todos los elementos ordenados por prioridad (para verificación).
   *
   * <p>Extrae todos los elementos en orden de prioridad y los devuelve como string separado por
   * comas.
   *
   * @return string con elementos ordenados, ej: "10, 20, 30"
   */
  public String getOrderedElements() {
    StringBuilder sb = new StringBuilder();
    Queue<Integer> copy = new PriorityQueue<>(priorityQueue);
    while (!copy.isEmpty()) {
      if (sb.length() > 0) {
        sb.append(ELEMENT_SEPARATOR);
      }
      sb.append(copy.poll());
    }
    return sb.toString();
  }

  /**
   * Obtiene todos los strings ordenados alfabéticamente.
   *
   * @return string con elementos ordenados
   */
  public String getOrderedStrings() {
    StringBuilder sb = new StringBuilder();
    Queue<String> copy = new PriorityQueue<>(stringQueue);
    while (!copy.isEmpty()) {
      if (sb.length() > 0) {
        sb.append(ELEMENT_SEPARATOR);
      }
      sb.append(copy.poll());
    }
    return sb.toString();
  }
}
