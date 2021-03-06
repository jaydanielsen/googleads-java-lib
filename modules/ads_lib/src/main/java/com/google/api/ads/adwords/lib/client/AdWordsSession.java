// Copyright 2011 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.api.ads.adwords.lib.client;

import com.google.api.ads.adwords.lib.client.reporting.ReportingConfiguration;
import com.google.api.ads.common.lib.auth.OAuth2Compatible;
import com.google.api.ads.common.lib.client.AdsSession;
import com.google.api.ads.common.lib.conf.ConfigurationHelper;
import com.google.api.ads.common.lib.conf.ConfigurationLoadException;
import com.google.api.ads.common.lib.exception.ValidationException;
import com.google.api.client.auth.oauth2.Credential;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import org.apache.commons.configuration.Configuration;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Nullable;

/**
 * A {@code AdWordsSession} represents a single session of AdWords use.
 *
 * <p>
 * Implementation is not thread-safe.
 * </p>
 */
public class AdWordsSession implements AdsSession, OAuth2Compatible {

  private String clientCustomerId;
  private Long expressBusinessId;
  private String expressPlusPageId;
  private Boolean isValidateOnly;
  private Boolean isPartialFailure;
  private Credential oAuth2Credential;
  private ReportingConfiguration reportingConfiguration;

  private final String userAgent;
  private final String developerToken;
  private final String endpoint;

  public static final String DEFAULT_ENDPOINT = "https://adwords.google.com/";
  
  private static final String DEFAULT_USER_AGENT = "INSERT_USERAGENT_HERE";

  /**
   * Private constructor.
   *
   * @param builder the AdWordsSession builder
   */
  private AdWordsSession(Builder builder) {
    this.clientCustomerId = builder.clientCustomerId;
    this.developerToken = builder.developerToken;
    this.endpoint = builder.endpoint;
    this.isPartialFailure = builder.isPartialFailure;
    this.isValidateOnly = builder.isValidateOnly;
    this.oAuth2Credential = builder.oAuth2Credential;
    this.userAgent = builder.userAgent;
    this.reportingConfiguration = builder.reportingConfiguration;
  }

  /**
   * Gets the client customer ID.
   */
  public String getClientCustomerId() {
    return clientCustomerId;
  }

  /**
   * Sets the client customer ID.
   */
  public void setClientCustomerId(String clientCustomerId) {
    this.clientCustomerId = clientCustomerId;
  }

  /**
   * Gets the AdWords Express business ID used by AdWords Express PromotionService.
   */
  @Nullable
  public Long getExpressBusinessId() {
    return expressBusinessId;
  }

  /**
   * Sets the AdWords Express business ID used by AdWords Express PromotionService.
   * 
   * <p>When using PromotionService, either set this value or the express plus page ID,
   * but not both.
   */
  public void setExpressBusinessId(@Nullable Long businessId) {
    this.expressBusinessId = businessId;
  }

  /**
   * Gets the Google+ page ID for the Google My Business location used by AdWords Express
   * PromotionService.
   */
  @Nullable
  public String getExpressPlusPageId() {
    return expressPlusPageId;
  }

  /**
   * Sets the Google+ page ID for the Google My Business location used by AdWords Express
   * PromotionService.
   * 
   * <p>When using PromotionService, either set this value or the express business ID,
   * but not both.
   */
  public void setExpressPlusPageId(String expressPlusPageId) {
    this.expressPlusPageId = expressPlusPageId;
  }
  
  /**
   * Returns {@code true} if the session should only validate the request.
   */
  @Nullable
  public Boolean isValidateOnly() {
    return isValidateOnly;
  }

  /**
   * Sets whether this session should only validate the request.
   */
  public void setValidateOnly(@Nullable Boolean isValidateOnly) {
    this.isValidateOnly = isValidateOnly;
  }

  /**
   * @return the userAgent
   */
  public String getUserAgent() {
    return userAgent;
  }

  /**
   * @return the developerToken
   */
  public String getDeveloperToken() {
    return developerToken;
  }

  /**
   * @return the isPartialFailure
   */
  @Nullable
  public Boolean isPartialFailure() {
    return isPartialFailure;
  }

  /**
   * Sets whether this session should allow partial failure.
   */
  public void setPartialFailure(@Nullable Boolean isPartialFailure) {
    this.isPartialFailure = isPartialFailure;
  }

  /**
   * Gets the OAuth2 credentials.
   */
  @Override
  public Credential getOAuth2Credential() {
    return oAuth2Credential;
  }

  /**
   * Sets the OAuth2 credential. Any other authentication credentials on the
   * session will be removed.
   */
  public void setOAuth2Credential(Credential oAuth2Credential) {
    Preconditions.checkNotNull(oAuth2Credential, "oAuth2Credential cannot be null.");
    clearAuthentication();
    this.oAuth2Credential = oAuth2Credential;
  }

  /**
   * Gets the reporting configuration.
   */
  @Nullable
  public ReportingConfiguration getReportingConfiguration() {
    return reportingConfiguration;
  }

  /**
   * Sets the reporting configuration.
   */
  public void setReportingConfiguration(@Nullable ReportingConfiguration reportingConfiguration) {
    this.reportingConfiguration = reportingConfiguration;
  }

  /**
   * Clears all the authentication credentials from this session.
   */
  private void clearAuthentication() {
    oAuth2Credential = null;
  }

  /**
   * @return the endpoint
   */
  @Override
  public String getEndpoint() {
    return endpoint;
  }

  /**
   * Builder for AdWordsSession.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   */
  public static class Builder implements
      com.google.api.ads.common.lib.utils.Builder<AdWordsSession> {

    private String endpoint;
    private String userAgent;
    private String developerToken;
    private String clientCustomerId;
    private Boolean isPartialFailure;
    private Boolean isValidateOnly;
    private Credential oAuth2Credential;
    private ReportingConfiguration reportingConfiguration;

    private final ConfigurationHelper configHelper;

    /**
     * Constructor.
     */
    public Builder() {
      this.configHelper = new ConfigurationHelper();
    }

    @Override
    public Builder fromFile() throws ConfigurationLoadException {
      return fromFile(Builder.DEFAULT_CONFIGURATION_FILENAME);
    }

    @Override
    public Builder fromFile(String path) throws ConfigurationLoadException {
      return from(configHelper.fromFile(path));
    }

    @Override
    public Builder fromFile(File path) throws ConfigurationLoadException {
      return from(configHelper.fromFile(path));
    }

    @Override
    public Builder fromFile(URL path) throws ConfigurationLoadException {
      return from(configHelper.fromFile(path));
    }

    /**
     * Reads properties from the provided {@link Configuration} object.<br><br>
     * Known properties:
     * <ul>
     * <li>api.adwords.clientCustomerId</li>
     * <li>api.adwords.userAgent</li>
     * <li>api.adwords.developerToken</li>
     * <li>api.adwords.isPartialFailure</li>
     * <li>api.adwords.endpoint</li>
     * <li>api.adwords.reporting.skipHeader</li>
     * <li>api.adwords.reporting.skipColumnHeader</li>
     * <li>api.adwords.reporting.skipSummary</li>
     * </ul>
     *
     * @param config
     * @return Builder populated from the Configuration
     */
    @Override
    public Builder from(Configuration config) {
      this.clientCustomerId = config.getString("api.adwords.clientCustomerId", null);
      this.userAgent = config.getString("api.adwords.userAgent", null);
      this.developerToken = config.getString("api.adwords.developerToken", null);
      this.isPartialFailure = config.getBoolean("api.adwords.isPartialFailure", null);
      this.endpoint = config.getString("api.adwords.endpoint", null);
      
      // Only create a ReportConfiguration for this object if at least one reporting
      // configuration config value is present.
      Boolean isSkipReportHeader = config.getBoolean("api.adwords.reporting.skipHeader", null);
      Boolean isSkipColumnHeader =
          config.getBoolean("api.adwords.reporting.skipColumnHeader", null);
      Boolean isSkipReportSummary = config.getBoolean("api.adwords.reporting.skipSummary", null);
      if (isSkipReportHeader != null || isSkipColumnHeader != null || isSkipReportSummary != null) {
        this.reportingConfiguration = new ReportingConfiguration.Builder()
            .skipReportHeader(isSkipReportHeader)
            .skipColumnHeader(isSkipColumnHeader)
            .skipReportSummary(isSkipReportSummary)
            .build();
      }

      return this;
    }

    /**
     * Includes OAuth2 credential to be used for OAuth2 authentication.
     */
    public Builder withOAuth2Credential(Credential oAuth2Credential) {
      clearAuthentication();
      this.oAuth2Credential = oAuth2Credential;
      return this;
    }
    
    public Builder withReportingConfiguration(ReportingConfiguration reportingConfiguration) {
      this.reportingConfiguration = reportingConfiguration;
      return this;
    }

    /**
     * Includes a developer token. Required.
     */
    public Builder withDeveloperToken(String developerToken) {
      this.developerToken = developerToken;
      return this;
    }

    /**
     * Includes user agent.
     */
    public Builder withUserAgent(String userAgent) {
      this.userAgent = userAgent;
      return this;
    }

    /**
     * Override the endpoint server. Optional and defaults to
     * https://adwords.google.com.
     */
    public Builder withEndpoint(String endpoint) {
      this.endpoint = endpoint;
      return this;
    }

    /**
     * Includes a clientCustomerId.
     */
    public Builder withClientCustomerId(String clientCustomerId) {
      this.clientCustomerId = clientCustomerId;
      return this;
    }

    /**
     * Enables partial failure. Default is disabled.
     */
    public Builder enablePartialFailure() {
      this.isPartialFailure = true;
      return this;
    }
    
    /**
     * Enables validate only. Default is disabled.
     */
    public Builder enableValidateOnly() {
      this.isValidateOnly = true;
      return this;
    }

    /**
     * Clears all the authentication credentials from this session.
     */
    private void clearAuthentication() {
      oAuth2Credential = null;
    }

    /**
     * Builds the {@code AdWordsSession}.
     *
     * @return the built {@code AdWordsSession}
     * @throws ValidationException if the {@code AdWordsSession} did not validate
     */
    @Override
    public AdWordsSession build() throws ValidationException {
      defaultOptionals();
      validate();
      return new AdWordsSession(this);
    }

    /**
     * Fills in defaults if {@code null}.
     */
    private void defaultOptionals() {
      if (this.endpoint == null) {
        this.endpoint = DEFAULT_ENDPOINT;
      }
    }

    /**
     * Validates the properties for the AdWords session.
     */
    private void validate() throws ValidationException {
      // Check for at least one authentication mechanism.
      if (this.oAuth2Credential == null) {
        throw new ValidationException("OAuth2 authentication must be used.", "");
      }

      // Check that the developer token is set.
      if (this.developerToken == null) {
        throw new ValidationException("A developer token must be set.", "developerToken");
      }
      
      // Check that user agent is not empty or the default.
      if (Strings.isNullOrEmpty(userAgent)
          || userAgent.contains(DEFAULT_USER_AGENT)) {
        throw new ValidationException(String.format(
            "User agent must be set and not be the default [%s]", DEFAULT_USER_AGENT),
            "userAgent");
      }

      // Make sure they specify an endpoint.
      try {
        new URL(this.endpoint);
      } catch (MalformedURLException e) {
        throw new ValidationException(String.format("Endpoint [%s] not recognized as a valid URL.",
            this.endpoint), "endpoint", e);
      }
    }
  }
}
