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
package com.adobe.xdm.external.repo;

import static com.adobe.xdm.common.XdmContext.XDM_DIRECTORY_PREFIX;
import static com.adobe.xdm.common.XdmContext.XDM_DIRECTORY_TYPE;

import com.adobe.xdm.XdmObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Directory extends XdmObject {

  private String assetId;
  private String name;
  private String path;
  private String etag;
  private String format;

  public Directory() {
    this.type = XDM_DIRECTORY_TYPE;
  }

  @JsonProperty(XDM_DIRECTORY_PREFIX + ":asset_id")
  public String getAssetId() {
    return assetId;
  }

  public void setAssetId(String assetId) {
    this.assetId = assetId;
  }

  @JsonProperty(XDM_DIRECTORY_PREFIX + ":name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @JsonProperty(XDM_DIRECTORY_PREFIX + ":path")
  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  @JsonProperty(XDM_DIRECTORY_PREFIX + ":etag")
  public String getEtag() {
    return etag;
  }

  public void setEtag(String etag) {
    this.etag = etag;
  }

  @JsonProperty(XDM_DIRECTORY_PREFIX + ":format")
  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
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

    Directory directory = (Directory) o;

    if (assetId != null ? !assetId.equals(directory.assetId) : directory.assetId != null) {
      return false;
    }
    if (name != null ? !name.equals(directory.name) : directory.name != null) {
      return false;
    }
    if (path != null ? !path.equals(directory.path) : directory.path != null) {
      return false;
    }
    if (etag != null ? !etag.equals(directory.etag) : directory.etag != null) {
      return false;
    }
    return format != null ? format.equals(directory.format) : directory.format == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (assetId != null ? assetId.hashCode() : 0);
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (path != null ? path.hashCode() : 0);
    result = 31 * result + (etag != null ? etag.hashCode() : 0);
    result = 31 * result + (format != null ? format.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Directory{" +
        "assetId='" + assetId + '\'' +
        ", name='" + name + '\'' +
        ", path='" + path + '\'' +
        ", etag='" + etag + '\'' +
        ", format='" + format + '\'' +
        ", id='" + id + '\'' +
        ", type='" + type + '\'' +
        '}';
  }
}
