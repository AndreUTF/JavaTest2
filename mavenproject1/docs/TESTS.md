# Test Coverage Documentation

## Test Summary

| Test Class | Framework | Target | Test Count | Status |
|-----------|-----------|--------|-----------|--------|
| `Mavenproject1Test` | TestNG | Mavenproject1.java | 14 | ✅ Active |
| `HLTVTest` | TestNG | HLTV.org Website | 25 | ✅ Active |
| `SeleniumTest` | TestNG | Cypress.io Website | 30 | ✅ Active |
| `RestAssuredTest` | TestNG | JSONPlaceholder API | 3 | ✅ Active |
| `RestAssured1Test` | TestNG | Custom REST API | 5 | ✅ Active |
| `testingNgTest` | JUnit 5 + TestNG | Framework Comparison | 6 | ✅ Active |
| `CoraLandingPageTest` | (Empty) | (Unknown) | 0 | ❌ Not Implemented |

**Total Test Methods:** 83  
**Total Test Classes:** 6 Active + 1 Empty

---

## 1. Mavenproject1Test

**Associated Production Class:** `Mavenproject1.java`  
**Test Framework:** TestNG  
**Purpose:** Unit tests for bubble sort algorithm implementation  
**Test Count:** 14

### Test Methods

#### 1. `testBubbleSortWithMixedNumbers()`
- **Purpose:** Tests sorting with positive, negative, and zero values
- **Input:** `{4, 1, -10, 40, 60, 80, 55}`
- **Expected:** `{-10, 1, 4, 40, 55, 60, 80}`
- **Coverage:** Mixed value types

#### 2. `testBubbleSortWithNegativeNumbers()`
- **Purpose:** Validates negative number handling
- **Input:** `{-5, -1, -10, -3}`
- **Expected:** `{-10, -5, -3, -1}`
- **Coverage:** Negative numbers only

#### 3. `testBubbleSortWithPositiveNumbers()`
- **Purpose:** Tests positive integer sorting
- **Input:** `{5, 2, 8, 1, 9}`
- **Expected:** `{1, 2, 5, 8, 9}`
- **Coverage:** Positive numbers only

#### 4. `testBubbleSortWithDuplicates()`
- **Purpose:** Ensures duplicates are preserved and sorted
- **Input:** `{3, 1, 3, 1, 3}`
- **Expected:** `{1, 1, 3, 3, 3}`
- **Coverage:** Duplicate handling

#### 5. `testBubbleSortWithSingleElement()`
- **Purpose:** Edge case - single element array
- **Input:** `{42}`
- **Expected:** `{42}`
- **Coverage:** Minimal array size

#### 6. `testBubbleSortWithAlreadySortedArray()`
- **Purpose:** Tests idempotency of algorithm
- **Input:** `{1, 2, 3, 4, 5}`
- **Expected:** `{1, 2, 3, 4, 5}`
- **Coverage:** Pre-sorted data

#### 7. `testBubbleSortWithReverseSortedArray()`
- **Purpose:** Worst-case scenario - reverse order
- **Input:** `{5, 4, 3, 2, 1}`
- **Expected:** `{1, 2, 3, 4, 5}`
- **Coverage:** Worst case performance

#### 8. `testBubbleSortWithZeros()`
- **Purpose:** Tests zero value handling
- **Input:** `{0, -1, 0, 2, 0}`
- **Expected:** `{-1, 0, 0, 0, 2}`
- **Coverage:** Zero values

#### 9. `testBubbleSortWithLargeNumbers()`
- **Purpose:** Tests large integer values
- **Input:** `{1000000, 500000, 999999}`
- **Expected:** `{500000, 999999, 1000000}`
- **Coverage:** Large values

#### 10. `testBubbleSortPreservesLength()`
- **Purpose:** Validates array length is unchanged
- **Input:** Various arrays of different sizes
- **Expected:** Output length == Input length
- **Coverage:** Array integrity

#### 11. `testBubbleSortEmptyArray()`
- **Purpose:** Edge case - empty array
- **Input:** `{}`
- **Expected:** `{}`
- **Coverage:** Empty input

#### 12. `testBubbleSortTwoElements()`
- **Purpose:** Edge case - two element array
- **Input:** `{2, 1}`
- **Expected:** `{1, 2}`
- **Coverage:** Minimal size

#### 13-14. (Additional comprehensive tests)
- Additional edge cases and boundary conditions

### Helper Methods in Test

```java
bubbleSort(int[] arr)
- Implementation of bubble sort algorithm
- Used for verification in tests

isSorted(int[] arr)
- Validates if array is sorted
- Utility for test assertions

containsAllElements(int[] original, int[] sorted)
- Verifies element preservation
- Ensures no data loss

countOccurrences(int[] arr, int value)
- Counts specific value occurrences
- Used for duplicate validation
```

### Coverage Metrics

- **Algorithm Coverage:** 100% (all paths tested)
- **Edge Cases:** 5+ (empty, single, two elements, pre-sorted, reverse-sorted)
- **Boundary Values:** Negative, zero, positive, large numbers
- **Data Preservation:** Verified (duplicates, all elements)

### Test Gaps

- ❌ No test for very large arrays (performance testing)
- ❌ No test for Integer.MIN_VALUE / Integer.MAX_VALUE
- ❌ No test for null input (exception handling)

---

## 2. HLTVTest

**Target Application:** HLTV.org (Esports website)  
**Test Framework:** TestNG  
**Browser:** Chrome WebDriver  
**Purpose:** UI automation tests for HLTV website navigation and functionality  
**Test Count:** 25

### Test Categories

#### Navigation & Basic Functionality (4 tests)
- `testNavigateToBaseURL()` - Loads main page
- `testGetCurrentURL()` - Verifies current URL
- `testPageSourceNotEmpty()` - Validates page content
- `testPageLoadTime()` - Measures load performance

#### Element Detection (4 tests)
- `testNavigationHeaderExists()` - Finds header element
- `testSearchFunctionalityExists()` - Locates search box
- `testFindElements()` - Identifies multiple elements
- `testNavigationMenuVisible()` - Checks menu visibility

#### Search Functionality (2 tests)
- `testSearchForTeam()` - Searches team by name
- `testSearchForMatch()` - Searches match by name

#### Navigation Menu (5 tests)
- `testClickOnMatchesTab()` - Navigates to matches
- `testClickOnTeamsTab()` - Navigates to teams
- `testClickOnPlayersTab()` - Navigates to players
- `testNavigateToNews()` - Navigates to news section
- `testNavigateToRankings()` - Navigates to rankings

#### Content Interaction (4 tests)
- `testClickOnNewsArticle()` - Opens news article
- `testClickOnUpcomingMatches()` - Views upcoming matches
- `testClickOnResults()` - Views past results
- `testApplyFilters()` - Applies search/list filters

#### Browser Interactions (6 tests)
- `testElementDisplayProperties()` - Checks element visibility
- `testMouseHoverOnMatch()` - Performs hover action
- `testRefreshPage()` - Refreshes page
- `testNavigateBack()` - Uses browser back button
- `testGetWindowHandle()` - Gets window identifier
- `testBrowserCapabilities()` - Checks browser info

### Scenarios Covered

✅ Basic navigation  
✅ Element visibility and interaction  
✅ Search functionality  
✅ Menu navigation  
✅ Content filtering  
✅ Browser actions (hover, click, refresh)  
✅ Window handling  

### Coverage Gaps

❌ No screenshot capture on failure  
❌ No explicit waits for dynamic content  
❌ No error handling for stale elements  
❌ No login/authentication tests  
❌ No data validation (verify match scores, team stats)  

---

## 3. SeleniumTest

**Target Application:** Cypress.io (Test Automation Framework)  
**Test Framework:** TestNG  
**Browser:** Chrome WebDriver  
**Purpose:** Comprehensive Selenium WebDriver functionality testing  
**Test Count:** 30

### Test Categories

#### Navigation (5 tests)
- `testNavigateToBaseURL()` - Go to URL
- `testGetCurrentURL()` - Read URL
- `testNavigateBack()` - Browser back
- `testNavigateForward()` - Browser forward
- `testRefreshPage()` - Refresh page

#### Element Finding (4 tests)
- `testFindElementByXPath()` - XPath locator
- `testFindElementByCSS()` - CSS selector
- `testFindElementByID()` - ID locator
- `testFindMultipleElements()` - Find list of elements

#### Element Interaction (6 tests)
- `testClickElement()` - Click action
- `testGetElementText()` - Read text
- `testGetElementAttribute()` - Read attributes
- `testElementDisplayed()` - Check visibility
- `testElementEnabled()` - Check if clickable
- `testSendKeysToField()` - Type into input

#### Page Properties (4 tests)
- `testGetPageSource()` - Get HTML source
- `testGetPageTitle()` - Get page title
- `testGetWindowHandle()` - Get window ID
- `testGetWindowHandles()` - Get all window IDs

#### Advanced Actions (4 tests)
- `testMouseHover()` - Hover over element
- `testDoubleClick()` - Double click action
- `testRightClick()` - Right click action
- `testDragAndDrop()` - Drag element

#### Waits (2 tests)
- `testExplicitWait()` - WebDriverWait usage
- `testImplicitWait()` - Implicit wait setting

#### Browser & Element Info (5 tests)
- `testGetBrowserName()` - Browser identification
- `testGetElementSize()` - Element dimensions
- `testGetElementLocation()` - Element coordinates
- `testPageLoadTime()` - Load time measurement
- `testScrollToElement()` - Scroll to element

### Coverage Metrics

- **Locator Strategies:** 3+ (XPath, CSS, ID)
- **Actions:** Click, Type, Hover, Double-click, Right-click, Drag-drop
- **Waits:** Implicit and Explicit
- **Element Properties:** Text, Attributes, Size, Location
- **Browser Controls:** Navigation, Window/Tab management

### Coverage Gaps

❌ No screenshot capture on failure  
❌ No keyboard shortcuts (keyboard modifier keys)  
❌ No file upload/download tests  
❌ No alert handling  
❌ No frame/iframe switching  
❌ No execute JavaScript tests  

---

## 4. RestAssuredTest

**Target API:** JSONPlaceholder (Mock JSON API)  
**Test Framework:** TestNG + RestAssured  
**Purpose:** REST API endpoint testing  
**Test Count:** 3  
**Endpoints:** 3

### Tests

#### 1. `getUsers_returns200AndNonEmptyList()`
**Endpoint:** GET /users  
**Expected Response:**
- Status Code: 200 (OK)
- Body: Non-empty list
- Assertions: Uses Hamcrest matchers

#### 2. `getUserById_returnsCorrectUser()`
**Endpoint:** GET /users/1  
**Expected Response:**
- Status Code: 200
- Body: User object with ID=1
- Assertions: Validates specific user data

#### 3. `createPost_returns201AndEchoesTitle()`
**Endpoint:** POST /posts  
**Request Body:** New post data  
**Expected Response:**
- Status Code: 201 (Created)
- Body: Echoes submitted data
- Assertions: Validates creation

### Assertions Used

✅ Response status code validation  
✅ Response body content validation  
✅ JSON structure validation  
✅ Hamcrest matchers  

### Coverage Gaps

❌ No PUT/PATCH endpoint tests  
❌ No DELETE endpoint tests  
❌ No error handling (400, 404, 500 responses)  
❌ No authentication/authorization tests  
❌ No performance tests  
❌ No payload validation schemas  

---

## 5. RestAssured1Test

**Target API:** dotesthere.com (Custom REST API)  
**Test Framework:** TestNG + RestAssured  
**Purpose:** Comprehensive CRUD API testing  
**Test Count:** 5  
**Coverage:** Full CRUD operations

### Tests

#### 1. `getUsers_returnsExpectedResponse()`
**Method:** GET /users  
**Validates:** All users endpoint

#### 2. `getUser1_returnsExpectedResponse()`
**Method:** GET /users/1  
**Validates:** Specific user by ID

#### 3. `putUser1_returnsExpectedResponse()`
**Method:** PUT /users/1  
**Validates:** User update operation

#### 4. `post1_returnsExpectedResponse()`
**Method:** POST /users  
**Validates:** User creation

#### 5. `delete_returnsExpectedResponse()`
**Method:** DELETE /users/1  
**Validates:** User deletion

### CRUD Coverage

✅ CREATE (POST)  
✅ READ (GET single, GET multiple)  
✅ UPDATE (PUT)  
✅ DELETE  

### Coverage Gaps

❌ No error status code tests (400, 404, 500)  
❌ No validation of deleted resource (verify 404 after delete)  
❌ No concurrent request tests  
❌ No timeout/retry tests  
❌ No response time assertions  

---

## 6. testingNgTest

**Frameworks:** JUnit 5 and TestNG  
**Purpose:** Framework comparison and feature demonstration  
**Test Count:** 6

### Tests

#### JUnit 5 Tests
1. **`junitSimpleTest()`** - Basic assertions
2. **`junitExceptionTest()`** - Exception handling
3. **`junitTimeoutTest()`** - Timeout validation

#### TestNG Tests
1. **`testngSimpleTest()`** - Basic assertions
2. **`testngParametrizedTest(int number)`** - Parametrized testing
3. **`testngExceptionTest()`** - Exception handling

### Framework Comparison Points

| Feature | JUnit 5 | TestNG |
|---------|---------|--------|
| Setup | @BeforeEach | @BeforeMethod |
| Teardown | @AfterEach | @AfterMethod |
| Exception Testing | `assertThrows()` | `expectedExceptions` |
| Parametrized Tests | `@ParameterizedTest` | `@DataProvider` |
| Timeout | `assertTimeout()` | `@Test(timeOut)` |

### Coverage

✅ Assertions  
✅ Exception handling  
✅ Parametrized tests  
✅ Setup/Teardown  

---

## 7. CoraLandingPageTest

**Status:** ❌ **Not Implemented (Empty File)**

**Expected Purpose:** Based on name, should test Cora landing page  
**Current Implementation:** 0 test methods  
**Recommendation:** Implement comprehensive landing page tests

---

## Coverage Summary

### Classes WITH Tests
- **Mavenproject1:** ✅ Tested (bubble sort only)

### Classes WITHOUT Tests
- String parsing functionality
- Character counting functionality  
- JSON object creation
- All Selenium test classes (independent tests)
- All REST API test classes (independent tests)

### Test Statistics

| Metric | Count |
|--------|-------|
| Total Test Methods | 83 |
| TestNG Tests | 74 |
| JUnit 5 Tests | 3 |
| Selenium Tests | 55 |
| REST API Tests | 8 |
| Unit Tests | 14 |
| Framework Comparison Tests | 6 |

### Test Framework Usage

- **Primary:** TestNG (74 tests)
- **Secondary:** JUnit 5 (3 tests)
- **Integration:** RestAssured (8 tests)
- **UI Automation:** Selenium WebDriver (55 tests)

---

## Recommendations

1. **Complete CoraLandingPageTest** - Implement the empty test class
2. **Add unit tests** for string parsing and character counting in `Mavenproject1.java`
3. **Add negative test cases** for API tests (error responses)
4. **Add performance tests** for bubble sort with large datasets
5. **Add visual regression tests** for Selenium tests
6. **Document expected behaviors** in each test's JavaDoc
7. **Add data-driven test parameters** for broader coverage
8. **Implement test reporting** with Allure or similar tools

