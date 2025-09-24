# **The Third Programmer**

An experiment in trio programming to find the best collaborative workflows for two engineers and one AI assistant.

## **The Experiment**

This repository chronicles our experiment in AI-augmented software development. Traditional **Pair Programming** has proven to be a powerful technique for delivering high-quality software. With the rise of capable AI code assistants, we are exploring how to evolve this practice into **Trio Programming**.

Our goal is to discover and document the most effective patterns, protocols, and best practices for a team of two human engineers collaborating with an AI agent as a third, active programmer.

### **Core Questions**

- How does the dynamic of pairing change with an AI in the mix?
- What are the most effective roles for the AI (e.g., driver, navigator, observer, refactoring engine)?
- How can we best leverage custom instructions to make the AI a more intelligent and context-aware partner?
- What new collaborative patterns emerge from this trio?

### **Foundational Concepts**

- **Pair Programming:** Our starting point and theoretical baseline, guided by the principles outlined in Martin Fowler's article, "[On Pair Programming](https://martinfowler.com/articles/on-pair-programming.html)".
- **Code Katas:** We will use short, focused programming exercises from sources like [CodeKata.com](http://codekata.com/) to provide a consistent framework for our sessions.

## **The Team**

This experiment is being conducted by:

- **Nik Malykhin:** [nikmalykhin.com](https://www.nikmalykhin.com/about)
- **Javier Lopez:** [Thoughtworks Profile](https://www.thoughtworks.com/en-es/profiles/j/javier-lopez-fernandez)
- **The Third Programmer:** GitHub Copilot

## **Environment & Technology Stack**

Our development and experimental environment consists of:

- **Language:** Core Java
- **Testing Framework:** JUnit 5
- **Build Automation:** Gradle
- **Editor:** Visual Studio Code
- **AI Assistant:** GitHub Copilot, enhanced with [**custom instructions**](https://www.nikmalykhin.com/p/can-we-make-ai-code-assistants-smarter) to provide more targeted and context-aware contributions.

## **Getting Started**

### **Prerequisites**

- Java 21 (LTS)
- Git

### **Setup**

```bash
git clone https://github.com/nikmalykhin-tw/the-third-programmer.git
cd the-third-programmer
./gradlew test  # Verify setup
```

### **Creating a New Kata**

Use the helper script to quickly scaffold a new kata:

```bash
./kata.sh fizz-buzz
# Creates kata-fizz-buzz/ with:
# - Standard Java package structure
# - README template with session notes
# - Automatically updates settings.gradle
```

### **Development Workflow**

```bash
# Run tests for a specific kata
./gradlew kata-one:test

# Run all tests
./gradlew test

# Continuous testing (TDD workflow)
./gradlew kata-one:test --continuous
```

## **Repository Structure**

This repository is organized by individual katas, each in its own directory:

```
kata-name/
├── src/
│   ├── main/java/com/thoughtworks/thethirdprogrammer/[kata]/
│   └── test/java/com/thoughtworks/thethirdprogrammer/[kata]/
└── README.md  # Session notes and trio programming observations
```

We document our findings as we progress, building a practical guide for trio programming patterns.

## **License**

This project and its findings are open-source and available under the [**MIT License**](https://www.google.com/search?q=LICENSE).
