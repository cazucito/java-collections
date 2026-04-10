/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Clases de ejemplo para ilustrar concurrencia en Map.
 */
package io.github.cazucito.collections.concurrency;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Ejemplifica problemas de concurrencia en HashMap y soluciones.
 *
 * <p>Demuestra que HashMap no es thread-safe y alternativas thread-safe.
 */
public class ConcurrentHashMapExample {

  /** Prefijo para nombres de thread. */
  private static final String THREAD_PREFIX = "Thread-";

  /** Separador para claves. */
  private static final String KEY_SEPARATOR = "-Key-";

  /** Clave del contador. */
  private static final String COUNTER_KEY = "counter";

  /** Map compartido no sincronizado. */
  private final Map<String, Integer> unsafeMap;

  /** Map sincronizado. */
  private final Map<String, Integer> synchronizedMap;

  /** Map thread-safe. */
  private final Map<String, Integer> concurrentMap;

  /** Contador de operaciones exitosas. */
  private final AtomicInteger successCount;

  /** Valor esperado de entradas. */
  private int expectedSize;

  /** Constructor que inicializa los maps. */
  public ConcurrentHashMapExample() {
    this.unsafeMap = new HashMap<>();
    this.synchronizedMap = Collections.synchronizedMap(new HashMap<>());
    this.concurrentMap = new ConcurrentHashMap<>();
    this.successCount = new AtomicInteger(0);
    this.expectedSize = 0;
  }

  /**
   * Configura el tamaño esperado.
   *
   * @param expected tamaño esperado
   */
  public void setExpectedSize(final int expected) {
    this.expectedSize = expected;
  }

  /**
   * Agrega entradas al map no seguro concurrentemente.
   *
   * @param threadCount número de threads
   * @param entriesPerThread entradas por thread
   * @throws InterruptedException si hay interrupción
   */
  public void addToUnsafeMapConcurrently(final int threadCount, final int entriesPerThread)
      throws InterruptedException {
    unsafeMap.clear();
    successCount.set(0);
    CountDownLatch latch = new CountDownLatch(threadCount);

    for (int i = 0; i < threadCount; i++) {
      final int threadId = i;
      new Thread(
              () -> {
                try {
                  for (int j = 0; j < entriesPerThread; j++) {
                    String key = THREAD_PREFIX + threadId + KEY_SEPARATOR + j;
                    unsafeMap.put(key, j);
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
   * Agrega entradas al map sincronizado concurrentemente.
   *
   * @param threadCount número de threads
   * @param entriesPerThread entradas por thread
   * @throws InterruptedException si hay interrupción
   */
  public void addToSynchronizedMapConcurrently(final int threadCount, final int entriesPerThread)
      throws InterruptedException {
    synchronizedMap.clear();
    successCount.set(0);
    CountDownLatch latch = new CountDownLatch(threadCount);

    for (int i = 0; i < threadCount; i++) {
      final int threadId = i;
      new Thread(
              () -> {
                try {
                  for (int j = 0; j < entriesPerThread; j++) {
                    String key = THREAD_PREFIX + threadId + KEY_SEPARATOR + j;
                    synchronizedMap.put(key, j);
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
   * Agrega entradas al ConcurrentHashMap concurrentemente.
   *
   * @param threadCount número de threads
   * @param entriesPerThread entradas por thread
   * @throws InterruptedException si hay interrupción
   */
  public void addToConcurrentMapConcurrently(final int threadCount, final int entriesPerThread)
      throws InterruptedException {
    concurrentMap.clear();
    successCount.set(0);
    CountDownLatch latch = new CountDownLatch(threadCount);

    for (int i = 0; i < threadCount; i++) {
      final int threadId = i;
      new Thread(
              () -> {
                try {
                  for (int j = 0; j < entriesPerThread; j++) {
                    String key = THREAD_PREFIX + threadId + KEY_SEPARATOR + j;
                    concurrentMap.put(key, j);
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
   * Simula race condition en incremento de valor.
   *
   * @param threadCount número de threads
   * @param incrementsPerThread incrementos por thread
   * @return valor final del contador
   * @throws InterruptedException si hay interrupción
   */
  public int demonstrateRaceCondition(final int threadCount, final int incrementsPerThread)
      throws InterruptedException {
    unsafeMap.clear();
    unsafeMap.put(COUNTER_KEY, 0);
    CountDownLatch latch = new CountDownLatch(threadCount);

    for (int i = 0; i < threadCount; i++) {
      new Thread(
              () -> {
                try {
                  for (int j = 0; j < incrementsPerThread; j++) {
                    int current = unsafeMap.get(COUNTER_KEY);
                    unsafeMap.put(COUNTER_KEY, current + 1);
                  }
                } finally {
                  latch.countDown();
                }
              })
          .start();
    }

    latch.await();
    return unsafeMap.get(COUNTER_KEY);
  }

  /**
   * Incremento atómico con ConcurrentHashMap.
   *
   * @param threadCount número de threads
   * @param incrementsPerThread incrementos por thread
   * @return valor final del contador
   * @throws InterruptedException si hay interrupción
   */
  public int atomicIncrementWithConcurrentMap(final int threadCount, final int incrementsPerThread)
      throws InterruptedException {
    concurrentMap.clear();
    concurrentMap.put(COUNTER_KEY, 0);
    CountDownLatch latch = new CountDownLatch(threadCount);

    for (int i = 0; i < threadCount; i++) {
      new Thread(
              () -> {
                try {
                  for (int j = 0; j < incrementsPerThread; j++) {
                    concurrentMap.compute(COUNTER_KEY, (k, v) -> v + 1);
                  }
                } finally {
                  latch.countDown();
                }
              })
          .start();
    }

    latch.await();
    return concurrentMap.get(COUNTER_KEY);
  }

  /**
   * Retorna el tamaño del map no seguro.
   *
   * @return tamaño
   */
  public int getUnsafeMapSize() {
    return unsafeMap.size();
  }

  /**
   * Retorna el tamaño del map sincronizado.
   *
   * @return tamaño
   */
  public int getSynchronizedMapSize() {
    return synchronizedMap.size();
  }

  /**
   * Retorna el tamaño del map concurrente.
   *
   * @return tamaño
   */
  public int getConcurrentMapSize() {
    return concurrentMap.size();
  }

  /**
   * Verifica si el map no seguro tiene el tamaño esperado.
   *
   * @return true si coincide
   */
  public boolean isUnsafeMapSizeCorrect() {
    return unsafeMap.size() == expectedSize;
  }

  /**
   * Verifica si el map sincronizado tiene el tamaño esperado.
   *
   * @return true si coincide
   */
  public boolean isSynchronizedMapSizeCorrect() {
    return synchronizedMap.size() == expectedSize;
  }

  /**
   * Verifica si el map concurrente tiene el tamaño esperado.
   *
   * @return true si coincide
   */
  public boolean isConcurrentMapSizeCorrect() {
    return concurrentMap.size() == expectedSize;
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
