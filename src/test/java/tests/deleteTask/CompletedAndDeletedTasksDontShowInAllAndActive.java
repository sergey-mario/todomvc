package tests.deleteTask;

import core.BaseTest;
import core.Constants;
import org.testng.annotations.Test;
import pages.MainPage;

public class CompletedAndDeletedTasksDontShowInAllAndActive extends BaseTest {
    private static final String FIRST_NEW_TASK = "Ice cream";
    private static final String SECOND_NEW_TASK = "Cake";

    @Test(description = "Completed and deleted tasks don't show in All and Active")
    public void completeAndDeleteTaskAndDontShowInAllAndActive() {
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.createTask(SECOND_NEW_TASK);
        mainPage.completeTaskByName(SECOND_NEW_TASK);
        mainPage.clearCompletedTask();
        mainPage.selectTaskFilterName(Constants.MENU_NAME_ALL);
        mainPage.isTaskDisplayedInCurrentFilter(FIRST_NEW_TASK, true);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_ACTIVE);
        mainPage.isTaskDisplayedInCurrentFilter(FIRST_NEW_TASK, true);
    }

}
