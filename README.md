## Table of Contents

- [Technologies Used](#technologies-used)
- [Folder Structure](#folder-structure)
- [Setup and Running](#setup-and-running)
- [Design Patterns](#design-patterns)
- [Created By](#created-by)

## Technologies Used

- **Serenity**: Test automation framework that integrates with Cucumber for behavior-driven development (BDD).
- **Cucumber**: BDD tool for writing acceptance tests in a human-readable format.
- **Appium 2**: Open-source tool for automating mobile applications.
- **Java**: Programming language used for test implementation.
- **Gradle**: Build tool used to manage dependencies and build the project.
- **Other Dependencies**: Add any other significant dependencies or tools used.

## Folder Structure

The project structure is organized as follows:

```bash
|-- .gitignore
|-- README.md
|-- build.gradle
|-- gradlew
|-- gradlew.bat
|-- serenity.properties
|-- src
    -- test
        |-- java
        |   -- com
        |       -- mariacastro
        |           |-- acceptancetests
        |           |   |-- AcceptanceTestSuite.java
        |           |-- steps
        |           |   |-- BookingStepDefinitions.java
        |           |   |-- CreditCardStepDefinitions.java
        |           |   |-- ParameterDefinitions.java
        |           |   |-- SearchAccommodationStepDefinitions.java
        |           |-- targets
        |           |   |-- BookingTargets.java
        |           |   |-- CreditCardTargets.java
        |           |   |-- SearchTargets.java
        |           |   |-- UserFormTargets.java
        |           |   -- VerifyDataTargets.java
        |           |-- tasks
        |           |   |-- CreditCardForm.java
        |           |   |-- SearchALocation.java
        |           |   |-- SelectDatesOnSearch.java
        |           |   |-- SelectPeople.java
        |           |   |-- SelectRooms.java
        |           |   |-- UserInfoForm.java
        |           |-- utils
        |               |-- ScrollUtils.java
        |-- resources
            |-- features
            |   -- booking
            |       |-- create_booking.feature
            |       |-- search_accommodations.feature
            |-- serenity.conf

```

## Setup and Running

Follow these steps to set up and run the project:

1. **Clone Repository**:
    - <code> git clone https://github.com/Mariaangelica2226/e2e-booking-yape.git</code>
    - <code> cd e2e-booking-yape/</code>

2. **Install Dependencies**:
   <code>./gradlew install</code>

3. **Run Appium server**:
   You need to have appium installed in your local machine and then run in your terminal
   <code>appium</code>

5. **Run Tests**:
   <code>./gradlew clean test</code>

Add any additional steps or configurations required to run the project.

## Design Patterns

- Page Object Model
- Screenplay Pattern

## Created By

- Maria Angelica Castro Duarte