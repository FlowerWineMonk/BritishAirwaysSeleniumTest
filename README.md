# BritishAirwaysSeleniumTest

## Overview

This project contains automated UI tests for the British Airways web application. The tests are designed to verify the Login, Registration and Book Flow Tests.

## What is Tested

- Validation of input fields and error messages
- Navigation between main pages (Pre-login page, Login page and Registration page)
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

   - Make sure to create a configurations (if needed) in `src/test/resources/application.properties` (BASE_URL).

4. **Run the Tests**

   - To execute all tests, use:

     ```bash
     mvn test
     ```

   - For specific test classes:

     ```bash
     mvn -Dtest=TestClassName test
     ```

## Techniques Used

- **Selenium WebDriver**: For browser automation and UI interaction.
- **Page Object Model (POM)**: To organize test code and improve maintainability.
- **TestNG**: For test structure and assertions.
- **Maven**: For dependency management and test lifecycle.
- **Waits**: For handling web elements.

---

Feel free to open issues or contribute to this project!
