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

package com.google.cloud.securesourcemanager.v1.spring;

import com.google.api.core.BetaApi;
import com.google.cloud.spring.core.Credentials;
import com.google.cloud.spring.core.CredentialsSupplier;
import com.google.cloud.spring.core.Retry;
import javax.annotation.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/** Provides default property values for SecureSourceManager client bean */
@Generated("by google-cloud-spring-generator")
@BetaApi("Autogenerated Spring autoconfiguration is not yet stable")
@ConfigurationProperties("com.google.cloud.securesourcemanager.v1.secure-source-manager")
public class SecureSourceManagerSpringProperties implements CredentialsSupplier {
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
   * Allow override of retry settings at method-level for listInstances. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listInstancesRetry;
  /**
   * Allow override of retry settings at method-level for getInstance. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getInstanceRetry;
  /**
   * Allow override of retry settings at method-level for listRepositories. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listRepositoriesRetry;
  /**
   * Allow override of retry settings at method-level for getRepository. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getRepositoryRetry;
  /**
   * Allow override of retry settings at method-level for listHooks. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listHooksRetry;
  /**
   * Allow override of retry settings at method-level for getHook. If defined, this takes precedence
   * over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getHookRetry;
  /**
   * Allow override of retry settings at method-level for getIamPolicyRepo. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getIamPolicyRepoRetry;
  /**
   * Allow override of retry settings at method-level for setIamPolicyRepo. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry setIamPolicyRepoRetry;
  /**
   * Allow override of retry settings at method-level for testIamPermissionsRepo. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry testIamPermissionsRepoRetry;
  /**
   * Allow override of retry settings at method-level for listBranchRules. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listBranchRulesRetry;
  /**
   * Allow override of retry settings at method-level for getBranchRule. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getBranchRuleRetry;
  /**
   * Allow override of retry settings at method-level for getPullRequest. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getPullRequestRetry;
  /**
   * Allow override of retry settings at method-level for listPullRequests. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listPullRequestsRetry;
  /**
   * Allow override of retry settings at method-level for listPullRequestFileDiffs. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listPullRequestFileDiffsRetry;
  /**
   * Allow override of retry settings at method-level for fetchTree. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry fetchTreeRetry;
  /**
   * Allow override of retry settings at method-level for fetchBlob. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry fetchBlobRetry;
  /**
   * Allow override of retry settings at method-level for getIssue. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getIssueRetry;
  /**
   * Allow override of retry settings at method-level for listIssues. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listIssuesRetry;
  /**
   * Allow override of retry settings at method-level for getPullRequestComment. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getPullRequestCommentRetry;
  /**
   * Allow override of retry settings at method-level for listPullRequestComments. If defined, this
   * takes precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listPullRequestCommentsRetry;
  /**
   * Allow override of retry settings at method-level for getIssueComment. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getIssueCommentRetry;
  /**
   * Allow override of retry settings at method-level for listIssueComments. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry listIssueCommentsRetry;
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
  /**
   * Allow override of retry settings at method-level for setIamPolicy. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry setIamPolicyRetry;
  /**
   * Allow override of retry settings at method-level for getIamPolicy. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry getIamPolicyRetry;
  /**
   * Allow override of retry settings at method-level for testIamPermissions. If defined, this takes
   * precedence over service-level retry configurations for that RPC method.
   */
  @NestedConfigurationProperty private Retry testIamPermissionsRetry;

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

  public Retry getListInstancesRetry() {
    return this.listInstancesRetry;
  }

  public void setListInstancesRetry(Retry listInstancesRetry) {
    this.listInstancesRetry = listInstancesRetry;
  }

  public Retry getGetInstanceRetry() {
    return this.getInstanceRetry;
  }

  public void setGetInstanceRetry(Retry getInstanceRetry) {
    this.getInstanceRetry = getInstanceRetry;
  }

  public Retry getListRepositoriesRetry() {
    return this.listRepositoriesRetry;
  }

  public void setListRepositoriesRetry(Retry listRepositoriesRetry) {
    this.listRepositoriesRetry = listRepositoriesRetry;
  }

  public Retry getGetRepositoryRetry() {
    return this.getRepositoryRetry;
  }

  public void setGetRepositoryRetry(Retry getRepositoryRetry) {
    this.getRepositoryRetry = getRepositoryRetry;
  }

  public Retry getListHooksRetry() {
    return this.listHooksRetry;
  }

  public void setListHooksRetry(Retry listHooksRetry) {
    this.listHooksRetry = listHooksRetry;
  }

  public Retry getGetHookRetry() {
    return this.getHookRetry;
  }

  public void setGetHookRetry(Retry getHookRetry) {
    this.getHookRetry = getHookRetry;
  }

  public Retry getGetIamPolicyRepoRetry() {
    return this.getIamPolicyRepoRetry;
  }

  public void setGetIamPolicyRepoRetry(Retry getIamPolicyRepoRetry) {
    this.getIamPolicyRepoRetry = getIamPolicyRepoRetry;
  }

  public Retry getSetIamPolicyRepoRetry() {
    return this.setIamPolicyRepoRetry;
  }

  public void setSetIamPolicyRepoRetry(Retry setIamPolicyRepoRetry) {
    this.setIamPolicyRepoRetry = setIamPolicyRepoRetry;
  }

  public Retry getTestIamPermissionsRepoRetry() {
    return this.testIamPermissionsRepoRetry;
  }

  public void setTestIamPermissionsRepoRetry(Retry testIamPermissionsRepoRetry) {
    this.testIamPermissionsRepoRetry = testIamPermissionsRepoRetry;
  }

  public Retry getListBranchRulesRetry() {
    return this.listBranchRulesRetry;
  }

  public void setListBranchRulesRetry(Retry listBranchRulesRetry) {
    this.listBranchRulesRetry = listBranchRulesRetry;
  }

  public Retry getGetBranchRuleRetry() {
    return this.getBranchRuleRetry;
  }

  public void setGetBranchRuleRetry(Retry getBranchRuleRetry) {
    this.getBranchRuleRetry = getBranchRuleRetry;
  }

  public Retry getGetPullRequestRetry() {
    return this.getPullRequestRetry;
  }

  public void setGetPullRequestRetry(Retry getPullRequestRetry) {
    this.getPullRequestRetry = getPullRequestRetry;
  }

  public Retry getListPullRequestsRetry() {
    return this.listPullRequestsRetry;
  }

  public void setListPullRequestsRetry(Retry listPullRequestsRetry) {
    this.listPullRequestsRetry = listPullRequestsRetry;
  }

  public Retry getListPullRequestFileDiffsRetry() {
    return this.listPullRequestFileDiffsRetry;
  }

  public void setListPullRequestFileDiffsRetry(Retry listPullRequestFileDiffsRetry) {
    this.listPullRequestFileDiffsRetry = listPullRequestFileDiffsRetry;
  }

  public Retry getFetchTreeRetry() {
    return this.fetchTreeRetry;
  }

  public void setFetchTreeRetry(Retry fetchTreeRetry) {
    this.fetchTreeRetry = fetchTreeRetry;
  }

  public Retry getFetchBlobRetry() {
    return this.fetchBlobRetry;
  }

  public void setFetchBlobRetry(Retry fetchBlobRetry) {
    this.fetchBlobRetry = fetchBlobRetry;
  }

  public Retry getGetIssueRetry() {
    return this.getIssueRetry;
  }

  public void setGetIssueRetry(Retry getIssueRetry) {
    this.getIssueRetry = getIssueRetry;
  }

  public Retry getListIssuesRetry() {
    return this.listIssuesRetry;
  }

  public void setListIssuesRetry(Retry listIssuesRetry) {
    this.listIssuesRetry = listIssuesRetry;
  }

  public Retry getGetPullRequestCommentRetry() {
    return this.getPullRequestCommentRetry;
  }

  public void setGetPullRequestCommentRetry(Retry getPullRequestCommentRetry) {
    this.getPullRequestCommentRetry = getPullRequestCommentRetry;
  }

  public Retry getListPullRequestCommentsRetry() {
    return this.listPullRequestCommentsRetry;
  }

  public void setListPullRequestCommentsRetry(Retry listPullRequestCommentsRetry) {
    this.listPullRequestCommentsRetry = listPullRequestCommentsRetry;
  }

  public Retry getGetIssueCommentRetry() {
    return this.getIssueCommentRetry;
  }

  public void setGetIssueCommentRetry(Retry getIssueCommentRetry) {
    this.getIssueCommentRetry = getIssueCommentRetry;
  }

  public Retry getListIssueCommentsRetry() {
    return this.listIssueCommentsRetry;
  }

  public void setListIssueCommentsRetry(Retry listIssueCommentsRetry) {
    this.listIssueCommentsRetry = listIssueCommentsRetry;
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

  public Retry getSetIamPolicyRetry() {
    return this.setIamPolicyRetry;
  }

  public void setSetIamPolicyRetry(Retry setIamPolicyRetry) {
    this.setIamPolicyRetry = setIamPolicyRetry;
  }

  public Retry getGetIamPolicyRetry() {
    return this.getIamPolicyRetry;
  }

  public void setGetIamPolicyRetry(Retry getIamPolicyRetry) {
    this.getIamPolicyRetry = getIamPolicyRetry;
  }

  public Retry getTestIamPermissionsRetry() {
    return this.testIamPermissionsRetry;
  }

  public void setTestIamPermissionsRetry(Retry testIamPermissionsRetry) {
    this.testIamPermissionsRetry = testIamPermissionsRetry;
  }
}
