package com.app.Utils;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportHandling 
{
	public static ExtentSparkReporter TakeReport(String ReportPath)
	{
		ExtentSparkReporter report = new ExtentSparkReporter(ReportPath);
		return report;
	}

}
