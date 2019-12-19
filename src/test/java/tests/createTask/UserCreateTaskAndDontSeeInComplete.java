package tests.createTask;

import core.BaseTest;
import core.Constants;
import org.testng.annotations.Test;
import pages.MainPage;

public class UserCreateTaskAndDontSeeInComplete extends BaseTest {
    private static final String NEW_TASK = "Ice cream";

    @Test(description = "User can't see created task in Completed")
    public void createAndCheckTaskInCompleted() {
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_COMPLETED);
        mainPage.isTaskDisplayed(NEW_TASK, true);
    }
}
