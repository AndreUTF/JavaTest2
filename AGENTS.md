# AGENTS.md

Guidance for AI agents and contributors working in this repository. This file
applies to the entire repository tree rooted at this directory.

## Project Overview

- Java Maven project located in the `mavenproject1/` subdirectory.
- Main class: `com.mycompany.mavenproject1.Mavenproject1`.
- Java version: 17 (Temurin in CI).
- Test framework: TestNG (run via Maven Surefire).
- UI tests use Selenium with Chrome; REST tests use REST-Assured.

## Build, Run and Test Commands

All Maven commands must be run from the `mavenproject1/` directory.

- Compile: `mvn clean compile`
- Verify build (package without tests): `mvn clean package -DskipTests`
- Run the application: `mvn exec:java@run-app`
- Run all tests: `mvn test`
- Run tests headless (browser tests): `mvn test -Dheadless=true`
- Generate HTML test report: `mvn surefire-report:report-only site:site -DgenerateReports=false`

## CI Workflows (`.github/workflows/`)

- `main.yml` — builds, verifies, runs the app, runs tests, publishes reports.
- `run-tests.yml` — runs all tests and publishes visual + HTML reports.
- Workflows set `CI=true`, so browser tests automatically run in headless Chrome.
- Only workflows at the repository root `.github/workflows/` are executed by GitHub.

## Per-Commit Code Review Checklist

For every commit / pull request, verify the following before approving:

### Correctness
- [ ] Code compiles: `mvn clean compile` passes.
- [ ] Build is healthy: `mvn clean package -DskipTests` passes.
- [ ] All tests pass: `mvn test` (or document expected/known failures).
- [ ] New logic has corresponding TestNG tests.

### Quality
- [ ] Changes are minimal and focused on the commit's stated purpose.
- [ ] No commented-out dead code or leftover debug `System.out.println` calls.
- [ ] Naming, indentation and style match the surrounding code.
- [ ] No hardcoded secrets, credentials, tokens or absolute local paths.

### Dependencies & Config
- [ ] New dependencies added to `pom.xml` with a pinned version and correct scope.
- [ ] Plugin versions are pinned (no implicit/latest resolution).

### Tests & CI
- [ ] Browser tests use `ChromeOptions` and respect the `CI`/`headless` flags.
- [ ] CI workflow changes have been validated (YAML is valid, paths correct).
- [ ] Surefire report paths remain valid for the test reporting steps.

### Commit Hygiene
- [ ] Commit message clearly summarizes the change (type + short description).
- [ ] Unrelated changes are split into separate commits.
- [ ] No large binary or generated artifacts committed (e.g. `target/`).

## Notes for Agents

- Do not modify formatting unrelated to the change being made.
- Do not commit unless explicitly asked.
- Prefer editing existing files over creating new ones.
- Run the relevant build/test commands above to verify changes before finishing.
