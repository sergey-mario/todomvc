package tests;

import core.BaseTest;
import core.Constants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class UserCreateTaskTest extends BaseTest {
    private static final String NEW_TASK = "Ice cream";
    private static final String FIRST_NEW_TASK = "Ice cream";
    private static final String SECOND_NEW_TASK = "Cake";
    private static final int COUNT = 1;
    private MainPage mainPage;

    @Test(description = "User can complete task")
    public void createAndCompleteTask() {
        mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        //mainPage.selectTaskFilterName(Constants.MENU_NAME_ALL); ///????????????????????????????
        mainPage.completeTask();
        mainPage.selectTaskFilterName(Constants.MENU_NAME_COMPLETED);
        assertTrue("Task wasn't displayed", mainPage.isTaskDisplayedInCurrentFilter(NEW_TASK));

    }

    @Test(description = "User can create task")
    public void createNewTask() {
        mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_ALL);
        mainPage.isTaskDisplayedInCurrentFilter(NEW_TASK);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_ACTIVE);
        assertTrue("Task wasn't displayed", mainPage.isTaskDisplayedInCurrentFilter(NEW_TASK));

    }

    @Test(description = "User can create tasks and see count of active tasks on display")
    public void createTaskAndCheckAmount() {
        mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.createTask(SECOND_NEW_TASK);
        mainPage.completeTaskByName(SECOND_NEW_TASK);
        assertEquals("Сount is not working correctly", mainPage.isCorrectTaskCount(), String.format("%d item left", COUNT));

    }

    @Test(description = "User can't see created task in Completed")
    public void createAndCheckTaskInCompleted() {
        mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_COMPLETED);
        assertTrue("Task wasn't displayed", mainPage.isTaskDisplayed(NEW_TASK));

    }

    @Test(description = "User can create task by clicking in empty place of site")
    public void createTaskByClick () {
        mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.clickOnEmptyPlace();
        assertTrue("Task wasn't displayed", mainPage.isTaskDisplayedInCurrentFilter(NEW_TASK));

    }
}
