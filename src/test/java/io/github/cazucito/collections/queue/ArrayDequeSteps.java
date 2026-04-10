/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de ArrayDeque.
 */
package io.github.cazucito.collections.queue;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Implementación de los steps para las pruebas de comportamiento de ArrayDeque.
 *
 * <p>Esta clase conecta los escenarios escritos en Gherkin con el código Java que ejecuta las
 * acciones y verifica los resultados.
 */
public class ArrayDequeSteps {

  /** Instancia del ejemplo de ArrayDeque que se está probando. */
  private ArrayDequeExample arrayDequeExample;

  /** Excepción capturada en operaciones que lanzan excepciones. */
  private Exception capturedException;

  /** Último resultado de operación pop/poll. */
  private String lastOperationResult;

  /**
   * Inicializa un ArrayDeque vacío.
   *
   * <p>Este step se ejecuta al inicio de los scenarios que requieren un deque vacío.
   */
  @Given("un ArrayDeque vacío")
  public void unArrayDequeVacio() {
    arrayDequeExample = new ArrayDequeExample();
    capturedException = null;
    lastOperationResult = null;
  }

  /**
   * Agrega un elemento al inicio del deque.
   *
   * @param element el elemento a agregar
   */
  @When("agrego el elemento {string} al inicio del deque")
  public void agregoElElementoAlInicioDelDeque(final String element) {
    arrayDequeExample.addFirst(element);
  }

  /**
   * Agrega un elemento al inicio (versión corta).
   *
   * @param element el elemento a agregar
   */
  @When("agrego el elemento {string} al inicio")
  public void agregoElElementoAlInicio(final String element) {
    arrayDequeExample.addFirst(element);
  }

  /**
   * Agrega un elemento al final del deque.
   *
   * @param element el elemento a agregar
   */
  @When("agrego el elemento {string} al final del deque")
  public void agregoElElementoAlFinalDelDeque(final String element) {
    arrayDequeExample.addLast(element);
  }

  /**
   * Hace push de un elemento (pila).
   *
   * @param element el elemento a agregar
   */
  @When("hago push del elemento {string}")
  public void hagoPushDelElemento(final String element) {
    arrayDequeExample.push(element);
  }

  /** Hace pop de la pila. */
  @When("hago pop")
  public void hagoPop() {
    lastOperationResult = arrayDequeExample.pop();
  }

  /**
   * Agrega un elemento al final (sinónimo de cola).
   *
   * @param element el elemento a agregar
   */
  @When("agrego el elemento {string} al final")
  public void agregoElElementoAlFinal(final String element) {
    arrayDequeExample.addLast(element);
  }

  /** Procesa (poll) el primer elemento de la cola. */
  @When("proceso el primer elemento")
  public void procesoElPrimerElemento() {
    lastOperationResult = arrayDequeExample.pollFirst();
  }

  /** Elimina el primer elemento. */
  @When("elimino el primer elemento")
  public void eliminoElPrimerElemento() {
    arrayDequeExample.pollFirst();
  }

  /** Elimina el último elemento. */
  @When("elimino el último elemento")
  public void eliminoElUltimoElemento() {
    arrayDequeExample.pollLast();
  }

  /** Limpia todos los elementos del deque. */
  @When("limpio el deque")
  public void limpioElDeque() {
    arrayDequeExample.clear();
  }

  /** Intenta agregar null al inicio. */
  @When("intento agregar null al inicio")
  public void intentoAgregarNullAlInicio() {
    try {
      arrayDequeExample.addFirst(null);
    } catch (Exception e) {
      capturedException = e;
    }
  }

  /**
   * Verifica que el tamaño del deque sea el esperado.
   *
   * @param expectedSize tamaño esperado
   */
  @Then("el tamaño del deque debe ser {int}")
  public void elTamanoDelDequeDebeSer(final int expectedSize) {
    assertThat(arrayDequeExample.size()).isEqualTo(expectedSize);
  }

  /**
   * Verifica que el primer elemento sea el esperado.
   *
   * @param expectedElement elemento esperado
   */
  @Then("el primer elemento del deque debe ser {string}")
  public void elPrimerElementoDelDequeDebeSer(final String expectedElement) {
    assertThat(arrayDequeExample.peekFirst()).isEqualTo(expectedElement);
  }

  /**
   * Verifica que el último elemento sea el esperado.
   *
   * @param expectedElement elemento esperado
   */
  @Then("el último elemento del deque debe ser {string}")
  public void elUltimoElementoDelDequeDebeSer(final String expectedElement) {
    assertThat(arrayDequeExample.peekLast()).isEqualTo(expectedElement);
  }

  /** Verifica que el primer elemento sea null (cola vacía). */
  @Then("el primer elemento del deque debe ser null")
  public void elPrimerElementoDelDequeDebeSerNull() {
    assertThat(arrayDequeExample.peekFirst()).isNull();
  }

  /** Verifica que el último elemento sea null (cola vacía). */
  @Then("el último elemento del deque debe ser null")
  public void elUltimoElementoDelDequeDebeSerNull() {
    assertThat(arrayDequeExample.peekLast()).isNull();
  }

  /**
   * Verifica que el elemento en el tope sea el esperado (pila).
   *
   * @param expectedElement elemento esperado
   */
  @Then("el elemento en el tope debe ser {string}")
  public void elElementoEnElTopeDebeSer(final String expectedElement) {
    assertThat(arrayDequeExample.peekFirst()).isEqualTo(expectedElement);
  }

  /**
   * Verifica el resultado de la última operación pop/poll.
   *
   * @param expectedResult resultado esperado
   */
  @Then("el resultado debe ser {string}")
  public void elResultadoDebeSer(final String expectedResult) {
    assertThat(lastOperationResult).isEqualTo(expectedResult);
  }

  /** Verifica que el deque esté vacío. */
  @Then("el deque debe estar vacío")
  public void elDequeDebeEstarVacio() {
    assertThat(arrayDequeExample.isEmpty()).isTrue();
  }

  /**
   * Verifica que el deque contenga un elemento específico.
   *
   * @param element elemento a verificar
   */
  @Then("el deque debe contener {string}")
  public void elDequeDebeContener(final String element) {
    assertThat(arrayDequeExample.contains(element)).isTrue();
  }

  /**
   * Verifica que el deque NO contenga un elemento específico.
   *
   * @param element elemento que no debe existir
   */
  @Then("el deque no debe contener {string}")
  public void elDequeNoDebeContener(final String element) {
    assertThat(arrayDequeExample.contains(element)).isFalse();
  }

  /**
   * Verifica el orden de los elementos.
   *
   * @param expectedOrder orden esperado separado por comas
   */
  @Then("el orden del deque debe ser {string}")
  public void elOrdenDelDequeDebeSer(final String expectedOrder) {
    assertThat(arrayDequeExample.getElementsInOrder()).isEqualTo(expectedOrder);
  }

  /**
   * Verifica la representación de array.
   *
   * @param expectedArray array esperado en formato [a, b, c]
   */
  @Then("el array resultante debe ser {string}")
  public void elArrayResultanteDebeSer(final String expectedArray) {
    assertThat(arrayDequeExample.toArrayString()).isEqualTo(expectedArray);
  }

  /** Verifica que se haya lanzado NullPointerException. */
  @Then("debe lanzarse NullPointerException en el deque")
  public void debeLanzarseNullPointerExceptionEnElDeque() {
    assertThat(capturedException).isInstanceOf(NullPointerException.class);
  }
}
