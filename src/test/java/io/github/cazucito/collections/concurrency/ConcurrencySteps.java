/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de concurrencia.
 */
package io.github.cazucito.collections.concurrency;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Implementación de los steps para pruebas de concurrencia.
 *
 * <p>Esta clase conecta los escenarios de concurrencia con el código Java que demuestra problemas
 * de thread-safety y sus soluciones.
 */
public class ConcurrencySteps {

  /** Instancia del ejemplo de acceso concurrente a List. */
  private ConcurrentAccessExample listExample;

  /** Instancia del ejemplo de acceso concurrente a Map. */
  private ConcurrentHashMapExample mapExample;

  /** Resultado de operación con lista. */
  private int listSizeResult;

  /** Resultado de operación con map. */
  private int mapSizeResult;

  /** Resultado booleano de verificación. */
  private boolean booleanResult;

  /** Resultado numérico de contador. */
  private int counterResult;

  /** Número de threads a usar. */
  private int threadCount;

  /** Elementos por thread. */
  private int itemsPerThread;

  /** Total de operaciones esperadas. */
  private int expectedTotal;

  /** Inicializa el ejemplo de lista. */
  @Given("un ejemplo de acceso concurrente a List")
  public void unEjemploDeAccesoConcurrenteAList() {
    listExample = new ConcurrentAccessExample();
  }

  /** Inicializa el ejemplo de map. */
  @Given("un ejemplo de acceso concurrente a Map")
  public void unEjemploDeAccesoConcurrenteAMap() {
    mapExample = new ConcurrentHashMapExample();
  }

  /**
   * Configura los parámetros de concurrencia.
   *
   * @param threads número de threads
   * @param items elementos por thread
   */
  @Given("que utilizo {int} threads con {int} elementos cada uno")
  public void queUtilizoThreadsConElementosCadaUno(final int threads, final int items) {
    this.threadCount = threads;
    this.itemsPerThread = items;
    this.expectedTotal = threads * items;
  }

  /**
   * Configura los parámetros de concurrencia para incrementos.
   *
   * @param threads número de threads
   * @param increments incrementos por thread
   */
  @Given("que utilizo {int} threads con {int} incrementos cada uno")
  public void queUtilizoThreadsConIncrementosCadaUno(final int threads, final int increments) {
    this.threadCount = threads;
    this.itemsPerThread = increments;
    this.expectedTotal = threads * increments;
  }

  /**
   * Configura el tamaño esperado.
   *
   * @param expected tamaño esperado
   */
  @Given("el tamaño esperado es {int}")
  public void elTamanoEsperadoEs(final int expected) {
    if (listExample != null) {
      listExample.setExpectedSize(expected);
    }
    if (mapExample != null) {
      mapExample.setExpectedSize(expected);
    }
  }

  /**
   * Agrega elementos a ArrayList concurrentemente.
   *
   * @throws InterruptedException si hay interrupción
   */
  @When("agrego elementos al ArrayList desde múltiples threads")
  public void agregoElementosAlArrayListDesdeMultiplesThreads() throws InterruptedException {
    listExample.addToUnsafeListConcurrently(threadCount, itemsPerThread);
  }

  /**
   * Agrega elementos a lista sincronizada concurrentemente.
   *
   * @throws InterruptedException si hay interrupción
   */
  @When("agrego elementos a la lista sincronizada desde múltiples threads")
  public void agregoElementosALaListaSincronizadaDesdeMultiplesThreads()
      throws InterruptedException {
    listExample.addToSynchronizedListConcurrently(threadCount, itemsPerThread);
  }

  /**
   * Agrega elementos a CopyOnWriteArrayList concurrentemente.
   *
   * @throws InterruptedException si hay interrupción
   */
  @When("agrego elementos al CopyOnWriteArrayList desde múltiples threads")
  public void agregoElementosAlCopyOnWriteArrayListDesdeMultiplesThreads()
      throws InterruptedException {
    listExample.addToConcurrentListConcurrently(threadCount, itemsPerThread);
  }

  /**
   * Agrega elementos a HashMap concurrentemente.
   *
   * @throws InterruptedException si hay interrupción
   */
  @When("agrego elementos al HashMap desde múltiples threads")
  public void agregoElementosAlHashMapDesdeMultiplesThreads() throws InterruptedException {
    mapExample.addToUnsafeMapConcurrently(threadCount, itemsPerThread);
  }

  /**
   * Agrega elementos a map sincronizado concurrentemente.
   *
   * @throws InterruptedException si hay interrupción
   */
  @When("agrego elementos al map sincronizado desde múltiples threads")
  public void agregoElementosAlMapSincronizadoDesdeMultiplesThreads() throws InterruptedException {
    mapExample.addToSynchronizedMapConcurrently(threadCount, itemsPerThread);
  }

  /**
   * Agrega elementos a ConcurrentHashMap concurrentemente.
   *
   * @throws InterruptedException si hay interrupción
   */
  @When("agrego elementos al ConcurrentHashMap desde múltiples threads")
  public void agregoElementosAlConcurrentHashMapDesdeMultiplesThreads()
      throws InterruptedException {
    mapExample.addToConcurrentMapConcurrently(threadCount, itemsPerThread);
  }

  /** Obtiene el tamaño del ArrayList no seguro. */
  @When("obtengo el tamaño del ArrayList")
  public void obtengoElTamanoDelArrayList() {
    listSizeResult = listExample.getUnsafeListSize();
  }

  /** Obtiene el tamaño de la lista sincronizada. */
  @When("obtengo el tamaño de la lista sincronizada")
  public void obtengoElTamanoDeLaListaSincronizada() {
    listSizeResult = listExample.getSynchronizedListSize();
  }

  /** Obtiene el tamaño del CopyOnWriteArrayList. */
  @When("obtengo el tamaño del CopyOnWriteArrayList")
  public void obtengoElTamanoDelCopyOnWriteArrayList() {
    listSizeResult = listExample.getConcurrentListSize();
  }

  /** Obtiene el tamaño del HashMap no seguro. */
  @When("obtengo el tamaño del HashMap")
  public void obtengoElTamanoDelHashMap() {
    mapSizeResult = mapExample.getUnsafeMapSize();
  }

  /** Obtiene el tamaño del map sincronizado. */
  @When("obtengo el tamaño del map sincronizado")
  public void obtengoElTamanoDelMapSincronizado() {
    mapSizeResult = mapExample.getSynchronizedMapSize();
  }

  /** Obtiene el tamaño del ConcurrentHashMap. */
  @When("obtengo el tamaño del ConcurrentHashMap")
  public void obtengoElTamanoDelConcurrentHashMap() {
    mapSizeResult = mapExample.getConcurrentMapSize();
  }

  /** Demuestra ConcurrentModificationException. */
  @When("intento modificar la lista mientras itero sobre ella")
  public void intentoModificarLaListaMientrasIteroSobreElla() {
    booleanResult = listExample.demonstrateConcurrentModification();
  }

  /** Itera y modifica CopyOnWriteArrayList. */
  @When("modifico el CopyOnWriteArrayList mientras itero")
  public void modificoElCopyOnWriteArrayListMientrasItero() {
    listSizeResult = listExample.safeIterationWithConcurrentList();
  }

  /**
   * Demuestra race condition en contador.
   *
   * @throws InterruptedException si hay interrupción
   */
  @When("incremento un contador concurrentemente sin sincronización")
  public void incrementoUnContadorConcurrentementeSinSincronizacion() throws InterruptedException {
    counterResult = mapExample.demonstrateRaceCondition(threadCount, itemsPerThread);
  }

  /**
   * Incremento atómico con ConcurrentHashMap.
   *
   * @throws InterruptedException si hay interrupción
   */
  @When("incremento el contador con ConcurrentHashMap")
  public void incrementoElContadorConConcurrentHashMap() throws InterruptedException {
    counterResult = mapExample.atomicIncrementWithConcurrentMap(threadCount, itemsPerThread);
  }

  /**
   * Verifica que el tamaño es menor o igual al esperado.
   *
   * @param expected esperado
   */
  @Then("el tamaño puede ser menor o igual a {int}")
  public void elTamanoPuedeSerMenorOIgualA(final int expected) {
    assertThat(listSizeResult).isLessThanOrEqualTo(expected);
  }

  /**
   * Verifica que el tamaño del map es menor o igual al esperado.
   *
   * @param expected esperado
   */
  @Then("el tamaño del map puede ser menor o igual a {int}")
  public void elTamanoDelMapPuedeSerMenorOIgualA(final int expected) {
    assertThat(mapSizeResult).isLessThanOrEqualTo(expected);
  }

  /**
   * Verifica que el tamaño es el esperado.
   *
   * @param expected esperado
   */
  @Then("el tamaño debe ser {int}")
  public void elTamanoDebeSer(final int expected) {
    assertThat(listSizeResult).isEqualTo(expected);
  }

  /**
   * Verifica el tamaño del map concurrente.
   *
   * @param expected esperado
   */
  @Then("el tamaño del map concurrente debe ser {int}")
  public void elTamanoDelMapConcurrenteDebeSer(final int expected) {
    assertThat(mapSizeResult).isEqualTo(expected);
  }

  /** Verifica que se lanzó ConcurrentModificationException. */
  @Then("debe lanzarse ConcurrentModificationException")
  public void debeLanzarseConcurrentModificationException() {
    assertThat(booleanResult).isTrue();
  }

  /**
   * Verifica que el contador es menor o igual al esperado.
   *
   * @param expected esperado
   */
  @Then("el valor del contador puede ser menor o igual a {int}")
  public void elValorDelContadorPuedeSerMenorOIgualA(final int expected) {
    assertThat(counterResult).isLessThanOrEqualTo(expected);
  }

  /**
   * Verifica que el contador tiene el valor esperado.
   *
   * @param expected esperado
   */
  @Then("el valor del contador debe ser {int}")
  public void elValorDelContadorDebeSer(final int expected) {
    assertThat(counterResult).isEqualTo(expected);
  }
}
