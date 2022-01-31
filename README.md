# msingathi.majola
This project automates api requests using rest assured with Java and BDD to test api calls, then generates a report afterwards.

Task 1
============
`Task 1` directory constitutes the test charter and answers to the questions related to the Monefy Android-Emulator app.

Task 2
============
`Task 2` folder contains proposed Test cases for automation in a spreadsheet document. Focusing on the following:

* Test cases are classified according to their impact to business and should be automated based on priority.
* Test automation was considered for the following:

    - `Functionality`: to ensure that each and every feature designed on the app is functional and performs
      according to expectation. This is important because it helps in identifying what works and what doesn't.
    - `User Experience`: Updating user interfaces to better the user experience. This is where the user would not
      whether its easy to use the app or not, and voice out their experience.
    - `Platform`: The platform on which the app was automated against played a key role in the behaviour of the automated
      test cases. This helped in the quick  and easy setup to start testing as no physical android device was required,
      but can cause a lot of instability on the application due to the emulator not being a real device.


* The Monefy application was tested against an Android emulator from Android Studio Arctic Fox 2020.3.1 Canary 15 running
on a Mac OS M1 machine, and the usage of an Appium server was useful as this will help save time in extending the Test 
Cases to accommodate iOS automation in future should it be required. 

The running of the application requires an installation of IntelliJ IDEA from 
https://www.jetbrains.com/idea/download/ for your machine; Appium 1.21.0 and an Android emulator from Android Studio
Arctic Fox 2020.3.1 and the Monefy apk file for installation in the emulator. After cloning the git repository `` then 
to run, you will navigate to the project > src > test > mobile package > then run the Monefy Class.

The application mainly tests the opening the Monefy app from the Android emulator, then it closes the popup message. Once
the user lands up on the home page the user should be able to navigate to a category and capture their income, and after
the user should be able to navigate to any categoery and capture their spending. Further the user needs to be able to
view their balance afterwards and capture their expenses and attach an expense to a respective category.

Task 3
=============
Using Rest-Assured library with cucumber, I wrote automated test cases for Petstore Swagger API endpoints. 
These test cases primarily focused on correct functioning of endpoints using various test cases. Everything available from the src > test folder for this task.

1. Open IntelliJ IDEA that was download from the previous Task
2. Make sure the PetStore Swagger API playground server is running
3. According to this repo:
```
https://github.com/swagger-api/swagger-petstore
```
4. Note: I used the main URL of the Swagger API instead of running it via docker and locally, due to system architecture
   issues with MacOS m1.
5. To run via docker `docker pull swaggerapi/petstore3:latest
   docker run  --name swaggerapi-petstore3 -d -p 8080:8080 swaggerapi/petstore3:latest`
6. The application makes use of cucumber feature files, and there is a directory created that includes all the feature
file steps required.
7. The feature steps package consists of the Java class which has implementation of the feature file steps and other class
8. To run the application, there is a runner class in the runner package, which only requires a user to click on Run.
9. The proposed test case is as follows with various scenarios:
   * The feature here tests whether a user can open the API endpoint  
   * then search a randomly selected status of the pet from
     the store
   * and then tries to a new pet to the store swagger
   * then it fails to add a new pet
   * and because of that the whole feature fails
   * and a report gets generated. 
10. I chose this approach and architecture, because of ease of usage and the fact that it is easy to extend test cases,
also the application of Single Reponsibility principle from SOLID principles.

Running Automated Tests from IntelliJ IDEA
----------------------
Right click on the project folder -> Run -> 'ClassName'
