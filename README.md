# BritishAirwaysSeleniumTest

## Overview

This project contains automated UI tests for the British Airways web application. The tests are designed to verify the Login, Registration, and Book Flow Tests.

## What is Tested

- Validation of input fields and error messages
- Navigation between main pages (Pre-login page, Login page, and Registration page)
- Verification of UI components (buttons, links, etc.)
- Responsive behavior of key pages

## How to Run the Tests

1. **Clone the Repository**

   ```bash
   git clone https://github.com/FlowerWineMonk/BritishAirwaysSeleniumTest.git
   cd BritishAirwaysSeleniumTest
   ```

2. **Install Dependencies**
   - Make sure you have Java and Maven installed.
   - Install all required dependencies:

     ```bash
     mvn clean install
     ```

3. **Configure Test Parameters**
   - Make sure to create a configuration file (if needed) in `src/test/resources/application.properties` (e.g., `BASE_URL`).

4. **Run the Tests**
   - To execute all tests, use:

     ```bash
     mvn test
     ```

   - For specific test classes:

     ```bash
     mvn -Dtest=TestClassName test
     ```

## Generating the Allure Report

1. **Run the tests** to generate the Allure results:

   ```bash
   mvn test
   ```

2. **Generate the Allure report** (output will be generated in the **project root**):

   ```bash
   allure serve
   ```

   or, to build the report without serving it:

   ```bash
   allure generate --clean
   ```

3. **Open the report**:
   - If using `allure serve`, it will automatically open in your default browser.
   - If you generated it manually, open the `index.html` file from the created `allure-report` folder in the project root.

## Techniques Used

- **Selenium WebDriver**: For browser automation and UI interaction.
- **Page Object Model (POM)**: To organize test code and improve maintainability.
- **TestNG**: For test structure and assertions.
- **Maven**: For dependency management and test lifecycle.
- **Waits**: For handling dynamic web elements.

---

Feel free to open issues or contribute to this project!
