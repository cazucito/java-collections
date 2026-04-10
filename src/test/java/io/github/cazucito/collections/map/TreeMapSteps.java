/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de TreeMap.
 */
package io.github.cazucito.collections.map;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.SortedMap;

/**
 * Implementación de los steps para las pruebas de comportamiento de TreeMap.
 *
 * <p>Esta clase conecta los escenarios escritos en Gherkin con el código Java que ejecuta las
 * acciones y verifica los resultados.
 */
public class TreeMapSteps {

  /** Instancia del ejemplo de TreeMap que se está probando. */
  private TreeMapExample treeMapExample;

  /** Resultado de la última operación de recuperación/eliminar. */
  private String lastOperationResult;

  /** Excepción capturada en operaciones que lanzan excepciones. */
  private Exception capturedException;

  /**
   * Inicializa un TreeMap vacío.
   *
   * <p>Este step se ejecuta al inicio de los scenarios que requieren un map vacío.
   */
  @Given("un TreeMap vacío")
  public void unTreeMapVacio() {
    treeMapExample = new TreeMapExample();
    capturedException = null;
  }

  /**
   * Agrega una entrada clave-valor al treemap.
   *
   * @param key la clave de la entrada
   * @param value el valor asociado
   */
  @When("agrego la entrada al treemap {string} -> {string}")
  public void agregoLaEntradaAlTreemap(final String key, final String value) {
    lastOperationResult = treeMapExample.putEntry(key, value);
  }

  /** Intenta agregar una entrada con clave null al treemap. */
  @When("intento agregar la entrada con clave null")
  public void intentoAgregarLaEntradaConClaveNull() {
    try {
      treeMapExample.putEntry(null, "valor");
    } catch (Exception e) {
      capturedException = e;
    }
  }

  /**
   * Elimina una entrada del treemap por su clave.
   *
   * @param key la clave de la entrada a eliminar
   */
  @When("elimino la entrada del treemap con clave {string}")
  public void eliminoLaEntradaDelTreemapConClave(final String key) {
    lastOperationResult = treeMapExample.removeEntry(key);
  }

  /** Limpia todas las entradas del treemap. */
  @When("limpio el treemap")
  public void limpioElTreemap() {
    treeMapExample.clear();
  }

  /**
   * Verifica que el tamaño del treemap sea el esperado.
   *
   * @param expectedSize tamaño esperado
   */
  @Then("el tamaño del treemap debe ser {int}")
  public void elTamanoDelTreemapDebeSer(final int expectedSize) {
    assertThat(treeMapExample.size()).isEqualTo(expectedSize);
  }

  /**
   * Verifica que una clave exista en el treemap.
   *
   * @param key clave a verificar
   */
  @Then("el treemap contiene la clave {string}")
  public void elTreemapContieneLaClave(final String key) {
    assertThat(treeMapExample.containsKey(key)).isTrue();
  }

  /**
   * Verifica que una clave NO exista en el treemap.
   *
   * @param key clave que no debe existir
   */
  @Then("el treemap no contiene la clave {string}")
  public void elTreemapNoContieneLaClave(final String key) {
    assertThat(treeMapExample.containsKey(key)).isFalse();
  }

  /**
   * Verifica que un valor exista en el treemap.
   *
   * @param value valor a verificar
   */
  @Then("el treemap contiene el valor {string}")
  public void elTreemapContieneElValor(final String value) {
    assertThat(treeMapExample.containsValue(value)).isTrue();
  }

  /**
   * Verifica que la primera clave sea la esperada.
   *
   * @param expectedKey clave esperada
   */
  @Then("la primera clave del treemap es {string}")
  public void laPrimeraClaveDelTreemapEs(final String expectedKey) {
    assertThat(treeMapExample.getFirstKey()).isEqualTo(expectedKey);
  }

  /**
   * Verifica que el primer valor sea el esperado.
   *
   * @param expectedValue valor esperado
   */
  @Then("el primer valor del treemap es {string}")
  public void elPrimerValorDelTreemapEs(final String expectedValue) {
    assertThat(treeMapExample.getFirstValue()).isEqualTo(expectedValue);
  }

  /**
   * Verifica que la última clave sea la esperada.
   *
   * @param expectedKey clave esperada
   */
  @Then("la última clave del treemap es {string}")
  public void laUltimaClaveDelTreemapEs(final String expectedKey) {
    assertThat(treeMapExample.getLastKey()).isEqualTo(expectedKey);
  }

  /**
   * Verifica que el último valor sea el esperado.
   *
   * @param expectedValue valor esperado
   */
  @Then("el último valor del treemap es {string}")
  public void elUltimoValorDelTreemapEs(final String expectedValue) {
    assertThat(treeMapExample.getLastValue()).isEqualTo(expectedValue);
  }

  /**
   * Verifica que las claves ordenadas sean las esperadas.
   *
   * @param expectedOrderedKeys claves esperadas separadas por coma
   */
  @Then("las claves ordenadas del treemap son {string}")
  public void lasClavesOrdenadasDelTreemapSon(final String expectedOrderedKeys) {
    assertThat(treeMapExample.getOrderedKeys()).isEqualTo(expectedOrderedKeys);
  }

  /**
   * Verifica que las claves menores a un valor sean las esperadas.
   *
   * @param toKey límite exclusivo
   * @param expectedKeys claves esperadas separadas por coma
   */
  @Then("las claves del treemap menores a {string} son {string}")
  public void lasClavesDelTreemapMenoresASon(final String toKey, final String expectedKeys) {
    SortedMap<String, String> headMap = treeMapExample.getHeadMap(toKey);
    assertThat(String.join(", ", headMap.keySet())).isEqualTo(expectedKeys);
  }

  /**
   * Verifica que las claves mayores o iguales a un valor sean las esperadas.
   *
   * @param fromKey límite inclusivo
   * @param expectedKeys claves esperadas separadas por coma
   */
  @Then("las claves del treemap mayores o iguales a {string} son {string}")
  public void lasClavesDelTreemapMayoresOIgualesASon(
      final String fromKey, final String expectedKeys) {
    SortedMap<String, String> tailMap = treeMapExample.getTailMap(fromKey);
    assertThat(String.join(", ", tailMap.keySet())).isEqualTo(expectedKeys);
  }

  /**
   * Verifica que las claves en un rango sean las esperadas.
   *
   * @param fromKey inicio inclusivo
   * @param toKey fin exclusivo
   * @param expectedKeys claves esperadas separadas por coma
   */
  @Then("las claves del treemap entre {string} y {string} son {string}")
  public void lasClavesDelTreemapEntreYSon(
      final String fromKey, final String toKey, final String expectedKeys) {
    SortedMap<String, String> subMap = treeMapExample.getSubMap(fromKey, toKey);
    assertThat(String.join(", ", subMap.keySet())).isEqualTo(expectedKeys);
  }

  /**
   * Verifica que el valor para una clave sea el esperado.
   *
   * @param key clave a consultar
   * @param expectedValue valor esperado
   */
  @Then("el valor en treemap para la clave {string} es {string}")
  public void elValorEnTreemapParaLaClaveEs(final String key, final String expectedValue) {
    assertThat(treeMapExample.getValue(key)).isEqualTo(expectedValue);
  }

  /**
   * Verifica que el valor para una clave sea null.
   *
   * @param key clave a consultar
   */
  @Then("el valor en treemap para la clave {string} es null")
  public void elValorEnTreemapParaLaClaveEsNull(final String key) {
    assertThat(treeMapExample.getValue(key)).isNull();
  }

  /** Verifica que el treemap esté vacío. */
  @Then("el treemap debe estar vacío")
  public void elTreemapDebeEstarVacio() {
    assertThat(treeMapExample.isEmpty()).isTrue();
  }

  /** Verifica que se haya lanzado NullPointerException en treemap. */
  @Then("debe lanzarse NullPointerException en el treemap")
  public void debeLanzarseNullPointerExceptionEnElTreemap() {
    assertThat(capturedException).isInstanceOf(NullPointerException.class);
  }
}
