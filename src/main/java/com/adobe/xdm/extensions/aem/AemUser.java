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
import com.adobe.xdm.XdmObject;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AemUser extends XdmObject implements Serializable {

  private String aemUserId;

  public AemUser() {
    super();
    this.type = XdmContext.XDM_AEM_USER_TYPE;
  }

  @JsonProperty(XdmContext.XDM_AEM_USER_PREFIX + ":id")
  public String getAemUserId() {
    return this.aemUserId;
  }

  public void setAemUserId(String aemUserId) {
    this.aemUserId = aemUserId;
  }
}