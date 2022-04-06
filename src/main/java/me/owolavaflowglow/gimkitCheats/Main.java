package me.owolavaflowglow.gimkitCheats;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Main {
	
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.gimkit.com/join");
		JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
		while (true) {
			try {
				runTick(driver, javascriptExecutor);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Map<String, String> questionAnswers = new HashMap<String, String>();
	public static String lastQuestion = "https://e621.net";
	public static void runTick(WebDriver driver, JavascriptExecutor javascriptExecutor) {
		
		// Get the question and the answers
		List<WebElement> questionAndAnswers = driver.findElements(By.className("notranslate"));
		
		// Check if we're on answer result screen
		if (questionAndAnswers.size() == 0) {
			try {
				
				// Click the view answer button if it's on screen
				WebElement button = driver.findElements(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div/div[5]/div/div/div[2]/div/div/div[2]/span[1]/div/div/div/div")).get(0);
				if (button != null && button.getText().equals("View Correct Answer")) {
					button.click();
				}
				
			} catch (Exception e) {
//				e.printStackTrace();
			}
			
			// Return
			return;
		}
		
		// Answer question if we already know the answer or get the answer if we don't
		switch (questionAndAnswers.size()) {
		
		case 2:{
			// If we are on the answer screen then copy down the answer
			try {
				WebElement arrow = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div[2]/div/div/div/div/i"));
				if (arrow != null && arrow.getText().length() == 0) {
					WebElement question = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div[1]/div/div/div/div/div/span"));
					WebElement answer = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div/div/div/div/div[5]/div/div/div[2]/div/div/div[1]/div/div[3]/div/div/div/div/span"));
					questionAnswers.put(question.getText(), answer.getText());
					questionAndAnswers.get(0).click();
					return;
				}
			} catch (Exception e) {
//				e.printStackTrace();
			}
		}
		break;
		
		// This means it's a multiple choice question
		case 5:{
				String question = questionAndAnswers.get(0).getText();
				
				// We know the answer to the question already
				if (questionAnswers.containsKey(question)) {
					for (int i = 1; i < 5; i++) {
						if (questionAndAnswers.get(i).getText().equals(questionAnswers.get(question))) {
							questionAndAnswers.get(i).click();
						}
					}
					return;
				}
				
				// We don't know the answer to the question
				lastQuestion = question;
				questionAndAnswers.get(1).click();
			}	
			break;

		default:
			System.out.println(questionAndAnswers.size());
			break;
		}
		
	}
	
}
