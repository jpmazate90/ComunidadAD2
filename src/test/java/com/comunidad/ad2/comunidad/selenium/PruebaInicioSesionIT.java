/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.comunidad.ad2.comunidad.selenium;

import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author jpmazate
 */
public class PruebaInicioSesionIT {

    @Autowired
    private static WebDriver driver;

    @BeforeAll
    public static void init() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver();
        driver.get("http://localhost:4200");
    }
    
    @BeforeEach
    public void detenerTiempo() throws InterruptedException {
        Thread.sleep(5000);
    }
    
    @AfterAll 
    public static void finish(){
        driver.quit();
    }

    @Test
    public void testInicioSesion() throws Exception {

        driver.navigate().to("http://localhost:4200/#/login");
        String botonInicio = "boton-iniciar-sesion-login";
        String campoRegistro = "numero-registro-login";
        String campoContrasena = "campo-contrasena-login";

        WebElement boton = driver.findElement(By.id(botonInicio));
        WebElement registro = driver.findElement(By.id(campoRegistro));
        WebElement contrasena = driver.findElement(By.id(campoContrasena));

        WebDriverWait wait = new WebDriverWait(driver, 5000);
        wait.until(ExpectedConditions.visibilityOf(boton));
        registro.sendKeys("111111111");
        contrasena.sendKeys("Juan1!");
        boton.submit();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);

    }

    @Test
    public void testCerrarSesion() throws Exception {
        driver.navigate().to("http://localhost:4200/#/inicio");
        String botonCerrarSesion = "boton-cerrar-sesion";
        WebElement boton = driver.findElement(By.id(botonCerrarSesion));
        boton.click();
    }

}
