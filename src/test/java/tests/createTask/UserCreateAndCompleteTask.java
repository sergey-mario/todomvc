package tests.createTask;

import core.BaseTest;
import core.Constants;
import org.testng.annotations.Test;
import pages.MainPage;

public class UserCreateAndCompleteTask extends BaseTest {
    private static final String NEW_TASK = "Ice cream";

    @Test(description = "User can complete task")
    public void createAndCompleteTask() {
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.completeTask();
        mainPage.selectTaskFilterName(Constants.MENU_NAME_COMPLETED);
        mainPage.isTaskDisplayedInCurrentFilter(NEW_TASK, true);
    }
}
