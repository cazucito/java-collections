/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de ArrayList.
 */
package io.github.cazucito.collections.list;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;

/**
 * Implementación de los steps para las pruebas de comportamiento de ArrayList.
 *
 * <p>Esta clase conecta los escenarios escritos en Gherkin con el código Java que ejecuta las
 * acciones y verifica los resultados.
 */
public class ArrayListSteps {

  /** Instancia del ejemplo de ArrayList que se está probando. */
  private ArrayListExample listExample;

  /** Resultado de la última operación booleana ejecutada. */
  private boolean lastOperationResult;

  /** Resultado de operación con índice. */
  private int indexResult;

  /** Elemento obtenido de operación. */
  private String retrievedElement;

  /** Sublista obtenida. */
  private List<String> subListResult;

  /** Array obtenido. */
  private String[] arrayResult;

  /**
   * Inicializa un ArrayList vacío.
   *
   * <p>Este step se ejecuta al inicio de los scenarios que requieren una lista vacía.
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

  /** Limpia todos los elementos de la lista. */
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

  /** Verifica que la última operación booleana retornó false. */
  @Then("la operación de segundo agregado debe retornar false")
  public void laOperacionDeSegundoAgregadoDebeRetornarFalse() {
    assertThat(lastOperationResult).isFalse();
  }

  /** Verifica que la lista esté vacía. */
  @Then("la lista debe estar vacía")
  public void laListaDebeEstarVacia() {
    assertThat(listExample.isEmpty()).isTrue();
  }

  /** Ordena la lista alfabéticamente. */
  @When("ordeno la lista alfabéticamente")
  public void ordenoLaListaAlfabeticamente() {
    listExample.sort();
  }

  /** Ordena la lista en orden descendente. */
  @When("ordeno la lista descendentemente")
  public void ordenoLaListaDescendentemente() {
    listExample.sortDescending();
  }

  /**
   * Busca el índice de un elemento.
   *
   * @param element elemento a buscar
   */
  @When("busco el índice del elemento {string}")
  public void buscoElIndiceDelElemento(final String element) {
    indexResult = listExample.indexOf(element);
  }

  /**
   * Busca el último índice de un elemento.
   *
   * @param element elemento a buscar
   */
  @When("busco el último índice del elemento {string}")
  public void buscoElUltimoIndiceDelElemento(final String element) {
    indexResult = listExample.lastIndexOf(element);
  }

  /**
   * Reemplaza un elemento en un índice.
   *
   * @param index índice
   * @param element nuevo elemento
   */
  @When("reemplazo el elemento en índice {int} con {string}")
  public void reemplazoElElementoEnIndiceCon(final int index, final String element) {
    retrievedElement = listExample.setElement(index, element);
  }

  /**
   * Agrega un elemento en un índice específico.
   *
   * @param index índice
   * @param elemento a agregar
   */
  @When("agrego el elemento {string} en el índice {int}")
  public void agregoElElementoEnElIndice(final String element, final int index) {
    listExample.addElementAt(index, element);
  }

  /**
   * Elimina un elemento en un índice específico.
   *
   * @param index índice
   */
  @When("elimino el elemento en el índice {int}")
  public void eliminoElElementoEnElIndice(final int index) {
    retrievedElement = listExample.removeElementAt(index);
  }

  /**
   * Obtiene una sublista.
   *
   * @param from índice inicial
   * @param to índice final
   */
  @When("obtengo la sublista desde el índice {int} hasta el {int}")
  public void obtengoLaSublistaDesdeElIndiceHastaEl(final int from, final int to) {
    subListResult = listExample.getSubList(from, to);
  }

  /** Convierte la lista a array. */
  @When("convierto la lista a array")
  public void conviertoLaListaAArray() {
    arrayResult = listExample.toArray();
  }

  /**
   * Verifica que el índice encontrado sea el esperado.
   *
   * @param expected índice esperado
   */
  @Then("el índice encontrado debe ser {int}")
  public void elIndiceEncontradoDebeSer(final int expected) {
    assertThat(indexResult).isEqualTo(expected);
  }

  /** Verifica que el índice sea -1 (no encontrado). */
  @Then("el índice debe ser -1 indicando que no existe")
  public void elIndiceDebeSerMenosUnoIndicandoQueNoExiste() {
    assertThat(indexResult).isEqualTo(-1);
  }

  /**
   * Verifica que el elemento obtenido sea el esperado.
   *
   * @param expected elemento esperado
   */
  @Then("el elemento obtenido debe ser {string}")
  public void elElementoObtenidoDebeSer(final String expected) {
    assertThat(retrievedElement).isEqualTo(expected);
  }

  /**
   * Verifica que la sublista tenga el tamaño esperado.
   *
   * @param expected tamaño esperado
   */
  @Then("el tamaño de la sublista debe ser {int}")
  public void elTamanoDeLaSublistaDebeSer(final int expected) {
    assertThat(subListResult.size()).isEqualTo(expected);
  }

  /**
   * Verifica que la sublista contenga un elemento.
   *
   * @param element elemento esperado
   */
  @Then("la sublista debe contener {string}")
  public void laSublistaDebeContener(final String element) {
    assertThat(subListResult).contains(element);
  }

  /**
   * Verifica que el array tenga el tamaño esperado.
   *
   * @param expected tamaño esperado
   */
  @Then("el tamaño del array debe ser {int}")
  public void elTamanoDelArrayDebeSer(final int expected) {
    assertThat(arrayResult.length).isEqualTo(expected);
  }

  /**
   * Verifica que el array contenga un elemento en posición.
   *
   * @param index índice
   * @param element elemento esperado
   */
  @Then("el array en posición {int} debe ser {string}")
  public void elArrayEnPosicionDebeSer(final int index, final String element) {
    assertThat(arrayResult[index]).isEqualTo(element);
  }
}
