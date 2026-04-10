/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de Streams API.
 */
package io.github.cazucito.collections.stream;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;

/**
 * Implementación de los steps para las pruebas de comportamiento de Streams API.
 *
 * <p>Esta clase conecta los escenarios escritos en Gherkin con el código Java que ejecuta las
 * operaciones de Streams y verifica los resultados.
 */
public class StreamSteps {

  /** Instancia del ejemplo de Streams que se está probando. */
  private StreamExample streamExample;

  /** Resultado de operaciones numéricas. */
  private int intResult;

  /** Resultado de operaciones de conteo. */
  private long longResult;

  /** Resultado de operaciones booleanas. */
  private boolean booleanResult;

  /** Resultado de operaciones de strings. */
  private String stringResult;

  /** Resultado de agrupación. */
  private Map<Integer, List<String>> groupingResult;

  /**
   * Inicializa con una lista de números.
   *
   * @param numbers lista de números separados por coma
   */
  @Given("una lista de números {string}")
  public void unaListaDeNumeros(final String numbers) {
    streamExample = new StreamExample();
    streamExample.initializeWithNumbers(numbers);
  }

  /**
   * Inicializa con una lista de strings.
   *
   * @param strings lista de strings separados por coma
   */
  @Given("una lista de nombres {string}")
  public void unaListaDeNombres(final String strings) {
    streamExample = new StreamExample();
    streamExample.initializeWithStrings(strings);
  }

  /**
   * Inicializa con una lista de palabras.
   *
   * @param words lista de palabras separadas por coma
   */
  @Given("una lista de palabras {string}")
  public void unaListaDePalabras(final String words) {
    streamExample = new StreamExample();
    streamExample.initializeWithStrings(words);
  }

  /**
   * Inicializa con una lista desordenada.
   *
   * @param strings lista desordenada
   */
  @Given("una lista desordenada {string}")
  public void unaListaDesordenada(final String strings) {
    streamExample = new StreamExample();
    streamExample.initializeWithStrings(strings);
  }

  /**
   * Inicializa con lista con duplicados.
   *
   * @param strings lista con duplicados
   */
  @Given("una lista con duplicados {string}")
  public void unaListaConDuplicados(final String strings) {
    streamExample = new StreamExample();
    streamExample.initializeWithStrings(strings);
  }

  /**
   * Filtra números mayores a un valor.
   *
   * @param threshold umbral
   */
  @When("filtro los números mayores a {int}")
  public void filtroLosNumerosMayoresA(final int threshold) {
    stringResult = streamExample.filterNumbersGreaterThan(threshold);
  }

  /**
   * Filtra strings que comienzan con prefijo.
   *
   * @param prefix prefijo
   */
  @When("filtro los nombres que comienzan con {string}")
  public void filtroLosNombresQueComienzanCon(final String prefix) {
    stringResult = streamExample.filterStringsStartingWith(prefix);
  }

  /** Multiplica cada número por 2. */
  @When("multiplico cada número por 2")
  public void multiplicoCadaNumeroPor2() {
    stringResult = streamExample.multiplyBy(2);
  }

  /** Convierte a mayúsculas. */
  @When("convierto todos a mayúsculas")
  public void conviertoTodosAMayusculas() {
    stringResult = streamExample.toUpperCase();
  }

  /** Obtiene longitudes de strings. */
  @When("obtengo la longitud de cada palabra")
  public void obtengoLaLongitudDeCadaPalabra() {
    stringResult = streamExample.getStringLengths();
  }

  /** Suma todos los elementos. */
  @When("sumo todos los elementos")
  public void sumoTodosLosElementos() {
    intResult = streamExample.sumAll();
  }

  /** Busca el valor máximo. */
  @When("busco el valor máximo")
  public void buscoElValorMaximo() {
    intResult = streamExample.findMax();
  }

  /** Busca el valor mínimo. */
  @When("busco el valor mínimo")
  public void buscoElValorMinimo() {
    intResult = streamExample.findMin();
  }

  /** Filtra pares y convierte a lista. */
  @When("filtro los números pares y convierto a lista")
  public void filtroLosNumerosParesYConviertoALista() {
    stringResult = streamExample.filterEvensToList();
  }

  /** Convierte a set. */
  @When("convierto a set")
  public void conviertoASet() {
    stringResult = streamExample.toSet();
  }

  /** Ordena alfabéticamente. */
  @When("ordeno alfabéticamente")
  public void ordenoAlfabeticamente() {
    stringResult = streamExample.sortAlphabetically();
  }

  /** Ordena descendente. */
  @When("ordeno descendente")
  public void ordenoDescendente() {
    stringResult = streamExample.sortDescending();
  }

  /** Elimina duplicados. */
  @When("elimino duplicados")
  public void eliminoDuplicados() {
    stringResult = streamExample.distinct();
  }

  /**
   * Limita a n elementos.
   *
   * @param limit cantidad límite
   */
  @When("limito a los primeros {int} elementos")
  public void limitoALosPrimerosElementos(final int limit) {
    stringResult = streamExample.limit(limit);
  }

  /**
   * Salta los primeros n elementos.
   *
   * @param skip cantidad a saltar
   */
  @When("salto los primeros {int} elementos")
  public void saltoLosPrimerosElementos(final int skip) {
    stringResult = streamExample.skip(skip);
  }

  /** Verifica si todos son pares. */
  @When("verifico si todos son pares")
  public void verificoSiTodosSonPares() {
    booleanResult = streamExample.allEven();
  }

  /** Verifica si alguno es par. */
  @When("verifico si alguno es par")
  public void verificoSiAlgunoEsPar() {
    booleanResult = streamExample.anyEven();
  }

  /** Verifica si ninguno es par. */
  @When("verifico si ninguno es par")
  public void verificoSiNingunoEsPar() {
    booleanResult = streamExample.noneEven();
  }

  /** Busca el primer número par. */
  @When("busco el primer número par")
  public void buscoElPrimerNumeroPar() {
    stringResult = streamExample.findFirstEven();
  }

  /**
   * Cuenta elementos mayores a un umbral.
   *
   * @param threshold umbral
   */
  @When("cuento los elementos mayores a {int}")
  public void cuentoLosElementosMayoresA(final int threshold) {
    longResult = streamExample.countGreaterThan(threshold);
  }

  /** Pipeline completo: filtrar > 5, multiplicar por 2, ordenar descendente. */
  @When("filtro mayores a 5, multiplico por 2 y ordeno descendente")
  public void filtroMayoresAMultiplicoPor2YOrdenoDescendente() {
    stringResult = streamExample.filterMultiplySort();
  }

  /** Agrupa por longitud. */
  @When("agrupo por longitud")
  public void agrupoPorLongitud() {
    groupingResult = streamExample.groupByLength();
  }

  /**
   * Verifica el resultado string.
   *
   * @param expected resultado esperado
   */
  @Then("el resultado del stream debe ser {string}")
  public void elResultadoDelStreamDebeSer(final String expected) {
    assertThat(stringResult).isEqualTo(expected);
  }

  /**
   * Verifica el resultado numérico.
   *
   * @param expected resultado esperado
   */
  @Then("el resultado numérico debe ser {string}")
  public void elResultadoNumericoDebeSer(final String expected) {
    assertThat(stringResult).isEqualTo(expected);
  }

  /**
   * Verifica el resultado reducido.
   *
   * @param expected resultado esperado
   */
  @Then("el resultado reducido debe ser {int}")
  public void elResultadoReducidoDebeSer(final int expected) {
    assertThat(intResult).isEqualTo(expected);
  }

  /**
   * Verifica la lista resultante.
   *
   * @param expected lista esperada
   */
  @Then("la lista resultante debe ser {string}")
  public void laListaResultanteDebeSer(final String expected) {
    assertThat(stringResult).isEqualTo(expected);
  }

  /**
   * Verifica el set resultante.
   *
   * @param expected set esperado
   */
  @Then("el set resultante debe contener {string}")
  public void elSetResultanteDebeContener(final String expected) {
    assertThat(stringResult).isEqualTo(expected);
  }

  /**
   * Verifica el resultado booleano.
   *
   * @param expected resultado esperado
   */
  @Then("el resultado booleano debe ser {string}")
  public void elResultadoBooleanoDebeSer(final String expected) {
    assertThat(booleanResult).isEqualTo(Boolean.parseBoolean(expected));
  }

  /**
   * Verifica el resultado opcional.
   *
   * @param expected resultado esperado
   */
  @Then("el resultado opcional debe ser {string}")
  public void elResultadoOpcionalDebeSer(final String expected) {
    assertThat(stringResult).isEqualTo(expected);
  }

  /**
   * Verifica el conteo.
   *
   * @param expected conteo esperado
   */
  @Then("el conteo debe ser {int}")
  public void elConteoDebeSer(final int expected) {
    assertThat(longResult).isEqualTo(expected);
  }

  /**
   * Verifica el grupo de una longitud específica.
   *
   * @param length longitud
   * @param expected elementos esperados
   */
  @Then("el grupo de longitud {int} debe ser {string}")
  public void elGrupoDeLongitudDebeSer(final int length, final String expected) {
    List<String> group = groupingResult.get(length);
    String result = String.join(", ", group);
    assertThat(result).isEqualTo(expected);
  }
}
