/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar utilidades de la clase Collections.
 */
package io.github.cazucito.collections.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Ejemplifica el uso de métodos utilitarios de la clase Collections.
 *
 * <p>Demuestra operaciones como ordenamiento, búsqueda, sincronización, y creación de vistas
 * inmodificables.
 */
// CHECKSTYLE:OFF: MultipleStringLiterals
public class CollectionsUtilitiesExample {

  /** Separador de elementos. */
  private static final String ELEMENT_SEPARATOR = ", ";

  /** Lista de trabajo para operaciones. */
  private List<String> stringList;

  /** Lista numérica para operaciones. */
  private List<Integer> integerList;

  /** Resultado de operaciones numéricas. */
  private int intResult;

  /** Resultado de operaciones booleanas. */
  private boolean booleanResult;

  /** Constructor por defecto. */
  public CollectionsUtilitiesExample() {
    this.stringList = new ArrayList<>();
    this.integerList = new ArrayList<>();
  }

  /**
   * Crea una lista de strings a partir de un array.
   *
   * @param elements elementos separados por coma
   */
  public void createStringList(final String elements) {
    stringList.clear();
    if (elements != null && !elements.isEmpty()) {
      for (String element : elements.split(ELEMENT_SEPARATOR)) {
        stringList.add(element.trim());
      }
    }
  }

  /**
   * Crea una lista de enteros a partir de un string.
   *
   * @param numbers números separados por coma
   */
  public void createIntegerList(final String numbers) {
    integerList.clear();
    if (numbers != null && !numbers.isEmpty()) {
      for (String num : numbers.split(ELEMENT_SEPARATOR)) {
        integerList.add(Integer.parseInt(num.trim()));
      }
    }
  }

  /**
   * Ordena la lista con orden natural.
   *
   * @return lista ordenada como string
   */
  public String sortNaturalOrder() {
    Collections.sort(stringList);
    return String.join(ELEMENT_SEPARATOR, stringList);
  }

  /**
   * Ordena la lista numérica en orden descendente.
   *
   * @return lista ordenada como string
   */
  public String sortDescending() {
    integerList.sort(Collections.reverseOrder());
    return integerList.toString().replace("[", "").replace("]", "");
  }

  /**
   * Invierte el orden de la lista.
   *
   * @return lista invertida como string
   */
  public String reverseList() {
    Collections.reverse(stringList);
    return String.join(ELEMENT_SEPARATOR, stringList);
  }

  /** Mezcla los elementos de la lista aleatoriamente. */
  public void shuffleList() {
    Collections.shuffle(stringList);
  }

  /**
   * Obtiene la lista actual como string.
   *
   * @return lista como string
   */
  public String getStringListAsString() {
    return String.join(ELEMENT_SEPARATOR, stringList);
  }

  /**
   * Verifica que la lista contenga todos los elementos esperados.
   *
   * @param expected elementos esperados separados por coma
   * @return true si contiene todos los elementos
   */
  public boolean hasAllElements(final String expected) {
    Set<String> expectedSet = new HashSet<>();
    for (String element : expected.split(ELEMENT_SEPARATOR)) {
      expectedSet.add(element.trim());
    }
    return stringList.containsAll(expectedSet) && expectedSet.containsAll(stringList);
  }

  /**
   * Realiza búsqueda binaria en la lista ordenada.
   *
   * @param target elemento a buscar
   * @return índice encontrado o negativo si no existe
   */
  public int binarySearch(final int target) {
    Collections.sort(integerList);
    intResult = Collections.binarySearch(integerList, target);
    return intResult;
  }

  /**
   * Obtiene el resultado de la última búsqueda binaria.
   *
   * @return resultado de búsqueda
   */
  public int getLastBinarySearchResult() {
    return intResult;
  }

  /**
   * Verifica si el resultado de búsqueda fue negativo.
   *
   * @return true si fue negativo
   */
  public boolean isBinarySearchResultNegative() {
    return intResult < 0;
  }

  /**
   * Encuentra el elemento máximo.
   *
   * @return elemento máximo
   */
  public int findMax() {
    return Collections.max(integerList);
  }

  /**
   * Encuentra el elemento mínimo.
   *
   * @return elemento mínimo
   */
  public int findMin() {
    return Collections.min(integerList);
  }

  /**
   * Cuenta la frecuencia de un elemento.
   *
   * @param element elemento a contar
   * @return frecuencia
   */
  public int frequency(final String element) {
    return Collections.frequency(stringList, element);
  }

  /**
   * Verifica si dos listas son disjuntas (sin elementos comunes).
   *
   * @param listA lista A
   * @param listB lista B
   * @return true si son disjuntas
   */
  public boolean areDisjoint(final String listA, final String listB) {
    List<String> a = new ArrayList<>();
    List<String> b = new ArrayList<>();

    for (String element : listA.split(ELEMENT_SEPARATOR)) {
      a.add(element.trim());
    }
    for (String element : listB.split(ELEMENT_SEPARATOR)) {
      b.add(element.trim());
    }

    booleanResult = Collections.disjoint(a, b);
    return booleanResult;
  }

  /**
   * Obtiene el resultado de la última operación booleana.
   *
   * @return resultado booleano
   */
  public boolean getLastBooleanResult() {
    return booleanResult;
  }

  /**
   * Crea una vista inmodificable de la lista.
   *
   * @return lista inmodificable
   */
  public List<String> createUnmodifiableList() {
    return Collections.unmodifiableList(new ArrayList<>(stringList));
  }

  /**
   * Crea un set inmodificable.
   *
   * @param elements elementos del set
   * @return set inmodificable
   */
  public Set<String> createUnmodifiableSet(final String elements) {
    Set<String> set = new HashSet<>();
    for (String element : elements.split(ELEMENT_SEPARATOR)) {
      set.add(element.trim());
    }
    return Collections.unmodifiableSet(set);
  }

  /**
   * Crea un map inmodificable.
   *
   * @param entries entradas en formato "clave=valor, clave=valor"
   * @return map inmodificable
   */
  public Map<String, String> createUnmodifiableMap(final String entries) {
    Map<String, String> map = new HashMap<>();
    for (String entry : entries.split(ELEMENT_SEPARATOR)) {
      String[] parts = entry.split("=");
      map.put(parts[0].trim(), parts[1].trim());
    }
    return Collections.unmodifiableMap(map);
  }

  /**
   * Crea una lista sincronizada.
   *
   * @return lista sincronizada
   */
  public List<String> createSynchronizedList() {
    return Collections.synchronizedList(new ArrayList<>());
  }

  /**
   * Crea un map sincronizado.
   *
   * @return map sincronizado
   */
  public Map<String, String> createSynchronizedMap() {
    return Collections.synchronizedMap(new HashMap<>());
  }

  /**
   * Crea un set sincronizado.
   *
   * @return set sincronizado
   */
  public Set<String> createSynchronizedSet() {
    return Collections.synchronizedSet(new HashSet<>());
  }

  /**
   * Copia elementos de lista origen a destino.
   *
   * @param source elementos origen
   * @param dest elementos destino iniciales
   * @return lista destino después de copia
   */
  public String copyElements(final String source, final String dest) {
    List<String> src = new ArrayList<>();
    List<String> dst = new ArrayList<>();

    for (String element : source.split(ELEMENT_SEPARATOR)) {
      src.add(element.trim());
    }
    for (String element : dest.split(ELEMENT_SEPARATOR)) {
      dst.add(element.trim());
    }

    Collections.copy(dst, src);
    return String.join(ELEMENT_SEPARATOR, dst);
  }

  /**
   * Rellena la lista con un valor.
   *
   * @param value valor de relleno
   * @return lista rellenada como string
   */
  public String fillList(final String value) {
    Collections.fill(stringList, value);
    return String.join(ELEMENT_SEPARATOR, stringList);
  }

  /**
   * Rota la lista.
   *
   * @param distance distancia de rotación
   * @return lista rotada como string
   */
  public String rotateList(final int distance) {
    Collections.rotate(stringList, distance);
    return String.join(ELEMENT_SEPARATOR, stringList);
  }

  /**
   * Obtiene el tamaño de la lista.
   *
   * @return tamaño
   */
  public int getListSize() {
    return stringList.size();
  }
}
// CHECKSTYLE:ON
