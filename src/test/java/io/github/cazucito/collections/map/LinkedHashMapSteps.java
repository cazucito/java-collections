/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de LinkedHashMap.
 */
package io.github.cazucito.collections.map;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Implementación de los steps para las pruebas de comportamiento de LinkedHashMap.
 *
 * <p>Esta clase conecta los escenarios escritos en Gherkin con el código Java que ejecuta las
 * acciones y verifica los resultados.
 */
public class LinkedHashMapSteps {

  /** Instancia del ejemplo de LinkedHashMap que se está probando. */
  private LinkedHashMapExample linkedHashMapExample;

  /** Resultado de la última operación de put/remove. */
  private String lastOperationResult;

  /**
   * Inicializa un LinkedHashMap vacío.
   *
   * <p>Este step se ejecuta al inicio de los scenarios que requieren un map vacío.
   */
  @Given("un LinkedHashMap vacío")
  public void unLinkedHashMapVacio() {
    linkedHashMapExample = new LinkedHashMapExample();
    lastOperationResult = null;
  }

  /**
   * Agrega una entrada clave-valor al linkedhashmap.
   *
   * @param key la clave de la entrada (puede ser null)
   * @param value el valor asociado (puede ser null)
   */
  @When("agrego la entrada al linkedhashmap {string} -> {string}")
  public void agregoLaEntradaAlLinkedHashmap(final String key, final String value) {
    lastOperationResult = linkedHashMapExample.putEntry(key, value);
  }

  /**
   * Agrega una entrada con clave null al linkedhashmap.
   *
   * @param value el valor asociado a null
   */
  @When("agrego la entrada al linkedhashmap null -> {string}")
  public void agregoLaEntradaAlLinkedHashmapConKeyNull(final String value) {
    lastOperationResult = linkedHashMapExample.putEntry(null, value);
  }

  /**
   * Agrega una entrada con valor null al linkedhashmap.
   *
   * @param key la clave asociada
   */
  @When("agrego la entrada al linkedhashmap {string} -> null")
  public void agregoLaEntradaAlLinkedHashmapConValueNull(final String key) {
    lastOperationResult = linkedHashMapExample.putEntry(key, null);
  }

  /**
   * Elimina una entrada del linkedhashmap por su clave.
   *
   * @param key la clave de la entrada a eliminar
   */
  @When("elimino la entrada del linkedhashmap con clave {string}")
  public void eliminoLaEntradaDelLinkedHashmapConClave(final String key) {
    lastOperationResult = linkedHashMapExample.removeEntry(key);
  }

  /** Limpia todas las entradas del linkedhashmap. */
  @When("limpio el linkedhashmap")
  public void limpioElLinkedHashmap() {
    linkedHashMapExample.clear();
  }

  /**
   * Verifica que el tamaño del linkedhashmap sea el esperado.
   *
   * @param expectedSize tamaño esperado
   */
  @Then("el tamaño del linkedhashmap debe ser {int}")
  public void elTamanoDelLinkedHashmapDebeSer(final int expectedSize) {
    assertThat(linkedHashMapExample.size()).isEqualTo(expectedSize);
  }

  /** Verifica que el linkedhashmap esté vacío. */
  @Then("el linkedhashmap debe estar vacío")
  public void elLinkedHashmapDebeEstarVacio() {
    assertThat(linkedHashMapExample.isEmpty()).isTrue();
  }

  /**
   * Verifica que el orden de inserción de claves sea el esperado.
   *
   * @param expectedKeys claves esperadas separadas por coma
   */
  @Then("el orden de inserción de claves debe ser {string}")
  public void elOrdenDeInsercionDeClavesDebeSer(final String expectedKeys) {
    assertThat(linkedHashMapExample.getOrderedKeys()).isEqualTo(expectedKeys);
  }

  /**
   * Verifica que el orden de inserción de valores sea el esperado.
   *
   * @param expectedValues valores esperados separados por coma
   */
  @Then("el orden de inserción de valores debe ser {string}")
  public void elOrdenDeInsercionDeValoresDebeSer(final String expectedValues) {
    assertThat(linkedHashMapExample.getOrderedValues()).isEqualTo(expectedValues);
  }

  /**
   * Verifica el valor para una clave específica.
   *
   * @param key clave a consultar
   * @param expectedValue valor esperado
   */
  @Then("el valor en linkedhashmap para la clave {string} es {string}")
  public void elValorEnLinkedHashmapParaLaClaveEs(final String key, final String expectedValue) {
    assertThat(linkedHashMapExample.getValue(key)).isEqualTo(expectedValue);
  }

  /**
   * Verifica el valor para la clave null.
   *
   * @param expectedValue valor esperado
   */
  @Then("el valor en linkedhashmap para la clave null es {string}")
  public void elValorEnLinkedHashmapParaLaClaveNullEs(final String expectedValue) {
    assertThat(linkedHashMapExample.getValue(null)).isEqualTo(expectedValue);
  }

  /**
   * Verifica que el linkedhashmap contenga una clave específica.
   *
   * @param key clave a verificar
   */
  @Then("el linkedhashmap contiene la clave {string}")
  public void elLinkedHashmapContieneLaClave(final String key) {
    assertThat(linkedHashMapExample.containsKey(key)).isTrue();
  }

  /** Verifica que el linkedhashmap contenga la clave null. */
  @Then("el linkedhashmap contiene la clave null")
  public void elLinkedHashmapContieneLaClaveNull() {
    assertThat(linkedHashMapExample.containsKey(null)).isTrue();
  }

  /**
   * Verifica que el linkedhashmap NO contenga una clave específica.
   *
   * @param key clave que no debe existir
   */
  @Then("el linkedhashmap no contiene la clave {string}")
  public void elLinkedHashmapNoContieneLaClave(final String key) {
    assertThat(linkedHashMapExample.containsKey(key)).isFalse();
  }

  /**
   * Verifica que el linkedhashmap contenga un valor específico.
   *
   * @param value valor a verificar
   */
  @Then("el linkedhashmap contiene el valor {string}")
  public void elLinkedHashmapContieneElValor(final String value) {
    assertThat(linkedHashMapExample.containsValue(value)).isTrue();
  }

  /** Verifica que el linkedhashmap contenga el valor null. */
  @Then("el linkedhashmap contiene el valor null")
  public void elLinkedHashmapContieneElValorNull() {
    assertThat(linkedHashMapExample.containsValue(null)).isTrue();
  }
}
