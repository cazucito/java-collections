/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de PriorityQueue.
 */
package io.github.cazucito.collections.queue;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Implementación de los steps para las pruebas de comportamiento de PriorityQueue.
 *
 * <p>Esta clase conecta los escenarios escritos en Gherkin con el código Java que ejecuta las
 * acciones y verifica los resultados.
 */
public class PriorityQueueSteps {

  /** Instancia del ejemplo de PriorityQueue que se está probando. */
  private PriorityQueueExample priorityQueueExample;

  /** Excepción capturada en operaciones que lanzan excepciones. */
  private Exception capturedException;

  /** Último elemento procesado (para escenarios multi-step). */
  private Integer lastPolledElement;

  /**
   * Inicializa una PriorityQueue vacía.
   *
   * <p>Este step se ejecuta al inicio de los scenarios que requieren una cola vacía.
   */
  @Given("una PriorityQueue vacía")
  public void unaPriorityQueueVacia() {
    priorityQueueExample = new PriorityQueueExample();
    capturedException = null;
    lastPolledElement = null;
  }

  /**
   * Inicializa una PriorityQueue de Strings vacía.
   *
   * <p>Este step se ejecuta al inicio de scenarios con strings.
   */
  @Given("una PriorityQueue de Strings vacía")
  public void unaPriorityQueueDeStringsVacia() {
    priorityQueueExample = new PriorityQueueExample();
    capturedException = null;
    lastPolledElement = null;
  }

  /**
   * Agrega un elemento entero a la cola de prioridad.
   *
   * @param element el elemento a agregar
   */
  @When("agrego el elemento con prioridad {int} a la cola")
  public void agregoElElementoConPrioridadALaCola(final int element) {
    priorityQueueExample.addElement(element);
  }

  /**
   * Agrega un string a la cola de strings.
   *
   * @param element el string a agregar
   */
  @When("agrego el string {string} a la cola")
  public void agregoElStringALaCola(final String element) {
    priorityQueueExample.addStringElement(element);
  }

  /** Intenta agregar null a la cola de enteros. */
  @When("intento agregar null a la cola")
  public void intentoAgregarNullALaCola() {
    try {
      priorityQueueExample.addElement((Integer) null);
    } catch (Exception e) {
      capturedException = e;
    }
  }

  /** Procesa (poll) un elemento de la cola. */
  @When("proceso un elemento de la cola")
  public void procesoUnElementoDeLaCola() {
    lastPolledElement = priorityQueueExample.pollElement();
  }

  /** Observa (peek) el elemento de mayor prioridad sin eliminarlo. */
  @When("observo el elemento de mayor prioridad")
  public void observoElElementoDeMayorPrioridad() {
    // Solo observamos, no modificamos
    priorityQueueExample.peekElement();
  }

  /** Limpia todas las entradas de la cola. */
  @When("limpio la cola")
  public void limpioLaCola() {
    priorityQueueExample.clear();
  }

  /**
   * Elimina un elemento específico de la cola.
   *
   * @param element el elemento a eliminar
   */
  @When("elimino el elemento con prioridad {int} de la cola")
  public void eliminoElElementoConPrioridadDeLaCola(final int element) {
    priorityQueueExample.removeElement(element);
  }

  /**
   * Verifica que el tamaño de la cola sea el esperado.
   *
   * @param expectedSize tamaño esperado
   */
  @Then("el tamaño de la cola debe ser {int}")
  public void elTamanoDeLaColaDebeSer(final int expectedSize) {
    assertThat(priorityQueueExample.size()).isEqualTo(expectedSize);
  }

  /**
   * Verifica que el elemento de mayor prioridad sea el esperado.
   *
   * @param expectedElement elemento esperado
   */
  @Then("el elemento de mayor prioridad debe ser {int}")
  public void elElementoDeMayorPrioridadDebeSer(final int expectedElement) {
    assertThat(priorityQueueExample.peekElement()).isEqualTo(expectedElement);
  }

  /**
   * Verifica que el elemento de mayor prioridad string sea el esperado.
   *
   * @param expectedElement string esperado
   */
  @Then("el elemento de mayor prioridad debe ser {string}")
  public void elElementoDeMayorPrioridadDebeSer(final String expectedElement) {
    assertThat(priorityQueueExample.peekStringElement()).isEqualTo(expectedElement);
  }

  /** Verifica que el elemento de mayor prioridad sea null (cola vacía). */
  @Then("el elemento de mayor prioridad debe ser null")
  public void elElementoDeMayorPrioridadDebeSerNull() {
    assertThat(priorityQueueExample.peekElement()).isNull();
  }

  /**
   * Verifica el orden de prioridad de todos los elementos.
   *
   * @param expectedOrder orden esperado separado por comas
   */
  @Then("el orden de prioridad debe ser {string}")
  public void elOrdenDePrioridadDebeSer(final String expectedOrder) {
    assertThat(priorityQueueExample.getOrderedElements()).isEqualTo(expectedOrder);
  }

  /**
   * Verifica el orden de prioridad de strings.
   *
   * @param expectedOrder orden esperado separado por comas
   */
  @Then("el orden de prioridad de strings debe ser {string}")
  public void elOrdenDePrioridadDeStringsDebeSer(final String expectedOrder) {
    assertThat(priorityQueueExample.getOrderedStrings()).isEqualTo(expectedOrder);
  }

  /**
   * Verifica que el primer elemento procesado sea el esperado.
   *
   * @param expectedElement elemento esperado
   */
  @Then("el elemento con mayor prioridad procesado debe ser {int}")
  public void elElementoConMayorPrioridadProcesadoDebeSer(final int expectedElement) {
    lastPolledElement = priorityQueueExample.pollElement();
    assertThat(lastPolledElement).isEqualTo(expectedElement);
  }

  /**
   * Verifica que el siguiente elemento procesado sea el esperado.
   *
   * @param expectedElement elemento esperado
   */
  @Then("el siguiente elemento procesado debe ser {int}")
  public void elSiguienteElementoProcesadoDebeSer(final int expectedElement) {
    lastPolledElement = priorityQueueExample.pollElement();
    assertThat(lastPolledElement).isEqualTo(expectedElement);
  }

  /**
   * Verifica que el último elemento procesado sea el esperado.
   *
   * @param expectedElement elemento esperado
   */
  @Then("el último elemento procesado debe ser {int}")
  public void elUltimoElementoProcesadoDebeSer(final int expectedElement) {
    lastPolledElement = priorityQueueExample.pollElement();
    assertThat(lastPolledElement).isEqualTo(expectedElement);
  }

  /** Verifica que la cola esté vacía. */
  @Then("la cola debe estar vacía")
  public void laColaDebeEstarVacia() {
    assertThat(priorityQueueExample.isEmpty()).isTrue();
  }

  /**
   * Verifica que la cola contenga un elemento específico.
   *
   * @param element elemento a verificar
   */
  @Then("la cola debe contener el elemento {int}")
  public void laColaDebeContenerElElemento(final int element) {
    assertThat(priorityQueueExample.contains(element)).isTrue();
  }

  /**
   * Verifica que la cola NO contenga un elemento específico.
   *
   * @param element elemento que no debe existir
   */
  @Then("la cola no debe contener el elemento {int}")
  public void laColaNoDebeContenerElElemento(final int element) {
    assertThat(priorityQueueExample.contains(element)).isFalse();
  }

  /** Verifica que se haya lanzado NullPointerException en la cola. */
  @Then("debe lanzarse NullPointerException en la cola")
  public void debeLanzarseNullPointerExceptionEnLaCola() {
    assertThat(capturedException).isInstanceOf(NullPointerException.class);
  }
}
