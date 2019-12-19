package tests.deleteTask;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;

public class UserCompleteAndDeleteTask extends BaseTest {
    private static final String NEW_TASK = "Ice cream";

    @Test(description = "User can complete and delete task")
    public void createAndDeleteTask() {
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.completeTask();
        mainPage.clearCompletedTask();
        mainPage.isTaskDisplayed(NEW_TASK, true);
    }
}
