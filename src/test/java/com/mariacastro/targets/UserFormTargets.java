package com.mariacastro.targets;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class UserFormTargets {

    public static Target FIRST_NAME_INPUT = Target.the("First name Input").located(AppiumBy.xpath("//javaClass[@resource-id=\"com.booking:id/bstage1_contact_firstname_value\"]/*[@resource-id=\"com.booking:id/bui_input_container_content\"]"));
    public static Target LAST_NAME_INPUT = Target.the("Last name Input").located(AppiumBy.xpath("//javaClass[@resource-id=\"com.booking:id/bstage1_contact_lastname_value\"]/*[@resource-id=\"com.booking:id/bui_input_container_content\"]"));
    public static Target EMAIL_INPUT = Target.the("Email Input").located(AppiumBy.xpath("//javaClass[@resource-id=\"com.booking:id/bstage1_contact_email_value\"]/*[@resource-id=\"com.booking:id/bui_input_container_content\"]"));
    public static Target ADDRESS_INPUT = Target.the("Address Input").located(AppiumBy.xpath("//javaClass[@resource-id=\"com.booking:id/bstage1_contact_address_value\"]/*[@resource-id=\"com.booking:id/bui_input_container_content\"]"));
    public static Target ZIP_CODE_INPUT = Target.the("Zip Code Input").located(AppiumBy.xpath("//javaClass[@resource-id=\"com.booking:id/bstage1_contact_zipcode_value\"]/*[@resource-id=\"com.booking:id/bui_input_container_content\"]"));
    public static Target CITY_INPUT = Target.the("City Input").located(AppiumBy.xpath("//javaClass[@resource-id=\"com.booking:id/bstage1_contact_city_value\"]/*[@resource-id=\"com.booking:id/bui_input_container_content\"]"));
    public static Target COUNTRY_INPUT = Target.the("Country Input").located(AppiumBy.xpath("//javaClass[@resource-id=\"com.booking:id/bstage1_contact_country_value\"]/*[@resource-id=\"com.booking:id/bui_input_container_content\"]"));
    public static Target PHONE_INPUT = Target.the("Phone Input").located(AppiumBy.xpath("//javaClass[@resource-id=\"com.booking:id/bstage1_contact_telephone_value\"]/*[@resource-id=\"com.booking:id/bui_input_container_content\"]"));
    public static Target LEISURE_RADIO_BUTTON = Target.the("Leisure Radio Button").located(AppiumBy.xpath("//android.widget.RadioButton[@resource-id=\"com.booking:id/business_purpose_leisure\"]"));
    public static Target SUBTOTAL_INFO_FORM_LABEL = Target.the("Subtotal info form label").located(AppiumBy.xpath("//android.widget.LinearLayout[@resource-id=\"com.booking:id/informative_cta_view_price_container\"]/android.widget.FrameLayout[1]/android.widget.TextView[@resource-id=\"com.booking:id/title\"]"));
    public static Target NEXT_STEP_FORM_BUTTON = Target.the("Next step info form button").located(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.booking:id/action_button\"]"));

}
