package tests;

import core.BaseTest;
import core.Constants;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.AssertJUnit.assertTrue;

public class UserEditTaskTest extends BaseTest {
    private static final String FIRST_NEW_TASK = "Hello";
    private static final String SECOND_NEW_TASK = "Good bye";
    private MainPage mainPage;

    @Test(description = "User can edit completed task", priority = 1)
    public void correctCompletedTask() {
        System.out.println("Edit");
        mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.completeTask();
        mainPage.selectTaskFilterName(Constants.MENU_NAME_COMPLETED);
        mainPage.callTaskEditorByName(FIRST_NEW_TASK);
        mainPage.setNewTaskName(SECOND_NEW_TASK, FIRST_NEW_TASK);
        assertTrue(Constants.TASK_DISPLAY_EXCEPTION, mainPage.isTaskDisplayedInCurrentFilter(SECOND_NEW_TASK));
    }

    @Test(description = "User can edit new task", priority = 2)
    public void correctNewTask() {
        System.out.println("Edit");
        mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.callTaskEditorByName(FIRST_NEW_TASK);
        mainPage.setNewTaskName(SECOND_NEW_TASK, FIRST_NEW_TASK);
        assertTrue(Constants.TASK_DISPLAY_EXCEPTION, mainPage.isTaskDisplayedInCurrentFilter(SECOND_NEW_TASK));
    }
}
