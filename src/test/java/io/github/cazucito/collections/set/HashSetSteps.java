/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de HashSet.
 */
package io.github.cazucito.collections.set;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Implementación de los steps para las pruebas de comportamiento de HashSet.
 *
 * <p>Esta clase conecta los escenarios escritos en Gherkin con el código Java que ejecuta las
 * acciones y verifica los resultados.
 */
public class HashSetSteps {

  /** Instancia del ejemplo de HashSet que se está probando. */
  private HashSetExample setExample;

  /** Resultado de la última operación booleana ejecutada. */
  private boolean lastOperationResult;

  /**
   * Inicializa un HashSet vacío.
   *
   * <p>Este step se ejecuta al inicio de los scenarios que requieren un set vacío.
   */
  @Given("un HashSet vacío")
  public void unHashSetVacio() {
    setExample = new HashSetExample();
  }

  /**
   * Agrega un elemento al set usando el método addElement.
   *
   * @param element el elemento a agregar
   */
  @When("agrego el elemento {string} al set")
  public void agregoElElementoAlSet(final String element) {
    lastOperationResult = setExample.addElement(element);
  }

  /** Agrega un elemento null al set. */
  @When("agrego el elemento null al set")
  public void agregoElElementoNullAlSet() {
    lastOperationResult = setExample.addElement(null);
  }

  /**
   * Elimina un elemento del set.
   *
   * @param element el elemento a eliminar
   */
  @When("elimino el elemento {string} del set")
  public void eliminoElElementoDelSet(final String element) {
    lastOperationResult = setExample.removeElement(element);
  }

  /** Limpia todos los elementos del set. */
  @When("limpio el set")
  public void limpioElSet() {
    setExample.clear();
  }

  /**
   * Verifica que el tamaño del set sea el esperado.
   *
   * @param expectedSize tamaño esperado
   */
  @Then("el tamaño del set debe ser {int}")
  public void elTamanoDelSetDebeSer(final int expectedSize) {
    assertThat(setExample.size()).isEqualTo(expectedSize);
  }

  /**
   * Verifica que un elemento exista en el set.
   *
   * @param element elemento a verificar
   */
  @Then("el set debe contener {string}")
  public void elSetDebeContener(final String element) {
    assertThat(setExample.contains(element)).isTrue();
  }

  /** Verifica que null exista en el set. */
  @Then("el set debe contener null")
  public void elSetDebeContenerNull() {
    assertThat(setExample.contains(null)).isTrue();
  }

  /**
   * Verifica que un elemento NO exista en el set.
   *
   * @param element elemento que no debe existir
   */
  @Then("el set no debe contener {string}")
  public void elSetNoDebeContener(final String element) {
    assertThat(setExample.contains(element)).isFalse();
  }

  /**
   * Verifica que solo exista una ocurrencia de un elemento.
   *
   * <p>En un HashSet, por definición, solo puede haber una ocurrencia de cada elemento.
   *
   * @param element elemento a verificar
   */
  @Then("solo existe una ocurrencia de {string}")
  public void soloExisteUnaOcurrenciaDe(final String element) {
    // En un Set solo puede existir una ocurrencia de cada elemento
    assertThat(setExample.contains(element)).isTrue();
    // Verificamos que el tamaño sea 1, lo que garantiza no hay duplicados
    assertThat(setExample.size()).isEqualTo(1);
  }

  /** Verifica que el set esté vacío. */
  @Then("el set debe estar vacío")
  public void elSetDebeEstarVacio() {
    assertThat(setExample.isEmpty()).isTrue();
  }
}
