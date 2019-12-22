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

    @Test(description = "User can edit completed task")
    public void correctCompletedTask () {
        mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.completeTask();
        mainPage.selectTaskFilterName(Constants.MENU_NAME_COMPLETED);
        mainPage.callTaskEditorByName(FIRST_NEW_TASK);
        mainPage.setNewTaskName(SECOND_NEW_TASK, FIRST_NEW_TASK);
        assertTrue("Task wasn't displayed", mainPage.isTaskDisplayedInCurrentFilter(SECOND_NEW_TASK));
    }

    @Test(description = "User can edit new task")
    public void correctNewTask() {
        mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        //mainPage.selectTaskFilterName(Constants.MENU_NAME_ALL); //?????????????????????????????????
        mainPage.callTaskEditorByName(FIRST_NEW_TASK);
        mainPage.setNewTaskName(SECOND_NEW_TASK, FIRST_NEW_TASK);
        assertTrue("Task wasn't displayed", mainPage.isTaskDisplayedInCurrentFilter(SECOND_NEW_TASK));


    }
}
