/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.mavenproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Arrays;

import org.json.JSONObject;

/**
 *
 * @author andre
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        /*
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println("a = " + a);
        
        
        System.out.println("arr" + arr);
        for (int i : arr){
            System.out.println("i = " + i);
        }
         */
        int[] arr = {4, 1, -10, 40, 60, 80, 55};
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] >= arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        int[] arr512 = {4, 1, -10, 40, 60, 80, 55};
        Arrays.sort(arr512);
        //Arrays.sort(arr);
        System.out.println("dadsda");
        for (int i : arr) {
            System.out.println("i = " + i);
        }
        
        int count1 = 0;
        int count2 = 0;
        String str3 = "zZOOAB";
        for(int i=0;i<str3.length();i++){
            if((str3.charAt(0) == 'z')){
            
            }
        }
        //System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get("https://www.cypress.io/#create");
//
//        // 2. Locate the search text box using its name attribute
//        WebElement acceptButton = driver.findElement(By.xpath("//*[contains(@class, 'osano-cm-accept')]"));
//        acceptButton.click();
//
//        WebElement productsLink = driver.findElement(By.xpath("//*[@id=\"dropdownProducts\"]"));
//        productsLink.click();
//
//        WebElement contactSales = driver.findElement(By.xpath("//*[@data-cy='header-contact-sales']"));
//        contactSales.click();
//
//        try {
//            // Pauses the script completely for 5000 milliseconds (5 seconds)
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        //Assert.assertTrue(actualTitle.contains(expectedTitleContains), "The title did not match the search query!");
//        driver.close();
    System.out.println("Start small. Ship something.");
        String str = "(()({}{}[]";
        System.out.println("str" + str);
        int countOfA = 0;
        int countOfB = 0;
        int countOfC = 0;
        int countOfD = 0;
        int countOfE = 0;
        int countOfF = 0;
        
        for (int i=0;i<str.length();i++){
            System.out.println("str[" + i + "]:" + str.charAt(i));
            if( str.charAt(i) == '('){
                countOfA +=1;
            }
            if( str.charAt(i) == ')'){
                countOfB +=1;
            }
            if( str.charAt(i) == '{'){
                countOfC +=1;
            }
            if( str.charAt(i) == '}'){
                countOfD +=1;
            }
            if( str.charAt(i) == '['){
                countOfE +=1;
            }
            if( str.charAt(i) == ']'){
                countOfF +=1;
            }
        }
        
        System.out.println("countOfA" + countOfA);
        System.out.println("countOfB" + countOfB);
        System.out.println("countOfC" + countOfC);
        System.out.println("countOfD" + countOfD);
        System.out.println("countOfE" + countOfE);
        System.out.println("countOfF" + countOfF);
        
        
        String str4 = "Maria Do Rosario Lopez";
        String[] str1 = str4.split(" ");
        System.out.println("str1 " + str1);
        for(String element : str1){
            System.out.println("element " + element);
        }
        
        String[] arr3 = str.split("}");
        for(String element : arr3){
            System.out.println("element " + element);
        }
        
        JSONObject jsonObject1 = new JSONObject();
        String str6 = "name1=test1;name2=test2;name3=test3;";
        String[] strStr = str6.split(";");
        
        for(int g=0; g<strStr.length; g++){
            if(strStr[g].isEmpty()) continue;
            String[] strStr2 = strStr[g].split("=");
            if(strStr2.length == 2) {
                jsonObject1.put(strStr2[0], strStr2[1]);
                System.out.println(jsonObject1);
            }
        }
        
        /*
        for(String element : strStr){
            System.out.println("element " + element);
            String[] strStr2 = element.split("=");
            jsonObject1.put(strStr2[0], strStr2[1]);
            System.out.println(strStr2[0] + "" + strStr2[1]);
            System.out.println(jsonObject1);
        }
        */
        
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Full Name", "Ritu Sharma");
        jsonObject.put("Roll No.", 1704310046);
        jsonObject.put("Tuition Fees", 65400);
        System.out.println(jsonObject);
        
        System.out.println(jsonObject);
    }
}