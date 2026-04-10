/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar el uso de TreeMap.
 */
package io.github.cazucito.collections.map;

import java.util.Map;
import java.util.SortedMap;

/**
 * Ejemplifica el uso de TreeMap para almacenar pares clave-valor ordenados por clave.
 *
 * <p>Demuestra operaciones básicas y específicas de TreeMap como acceso a primera/última entrada y
 * operaciones de rango (headMap, tailMap, subMap), destacando el ordenamiento natural de las
 * claves.
 */
public class TreeMapExample {

  /** SortedMap interno (TreeMap) para almacenar pares ordenados por clave. */
  private final SortedMap<String, String> entries;

  /** Constructor que inicializa el map vacío. */
  public TreeMapExample() {
    this.entries = new java.util.TreeMap<>();
  }

  /**
   * Agrega o actualiza un par clave-valor en el map.
   *
   * <p>La entrada se inserta en la posición correcta según el orden natural de la clave. Si la
   * clave ya existe, el valor es reemplazado. No permite claves null.
   *
   * @param key la clave del elemento
   * @param value el valor asociado a la clave
   * @return el valor anterior asociado a la clave, o null si no existía
   * @throws NullPointerException si la clave es null
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
   * Retorna la primera clave (menor) del map.
   *
   * @return la primera clave ordenada
   * @throws java.util.NoSuchElementException si el map está vacío
   */
  public String getFirstKey() {
    return entries.firstKey();
  }

  /**
   * Retorna el valor asociado a la primera clave.
   *
   * @return el valor de la primera entrada
   * @throws java.util.NoSuchElementException si el map está vacío
   */
  public String getFirstValue() {
    return entries.get(entries.firstKey());
  }

  /**
   * Retorna la última clave (mayor) del map.
   *
   * @return la última clave ordenada
   * @throws java.util.NoSuchElementException si el map está vacío
   */
  public String getLastKey() {
    return entries.lastKey();
  }

  /**
   * Retorna el valor asociado a la última clave.
   *
   * @return el valor de la última entrada
   * @throws java.util.NoSuchElementException si el map está vacío
   */
  public String getLastValue() {
    return entries.get(entries.lastKey());
  }

  /**
   * Retorna un submap con entradas con claves menores al valor dado.
   *
   * @param toKey clave límite exclusivo
   * @return SortedMap con entradas con claves menores a toKey
   */
  public SortedMap<String, String> getHeadMap(final String toKey) {
    return entries.headMap(toKey);
  }

  /**
   * Retorna un submap con entradas con claves mayores o iguales al valor dado.
   *
   * @param fromKey clave límite inclusivo
   * @return SortedMap con entradas con claves mayores o iguales a fromKey
   */
  public SortedMap<String, String> getTailMap(final String fromKey) {
    return entries.tailMap(fromKey);
  }

  /**
   * Retorna un submap entre dos claves.
   *
   * @param fromKey clave inicial inclusiva
   * @param toKey clave final exclusiva
   * @return SortedMap con entradas en el rango [fromKey, toKey)
   */
  public SortedMap<String, String> getSubMap(final String fromKey, final String toKey) {
    return entries.subMap(fromKey, toKey);
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
   * @return true si el valor existe
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
   * Retorna las claves ordenadas como un string separado por comas.
   *
   * @return string con claves ordenadas
   */
  public String getOrderedKeys() {
    return String.join(", ", entries.keySet());
  }

  /**
   * Retorna una copia del map actual.
   *
   * @return map con las mismas entradas
   */
  public Map<String, String> getAllEntries() {
    return new java.util.TreeMap<>(entries);
  }
}
