import org.junit.*  // Import statement for using the following annotations.

@Test               // Identifies a method as a test method.

@Before             // Executed before each test. It is used to prepare the test environment (e.g., read input data, initialize the class).

@After              // Executed after each test. It is used to cleanup the test environment (e.g., delete temporary data, restore defaults). It can also save
                    // memory by cleaning up expensive memory structures.

@BeforeClass        // Executed once, before the start of all tests. It is used to perform time intensive activities, for example, to connect to a database.
                    // Methods marked with this annotation need to be defined as static to work with JUnit.

@AfterClass         // Executed once, after all tests have been finished. It is used to perform clean-up activities, for example, to disconnect from a
                    // database. Methods annotated with this annotation need to be defined as static to work with JUnit.
                
@Ignore or 
@Ignore("Why disabled")     // Marks that the test should be disabled. This is useful when the underlying code has been changed and the test case has not yet
                            // been adapted. Or if the execution time of this test is too long to be included. It is best practice to provide the optional description, why the test is disabled.

@Test 
(expected = Exception.class)    // Fails if the method does not throw the named exception.

@Test (timeout=100)   // Fails if the method takes longer than 100 milliseconds.