/*
 * Copyright 2012-present Facebook, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.facebook.buck.json;

import com.facebook.buck.event.BuckEventBus;
import com.facebook.buck.rules.ConstructorArgMarshaller;
import com.facebook.buck.util.Console;
import com.facebook.buck.util.DefaultProcessExecutor;
import com.google.common.collect.ImmutableMap;

public class DefaultProjectBuildFileParserFactory implements ProjectBuildFileParserFactory {
  private final ProjectBuildFileParserOptions options;

  public DefaultProjectBuildFileParserFactory(ProjectBuildFileParserOptions options) {
    this.options = options;
  }

  @Override
  public ProjectBuildFileParser createParser(
      ConstructorArgMarshaller marshaller,
      Console console,
      ImmutableMap<String, String> environment,
      BuckEventBus buckEventBus,
      boolean ignoreBuckAutodepsFiles) {
    return new ProjectBuildFileParser(
        options,
        marshaller,
        environment,
        buckEventBus,
        new DefaultProcessExecutor(console),
        ignoreBuckAutodepsFiles);
  }
}
