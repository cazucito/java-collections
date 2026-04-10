/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar el uso de Map.
 */
package io.github.cazucito.collections.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Ejemplifica el uso de HashMap para almacenar y manipular pares clave-valor.
 *
 * <p>Demuestra operaciones básicas como agregar, recuperar, eliminar y verificar entradas,
 * destacando las características principales de HashMap: acceso O(1) por clave, claves únicas, y
 * permitir valores duplicados y null.
 */
public class HashMapExample {

  /** Map interno para almacenar pares clave-valor de tipo String. */
  private final Map<String, String> entries;

  /** Constructor que inicializa el map vacío. */
  public HashMapExample() {
    this.entries = new HashMap<>();
  }

  /**
   * Agrega o actualiza un par clave-valor en el map.
   *
   * <p>Si la clave ya existe, el valor anterior es reemplazado.
   *
   * @param key la clave del elemento
   * @param value el valor asociado a la clave
   * @return el valor anterior asociado a la clave, o null si no existía
   */
  public String putEntry(final String key, final String value) {
    return entries.put(key, value);
  }

  /**
   * Recupera el valor asociado a una clave.
   *
   * @param key la clave a buscar
   * @return el valor asociado, o null si la clave no existe
   */
  public String getValue(final String key) {
    return entries.get(key);
  }

  /**
   * Elimina una entrada del map por su clave.
   *
   * @param key la clave de la entrada a eliminar
   * @return el valor eliminado, o null si la clave no existía
   */
  public String removeEntry(final String key) {
    return entries.remove(key);
  }

  /**
   * Verifica si una clave existe en el map.
   *
   * @param key la clave a verificar
   * @return true si la clave existe
   */
  public boolean containsKey(final String key) {
    return entries.containsKey(key);
  }

  /**
   * Verifica si un valor existe en el map.
   *
   * @param value el valor a buscar
   * @return true si el valor existe (asociado a alguna clave)
   */
  public boolean containsValue(final String value) {
    return entries.containsValue(value);
  }

  /**
   * Retorna el número de entradas en el map.
   *
   * @return cantidad de pares clave-valor
   */
  public int size() {
    return entries.size();
  }

  /**
   * Verifica si el map está vacío.
   *
   * @return true si no tiene entradas
   */
  public boolean isEmpty() {
    return entries.isEmpty();
  }

  /** Limpia todas las entradas del map. */
  public void clear() {
    entries.clear();
  }

  /**
   * Retorna una copia del map actual.
   *
   * @return map con las mismas entradas
   */
  public Map<String, String> getAllEntries() {
    return new HashMap<>(entries);
  }
}
