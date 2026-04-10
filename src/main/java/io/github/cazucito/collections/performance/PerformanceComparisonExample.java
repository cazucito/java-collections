/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar comparaciones de rendimiento.
 */
package io.github.cazucito.collections.performance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Ejemplifica comparaciones de rendimiento entre diferentes colecciones.
 *
 * <p>Demuestra las diferencias de complejidad temporal (Big O) entre ArrayList vs LinkedList,
 * HashSet vs TreeSet, y HashMap vs TreeMap para operaciones comunes.
 */
public class PerformanceComparisonExample {

  /** Factor de conversión de nanosegundos a milisegundos. */
  private static final double NS_TO_MS = 1_000_000.0;

  /** Tiempo medido de operación. */
  private long measuredTimeNanos;

  /** Tamaño de la colección usada en pruebas. */
  private int collectionSize;

  /** Constructor por defecto. */
  public PerformanceComparisonExample() {
    // Constructor vacío
  }

  /**
   * Configura el tamaño de la colección para pruebas.
   *
   * @param size tamaño de la colección
   */
  public void setCollectionSize(final int size) {
    this.collectionSize = size;
  }

  /**
   * Mide el tiempo de inserción en ArrayList al final.
   *
   * @return tiempo en milisegundos
   */
  public double measureArrayListAddAtEnd() {
    List<Integer> list = new ArrayList<>();
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      list.add(i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de inserción en ArrayList al inicio.
   *
   * @return tiempo en milisegundos
   */
  public double measureArrayListAddAtBeginning() {
    List<Integer> list = new ArrayList<>();
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      list.add(0, i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de inserción en LinkedList al final.
   *
   * @return tiempo en milisegundos
   */
  public double measureLinkedListAddAtEnd() {
    List<Integer> list = new LinkedList<>();
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      list.add(i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de inserción en LinkedList al inicio.
   *
   * @return tiempo en milisegundos
   */
  public double measureLinkedListAddAtBeginning() {
    List<Integer> list = new LinkedList<>();
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      list.add(0, i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de acceso por índice en ArrayList.
   *
   * @return tiempo en milisegundos
   */
  public double measureArrayListAccessByIndex() {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < collectionSize; i++) {
      list.add(i);
    }
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      list.get(i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de acceso por índice en LinkedList.
   *
   * @return tiempo en milisegundos
   */
  public double measureLinkedListAccessByIndex() {
    List<Integer> list = new LinkedList<>();
    for (int i = 0; i < collectionSize; i++) {
      list.add(i);
    }
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      list.get(i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de inserción en HashSet.
   *
   * @return tiempo en milisegundos
   */
  public double measureHashSetAdd() {
    Set<Integer> set = new HashSet<>();
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      set.add(i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de inserción en TreeSet.
   *
   * @return tiempo en milisegundos
   */
  public double measureTreeSetAdd() {
    Set<Integer> set = new TreeSet<>();
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      set.add(i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de búsqueda en HashSet.
   *
   * @return tiempo en milisegundos
   */
  public double measureHashSetContains() {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < collectionSize; i++) {
      set.add(i);
    }
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      set.contains(i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de búsqueda en TreeSet.
   *
   * @return tiempo en milisegundos
   */
  public double measureTreeSetContains() {
    Set<Integer> set = new TreeSet<>();
    for (int i = 0; i < collectionSize; i++) {
      set.add(i);
    }
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      set.contains(i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de inserción en HashMap.
   *
   * @return tiempo en milisegundos
   */
  public double measureHashMapPut() {
    Map<Integer, Integer> map = new HashMap<>();
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      map.put(i, i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de inserción en TreeMap.
   *
   * @return tiempo en milisegundos
   */
  public double measureTreeMapPut() {
    Map<Integer, Integer> map = new TreeMap<>();
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      map.put(i, i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de búsqueda en HashMap.
   *
   * @return tiempo en milisegundos
   */
  public double measureHashMapGet() {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < collectionSize; i++) {
      map.put(i, i);
    }
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      map.get(i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de búsqueda en TreeMap.
   *
   * @return tiempo en milisegundos
   */
  public double measureTreeMapGet() {
    Map<Integer, Integer> map = new TreeMap<>();
    for (int i = 0; i < collectionSize; i++) {
      map.put(i, i);
    }
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      map.get(i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de inserción en LinkedHashSet (mantiene orden).
   *
   * @return tiempo en milisegundos
   */
  public double measureLinkedHashSetAdd() {
    Set<Integer> set = new LinkedHashSet<>();
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      set.add(i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Mide el tiempo de inserción en LinkedHashMap (mantiene orden).
   *
   * @return tiempo en milisegundos
   */
  public double measureLinkedHashMapPut() {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    long start = System.nanoTime();
    for (int i = 0; i < collectionSize; i++) {
      map.put(i, i);
    }
    measuredTimeNanos = System.nanoTime() - start;
    return measuredTimeNanos / NS_TO_MS;
  }

  /**
   * Retorna el último tiempo medido en nanosegundos.
   *
   * @return tiempo en nanosegundos
   */
  public long getLastMeasuredTimeNanos() {
    return measuredTimeNanos;
  }
}
