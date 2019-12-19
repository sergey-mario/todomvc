package tests.createTask;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;

public class UserCreateTaskAndCheckAmount extends BaseTest {
    public int taskCount = 1;
    private static final String FIRST_NEW_TASK = "Ice cream";
    private static final String SECOND_NEW_TASK = "Cake";

    @Test(description = "User can create tasks and see count of active tasks on display")
    public void createTaskAndCheckAmount() {
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(FIRST_NEW_TASK);
        mainPage.createTask(SECOND_NEW_TASK);
        mainPage.completeTaskByName(SECOND_NEW_TASK);
        mainPage.isCorrectTaskCount(taskCount);
    }



}
