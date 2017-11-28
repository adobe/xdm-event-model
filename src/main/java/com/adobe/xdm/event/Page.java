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
public class Page extends ActivityStreamObject {

  private String title;
  private String path;

  public Page() {
    super();
    this.type = XdmContext.XDM_COMPONENTIZED_PAGE_TYPE;
  }

  @JsonProperty(XdmContext.XDM_COMPONENTIZED_PAGE_PREFIX + ":title")
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @JsonProperty(XdmContext.XDM_COMPONENTIZED_PAGE_PREFIX + ":path")
  public String getPathname() {
    return path;
  }

  public void setPathname(String pathname) {
    this.path = pathname;
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

    Page page = (Page) o;

    if (title != null ? !title.equals(page.title) : page.title != null) {
      return false;
    }
    return path != null ? path.equals(page.path) : page.path == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (title != null ? title.hashCode() : 0);
    result = 31 * result + (path != null ? path.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Page{" +
        "title='" + title + '\'' +
        ", pathname='" + path + '\'' +
        ", id='" + id +
        ", type='" + type + '\'' +
        '}';
  }
}