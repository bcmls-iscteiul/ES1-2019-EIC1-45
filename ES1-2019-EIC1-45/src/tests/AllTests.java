package tests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import excel.ExcelFile;


@RunWith(JUnitPlatform.class)
@SelectClasses({ExcelObjectTest.class, ExcelFileTest.class, RuleTest.class})
public class AllTests {

}
