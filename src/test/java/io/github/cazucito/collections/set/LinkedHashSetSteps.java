/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de LinkedHashSet.
 */
package io.github.cazucito.collections.set;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Implementación de los steps para las pruebas de comportamiento de LinkedHashSet.
 *
 * <p>Esta clase conecta los escenarios escritos en Gherkin con el código Java que ejecuta las
 * acciones y verifica los resultados.
 */
public class LinkedHashSetSteps {

  /** Instancia del ejemplo de LinkedHashSet que se está probando. */
  private LinkedHashSetExample linkedHashSetExample;

  /** Resultado de la última operación de add. */
  private boolean lastAddResult;

  /**
   * Inicializa un LinkedHashSet vacío.
   *
   * <p>Este step se ejecuta al inicio de los scenarios que requieren un set vacío.
   */
  @Given("un LinkedHashSet vacío")
  public void unLinkedHashSetVacio() {
    linkedHashSetExample = new LinkedHashSetExample();
    lastAddResult = false;
  }

  /**
   * Agrega un elemento al linkedhashset.
   *
   * @param element el elemento a agregar
   */
  @When("agrego el elemento {string} al linkedhashset")
  public void agregoElElementoAlLinkedHashset(final String element) {
    lastAddResult = linkedHashSetExample.addElement(element);
  }

  /** Agrega null al linkedhashset. */
  @When("agrego el elemento null al linkedhashset")
  public void agregoElElementoNullAlLinkedHashset() {
    lastAddResult = linkedHashSetExample.addElement(null);
  }

  /**
   * Elimina un elemento del linkedhashset.
   *
   * @param element el elemento a eliminar
   */
  @When("elimino el elemento {string} del linkedhashset")
  public void eliminoElElementoDelLinkedHashset(final String element) {
    linkedHashSetExample.removeElement(element);
  }

  /** Limpia todos los elementos del linkedhashset. */
  @When("limpio el linkedhashset")
  public void limpioElLinkedHashset() {
    linkedHashSetExample.clear();
  }

  /**
   * Verifica que el tamaño del linkedhashset sea el esperado.
   *
   * @param expectedSize tamaño esperado
   */
  @Then("el tamaño del linkedhashset debe ser {int}")
  public void elTamanoDelLinkedHashsetDebeSer(final int expectedSize) {
    assertThat(linkedHashSetExample.size()).isEqualTo(expectedSize);
  }

  /** Verifica que el linkedhashset esté vacío. */
  @Then("el linkedhashset debe estar vacío")
  public void elLinkedHashsetDebeEstarVacio() {
    assertThat(linkedHashSetExample.isEmpty()).isTrue();
  }

  /**
   * Verifica que el orden de inserción sea el esperado.
   *
   * @param expectedOrder orden esperado separado por comas
   */
  @Then("el orden de inserción debe ser {string}")
  public void elOrdenDeInsercionDebeSer(final String expectedOrder) {
    assertThat(linkedHashSetExample.getOrderedElements()).isEqualTo(expectedOrder);
  }

  /**
   * Verifica que el linkedhashset contenga un elemento específico.
   *
   * @param element elemento a verificar
   */
  @Then("el linkedhashset contiene el elemento {string}")
  public void elLinkedHashsetContieneElElemento(final String element) {
    assertThat(linkedHashSetExample.contains(element)).isTrue();
  }

  /** Verifica que el linkedhashset contenga null. */
  @Then("el linkedhashset contiene el elemento null")
  public void elLinkedHashsetContieneElElementoNull() {
    assertThat(linkedHashSetExample.containsNull()).isTrue();
  }

  /**
   * Verifica que el linkedhashset NO contenga un elemento específico.
   *
   * @param element elemento que no debe existir
   */
  @Then("el linkedhashset no contiene el elemento {string}")
  public void elLinkedHashsetNoContieneElElemento(final String element) {
    assertThat(linkedHashSetExample.contains(element)).isFalse();
  }
}
