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

package com.google.cloud.aiplatform.v1.spring;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.ExecutorProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.cloud.aiplatform.v1.VertexRagDataServiceClient;
import com.google.cloud.aiplatform.v1.VertexRagDataServiceSettings;
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
 * Auto-configuration for {@link VertexRagDataServiceClient}.
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
@ConditionalOnClass(VertexRagDataServiceClient.class)
@ConditionalOnProperty(
    value = "com.google.cloud.aiplatform.v1.vertex-rag-data-service.enabled",
    matchIfMissing = true)
@EnableConfigurationProperties(VertexRagDataServiceSpringProperties.class)
public class VertexRagDataServiceSpringAutoConfiguration {
  private final VertexRagDataServiceSpringProperties clientProperties;
  private final CredentialsProvider credentialsProvider;
  private static final Log LOGGER =
      LogFactory.getLog(VertexRagDataServiceSpringAutoConfiguration.class);

  protected VertexRagDataServiceSpringAutoConfiguration(
      VertexRagDataServiceSpringProperties clientProperties,
      CredentialsProvider credentialsProvider)
      throws IOException {
    this.clientProperties = clientProperties;
    if (this.clientProperties.getCredentials().hasKey()) {
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Using credentials from VertexRagDataService-specific configuration");
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
  @ConditionalOnMissingBean(name = "defaultVertexRagDataServiceTransportChannelProvider")
  public TransportChannelProvider defaultVertexRagDataServiceTransportChannelProvider() {
    return VertexRagDataServiceSettings.defaultTransportChannelProvider();
  }

  /**
   * Provides a VertexRagDataServiceSettings bean configured to use a DefaultCredentialsProvider and
   * the client library's default transport channel provider
   * (defaultVertexRagDataServiceTransportChannelProvider()). It also configures the quota project
   * ID and executor thread count, if provided through properties.
   *
   * <p>Retry settings are also configured from service-level and method-level properties specified
   * in VertexRagDataServiceSpringProperties. Method-level properties will take precedence over
   * service-level properties if available, and client library defaults will be used if neither are
   * specified.
   *
   * @param defaultTransportChannelProvider TransportChannelProvider to use in the settings.
   * @return a {@link VertexRagDataServiceSettings} bean configured with {@link
   *     TransportChannelProvider} bean.
   */
  @Bean
  @ConditionalOnMissingBean
  public VertexRagDataServiceSettings vertexRagDataServiceSettings(
      @Qualifier("defaultVertexRagDataServiceTransportChannelProvider")
          TransportChannelProvider defaultTransportChannelProvider)
      throws IOException {
    VertexRagDataServiceSettings.Builder clientSettingsBuilder =
        VertexRagDataServiceSettings.newBuilder();
    clientSettingsBuilder
        .setCredentialsProvider(this.credentialsProvider)
        .setTransportChannelProvider(defaultTransportChannelProvider)
        .setEndpoint(VertexRagDataServiceSettings.getDefaultEndpoint())
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
          VertexRagDataServiceSettings.defaultExecutorProviderBuilder()
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
      RetrySettings getRagCorpusRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getRagCorpusSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getRagCorpusSettings().setRetrySettings(getRagCorpusRetrySettings);

      RetrySettings listRagCorporaRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listRagCorporaSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listRagCorporaSettings().setRetrySettings(listRagCorporaRetrySettings);

      RetrySettings uploadRagFileRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.uploadRagFileSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.uploadRagFileSettings().setRetrySettings(uploadRagFileRetrySettings);

      RetrySettings getRagFileRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getRagFileSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getRagFileSettings().setRetrySettings(getRagFileRetrySettings);

      RetrySettings listRagFilesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listRagFilesSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listRagFilesSettings().setRetrySettings(listRagFilesRetrySettings);

      RetrySettings getRagEngineConfigRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getRagEngineConfigSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .getRagEngineConfigSettings()
          .setRetrySettings(getRagEngineConfigRetrySettings);

      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);

      RetrySettings getLocationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLocationSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getLocationSettings().setRetrySettings(getLocationRetrySettings);

      RetrySettings setIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.setIamPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.setIamPolicySettings().setRetrySettings(setIamPolicyRetrySettings);

      RetrySettings getIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getIamPolicySettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder.getIamPolicySettings().setRetrySettings(getIamPolicyRetrySettings);

      RetrySettings testIamPermissionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.testIamPermissionsSettings().getRetrySettings(), serviceRetry);
      clientSettingsBuilder
          .testIamPermissionsSettings()
          .setRetrySettings(testIamPermissionsRetrySettings);

      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured service-level retry settings from properties.");
      }
    }
    Retry getRagCorpusRetry = clientProperties.getGetRagCorpusRetry();
    if (getRagCorpusRetry != null) {
      RetrySettings getRagCorpusRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getRagCorpusSettings().getRetrySettings(), getRagCorpusRetry);
      clientSettingsBuilder.getRagCorpusSettings().setRetrySettings(getRagCorpusRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getRagCorpus from properties.");
      }
    }
    Retry listRagCorporaRetry = clientProperties.getListRagCorporaRetry();
    if (listRagCorporaRetry != null) {
      RetrySettings listRagCorporaRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listRagCorporaSettings().getRetrySettings(),
              listRagCorporaRetry);
      clientSettingsBuilder.listRagCorporaSettings().setRetrySettings(listRagCorporaRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listRagCorpora from properties.");
      }
    }
    Retry uploadRagFileRetry = clientProperties.getUploadRagFileRetry();
    if (uploadRagFileRetry != null) {
      RetrySettings uploadRagFileRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.uploadRagFileSettings().getRetrySettings(), uploadRagFileRetry);
      clientSettingsBuilder.uploadRagFileSettings().setRetrySettings(uploadRagFileRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for uploadRagFile from properties.");
      }
    }
    Retry getRagFileRetry = clientProperties.getGetRagFileRetry();
    if (getRagFileRetry != null) {
      RetrySettings getRagFileRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getRagFileSettings().getRetrySettings(), getRagFileRetry);
      clientSettingsBuilder.getRagFileSettings().setRetrySettings(getRagFileRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getRagFile from properties.");
      }
    }
    Retry listRagFilesRetry = clientProperties.getListRagFilesRetry();
    if (listRagFilesRetry != null) {
      RetrySettings listRagFilesRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listRagFilesSettings().getRetrySettings(), listRagFilesRetry);
      clientSettingsBuilder.listRagFilesSettings().setRetrySettings(listRagFilesRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listRagFiles from properties.");
      }
    }
    Retry getRagEngineConfigRetry = clientProperties.getGetRagEngineConfigRetry();
    if (getRagEngineConfigRetry != null) {
      RetrySettings getRagEngineConfigRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getRagEngineConfigSettings().getRetrySettings(),
              getRagEngineConfigRetry);
      clientSettingsBuilder
          .getRagEngineConfigSettings()
          .setRetrySettings(getRagEngineConfigRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for getRagEngineConfig from properties.");
      }
    }
    Retry listLocationsRetry = clientProperties.getListLocationsRetry();
    if (listLocationsRetry != null) {
      RetrySettings listLocationsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.listLocationsSettings().getRetrySettings(), listLocationsRetry);
      clientSettingsBuilder.listLocationsSettings().setRetrySettings(listLocationsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for listLocations from properties.");
      }
    }
    Retry getLocationRetry = clientProperties.getGetLocationRetry();
    if (getLocationRetry != null) {
      RetrySettings getLocationRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getLocationSettings().getRetrySettings(), getLocationRetry);
      clientSettingsBuilder.getLocationSettings().setRetrySettings(getLocationRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getLocation from properties.");
      }
    }
    Retry setIamPolicyRetry = clientProperties.getSetIamPolicyRetry();
    if (setIamPolicyRetry != null) {
      RetrySettings setIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.setIamPolicySettings().getRetrySettings(), setIamPolicyRetry);
      clientSettingsBuilder.setIamPolicySettings().setRetrySettings(setIamPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for setIamPolicy from properties.");
      }
    }
    Retry getIamPolicyRetry = clientProperties.getGetIamPolicyRetry();
    if (getIamPolicyRetry != null) {
      RetrySettings getIamPolicyRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.getIamPolicySettings().getRetrySettings(), getIamPolicyRetry);
      clientSettingsBuilder.getIamPolicySettings().setRetrySettings(getIamPolicyRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace("Configured method-level retry settings for getIamPolicy from properties.");
      }
    }
    Retry testIamPermissionsRetry = clientProperties.getTestIamPermissionsRetry();
    if (testIamPermissionsRetry != null) {
      RetrySettings testIamPermissionsRetrySettings =
          RetryUtil.updateRetrySettings(
              clientSettingsBuilder.testIamPermissionsSettings().getRetrySettings(),
              testIamPermissionsRetry);
      clientSettingsBuilder
          .testIamPermissionsSettings()
          .setRetrySettings(testIamPermissionsRetrySettings);
      if (LOGGER.isTraceEnabled()) {
        LOGGER.trace(
            "Configured method-level retry settings for testIamPermissions from properties.");
      }
    }
    return clientSettingsBuilder.build();
  }

  /**
   * Provides a VertexRagDataServiceClient bean configured with VertexRagDataServiceSettings.
   *
   * @param vertexRagDataServiceSettings settings to configure an instance of client bean.
   * @return a {@link VertexRagDataServiceClient} bean configured with {@link
   *     VertexRagDataServiceSettings}
   */
  @Bean
  @ConditionalOnMissingBean
  public VertexRagDataServiceClient vertexRagDataServiceClient(
      VertexRagDataServiceSettings vertexRagDataServiceSettings) throws IOException {
    return VertexRagDataServiceClient.create(vertexRagDataServiceSettings);
  }

  private HeaderProvider userAgentHeaderProvider() {
    String springLibrary = "spring-autogen-vertex-rag-data-service";
    String version = this.getClass().getPackage().getImplementationVersion();
    return () -> Collections.singletonMap("user-agent", springLibrary + "/" + version);
  }
}
