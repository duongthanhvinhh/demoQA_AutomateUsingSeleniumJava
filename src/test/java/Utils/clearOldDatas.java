package Utils;

import org.apache.commons.io.FileUtils;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static Common.extentReport.ExtentTestManager.reporterLog;

public class clearOldDatas {
    public static void deleteOldAllureResults() {
        String userPath = System.getProperty("user.dir");
        File allureResult = new File(userPath + "/allure-results/");
        if (allureResult.exists()) {
            reporterLog("Clear allure result");
            try {
                FileUtils.cleanDirectory(allureResult);
                FileUtils.deleteDirectory(allureResult);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void deleteOldExportData() {
        String userPath = System.getProperty("user.dir");
        File exportData = new File(userPath + "/ExportData/");
        File snapshot = new File(userPath + "/Automation_Reports/Screenshots/");
        if (exportData.exists()) {
            reporterLog("delete old exportData");
            try {
                FileUtils.cleanDirectory(exportData);
                FileUtils.deleteDirectory(exportData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (snapshot.exists()) {
            reporterLog("delete old snapshots");
            try {
                FileUtils.cleanDirectory(snapshot);
                FileUtils.deleteDirectory(snapshot);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void deleteOldExtentReports() {
        String userPath = System.getProperty("user.dir");
        File extentReports = new File(userPath + "/ExtentReports/");
        if (extentReports.exists()) {
            reporterLog("delete old extent reports");
            try {
                FileUtils.cleanDirectory(extentReports);
                FileUtils.deleteDirectory(extentReports);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void deleteOldlogs() {
        String userPath = System.getProperty("user.dir");
        File logs = new File(userPath + "/logs/");
        if (logs.exists()) {
            reporterLog("delete old logs");
            try {
                FileUtils.cleanDirectory(logs);
                FileUtils.deleteDirectory(logs);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void deleteOldtestRecordings() {
        String userPath = System.getProperty("user.dir");
        File testRecords = new File(userPath + "/test-recordings/");
        if (testRecords.exists()) {
            reporterLog("delete old test Records");
            try {
                FileUtils.cleanDirectory(testRecords);
                FileUtils.deleteDirectory(testRecords);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

