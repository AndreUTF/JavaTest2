# Java Project Documentation Generation Guide

## Goal
Read and analyze all existing Java classes and test files in the project, then produce comprehensive project documentation.

## Objectives

1. Identify all Java source files in the project.
2. Identify all test files (JUnit, TestNG, integration tests, and other testing frameworks).
3. Analyze class responsibilities, relationships, and dependencies.
4. Review test coverage and determine what functionality each test validates.
5. Generate clear and structured documentation for developers and stakeholders.

## Documentation Requirements

### Project Overview
- Purpose of the project
- Main modules and packages
- High-level architecture

### Class Documentation
For each class:
- Package name
- Class name
- Purpose and responsibilities
- Public methods and their descriptions
- Important fields and properties
- Dependencies on other classes
- Design patterns used (if any)

### Test Documentation
For each test class:
- Test class name
- Associated production class(es)
- Test purpose
- Main scenarios covered
- Edge cases covered
- Missing or potential gaps in coverage

### Package Documentation
For each package:
- Package purpose
- Key classes
- Relationships with other packages

### Architecture Documentation
- Component interactions
- Data flow
- Dependency graph
- External integrations

### Coverage Summary
- Classes with tests
- Classes without tests
- Estimated coverage observations
- Recommendations for additional testing

## Expected Output
Generate a markdown documentation set containing:

- Project overview
- Package summaries
- Class reference documentation
- Test coverage documentation
- Architecture notes
- Recommendations and findings

## Documentation Style
- Use clear markdown headings
- Include code examples when useful
- Link related classes and tests
- Keep descriptions concise but informative
- Highlight assumptions and potential issues
