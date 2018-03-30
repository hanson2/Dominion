# Code Inspections
## Logistics:

1. When will a formal inspection happen?
    * When a pull request is submitted.  They are submitted when a feature is
      completed.
2. Who will moderate inspections?
    * The second least associated coder.  The least will do the review itself.
3. How will results be shared?
    * They will be posted within the gitlab pull request.

## Criteria:
1. What are the code smells?

### Names
* Method names: keep them clear and unambiguous
* Methods are verbs

### Functions
* Functions do one thing
* Avoid copy pasting code - don't repeat yourself
* One abstraction level per function
* Delete unused code

### Comments
* Never use Javadoc outside of Public APIs
* Most comments can be removed by using good naming
    * Legal comments are okay.
    * Describing intent is okay.
* Don't leave commented out code.

### Formatting
* Automate when possible
* Separate blocks of code with whitespace
* Separate functions by abstraction level
* Use tabs, not spaces
* Short lines
* White space between operators
* Horizontal alignment is unnecessary
* Curly braces for one-line chunks

### Demeter
* Modules should not know about the innards of the **objects** it manipulates.
* Hide implementations of objects
* Data structures are separate from objects (don't have hybrids)
* Data structures shouldn't have getters and setters
* Trainwrecks should be avoided
    * Trainwreck:  calling nested methods on objects
* Hybrids can be worse than beans or data structures
* Data Transfer Objects don't have any functions and are like C-style structs.
  Usually have get, set, and with methods.
* Active Records are like DTO's but have methods to deal the databases
    * Easy to slip into being a hybrid - caution!

### Error Handling
* Error codes is bad practice - use exceptions instead
* It's better to use try/catch beforehand than as an afterthought
* Try not to use checked exceptions - use RuntimeExceptions instead.
    * Reason: checked exceptions must be thrown or caught all the way up the
      call chain.
* Include informative exception text
* Wrap exceptions if your going to re-throw them - it will simplify your code.
* Define exceptions based on the callers needs.
* Special cases shouldn't throw exceptions if they could instead be handled and
  returned.
* Don't return and don't pass null.  Instead, throw exceptions or find a better
  thing to return.

### Unit tests
* TDD rules:
    1. You may not write production code until a failing unit test has been
       written.
    2. You may not write more of a unit test than is sufficient to fail.
    3. You may not write more production code that it takes to pass the failing
       test.

* Tests should be as clean a functional code.
* Tests enable you to write more flexible code.
* Readability is key in tests.
* Tests do not need to be efficient.
* Try to hide implementation details from tests.
* Test one concept per tests - single assertion per test.
* F.I.R.S.T. tests:
    * Fast
    * Independent
    * Repeatable
    * Self-validating
    * Timely -> TDD

### Classes
* Fields then methods
    * Public methods first, then private methods.
* Classes should have a single responsibility (Single Responsibility Principle).
* Aim for few instance variables and methods that interact with more of these
  variables.
* Split large classes into several smaller classes.
* Smaller classes make changes easier.

* Code should run and pass all the tests.
* Refactoring is made comfortable because of tests.
    * No duplication of code.
    * Work to make code as expressive as possible.
    * Work to keep classes and methods simple -- minimize them in number.

2. Will everyone apply all criteria from every chapter from Clean Code? Or will
   each person specialize in a few criteria?
    * Everyone should try to apply everything to their code, but each person
      will inevitably have strong and weak points.  Code reviews will strengthen
      individual weak areas.

## Scope
1. Will your team inspect every file in your codebase? Every file you touch in
   your feature branch? Or something else entirely?
    * Changes will be inspected as they are going into the master branch by the
      team in a code review session.  Everyone will be able to make comments and
      critique the code for errors.  Only the code that is entering the master
      branch will be inspected.
    * Periodically, the entire repository will be inspected for sanity and
      reasonability.  This will be done the weekend after milestones are due
      before features for the next milestone are implemented.

2. Of those files, will each person look at every file in consideration? Or will
   your team assign different files to different people?
    * Files will be split among the team.  They will be divided based on the
      various review strengths of each member of the team.

## Tools:
1. To what extent can your inspection criteria be automated? Automation will
   increase your inspection's speed and reliability.
    * Formatting can be automated, and linters can be run to help check the
      code.  However, much of the actual review process will require team
      intervention.

2. Which aspects of your inspection criteria will need human intervention?
    * Method naming, the SRP, dead function spotting, hiding method
      implementation, etc., will all require human interaction and intervention.
