package com.mariacastro.utils;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

public class ScrollUtils {

    public static void scrollToElementWithText(Actor actor, String text) {
        BrowseTheWeb.as(actor).getDriver().findElements(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + text + "\").instance(0))"));
    }

    public static void scrollToElementWithResourceId(Actor actor, String resourceId) {
        BrowseTheWeb.as(actor).getDriver().findElements(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\").instance(0))"));
    }

    public static void scrollToElementWithDescription(Actor actor, String description, String containerResourceId) {
        BrowseTheWeb.as(actor).getDriver().findElements(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"" + containerResourceId + "\").instance(0)).scrollIntoView(new UiSelector().description(\"" + description + "\").instance(0))"));
    }
}
