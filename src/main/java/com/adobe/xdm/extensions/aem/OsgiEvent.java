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
package com.adobe.xdm.extensions.aem;

import com.adobe.xdm.common.XdmContext;
import com.adobe.xdm.external.ActivityStreamObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Hashtable;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OsgiEvent extends ActivityStreamObject implements Serializable {

  String topic;
  Hashtable properties;

  public OsgiEvent() {
    super();
    this.type = XdmContext.OSGI_EVENT_TYPE;
  }

  @JsonProperty(XdmContext.OSGI_EVENT_PREFIX + ":topic")
  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
    this.type =  XdmContext.OSGI_EVENT_TYPE +":"+topic;
  }

  @JsonProperty(XdmContext.OSGI_EVENT_PREFIX + ":properties")
  public Hashtable getProperties() {
    return properties;
  }

  public void setProperties(Hashtable properties) {
    this.properties = properties;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }

    OsgiEvent that = (OsgiEvent) o;

    if (topic != null ? !topic.equals(that.topic) : that.topic != null) {
      return false;
    }
    return properties != null ? properties.equals(that.properties) : that.properties == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (topic != null ? topic.hashCode() : 0);
    result = 31 * result + (properties != null ? properties.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "AemOsgiEvent{" +
        "topic='" + topic + '\'' +
        ", properties=" + properties +
        ", id='" + id + '\'' +
        ", type='" + type + '\'' +
        '}';
  }
}