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

package com.google.cloud.tpu.v2.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.Retry;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for Tpu client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.cloud.tpu.v2.tpu")
public class TpuSpringProperties implements CredentialsSupplier {
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
   * Allow override of retry settings at method-level for listNodes. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listNodesRetry;
  /**
   * Allow override of retry settings at method-level for getNode. If defined, this takes precedence
   * over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getNodeRetry;
  /**
   * Allow override of retry settings at method-level for listQueuedResources. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listQueuedResourcesRetry;
  /**
   * Allow override of retry settings at method-level for getQueuedResource. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getQueuedResourceRetry;
  /**
   * Allow override of retry settings at method-level for generateServiceIdentity. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry generateServiceIdentityRetry;
  /**
   * Allow override of retry settings at method-level for listAcceleratorTypes. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listAcceleratorTypesRetry;
  /**
   * Allow override of retry settings at method-level for getAcceleratorType. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getAcceleratorTypeRetry;
  /**
   * Allow override of retry settings at method-level for listRuntimeVersions. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listRuntimeVersionsRetry;
  /**
   * Allow override of retry settings at method-level for getRuntimeVersion. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getRuntimeVersionRetry;
  /**
   * Allow override of retry settings at method-level for getGuestAttributes. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getGuestAttributesRetry;
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

  public Retry getListNodesRetry() {
    return this.listNodesRetry;
  }

  public void setListNodesRetry(Retry listNodesRetry) {
    this.listNodesRetry = listNodesRetry;
  }

  public Retry getGetNodeRetry() {
    return this.getNodeRetry;
  }

  public void setGetNodeRetry(Retry getNodeRetry) {
    this.getNodeRetry = getNodeRetry;
  }

  public Retry getListQueuedResourcesRetry() {
    return this.listQueuedResourcesRetry;
  }

  public void setListQueuedResourcesRetry(Retry listQueuedResourcesRetry) {
    this.listQueuedResourcesRetry = listQueuedResourcesRetry;
  }

  public Retry getGetQueuedResourceRetry() {
    return this.getQueuedResourceRetry;
  }

  public void setGetQueuedResourceRetry(Retry getQueuedResourceRetry) {
    this.getQueuedResourceRetry = getQueuedResourceRetry;
  }

  public Retry getGenerateServiceIdentityRetry() {
    return this.generateServiceIdentityRetry;
  }

  public void setGenerateServiceIdentityRetry(Retry generateServiceIdentityRetry) {
    this.generateServiceIdentityRetry = generateServiceIdentityRetry;
  }

  public Retry getListAcceleratorTypesRetry() {
    return this.listAcceleratorTypesRetry;
  }

  public void setListAcceleratorTypesRetry(Retry listAcceleratorTypesRetry) {
    this.listAcceleratorTypesRetry = listAcceleratorTypesRetry;
  }

  public Retry getGetAcceleratorTypeRetry() {
    return this.getAcceleratorTypeRetry;
  }

  public void setGetAcceleratorTypeRetry(Retry getAcceleratorTypeRetry) {
    this.getAcceleratorTypeRetry = getAcceleratorTypeRetry;
  }

  public Retry getListRuntimeVersionsRetry() {
    return this.listRuntimeVersionsRetry;
  }

  public void setListRuntimeVersionsRetry(Retry listRuntimeVersionsRetry) {
    this.listRuntimeVersionsRetry = listRuntimeVersionsRetry;
  }

  public Retry getGetRuntimeVersionRetry() {
    return this.getRuntimeVersionRetry;
  }

  public void setGetRuntimeVersionRetry(Retry getRuntimeVersionRetry) {
    this.getRuntimeVersionRetry = getRuntimeVersionRetry;
  }

  public Retry getGetGuestAttributesRetry() {
    return this.getGuestAttributesRetry;
  }

  public void setGetGuestAttributesRetry(Retry getGuestAttributesRetry) {
    this.getGuestAttributesRetry = getGuestAttributesRetry;
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
