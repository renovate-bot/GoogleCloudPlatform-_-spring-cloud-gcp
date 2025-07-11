/*
 * Copyright 2017-2020 the original author or authors.
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

package com.google.cloud.spring.secretmanager;

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.secretmanager.v1.AddSecretVersionRequest;
import com.google.cloud.secretmanager.v1.CreateSecretRequest;
import com.google.cloud.secretmanager.v1.DeleteSecretRequest;
import com.google.cloud.secretmanager.v1.LocationName;
import com.google.cloud.secretmanager.v1.ProjectName;
import com.google.cloud.secretmanager.v1.Replication;
import com.google.cloud.secretmanager.v1.Secret;
import com.google.cloud.secretmanager.v1.SecretManagerServiceClient;
import com.google.cloud.secretmanager.v1.SecretName;
import com.google.cloud.secretmanager.v1.SecretPayload;
import com.google.cloud.secretmanager.v1.SecretVersionName;
import com.google.cloud.spring.core.GcpProjectIdProvider;
import com.google.protobuf.ByteString;
import javax.annotation.Nullable;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.ObjectUtils;

/**
 * Offers convenience methods for performing common operations on Secret Manager including creating
 * and reading secrets.
 *
 * @since 1.2.2
 */
public class SecretManagerTemplate implements SecretManagerOperations {

  /**
   * Default value for the latest version of the secret.
   */
  public static final String LATEST_VERSION = "latest";

  /**
   * Default value for the latest version of the secret.
   */
  public static final String GLOBAL_LOCATION = "global";

  private static final Log LOGGER = LogFactory.getLog(SecretManagerTemplate.class);
  private final SecretManagerServiceClient secretManagerServiceClient;
  private final SecretManagerServiceClientFactory clientFactory;
  private final GcpProjectIdProvider projectIdProvider;
  /**
   * Define the behavior when accessing a non-existed secret string/bytes.
   */
  private boolean allowDefaultSecretValue;

  // Constructor for SecretManagerServiceClient
  public SecretManagerTemplate(
      SecretManagerServiceClient secretManagerServiceClient,
      GcpProjectIdProvider projectIdProvider) {
    this(secretManagerServiceClient, null, projectIdProvider);
  }

  // Constructor for SecretManagerServiceClientFactory
  public SecretManagerTemplate(
      SecretManagerServiceClientFactory clientFactory,
      GcpProjectIdProvider projectIdProvider) {
    this(clientFactory.getClient(GLOBAL_LOCATION), clientFactory, projectIdProvider);
  }

  // Private constructor that initializes common fields
  private SecretManagerTemplate(
      SecretManagerServiceClient secretManagerServiceClient,
      SecretManagerServiceClientFactory clientFactory,
      GcpProjectIdProvider projectIdProvider) {
    this.secretManagerServiceClient = secretManagerServiceClient;
    this.clientFactory = clientFactory;
    this.projectIdProvider = projectIdProvider;
    this.allowDefaultSecretValue = false;
  }

  private SecretManagerServiceClient getClient(@Nullable String locationId) {
    return clientFactory == null
        ? secretManagerServiceClient
        : clientFactory.getClient(locationId);
  }

  public SecretManagerTemplate setAllowDefaultSecretValue(boolean allowDefaultSecretValue) {
    this.allowDefaultSecretValue = allowDefaultSecretValue;

    return this;
  }

  public String getProjectId() {
    return projectIdProvider.getProjectId();
  }

  @Override
  public void createSecret(String secretId, String payload) {
    createNewSecretVersion(
        secretId, ByteString.copyFromUtf8(payload), projectIdProvider.getProjectId(), null);
  }

  @Override
  public void createSecret(String secretId, String payload, String locationId) {
    createNewSecretVersion(
        secretId, ByteString.copyFromUtf8(payload), projectIdProvider.getProjectId(), locationId);
  }


  @Override
  public void createSecret(String secretId, byte[] payload) {
    createNewSecretVersion(
        secretId, ByteString.copyFrom(payload), projectIdProvider.getProjectId(), null);
  }

  @Override
  public void createSecret(String secretId, byte[] payload, String projectId) {
    createNewSecretVersion(secretId, ByteString.copyFrom(payload), projectId, null);
  }

  @Override
  public void createSecret(String secretId, byte[] payload, String projectId, String locationId) {
    createNewSecretVersion(secretId, ByteString.copyFrom(payload), projectId, locationId);
  }

  @Override
  @Nullable
  public String getSecretString(String secretIdentifier) {
    ByteString secretByteString = getSecretByteString(secretIdentifier);
    return secretByteString == null ? null : secretByteString.toStringUtf8();
  }


  @Override
  @Nullable
  public byte[] getSecretBytes(String secretIdentifier) {
    ByteString secretByteString = getSecretByteString(secretIdentifier);
    return secretByteString == null ? null : secretByteString.toByteArray();
  }


  @Override
  public boolean secretExists(String secretId) {
    return secretExists(secretId, this.projectIdProvider.getProjectId());
  }

  @Override
  public boolean secretExists(String secretId, String projectId) {
    SecretName secretName = getSecretName(projectId, secretId, null);
    try {
      getClient(GLOBAL_LOCATION).getSecret(secretName);
    } catch (NotFoundException ex) {
      return false;
    }

    return true;
  }

  @Override
  public boolean secretExists(String secretId, String projectId, String locationId) {
    SecretName secretName = getSecretName(projectId, secretId, locationId);
    try {
      getClient(locationId).getSecret(secretName);
    } catch (NotFoundException ex) {
      return false;
    }

    return true;
  }

  @Override
  public void disableSecretVersion(String secretId, String version) {
    disableSecretVersion(secretId, version, this.projectIdProvider.getProjectId());
  }

  @Override
  public void disableSecretVersion(String secretId, String version, String projectId) {
    SecretVersionName secretVersionName =
        SecretManagerPropertyUtils.getSecretVersionName(
            projectId, secretId, version, null);
    getClient(GLOBAL_LOCATION).disableSecretVersion(secretVersionName);
  }

  @Override
  public void disableSecretVersion(String secretId, String version, String projectId, String locationId) {
    SecretVersionName secretVersionName =
        SecretManagerPropertyUtils.getSecretVersionName(
            projectId, secretId, version, locationId);
    getClient(locationId).disableSecretVersion(secretVersionName);
  }

  @Override
  public void enableSecretVersion(String secretId, String version) {
    enableSecretVersion(secretId, version, this.projectIdProvider.getProjectId());
  }

  @Override
  public void enableSecretVersion(String secretId, String version, String projectId) {
    SecretVersionName secretVersionName =
        SecretManagerPropertyUtils.getSecretVersionName(
            projectId, secretId, version, null);
    getClient(GLOBAL_LOCATION).enableSecretVersion(secretVersionName);
  }

  @Override
  public void enableSecretVersion(String secretId, String version, String projectId, String locationId) {
    SecretVersionName secretVersionName =
        SecretManagerPropertyUtils.getSecretVersionName(
            projectId, secretId, version, locationId);
    getClient(locationId).enableSecretVersion(secretVersionName);
  }

  @Override
  public void deleteSecret(String secretId) {
    deleteSecret(secretId, this.projectIdProvider.getProjectId());
  }

  @Override
  public void deleteSecret(String secretId, String projectId) {
    SecretName name = getSecretName(projectId, secretId, null);
    DeleteSecretRequest request = DeleteSecretRequest.newBuilder().setName(name.toString()).build();
    getClient(GLOBAL_LOCATION).deleteSecret(request);
  }

  @Override
  public void deleteSecret(String secretId, String projectId, String locationId) {
    SecretName name = getSecretName(projectId, secretId, locationId);
    DeleteSecretRequest request = DeleteSecretRequest.newBuilder().setName(name.toString()).build();
    getClient(locationId).deleteSecret(request);
  }

  @Override
  public void deleteSecretVersion(String secretId, String version, String projectId) {
    SecretVersionName secretVersionName =
        SecretManagerPropertyUtils.getSecretVersionName(
            projectId, secretId, version, null);
    getClient(GLOBAL_LOCATION).destroySecretVersion(secretVersionName);
  }

  @Override
  public void deleteSecretVersion(String secretId, String version, String projectId, String locationId) {
    SecretVersionName secretVersionName =
        SecretManagerPropertyUtils.getSecretVersionName(
            projectId, secretId, version, locationId);
    getClient(locationId).destroySecretVersion(secretVersionName);
  }

  ByteString getSecretByteString(String secretIdentifier) {
    SecretVersionName secretVersionName = SecretManagerPropertyUtils.getSecretVersionName(
        secretIdentifier, this.projectIdProvider);

    if (secretVersionName == null) {
      secretVersionName = getDefaultSecretVersionName(secretIdentifier);
    }

    return getSecretByteString(secretVersionName);
  }

  ByteString getSecretByteString(SecretVersionName secretVersionName) {
    ByteString secretData;
    try {
      secretData =
        getClient(secretVersionName.getLocation()).accessSecretVersion(secretVersionName).getPayload().getData();
    } catch (NotFoundException ex) {
      LOGGER.warn(secretVersionName.toString() + " doesn't exist in Secret Manager.");
      if (!this.allowDefaultSecretValue) {
        throw ex;
      }
      // If no secret is found in Secret Manager and default secret is allowed,
      // returns null rather than throwing the exception to facilitate default
      // secret value parsing.
      // See https://github.com/GoogleCloudPlatform/spring-cloud-gcp/issues/213
      return null;
    }

    return secretData;
  }

  /**
   * Create a new version of the secret with the specified payload under a {@link Secret}. Will also
   * create the parent secret if it does not already exist.
   */
  private void createNewSecretVersion(String secretId, ByteString payload, String projectId, String locationId) {
    if (!secretExists(secretId, projectId, locationId)) {
      createSecretInternal(secretId, projectId, locationId);
    }

    SecretName name = getSecretName(projectId, secretId, locationId);
    AddSecretVersionRequest payloadRequest =
        AddSecretVersionRequest.newBuilder()
            .setParent(name.toString())
            .setPayload(SecretPayload.newBuilder().setData(payload))
            .build();
    getClient(locationId).addSecretVersion(payloadRequest);
  }

  /**
   * Creates a new secret for the GCP Project.
   *
   * <p>Note that the {@link Secret} object does not contain the secret payload. You must create
   * versions of the secret which stores the payload of the secret.
   */
  private void createSecretInternal(String secretId, String projectId, String locationId) {
    Secret.Builder secret = Secret.newBuilder();
    String parent;
    if (ObjectUtils.isEmpty(locationId)) {
      secret.setReplication(
          Replication.newBuilder().setAutomatic(Replication.Automatic.getDefaultInstance())
      );
      parent = ProjectName.of(projectId).toString();
    } else {
      parent = LocationName.of(projectId, locationId).toString();
    }
    CreateSecretRequest request =
        CreateSecretRequest.newBuilder()
            .setParent(parent)
            .setSecretId(secretId)
            .setSecret(secret.build())
            .build();
    getClient(locationId).createSecret(request);
  }

  private SecretVersionName getDefaultSecretVersionName(String secretId) {
    return SecretManagerPropertyUtils.getSecretVersionName(
        this.projectIdProvider.getProjectId(), secretId, LATEST_VERSION, null);
  }

  private SecretName getSecretName(String projectId, String secretId, String locationId) {
    if (ObjectUtils.isEmpty(locationId)) {
      return SecretName.of(projectId, secretId);
    } else {
      return SecretName.ofProjectLocationSecretName(projectId, locationId, secretId);
    }
  }
}
