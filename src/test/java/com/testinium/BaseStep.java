package com.testinium;

import com.thoughtworks.gauge.Step;
//import driver.Driver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseStep extends BaseTest {
   private  Logger logger = LoggerFactory.getLogger(getClass());
    private String nereden;
    private String nereye;
    private String isim;
    private String soyIsim;
    private String elekronikPosta;
    private String tcKimlik;
    private String isim2;
    private String soyIsim2;
    private String elekronikPosta2;
    private String tcKimlik2;

    @Step("bilet al")
    public void lokasyon(){
        appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/acMain_btnBooking")).click();
    }
    @Step({"bekle <seconds>"})
    public void waitBySecond1(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @Step("yon secimi")
    public void ucusYonu(){
        appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvOneWay")).click();
    }

    @Step("uçuş nerden")
    public void nereden1() throws Exception {
        dosyaOkuma();
        appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvFromCode")).click();
        MobileElement el2 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch");
        el2.sendKeys(nereden.substring(1));
        Thread.sleep(500);

        appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView[2]")).click();
        TimeUnit.SECONDS.toMillis(2000);
    }

    @Step("uçus nereye")
    public void nereye1() throws Exception {
        dosyaOkuma();
        appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_tvToCode")).click();
        MobileElement el5 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frAirportSelection_etSearch");
        el5.sendKeys(nereye);
        Thread.sleep(500);
        appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.widget.RelativeLayout[2]/android.widget.TextView[2]")).click();
    }

    @Step("Yolcu sayısı artırma")
    public void yolcuSayisi(){
        appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.FrameLayout[7]/android.widget.TextView")).click();

    }
    @Step("uçuş ara")
    public void ucusAra(){
        appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frDashboard_btnSearch")).click();
    }


    @Step("Uçuş Tarihi Seç")
    public void ucusTarihi(){

        MobileElement el1 = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[1]/android.view.ViewGroup[3]");
        el1.click();

    }
    @Step("uçuş kontrolü")
    public void ucusKontrolu() throws Exception {
        MobileElement el1 = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup");
        Assert.assertEquals( el1, el1.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup")));
        logger.info("Uçuş kontrolü sağlandı.");
    }


    @Step("uçuş seç")
    public void ucusSec() throws InterruptedException {
        appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]")).click();
        appiumDriver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.recyclerview.widget.RecyclerView[2]/android.view.ViewGroup[1]/android.widget.FrameLayout[2]/android.widget.LinearLayout/androidx.recyclerview.widget.RecyclerView/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup")).click();
        appiumDriver.findElement(By.id("com.turkishairlines.mobile:id/frFlightSearch_btnContinue")).click();
    }

    @Step( "yolcu bilgileri")
    public void yolcuBilgileri(){
        MobileElement el1 = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ExpandableListView/android.widget.RelativeLayout[2]/android.widget.RelativeLayout");
        el1.click();
    }
    @Step("İsim giriniz")
    public void isimGir() throws Exception {
        dosyaOkuma();
        MobileElement el1 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddName");
        el1.sendKeys(isim);
    }
    @Step("İkinci yolcu İsim giriniz")
    public void isimGir1() throws Exception {
        dosyaOkuma();
        MobileElement el1 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddName");
        el1.sendKeys(isim2);
    }
    @Step("Soyisim giriniz")
    public void soyIsimGir() throws Exception {
        dosyaOkuma();
        MobileElement el2 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddLastName");
        el2.sendKeys(soyIsim);

    }
    @Step("İkinci yolcu Soyisim giriniz")
    public void soyIsimGir1() throws Exception {
        dosyaOkuma();
        MobileElement el2 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddLastName");
        el2.sendKeys(soyIsim2);

    }
    @Step("Cinsiyet Seçimi")
    public void cinSec(){
        MobileElement el1 = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.CheckBox[1]");
        el1.click();

    }
    @Step("dogum Gunu Gir <dogumGunu>")
    public void dogumGunu(String dogumGunu){
        MobileElement el2 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddDateOfBirth");
        el2.sendKeys(dogumGunu);
    }
    @Step("e-posta gir")
    public void eMail() throws Exception {
        dosyaOkuma();
        MobileElement el1 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddEmail");
        el1.sendKeys(elekronikPosta);

    }
    @Step("İkinci yolcu e-posta gir")
    public void eMail1() throws Exception {
        dosyaOkuma();
        MobileElement el1 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddEmail");
        el1.sendKeys(elekronikPosta2);

    }


    @Step("Uyruk Seçiniz")
    public void uyrukSec(){
        MobileElement el1 = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.widget.CheckBox[1]");
        el1.click();

    }
    @Step("TC giriniz")
    public void tcGir() throws Exception {
        dosyaOkuma();
        MobileElement el1 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddTCKN");
        el1.sendKeys(tcKimlik);


    }
    @Step("İkinci yolcu TC giriniz")
    public void tcGir1() throws Exception {
        dosyaOkuma();
        MobileElement el1 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_etAddTCKN");
        el1.sendKeys(tcKimlik2);


    }

    @Step("Üye kayıt verilerini alma")
    public void veriAlmaBtn(){
        MobileElement el1 = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.ScrollView/android.widget.LinearLayout/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup/android.widget.CheckBox[2]");
        el1.click();
    }

    @Step("kaydet")
    public void kaydetBtn(){
        MobileElement el1 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frAddNewPassenger_btnAddPassenger");
        el1.click();

    }
    @Step("ikinci kayit")
    public void okBtn(){
        MobileElement el3 = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ExpandableListView/android.widget.RelativeLayout[4]/android.widget.RelativeLayout/android.widget.ImageView");
        el3.click();
    }
    @Step("ikinci kayitt")
    public void kayitBtn(){
        MobileElement el4 = (MobileElement) appiumDriver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.ExpandableListView/android.widget.RelativeLayout[5]/android.widget.RelativeLayout/android.widget.TextView[1]");
        el4.click();


    }
    @Step("Çıkış işlemlerini yap ve bitir")
    public void cikisIslemleri() throws InterruptedException {
        MobileElement el1 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/frPickPassenger_btnContinue");
        el1.click();
        MobileElement el2 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/toolbarBase_tvCancel");
        el2.click();
        MobileElement el3 = (MobileElement) appiumDriver.findElementById("com.turkishairlines.mobile:id/dgBase_btnPositive");
        el3.click();
    }

    public void dosyaOkuma() {
        String file = "C:\\Users\\testinium\\Desktop\\TurHavaYollariAppiumTest\\kayitlar.csv";
        BufferedReader buffer = null;
        String br = "";
        String split = ";";
        try {
            buffer = new BufferedReader(new FileReader(file));
            while ((br = buffer.readLine()) != null) {

                String[] veri = br.split(split);
                nereden=veri[0];
                nereye =veri[1];
                isim = veri[2];
                soyIsim =veri[3];
                elekronikPosta =veri[4];
                tcKimlik =veri[5];
                isim2 = veri[6];
                soyIsim2 =veri[7];
                elekronikPosta2 =veri[8];
                tcKimlik2 =veri[9];

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }




    }

