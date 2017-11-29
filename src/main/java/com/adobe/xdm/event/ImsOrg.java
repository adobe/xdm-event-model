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

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ImsOrg extends ActivityStreamObject {

  private String imsOrgId;

  public ImsOrg() {
    super();
    this.type = XdmContext.XDM_IMS_ORG_TYPE;
  }

  @JsonProperty(XdmContext.XDM_IMS_ORG_PREFIX + ":id")
  public String getImsOrgId() {
    return imsOrgId;
  }


  public void setImsOrgId(String imsOrgId) {
    this.imsOrgId = imsOrgId;
  }
}