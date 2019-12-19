package tests.createTask;

import core.BaseTest;
import org.testng.annotations.Test;
import pages.MainPage;

public class UserCreateTaskByClick extends BaseTest {
    private static final String NEW_TASK = "Ice cream";

    @Test(description = "User can create task by clicking in empty place of site")
    public void createTaskByClick () {
        MainPage mainPage = new MainPage(driver);
        mainPage.createTask(NEW_TASK);
        mainPage.clickOnEmptyPlace();
        mainPage.isTaskDisplayedInCurrentFilter(NEW_TASK, true);

    }

}
