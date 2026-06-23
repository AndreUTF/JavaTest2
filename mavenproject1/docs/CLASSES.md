# Class Reference Documentation

## Main Source Classes

### 1. Mavenproject1

**Package:** `com.mycompany.mavenproject1`  
**Location:** `src/main/java/com/mycompany/mavenproject1/Mavenproject1.java`  
**Type:** Utility Class  
**Scope:** Public

#### Purpose and Responsibilities

`Mavenproject1` is a demonstration class containing utility methods for various algorithms and data manipulation tasks. It serves as a learning resource and proof-of-concept for different programming concepts.

#### Main Methods

**1. `main(String[] args)`**
- **Visibility:** Public Static
- **Parameters:** Command-line arguments (unused)
- **Return Type:** void
- **Description:** Entry point of the application. Contains inline demonstrations of:

#### Core Functionality

##### 1. **Bubble Sort Implementation**
```java
// Bubble sort for integer arrays
for (int i = 0; i < arr.length - 1; i++) {
    for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] >= arr[j + 1]) {
            int temp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = temp;
        }
    }
}
```
- **Time Complexity:** O(n²)
- **Space Complexity:** O(1)
- **Features:** In-place sorting, stable
- **Input:** Integer array with mixed positive/negative numbers

##### 2. **String Parsing and Splitting**
- Splits strings by delimiters (space, semicolon, equals sign)
- Extracts substrings and arrays
- **Example:** `"name1=test1;name2=test2;name3=test3"` → key-value pairs

##### 3. **Character Counting**
```java
// Counts bracket occurrences
- Opening parentheses: (
- Closing parentheses: )
- Opening braces: {
- Closing braces: }
- Opening brackets: [
- Closing brackets: ]
```
- **Use Case:** Bracket matching validation
- **Input:** String with mixed bracket types

##### 4. **JSON Object Creation**
```java
JSONObject jsonObject1 = new JSONObject();
String str6 = "name1=test1;name2=test2;name3=test3;";
String[] strStr = str6.split(";");

for(int g=0; g<strStr.length; g++){
    if(strStr[g].isEmpty()) continue;
    String[] strStr2 = strStr[g].split("=");
    if(strStr2.length == 2) {
        jsonObject1.put(strStr2[0], strStr2[1]);
    }
}
```
- **Library:** `org.json.JSONObject` (not json-simple)
- **Feature:** Maintains insertion order
- **Output:** `{"name1":"test1","name2":"test2","name3":"test3"}`

#### Important Fields

| Field | Type | Scope | Purpose |
|-------|------|-------|---------|
| `arr` | `int[]` | Local | Test data for bubble sort |
| `str` | `String` | Local | String with mixed brackets |
| `str6` | `String` | Local | Key-value pair string |
| `jsonObject1` | `JSONObject` | Local | JSON object storage |

#### Dependencies on Other Classes

| Dependency | Package | Purpose |
|------------|---------|---------|
| `JSONObject` | `org.json` | JSON object creation and manipulation |
| `Arrays` | `java.util` | Array utilities (for comparison) |
| `WebDriver` | `org.openqa.selenium` | (Imported but not used) |
| `ChromeDriver` | `org.openqa.selenium.chrome` | (Imported but not used) |
| `Duration` | `java.time` | (Imported but not used) |

#### Design Patterns Used

1. **Procedural Programming** - Direct implementation of algorithms in main method
2. **Demo/Playground Pattern** - Serves as a testing ground for concepts
3. **Utility Class** - Contains reusable algorithm implementations

#### Known Issues and Considerations

1. **No Separation of Concerns** - All functionality is in the main method
2. **Limited Reusability** - Methods are not extracted; code is procedural
3. **No Error Handling** - Does not validate input or handle exceptions
4. **Hard-coded Test Data** - Test data is embedded in the main method
5. **Mixed Dependencies** - Imports Selenium classes that are never used

#### Potential Improvements

1. Extract bubble sort to a separate `SortingUtils` class
2. Create `StringParser` class for string manipulation
3. Create `JsonBuilder` class for JSON operations
4. Add input validation and error handling
5. Remove unused imports (Selenium)
6. Add Javadoc comments

#### Testing Status

**Partially Tested by:** `Mavenproject1Test.java`
- ✅ Bubble sort algorithm (14 test cases)
- ❌ String parsing (not tested)
- ❌ Character counting (not tested)
- ❌ JSON object creation (not tested)

---

## Supporting Test Classes

### 1. Mavenproject1Test

**Location:** `src/test/java/com/mycompany/mavenproject1/Mavenproject1Test.java`  
**Type:** Unit Test Class  
**Framework:** TestNG  
**Test Methods:** 14

See [TESTS.md](TESTS.md) for detailed test documentation.

### 2. testingNgTest

**Location:** `src/test/java/com/mycompany/mavenproject1/testingNgTest.java`  
**Type:** Framework Comparison Test  
**Frameworks:** JUnit 5, TestNG  
**Test Methods:** 6

**Purpose:** Demonstrates differences between JUnit 5 and TestNG frameworks with side-by-side comparisons.

See [TESTS.md](TESTS.md) for detailed test documentation.

### 3. HLTVTest

**Location:** `src/test/java/com/mycompany/mavenproject1/HLTVTest.java`  
**Type:** Selenium UI Test  
**Framework:** TestNG  
**Target Application:** HLTV.org (Esports website)  
**Test Methods:** 25

**Scope of Tests:**
- Navigation and URL validation
- Element detection and visibility
- Search functionality
- Menu navigation
- Content interaction
- Browser actions

See [TESTS.md](TESTS.md) for detailed test documentation.

### 4. SeleniumTest

**Location:** `src/test/java/com/mycompany/mavenproject1/SeleniumTest.java`  
**Type:** Selenium UI Test  
**Framework:** TestNG  
**Target Application:** Cypress.io (Test automation framework website)  
**Test Methods:** 30

**Scope of Tests:**
- Web element interaction (click, send keys, hover)
- Element properties (text, attributes, size, location)
- Navigation (forward, back, refresh)
- Advanced actions (drag-drop, double-click, right-click)
- Waits (implicit, explicit)
- Window/handle management

See [TESTS.md](TESTS.md) for detailed test documentation.

### 5. RestAssuredTest

**Location:** `src/test/java/com/mycompany/mavenproject1/RestAssuredTest.java`  
**Type:** REST API Test  
**Framework:** TestNG + RestAssured  
**Target API:** JSONPlaceholder (Mock REST API)  
**Test Methods:** 3

**Endpoints Tested:**
- GET /users
- GET /users/1
- POST /posts

See [TESTS.md](TESTS.md) for detailed test documentation.

### 6. RestAssured1Test

**Location:** `src/test/java/com/mycompany/mavenproject1/RestAssured1Test.java`  
**Type:** REST API Test  
**Framework:** TestNG + RestAssured  
**Target API:** dotesthere.com (Custom REST API)  
**Test Methods:** 5

**CRUD Operations Tested:**
- GET /users
- GET /users/1
- PUT /users/1
- POST /users
- DELETE /users/1

See [TESTS.md](TESTS.md) for detailed test documentation.

### 7. CoraLandingPageTest

**Location:** `src/test/java/com/mycompany/mavenproject1/CoraLandingPageTest.java`  
**Type:** Selenium UI Test (Empty)  
**Status:** ⚠️ Not Implemented

**Expected Purpose:** Testing for Cora landing page (based on class name)

---

## Dependency Graph

```
Mavenproject1
    ├── JSONObject (org.json)
    ├── Arrays (java.util)
    ├── [UNUSED] WebDriver (org.openqa.selenium)
    ├── [UNUSED] ChromeDriver (org.openqa.selenium.chrome)
    └── [UNUSED] Duration (java.time)

Mavenproject1Test
    ├── Mavenproject1
    ├── TestNG
    └── Java Arrays

HLTVTest
    ├── ChromeDriver
    ├── WebDriver
    ├── WebElement
    ├── By
    ├── Duration
    ├── TestNG
    └── WebDriverWait

SeleniumTest
    ├── ChromeDriver
    ├── WebDriver
    ├── WebElement
    ├── By
    ├── Duration
    ├── Actions
    ├── TestNG
    └── WebDriverWait

RestAssuredTest
    ├── RestAssured
    ├── Hamcrest Matchers
    └── TestNG

RestAssured1Test
    ├── RestAssured
    ├── Hamcrest Matchers
    └── TestNG

testingNgTest
    ├── JUnit 5
    ├── TestNG
    └── Java lang
```
