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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImsUser extends ActivityStreamObject implements Serializable {

  private String imsUserId;

  public ImsUser() {
    super();
    this.type = XdmContext.XDM_IMS_USER_TYPE;
  }

  @JsonProperty(XdmContext.XDM_IMS_USER_PREFIX + ":id")
  public String getImsUserId() {
    return this.imsUserId;
  }

  public void setImsUserId(String imsUserId) {
    this.imsUserId = imsUserId;
  }
}