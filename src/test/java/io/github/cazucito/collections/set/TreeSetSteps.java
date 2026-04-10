/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de TreeSet.
 */
package io.github.cazucito.collections.set;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.SortedSet;

/**
 * Implementación de los steps para las pruebas de comportamiento de TreeSet.
 *
 * <p>Esta clase conecta los escenarios escritos en Gherkin con el código Java que ejecuta las
 * acciones y verifica los resultados.
 */
public class TreeSetSteps {

  /** Instancia del ejemplo de TreeSet que se está probando. */
  private TreeSetExample treeSetExample;

  /** Resultado de la última operación booleana ejecutada. */
  private boolean lastOperationResult;

  /** Excepción capturada en operaciones que lanzan excepciones. */
  private Exception capturedException;

  /**
   * Inicializa un TreeSet vacío.
   *
   * <p>Este step se ejecuta al inicio de los scenarios que requieren un set vacío.
   */
  @Given("un TreeSet vacío")
  public void unTreeSetVacio() {
    treeSetExample = new TreeSetExample();
    capturedException = null;
  }

  /**
   * Agrega un elemento al treeset.
   *
   * @param element el elemento a agregar
   */
  @When("agrego el elemento {string} al treeset")
  public void agregoElElementoAlTreeset(final String element) {
    lastOperationResult = treeSetExample.addElement(element);
  }

  /** Intenta agregar null al treeset (debe lanzar excepción). */
  @When("intento agregar null al treeset")
  public void intentoAgregarNullAlTreeset() {
    try {
      treeSetExample.addElement(null);
    } catch (Exception e) {
      capturedException = e;
    }
  }

  /**
   * Elimina un elemento del treeset.
   *
   * @param element el elemento a eliminar
   */
  @When("elimino el elemento {string} del treeset")
  public void eliminoElElementoDelTreeset(final String element) {
    lastOperationResult = treeSetExample.removeElement(element);
  }

  /** Limpia todos los elementos del treeset. */
  @When("limpio el treeset")
  public void limpioElTreeset() {
    treeSetExample.clear();
  }

  /**
   * Verifica que el tamaño del treeset sea el esperado.
   *
   * @param expectedSize tamaño esperado
   */
  @Then("el tamaño del treeset debe ser {int}")
  public void elTamanoDelTreesetDebeSer(final int expectedSize) {
    assertThat(treeSetExample.size()).isEqualTo(expectedSize);
  }

  /**
   * Verifica que un elemento exista en el treeset.
   *
   * @param element elemento a verificar
   */
  @Then("el treeset debe contener {string}")
  public void elTreesetDebeContener(final String element) {
    assertThat(treeSetExample.contains(element)).isTrue();
  }

  /**
   * Verifica que un elemento NO exista en el treeset.
   *
   * @param element elemento que no debe existir
   */
  @Then("el treeset no debe contener {string}")
  public void elTreesetNoDebeContener(final String element) {
    assertThat(treeSetExample.contains(element)).isFalse();
  }

  /**
   * Verifica que el primer elemento sea el esperado.
   *
   * @param expectedElement elemento esperado
   */
  @Then("el primer elemento debe ser {string}")
  public void elPrimerElementoDebeSer(final String expectedElement) {
    assertThat(treeSetExample.getFirst()).isEqualTo(expectedElement);
  }

  /**
   * Verifica que el último elemento sea el esperado.
   *
   * @param expectedElement elemento esperado
   */
  @Then("el último elemento debe ser {string}")
  public void elUltimoElementoDebeSer(final String expectedElement) {
    assertThat(treeSetExample.getLast()).isEqualTo(expectedElement);
  }

  /**
   * Verifica que los elementos ordenados sean los esperados.
   *
   * @param expectedOrderedElements elementos esperados separados por coma
   */
  @Then("el treeset ordenado debe ser {string}")
  public void elTreesetOrdenadoDebeSer(final String expectedOrderedElements) {
    assertThat(treeSetExample.getOrderedElements()).isEqualTo(expectedOrderedElements);
  }

  /**
   * Verifica que los elementos menores a un valor sean los esperados.
   *
   * @param toElement límite exclusivo
   * @param expectedElements elementos esperados separados por coma
   */
  @Then("los elementos menores a {string} deben ser {string}")
  public void losElementosMenoresADebenSer(final String toElement, final String expectedElements) {
    SortedSet<String> headSet = treeSetExample.getHeadSet(toElement);
    assertThat(String.join(", ", headSet)).isEqualTo(expectedElements);
  }

  /**
   * Verifica que los elementos mayores o iguales a un valor sean los esperados.
   *
   * @param fromElement límite inclusivo
   * @param expectedElements elementos esperados separados por coma
   */
  @Then("los elementos mayores o iguales a {string} deben ser {string}")
  public void losElementosMayoresOIgualesADebenSer(
      final String fromElement, final String expectedElements) {
    SortedSet<String> tailSet = treeSetExample.getTailSet(fromElement);
    assertThat(String.join(", ", tailSet)).isEqualTo(expectedElements);
  }

  /**
   * Verifica que los elementos en un rango sean los esperados.
   *
   * @param fromElement inicio inclusivo
   * @param toElement fin exclusivo
   * @param expectedElements elementos esperados separados por coma
   */
  @Then("los elementos entre {string} y {string} deben ser {string}")
  public void losElementosEntreYDebenSer(
      final String fromElement, final String toElement, final String expectedElements) {
    SortedSet<String> subSet = treeSetExample.getSubSet(fromElement, toElement);
    assertThat(String.join(", ", subSet)).isEqualTo(expectedElements);
  }

  /** Verifica que el treeset esté vacío. */
  @Then("el treeset debe estar vacío")
  public void elTreesetDebeEstarVacio() {
    assertThat(treeSetExample.isEmpty()).isTrue();
  }

  /** Verifica que se haya lanzado NullPointerException. */
  @Then("debe lanzarse NullPointerException")
  public void debeLanzarseNullPointerException() {
    assertThat(capturedException).isInstanceOf(NullPointerException.class);
  }
}
