package tests;

import core.BaseTest;
import core.Constants;
import org.testng.annotations.Test;
import pages.MainPage;

import static org.testng.AssertJUnit.assertTrue;

public class UserCompleteTaskTest extends BaseTest {
    private static final String FIRST_NEW_TASK = "Ice cream";
    private static final String SECOND_NEW_TASK = "Cake";

    private MainPage mainPage;

    @Test(description = "Completed tasks don't show in Active", priority = 1)
    public void completeTaskAndSeeAnotherActiveTask() {
        System.out.println("Complete");
        mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.createTask(SECOND_NEW_TASK);
        mainPage.completeTaskByName(SECOND_NEW_TASK);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_ACTIVE);
        assertTrue(Constants.TASK_DISPLAY_EXCEPTION, mainPage.isTaskDisplayedInCurrentFilter(FIRST_NEW_TASK));
    }

    @Test(description = "User can't see created task in Completed", priority = 2)
    public void completeTaskAndSeeItInCompleted() {
        System.out.println("Complete");
        mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.createTask(SECOND_NEW_TASK);
        mainPage.completeTaskByName(SECOND_NEW_TASK);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_COMPLETED);
        assertTrue(Constants.TASK_DISPLAY_EXCEPTION, mainPage.isTaskDisplayedInCurrentFilter(SECOND_NEW_TASK));
    }

    @Test(description = "User can completed all tasks, see them in Complete and don't show in Active", priority = 3)
    public void completeAllTask() {
        System.out.println("Complete");
        mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.createTask(SECOND_NEW_TASK);
        mainPage.toggleAllTask();
        mainPage.selectTaskFilterName(Constants.MENU_NAME_COMPLETED);
        mainPage.isTaskDisplayedInCurrentFilter(FIRST_NEW_TASK);
        mainPage.isTaskDisplayedInCurrentFilter(SECOND_NEW_TASK);
        mainPage.selectTaskFilterName(Constants.MENU_NAME_ACTIVE);
        assertTrue(Constants.TASK_DISPLAY_EXCEPTION, mainPage.isTaskDisplayed(FIRST_NEW_TASK));
        assertTrue(Constants.TASK_DISPLAY_EXCEPTION, mainPage.isTaskDisplayed(SECOND_NEW_TASK));
    }
}
