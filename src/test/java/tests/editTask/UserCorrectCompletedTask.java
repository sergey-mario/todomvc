package tests.editTask;

import core.BaseTest;
import core.Constants;
import org.testng.annotations.Test;
import pages.MainPage;

public class UserCorrectCompletedTask extends BaseTest {
    private static final String FIRST_NEW_TASK = "Hello";
    private static final String SECOND_NEW_TASK = "Good bye";

    @Test(description = "User can edit completed task")
    public void correctCompletedTask () {
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.completeTask();
        mainPage.selectTaskFilterName(Constants.MENU_NAME_COMPLETED);
        mainPage.callTaskEditorByName(FIRST_NEW_TASK);
        mainPage.setNewTaskName(SECOND_NEW_TASK, FIRST_NEW_TASK);
        mainPage.isTaskDisplayedInCurrentFilter(SECOND_NEW_TASK, true);
    }
}
