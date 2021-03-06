/*
 * Copyright 2010-2015 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 * 
 *  http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.services.elasticmapreduce.model.transform;

import static com.amazonaws.util.StringUtils.UTF8;
import static com.amazonaws.util.StringUtils.COMMA_SEPARATOR;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.regex.Pattern;

import com.amazonaws.AmazonClientException;
import com.amazonaws.Request;
import com.amazonaws.DefaultRequest;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.elasticmapreduce.model.*;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.BinaryUtils;
import com.amazonaws.util.StringUtils;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.*;

/**
 * Add Job Flow Steps Request Marshaller
 */
public class AddJobFlowStepsRequestMarshaller implements Marshaller<Request<AddJobFlowStepsRequest>, AddJobFlowStepsRequest> {

    public Request<AddJobFlowStepsRequest> marshall(AddJobFlowStepsRequest addJobFlowStepsRequest) {
        if (addJobFlowStepsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }

        Request<AddJobFlowStepsRequest> request = new DefaultRequest<AddJobFlowStepsRequest>(addJobFlowStepsRequest, "AmazonElasticMapReduce");
        String target = "ElasticMapReduce.AddJobFlowSteps";
        request.addHeader("X-Amz-Target", target);

        request.setHttpMethod(HttpMethodName.POST);
        request.setResourcePath("");
        
        try {
          StringWriter stringWriter = new StringWriter();
          JSONWriter jsonWriter = new JSONWriter(stringWriter);

          jsonWriter.object();
          
            if (addJobFlowStepsRequest.getJobFlowId() != null) {
                jsonWriter.key("JobFlowId").value(addJobFlowStepsRequest.getJobFlowId());
            }

            com.amazonaws.internal.ListWithAutoConstructFlag<StepConfig> stepsList = (com.amazonaws.internal.ListWithAutoConstructFlag<StepConfig>)(addJobFlowStepsRequest.getSteps());
            if (stepsList != null && !(stepsList.isAutoConstruct() && stepsList.isEmpty())) {

                jsonWriter.key("Steps");
                jsonWriter.array();

                for (StepConfig stepsListValue : stepsList) {
                    if (stepsListValue != null) {
                        jsonWriter.object();
                        if (stepsListValue.getName() != null) {
                            jsonWriter.key("Name").value(stepsListValue.getName());
                        }
                        if (stepsListValue.getActionOnFailure() != null) {
                            jsonWriter.key("ActionOnFailure").value(stepsListValue.getActionOnFailure());
                        }
                        HadoopJarStepConfig hadoopJarStep = stepsListValue.getHadoopJarStep();
                        if (hadoopJarStep != null) {

                            jsonWriter.key("HadoopJarStep");
                            jsonWriter.object();

                            com.amazonaws.internal.ListWithAutoConstructFlag<KeyValue> propertiesList = (com.amazonaws.internal.ListWithAutoConstructFlag<KeyValue>)(hadoopJarStep.getProperties());
                            if (propertiesList != null && !(propertiesList.isAutoConstruct() && propertiesList.isEmpty())) {

                                jsonWriter.key("Properties");
                                jsonWriter.array();

                                for (KeyValue propertiesListValue : propertiesList) {
                                    if (propertiesListValue != null) {
                                        jsonWriter.object();
                                        if (propertiesListValue.getKey() != null) {
                                            jsonWriter.key("Key").value(propertiesListValue.getKey());
                                        }
                                        if (propertiesListValue.getValue() != null) {
                                            jsonWriter.key("Value").value(propertiesListValue.getValue());
                                        }
                                        jsonWriter.endObject();
                                    }
                                }
                                jsonWriter.endArray();
                            }
                            if (hadoopJarStep.getJar() != null) {
                                jsonWriter.key("Jar").value(hadoopJarStep.getJar());
                            }
                            if (hadoopJarStep.getMainClass() != null) {
                                jsonWriter.key("MainClass").value(hadoopJarStep.getMainClass());
                            }

                            com.amazonaws.internal.ListWithAutoConstructFlag<String> argsList = (com.amazonaws.internal.ListWithAutoConstructFlag<String>)(hadoopJarStep.getArgs());
                            if (argsList != null && !(argsList.isAutoConstruct() && argsList.isEmpty())) {

                                jsonWriter.key("Args");
                                jsonWriter.array();

                                for (String argsListValue : argsList) {
                                    if (argsListValue != null) {
                                        jsonWriter.value(argsListValue);
                                    }
                                }
                                jsonWriter.endArray();
                            }
                            jsonWriter.endObject();
                        }
                        jsonWriter.endObject();
                    }
                }
                jsonWriter.endArray();
            }

          jsonWriter.endObject();

          String snippet = stringWriter.toString();
          byte[] content = snippet.getBytes(UTF8);
          request.setContent(new StringInputStream(snippet));
          request.addHeader("Content-Length", Integer.toString(content.length));
          request.addHeader("Content-Type", "application/x-amz-json-1.1");
        } catch(Throwable t) {
          throw new AmazonClientException("Unable to marshall request to JSON: " + t.getMessage(), t);
        }

        return request;
    }
}
