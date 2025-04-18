/*
 * Copyright 2017-2018 the original author or authors.
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

package com.google.cloud.spring.autoconfigure.core;

import static com.google.cloud.spring.autoconfigure.core.GcpProperties.CORE_PROPERTY_PREFIX;

import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;
import org.springframework.context.annotation.ImportRuntimeHints;

/** Top-level auto-config settings. */
@ConfigurationProperties(CORE_PROPERTY_PREFIX)
@ImportRuntimeHints(CredentialsRuntimeHints.class)
public class GcpProperties implements CredentialsSupplier {

  /** Configuration prefix. */
  public static final String CORE_PROPERTY_PREFIX = "spring.cloud.gcp";

  /** GCP project ID where services are running. */
  private String projectId;

  /**
   * GCP OAuth2 credentials to authenticate and authorize calls to Google Cloud Client Libraries.
   */
  @NestedConfigurationProperty private final Credentials credentials = new Credentials();

  public String getProjectId() {
    return this.projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public Credentials getCredentials() {
    return this.credentials;
  }
}
