/*
 * ADOBE CONFIDENTIAL
 * ___________________
 *
 * Copyright 2017 Adobe Systems Incorporated
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Adobe Systems Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Adobe Systems Incorporated and its
 * suppliers and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Adobe Systems Incorporated.
 */
package com.adobe.xdm.event;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

public class JsonUtils {

  private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
  private static final JsonFactory JSON_FACTORY = new JsonFactory(JSON_MAPPER);

  public static String toPrettyString(Object jsonObject) throws IOException {
    final StringWriter sw = new StringWriter();
    writePrettyPrint(sw, jsonObject);
    return sw.toString();
  }

  public static void writePrettyPrint(Writer writer, Object jsonObject) throws IOException {
    final JsonGenerator jw = JSON_FACTORY.createGenerator(writer);
    jw.useDefaultPrettyPrinter();
    jw.writeObject(jsonObject);
  }


}
