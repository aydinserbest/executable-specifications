###
As we have seen, the built-in assertions provided out of the box for Jupiter are sufficient for many testing scenarios. 
Nevertheless, there are times when more additional functionality, such as matchers, 
can be desired or required. 
In such situations, the JUnit team recommends the use of the following third-party assertion libraries:
-Hamcrest
-AssertJ
-Truth

////

###
Those tags can later be used to filter test discovery and execution.

we need to use maven-surefire-plugin in a Maven project to execute Jupiter test. 
Moreover, this plugin allows us to filter the test execution in several ways: 
-filtering by JUnit 5 tags and also 
-using the regular inclusion/exclusion support of maven-surefire-plugin.

1-
we use the configuration keywords includeTags and excludeTags in the Maven pom.xml file. 
In this example, we include the test with the tag functional and non-functional:     

    <build>
        <plugins>
        <plugin>
        <artifactId>maven-surefire-plugin</artifactId>
        <version>${maven-surefire-plugin.version}</version>
             <configuration>
                <properties>
                    <includeTags>functional</includeTags>
                    <excludeTags>non-functional</excludeTags>
                </properties>
             </configuration>
        <dependencies>
        <dependency>
        <groupId>org.junit.platform</groupId>
        <artifactId>junit-platform-surefire-provider</artifactId>
        <version>${junit.platform.version}</version>
        </dependency>
        <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>${junit.jupiter.version}</version>
        </dependency>
        </dependencies>
        </plugin>
        </plugins>
        </build>

As a result, when we try to execute all the tests within the project, 
only two will be executed (those with the tag functional), and the rest are not recognized as tests

2-
Maven regular support The regular inclusion/exclusion support of the Maven plugin can still be used 
to select which tests are going to be executed by maven-surefire-plugin. 
To that aim, we use the keywords includes and excludes to configure the test name pattern used to filter the execution 
by the plugin. 
Notice that for both inclusions and exclusions, regular expressions can be used to specify a pattern of the test filenames: 

    <configuration>
        
    <includes>
        <include>**/Test*.java</include>
        <include>**/*Test.java</include>
        <include>**/*TestCase.java</include>
        </includes>
        </configuration>
        <configuration>
        <excludes>
        <exclude>**/TestCircle.java</exclude>
        <exclude>**/TestSquare.java</exclude>
        </excludes>
        </configuration> 

These three patterns, that is, the Java files containing the word Test or ending with TestCase, 
are included by default by maven-surefire plugin.



