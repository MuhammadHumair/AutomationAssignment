
	*****************

	Hybrid Framework

	*****************

Basically, a hybrid framework is a data-driven framework with hybrid nature which is implemented by using Page Object Model (POM) and Page Factory Model (PFM).

First of all, I want to explain those libraries which are used to build this framework and after that, its folder structure, and at last how the framework will run the test case.

I created a maven project and get dependencies from the maven repository. It works like other dependency or library manager such as pip in python. There is a pom.xml file that helps us to add a new library to the project easily without finding and downloading the jar files of it. It automatically downloads the files from the maven repository whereas we can easily manage the dependencies versions.

I used majorly four libraries to build the framework which is as follows:

	  i) Selenium (It is used to automate the website.)
	 ii) TestNG (It is used to make automated tests more structured, readable, maintainable, and user-friendly. It is also used for annotations and assertions.)
	iii) Extent Report (It is used to make attractive reports of test cases.)
	 iv) Log4j (It is used for logging the activities.)

The beauty of the framework is that everything organizes independently well manner. Moreover, components can be reusable. We don't do anything hard coded. So, I learned and implemented everything independently. I made several folders to make this framework such as Drivers, Screenshots, Configurations, etc.

In the main/java folder, I made four packages and inside packages, I made different classes. Additionally, actions are written in customAction class. BaseClass is a class that has all methods used repeatedly and other classes extend the base class. All web elements of the page are handled separately in pageObjects package. In the utility package, I managed all helper classes which provide help to make attractive reports and read configuration files. In the src/test/java directory, I wrote just a test case. Test Cases are handled separately from other java core classes. The configuration folder is used to store the values which we access within the project such as URL, username, password, driver's path, etc. The screenshots folder is used to store screenshots of all steps while running the test cases. The drivers' folder is used to store the driver's .exe files. It is helpful while project reusing, paths of drivers will not return the error. Furthermore, the logs folder is used to store the logs with timestamps. At last, in a test-output folder, we store the reports of passed/failed/skipped test cases.

All configuration files are stored in the project parent directory which are as follows:

	  i) extent-reports.xml (It is used for reports configurations.)
	 ii) log4j.properties (It is used to store the logging configurations.)
	iii) pox.xml (It works like a dependency manager to download and add in the project.)
	 iv) testng.xml (It is a testng configuration file.)

TestNG.xml file is a file from where we call the test cases which we wrote in the src/test/java directory. From TestNG, we can pass the browser name as a parameter to the test case in which the browser test case will execute. In addition, we also mention in this file if we want to test the test case on different browsers at the same time or run test cases parallelly. This is a starting point from where we will run the scripts. We will run this file as TestNG, then screenshots will store in the screenshots folder as above said, logs will store in the logs folder, and a detailed report will save in the test-output folder with passed/failed/skipped status.