package tests.deleteTask;

import core.BaseTest;
import core.Constants;
import org.testng.annotations.Test;
import pages.MainPage;

public class UserDeleteTaskAndSeeAnotherInAll extends BaseTest {
    private static final String FIRST_NEW_TASK = "Ice cream";
    private static final String SECOND_NEW_TASK = "Cake";

    @Test(description = "Deleted tasks don't show in All")
    public void deleteTaskAndSeeAnotherInAll() {
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.createTask(SECOND_NEW_TASK);
        mainPage.deleteTaskByName(SECOND_NEW_TASK);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_ALL);
        mainPage.isTaskDisplayedInCurrentFilter(FIRST_NEW_TASK, true);
    }
}
