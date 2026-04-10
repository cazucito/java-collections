/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar el uso de Streams API.
 */
package io.github.cazucito.collections.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Ejemplifica el uso de Streams API para procesamiento funcional de colecciones.
 *
 * <p>Demuestra operaciones intermedias (filter, map, sorted, distinct) y terminales (collect,
 * reduce, count, match), destacando el enfoque declarativo y funcional de Streams.
 */
public class StreamExample {

  /** Separador para elementos en toString. */
  private static final String ELEMENT_SEPARATOR = ", ";

  /** Lista interna de enteros para operaciones numéricas. */
  private List<Integer> integerList;

  /** Lista interna de strings para operaciones textuales. */
  private List<String> stringList;

  /** Constructor por defecto. */
  public StreamExample() {
    // Constructor vacío
  }

  /**
   * Inicializa con una lista de números separados por coma.
   *
   * @param numbers string con números separados por coma
   */
  public void initializeWithNumbers(final String numbers) {
    this.integerList =
        Arrays.stream(numbers.split(ELEMENT_SEPARATOR))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
  }

  /**
   * Inicializa con una lista de strings separados por coma.
   *
   * @param strings string con elementos separados por coma
   */
  public void initializeWithStrings(final String strings) {
    this.stringList = Arrays.asList(strings.split(ELEMENT_SEPARATOR));
  }

  /**
   * Filtra números mayores a un valor.
   *
   * @param threshold valor umbral
   * @return lista filtrada como string
   */
  public String filterNumbersGreaterThan(final int threshold) {
    return integerList.stream()
        .filter(n -> n > threshold)
        .map(String::valueOf)
        .collect(Collectors.joining(ELEMENT_SEPARATOR));
  }

  /**
   * Filtra strings que comienzan con un prefijo.
   *
   * @param prefix prefijo a buscar
   * @return lista filtrada como string
   */
  public String filterStringsStartingWith(final String prefix) {
    return stringList.stream()
        .filter(s -> s.startsWith(prefix))
        .collect(Collectors.joining(ELEMENT_SEPARATOR));
  }

  /**
   * Multiplica cada número por un factor.
   *
   * @param factor factor de multiplicación
   * @return lista transformada como string
   */
  public String multiplyBy(final int factor) {
    return integerList.stream()
        .map(n -> n * factor)
        .map(String::valueOf)
        .collect(Collectors.joining(ELEMENT_SEPARATOR));
  }

  /**
   * Convierte todos los strings a mayúsculas.
   *
   * @return lista en mayúsculas como string
   */
  public String toUpperCase() {
    return stringList.stream()
        .map(String::toUpperCase)
        .collect(Collectors.joining(ELEMENT_SEPARATOR));
  }

  /**
   * Obtiene la longitud de cada string.
   *
   * @return longitudes como string
   */
  public String getStringLengths() {
    return stringList.stream()
        .map(String::length)
        .map(String::valueOf)
        .collect(Collectors.joining(ELEMENT_SEPARATOR));
  }

  /**
   * Suma todos los elementos.
   *
   * @return suma total
   */
  public int sumAll() {
    return integerList.stream().reduce(0, Integer::sum);
  }

  /**
   * Encuentra el valor máximo.
   *
   * @return valor máximo
   */
  public int findMax() {
    return integerList.stream().mapToInt(Integer::intValue).max().orElse(0);
  }

  /**
   * Encuentra el valor mínimo.
   *
   * @return valor mínimo
   */
  public int findMin() {
    return integerList.stream().mapToInt(Integer::intValue).min().orElse(0);
  }

  /**
   * Filtra pares y convierte a lista.
   *
   * @return lista de pares como string
   */
  public String filterEvensToList() {
    return integerList.stream()
        .filter(n -> n % 2 == 0)
        .map(String::valueOf)
        .collect(Collectors.joining(ELEMENT_SEPARATOR));
  }

  /**
   * Convierte a Set (elimina duplicados).
   *
   * @return set como string ordenado
   */
  public String toSet() {
    Set<String> set = stringList.stream().collect(Collectors.toSet());
    return set.stream().sorted().collect(Collectors.joining(ELEMENT_SEPARATOR));
  }

  /**
   * Ordena alfabéticamente.
   *
   * @return lista ordenada como string
   */
  public String sortAlphabetically() {
    return stringList.stream().sorted().collect(Collectors.joining(ELEMENT_SEPARATOR));
  }

  /**
   * Ordena números descendente.
   *
   * @return lista ordenada como string
   */
  public String sortDescending() {
    return integerList.stream()
        .sorted(Comparator.reverseOrder())
        .map(String::valueOf)
        .collect(Collectors.joining(ELEMENT_SEPARATOR));
  }

  /**
   * Elimina duplicados.
   *
   * @return lista sin duplicados como string
   */
  public String distinct() {
    return stringList.stream().distinct().collect(Collectors.joining(ELEMENT_SEPARATOR));
  }

  /**
   * Limita a n elementos.
   *
   * @param limit cantidad límite
   * @return lista limitada como string
   */
  public String limit(final int limit) {
    return integerList.stream()
        .limit(limit)
        .map(String::valueOf)
        .collect(Collectors.joining(ELEMENT_SEPARATOR));
  }

  /**
   * Salta los primeros n elementos.
   *
   * @param skip cantidad a saltar
   * @return lista resultante como string
   */
  public String skip(final int skip) {
    return integerList.stream()
        .skip(skip)
        .map(String::valueOf)
        .collect(Collectors.joining(ELEMENT_SEPARATOR));
  }

  /**
   * Verifica si todos son pares.
   *
   * @return true si todos son pares
   */
  public boolean allEven() {
    return integerList.stream().allMatch(n -> n % 2 == 0);
  }

  /**
   * Verifica si alguno es par.
   *
   * @return true si alguno es par
   */
  public boolean anyEven() {
    return integerList.stream().anyMatch(n -> n % 2 == 0);
  }

  /**
   * Verifica si ninguno es par.
   *
   * @return true si ninguno es par
   */
  public boolean noneEven() {
    return integerList.stream().noneMatch(n -> n % 2 == 0);
  }

  /**
   * Encuentra el primer número par.
   *
   * @return primer par como string
   */
  public String findFirstEven() {
    Optional<Integer> first = integerList.stream().filter(n -> n % 2 == 0).findFirst();
    return first.map(String::valueOf).orElse("");
  }

  /**
   * Cuenta elementos que cumplen condición.
   *
   * @param threshold umbral
   * @return cantidad de elementos mayores al umbral
   */
  public long countGreaterThan(final int threshold) {
    return integerList.stream().filter(n -> n > threshold).count();
  }

  /**
   * Pipeline completo: filtrar > 5, multiplicar por 2, ordenar descendente.
   *
   * @return resultado como string
   */
  public String filterMultiplySort() {
    return integerList.stream()
        .filter(n -> n > 5)
        .map(n -> n * 2)
        .sorted(Comparator.reverseOrder())
        .map(String::valueOf)
        .collect(Collectors.joining(ELEMENT_SEPARATOR));
  }

  /**
   * Agrupa strings por su longitud.
   *
   * @return mapa de longitud -> lista de strings
   */
  public Map<Integer, List<String>> groupByLength() {
    return stringList.stream().collect(Collectors.groupingBy(String::length));
  }
}
