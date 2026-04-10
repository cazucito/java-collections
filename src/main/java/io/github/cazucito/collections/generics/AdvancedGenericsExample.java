/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Ejemplo de generics avanzados en colecciones Java.
 */
package io.github.cazucito.collections.generics;

import java.util.ArrayList;
import java.util.List;

/** Demuestra generics avanzados: wildcards, PECS, type erasure, bounded types. */
public class AdvancedGenericsExample {

  /** Resultado de operación. */
  private String lastResult;

  /** Constructor. */
  public AdvancedGenericsExample() {
    // Constructor vacío
  }

  /**
   * Copia elementos de una lista fuente a una lista destino usando PECS. Producer Extends: src
   * produce elementos (? extends T) Consumer Super: dest consume elementos (? super T)
   *
   * @param src lista fuente (producer)
   * @param dest lista destino (consumer)
   * @param <T> tipo de elementos
   */
  public <T> void copyWithPecs(final List<? extends T> src, final List<? super T> dest) {
    for (T element : src) {
      dest.add(element);
    }
  }

  /**
   * Calcula la suma de números usando bounded wildcard.
   *
   * @param numbers lista de números
   * @return suma total
   */
  public double sumNumbers(final List<? extends Number> numbers) {
    double sum = 0.0;
    for (Number num : numbers) {
      sum += num.doubleValue();
    }
    return sum;
  }

  /**
   * Agrega números enteros a una lista usando lower bounded wildcard.
   *
   * @param list lista de destino
   * @param value valor a agregar
   */
  public void addInteger(final List<? super Integer> list, final int value) {
    list.add(value);
  }

  /**
   * Verifica si un elemento está en la lista usando unbounded wildcard.
   *
   * @param list lista de elementos
   * @param element elemento a buscar
   * @return true si contiene el elemento
   */
  public boolean containsElement(final List<?> list, final Object element) {
    return list.contains(element);
  }

  /**
   * Obtiene el tamaño de una lista usando unbounded wildcard.
   *
   * @param list lista de elementos de cualquier tipo
   * @return tamaño de la lista
   */
  public int getListSize(final List<?> list) {
    return list.size();
  }

  /**
   * Crea una lista de números con bounded type parameter.
   *
   * @param <T> tipo de número
   * @return lista vacía de números
   */
  public <T extends Number> List<T> createNumberList() {
    return new ArrayList<>();
  }

  /**
   * Encuentra el máximo en una lista de elementos comparables.
   *
   * @param list lista de elementos
   * @param <T> tipo comparable
   * @return elemento máximo
   */
  public <T extends Comparable<T>> T findMax(final List<T> list) {
    if (list.isEmpty()) {
      return null;
    }
    T max = list.get(0);
    for (T element : list) {
      if (element.compareTo(max) > 0) {
        max = element;
      }
    }
    return max;
  }

  /**
   * Demuestra type erasure - el tipo genérico no existe en runtime.
   *
   * @param list1 primera lista
   * @param list2 segunda lista
   * @return true si son del mismo tipo raw
   */
  public boolean demonstrateTypeErasure(final List<?> list1, final List<?> list2) {
    // En runtime, ambos son List (raw type), no List<String> o List<Integer>
    return list1.getClass().equals(list2.getClass());
  }

  /**
   * Obtiene el nombre de la clase en runtime (demuestra type erasure).
   *
   * @param list lista genérica
   * @return nombre de la clase
   */
  public String getRuntimeClassName(final List<?> list) {
    return list.getClass().getSimpleName();
  }

  /**
   * Intenta agregar elementos a una lista con extends wildcard (fallará en compilación). Este
   * método demuestra por qué ? extends T es solo para lectura.
   *
   * @param list lista de elementos
   * @param <T> tipo de elementos
   */
  public <T> void demonstrateExtendsReadOnly(final List<? extends T> list) {
    // No se puede agregar elementos a List<? extends T>
    // porque no sabemos el tipo exacto
    // list.add(new Object()); // Error de compilación
    lastResult = "read-only";
  }

  /**
   * Agrega elementos a una lista con super wildcard (escritura permitida).
   *
   * @param list lista de destino
   * @param element elemento a agregar
   * @param <T> tipo base
   */
  public <T> void demonstrateSuperWrite(final List<? super T> list, final T element) {
    list.add(element);
    lastResult = "write-allowed";
  }

  /**
   * Obtiene el último resultado.
   *
   * @return último resultado
   */
  public String getLastResult() {
    return lastResult;
  }

  /**
   * Clase base abstracta para demostrar bounded types.
   *
   * @param <T> tipo de animal
   */
  public abstract static class AbstractAnimal<T> {
    /** Nombre del animal. */
    private final String name;

    /**
     * Constructor.
     *
     * @param name nombre del animal
     */
    public AbstractAnimal(final String name) {
      this.name = name;
    }

    /**
     * Obtiene el nombre.
     *
     * @return nombre
     */
    public String getName() {
      return name;
    }

    /**
     * Método abstracto para hacer sonido.
     *
     * @return sonido del animal
     */
    public abstract String makeSound();
  }

  /** Clase Dog que extiende AbstractAnimal. */
  public static class Dog extends AbstractAnimal<Dog> {
    /**
     * Constructor.
     *
     * @param name nombre del perro
     */
    public Dog(final String name) {
      super(name);
    }

    @Override
    public String makeSound() {
      return "Woof";
    }
  }

  /** Clase Cat que extiende AbstractAnimal. */
  public static class Cat extends AbstractAnimal<Cat> {
    /**
     * Constructor.
     *
     * @param name nombre del gato
     */
    public Cat(final String name) {
      super(name);
    }

    @Override
    public String makeSound() {
      return "Meow";
    }
  }
}
