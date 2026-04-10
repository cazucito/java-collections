/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar problemas de concurrencia en colecciones.
 */
package io.github.cazucito.collections.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ejemplifica problemas de concurrencia en ArrayList y soluciones.
 *
 * <p>Demuestra que ArrayList no es thread-safe y cómo sincronizarlo correctamente.
 */
public class ConcurrentAccessExample {

  /** Prefijo para nombres de thread. */
  private static final String THREAD_PREFIX = "Thread-";

  /** Separador para items. */
  private static final String ITEM_SEPARATOR = "-Item-";

  /** Elemento A. */
  private static final String ELEMENT_A = "A";

  /** Elemento B. */
  private static final String ELEMENT_B = "B";

  /** Elemento C. */
  private static final String ELEMENT_C = "C";

  /** Lista compartida no sincronizada. */
  private final List<String> unsafeList;

  /** Lista sincronizada con Collections.synchronizedList. */
  private final List<String> synchronizedList;

  /** Lista thread-safe con CopyOnWriteArrayList. */
  private final List<String> concurrentList;

  /** Contador de elementos agregados exitosamente. */
  private final AtomicInteger successCount;

  /** Contador de elementos esperados. */
  private int expectedSize;

  /** Constructor que inicializa las listas. */
  public ConcurrentAccessExample() {
    this.unsafeList = new ArrayList<>();
    this.synchronizedList = Collections.synchronizedList(new ArrayList<>());
    this.concurrentList = new CopyOnWriteArrayList<>();
    this.successCount = new AtomicInteger(0);
    this.expectedSize = 0;
  }

  /**
   * Configura el número esperado de elementos.
   *
   * @param expected número esperado
   */
  public void setExpectedSize(final int expected) {
    this.expectedSize = expected;
  }

  /**
   * Agrega elementos a la lista no segura desde múltiples threads.
   *
   * @param threadCount número de threads
   * @param itemsPerThread elementos por thread
   * @throws InterruptedException si hay interrupción
   */
  public void addToUnsafeListConcurrently(final int threadCount, final int itemsPerThread)
      throws InterruptedException {
    unsafeList.clear();
    successCount.set(0);
    CountDownLatch latch = new CountDownLatch(threadCount);

    for (int i = 0; i < threadCount; i++) {
      final int threadId = i;
      new Thread(
              () -> {
                try {
                  for (int j = 0; j < itemsPerThread; j++) {
                    unsafeList.add(THREAD_PREFIX + threadId + ITEM_SEPARATOR + j);
                    successCount.incrementAndGet();
                  }
                } finally {
                  latch.countDown();
                }
              })
          .start();
    }

    latch.await();
  }

  /**
   * Agrega elementos a la lista sincronizada desde múltiples threads.
   *
   * @param threadCount número de threads
   * @param itemsPerThread elementos por thread
   * @throws InterruptedException si hay interrupción
   */
  public void addToSynchronizedListConcurrently(final int threadCount, final int itemsPerThread)
      throws InterruptedException {
    synchronizedList.clear();
    successCount.set(0);
    CountDownLatch latch = new CountDownLatch(threadCount);

    for (int i = 0; i < threadCount; i++) {
      final int threadId = i;
      new Thread(
              () -> {
                try {
                  for (int j = 0; j < itemsPerThread; j++) {
                    synchronizedList.add(THREAD_PREFIX + threadId + ITEM_SEPARATOR + j);
                    successCount.incrementAndGet();
                  }
                } finally {
                  latch.countDown();
                }
              })
          .start();
    }

    latch.await();
  }

  /**
   * Agrega elementos a CopyOnWriteArrayList desde múltiples threads.
   *
   * @param threadCount número de threads
   * @param itemsPerThread elementos por thread
   * @throws InterruptedException si hay interrupción
   */
  public void addToConcurrentListConcurrently(final int threadCount, final int itemsPerThread)
      throws InterruptedException {
    concurrentList.clear();
    successCount.set(0);
    CountDownLatch latch = new CountDownLatch(threadCount);

    for (int i = 0; i < threadCount; i++) {
      final int threadId = i;
      new Thread(
              () -> {
                try {
                  for (int j = 0; j < itemsPerThread; j++) {
                    concurrentList.add(THREAD_PREFIX + threadId + ITEM_SEPARATOR + j);
                    successCount.incrementAndGet();
                  }
                } finally {
                  latch.countDown();
                }
              })
          .start();
    }

    latch.await();
  }

  /**
   * Simula ConcurrentModificationException al iterar y modificar.
   *
   * @return true si lanza excepción
   */
  public boolean demonstrateConcurrentModification() {
    unsafeList.clear();
    unsafeList.add(ELEMENT_A);
    unsafeList.add(ELEMENT_B);
    unsafeList.add(ELEMENT_C);

    try {
      for (String item : unsafeList) {
        // Modificar la lista durante iteración causa ConcurrentModificationException
        unsafeList.add("Nuevo");
      }
      return false;
    } catch (java.util.ConcurrentModificationException e) {
      return true;
    }
  }

  /**
   * Iteración segura con CopyOnWriteArrayList.
   *
   * @return tamaño final de la lista
   */
  public int safeIterationWithConcurrentList() {
    concurrentList.clear();
    concurrentList.add(ELEMENT_A);
    concurrentList.add(ELEMENT_B);
    concurrentList.add(ELEMENT_C);

    for (String item : concurrentList) {
      if (ELEMENT_B.equals(item)) {
        concurrentList.remove(item);
      }
    }

    return concurrentList.size();
  }

  /**
   * Retorna el tamaño de la lista no segura.
   *
   * @return tamaño actual
   */
  public int getUnsafeListSize() {
    return unsafeList.size();
  }

  /**
   * Retorna el tamaño de la lista sincronizada.
   *
   * @return tamaño actual
   */
  public int getSynchronizedListSize() {
    return synchronizedList.size();
  }

  /**
   * Retorna el tamaño de la lista concurrente.
   *
   * @return tamaño actual
   */
  public int getConcurrentListSize() {
    return concurrentList.size();
  }

  /**
   * Verifica si la lista no segura tiene el tamaño esperado.
   *
   * @return true si coincide
   */
  public boolean isUnsafeListSizeCorrect() {
    return unsafeList.size() == expectedSize;
  }

  /**
   * Verifica si la lista sincronizada tiene el tamaño esperado.
   *
   * @return true si coincide
   */
  public boolean isSynchronizedListSizeCorrect() {
    return synchronizedList.size() == expectedSize;
  }

  /**
   * Verifica si la lista concurrente tiene el tamaño esperado.
   *
   * @return true si coincide
   */
  public boolean isConcurrentListSizeCorrect() {
    return concurrentList.size() == expectedSize;
  }

  /**
   * Retorna el conteo de operaciones exitosas.
   *
   * @return conteo
   */
  public int getSuccessCount() {
    return successCount.get();
  }
}
