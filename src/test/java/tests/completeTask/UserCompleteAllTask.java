package tests.completeTask;

import core.BaseTest;
import core.Constants;
import org.testng.annotations.Test;
import pages.MainPage;

public class UserCompleteAllTask extends BaseTest {
    private static final String FIRST_NEW_TASK = "Ice cream";
    private static final String SECOND_NEW_TASK = "Cake";
    private static final String MENU_NAME_ACTIVE = "active";

    @Test(description = "User can completed all tasks, see them in Complete and don't shpw in Active")
    public void completeAllTask() {
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.createTask(SECOND_NEW_TASK);
        mainPage.toggleAllTask();
        mainPage.selectTaskFilterName(Constants.MENU_NAME_COMPLETED);
        mainPage.isTaskDisplayedInCurrentFilter(FIRST_NEW_TASK, true);
        mainPage.isTaskDisplayedInCurrentFilter(SECOND_NEW_TASK, true);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_ACTIVE);
        mainPage.isTaskDisplayed(FIRST_NEW_TASK, true);
        mainPage.isTaskDisplayed(SECOND_NEW_TASK, true);
    }

}
