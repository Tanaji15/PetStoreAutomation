package PetStorAutomation.api.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.http.Header;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentReportManager implements ITestListener {

    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static String repoName;
    public static ExtentTest test;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    //public static ExtentReports createInstance ()
    public void onStart(ITestContext context)
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repoName = "Index" +
                ".html";
        sparkReporter = new ExtentSparkReporter(".\\reports\\"+repoName);
        sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");
        sparkReporter.config().setReportName("Pet Store User API");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application","Pet Store User API");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("User", "Tanaji");
       // return extent;
    }

  /*  public void onStart(ITestContext context)
    {
        extent=createInstance();
    } */

    public void onTestStart(ITestResult result)
    {
        test = extent.createTest("Test Name " +result.getTestClass().getName().toUpperCase() + " - " +result.getMethod().getMethodName().toUpperCase());
        extentTest.set(test);
    }

    public static void logPassDetails(String log)
    {
        extentTest.get().pass(MarkupHelper.createLabel(log, ExtentColor.GREEN));
    }

    public static void logFailureDetails(String log)
    {
        extentTest.get().fail(MarkupHelper.createLabel(log, ExtentColor.RED));
    }

    public static void logInfoDetails(String log)
    {
        extentTest.get().info(MarkupHelper.createLabel(log, ExtentColor.GREY));
    }

    public static void logWarningDetails(String log)
    {
        extentTest.get().warning(MarkupHelper.createLabel(log, ExtentColor.YELLOW));
    }

    public static void logJson(String json)
    {
        extentTest.get().info(MarkupHelper.createCodeBlock(json, CodeLanguage.JSON));
    }

    public static void printHeaders(List<Header> headerList)
    {
       String[][] arrayHeaders = headerList.stream().map(header ->new String[] {header.getName(), header.getValue()})
                       .toArray(String[][] ::new);

        extentTest.get().info(MarkupHelper.createTable(arrayHeaders));
    }

    public void onFinish(ITestContext testContext)
    {
        if(extent!=null)
            extent.flush();
    }
}
