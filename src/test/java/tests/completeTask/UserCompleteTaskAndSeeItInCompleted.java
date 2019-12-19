package tests.completeTask;

import core.BaseTest;
import core.Constants;
import org.testng.annotations.Test;
import pages.MainPage;

public class UserCompleteTaskAndSeeItInCompleted extends BaseTest {

    private static final String FIRST_NEW_TASK = "Ice cream";
    private static final String SECOND_NEW_TASK = "Cake";

    @Test(description = "User can't see created task in Completed")
    public void completeTaskAndSeeItInCompleted() {
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.createTask(SECOND_NEW_TASK);
        mainPage.completeTaskByName(SECOND_NEW_TASK);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_COMPLETED);
        mainPage.isTaskDisplayedInCurrentFilter(SECOND_NEW_TASK, true);
    }


}
