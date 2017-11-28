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

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SerializationTest {

  Logger logger = LoggerFactory.getLogger(SerializationTest.class);

  private ObjectMapper mapper;

  @Before
  public void setUp() {
    mapper = new ObjectMapper();
  }

  private CCAssetEvent getCCAssetSampleEvent(CCAssetEvent assetEvent) {
    assetEvent.setId("82235bac-2b81-4e70-90b5-2bd1f04b5c7b");
    assetEvent.setPublished("2016-07-16T19:20:30+01:00");
    ImsUser imsUser = new ImsUser();
    imsUser.setImsUserId("D13A1E7053E46A220A4C86E1@AdobeID");
    assetEvent.setTo(imsUser);
    assetEvent.setActor(imsUser);

    ContentRepository creativeCloud = new ContentRepository();
    creativeCloud.setRoot("https://cc-api-storage.adobe.io/");
    assetEvent.setGenerator(creativeCloud);

    Asset asset = new Asset();
    asset.setFormat("image/jpeg");
    asset.setAssetId("urn:aaid:sc:us:4123ba4c-93a8-4c5d-b979-ffbbe4318185");
    asset.setAssetName("example.jpg");
    asset.setEtag("6fc55d0389d856ae7deccebba54f110e");
    asset.setPath("/MyFolder/example.jpg");
    assetEvent.setObject(asset);
    return assetEvent;
  }

  private <T> void assertDeserialization(T xdmEvent, String xdmEventJsonFile,
      Class<T> xdmEventClass)
      throws IOException {
    T xdmEventFromFile = mapper.readValue(readFile(xdmEventJsonFile), xdmEventClass);
    assertTrue(xdmEventFromFile.equals(xdmEvent));
  }

  @Test
  public void testCCAssetCreatedEventSerialization() throws IOException {
    CCAssetEvent xdmEvent = getCCAssetSampleEvent(new CCAssetCreatedEvent());
    String prettyString = JsonUtils.toPrettyString(xdmEvent);
    logger.info(prettyString);
    assertDeserialization(xdmEvent, "asset_created_cc_sample.json", CCAssetEvent.class);
  }

  @Test
  public void testCCAssetUpdatedEventSerialization() throws IOException {
    CCAssetEvent xdmEvent = getCCAssetSampleEvent(new CCAssetUpdatedEvent());
    String prettyString = JsonUtils.toPrettyString(xdmEvent);
    logger.info(prettyString);

    assertDeserialization(xdmEvent, "asset_updated_cc_sample.json", CCAssetEvent.class);
  }

  @Test
  public void testCCAssetDeletedEventSerialization() throws IOException {
    CCAssetEvent assetEvent = getCCAssetSampleEvent(new CCAssetDeletedEvent());
    Asset asset = new Asset();
    asset.setAssetId("urn:aaid:sc:us:4123ba4c-93a8-4c5d-b979-ffbbe4318185");
    assetEvent.setObject(asset);
    String prettyString = JsonUtils.toPrettyString(assetEvent);
    logger.info(prettyString);

    assertDeserialization(assetEvent, "asset_deleted_cc_sample.json", CCAssetEvent.class);
  }

  private AemAssetEvent getAemAssetSampleEvent(AemAssetEvent assetEvent) {
    assetEvent.setId("82235bac-2b81-4e70-90b5-2bd1f04b5c7b");
    assetEvent.setPublished("2016-07-16T19:20:30+01:00");
    ImsOrg imsOrg = new ImsOrg();
    imsOrg.setImsOrgId("08B3E5CE5822FC520A494229@AdobeOrg");
    assetEvent.setTo(imsOrg);

    ContentRepository aemInstance = new ContentRepository();
    aemInstance.setRoot("http://francois.corp.adobe.com:4502/");
    assetEvent.setGenerator(aemInstance);

    AemUser aemUser = new AemUser();
    aemUser.setAemUserId("admin");
    assetEvent.setActor(aemUser);

    Asset asset = new Asset();
    asset.setFormat("image/png");
    asset.setAssetId("urn:aaid:aem:4123ba4c-93a8-4c5d-b979-ffbbe4318185");
    asset.setAssetName("Fx_DUKE-small.png");
    asset.setEtag("6fc55d0389d856ae7deccebba54f110e");
    asset.setPath("/content/dam/Fx_DUKE-small.png");
    assetEvent.setObject(asset);
    return assetEvent;
  }


  @Test
  public void testAemAssetCreatedEventSerialization() throws IOException {
    AemAssetEvent xdmEvent = getAemAssetSampleEvent(new AemAssetCreatedEvent());
    String prettyString = JsonUtils.toPrettyString(xdmEvent);
    logger.info(prettyString);
    assertDeserialization(xdmEvent, "asset_created_aem_sample.json", AemAssetEvent.class);
  }

  @Test
  public void testAemAssetUpdatedEventSerialization() throws IOException {
    AemAssetEvent xdmEvent = getAemAssetSampleEvent(new AemAssetUpdatedEvent());
    String prettyString = JsonUtils.toPrettyString(xdmEvent);
    logger.info(prettyString);
    assertDeserialization(xdmEvent, "asset_updated_aem_sample.json", AemAssetEvent.class);
  }

  @Test
  public void testAemAssetDeletedEventSerialization() throws IOException {
    AemAssetEvent assetEvent = getAemAssetSampleEvent(new AemAssetDeletedEvent());
    Asset asset = new Asset();
    asset.setAssetId("urn:aaid:aem:4123ba4c-93a8-4c5d-b979-ffbbe4318185");
    assetEvent.setObject(asset);
    String prettyString = JsonUtils.toPrettyString(assetEvent);
    logger.info(prettyString);

    assertDeserialization(assetEvent, "asset_deleted_aem_sample.json", AemAssetEvent.class);
  }


  private AemPageEvent getAemPageSampleEvent(AemPageEvent pageEvent) {
    pageEvent.setId("82235bac-2b81-4e70-90b5-2bd1f04b5c7b");
    pageEvent.setPublished("2016-07-16T19:20:30+01:00");

    ImsOrg imsOrg = new ImsOrg();
    imsOrg.setImsOrgId("08B3E5CE5822FC520A494229@AdobeOrg");
    pageEvent.setTo(imsOrg);

    ContentRepository aemInstance = new ContentRepository();
    aemInstance.setRoot("http://francois.corp.adobe.com:4502/");
    pageEvent.setGenerator(aemInstance);

    AemUser aemUser = new AemUser();
    aemUser.setAemUserId("admin");
    pageEvent.setActor(aemUser);

    Page page = new Page();
    page.setTitle("Vintage Collection");
    page.setPathname("/content/geometrixx/en/vintage.html");
    page.setId("http://adobesummit.adobesandbox.com:4502/content/geometrixx/en/vintage.html");
    pageEvent.setObject(page);
    return pageEvent;
  }

  @Test
  public void testAemPagePublishedEventSerialization() throws IOException {
    AemPageEvent xdmEvent = getAemPageSampleEvent(new AemPagePublishedEvent());
    String prettyString = JsonUtils.toPrettyString(xdmEvent);
    logger.info(prettyString);

    assertDeserialization(xdmEvent, "page_published_aem_sample.json", AemPageEvent.class);
  }

  @Test
  public void testAemPageUnpublishedEventSerialization() throws IOException {
    AemPageEvent xdmEvent = getAemPageSampleEvent(new AemPageUnpublishedEvent());
    String prettyString = JsonUtils.toPrettyString(xdmEvent);
    logger.info(prettyString);

    assertDeserialization(xdmEvent, "page_unpublished_aem_sample.json", AemPageEvent.class);
  }

  @Test
  public void testXdmContextSerialization() throws IOException {
    Xdm xdm = new Xdm();
    String prettyString = JsonUtils.toPrettyString(xdm);
    logger.info(prettyString);
  }


  private String readFile(String relativePath)
      throws IOException {
    String absoluteFilePath = new File("src/test/resources").getAbsolutePath() + "/" + relativePath;
    byte[] encoded = Files.readAllBytes(Paths.get(absoluteFilePath));
    return new String(encoded, StandardCharsets.UTF_8);
  }


}
