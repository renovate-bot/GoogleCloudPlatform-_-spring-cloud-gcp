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

package com.google.cloud.assuredworkloads.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.assuredworkloads.v1.AssuredWorkloadsServiceClient;
import com.google.cloud.assuredworkloads.v1.AssuredWorkloadsServiceSettings;
import com.google.cloud.spring.autoconfigure.core.GcpContextAutoConfiguration;
import com.google.cloud.spring.core.DefaultCredentialsProvider;
import com.google.cloud.spring.core.Retry;
import com.google.cloud.spring.core.util.RetryUtil;
import java.io.IOException;
import java.util.Collections;
import javax.annotation.Generated;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Auto-configuration for {@link AssuredWorkloadsServiceClient}.
 *
 * <p>Provides auto-configuration for Spring Boot
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default transport provider is used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@AutoConfiguration
@AutoConfigureAfter(GcpContextAutoConfiguration.class)
@ConditionalOnClass(AssuredWorkloadsServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.assuredworkloads.v1.assured-workloads-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(AssuredWorkloadsServiceSpringProperties.class)
public class AssuredWorkloadsServiceSpringAutoConfiguration {
  private final AssuredWorkloadsServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER =
      LogFactory.getLog(AssuredWorkloadsServiceSpringAutoConfiguration.class);

  protected AssuredWorkloadsServiceSpringAutoConfiguration(
      AssuredWorkloadsServiceSpringProperties clientProperties,
      CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from AssuredWorkloadsService-specific configuration");
      }
      this.credentialsProvider =
          ((CredentialsProvider) new DefaultCredentialsProvider(this.clientProperties));
    } else {
      this.credentialsProvider = credentialsProvider;
    }
  }

  /**
   * Provides a default transport channel provider bean, corresponding to the client library's
   * default transport channel provider. If the library supports both GRPC and REST transport, and
   * the useRest property is configured, the HTTP/JSON transport provider will be used instead of
   * GRPC.
   *
   * @return a default transport channel provider.
   */
  @Bean
  @ConditionalOnMissingBean(name = "defaultAssuredWorkloadsServiceTransportChannelProvider")
  public TransportChannelProvider defaultAssuredWorkloadsServiceTransportChannelProvider() {
    if (this.clientProperties.getUseRest()) {
      return AssuredWorkloadsServiceSettings.defaultHttpJsonTransportProviderBuilder().build();
    }
    return AssuredWorkloadsServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a AssuredWorkloadsServiceSettings bean configured to use a DefaultCredentialsProvider
   * and the client library's default transport channel provider
   * (defaultAssuredWorkloadsServiceTransportChannelProvider()). It also configures the quota
   * project ID and executor thread count, if provided through properties.
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in AssuredWorkloadsServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link AssuredWorkloadsServiceSettings} bean configured with {@link
   *     TransportChannelProvider} bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public AssuredWorkloadsServiceSettings assuredWorkloadsServiceSettings(
      @Qualifier("defaultAssuredWorkloadsServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    AssuredWorkloadsServiceSettings.Builder clientSettingsBuilder;
    if (this.clientProperties.getUseRest()) {
      clientSettingsBuilder = AssuredWorkloadsServiceSettings.newHttpJsonBuilder();
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using REST (HTTP/JSON) transport.");
      }
    } else {
      clientSettingsBuilder = AssuredWorkloadsServiceSettings.newBuilder();
    }
    clientSettingsBuilder
        .setCredentialsProvider(this.credentialsProvider)
        .setTransportChannelProvider(defaultTransportChannelProvider)
        .setEndpoint(AssuredWorkloadsServiceSettings.getDefaultEndpoint())
        .setHeaderProvider(this.userAgentHeaderProvider());
    if (this.clientProperties.getQuotaProjectId() != null) {
      clientSettingsBuilder.setQuotaProjectId(this.clientProperties.getQuotaProjectId());
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Quota project id set to "
                + this.clientProperties.getQuotaProjectId()
                + ", this overrides project id from credentials.");
      }
    }
    if (this.clientProperties.getExecutorThreadCount() != null) {
      ExecutorProvider executorProvider =
          AssuredWorkloadsServiceSettings.defaultExecutorProviderBuilder()
              .setExecutorThreadCount(this.clientProperties.getExecutorThreadCount())
              .build();
      clientSettingsBuilder.setBackgroundExecutorProvider(executorProvider);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Background executor thread count is "
                + this.clientProperties.getExecutorThreadCount());
      }
    }
    Retry serviceRetry = clientProperties.getRetry();
    if (serviceRetry != null) {
      RetrySettings updateWorkloadRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateWorkloadSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.updateWorkloadSettings().setRetrySettings(updateWorkloadRetrySettings);

      RetrySettings restrictAllowedResourcesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.restrictAllowedResourcesSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .restrictAllowedResourcesSettings()
          .setRetrySettings(restrictAllowedResourcesRetrySettings);

      RetrySettings deleteWorkloadRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteWorkloadSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.deleteWorkloadSettings().setRetrySettings(deleteWorkloadRetrySettings);

      RetrySettings getWorkloadRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getWorkloadSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getWorkloadSettings().setRetrySettings(getWorkloadRetrySettings);

      RetrySettings listWorkloadsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listWorkloadsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listWorkloadsSettings().setRetrySettings(listWorkloadsRetrySettings);

      RetrySettings listViolationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listViolationsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listViolationsSettings().setRetrySettings(listViolationsRetrySettings);

      RetrySettings getViolationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getViolationSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getViolationSettings().setRetrySettings(getViolationRetrySettings);

      RetrySettings acknowledgeViolationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.acknowledgeViolationSettings().getRetrySettings(),
              serviceRetry);
      clientSettingsBuilder
          .acknowledgeViolationSettings()
          .setRetrySettings(acknowledgeViolationRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry updateWorkloadRetry = clientProperties.getUpdateWorkloadRetry();
    if (updateWorkloadRetry != null) {
      RetrySettings updateWorkloadRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.updateWorkloadSettings().getRetrySettings(),
              updateWorkloadRetry);
      clientSettingsBuilder.updateWorkloadSettings().setRetrySettings(updateWorkloadRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for updateWorkload from properties.");
      }
    }
    Retry restrictAllowedResourcesRetry = clientProperties.getRestrictAllowedResourcesRetry();
    if (restrictAllowedResourcesRetry != null) {
      RetrySettings restrictAllowedResourcesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.restrictAllowedResourcesSettings().getRetrySettings(),
              restrictAllowedResourcesRetry);
      clientSettingsBuilder
          .restrictAllowedResourcesSettings()
          .setRetrySettings(restrictAllowedResourcesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for restrictAllowedResources from properties.");
      }
    }
    Retry deleteWorkloadRetry = clientProperties.getDeleteWorkloadRetry();
    if (deleteWorkloadRetry != null) {
      RetrySettings deleteWorkloadRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.deleteWorkloadSettings().getRetrySettings(),
              deleteWorkloadRetry);
      clientSettingsBuilder.deleteWorkloadSettings().setRetrySettings(deleteWorkloadRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for deleteWorkload from properties.");
      }
    }
    Retry getWorkloadRetry = clientProperties.getGetWorkloadRetry();
    if (getWorkloadRetry != null) {
      RetrySettings getWorkloadRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getWorkloadSettings().getRetrySettings(), getWorkloadRetry);
      clientSettingsBuilder.getWorkloadSettings().setRetrySettings(getWorkloadRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getWorkload from properties.");
      }
    }
    Retry listWorkloadsRetry = clientProperties.getListWorkloadsRetry();
    if (listWorkloadsRetry != null) {
      RetrySettings listWorkloadsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listWorkloadsSettings().getRetrySettings(), listWorkloadsRetry);
      clientSettingsBuilder.listWorkloadsSettings().setRetrySettings(listWorkloadsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listWorkloads from properties.");
      }
    }
    Retry listViolationsRetry = clientProperties.getListViolationsRetry();
    if (listViolationsRetry != null) {
      RetrySettings listViolationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listViolationsSettings().getRetrySettings(),
              listViolationsRetry);
      clientSettingsBuilder.listViolationsSettings().setRetrySettings(listViolationsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listViolations from properties.");
      }
    }
    Retry getViolationRetry = clientProperties.getGetViolationRetry();
    if (getViolationRetry != null) {
      RetrySettings getViolationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getViolationSettings().getRetrySettings(), getViolationRetry);
      clientSettingsBuilder.getViolationSettings().setRetrySettings(getViolationRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getViolation from properties.");
      }
    }
    Retry acknowledgeViolationRetry = clientProperties.getAcknowledgeViolationRetry();
    if (acknowledgeViolationRetry != null) {
      RetrySettings acknowledgeViolationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.acknowledgeViolationSettings().getRetrySettings(),
              acknowledgeViolationRetry);
      clientSettingsBuilder
          .acknowledgeViolationSettings()
          .setRetrySettings(acknowledgeViolationRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for acknowledgeViolation from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  /**
   * Provides a AssuredWorkloadsServiceClient bean configured with AssuredWorkloadsServiceSettings.
   *
   * @param assuredWorkloadsServiceSettings settings to configure an instance of client bean.
   * @return a {@link AssuredWorkloadsServiceClient} bean configured with {@link
   *     AssuredWorkloadsServiceSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public AssuredWorkloadsServiceClient assuredWorkloadsServiceClient(
      AssuredWorkloadsServiceSettings assuredWorkloadsServiceSettings) throws IOException {
    return AssuredWorkloadsServiceClient.create(assuredWorkloadsServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-assured-workloads-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
