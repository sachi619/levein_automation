# Levein Automation

##  Hybrid Automation test Framework using BDD

Behaviour Driven Development test automaton framework for assessment

-- In this test framework I used below tech stacks --
* Cucumber - test layer
* Java - primary language

###### Prerequisites:
* Java 10
* Maven > 3.8.1


### Framework Structure:
* Config.properties (Path: assessment_automation_web/src/main/resources/config.properties)
    * Browser - firefox or chrome
    * Url

* Utility
    * testBase  - BeforeSuite methods
    * baseClass - browser configuration
    * Constants - variables.

* Pages (Path: assessment_automation_web/src/main/java/assessment/web/ui/pages)
  * locators and functions and logics

* Steps (Path: assessment_automation_web/src/test/java/steps)
  * step definitions 

* assessment.feature (Path: assessment_automation_web/src/test/java/features/assessment.feature)
  * Testcase 1: User registration 
  
### How to Execute:
* Navigate to assessment.Feature -> Right-Click on the feature file -> click Run or Click Play / Run button near the Scenarios.
* Navigate to TestRunner Class -> Click Run button => Through the Runner class can generate the report