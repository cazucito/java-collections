/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar comparadores personalizados.
 */
package io.github.cazucito.collections.comparator;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * Ejemplifica el uso de comparadores personalizados con TreeSet y TreeMap.
 *
 * <p>Demuestra diferentes estrategias de ordenamiento: natural, inverso, por longitud,
 * case-insensitive, y ordenamiento compuesto con múltiples criterios.
 */
public class CustomComparatorExample {

  /** Separador para elementos. */
  private static final String ELEMENT_SEPARATOR = ", ";

  /** Patrón de separación de colección. */
  private static final String COLLECTION_SEPARATOR = "," + " ";

  /** TreeSet con ordenamiento natural. */
  private Set<String> naturalOrderSet;

  /** TreeSet con ordenamiento inverso. */
  private NavigableSet<String> reverseOrderSet;

  /** TreeSet ordenado por longitud de string. */
  private Set<String> lengthOrderSet;

  /** TreeSet con ordenamiento case-insensitive. */
  private Set<String> caseInsensitiveSet;

  /** TreeMap con ordenamiento inverso de claves. */
  private SortedMap<String, Integer> reverseOrderMap;

  /** TreeSet de personas ordenadas por edad. */
  private Set<Person> personsByAge;

  /** TreeSet de personas ordenadas por nombre. */
  private Set<Person> personsByName;

  /** Constructor que inicializa las colecciones. */
  public CustomComparatorExample() {
    this.naturalOrderSet = new TreeSet<>();
    this.reverseOrderSet = new TreeSet<>(Comparator.reverseOrder());
    this.lengthOrderSet = new TreeSet<>(Comparator.comparingInt(String::length));
    this.caseInsensitiveSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
    this.reverseOrderMap = new TreeMap<>(Comparator.reverseOrder());
    this.personsByAge = new TreeSet<>(Comparator.comparingInt(Person::getAge));
    this.personsByName = new TreeSet<>(Comparator.comparing(Person::getName));
  }

  /**
   * Agrega elementos al TreeSet con ordenamiento natural.
   *
   * @param elements elementos a agregar
   */
  public void addToNaturalOrderSet(final String[] elements) {
    for (String element : elements) {
      naturalOrderSet.add(element);
    }
  }

  /**
   * Agrega elementos al TreeSet con ordenamiento inverso.
   *
   * @param elements elementos a agregar
   */
  public void addToReverseOrderSet(final String[] elements) {
    for (String element : elements) {
      reverseOrderSet.add(element);
    }
  }

  /**
   * Agrega elementos al TreeSet ordenado por longitud.
   *
   * @param elements elementos a agregar
   */
  public void addToLengthOrderSet(final String[] elements) {
    for (String element : elements) {
      lengthOrderSet.add(element);
    }
  }

  /**
   * Agrega elementos al TreeSet case-insensitive.
   *
   * @param elements elementos a agregar
   */
  public void addToCaseInsensitiveSet(final String[] elements) {
    for (String element : elements) {
      caseInsensitiveSet.add(element);
    }
  }

  /**
   * Agrega entradas al TreeMap con ordenamiento inverso.
   *
   * @param keys claves a agregar
   * @param values valores correspondientes
   */
  public void addToReverseOrderMap(final String[] keys, final Integer[] values) {
    for (int i = 0; i < keys.length; i++) {
      reverseOrderMap.put(keys[i], values[i]);
    }
  }

  /**
   * Agrega personas ordenadas por edad.
   *
   * @param names nombres
   * @param ages edades
   */
  public void addPersonsByAge(final String[] names, final int[] ages) {
    for (int i = 0; i < names.length; i++) {
      personsByAge.add(new Person(names[i], ages[i]));
    }
  }

  /**
   * Agrega personas ordenadas por nombre.
   *
   * @param names nombres
   * @param ages edades
   */
  public void addPersonsByName(final String[] names, final int[] ages) {
    for (int i = 0; i < names.length; i++) {
      personsByName.add(new Person(names[i], ages[i]));
    }
  }

  /**
   * Retorna el TreeSet ordenado naturalmente como string.
   *
   * @return elementos separados por coma
   */
  public String getNaturalOrderSetAsString() {
    return String.join(ELEMENT_SEPARATOR, naturalOrderSet);
  }

  /**
   * Retorna el TreeSet en orden inverso como string.
   *
   * @return elementos separados por coma
   */
  public String getReverseOrderSetAsString() {
    return String.join(ELEMENT_SEPARATOR, reverseOrderSet);
  }

  /**
   * Retorna el TreeSet ordenado por longitud como string.
   *
   * @return elementos separados por coma
   */
  public String getLengthOrderSetAsString() {
    return String.join(ELEMENT_SEPARATOR, lengthOrderSet);
  }

  /**
   * Retorna el TreeSet case-insensitive como string.
   *
   * @return elementos separados por coma
   */
  public String getCaseInsensitiveSetAsString() {
    return String.join(ELEMENT_SEPARATOR, caseInsensitiveSet);
  }

  /**
   * Retorna las claves del TreeMap en orden inverso.
   *
   * @return claves separadas por coma
   */
  public String getReverseOrderMapKeysAsString() {
    return String.join(ELEMENT_SEPARATOR, reverseOrderMap.keySet());
  }

  /**
   * Retorna los valores del TreeMap en orden de claves inverso.
   *
   * @return valores como string
   */
  public String getReverseOrderMapValuesAsString() {
    return reverseOrderMap
        .values()
        .toString()
        .replace("[", "")
        .replace("]", "")
        .replace(COLLECTION_SEPARATOR, ELEMENT_SEPARATOR);
  }

  /**
   * Retorna las personas ordenadas por edad.
   *
   * @return nombres separados por coma
   */
  public String getPersonsByAgeAsString() {
    StringBuilder sb = new StringBuilder();
    for (Person p : personsByAge) {
      if (sb.length() > 0) {
        sb.append(ELEMENT_SEPARATOR);
      }
      sb.append(p.getName()).append("(").append(p.getAge()).append(")");
    }
    return sb.toString();
  }

  /**
   * Retorna las personas ordenadas por nombre.
   *
   * @return nombres separados por coma
   */
  public String getPersonsByNameAsString() {
    StringBuilder sb = new StringBuilder();
    for (Person p : personsByName) {
      if (sb.length() > 0) {
        sb.append(ELEMENT_SEPARATOR);
      }
      sb.append(p.getName());
    }
    return sb.toString();
  }

  /**
   * Retorna el tamaño del set ordenado por longitud.
   *
   * @return tamaño
   */
  public int getLengthOrderSetSize() {
    return lengthOrderSet.size();
  }

  /** Clase interna que representa una persona con nombre y edad. */
  public static class Person {

    /** Nombre de la persona. */
    private final String name;

    /** Edad de la persona. */
    private final int age;

    /**
     * Constructor de Person.
     *
     * @param personName nombre
     * @param personAge edad
     */
    public Person(final String personName, final int personAge) {
      this.name = personName;
      this.age = personAge;
    }

    /**
     * Retorna el nombre.
     *
     * @return nombre
     */
    public String getName() {
      return name;
    }

    /**
     * Retorna la edad.
     *
     * @return edad
     */
    public int getAge() {
      return age;
    }
  }
}
