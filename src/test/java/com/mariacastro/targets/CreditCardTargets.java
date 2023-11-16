package com.mariacastro.targets;

import io.appium.java_client.AppiumBy;
import net.serenitybdd.screenplay.targets.Target;

public class CreditCardTargets {

    public static Target CREDIT_CARD_NUMBER_INPUT = Target.the("Credit Card number input").located(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.booking:id/new_credit_card_number_edit\"]"));
    public static Target CREDIT_CARD_EXPIRATION_DATE_INPUT = Target.the("Credit Card expiration date").located(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.booking:id/new_credit_card_expiry_date_edit\"]"));
    public static Target CREDIT_CARD_CVV_INPUT = Target.the("Credit Card cvv input").located(AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.booking:id/new_credit_card_cvc_edit_text\"]"));
    public static Target FINAL_TOTAL_LABEL = Target.the("Final Total Label").located(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.booking:id/bp_price_summary_total_price_value\"]"));

}
