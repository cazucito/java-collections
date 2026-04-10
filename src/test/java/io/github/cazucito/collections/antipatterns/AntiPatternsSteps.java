/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Step definitions para anti-patrones comunes en colecciones.
 */
package io.github.cazucito.collections.antipatterns;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.github.cazucito.collections.antipatterns.AntiPatternsExample.MutableKey;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/** Step definitions para anti-patrones. */
public class AntiPatternsSteps {

  /** Instancia del ejemplo. */
  private AntiPatternsExample antiPatternsExample;

  /** Resultado de comparación. */
  private boolean comparisonResult;

  /** String 1 para comparación. */
  private String string1;

  /** String 2 para comparación. */
  private String string2;

  /** Lista para operaciones. */
  private java.util.List<String> testList;

  /** Mapa con clave mutable. */
  private Map<MutableKey, String> mutableKeyMap;

  /** Clave mutable usada. */
  private MutableKey mutableKey;

  /** Tamaño del HashSet. */
  private int hashSetSize;

  /** Constructor. */
  public AntiPatternsSteps() {
    antiPatternsExample = new AntiPatternsExample();
  }

  // ============================================
  // MEMORY LEAK
  // ============================================
  @Dado("una colección estática declarada")
  public void unaColeccionEstaticaDeclarada() {
    antiPatternsExample.clearStaticCache();
  }

  @Dado("una colección estática con elementos {string}")
  public void unaColeccionEstaticaConElementos(final String elements) {
    antiPatternsExample.clearStaticCache();
    antiPatternsExample.addToStaticCache(elements);
  }

  @Cuando("se agregan elementos sin límite {string}")
  public void seAgreganElementosSinLimite(final String elements) {
    antiPatternsExample.addToStaticCache(elements);
  }

  @Cuando("se limpia la colección estática")
  public void seLimpiaLaColeccionEstatica() {
    antiPatternsExample.clearStaticCache();
  }

  @Entonces("el tamaño de la colección estática es {int}")
  public void elTamanoDeLaColeccionEstaticaEs(final int expected) {
    assertThat(antiPatternsExample.getStaticCacheSize()).isEqualTo(expected);
  }

  @Y("la colección no es elegible para garbage collection")
  public void laColeccionNoEsElegibleParaGarbageCollection() {
    assertThat(antiPatternsExample.getStaticCacheSize()).isGreaterThan(0);
  }

  @Y("la memoria puede ser liberada")
  public void laMemoriaPuedeSerLiberada() {
    assertThat(antiPatternsExample.getStaticCacheSize()).isEqualTo(0);
  }

  // ============================================
  // MODIFICAR CLAVE MUTABLE
  // ============================================
  @Dado("un HashMap con claves mutables")
  public void unHashMapConClavesMutables() {
    mutableKeyMap = antiPatternsExample.createMapWithMutableKey();
  }

  @Cuando("se inserta una entrada con clave mutable {int}")
  public void seInsertaUnaEntradaConClaveMutable(final int keyValue) {
    mutableKey = new MutableKey(keyValue);
    mutableKeyMap.put(mutableKey, "Valor para " + keyValue);
  }

  @Cuando("se modifica la clave a {int} después de insertarla")
  public void seModificaLaClaveDespuesDeInsertarla(final int newValue) {
    mutableKey.setValue(newValue);
  }

  @Entonces("la entrada no es encontrable con la clave original")
  public void laEntradaNoEsEncontrableConLaClaveOriginal() {
    MutableKey originalKey = new MutableKey(100);
    assertThat(mutableKeyMap.get(originalKey)).isNull();
  }

  @Entonces("la entrada no es encontrable con la clave modificada")
  public void laEntradaNoEsEncontrableConLaClaveModificada() {
    MutableKey modifiedKey = new MutableKey(200);
    assertThat(mutableKeyMap.get(modifiedKey)).isNull();
  }

  @Y("se produce una fuga de memoria en el mapa")
  public void seProduceUnaFugaDeMemoriaEnElMapa() {
    assertThat(mutableKeyMap.size()).isEqualTo(1);
    // La entrada existe pero no es accesible
    assertThat(mutableKeyMap.get(mutableKey)).isNull();
  }

  // ============================================
  // COMPARACIÓN CON ==
  // ============================================
  @Dado("dos strings con mismo contenido {string}")
  public void dosStringsConMismoContenido(final String content) {
    string1 = new String(content);
    string2 = new String(content);
  }

  @Cuando("se comparan con operador ==")
  public void seComparanConOperador() {
    comparisonResult = antiPatternsExample.compareWithReferenceEquality(string1, string2);
  }

  @Cuando("se comparan con método equals")
  public void seComparanConMetodoEquals() {
    comparisonResult = antiPatternsExample.compareWithValueEquality(string1, string2);
  }

  @Entonces("el resultado de comparación por referencia es falso")
  public void elResultadoDeComparacionPorReferenciaEsFalso() {
    assertThat(comparisonResult).isFalse();
  }

  @Entonces("el resultado de comparación por valor es verdadero")
  public void elResultadoDeComparacionPorValorEsVerdadero() {
    assertThat(comparisonResult).isTrue();
  }

  // ============================================
  // CONCURRENT MODIFICATION
  // ============================================
  @Dado("una lista con elementos {string}")
  public void unaListaConElementos(final String elements) {
    testList = new java.util.ArrayList<>();
    for (String element : elements.split(", ")) {
      testList.add(element.trim());
    }
  }

  @Cuando("se intenta remover elemento {string} durante iteración for-each")
  public void seIntentaRemoverElementoDuranteIteracion(final String toRemove) {
    String elements = String.join(", ", testList);
    String result = antiPatternsExample.removeDuringIteration(elements, toRemove);
    assertThat(result).isEqualTo("ConcurrentModificationException");
  }

  @Entonces("se lanza ConcurrentModificationException")
  public void seLanzaConcurrentModificationException() {
    assertThat(antiPatternsExample.getCapturedErrorMessage())
        .isEqualTo("ConcurrentModificationException");
  }

  @Cuando("se remueve elemento {string} usando Iterator")
  public void seRemueveElementoUsandoIterator(final String toRemove) {
    String elements = String.join(", ", testList);
    String result = antiPatternsExample.removeWithIterator(elements, toRemove);
    testList = new java.util.ArrayList<>();
    for (String element : result.split(", ")) {
      testList.add(element.trim());
    }
  }

  @Cuando("se remueve elemento {string} usando removeIf")
  public void seRemueveElementoUsandoRemoveIf(final String toRemove) {
    testList.removeIf(element -> element.equals(toRemove));
  }

  @Entonces("la lista resultante es {string}")
  public void laListaResultanteEs(final String expected) {
    assertThat(String.join(", ", testList)).isEqualTo(expected);
  }

  @Y("no se lanza ninguna excepción")
  public void noSeLanzaNingunaExcepcion() {
    assertThat(antiPatternsExample.getCapturedErrorMessage()).isNullOrEmpty();
  }

  // ============================================
  // HASHSET CON STRINGS
  // ============================================
  @Dado("strings con contenido duplicado creados con new String")
  public void stringsConContenidoDuplicadoCreadosConNewString() {
    // Preparado para el escenario
  }

  @Cuando("se agregan a un HashSet")
  public void seAgreganAUnHashSet() {
    Set<String> set = new HashSet<>();
    // Simular creación de strings con new String()
    set.add(new String("A"));
    set.add(new String("B"));
    set.add(new String("A"));
    set.add(new String("C"));
    set.add(new String("B"));
    hashSetSize = set.size();
  }

  @Entonces("el HashSet contiene solo elementos únicos lógicos")
  public void elHashSetContieneSoloElementosUnicosLogicos() {
    assertThat(hashSetSize).isEqualTo(3); // A, B, C únicos
  }

  @Y("el tamaño del HashSet es menor que la cantidad de strings creados")
  public void elTamanoDelHashSetEsMenorQueLaCantidadDeStringsCreados() {
    assertThat(hashSetSize).isLessThan(5); // Se crearon 5 strings
  }
}
