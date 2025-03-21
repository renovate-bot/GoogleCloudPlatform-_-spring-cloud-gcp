/*
 * Copyright 2017-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spring.autoconfigure.datastore.health;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import com.google.api.gax.core.CredentialsProvider;
import com.google.cloud.spring.autoconfigure.TestUtils;
import com.google.cloud.spring.autoconfigure.core.GcpContextAutoConfiguration;
import com.google.cloud.spring.autoconfigure.datastore.GcpDatastoreAutoConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.AutoConfigurations;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Tests for Datastore health check auto-config.
 *
 * @since 1.2
 */
class DatastoreHealthIndicatorAutoConfigurationTests {

  private ApplicationContextRunner contextRunner =
      new ApplicationContextRunner()
          .withConfiguration(
              AutoConfigurations.of(
                  GcpDatastoreAutoConfiguration.class,
                  GcpContextAutoConfiguration.class,
                  DatastoreHealthIndicatorAutoConfiguration.class))
          .withUserConfiguration(TestConfiguration.class)
          .withPropertyValues(
              "spring.cloud.gcp.datastore.project-id=test-project",
              "spring.cloud.gcp.datastore.namespace-id=testNamespace",
              "management.health.datastore.enabled=true");

  @Test
  void testDatastoreHealthIndicatorCreated() {
    this.contextRunner.run(
        context -> assertThat(context.getBean(DatastoreHealthIndicator.class)).isNotNull());
  }

  /** Spring Boot config for tests. */
  @Configuration
  static class TestConfiguration {

    @Bean
    public CredentialsProvider credentialsProvider() {
      return () -> TestUtils.MOCK_CREDENTIALS;
    }
  }
}
