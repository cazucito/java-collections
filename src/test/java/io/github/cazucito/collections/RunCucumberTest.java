/**
 * Copyright 2024 cazucito SPDX-License-Identifier: Apache-2.0
 *
 * <p>Suite de tests para ejecutar Cucumber con JUnit 5.
 */
package io.github.cazucito.collections;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

/**
 * Clase principal para la ejecución de tests de Cucumber.
 *
 * <p>Esta clase configura el entorno de ejecución de Cucumber con JUnit 5, definiendo la ubicación
 * de los archivos .feature y los step definitions.
 *
 * <p>Para ejecutar: {@code mvn test}
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "io.github.cazucito.collections")
@ConfigurationParameter(
    key = PLUGIN_PROPERTY_NAME,
    value = "pretty, html:target/cucumber-report.html")
public class RunCucumberTest {
  // Clase vacía - la configuración se realiza mediante anotaciones
}
