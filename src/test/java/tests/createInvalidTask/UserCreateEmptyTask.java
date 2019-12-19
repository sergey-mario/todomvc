package tests.createInvalidTask;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;

public class UserCreateEmptyTask extends BaseTest {
    private static final String NEW_TASK = "";

    @Test(description = "User can't create empty task")
    public void createEmptyTask() {
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.isTaskDisplayed(NEW_TASK, true);
    }
}
