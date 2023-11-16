package com.mariacastro.targets;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class BookingTargets {

    public static Target SEE_ROOMS_OPTIONS_BUTTON = Target.the("See rooms options Button").located(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.booking:id/select_room_cta\"]"));
    public static Target ROOM_SUBTOTAL_LABEL_RESERVE = Target.the("Rooms subtotal label").located(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.booking:id/recommended_block_subtotal_price_view\"]"));
    public static Target ROOM_SUBTOTAL_LABEL_SELECT = Target.the("Rooms subtotal label").located(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.booking:id/price_view_price\"]"));
    public static Target RESERVE_ROOMS_BUTTON = Target.the("Reserve room Button").located(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.booking:id/recommended_block_reserve_button\"]"));
    public static Target SELECT_ROOMS_BUTTON = Target.the("Select room Button").located(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.booking:id/room_linear_layout\"]/android.widget.LinearLayout[@resource-id=\"com.booking:id/rooms_item_select_layout\"]"));
    public static Target FOOTER_SUBTOTAL_LABEL = Target.the("Footer subtotal label").located(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.booking:id/info_title\"]"));
    public static Target FOOTER_SELECT_ROOMS_BUTTON = Target.the("Footer select room Button").located(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.booking:id/main_action\"]"));
    public static Target DISMISS_INFO_BUTTON = Target.the("Dismiss info button").located(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Dismiss this info\"]"));
}
