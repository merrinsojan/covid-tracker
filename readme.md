# Covid tracker

This document gives details to setup the project locally and run the test cases locally.

## Prerequisites

- **Java JDK 8 or later**
- **Maven**
- **IDE (Optional but recommended)**: Eclipse / Intellij
  
## Steps to setup and run the project locally

### Step 1: Checkout the Project
Clone the project repository from GitHub:


```bash
git clone https://github.com/merrinsojan/covid-tracker
```
   
### Step 2: navigate to folder 
Cd into the folder having pom.xml:

```bash
cd covid-tracker
```

### Step 3: Compile 
Compile the checked out code:

```bash
mvn compile
```
   
### Step 4: Run
Run the test suite using: 

```bash
mvn test
```


Results of the test will can be observed in the console output. Details of test output available in test-output folder