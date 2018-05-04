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

import com.adobe.xdm.assets.Asset;
import com.adobe.xdm.common.XdmEvent;
import com.adobe.xdm.content.ContentRepository;
import com.adobe.xdm.extensions.aem.AemUser;
import com.adobe.xdm.extensions.ims.ImsOrg;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AemAssetEvent extends XdmEvent<Asset, ImsOrg, ContentRepository, AemUser> implements
    Serializable {

  public AemAssetEvent() {
    super();
    this.object = new Asset();
  }

}
