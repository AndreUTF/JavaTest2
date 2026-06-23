# Maven Project 1 - Documentation

## Project Overview

### Purpose
Maven Project 1 is a multi-purpose Java demonstration and testing project that showcases various programming concepts and testing frameworks. It includes:

1. **Core Algorithms** - Bubble sort implementation and utilities
2. **JSON Processing** - Key-value pair parsing and JSON object manipulation
3. **String Manipulation** - Bracket matching, character counting, and string parsing
4. **Test Automation** - Comprehensive testing using multiple frameworks (TestNG, JUnit 5)
5. **Web Testing** - Selenium-based UI automation tests
6. **API Testing** - REST API testing with RestAssured

### Main Modules and Packages

**Package Structure:**
```
com.mycompany.mavenproject1
├── Main Classes
│   └── Mavenproject1.java (algorithms and utilities)
└── Test Classes
    ├── Unit Tests
    │   ├── Mavenproject1Test.java
    │   └── testingNgTest.java
    ├── Selenium UI Tests
    │   ├── HLTVTest.java
    │   └── SeleniumTest.java
    ├── REST API Tests
    │   ├── RestAssuredTest.java
    │   └── RestAssured1Test.java
    └── Other Tests
        └── CoraLandingPageTest.java (empty)
```

### High-Level Architecture

```
┌─────────────────────────────────────────────────────┐
│            Maven Project 1                          │
├─────────────────────────────────────────────────────┤
│  Core Components                                    │
│  ├─ Sorting Algorithms (Bubble Sort)               │
│  ├─ String Processing & Parsing                    │
│  └─ JSON Manipulation                              │
├─────────────────────────────────────────────────────┤
│  Testing Framework                                  │
│  ├─ TestNG (Primary Test Framework)                │
│  ├─ JUnit 5 (Secondary/Comparative Framework)      │
│  └─ RestAssured (API Testing)                      │
├─────────────────────────────────────────────────────┤
│  External Integrations                              │
│  ├─ Selenium WebDriver (Chrome)                    │
│  ├─ REST API Testing (JSONPlaceholder, Custom API) │
│  └─ Web Automation (HLTV.org, Cypress.io)          │
└─────────────────────────────────────────────────────┘
```

### Key Technologies

| Technology | Version | Purpose |
|-----------|---------|---------|
| Java | 17+ | Programming Language |
| Maven | Latest | Build Tool |
| TestNG | 7.10.2 | Test Framework (Primary) |
| JUnit 5 | 5.10.2 | Test Framework (Secondary) |
| Selenium | 4.23.0 | Web Automation |
| RestAssured | 5.4.0 | API Testing |
| JSON Processing | org.json 20240303 | JSON Object Handling |
| Appium | 9.1.0 | Mobile Testing Support |

### Project Statistics

- **Total Source Classes**: 1 (`Mavenproject1.java`)
- **Total Test Classes**: 7 (with 1 empty)
- **Total Test Methods**: 83+ test cases
- **Main Test Framework**: TestNG
- **Secondary Test Framework**: JUnit 5
- **External Dependencies**: 8+ (Selenium, RestAssured, TestNG, JUnit, Hamcrest, etc.)

### Build Configuration

**Maven (`pom.xml`)**
- **Compiler**: Java 26
- **Java Release**: 17
- **Main Executable Class**: `com.mycompany.mavenproject1.Mavenproject1`
- **Test Runner**: Maven Surefire Plugin (v3.2.5)

### Project Scope

This project serves multiple purposes:
1. **Learning & Demonstration** - Shows various Java programming patterns and test automation techniques
2. **Test Automation Framework** - Includes web UI testing and REST API testing
3. **Algorithm Practice** - Implements sorting algorithms and data structure manipulation
4. **Framework Comparison** - Demonstrates differences between TestNG and JUnit 5

### Next Steps for Development

See [RECOMMENDATIONS.md](RECOMMENDATIONS.md) for suggested improvements and missing implementations.
