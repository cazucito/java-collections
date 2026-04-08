/**
 * Copyright 2024 cazucito
 * SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de ArrayList.
 */
package io.github.cazucito.collections.list;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Implementación de los steps para las pruebas de comportamiento de ArrayList.
 *
 * <p>Esta clase conecta los escenarios escritos en Gherkin con el código Java
 * que ejecuta las acciones y verifica los resultados.
 */
public class ArrayListSteps {

  /** Instancia del ejemplo de ArrayList que se está probando. */
  private ArrayListExample listExample;

  /** Resultado de la última operación booleana ejecutada. */
  private boolean lastOperationResult;

  /**
   * Inicializa un ArrayList vacío.
   *
   * <p>Este step se ejecuta al inicio de los scenarios que requieren
   * una lista vacía.
   */
  @Given("un ArrayList vacío")
  public void unArrayListVacio() {
    listExample = new ArrayListExample();
  }

  /**
   * Agrega un elemento a la lista usando el método addElement.
   *
   * @param element el elemento a agregar
   */
  @When("agrego el elemento {string}")
  public void agregoElElemento(final String element) {
    listExample.addElement(element);
  }

  /**
   * Agrega un elemento único a la lista y guarda el resultado.
   *
   * @param element el elemento a agregar
   */
  @When("agrego el elemento único {string}")
  public void agregoElElementoUnico(final String element) {
    lastOperationResult = listExample.addUniqueElement(element);
  }

  /**
   * Elimina un elemento de la lista.
   *
   * @param element el elemento a eliminar
   */
  @When("elimino el elemento {string}")
  public void eliminoElElemento(final String element) {
    listExample.removeElement(element);
  }

  /**
   * Limpia todos los elementos de la lista.
   */
  @When("limpio la lista")
  public void limpioLaLista() {
    listExample.clear();
  }

  /**
   * Verifica que el tamaño de la lista sea el esperado.
   *
   * @param expectedSize tamaño esperado
   */
  @Then("el tamaño de la lista debe ser {int}")
  public void elTamanoDeLaListaDebeSer(final int expectedSize) {
    assertThat(listExample.size()).isEqualTo(expectedSize);
  }

  /**
   * Verifica que un elemento exista en la lista.
   *
   * @param element elemento a verificar
   */
  @Then("la lista debe contener {string}")
  public void laListaDebeContener(final String element) {
    assertThat(listExample.contains(element)).isTrue();
  }

  /**
   * Verifica que un elemento NO exista en la lista.
   *
   * @param element elemento que no debe existir
   */
  @Then("la lista no debe contener {string}")
  public void laListaNoDebeContener(final String element) {
    assertThat(listExample.contains(element)).isFalse();
  }

  /**
   * Verifica que el elemento en un índice específico sea el esperado.
   *
   * @param index índice a verificar
   * @param expectedElement elemento esperado
   */
  @Then("el elemento en índice {int} debe ser {string}")
  public void elElementoEnIndiceDebeSer(final int index, final String expectedElement) {
    assertThat(listExample.getElement(index)).isEqualTo(expectedElement);
  }

  /**
   * Verifica que la última operación booleana retornó false.
   */
  @Then("la operación de segundo agregado debe retornar false")
  public void laOperacionDeSegundoAgregadoDebeRetornarFalse() {
    assertThat(lastOperationResult).isFalse();
  }

  /**
   * Verifica que la lista esté vacía.
   */
  @Then("la lista debe estar vacía")
  public void laListaDebeEstarVacia() {
    assertThat(listExample.isEmpty()).isTrue();
  }
}
