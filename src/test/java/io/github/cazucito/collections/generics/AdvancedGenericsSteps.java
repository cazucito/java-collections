/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para generics avanzados en colecciones.
 */
package io.github.cazucito.collections.generics;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.github.cazucito.collections.generics.AdvancedGenericsExample.AbstractAnimal;
import io.github.cazucito.collections.generics.AdvancedGenericsExample.Dog;
import java.util.ArrayList;
import java.util.List;

/** Step definitions para AdvancedGenericsExample. */
public class AdvancedGenericsSteps {

  /** Instancia del ejemplo. */
  private AdvancedGenericsExample genericsExample;

  /** Lista fuente para operaciones. */
  private List<Integer> sourceList;

  /** Lista destino para operaciones. */
  private List<Number> destList;

  /** Lista de strings. */
  private List<String> stringList;

  /** Lista de números. */
  private List<Number> numberList;

  /** Lista de enteros. */
  private List<Integer> integerList;

  /** Lista de dogs. */
  private List<Dog> dogList;

  /** Lista de animales. */
  private List<AbstractAnimal<?>> animalList;

  /** Suma calculada. */
  private double calculatedSum;

  /** Resultado de contención. */
  private boolean containsResult;

  /** Tamaño obtenido. */
  private int obtainedSize;

  /** Máximo encontrado. */
  private String maxFound;

  /** Perro actual. */
  private Dog currentDog;

  /** Constructor. */
  public AdvancedGenericsSteps() {
    genericsExample = new AdvancedGenericsExample();
  }

  // ============================================
  // PECS
  // ============================================
  @Dado("una lista fuente de enteros para generics {string}")
  public void unaListaFuenteDeEnteros(final String numbers) {
    sourceList = new ArrayList<>();
    for (String num : numbers.split(", ")) {
      sourceList.add(Integer.parseInt(num.trim()));
    }
  }

  @Dado("una lista destino vacia para generics")
  public void unaListaDestinoVacia() {
    destList = new ArrayList<>();
  }

  @Cuando("copio elementos usando PECS")
  public void copioElementosUsandoPecs() {
    genericsExample.copyWithPecs(sourceList, destList);
  }

  @Entonces("la lista destino contiene {string}")
  public void laListaDestinoContiene(final String expected) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < destList.size(); i++) {
      if (i > 0) {
        sb.append(", ");
      }
      sb.append(destList.get(i));
    }
    assertThat(sb.toString()).isEqualTo(expected);
  }

  @Dado("una lista de Dog con elementos {string}")
  public void unaListaDeDogConElementos(final String names) {
    dogList = new ArrayList<>();
    for (String name : names.split(", ")) {
      dogList.add(new Dog(name.trim()));
    }
  }

  @Cuando("intento demostrar que extends es solo lectura")
  public void intentoDemostrarQueExtendsEsSoloLectura() {
    genericsExample.demonstrateExtendsReadOnly(dogList);
  }

  @Entonces("el resultado es modo solo-lectura")
  public void elResultadoEsModoSoloLectura() {
    assertThat(genericsExample.getLastResult()).isEqualTo("read-only");
  }

  @Dado("una lista de animales vacia")
  public void unaListaDeAnimalesVacia() {
    animalList = new ArrayList<>();
  }

  @Dado("un perro llamado {string}")
  public void unPerroLlamado(final String name) {
    currentDog = new Dog(name);
  }

  @Cuando("agrego el perro usando super wildcard")
  public void agregoElPerroUsandoSuperWildcard() {
    genericsExample.demonstrateSuperWrite(animalList, currentDog);
  }

  @Entonces("el resultado es escritura-permitida")
  public void elResultadoEsEscrituraPermitida() {
    assertThat(genericsExample.getLastResult()).isEqualTo("write-allowed");
  }

  @Y("la lista contiene el perro")
  public void laListaContieneElPerro() {
    assertThat(animalList).contains(currentDog);
  }

  // ============================================
  // WILDCARDS
  // ============================================
  @Dado("una lista de numeros para generics {string}")
  public void unaListaDeNumerosParaGenerics(final String numbers) {
    numberList = new ArrayList<>();
    for (String num : numbers.split(", ")) {
      numberList.add(Double.parseDouble(num.trim()));
    }
  }

  @Cuando("calculo la suma usando bounded wildcard")
  public void calculoLaSumaUsandoBoundedWildcard() {
    if (numberList != null && !numberList.isEmpty()) {
      calculatedSum = genericsExample.sumNumbers(numberList);
    } else if (integerList != null && !integerList.isEmpty()) {
      calculatedSum = genericsExample.sumNumbers(integerList);
    }
  }

  @Entonces("la suma total es {double}")
  public void laSumaTotalEs(final double expected) {
    assertThat(calculatedSum).isEqualTo(expected);
  }

  @Dado("una lista de enteros para generics {string}")
  public void unaListaDeEnterosParaGenerics(final String numbers) {
    integerList = new ArrayList<>();
    for (String num : numbers.split(", ")) {
      integerList.add(Integer.parseInt(num.trim()));
    }
  }

  @Dado("una lista de numeros vacia")
  public void unaListaDeNumerosVacia() {
    numberList = new ArrayList<>();
  }

  @Cuando("agrego enteros {int} usando lower bounded wildcard")
  public void agregoEnterosUsandoLowerBoundedWildcard(final int value) {
    genericsExample.addInteger(numberList, value);
  }

  @Entonces("la lista de numeros contiene {int} elementos")
  public void laListaDeNumerosContieneElementos(final int expected) {
    assertThat(numberList.size()).isEqualTo(expected);
  }

  @Dado("una lista de strings para generics {string}")
  public void unaListaDeStringsParaGenerics(final String elements) {
    stringList = new ArrayList<>();
    for (String element : elements.split(", ")) {
      stringList.add(element.trim());
    }
  }

  @Cuando("obtengo el tamano usando unbounded wildcard")
  public void obtengoElTamanoUsandoUnboundedWildcard() {
    obtainedSize = genericsExample.getListSize(stringList);
  }

  @Entonces("el tamano obtenido es {int}")
  public void elTamanoObtenidoEs(final int expected) {
    assertThat(obtainedSize).isEqualTo(expected);
  }

  @Cuando("verifico si contiene {string} usando unbounded wildcard")
  public void verificoSiContieneUsandoUnboundedWildcard(final String element) {
    containsResult = genericsExample.containsElement(stringList, element);
  }

  @Entonces("el resultado de contencion es verdadero")
  public void elResultadoDeContencionEsVerdadero() {
    assertThat(containsResult).isTrue();
  }

  // ============================================
  // BOUNDED TYPE PARAMETERS
  // ============================================
  @Cuando("creo una lista de numeros usando bounded type parameter")
  public void creoUnaListaDeNumerosUsandoBoundedTypeParameter() {
    numberList = genericsExample.createNumberList();
  }

  @Entonces("la lista creada esta vacia")
  public void laListaCreadaEstaVacia() {
    assertThat(numberList).isEmpty();
  }

  @Y("puedo agregar numeros enteros a la lista")
  public void puedoAgregarNumerosEnterosALaLista() {
    numberList.add(42);
    assertThat(numberList).contains(42);
  }

  @Cuando("encuentro el maximo usando comparable bound")
  public void encuentroElMaximoUsandoComparableBound() {
    if (stringList != null && !stringList.isEmpty()) {
      maxFound = genericsExample.findMax(stringList);
    } else if (integerList != null && !integerList.isEmpty()) {
      Integer max = genericsExample.findMax(integerList);
      maxFound = max != null ? max.toString() : null;
    }
  }

  @Entonces("el maximo encontrado es {string}")
  public void elMaximoEncontradoEs(final String expected) {
    assertThat(maxFound).isEqualTo(expected);
  }

  // ============================================
  // TYPE ERASURE
  // ============================================
  @Cuando("comparo las clases en runtime")
  public void comparoLasClasesEnRuntime() {
    containsResult = genericsExample.demonstrateTypeErasure(stringList, integerList);
  }

  @Entonces("ambas listas tienen la misma clase")
  public void ambasListasTienenLaMismaClase() {
    assertThat(containsResult).isTrue();
  }

  @Y("el nombre de la clase es {string}")
  public void elNombreDeLaClaseEs(final String expected) {
    String className = genericsExample.getRuntimeClassName(stringList);
    assertThat(className).isEqualTo(expected);
  }

  @Cuando("obtengo el nombre de la clase en runtime")
  public void obtengoElNombreDeLaClaseEnRuntime() {
    // Resultado obtenido en el siguiente paso
  }

  @Entonces("el nombre es {string} sin informacion de tipo generico")
  public void elNombreEsSinInformacionDeTipoGenerico(final String expected) {
    String className = genericsExample.getRuntimeClassName(stringList);
    assertThat(className).isEqualTo(expected);
    // Verificar que no hay información de tipo genérico
    assertThat(className).doesNotContain("<");
  }
}
