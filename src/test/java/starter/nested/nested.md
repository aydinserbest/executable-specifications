The @Nested annotation lets you group related test cases into hierarchical structures, 
promoting a cleaner arrangement and mirroring how you might structure your production code. 
1. Why Use Nested Tests? 

●Readability: Nested classes visually demarcate scenarios within a broader testing context. 
This makes large test suites easier to understand. 
●Organization: Group tests sharing common setup logic, state, or focusing on a specific aspect of a class. 
●Focus: Helps keep each test class smaller and more focused, aligning with the single-responsibility principle. 
●Better Naming: Descriptive names of nested classes enhance test reports.

Nested tests give the test writer more capabilities to express the relationship and order in a group of tests. 
JUnit 5 makes it effortless to nest test classes. 
We simply need to annotate inner classes with @Nested and all test methods in there will be executed as well, 
going from the regular tests (defined in the top-level class) to the tests defined in each of the inner classes. 
The first thing we need to take into account is that 
only non-static nested classes (that is inner classes) can serve as @Nested tests.

