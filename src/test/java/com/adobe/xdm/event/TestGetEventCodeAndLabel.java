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

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestGetEventCodeAndLabel {

  Logger logger = LoggerFactory.getLogger(SerializationTest.class);

  @Test
  public void testEventCodes() {
    assertEventCodeAndLabel(new AemAssetCreatedEvent(), "asset_created", "Asset Created Event");
    assertEventCodeAndLabel(new AemAssetDeletedEvent(), "asset_deleted", "Asset Deleted Event");
    assertEventCodeAndLabel(new AemAssetUpdatedEvent(), "asset_updated", "Asset Updated Event");
    assertEventCodeAndLabel(new AemPagePublishedEvent(), "page_published", "Page Published Event");
    assertEventCodeAndLabel(new AemPageUnpublishedEvent(), "page_unpublished",
        "Page Unpublished Event");
    assertEventCodeAndLabel(new CCAssetCreatedEvent(), "asset_created", "Asset Created Event");
    assertEventCodeAndLabel(new CCAssetDeletedEvent(), "asset_deleted", "Asset Deleted Event");
    assertEventCodeAndLabel(new CCAssetUpdatedEvent(), "asset_updated", "Asset Updated Event");
  }

  private void assertEventCodeAndLabel(XdmEvent xdmEvent, String expectedEventCode,
      String expectedLabel) {
    String eventCode = xdmEvent.getEventCode();
    String label = xdmEvent.getLabel();
    logger.info(xdmEvent.getClass().getName() + ".eventCode=" + eventCode);
    logger.info(xdmEvent.getClass().getName() + ".label=" + label);
    assertTrue(eventCode != null);
    assertTrue(eventCode.equals(expectedEventCode));
    assertTrue(label.equals(expectedLabel));
  }


}
