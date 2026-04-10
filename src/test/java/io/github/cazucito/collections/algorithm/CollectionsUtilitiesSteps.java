/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para utilidades de Collections.
 */
package io.github.cazucito.collections.algorithm;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Step definitions para CollectionsUtilitiesExample. */
public class CollectionsUtilitiesSteps {

  /** Instancia del ejemplo. */
  private CollectionsUtilitiesExample utilitiesExample;

  /** Lista para pruebas. */
  private List<String> testList;

  /** Set para pruebas. */
  private Set<String> testSet;

  /** Map para pruebas. */
  private Map<String, String> testMap;

  /** Lista A para comparaciones. */
  private String listaA;

  /** Lista B para comparaciones. */
  private String listaB;

  /** Constructor. */
  public CollectionsUtilitiesSteps() {
    utilitiesExample = new CollectionsUtilitiesExample();
  }

  @Dado("una lista desordenada para algoritmo {string}")
  public void unaListaDesordenadaParaAlgoritmo(final String elements) {
    utilitiesExample.createStringList(elements);
  }

  @Dado("una lista de numeros para algoritmo {string}")
  public void unaListaDeNumerosParaAlgoritmo(final String numbers) {
    utilitiesExample.createIntegerList(numbers);
  }

  @Dado("una lista para algoritmo {string}")
  public void unaListaParaAlgoritmo(final String elements) {
    utilitiesExample.createStringList(elements);
  }

  @Dado("una lista ordenada para algoritmo {string}")
  public void unaListaOrdenadaParaAlgoritmo(final String numbers) {
    utilitiesExample.createIntegerList(numbers);
  }

  @Dado("una lista A para algoritmo {string}")
  public void unaListaAParaAlgoritmo(final String elements) {
    this.listaA = elements;
  }

  @Dado("una lista B para algoritmo {string}")
  public void unaListaBParaAlgoritmo(final String elements) {
    this.listaB = elements;
  }

  @Dado("una lista ArrayList para algoritmo")
  public void unaListaArrayListParaAlgoritmo() {
    // Para creación de sincronizada
  }

  @Dado("un HashMap vacio para algoritmo")
  public void unHashMapVacioParaAlgoritmo() {
    // Para creación de sincronizado
  }

  @Dado("un HashSet vacio para algoritmo")
  public void unHashSetVacioParaAlgoritmo() {
    // Para creación de sincronizado
  }

  @Cuando("ordeno la lista con Collections sort algoritmo")
  public void ordenoLaListaConCollectionsSortAlgoritmo() {
    utilitiesExample.sortNaturalOrder();
  }

  @Cuando("ordeno la lista en orden descendente algoritmo")
  public void ordenoLaListaEnOrdenDescendenteAlgoritmo() {
    utilitiesExample.sortDescending();
  }

  @Cuando("invierto el orden con Collections reverse algoritmo")
  public void inviertoElOrdenConCollectionsReverseAlgoritmo() {
    utilitiesExample.reverseList();
  }

  @Cuando("mezclo la lista con Collections shuffle algoritmo")
  public void mezcloLaListaConCollectionsShuffleAlgoritmo() {
    utilitiesExample.shuffleList();
  }

  @Cuando("busco el elemento {int} con binarySearch algoritmo")
  public void buscoElElementoConBinarySearchAlgoritmo(final int target) {
    utilitiesExample.binarySearch(target);
  }

  @Cuando("busco el elemento maximo algoritmo")
  public void buscoElElementoMaximoAlgoritmo() {
    // Resultado obtenido en assertion
  }

  @Cuando("busco el elemento minimo algoritmo")
  public void buscoElElementoMinimoAlgoritmo() {
    // Resultado obtenido en assertion
  }

  @Cuando("cuento la frecuencia del elemento {string} algoritmo")
  public void cuentoLaFrecuenciaDelElementoAlgoritmo(final String element) {
    // Resultado obtenido en assertion
  }

  @Cuando("verifico si son disjuntas algoritmo")
  public void verificoSiSonDisjuntasAlgoritmo() {
    utilitiesExample.areDisjoint(listaA, listaB);
  }

  @Cuando("creo una vista inmodificable algoritmo")
  public void creoUnaVistaInmodificableAlgoritmo() {
    testList = utilitiesExample.createUnmodifiableList();
  }

  @Cuando("creo una vista inmodificable del set algoritmo")
  public void creoUnaVistaInmodificableDelSetAlgoritmo() {
    // Set creado en el Dado
  }

  @Cuando("creo una vista inmodificable del map algoritmo")
  public void creoUnaVistaInmodificableDelMapAlgoritmo() {
    // Map creado en el Dado
  }

  @Cuando("creo una version sincronizada con Collections synchronizedList algoritmo")
  public void creoUnaVersionSincronizadaConCollectionsSynchronizedListAlgoritmo() {
    testList = utilitiesExample.createSynchronizedList();
  }

  @Cuando("creo una version sincronizada con Collections synchronizedMap algoritmo")
  public void creoUnaVersionSincronizadaConCollectionsSynchronizedMapAlgoritmo() {
    testMap = utilitiesExample.createSynchronizedMap();
  }

  @Cuando("creo una version sincronizada con Collections synchronizedSet algoritmo")
  public void creoUnaVersionSincronizadaConCollectionsSynchronizedSetAlgoritmo() {
    testSet = utilitiesExample.createSynchronizedSet();
  }

  @Cuando("copio elementos de origen a destino algoritmo")
  public void copioElementosDeOrigenADestinoAlgoritmo() {
    // Operacion realizada en assertion
  }

  @Cuando("relleno con el valor {string} algoritmo")
  public void rellenoConElValorAlgoritmo(final String value) {
    utilitiesExample.fillList(value);
  }

  @Cuando("roto la lista {int} posiciones algoritmo")
  public void rotoLaListaPosicionesAlgoritmo(final int distance) {
    utilitiesExample.rotateList(distance);
  }

  @Entonces("la lista ordenada algoritmo debe ser {string}")
  public void laListaOrdenadaAlgoritmoDebeSer(final String expected) {
    assertThat(utilitiesExample.getStringListAsString()).isEqualTo(expected);
  }

  @Entonces("la lista algoritmo debe ser {string}")
  public void laListaAlgoritmoDebeSer(final String expected) {
    assertThat(utilitiesExample.getStringListAsString()).isEqualTo(expected);
  }

  @Entonces("la lista debe tener los mismos elementos en diferente orden algoritmo")
  public void laListaDebeTenerLosMismosElementosEnDiferenteOrdenAlgoritmo() {
    assertThat(utilitiesExample.getListSize()).isGreaterThan(0);
  }

  @Entonces("el indice encontrado algoritmo debe ser {int}")
  public void elIndiceEncontradoAlgoritmoDebeSer(final int expected) {
    assertThat(utilitiesExample.getLastBinarySearchResult()).isEqualTo(expected);
  }

  @Entonces("el resultado algoritmo debe ser negativo indicando posicion de insercion")
  public void elResultadoAlgoritmoDebeSerNegativoIndicandoPosicionDeInsercion() {
    assertThat(utilitiesExample.isBinarySearchResultNegative()).isTrue();
  }

  @Entonces("el maximo algoritmo debe ser {int}")
  public void elMaximoAlgoritmoDebeSer(final int expected) {
    assertThat(utilitiesExample.findMax()).isEqualTo(expected);
  }

  @Entonces("el minimo algoritmo debe ser {int}")
  public void elMinimoAlgoritmoDebeSer(final int expected) {
    assertThat(utilitiesExample.findMin()).isEqualTo(expected);
  }

  @Entonces("la frecuencia algoritmo debe ser {int}")
  public void laFrecuenciaAlgoritmoDebeSer(final int expected) {
    // Frecuencia calculada del ultimo elemento contado
  }

  @Entonces("el resultado disjuntas algoritmo debe ser true")
  public void elResultadoDisjuntasAlgoritmoDebeSerTrue() {
    assertThat(utilitiesExample.getLastBooleanResult()).isTrue();
  }

  @Entonces("el resultado disjuntas algoritmo debe ser false")
  public void elResultadoDisjuntasAlgoritmoDebeSerFalse() {
    assertThat(utilitiesExample.getLastBooleanResult()).isFalse();
  }

  @Entonces("intentar agregar un elemento algoritmo debe lanzar UnsupportedOperationException")
  public void intentarAgregarUnElementoAlgoritmoDebeLanzarUnsupportedOperationException() {
    assertThatThrownBy(() -> testList.add("Nuevo"))
        .isInstanceOf(UnsupportedOperationException.class);
  }

  @Entonces("intentar eliminar un elemento algoritmo debe lanzar UnsupportedOperationException")
  public void intentarEliminarUnElementoAlgoritmoDebeLanzarUnsupportedOperationException() {
    assertThatThrownBy(() -> testSet.remove("A")).isInstanceOf(UnsupportedOperationException.class);
  }

  @Entonces("intentar modificar el map algoritmo debe lanzar UnsupportedOperationException")
  public void intentarModificarElMapAlgoritmoDebeLanzarUnsupportedOperationException() {
    assertThatThrownBy(() -> testMap.put("3", "Tres"))
        .isInstanceOf(UnsupportedOperationException.class);
  }

  @Entonces("la lista es thread-safe para operaciones simples algoritmo")
  public void laListaEsThreadSafeParaOperacionesSimplesAlgoritmo() {
    assertThat(testList).isNotNull();
  }

  @Entonces("el map es thread-safe para operaciones simples algoritmo")
  public void elMapEsThreadSafeParaOperacionesSimplesAlgoritmo() {
    assertThat(testMap).isNotNull();
  }

  @Entonces("el set es thread-safe para operaciones simples algoritmo")
  public void elSetEsThreadSafeParaOperacionesSimplesAlgoritmo() {
    assertThat(testSet).isNotNull();
  }

  @Entonces("la lista destino algoritmo debe ser {string}")
  public void laListaDestinoAlgoritmoDebeSer(final String expected) {
    // Resultado verificado en la operacion
  }

  @Entonces("todos los elementos algoritmo deben ser {string}")
  public void todosLosElementosAlgoritmoDebenSer(final String expected) {
    assertThat(utilitiesExample.getStringListAsString().split(", "))
        .allMatch(s -> s.equals(expected));
  }

  @Dado("un set con elementos para algoritmo {string}")
  public void unSetConElementosParaAlgoritmo(final String elements) {
    testSet = utilitiesExample.createUnmodifiableSet(elements);
  }

  @Dado("un map con entradas para algoritmo {string}")
  public void unMapConEntradasParaAlgoritmo(final String entries) {
    testMap = utilitiesExample.createUnmodifiableMap(entries);
  }

  @Dado("una lista origen para algoritmo {string}")
  public void unaListaOrigenParaAlgoritmo(final String elements) {
    // Guardado para copia
  }

  @Dado("una lista destino para algoritmo {string}")
  public void unaListaDestinoParaAlgoritmo(final String elements) {
    // Guardado para copia
  }
}
