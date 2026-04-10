/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para los scenarios de comparadores personalizados.
 */
package io.github.cazucito.collections.comparator;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * Implementación de los steps para pruebas de comparadores personalizados.
 *
 * <p>Esta clase conecta los escenarios de ordenamiento custom con el código Java.
 */
public class CustomComparatorSteps {

  /** Instancia del ejemplo de comparadores. */
  private CustomComparatorExample comparatorExample;

  /** Elementos a agregar. */
  private String[] elements;

  /** Claves para map. */
  private String[] keys;

  /** Valores para map. */
  private Integer[] values;

  /** Nombres de personas. */
  private String[] personNames;

  /** Edades de personas. */
  private int[] personAges;

  /** Resultado de operación como string. */
  private String resultString;

  /** Resultado numérico. */
  private int resultInt;

  /** Inicializa el ejemplo de comparadores. */
  @Given("un ejemplo de comparadores personalizados")
  public void unEjemploDeComparadoresPersonalizados() {
    comparatorExample = new CustomComparatorExample();
  }

  /**
   * Define los elementos a usar.
   *
   * @param elementsString elementos separados por coma
   */
  @Given("los elementos {string}")
  public void losElementos(final String elementsString) {
    this.elements = elementsString.split(", ");
  }

  /**
   * Define claves y valores para map.
   *
   * @param keysString claves separadas por coma
   * @param valuesString valores separados por coma
   */
  @Given("las claves {string} con valores {string}")
  public void lasClavesConValores(final String keysString, final String valuesString) {
    this.keys = keysString.split(", ");
    String[] valueStrings = valuesString.split(", ");
    this.values = new Integer[valueStrings.length];
    for (int i = 0; i < valueStrings.length; i++) {
      this.values[i] = Integer.parseInt(valueStrings[i]);
    }
  }

  /**
   * Define personas con nombres y edades.
   *
   * @param namesString nombres separados por coma
   * @param agesString edades separadas por coma
   */
  @Given("personas con nombres {string} y edades {string}")
  public void personasConNombresYEdades(final String namesString, final String agesString) {
    this.personNames = namesString.split(", ");
    String[] ageStrings = agesString.split(", ");
    this.personAges = new int[ageStrings.length];
    for (int i = 0; i < ageStrings.length; i++) {
      this.personAges[i] = Integer.parseInt(ageStrings[i]);
    }
  }

  /** Agrega elementos al TreeSet natural. */
  @When("agrego los elementos al TreeSet con ordenamiento natural")
  public void agregoLosElementosAlTreeSetConOrdenamientoNatural() {
    comparatorExample.addToNaturalOrderSet(elements);
  }

  /** Agrega elementos al TreeSet inverso. */
  @When("agrego los elementos al TreeSet con ordenamiento inverso")
  public void agregoLosElementosAlTreeSetConOrdenamientoInverso() {
    comparatorExample.addToReverseOrderSet(elements);
  }

  /** Agrega elementos al TreeSet por longitud. */
  @When("agrego los elementos al TreeSet ordenado por longitud")
  public void agregoLosElementosAlTreeSetOrdenadoPorLongitud() {
    comparatorExample.addToLengthOrderSet(elements);
  }

  /** Agrega elementos al TreeSet case-insensitive. */
  @When("agrego los elementos al TreeSet con ordenamiento case-insensitive")
  public void agregoLosElementosAlTreeSetConOrdenamientoCaseInsensitive() {
    comparatorExample.addToCaseInsensitiveSet(elements);
  }

  /** Agrega entradas al TreeMap inverso. */
  @When("agrego las entradas al TreeMap con ordenamiento inverso de claves")
  public void agregoLasEntradasAlTreeMapConOrdenamientoInversoDeClaves() {
    comparatorExample.addToReverseOrderMap(keys, values);
  }

  /** Agrega personas ordenadas por edad. */
  @When("agrego las personas ordenadas por edad")
  public void agregoLasPersonasOrdenadasPorEdad() {
    comparatorExample.addPersonsByAge(personNames, personAges);
  }

  /** Agrega personas ordenadas por nombre. */
  @When("agrego las personas ordenadas por nombre")
  public void agregoLasPersonasOrdenadasPorNombre() {
    comparatorExample.addPersonsByName(personNames, personAges);
  }

  /** Obtiene el orden natural del set. */
  @When("obtengo el orden natural del TreeSet")
  public void obtengoElOrdenNaturalDelTreeSet() {
    resultString = comparatorExample.getNaturalOrderSetAsString();
  }

  /** Obtiene el orden inverso del set. */
  @When("obtengo el orden inverso del TreeSet")
  public void obtengoElOrdenInversoDelTreeSet() {
    resultString = comparatorExample.getReverseOrderSetAsString();
  }

  /** Obtiene el orden por longitud. */
  @When("obtengo el orden por longitud del TreeSet")
  public void obtengoElOrdenPorLongitudDelTreeSet() {
    resultString = comparatorExample.getLengthOrderSetAsString();
  }

  /** Obtiene el orden case-insensitive. */
  @When("obtengo el orden case-insensitive del TreeSet")
  public void obtengoElOrdenCaseInsensitiveDelTreeSet() {
    resultString = comparatorExample.getCaseInsensitiveSetAsString();
  }

  /** Obtiene las claves del map inverso. */
  @When("obtengo las claves del TreeMap")
  public void obtengoLasClavesDelTreeMap() {
    resultString = comparatorExample.getReverseOrderMapKeysAsString();
  }

  /** Obtiene los valores del map. */
  @When("obtengo los valores del TreeMap")
  public void obtengoLosValoresDelTreeMap() {
    resultString = comparatorExample.getReverseOrderMapValuesAsString();
  }

  /** Obtiene personas ordenadas por edad. */
  @When("obtengo las personas ordenadas por edad")
  public void obtengoLasPersonasOrdenadasPorEdad() {
    resultString = comparatorExample.getPersonsByAgeAsString();
  }

  /** Obtiene personas ordenadas por nombre. */
  @When("obtengo las personas ordenadas por nombre")
  public void obtengoLasPersonasOrdenadasPorNombre() {
    resultString = comparatorExample.getPersonsByNameAsString();
  }

  /** Obtiene el tamaño del set por longitud. */
  @When("obtengo el tamaño del TreeSet por longitud")
  public void obtengoElTamanoDelTreeSetPorLongitud() {
    resultInt = comparatorExample.getLengthOrderSetSize();
  }

  /**
   * Verifica que el resultado sea el esperado.
   *
   * @param expected resultado esperado
   */
  @Then("el resultado comparator debe ser {string}")
  public void elResultadoComparatorDebeSer(final String expected) {
    assertThat(resultString).isEqualTo(expected);
  }

  /**
   * Verifica el tamaño esperado del set.
   *
   * @param expected tamaño esperado
   */
  @Then("el tamaño del set comparator debe ser {int}")
  public void elTamanoDelSetComparatorDebeSer(final int expected) {
    assertThat(resultInt).isEqualTo(expected);
  }
}
