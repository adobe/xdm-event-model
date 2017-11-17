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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class XdmEvent
    <Ob extends ActivityStreamObject,
        To extends ActivityStreamObject,
        Ge extends ActivityStreamObject,
        Ac extends ActivityStreamObject> {

  protected String id;
  protected String type;
  protected String published;
  protected To to;
  protected Ge generator;
  protected Ac actor;
  protected Ob object;

  @JsonProperty("@id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @NotNull(message = "XdmEvent's @type cannot be null")
  @JsonProperty("@type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  @JsonProperty(XdmContext.XDM_EVENT_ENVELOPE_PREFIX + ":objectType")
  public String getObjectType() {
    return (object == null) ? null : object.getType();
  }

  @JsonProperty(XdmContext.W3C_ACTIVITYSTREAMS_PREFIX + ":published")
  public String getPublished() {
    return published;
  }

  public void setPublished(String published) {
    this.published = published;
  }

  @JsonProperty(XdmContext.W3C_ACTIVITYSTREAMS_PREFIX + ":to")
  public To getTo() {
    return to;
  }

  public void setTo(To to) {
    this.to = to;
  }

  @JsonProperty(XdmContext.W3C_ACTIVITYSTREAMS_PREFIX + ":actor")
  public Ac getActor() {
    return actor;
  }

  public void setActor(Ac actor) {
    this.actor = actor;
  }

  @JsonProperty(XdmContext.W3C_ACTIVITYSTREAMS_PREFIX + ":generator")
  public Ge getGenerator() {
    return generator;
  }

  public void setGenerator(Ge generator) {
    this.generator = generator;
  }

  @NotNull(message = "XdmEvent's " + XdmContext.W3C_ACTIVITYSTREAMS_PREFIX
      + ":object cannot be null")
  @JsonProperty(XdmContext.W3C_ACTIVITYSTREAMS_PREFIX + ":object")
  public Ob getObject() {
    return object;
  }

  public void setObject(Ob object) {
    this.object = object;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || !this.getClass().isAssignableFrom(o.getClass())) {
      return false;
    }

    XdmEvent<?, ?, ?, ?> xdmEvent = (XdmEvent<?, ?, ?, ?>) o;

    if (id != null ? !id.equals(xdmEvent.id) : xdmEvent.id != null) {
      return false;
    }
    if (type != null ? !type.equals(xdmEvent.type) : xdmEvent.type != null) {
      return false;
    }
    if (published != null ? !published.equals(xdmEvent.published) : xdmEvent.published != null) {
      return false;
    }
    if (to != null ? !to.equals(xdmEvent.to) : xdmEvent.to != null) {
      return false;
    }
    if (generator != null ? !generator.equals(xdmEvent.generator) : xdmEvent.generator != null) {
      return false;
    }
    if (actor != null ? !actor.equals(xdmEvent.actor) : xdmEvent.actor != null) {
      return false;
    }
    return object != null ? object.equals(xdmEvent.object) : xdmEvent.object == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (type != null ? type.hashCode() : 0);
    result = 31 * result + (published != null ? published.hashCode() : 0);
    result = 31 * result + (to != null ? to.hashCode() : 0);
    result = 31 * result + (generator != null ? generator.hashCode() : 0);
    result = 31 * result + (actor != null ? actor.hashCode() : 0);
    result = 31 * result + (object != null ? object.hashCode() : 0);
    return result;
  }
}
