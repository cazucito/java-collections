/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar el uso de TreeSet.
 */
package io.github.cazucito.collections.set;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Ejemplifica el uso de TreeSet para almacenar elementos únicos ordenados.
 *
 * <p>Demuestra operaciones básicas y específicas de TreeSet como acceso a primer/último elemento y
 * operaciones de rango (headSet, tailSet, subSet), destacando el ordenamiento natural de los
 * elementos.
 */
public class TreeSetExample {

  /** SortedSet interno (TreeSet) para almacenar elementos de tipo String ordenados. */
  private final SortedSet<String> elements;

  /** Constructor que inicializa el set vacío. */
  public TreeSetExample() {
    this.elements = new java.util.TreeSet<>();
  }

  /**
   * Agrega un elemento al set.
   *
   * <p>El elemento se inserta en la posición correcta según el orden natural. Si el elemento ya
   * existe, no se agrega y se retorna false. No permite elementos null.
   *
   * @param element el elemento a agregar
   * @return true si se agregó, false si ya existía
   * @throws NullPointerException si el elemento es null
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
   * Retorna el primer elemento (menor) del set.
   *
   * @return el primer elemento ordenado
   * @throws java.util.NoSuchElementException si el set está vacío
   */
  public String getFirst() {
    return elements.first();
  }

  /**
   * Retorna el último elemento (mayor) del set.
   *
   * @return el último elemento ordenado
   * @throws java.util.NoSuchElementException si el set está vacío
   */
  public String getLast() {
    return elements.last();
  }

  /**
   * Retorna un subset con elementos menores al valor dado.
   *
   * @param toElement elemento límite exclusivo
   * @return SortedSet con elementos menores a toElement
   */
  public SortedSet<String> getHeadSet(final String toElement) {
    return elements.headSet(toElement);
  }

  /**
   * Retorna un subset con elementos mayores o iguales al valor dado.
   *
   * @param fromElement elemento límite inclusivo
   * @return SortedSet con elementos mayores o iguales a fromElement
   */
  public SortedSet<String> getTailSet(final String fromElement) {
    return elements.tailSet(fromElement);
  }

  /**
   * Retorna un subset entre dos valores.
   *
   * @param fromElement elemento inicial inclusivo
   * @param toElement elemento final exclusivo
   * @return SortedSet con elementos en el rango [fromElement, toElement)
   */
  public SortedSet<String> getSubSet(final String fromElement, final String toElement) {
    return elements.subSet(fromElement, toElement);
  }

  /**
   * Retorna el número de elementos en el set.
   *
   * @return cantidad de elementos
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
   * Retorna los elementos ordenados como un string separado por comas.
   *
   * @return string con elementos ordenados
   */
  public String getOrderedElements() {
    return String.join(", ", elements);
  }

  /**
   * Retorna una copia del set actual.
   *
   * @return set con los mismos elementos
   */
  public Set<String> getAllElements() {
    return new TreeSet<>(elements);
  }
}
