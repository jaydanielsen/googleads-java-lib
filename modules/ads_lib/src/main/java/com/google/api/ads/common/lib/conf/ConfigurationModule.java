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

package com.google.api.ads.common.lib.conf;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Lists;
import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import org.apache.commons.configuration.Configuration;

import java.net.URL;
import java.util.List;

import javax.annotation.Nullable;

/**
 * Module for configuration.
 */
public abstract class ConfigurationModule extends AbstractModule {

  private static final String BUILD_PROPERTIES = "props/google-ads-api-java-build.properties";
  private static final String DEFAULT_ADS_PROPERTIES = "ads.properties";
  private static final String DEFAULT_BUILD_PROPERTIES = "google-ads-api-java-build.properties";

  private final ConfigurationHelper configurationHelper;

  /**
   * Constructor.
   */
  public ConfigurationModule() {
    configurationHelper = new ConfigurationHelper();
  }

  /**
   * Constructor.
   *
   * @param configurationHelper the configuration helper.
   */
  @VisibleForTesting
  ConfigurationModule(ConfigurationHelper configurationHelper) {
    this.configurationHelper = configurationHelper;
  }

  @Override
  protected void configure() {}

  /**
   * Configures configurations.
   *
   * @param apiConfigurationClass the API configuration class
   * @param apiPropertyUrls the API properties file URLs
   * @param apiPropertyFilePaths the API properties file paths or names
   * @param adsLibConfigurationClass the lib configuration class
   * @param libPropertyUrls the lib properties files
   * @param libPropertyFilePaths the lib properties file paths or names
   * @param productPropertyUrls the product build properties files
   */
  protected void configureConfigurations(
      Class<? extends AdsApiConfiguration> apiConfigurationClass,
      @Nullable List<URL> apiPropertyUrls, @Nullable List<String> apiPropertyFilePaths,
      Class<? extends AdsLibConfiguration> adsLibConfigurationClass,
      @Nullable List<URL> libPropertyUrls, @Nullable List<String> libPropertyFilePaths,
      List<URL> productPropertyUrls) {
    bind(AdsApiConfiguration.class).to(apiConfigurationClass).asEagerSingleton();
    bind(AdsLibConfiguration.class).to(adsLibConfigurationClass).asEagerSingleton();
    bind(Configuration.class).annotatedWith(Names.named("api")).toProvider(
        new ConfigurationProvider(ConfigurationHelper.newList(apiPropertyUrls, false),
            ConfigurationHelper.newList(apiPropertyFilePaths, true)));
    bind(Configuration.class).annotatedWith(Names.named("lib")).toProvider(
        new ConfigurationProvider(ConfigurationHelper.newList(libPropertyUrls, false),
            getFilePathConfigurationListWithDefault(libPropertyFilePaths, DEFAULT_ADS_PROPERTIES)));
    bind(Configuration.class).annotatedWith(Names.named("build")).toProvider(
        new ConfigurationProvider(ConfigurationHelper.newList(
            Lists.newArrayList(ConfigurationModule.class.getResource(BUILD_PROPERTIES)), false),
            getFilePathConfigurationListWithDefault(null, DEFAULT_BUILD_PROPERTIES)));
    bind(Configuration.class).annotatedWith(Names.named("product")).toProvider(
        new ConfigurationProvider(ConfigurationHelper.newList(productPropertyUrls, false), null));
  }

  /**
   * Gets a combined configuration list with the default added last so that
   * {@code filePaths} will override {@code defaultFilePath}.
   */
  private List<ConfigurationHelper.ConfigurationInfo<String>>
      getFilePathConfigurationListWithDefault(@Nullable List<String> filePaths,
       String defaultFilePath) {
    List<ConfigurationHelper.ConfigurationInfo<String>> defaultConfigList =
        ConfigurationHelper.newList(true, defaultFilePath);
    List<ConfigurationHelper.ConfigurationInfo<String>> filePathConfigList =
        ConfigurationHelper.newList(filePaths, true);
    if (defaultConfigList != null) {
      if (filePathConfigList == null) {
        filePathConfigList = defaultConfigList;
      } else {
        filePathConfigList.addAll(defaultConfigList);
      } 
    }
    return filePathConfigList;
  }
}
