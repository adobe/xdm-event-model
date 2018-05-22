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

import com.adobe.xdm.common.XdmEvent;
import com.adobe.xdm.content.ContentRepository;
import com.adobe.xdm.extensions.ims.ImsUser;
import com.adobe.xdm.external.repo.Directory;

public class CCDirectoryEvent extends XdmEvent<Directory, ImsUser, ContentRepository, ImsUser> {

  public CCDirectoryEvent() {
    this.object = new Directory();
  }
}