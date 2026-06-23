# Architecture Documentation

## System Architecture

### Component Diagram

```
┌─────────────────────────────────────────────────────────────────────┐
│                     Maven Project 1                                 │
├─────────────────────────────────────────────────────────────────────┤
│                                                                     │
│  ┌────────────────────────────────────────────────────────────┐   │
│  │         Main Application Layer                            │   │
│  │  ┌──────────────────────────────────────────────────────┐ │   │
│  │  │  Mavenproject1 (Utility & Demo Class)                │ │   │
│  │  │  ├─ Bubble Sort Algorithm                           │ │   │
│  │  │  ├─ String Parsing & Manipulation                   │ │   │
│  │  │  ├─ Character Counting Logic                        │ │   │
│  │  │  └─ JSON Object Creation & Management               │ │   │
│  │  └──────────────────────────────────────────────────────┘ │   │
│  └────────────────────────────────────────────────────────────┘   │
│                                                                     │
│  ┌────────────────────────────────────────────────────────────┐   │
│  │         Test Layer                                         │   │
│  │  ┌──────────────────────────────────────────────────────┐ │   │
│  │  │  Unit Tests                                          │ │   │
│  │  │  └─ Mavenproject1Test (14 tests)                    │ │   │
│  │  └──────────────────────────────────────────────────────┘ │   │
│  │  ┌──────────────────────────────────────────────────────┐ │   │
│  │  │  Integration Tests - Web Automation                  │ │   │
│  │  │  ├─ HLTVTest (25 tests)                             │ │   │
│  │  │  └─ SeleniumTest (30 tests)                         │ │   │
│  │  └──────────────────────────────────────────────────────┘ │   │
│  │  ┌──────────────────────────────────────────────────────┐ │   │
│  │  │  Integration Tests - API Testing                     │ │   │
│  │  │  ├─ RestAssuredTest (3 tests)                       │ │   │
│  │  │  └─ RestAssured1Test (5 tests)                      │ │   │
│  │  └──────────────────────────────────────────────────────┘ │   │
│  │  ┌──────────────────────────────────────────────────────┐ │   │
│  │  │  Framework Comparison Tests                          │ │   │
│  │  │  └─ testingNgTest (6 tests)                         │ │   │
│  │  └──────────────────────────────────────────────────────┘ │   │
│  └────────────────────────────────────────────────────────────┘   │
│                                                                     │
│  ┌────────────────────────────────────────────────────────────┐   │
│  │         Infrastructure Layer                              │   │
│  │  ┌──────────────────────────────────────────────────────┐ │   │
│  │  │  Maven Build System                                  │ │   │
│  │  │  ├─ Compiler Plugin (Java 26)                       │ │   │
│  │  │  └─ Surefire Plugin (Test Runner)                   │ │   │
│  │  └──────────────────────────────────────────────────────┘ │   │
│  │  ┌──────────────────────────────────────────────────────┐ │   │
│  │  │  External Dependencies                               │ │   │
│  │  │  ├─ JSON Processing (org.json)                      │ │   │
│  │  │  ├─ Selenium WebDriver (4.23.0)                     │ │   │
│  │  │  ├─ RestAssured (5.4.0)                             │ │   │
│  │  │  ├─ TestNG (7.10.2)                                 │ │   │
│  │  │  ├─ JUnit 5 (5.10.2)                                │ │   │
│  │  │  ├─ Hamcrest (2.2)                                  │ │   │
│  │  │  └─ Appium (9.1.0)                                  │ │   │
│  │  └──────────────────────────────────────────────────────┘ │   │
│  └────────────────────────────────────────────────────────────┘   │
│                                                                     │
│  ┌────────────────────────────────────────────────────────────┐   │
│  │         External Systems                                  │   │
│  │  ├─ HLTV.org (Web Application)                           │   │
│  │  ├─ Cypress.io (Web Application)                         │   │
│  │  ├─ JSONPlaceholder API (Mock REST API)                 │   │
│  │  └─ dotesthere.com (Custom REST API)                    │   │
│  └────────────────────────────────────────────────────────────┘   │
│                                                                     │
└─────────────────────────────────────────────────────────────────────┘
```

---

## Data Flow

### 1. Bubble Sort Data Flow

```
Input: Integer Array
    │
    ├─→ Mavenproject1.main()
    │   ├─ Nested loop iteration
    │   ├─ Element comparison
    │   └─ Element swapping (in-place)
    │
    └─→ Sorted Array (Output)
```

### 2. String Parsing Data Flow

```
Input: "name1=test1;name2=test2;name3=test3;"
    │
    ├─→ Split by ";" → ["name1=test1", "name2=test2", "name3=test3", ""]
    │
    ├─→ For each element:
    │   ├─ Check if empty → skip
    │   ├─ Split by "=" → [key, value]
    │   └─ Put in JSONObject
    │
    └─→ JSONObject: {"name1":"test1", "name2":"test2", "name3":"test3"}
```

### 3. Test Execution Data Flow

```
Test Framework (TestNG/JUnit)
    │
    ├─→ @BeforeEach/@BeforeMethod
    │   └─ Initialize test data
    │
    ├─→ @Test
    │   ├─ Execute test logic
    │   └─ Perform assertions
    │
    └─→ @AfterEach/@AfterMethod
        └─ Cleanup resources
```

### 4. Web Testing Data Flow

```
ChromeDriver
    │
    ├─→ Navigate to URL
    │
    ├─→ Find Elements (XPath, CSS, ID)
    │
    ├─→ Perform Actions (Click, Type, Hover)
    │
    ├─→ Wait for Elements
    │   ├─ Implicit Wait
    │   └─ Explicit Wait (WebDriverWait)
    │
    ├─→ Verify Element Properties
    │
    └─→ Generate Test Results
```

### 5. API Testing Data Flow

```
RestAssured
    │
    ├─→ Build Request
    │   ├─ Method (GET/POST/PUT/DELETE)
    │   ├─ Endpoint URL
    │   └─ Request Body (if applicable)
    │
    ├─→ Send HTTP Request
    │
    ├─→ Receive Response
    │   ├─ Status Code
    │   ├─ Headers
    │   └─ Body
    │
    ├─→ Apply Assertions
    │   ├─ Status code validation
    │   ├─ Response body validation
    │   └─ JSON structure validation
    │
    └─→ Test Result (Pass/Fail)
```

---

## Dependency Graph

### Build Dependencies

```
pom.xml (Maven Configuration)
    │
    ├─→ Test Dependencies (Scope: test)
    │   ├─ TestNG (7.10.2)
    │   ├─ JUnit 5 (5.10.2)
    │   │   ├─ junit-jupiter-api
    │   │   └─ junit-jupiter-engine
    │   ├─ RestAssured (5.4.0)
    │   ├─ Hamcrest (2.2)
    │   └─ Appium (9.1.0)
    │
    ├─→ Main Dependencies
    │   ├─ Selenium (4.23.0)
    │   ├─ JSON (20240303)
    │   ├─ JSON-Simple (1.1)
    │   └─ RestAssured (5.4.0)
    │
    └─→ Build Plugins
        ├─ Maven Compiler (3.13.0)
        └─ Maven Surefire (3.2.5)
```

### Runtime Dependencies

```
Application Startup
    │
    ├─→ JVM (Java Runtime)
    │
    ├─→ Classpath Resolution
    │   ├─ org.json.JSONObject
    │   ├─ java.util.Arrays
    │   └─ org.openqa.selenium.*
    │
    └─→ Mavenproject1.main()
```

### Test Execution Dependencies

```
Test Runner (Surefire Plugin)
    │
    ├─→ TestNG Engine (Primary Framework)
    │   ├─ 74 test methods
    │   └─ Selenium + RestAssured Integration
    │
    ├─→ JUnit 5 Engine (Secondary Framework)
    │   ├─ 3 test methods
    │   └─ Framework Comparison Tests
    │
    ├─→ External Services
    │   ├─ Chrome WebDriver (Browser Control)
    │   ├─ HTTP Client (API Requests)
    │   └─ Assertion Libraries (Hamcrest)
    │
    └─→ Test Results
```

---

## External Integrations

### 1. Selenium WebDriver Integration

**Purpose:** Web automation and UI testing  
**Configuration:**
- **Browser:** Chrome
- **Driver:** ChromeDriver (embedded in selenium-java)
- **Version:** 4.23.0
- **Capabilities:**
  - Element detection and interaction
  - Page navigation
  - Event simulation (click, type, hover)
  - Screenshot capture
  - Window/tab management
  - JavaScript execution

**Test Coverage:**
- HLTVTest (25 tests)
- SeleniumTest (30 tests)
- Total: 55 Selenium tests

### 2. RestAssured Integration

**Purpose:** REST API testing  
**Configuration:**
- **Version:** 5.4.0
- **HTTP Methods:** GET, POST, PUT, DELETE
- **Response Formats:** JSON, XML
- **Assertion:** Hamcrest matchers
- **Target APIs:**
  - JSONPlaceholder (Mock API)
  - dotesthere.com (Custom API)

**Test Coverage:**
- RestAssuredTest (3 tests)
- RestAssured1Test (5 tests)
- Total: 8 REST API tests

### 3. JSON Processing Integration

**Purpose:** JSON object creation and manipulation  
**Configuration:**
- **Primary Library:** org.json (20240303)
  - Features: Insertion order preservation
  - Used in: Mavenproject1.java
- **Secondary Library:** json-simple (1.1) (legacy)
  - Status: Deprecated for this use case

**Features:**
- Create JSON objects
- Add key-value pairs
- Maintain insertion order
- String representation

### 4. Test Framework Integration

#### TestNG
- **Version:** 7.10.2
- **Test Count:** 74 tests
- **Features:**
  - Annotations (@Test, @BeforeMethod, @AfterMethod)
  - Data-driven testing (@DataProvider)
  - Parametrized tests
  - Test grouping
  - Parallel execution

#### JUnit 5
- **Version:** 5.10.2
- **Test Count:** 3 tests (comparison only)
- **Features:**
  - Annotations (@Test, @BeforeEach, @AfterEach)
  - Parametrized tests
  - Exception testing (assertThrows)
  - Timeout testing

### 5. Target Applications

#### HLTV.org
- **Type:** Web Application (E-sports)
- **Testing:** UI automation
- **Test Class:** HLTVTest (25 tests)
- **Coverage:** Navigation, search, menu, content

#### Cypress.io
- **Type:** Web Application (Test Framework)
- **Testing:** UI automation
- **Test Class:** SeleniumTest (30 tests)
- **Coverage:** Element interaction, navigation, advanced actions

#### JSONPlaceholder
- **Type:** Mock REST API
- **Endpoints:** /users, /posts, etc.
- **Testing:** REST API testing
- **Test Class:** RestAssuredTest (3 tests)
- **Coverage:** GET, POST operations

#### dotesthere.com
- **Type:** Custom REST API
- **Testing:** REST API testing
- **Test Class:** RestAssured1Test (5 tests)
- **Coverage:** CRUD operations (GET, POST, PUT, DELETE)

---

## Deployment Architecture

### Development Environment

```
Developer Machine
    │
    ├─→ IDE (NetBeans/IntelliJ/Eclipse)
    │
    ├─→ Maven
    │   ├─ Compile source code
    │   ├─ Run tests (Surefire)
    │   └─ Generate artifacts
    │
    ├─→ JDK 17+ (Compiler)
    │   └─ Java 26 (Configured in pom.xml)
    │
    ├─→ Git (Version Control)
    │
    └─→ Chrome Browser + ChromeDriver
        └─ For Selenium tests
```

### Build Pipeline

```
Source Code (Git Repository)
    │
    ├─→ Maven Clean
    │   └─ Remove previous build artifacts
    │
    ├─→ Maven Compile
    │   ├─ Source: src/main/java
    │   └─ Output: target/classes
    │
    ├─→ Maven Test (Surefire Plugin)
    │   ├─ Source: src/test/java
    │   ├─ Frameworks: TestNG, JUnit 5
    │   └─ Output: Test results
    │
    ├─→ Maven Package
    │   └─ Create JAR artifact
    │
    └─→ Maven Install
        └─ Install to local repository
```

### Test Execution Environment

```
Test Execution
    │
    ├─→ Unit Tests
    │   ├─ Mavenproject1Test (14 tests)
    │   └─ Execution time: < 1 second
    │
    ├─→ Integration Tests (Web)
    │   ├─ HLTVTest (25 tests)
    │   ├─ SeleniumTest (30 tests)
    │   └─ Execution time: ~ 5-10 minutes (depends on page load)
    │
    ├─→ Integration Tests (API)
    │   ├─ RestAssuredTest (3 tests)
    │   ├─ RestAssured1Test (5 tests)
    │   └─ Execution time: < 2 seconds
    │
    └─→ Framework Comparison Tests
        ├─ testingNgTest (6 tests)
        └─ Execution time: < 1 second
```

---

## Security Considerations

### Current Security Status

1. **No Authentication:** Tests connect to public APIs without credentials
2. **No Data Encryption:** Uses HTTP (not HTTPS) in some test cases
3. **No Sensitive Data:** No passwords, tokens, or secrets in code
4. **Open Test APIs:** Uses public mock APIs (JSONPlaceholder) and free test services

### Security Recommendations

1. **Use Environment Variables** for API credentials
2. **Use HTTPS** for all external integrations
3. **Implement API Key Management** if real API testing is added
4. **Add Input Validation** for test data
5. **Secure WebDriver** communication if testing authenticated pages

---

## Performance Characteristics

### Test Execution Performance

| Test Category | Test Count | Est. Duration | Performance Impact |
|---|---|---|---|
| Unit Tests | 14 | < 1 sec | Minimal |
| Web UI Tests | 55 | 5-10 min | High (Browser startup) |
| API Tests | 8 | < 2 sec | Minimal |
| Framework Tests | 6 | < 1 sec | Minimal |
| **Total** | **83** | **5-15 min** | - |

### Optimization Opportunities

1. **Parallel Test Execution** - Configure TestNG for parallel runs
2. **Browser Session Reuse** - Share WebDriver across tests
3. **API Response Caching** - Cache mock API responses
4. **Selective Test Runs** - Run only affected tests

---

## Scalability Considerations

### Current Limitations

1. **Single Main Class** - All logic in one file
2. **Monolithic Test Structure** - Tests not well-organized by feature
3. **Limited Modularity** - Code reuse not optimized
4. **Manual Resource Management** - No dependency injection

### Scaling Recommendations

1. **Refactor Main Class** - Extract algorithms into separate classes
2. **Create Page Objects** - For Selenium tests
3. **Create API Client** - For REST API tests
4. **Implement Factory Pattern** - For WebDriver creation
5. **Use Dependency Injection** - For test setup/teardown

