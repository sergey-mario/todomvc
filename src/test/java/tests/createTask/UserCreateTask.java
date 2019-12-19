package tests.createTask;

import core.BaseTest;
import core.Constants;
import org.testng.annotations.Test;
import pages.MainPage;

public class UserCreateTask extends BaseTest {
    private static final String NEW_TASK = "Ice cream";

    @Test(description = "User can create task")
    public void createNewTask() {
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.selectTaskFilterName("");
        mainPage.isTaskDisplayedInCurrentFilter(NEW_TASK, true);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_ACTIVE);
        mainPage.isTaskDisplayedInCurrentFilter(NEW_TASK, true);
    }
}
