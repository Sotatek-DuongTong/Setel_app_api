# Test_mobile_API
## Description
- Testing framework for Todoist App
- Core: Java + Appium + REST Assured + TestNG
## Setup Environment:
- Java JDK 11 or higher (add to Path System Environment Variable)
- Maven 3.8.1 (add to Path System Environment Variable)
- Appium Desktop 1.21.0 (for Windows)
- Android Emulator in Android Studio Arctic Fox | 2020.3.1 Patch 4 (add to Path System Environment Variable)
- Setup an Android Virtual Device with the following information:
- Device name: Android Phone; Android version: 11 
- Install the app for the virtual device
## Test Target:
Todoist Mobile App and Api
## Framework Components:
### main
- commons: stores common functions used by all pageObjects/apiObjects
- mobilePageObjects: stores specific functions used by each pageObject
- mobileInterfaces:stores locator of each page
- apiObjects: stores specific functions used by each apiObject
- apiEndpoints: stores endpoint of each api
### test cases
Action taken for test
### test resources
Supplement files for test cases
## Run Test
- Start the Android Virtual Device
- Start appium desktop app and start the server at 0.0.0.0:4723
- Open `run.bat` to run test or run in any supported IDE
