package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By inputField = By.xpath("//input[@class='new-todo']");
    private By checkBoxCircle = By.xpath("//input[@class='toggle']");
    private By checkBoxDestroy = By.xpath("//button[@class='destroy']");
    private By buttonClearCompleted = By.xpath("//button[@class='clear-completed']");
    private By buttonToggleAll = By.xpath("//label[@for='toggle-all']");
    private By countActiveTask = By.xpath("//span[@class='todo-count']");
    private By editTaskField = By.xpath("//input[@class='edit']");
    private By placeForClick = By.xpath("//ul[@class='filters']");
    private String menuButtonPath = "//a[@href='#/%s']";
    private String taskLabelPath = "//label[text()='%s']";
    private String taskForComplete = "//label[text()='%s']//preceding-sibling::input";
    private String taskForDelete = "//label[text()='%s']//following-sibling::button";

    public void createTask(String taskName) {
        WebElement newTaskTextField = driver.findElement(inputField);
        newTaskTextField.sendKeys(taskName);
        newTaskTextField.sendKeys(Keys.ENTER);
    }

    public void completeTask() {
        WebElement toggleTask = driver.findElement(checkBoxCircle);
        toggleTask.click();
    }

    public void deleteTask(String taskName) {
        WebElement inputTask = driver.findElement(By.xpath(String.format(taskLabelPath, taskName)));
        Actions actions = new Actions(driver);
        actions.moveToElement(inputTask).build().perform();
        WebElement deleteTaskCheckBox = driver.findElement(checkBoxDestroy);
        deleteTaskCheckBox.click();
    }

    public void selectTaskFilterName(String menuName) {
        WebElement menuButton = driver.findElement(By.xpath(String.format(menuButtonPath, menuName)));
        menuButton.click();
    }

    public boolean isTaskDisplayedInCurrentFilter(String taskName) {
        WebElement inputTask = driver.findElement(By.xpath(String.format(taskLabelPath, taskName)));
        return inputTask.isDisplayed();
    }

    public boolean isTaskDisplayed(String taskName) {
        List<WebElement> taskList = driver.findElements(By.xpath(String.format(taskLabelPath, taskName)));
        return taskList.isEmpty();
    }

    public void clearCompletedTask() {
        WebElement buttonForClear = driver.findElement(buttonClearCompleted);
        buttonForClear.click();
    }

    public void toggleAllTask() {
        WebElement buttonForToggleAllTask = driver.findElement(buttonToggleAll);
        buttonForToggleAllTask.click();
    }

    public String isCorrectTaskCount() {
        WebElement taskCount = driver.findElement(countActiveTask);
        return taskCount.getText();
    }

    public void completeTaskByName(String taskName) {
        WebElement numberOfTask = driver.findElement(By.xpath(String.format(taskForComplete, taskName)));
        numberOfTask.click();
    }

    public void deleteTaskByName(String taskName) {
        WebElement inputTask = driver.findElement(By.xpath(String.format(taskLabelPath, taskName)));
        Actions actions = new Actions(driver);
        actions.moveToElement(inputTask).build().perform();
        WebElement deleteTaskCheckBox = driver
                .findElement(By.xpath(String.format(taskForDelete, taskName)));
        deleteTaskCheckBox.click();
    }

    public void callTaskEditorByName(String taskName) {
        WebElement inputTask = driver.findElement(By.xpath(String.format(taskLabelPath, taskName)));
        Actions actions = new Actions(driver);
        actions.doubleClick(inputTask).perform();
    }

    public void setNewTaskName(String newTaskName, String actualTaskName) {
        WebElement editField = driver.findElement(editTaskField);
        editField.click();
        for (int i = 0; i <= actualTaskName.length(); i++) {
            editField.sendKeys(Keys.BACK_SPACE);
        }
        editField.sendKeys(newTaskName);
        editField.sendKeys(Keys.ENTER);
    }

    public void clickOnEmptyPlace() {
        WebElement emptyPlace = driver.findElement(placeForClick);
        emptyPlace.click();
    }
}
