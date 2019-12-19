package tests.editTask;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;

public class UserCorrectNewTask extends BaseTest {
    private static final String FIRST_NEW_TASK = "Hello";
    private static final String SECOND_NEW_TASK = "Good bye";

    @Test(description = "User can edit new task")
    public void correctNewTask() {
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.callTaskEditorByName(FIRST_NEW_TASK);
        mainPage.setNewTaskName(SECOND_NEW_TASK, FIRST_NEW_TASK);
        mainPage.isTaskDisplayedInCurrentFilter(SECOND_NEW_TASK, true);
    }
}
