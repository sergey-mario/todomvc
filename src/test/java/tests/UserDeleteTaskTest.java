package tests;

import core.BaseTest;
import core.Constants;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.AssertJUnit.assertTrue;

public class UserDeleteTaskTest extends BaseTest {
    private static final String FIRST_NEW_TASK = "Ice cream";
    private static final String SECOND_NEW_TASK = "Cake";
    private static final String NEW_TASK = "Ice cream";

    private MainPage mainPage;

    @Test(description = "Completed and deleted tasks don't show in All and Active")
    public void completeAndDeleteTaskAndDontShowInAllAndActive() {
        mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.createTask(SECOND_NEW_TASK);
        mainPage.completeTaskByName(SECOND_NEW_TASK);
        mainPage.clearCompletedTask();
        mainPage.selectTaskFilterName(Constants.MENU_NAME_ALL);
        assertTrue("Task wasn't displayed", mainPage.isTaskDisplayedInCurrentFilter(FIRST_NEW_TASK));
        mainPage.selectTaskFilterName(Constants.MENU_NAME_ACTIVE);
        assertTrue("Task wasn't displayed", mainPage.isTaskDisplayedInCurrentFilter(FIRST_NEW_TASK));

    }

    @Test(description = "User can complete and delete task")
    public void createAndDeleteTask() {
        mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.completeTask();
        mainPage.clearCompletedTask();
        assertTrue("Task wasn't displayed", mainPage.isTaskDisplayed(NEW_TASK));
    }

    @Test(description = "User can delete task")
    public void deleteTask(){
        mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.deleteTask(NEW_TASK);
        assertTrue("Task wasn't displayed", mainPage.isTaskDisplayed(NEW_TASK));

    }

    @Test(description = "Deleted tasks don't show in All")
    public void deleteTaskAndSeeAnotherInAll() {
        mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.createTask(SECOND_NEW_TASK);
        mainPage.deleteTaskByName(SECOND_NEW_TASK);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_ALL);
        assertTrue("Task wasn't displayed", mainPage.isTaskDisplayedInCurrentFilter(FIRST_NEW_TASK));
    }
}
