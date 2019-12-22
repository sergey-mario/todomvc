package tests;

import core.BaseTest;
import core.Constants;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class UserCreateTaskTest extends BaseTest {
    private static final String NEW_TASK = "Ice cream";
    private static final String FIRST_NEW_TASK = "Ice cream";
    private static final String SECOND_NEW_TASK = "Cake";

    private MainPage mainPage;

    @Test(description = "User can complete task", priority = 1)
    public void createAndCompleteTask() {
        mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.completeTask();
        mainPage.selectTaskFilterName(Constants.MENU_NAME_COMPLETED);
        assertTrue(Constants.TASK_DISPLAY_EXCEPTION, mainPage.isTaskDisplayedInCurrentFilter(NEW_TASK));
    }

    @Test(description = "User can create task", priority = 2)
    public void createNewTask() {
        mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_ALL);
        mainPage.isTaskDisplayedInCurrentFilter(NEW_TASK);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_ACTIVE);
        assertTrue(Constants.TASK_DISPLAY_EXCEPTION, mainPage.isTaskDisplayedInCurrentFilter(NEW_TASK));
    }

    @Test(description = "User can create tasks and see count of active tasks on display", priority = 3)
    public void createTaskAndCheckAmount() {
        mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.createTask(SECOND_NEW_TASK);
        mainPage.completeTaskByName(SECOND_NEW_TASK);
        assertEquals(Constants.TASK_COUNT_EXCEPTION, mainPage.isCorrectTaskCount()
                , String.format("%d item left", 1));
    }

    @Test(description = "User can't see created task in Completed", priority = 4)
    public void createAndCheckTaskInCompleted() {
        mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_COMPLETED);
        assertTrue(Constants.TASK_DISPLAY_EXCEPTION, mainPage.isTaskDisplayed(NEW_TASK));
    }

    @Test(description = "User can create task by clicking in empty place of site", priority = 5)
    public void createTaskByClick() {
        mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.clickOnEmptyPlace();
        assertTrue(Constants.TASK_DISPLAY_EXCEPTION, mainPage.isTaskDisplayedInCurrentFilter(NEW_TASK));
    }
}
