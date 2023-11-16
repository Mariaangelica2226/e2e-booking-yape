package com.mariacastro.targets;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class SearchTargets {

    public static Target CLOSE_LOGIN_SCREEN_BUTTON = Target.the("Close Login Screen Button").located(AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]"));
    public static Target DESTINATION_INPUT_BUTTON = Target.the("Destination Input Button").located(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.booking:id/facet_search_box_accommodation_destination\"]"));
    public static Target DESTINATION_INPUT = Target.the("Destination Input").located(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content\"]"));
    public static Target FIRST_ELEMENT_ON_DESTINATION_LIST = Target.the("First element in destination list").located(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.booking:id/facet_disambiguation_content\"]/android.view.ViewGroup[1]/android.widget.TextView[@resource-id=\"com.booking:id/view_disambiguation_destination_subtitle\"]"));
    public static Target EMPTY_MESSAGE_ON_DESTINATION_LIST = Target.the("First element in destination list").located(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.booking:id/facet_disambiguation_content\"]/android.widget.TextView[1]"));

    public static Target SELECT_DATES_CONFIRM_BUTTON = Target.the("Select Dates confirm button").located(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.booking:id/facet_date_picker_confirm\"]"));
    public static Target ROOMS_AND_PEOPLE_SELECTOR_BUTTON = Target.the("Rooms and people button").located(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.booking:id/facet_search_box_accommodation_occupancy\"]"));
    public static Target ACCOMMODATION_COUNTERS = Target.the("Rooms counter").located(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.booking:id/bui_input_stepper_value\"]"));
    public static Target ADD_CHILDREN_BUTTON = Target.the("Add children button").located(AppiumBy.xpath("(//android.widget.Button[@resource-id=\"com.booking:id/bui_input_stepper_add_button\"])[3]"));
    public static Target NUMBER_PICKER_SELECTED_ELEMENT = Target.the("Number picker selected element").located(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"android:id/numberpicker_input\"]"));
    public static Target NUMBER_PICKER_CONFIRM_BUTTON = Target.the("Number picker confirm button").located(AppiumBy.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]"));
    public static Target NUMBER_PICKER_BOTTOM_BUTTON_SCROLL = Target.the("Number picker bottom button to scroll").located(AppiumBy.xpath("//android.widget.NumberPicker" + "/android.widget.Button"));
    public static Target SELECTED_CHILD_LABEL = Target.the("Label of selected child").located(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.booking:id/group_config_child_age_row_button\"]"));
    public static Target ACCOMMODATION_APPLY_BUTTON = Target.the("Apply button").located(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.booking:id/group_config_apply_button\"]"));
    public static Target SEARCH_BUTTON = Target.the("Search button").located(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.booking:id/facet_search_box_cta\"]"));
    public static Target SEARCH_RESULTS_LIST = Target.the("Search results list").located(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView"));
    public static Target SEARCH_RESULTS_SECOND_ELEMENT = Target.the("Search result second element").located(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[3]"));

}
