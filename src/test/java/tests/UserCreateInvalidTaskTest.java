package tests;

import core.BaseTest;
import core.Constants;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.AssertJUnit.assertTrue;

public class UserCreateInvalidTaskTest extends BaseTest {
    private static final String NEW_TASK_EMPTY = "";
    private static final String NEW_TASK_SPACE = " ";

    private MainPage mainPage;

    @Test(description = "User can't create empty task", priority = 1)
    public void cantCreateEmptyTask() {
        mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK_EMPTY);
        assertTrue(Constants.TASK_DISPLAY_EXCEPTION, mainPage.isTaskDisplayed(NEW_TASK_EMPTY));
    }

    @Test(description = "User can't create task with space bar", priority = 2)
    public void cantCreateTaskWithSpace() {
        mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK_SPACE);
        assertTrue(Constants.TASK_DISPLAY_EXCEPTION, mainPage.isTaskDisplayed(NEW_TASK_SPACE));
    }
}
