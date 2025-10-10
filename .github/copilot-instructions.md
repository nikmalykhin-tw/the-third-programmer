# The Third Programmer – AI Coding Agent Instructions

## Project Overview

**The Third Programmer** is an experimental repository exploring trio programming: two human engineers collaborating with GitHub Copilot as an active third programmer. The goal is to discover effective patterns and workflows for AI-augmented software development.

- **Core Language:** Java (Core Java, not frameworks)
- **Build Tool:** Gradle
- **Testing:** JUnit 5
- **Editor:** VS Code with GitHub Copilot
- **Methodology:** Trio programming using Code Katas from [CodeKata.com](http://codekata.com/)

## Trio Programming Protocol

**BEFORE any code implementation or changes:**

1. **Ask for permission** – Present your short plan and get approval
2. **Show your approach** – Explain what you intend to implement in 2-3 sentences
3. **Wait for confirmation** – Don't proceed until the human partners agree

**Code Implementation Rules:**

- **Small increments:** Add no more than 20-30 lines of code per change
- **Tiny steps:** Make the smallest possible change that moves toward the goal
- **TDD cycle:** Always follow Red → Green → (Optional) Refactor
  - Red: Write a failing test first
  - Green: Write minimal code to make it pass
  - Refactor: Clean up only if needed, keeping tests green

**Refactoring Protocol:**

- Only refactor after all tests pass and with explicit approval.
- Refactoring must not change test behavior or break existing tests.
- All refactoring steps must be explained and approved before implementation.

**Design Patterns & Encapsulation:**

- Prefer using design patterns (e.g., Composite) for hierarchical or tree-like data, but justify and get approval before introducing them.
- For dynamic JSON keys, use a `Map` or a class that serializes as a `Map` (e.g., with `@JsonValue`), even with frameworks like Spring Boot.
- Encapsulate collections (like `Map`) in domain objects to improve type safety and maintainability.

**Test Change Restrictions:**

- Do not change existing tests unless explicitly requested. New requirements must be covered by new tests.

**Version Control Rules:**

- Never commit automatically: Only commit when explicitly asked by the human partners.
- Wait for commit commands: Do not suggest or perform commits unless directly requested.
- Use Conventional Commits for all commit messages, including a summary of what changed and why in the commit body.
- After each development cycle, summarize what was learned and propose rule improvements.

**Session Retrospective:**

- After each development cycle, summarize the process, what was learned, and propose improvements to these instructions.

---

## Spring Boot & Framework Katas

When using Spring Boot or similar frameworks in a kata:

- **Minimal setup:** Only add the minimum required dependencies (e.g., `spring-boot-starter-web`, `spring-boot-starter-test`) in the kata's `build.gradle` or the `subprojects` block of the root build.
- **Application class:** Always include a minimal `@SpringBootApplication` class (e.g., `HelloWorldApplication`) in the main package to satisfy Spring context requirements for tests.
- **Test placement:** Place all Spring Boot tests in the same package (or a subpackage) as the application class to ensure component scanning works.
- **Test context:** Use `@WebMvcTest` for controller tests, and ensure the controller and test are in the correct package.
- **Dependency troubleshooting:** If you see errors about missing Spring/JUnit classes, check that dependencies are in the correct `build.gradle` and use the `${springBootVersion}` property if defined.
- **Classpath troubleshooting:** Test files must be in `src/test/java`, not `src/main/java`, to access test dependencies.
- **Package troubleshooting:** If you see `Unable to find a @SpringBootConfiguration`, move your test to the same package as your application class.

---

## Repository Structure & Patterns

- **Kata-Based Organization:** Each programming exercise lives in its own directory (`kata-name/`)
- **Standard Kata Structure:**
  - `kata-name/src/` - Source code for the exercise
  - `kata-name/README.md` - Session notes, observations, and reflections on the trio programming process
  - `kata-name/build.gradle` - Gradle build configuration (when present)

## Development Workflow

- **Build & Test:** `./gradlew test` (from kata directory)
- **Session Documentation:** Each kata session should be documented in its README.md with:
  - Process observations
  - AI collaboration patterns discovered
  - Code quality reflections
  - Lessons learned about trio programming dynamics

---

## Troubleshooting & Best Practices

- **Missing dependencies:** Ensure all required dependencies are present in the correct `build.gradle` (root or kata-specific). Use version properties for consistency.
- **Test context errors:** Always provide a minimal `@SpringBootApplication` class and keep test files in the correct package and source set.
- **Classpath issues:** Place test files in `src/test/java`, not `src/main/java`.
- **Spring context errors:** If you see `Unable to find a @SpringBootConfiguration`, check your package structure and test location.
- **Commit protocol:** Only commit or amend when explicitly instructed. Use amend for adding files to the last commit.

---

## Code Quality Standards

- **Clean Code Principles:** Follow "The Boy Scout Rule" - leave code cleaner than found
- **TDD Approach:** Red-Green-Refactor cycle, especially suitable for kata exercises
- **Intentional Naming:** Classes as nouns, methods as verbs, reveal intent clearly
- **Small Functions:** Each function should do one thing well
- **No Dead Code:** Remove commented-out code; code should be self-documenting

## AI Collaboration Context

- **Experimental Focus:** This is research into AI-human collaboration patterns
- **Role Flexibility:** AI can serve as driver, navigator, or observer depending on the session
- **Documentation Emphasis:** Record not just what was built, but how the trio dynamic affected the process
- **Custom Instructions:** Leverage project-specific context to make AI contributions more targeted

## Current Status

Repository is in early experimental phase. When working on katas:

1. Create new kata directory following naming convention
2. Set up standard Java/Gradle structure in `src/`
3. Document the trio programming experience in kata README.md
4. Focus on discovering effective AI collaboration patterns

---

**Refer to main README.md for experiment background and team information.**

---
