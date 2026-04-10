/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de LinkedList.
 */
package io.github.cazucito.collections.list;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Implementación de los steps para las pruebas de comportamiento de LinkedList.
 *
 * <p>Esta clase conecta los escenarios escritos en Gherkin con el código Java que ejecuta las
 * acciones y verifica los resultados.
 */
public class LinkedListSteps {

  /** Instancia del ejemplo de LinkedList que se está probando. */
  private LinkedListExample linkedListExample;

  /** Resultado de la última operación booleana ejecutada. */
  private boolean lastOperationResult;

  /** Elemento obtenido en operaciones de consulta. */
  private String retrievedElement;

  /**
   * Inicializa una LinkedList vacía.
   *
   * <p>Este step se ejecuta al inicio de los scenarios que requieren una lista vacía.
   */
  @Given("una LinkedList vacía")
  public void unaLinkedListVacia() {
    linkedListExample = new LinkedListExample();
  }

  /**
   * Agrega un elemento a la lista.
   *
   * @param element el elemento a agregar
   */
  @When("agrego el elemento {string} a la linked list")
  public void agregoElElementoALaLinkedList(final String element) {
    lastOperationResult = linkedListExample.addElement(element);
  }

  /**
   * Agrega un elemento al inicio de la lista.
   *
   * @param element el elemento a agregar al inicio
   */
  @When("agrego al inicio el elemento {string}")
  public void agregoAlInicioElElemento(final String element) {
    linkedListExample.addFirst(element);
  }

  /**
   * Agrega un elemento al final de la lista.
   *
   * @param element el elemento a agregar al final
   */
  @When("agrego al final el elemento {string}")
  public void agregoAlFinalElElemento(final String element) {
    linkedListExample.addLast(element);
  }

  /** Elimina el primer elemento de la lista. */
  @When("elimino el primer elemento de la linked list")
  public void eliminoElPrimerElementoDeLaLinkedList() {
    retrievedElement = linkedListExample.removeFirst();
  }

  /** Elimina el último elemento de la lista. */
  @When("elimino el último elemento de la linked list")
  public void eliminoElUltimoElementoDeLaLinkedList() {
    retrievedElement = linkedListExample.removeLast();
  }

  /** Obtiene el primer elemento de la lista sin eliminarlo. */
  @When("obtengo el primer elemento de la linked list")
  public void obtengoElPrimerElementoDeLaLinkedList() {
    retrievedElement = linkedListExample.getFirst();
  }

  /** Obtiene el último elemento de la lista sin eliminarlo. */
  @When("obtengo el último elemento de la linked list")
  public void obtengoElUltimoElementoDeLaLinkedList() {
    retrievedElement = linkedListExample.getLast();
  }

  /**
   * Elimina un elemento de la lista.
   *
   * @param element el elemento a eliminar
   */
  @When("elimino el elemento {string} de la linked list")
  public void eliminoElElementoDeLaLinkedList(final String element) {
    lastOperationResult = linkedListExample.removeElement(element);
  }

  /** Limpia todos los elementos de la lista. */
  @When("limpio la linked list")
  public void limpioLaLinkedList() {
    linkedListExample.clear();
  }

  /**
   * Verifica que el tamaño de la lista sea el esperado.
   *
   * @param expectedSize tamaño esperado
   */
  @Then("el tamaño de la linked list debe ser {int}")
  public void elTamanoDeLaLinkedListDebeSer(final int expectedSize) {
    assertThat(linkedListExample.size()).isEqualTo(expectedSize);
  }

  /**
   * Verifica que un elemento exista en la lista.
   *
   * @param element elemento a verificar
   */
  @Then("la linked list debe contener {string}")
  public void laLinkedListDebeContener(final String element) {
    assertThat(linkedListExample.contains(element)).isTrue();
  }

  /**
   * Verifica que un elemento NO exista en la lista.
   *
   * @param element elemento que no debe existir
   */
  @Then("la linked list no debe contener {string}")
  public void laLinkedListNoDebeContener(final String element) {
    assertThat(linkedListExample.contains(element)).isFalse();
  }

  /**
   * Verifica que el elemento en un índice específico sea el esperado.
   *
   * @param index índice a verificar
   * @param expectedElement elemento esperado
   */
  @Then("el elemento en índice {int} de la linked list debe ser {string}")
  public void elElementoEnIndiceDeLaLinkedListDebeSer(
      final int index, final String expectedElement) {
    assertThat(linkedListExample.getElement(index)).isEqualTo(expectedElement);
  }

  /**
   * Verifica que el primer elemento obtenido sea el esperado.
   *
   * @param expectedElement elemento esperado
   */
  @Then("el primer elemento obtenido debe ser {string}")
  public void elPrimerElementoObtenidoDebeSer(final String expectedElement) {
    assertThat(retrievedElement).isEqualTo(expectedElement);
  }

  /**
   * Verifica que el último elemento obtenido sea el esperado.
   *
   * @param expectedElement elemento esperado
   */
  @Then("el último elemento obtenido debe ser {string}")
  public void elUltimoElementoObtenidoDebeSer(final String expectedElement) {
    assertThat(retrievedElement).isEqualTo(expectedElement);
  }

  /** Verifica que la lista esté vacía. */
  @Then("la linked list debe estar vacía")
  public void laLinkedListDebeEstarVacia() {
    assertThat(linkedListExample.isEmpty()).isTrue();
  }
}
