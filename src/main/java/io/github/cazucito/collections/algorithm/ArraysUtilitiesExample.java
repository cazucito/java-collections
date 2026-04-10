/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Ejemplo de uso de utilidades de la clase Arrays.
 */
package io.github.cazucito.collections.algorithm;

import java.util.Arrays;
import java.util.List;

/** Ejemplo de utilidades de Arrays. */
public class ArraysUtilitiesExample {

  /** Separador de elementos. */
  private static final String ELEMENT_SEPARATOR = ", ";

  /** Patrón para eliminar corchetes. */
  private static final String BRACKET_PATTERN = "\\[|\\]";

  /** Array de strings para pruebas. */
  private String[] stringArray;

  /** Array de enteros para pruebas. */
  private int[] intArray;

  /** Resultado de búsqueda. */
  private int searchResult;

  /** Constructor. */
  public ArraysUtilitiesExample() {
    // Constructor vacío
  }

  /**
   * Crea un array de strings desde una cadena.
   *
   * @param elements elementos separados por coma
   */
  public void createStringArray(final String elements) {
    String[] parts = elements.split(ELEMENT_SEPARATOR);
    stringArray = new String[parts.length];
    for (int i = 0; i < parts.length; i++) {
      stringArray[i] = parts[i].trim();
    }
  }

  /**
   * Crea un array de enteros desde una cadena.
   *
   * @param numbers números separados por coma
   */
  public void createIntArray(final String numbers) {
    String[] parts = numbers.split(ELEMENT_SEPARATOR);
    intArray = new int[parts.length];
    for (int i = 0; i < parts.length; i++) {
      intArray[i] = Integer.parseInt(parts[i].trim());
    }
  }

  /**
   * Crea un array de enteros aleatorios.
   *
   * @param size tamaño del array
   */
  public void createRandomIntArray(final int size) {
    intArray = new int[size];
    for (int i = 0; i < size; i++) {
      intArray[i] = (int) (Math.random() * size);
    }
  }

  /**
   * Convierte el array a lista usando Arrays.asList().
   *
   * @return lista de strings
   */
  public List<String> asList() {
    return Arrays.asList(stringArray);
  }

  /**
   * Modifica el primer elemento del array.
   *
   * @param value nuevo valor
   */
  public void modifyFirstElement(final String value) {
    stringArray[0] = value;
  }

  /**
   * Obtiene el primer elemento del array.
   *
   * @return primer elemento
   */
  public String getFirstElement() {
    return stringArray[0];
  }

  /** Ordena el array de enteros. */
  public void sortIntArray() {
    Arrays.sort(intArray);
  }

  /** Ordena el array de enteros en paralelo. */
  public void parallelSortIntArray() {
    Arrays.parallelSort(intArray);
  }

  /**
   * Busca un elemento en el array ordenado.
   *
   * @param target elemento a buscar
   */
  public void binarySearchInt(final int target) {
    searchResult = Arrays.binarySearch(intArray, target);
  }

  /**
   * Rellena el array de strings con un valor.
   *
   * @param value valor para rellenar
   */
  public void fillStringArray(final String value) {
    Arrays.fill(stringArray, value);
  }

  /**
   * Copia el array con un nuevo tamaño.
   *
   * @param newLength nuevo tamaño
   */
  public void copyOfIntArray(final int newLength) {
    intArray = Arrays.copyOf(intArray, newLength);
  }

  /**
   * Obtiene el array de enteros como string.
   *
   * @return representación string del array
   */
  public String getIntArrayAsString() {
    return Arrays.toString(intArray).replaceAll(BRACKET_PATTERN, "");
  }

  /**
   * Obtiene el array de strings como string.
   *
   * @return representación string del array
   */
  public String getStringArrayAsString() {
    return Arrays.toString(stringArray).replaceAll(BRACKET_PATTERN, "");
  }

  /**
   * Obtiene un elemento del array de strings.
   *
   * @param index índice
   * @return elemento en el índice
   */
  public String getStringArrayElement(final int index) {
    return stringArray[index];
  }

  /**
   * Obtiene el resultado de la última búsqueda.
   *
   * @return resultado de búsqueda
   */
  public int getSearchResult() {
    return searchResult;
  }

  /**
   * Verifica si el resultado de búsqueda es negativo.
   *
   * @return true si es negativo
   */
  public boolean isSearchResultNegative() {
    return searchResult < 0;
  }

  /**
   * Verifica si el array de enteros está ordenado.
   *
   * @return true si está ordenado
   */
  public boolean isIntArraySorted() {
    for (int i = 1; i < intArray.length; i++) {
      if (intArray[i] < intArray[i - 1]) {
        return false;
      }
    }
    return true;
  }

  /**
   * Obtiene la longitud del array de enteros.
   *
   * @return longitud
   */
  public int getIntArrayLength() {
    return intArray.length;
  }
}
