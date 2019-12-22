package tests;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.AssertJUnit.assertTrue;

public class UserCreateInvalidTaskTest extends BaseTest {
    private static final String NEW_TASK_EMPTY = "";
    private static final String NEW_TASK_SPACE = " ";
    private MainPage mainPage;

    @Test(description = "User can't create empty task")
    public void cantCreateEmptyTask() {
        mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK_EMPTY);
        assertTrue("Task wasn't displayed", mainPage.isTaskDisplayed(NEW_TASK_EMPTY));

    }

    @Test(description = "User can't create task with space bar")
    public void cantCreateTaskWithSpace() {
        mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK_SPACE);
        assertTrue("Task wasn't displayed", mainPage.isTaskDisplayed(NEW_TASK_SPACE));
    }
}
