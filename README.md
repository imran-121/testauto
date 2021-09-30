
**********************************
Tools Used
**********************************

1) Java + Apache Maven + Junit + Selenium + Log4j
2) You can refer to pom.xml inside project root folder for all of the dependencies


**********************************
Directory Structure
**********************************
- Root folder name  <testauto>
- Find all of the test source code in directory <testauto\src\test\java>
- Find test reports in directory <testauto\target>
- Find log files in <testauto\target\test\logs>
- Logs configuration file <testauto\src\test\resources\log4j2.xml>

**********************************
How to run
**********************************
1) Make sure the application under test in running at : http://localhost:8080 
   Or if you are running it on diff port/url, then you can configure it in class <TestRunnerBase>
   Rlease refer to last section [Setting up System under test]
2) Go inside to the root folder <cd testauto>
3) Execute <mvnw test>
5) You will see the result on maven build console and reports will be created in target folder


**********************************
Class level information
**********************************
1) TestRunnerBase 
	- This is the base class for Test Runner class
	- For setting up all of base configuration for driver
	
2) TestRunner 
	- This class is starting point of test execution
	- Its a collection of test cases

3) Executor 
	- This class is solely responsible for processing test case backend tasks
	- Its takes the WebDriver class object and performs the actions on it
	- It also leverages the functionality from Logger Class and Locators Class  
	
4) Locators
	- This class is the repository for xpaths
	- xpaths are segregated on the basis of respective page object level
	
4) Helpers
	- This class is responsible for handling generic tasks 
	
	
****************************************************
Setting up System under test
****************************************************	
1) Execute the below mention command to run the application on local environment:
   - Set JAVA_HOME variable in your system
   - git clone https://github.com/spring-projects/spring-petclinic.git
   - cd spring-petclinic
   - ./mvnw spring-boot:run or mvnw spring-boot:run

2)After this you can access the application on: http://localhost:8080/
This is an application which contains information about the veterinarians and the information
of pet owners

****************************************************
Test Cases
****************************************************
 UI Automation framework and automate the below mention use cases:
1) Verify image on home page
2) Find all the Veterinarians which are added in the application
3) Find all the existing owners which are added in application
4) Add a new owner, add pet for that owner.
5) Check all the information added for the newly created owner and pet is correct 
