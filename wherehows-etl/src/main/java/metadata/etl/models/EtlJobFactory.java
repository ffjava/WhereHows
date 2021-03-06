/**
 * Copyright 2015 LinkedIn Corp. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 */
package metadata.etl.models;

import java.lang.reflect.Constructor;
import java.util.Properties;
import metadata.etl.EtlJob;

/**
 * Created by zechen on 10/21/15.
 */
public class EtlJobFactory {

  public static EtlJob getEtlJob(String etlClassName, int refId, long whExecId, Properties properties)
      throws Exception {
    Class etlClass = Class.forName(etlClassName);
    Constructor<?> ctor = etlClass.getConstructor(int.class, long.class, Properties.class);
    return (EtlJob) ctor.newInstance(refId, whExecId, properties);
  }
}
