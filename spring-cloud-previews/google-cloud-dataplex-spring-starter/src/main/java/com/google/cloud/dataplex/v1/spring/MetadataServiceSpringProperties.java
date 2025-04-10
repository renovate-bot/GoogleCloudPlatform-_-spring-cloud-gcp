/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.dataplex.v1.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.Retry;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for MetadataService client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.cloud.dataplex.v1.metadata-service")
public class MetadataServiceSpringProperties implements CredentialsSupplier {
  /** OAuth2 credentials to authenticate and authorize calls to Google Cloud Client Libraries. */
  @NestedConfigurationProperty
  private final Credentials credentials =
      new Credentials("https://www.googleapis.com/auth/cloud-platform");
  /** Quota project to use for billing. */
  private String quotaProjectId;
  /** Number of threads used for executors. */
  private Integer executorThreadCount;
  /** Allow override of default transport channel provider to use REST instead of gRPC. */
  private boolean useRest = false;
  /** Allow override of retry settings at service level, applying to all of its RPC methods. */
  @NestedConfigurationProperty private Retry retry;
  /**
   * Allow override of retry settings at method-level for createEntity. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createEntityRetry;
  /**
   * Allow override of retry settings at method-level for updateEntity. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry updateEntityRetry;
  /**
   * Allow override of retry settings at method-level for deleteEntity. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deleteEntityRetry;
  /**
   * Allow override of retry settings at method-level for getEntity. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getEntityRetry;
  /**
   * Allow override of retry settings at method-level for listEntities. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listEntitiesRetry;
  /**
   * Allow override of retry settings at method-level for createPartition. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry createPartitionRetry;
  /**
   * Allow override of retry settings at method-level for deletePartition. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry deletePartitionRetry;
  /**
   * Allow override of retry settings at method-level for getPartition. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getPartitionRetry;
  /**
   * Allow override of retry settings at method-level for listPartitions. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listPartitionsRetry;
  /**
   * Allow override of retry settings at method-level for listLocations. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listLocationsRetry;
  /**
   * Allow override of retry settings at method-level for getLocation. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getLocationRetry;

  @Override
  public Credentials getCredentials() {
    return this.credentials;
  }

  public String getQuotaProjectId() {
    return this.quotaProjectId;
  }

  public void setQuotaProjectId(String quotaProjectId) {
    this.quotaProjectId = quotaProjectId;
  }

  public boolean getUseRest() {
    return this.useRest;
  }

  public void setUseRest(boolean useRest) {
    this.useRest = useRest;
  }

  public Integer getExecutorThreadCount() {
    return this.executorThreadCount;
  }

  public void setExecutorThreadCount(Integer executorThreadCount) {
    this.executorThreadCount = executorThreadCount;
  }

  public Retry getRetry() {
    return this.retry;
  }

  public void setRetry(Retry retry) {
    this.retry = retry;
  }

  public Retry getCreateEntityRetry() {
    return this.createEntityRetry;
  }

  public void setCreateEntityRetry(Retry createEntityRetry) {
    this.createEntityRetry = createEntityRetry;
  }

  public Retry getUpdateEntityRetry() {
    return this.updateEntityRetry;
  }

  public void setUpdateEntityRetry(Retry updateEntityRetry) {
    this.updateEntityRetry = updateEntityRetry;
  }

  public Retry getDeleteEntityRetry() {
    return this.deleteEntityRetry;
  }

  public void setDeleteEntityRetry(Retry deleteEntityRetry) {
    this.deleteEntityRetry = deleteEntityRetry;
  }

  public Retry getGetEntityRetry() {
    return this.getEntityRetry;
  }

  public void setGetEntityRetry(Retry getEntityRetry) {
    this.getEntityRetry = getEntityRetry;
  }

  public Retry getListEntitiesRetry() {
    return this.listEntitiesRetry;
  }

  public void setListEntitiesRetry(Retry listEntitiesRetry) {
    this.listEntitiesRetry = listEntitiesRetry;
  }

  public Retry getCreatePartitionRetry() {
    return this.createPartitionRetry;
  }

  public void setCreatePartitionRetry(Retry createPartitionRetry) {
    this.createPartitionRetry = createPartitionRetry;
  }

  public Retry getDeletePartitionRetry() {
    return this.deletePartitionRetry;
  }

  public void setDeletePartitionRetry(Retry deletePartitionRetry) {
    this.deletePartitionRetry = deletePartitionRetry;
  }

  public Retry getGetPartitionRetry() {
    return this.getPartitionRetry;
  }

  public void setGetPartitionRetry(Retry getPartitionRetry) {
    this.getPartitionRetry = getPartitionRetry;
  }

  public Retry getListPartitionsRetry() {
    return this.listPartitionsRetry;
  }

  public void setListPartitionsRetry(Retry listPartitionsRetry) {
    this.listPartitionsRetry = listPartitionsRetry;
  }

  public Retry getListLocationsRetry() {
    return this.listLocationsRetry;
  }

  public void setListLocationsRetry(Retry listLocationsRetry) {
    this.listLocationsRetry = listLocationsRetry;
  }

  public Retry getGetLocationRetry() {
    return this.getLocationRetry;
  }

  public void setGetLocationRetry(Retry getLocationRetry) {
    this.getLocationRetry = getLocationRetry;
  }
}
