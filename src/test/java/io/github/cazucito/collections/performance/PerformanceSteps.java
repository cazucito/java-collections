/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de rendimiento.
 */
package io.github.cazucito.collections.performance;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Implementación de los steps para pruebas de rendimiento.
 *
 * <p>Esta clase conecta los escenarios de rendimiento con el código Java que mide tiempos.
 */
public class PerformanceSteps {

  /** Instancia del ejemplo de rendimiento. */
  private PerformanceComparisonExample performanceExample;

  /** Tiempo medido de ArrayList. */
  private double arrayListTime;

  /** Tiempo medido de LinkedList. */
  private double linkedListTime;

  /** Tiempo medido de HashSet. */
  private double hashSetTime;

  /** Tiempo medido de TreeSet. */
  private double treeSetTime;

  /** Tiempo medido de HashMap. */
  private double hashMapTime;

  /** Tiempo medido de TreeMap. */
  private double treeMapTime;

  /** Inicializa el ejemplo de rendimiento. */
  @Given("un ejemplo de comparación de rendimiento")
  public void unEjemploDeComparacionDeRendimiento() {
    performanceExample = new PerformanceComparisonExample();
  }

  /**
   * Configura el tamaño de la colección.
   *
   * @param size tamaño
   */
  @Given("una colección de {int} elementos")
  public void unaColeccionDeElementos(final int size) {
    performanceExample.setCollectionSize(size);
  }

  /** Mide inserción al final de ArrayList. */
  @When("mido el tiempo de inserción al final en ArrayList")
  public void midoElTiempoDeInsercionAlFinalEnArrayList() {
    arrayListTime = performanceExample.measureArrayListAddAtEnd();
  }

  /** Mide inserción al final de LinkedList. */
  @When("mido el tiempo de inserción al final en LinkedList")
  public void midoElTiempoDeInsercionAlFinalEnLinkedList() {
    linkedListTime = performanceExample.measureLinkedListAddAtEnd();
  }

  /** Mide inserción al inicio de ArrayList. */
  @When("mido el tiempo de inserción al inicio en ArrayList")
  public void midoElTiempoDeInsercionAlInicioEnArrayList() {
    arrayListTime = performanceExample.measureArrayListAddAtBeginning();
  }

  /** Mide inserción al inicio de LinkedList. */
  @When("mido el tiempo de inserción al inicio en LinkedList")
  public void midoElTiempoDeInsercionAlInicioEnLinkedList() {
    linkedListTime = performanceExample.measureLinkedListAddAtBeginning();
  }

  /** Mide acceso por índice en ArrayList. */
  @When("mido el tiempo de acceso por índice en ArrayList")
  public void midoElTiempoDeAccesoPorIndiceEnArrayList() {
    arrayListTime = performanceExample.measureArrayListAccessByIndex();
  }

  /** Mide acceso por índice en LinkedList. */
  @When("mido el tiempo de acceso por índice en LinkedList")
  public void midoElTiempoDeAccesoPorIndiceEnLinkedList() {
    linkedListTime = performanceExample.measureLinkedListAccessByIndex();
  }

  /** Mide inserción en HashSet. */
  @When("mido el tiempo de inserción en HashSet")
  public void midoElTiempoDeInsercionEnHashSet() {
    hashSetTime = performanceExample.measureHashSetAdd();
  }

  /** Mide inserción en TreeSet. */
  @When("mido el tiempo de inserción en TreeSet")
  public void midoElTiempoDeInsercionEnTreeSet() {
    treeSetTime = performanceExample.measureTreeSetAdd();
  }

  /** Mide búsqueda en HashSet. */
  @When("mido el tiempo de búsqueda en HashSet")
  public void midoElTiempoDeBusquedaEnHashSet() {
    hashSetTime = performanceExample.measureHashSetContains();
  }

  /** Mide búsqueda en TreeSet. */
  @When("mido el tiempo de búsqueda en TreeSet")
  public void midoElTiempoDeBusquedaEnTreeSet() {
    treeSetTime = performanceExample.measureTreeSetContains();
  }

  /** Mide inserción en HashMap. */
  @When("mido el tiempo de inserción en HashMap")
  public void midoElTiempoDeInsercionEnHashMap() {
    hashMapTime = performanceExample.measureHashMapPut();
  }

  /** Mide inserción en TreeMap. */
  @When("mido el tiempo de inserción en TreeMap")
  public void midoElTiempoDeInsercionEnTreeMap() {
    treeMapTime = performanceExample.measureTreeMapPut();
  }

  /** Mide búsqueda en HashMap. */
  @When("mido el tiempo de búsqueda en HashMap")
  public void midoElTiempoDeBusquedaEnHashMap() {
    hashMapTime = performanceExample.measureHashMapGet();
  }

  /** Mide búsqueda en TreeMap. */
  @When("mido el tiempo de búsqueda en TreeMap")
  public void midoElTiempoDeBusquedaEnTreeMap() {
    treeMapTime = performanceExample.measureTreeMapGet();
  }

  /** Verifica que ArrayList sea más rápido que LinkedList para acceso. */
  @Then("el acceso por índice en ArrayList debe ser más rápido que en LinkedList")
  public void elAccesoPorIndiceEnArrayListDebeSerMasRapidoQueEnLinkedList() {
    assertThat(arrayListTime).isLessThan(linkedListTime);
  }

  /** Verifica que LinkedList sea más rápido para inserción al inicio. */
  @Then("la inserción al inicio en LinkedList debe ser más rápida que en ArrayList")
  public void laInsercionAlInicioEnLinkedListDebeSerMasRapidaQueEnArrayList() {
    assertThat(linkedListTime).isLessThan(arrayListTime);
  }

  /** Verifica que HashSet sea más rápido que TreeSet. */
  @Then("las operaciones en HashSet deben ser más rápidas que en TreeSet")
  public void lasOperacionesEnHashSetDebenSerMasRapidasQueEnTreeSet() {
    assertThat(hashSetTime).isLessThan(treeSetTime);
  }

  /** Verifica que HashMap sea más rápido que TreeMap. */
  @Then("las operaciones en HashMap deben ser más rápidas que en TreeMap")
  public void lasOperacionesEnHashMapDebenSerMasRapidasQueEnTreeMap() {
    assertThat(hashMapTime).isLessThan(treeMapTime);
  }

  /** Verifica que el tiempo sea razonable (menos de 1 segundo). */
  @Then("el tiempo de ejecución debe ser menor a {int} ms")
  public void elTiempoDeEjecucionDebeSerMenorAMs(final int maxTime) {
    double maxTimeMs = maxTime;
    assertThat(
            arrayListTime + linkedListTime + hashSetTime + treeSetTime + hashMapTime + treeMapTime)
        .isLessThan(maxTimeMs);
  }
}
