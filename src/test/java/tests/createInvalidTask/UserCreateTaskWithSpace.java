package tests.createInvalidTask;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;

public class UserCreateTaskWithSpace extends BaseTest {
    private static final String NEW_TASK = " ";

    @Test(description = "User can't create task with space bar")
    public void createTaskWithSpace() {
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.isTaskDisplayed(NEW_TASK, true);

    }

}
