/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de HashMap.
 */
package io.github.cazucito.collections.map;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Implementación de los steps para las pruebas de comportamiento de HashMap.
 *
 * <p>Esta clase conecta los escenarios escritos en Gherkin con el código Java que ejecuta las
 * acciones y verifica los resultados.
 */
public class HashMapSteps {

  /** Instancia del ejemplo de HashMap que se está probando. */
  private HashMapExample mapExample;

  /** Resultado de la última operación de recuperación/eliminar. */
  private String lastOperationResult;

  /**
   * Inicializa un HashMap vacío.
   *
   * <p>Este step se ejecuta al inicio de los scenarios que requieren un map vacío.
   */
  @Given("un HashMap vacío")
  public void unHashMapVacio() {
    mapExample = new HashMapExample();
  }

  /**
   * Agrega una entrada clave-valor al map.
   *
   * @param key la clave de la entrada
   * @param value el valor asociado
   */
  @When("agrego la entrada {string} -> {string}")
  public void agregoLaEntrada(final String key, final String value) {
    mapExample.putEntry(key, value);
  }

  /**
   * Agrega una entrada con clave null al map.
   *
   * @param value el valor asociado a null
   */
  @When("agrego la entrada null -> {string}")
  public void agregoLaEntradaConClaveNull(final String value) {
    mapExample.putEntry(null, value);
  }

  /**
   * Agrega una entrada con valor null al map.
   *
   * @param key la clave del elemento
   */
  @When("agrego la entrada {string} -> null")
  public void agregoLaEntradaConValorNull(final String key) {
    mapExample.putEntry(key, null);
  }

  /**
   * Actualiza una entrada existente en el map.
   *
   * @param key la clave a actualizar
   * @param value el nuevo valor
   */
  @When("actualizo la entrada {string} -> {string}")
  public void actualizoLaEntrada(final String key, final String value) {
    lastOperationResult = mapExample.putEntry(key, value);
  }

  /**
   * Elimina una entrada del map por su clave.
   *
   * @param key la clave de la entrada a eliminar
   */
  @When("elimino la entrada con clave {string}")
  public void eliminoLaEntradaConClave(final String key) {
    lastOperationResult = mapExample.removeEntry(key);
  }

  /** Limpia todas las entradas del map. */
  @When("limpio el map")
  public void limpioElMap() {
    mapExample.clear();
  }

  /**
   * Verifica que el tamaño del map sea el esperado.
   *
   * @param expectedSize tamaño esperado
   */
  @Then("el tamaño del map debe ser {int}")
  public void elTamanoDelMapDebeSer(final int expectedSize) {
    assertThat(mapExample.size()).isEqualTo(expectedSize);
  }

  /**
   * Verifica que una clave exista en el map.
   *
   * @param key clave a verificar
   */
  @Then("el map debe contener la clave {string}")
  public void elMapDebeContenerLaClave(final String key) {
    assertThat(mapExample.containsKey(key)).isTrue();
  }

  /**
   * Verifica que una clave NO exista en el map.
   *
   * @param key clave que no debe existir
   */
  @Then("el map no debe contener la clave {string}")
  public void elMapNoDebeContenerLaClave(final String key) {
    assertThat(mapExample.containsKey(key)).isFalse();
  }

  /**
   * Verifica que un valor exista en el map.
   *
   * @param value valor a verificar
   */
  @Then("el map debe contener el valor {string}")
  public void elMapDebeContenerElValor(final String value) {
    assertThat(mapExample.containsValue(value)).isTrue();
  }

  /**
   * Verifica que un valor NO exista en el map.
   *
   * @param value valor que no debe existir
   */
  @Then("el map no debe contener el valor {string}")
  public void elMapNoDebeContenerElValor(final String value) {
    assertThat(mapExample.containsValue(value)).isFalse();
  }

  /**
   * Verifica que el valor para una clave sea el esperado.
   *
   * @param key clave a consultar
   * @param expectedValue valor esperado
   */
  @Then("el valor para la clave {string} debe ser {string}")
  public void elValorParaLaClaveDebeSer(final String key, final String expectedValue) {
    assertThat(mapExample.getValue(key)).isEqualTo(expectedValue);
  }

  /**
   * Verifica que el valor para una clave sea null.
   *
   * @param key clave a consultar
   */
  @Then("el valor para la clave {string} debe ser null")
  public void elValorParaLaClaveDebeSerNull(final String key) {
    assertThat(mapExample.getValue(key)).isNull();
  }

  /**
   * Verifica que el valor para clave null sea el esperado.
   *
   * @param expectedValue valor esperado para clave null
   */
  @Then("el valor para la clave null debe ser {string}")
  public void elValorParaLaClaveNullDebeSer(final String expectedValue) {
    assertThat(mapExample.getValue(null)).isEqualTo(expectedValue);
  }

  /** Verifica que el map esté vacío. */
  @Then("el map debe estar vacío")
  public void elMapDebeEstarVacio() {
    assertThat(mapExample.isEmpty()).isTrue();
  }
}
