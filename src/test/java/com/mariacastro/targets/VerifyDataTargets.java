package com.mariacastro.targets;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class VerifyDataTargets {

    public static Target HOTEL_NAME_LABEL = Target.the("Hotel name").located(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.booking:id/bp_overview_hotelname\"]"));
    public static Target TOTAL_VALUE_LABEL = Target.the("Total value").located(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.booking:id/informative_cta_view_price_container\"]/android.widget.FrameLayout[1]/android.widget.TextView[@resource-id=\"com.booking:id/title\"]"));
    public static Target BOOK_NOW_BUTTON = Target.the("Total value").located(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"com.booking:id/informative_click_to_action_container\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.Button[@resource-id=\"com.booking:id/action_button\"]"));

}
