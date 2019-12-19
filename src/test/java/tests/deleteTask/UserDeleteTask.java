package tests.deleteTask;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;

public class UserDeleteTask extends BaseTest {
    private static final String NEW_TASK = "Ice cream";

    @Test(description = "User can delete task")
    public void deleteTask(){
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.deleteTask(NEW_TASK);
        mainPage.isTaskDisplayed(NEW_TASK, true);
    }

}
