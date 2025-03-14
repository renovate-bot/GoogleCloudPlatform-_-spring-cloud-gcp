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

package com.google.cloud.spring.autoconfigure.datastore;

import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.GcpScope;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Properties for configuring Cloud Datastore.
 *
 * @since 1.1
 */
@ConfigurationProperties("spring.cloud.gcp.datastore")
public class GcpDatastoreProperties implements CredentialsSupplier {

  /** Overrides the GCP OAuth2 credentials specified in the Core module. */
  @NestedConfigurationProperty
  private final Credentials credentials = new Credentials(GcpScope.DATASTORE.getUrl());

  /** Properties to auto configure a local Datastore Emulator. */
  @NestedConfigurationProperty private final EmulatorSettings emulator = new EmulatorSettings();

  /** The host and port of a Datastore emulator as the following example: localhost:8081. */
  private String host;

  private String projectId;

  private String databaseId;

  private String namespace;

  /** Whether skip the insertion if the value is null */
  private boolean skipNullValue;

  @Override
  public Credentials getCredentials() {
    return this.credentials;
  }

  public EmulatorSettings getEmulator() {
    return this.emulator;
  }

  public String getProjectId() {
    return this.projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public String getDatabaseId() {
    return databaseId;
  }

  public void setDatabaseId(String databaseId) {
    this.databaseId = databaseId;
  }

  public String getNamespace() {
    return this.namespace;
  }

  public void setNamespace(String namespace) {
    this.namespace = namespace;
  }

  public String getHost() {
    return this.host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public boolean isSkipNullValue() {
    return skipNullValue;
  }

  public void setSkipNullValue(boolean skipNullValue) {
    this.skipNullValue = skipNullValue;
  }
}
