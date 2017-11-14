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


import java.util.HashMap;
import java.util.Map;

public class XdmContext {

  public static final String XDM_BASE_URL = "http://ns.adobe.com/xdm";

  public static final String XDM_EVENT_BASE_URL = XDM_BASE_URL + "/event";

  public static final String XDM_EVENT_CREATED_TYPE = XDM_EVENT_BASE_URL + "/created";
  public static final String XDM_EVENT_DELETED_TYPE = XDM_EVENT_BASE_URL + "/deleted";
  public static final String XDM_EVENT_UPDATED_TYPE = XDM_EVENT_BASE_URL + "/updated";

  public static final String XDM_EVENT_PUBLISHED_TYPE = XDM_EVENT_BASE_URL + "/published";
  public static final String XDM_EVENT_UNPUBLISHED_TYPE = XDM_EVENT_BASE_URL + "/unpublished";

  public static final String W3C_ACTIVITYSTREAMS_PREFIX = "activitystreams";
  public static final String W3C_ACTIVITYSTREAMS_JSONLD_IRI = "http://www.w3.org/ns/activitystreams#";

  public static final String XDM_EVENT_ENVELOPE_PREFIX = "xdmEventEnvelope";
  public static final String XDM_EVENT_ENVELOPE_JSONLD_IRI = XDM_BASE_URL + "/event-envelope#";

  public static final String XDM_ASSET_PREFIX = "xdmAsset";
  public static final String XDM_ASSET_JSONLD_IRI = Asset.TYPE + "#";

  public static final String XDM_PAGE_PREFIX = "xdmPage";
  public static final String XDM_PAGE_JSONLD_IRI = Page.TYPE + "#";

  public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssX";

  /**
   * @return the context map to be used while jsonld compaction cf. https://json-ld.org/spec/latest/json-ld-api/#compaction
   */
  public static Map getDefault() {
    Map context = new HashMap();
    context.put(W3C_ACTIVITYSTREAMS_PREFIX, W3C_ACTIVITYSTREAMS_JSONLD_IRI);
    context.put(XDM_EVENT_ENVELOPE_PREFIX, XDM_EVENT_ENVELOPE_JSONLD_IRI);
    context.put(XDM_ASSET_PREFIX, XDM_ASSET_JSONLD_IRI);
    context.put(XDM_PAGE_PREFIX, XDM_PAGE_JSONLD_IRI);
    return context;
  }

}
