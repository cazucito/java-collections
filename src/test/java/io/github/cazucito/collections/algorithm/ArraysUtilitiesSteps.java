/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para utilidades de Arrays.
 */
package io.github.cazucito.collections.algorithm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import java.util.List;

/** Step definitions para ArraysUtilitiesExample. */
public class ArraysUtilitiesSteps {

  /** Instancia del ejemplo. */
  private ArraysUtilitiesExample arraysExample;

  /** Lista resultado de conversión. */
  private List<String> convertedList;

  /** Constructor. */
  public ArraysUtilitiesSteps() {
    arraysExample = new ArraysUtilitiesExample();
  }

  @Dado("un array de strings para utilidad {string}")
  public void arraysUtil_crearArrayStrings(final String elements) {
    arraysExample.createStringArray(elements);
  }

  @Dado("un array de enteros para utilidad {string}")
  public void arraysUtil_crearArrayEnteros(final String numbers) {
    arraysExample.createIntArray(numbers);
  }

  @Dado("un array ordenado de enteros para utilidad {string}")
  public void arraysUtil_crearArrayOrdenado(final String numbers) {
    arraysExample.createIntArray(numbers);
  }

  @Dado("un array de {int} enteros aleatorios para utilidad")
  public void arraysUtil_crearArrayAleatorio(final int size) {
    arraysExample.createRandomIntArray(size);
  }

  @Cuando("convierto el array a lista con Arrays asList")
  public void arraysUtil_convertirALista() {
    convertedList = arraysExample.asList();
  }

  @Cuando("ordeno el array de enteros con Arrays sort")
  public void arraysUtil_ordenarArray() {
    arraysExample.sortIntArray();
  }

  @Cuando("ordeno el array de enteros con Arrays parallelSort")
  public void arraysUtil_ordenarArrayParalelo() {
    arraysExample.parallelSortIntArray();
  }

  @Cuando("busco en el array ordenado el elemento {int} con binarySearch")
  public void arraysUtil_busquedaBinaria(final int target) {
    arraysExample.binarySearchInt(target);
  }

  @Cuando("relleno el array de strings con el valor {string}")
  public void arraysUtil_rellenarArray(final String value) {
    arraysExample.fillStringArray(value);
  }

  @Cuando("copio el array a nuevo array de tamaño {int} con Arrays copyOf")
  public void arraysUtil_copiarArray(final int newLength) {
    arraysExample.copyOfIntArray(newLength);
  }

  @Y("modifico el primer elemento de la lista a {string}")
  public void arraysUtil_modificarPrimero(final String value) {
    convertedList.set(0, value);
  }

  @Entonces("la lista convertida desde array debe ser {string}")
  public void arraysUtil_verificarListaConvertida(final String expected) {
    assertThat(String.join(", ", convertedList)).isEqualTo(expected);
  }

  @Entonces("el array original refleja la modificación de la lista con valor {string}")
  public void arraysUtil_verificarModificacionArray(final String expected) {
    assertThat(arraysExample.getFirstElement()).isEqualTo(expected);
  }

  @Entonces("intentar agregar elemento a la lista fija lanza UnsupportedOperationException")
  public void arraysUtil_verificarListaFija() {
    assertThatThrownBy(() -> convertedList.add("D"))
        .isInstanceOf(UnsupportedOperationException.class);
  }

  @Entonces("el array de enteros ordenado debe ser {string}")
  public void arraysUtil_verificarArrayOrdenado(final String expected) {
    assertThat(arraysExample.getIntArrayAsString()).isEqualTo(expected);
  }

  @Entonces("el array de enteros esta ordenado correctamente")
  public void arraysUtil_verificarOrdenado() {
    assertThat(arraysExample.isIntArraySorted()).isTrue();
  }

  @Entonces("el indice encontrado en array debe ser {int}")
  public void arraysUtil_verificarIndiceEncontrado(final int expected) {
    assertThat(arraysExample.getSearchResult()).isEqualTo(expected);
  }

  @Entonces("el resultado de busqueda es negativo indicando posicion de insercion")
  public void arraysUtil_verificarResultadoNegativo() {
    assertThat(arraysExample.isSearchResultNegative()).isTrue();
  }

  @Entonces("todos los elementos del array de strings deben ser {string}")
  public void arraysUtil_verificarElementosRellenos(final String expected) {
    String[] elements = arraysExample.getStringArrayAsString().split(", ");
    for (String element : elements) {
      assertThat(element.trim()).isEqualTo(expected);
    }
  }

  @Entonces("el nuevo array de enteros debe ser {string}")
  public void arraysUtil_verificarNuevoArray(final String expected) {
    assertThat(arraysExample.getIntArrayAsString()).isEqualTo(expected);
  }

  @Entonces("el tamaño del array de enteros es {int}")
  public void arraysUtil_verificarTamano(final int expected) {
    assertThat(arraysExample.getIntArrayLength()).isEqualTo(expected);
  }
}
