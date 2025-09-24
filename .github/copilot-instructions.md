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

1. **Ask for permission** - Present your short plan and get approval
2. **Show your approach** - Explain what you intend to implement in 2-3 sentences
3. **Wait for confirmation** - Don't proceed until the human partners agree

**Code Implementation Rules:**

- **Small increments:** Add no more than 20-30 lines of code per change
- **Tiny steps:** Make the smallest possible change that moves toward the goal
- **TDD cycle:** Always follow Red → Green → (Optional) Refactor
  - Red: Write a failing test first
  - Green: Write minimal code to make it pass
  - Refactor: Clean up only if needed, keeping tests green

**Version Control Rules:**

- **Never commit automatically:** Only commit when explicitly asked by the human partners
- **Wait for commit commands:** Do not suggest or perform commits unless directly requested

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
