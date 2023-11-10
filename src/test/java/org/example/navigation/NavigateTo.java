package org.example.navigation;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import org.example.navigation.pages.RurallHomePage;

public class NavigateTo {
    public static Performable theLoginPage() {
        return Task.where("{0} opens the Rurall home page",
                Open.browserOn().the(RurallHomePage.class));
    }
}
