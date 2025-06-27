# Sample Test Suite Demonstration

This repository was created in an effort to demonstrate my CS classmates the importance of test suites in software development by simulating a possible behavior of methods before and after refactoring. That is inducing an artificial bug into the post refractor method, and watching the JTestSuite discover it.

## Project Overview

The project contains two methods in the `MathUtils` class:

1. **Pre-refactor Method**: Represents the original implementation.
2. **Post-refactor Method**: Represents the refactored implementation, which intentionally includes a simulated error.

The tests are designed to validate the correctness of these methods. Reflection is used to dynamically select whether the pre-refactor or post-refactor method is being tested.

