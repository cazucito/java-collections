/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar el uso de LinkedHashMap.
 */
package io.github.cazucito.collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Ejemplifica el uso de LinkedHashMap para almacenar pares clave-valor con orden de inserción.
 *
 * <p>Demuestra operaciones básicas de LinkedHashMap, destacando el mantenimiento del orden de
 * inserción de entradas y la eficiencia de acceso O(1) heredada de HashMap.
 */
public class LinkedHashMapExample {

  /** Separador para elementos en toString. */
  private static final String ELEMENT_SEPARATOR = ", ";

  /** LinkedHashMap interno para almacenar entradas ordenadas. */
  private final Map<String, String> linkedHashMap;

  /** Constructor que inicializa el LinkedHashMap vacío. */
  public LinkedHashMapExample() {
    this.linkedHashMap = new LinkedHashMap<>();
  }

  /**
   * Agrega una entrada clave-valor al linkedhashmap.
   *
   * @param key la clave de la entrada (puede ser null)
   * @param value el valor asociado (puede ser null)
   * @return el valor anterior asociado con la clave, o null si no existía
   */
  public String putEntry(final String key, final String value) {
    return linkedHashMap.put(key, value);
  }

  /**
   * Obtiene el valor asociado a una clave.
   *
   * @param key la clave a consultar
   * @return el valor asociado, o null si no existe
   */
  public String getValue(final String key) {
    return linkedHashMap.get(key);
  }

  /**
   * Elimina una entrada del linkedhashmap por su clave.
   *
   * @param key la clave de la entrada a eliminar
   * @return el valor eliminado, o null si no existía
   */
  public String removeEntry(final String key) {
    return linkedHashMap.remove(key);
  }

  /**
   * Obtiene el tamaño actual del linkedhashmap.
   *
   * @return número de entradas
   */
  public int size() {
    return linkedHashMap.size();
  }

  /**
   * Verifica si el linkedhashmap está vacío.
   *
   * @return true si no contiene entradas
   */
  public boolean isEmpty() {
    return linkedHashMap.isEmpty();
  }

  /** Elimina todas las entradas del linkedhashmap. */
  public void clear() {
    linkedHashMap.clear();
  }

  /**
   * Verifica si una clave existe en el linkedhashmap.
   *
   * @param key la clave a buscar
   * @return true si existe
   */
  public boolean containsKey(final String key) {
    return linkedHashMap.containsKey(key);
  }

  /**
   * Verifica si un valor existe en el linkedhashmap.
   *
   * @param value el valor a buscar
   * @return true si existe
   */
  public boolean containsValue(final String value) {
    return linkedHashMap.containsValue(value);
  }

  /**
   * Obtiene todas las claves en orden de inserción.
   *
   * @return string con claves separadas por coma
   */
  public String getOrderedKeys() {
    StringBuilder sb = new StringBuilder();
    for (String key : linkedHashMap.keySet()) {
      if (sb.length() > 0) {
        sb.append(ELEMENT_SEPARATOR);
      }
      sb.append(key);
    }
    return sb.toString();
  }

  /**
   * Obtiene todos los valores en orden de inserción de sus claves.
   *
   * @return string con valores separados por coma
   */
  public String getOrderedValues() {
    StringBuilder sb = new StringBuilder();
    for (String value : linkedHashMap.values()) {
      if (sb.length() > 0) {
        sb.append(ELEMENT_SEPARATOR);
      }
      sb.append(value);
    }
    return sb.toString();
  }
}
