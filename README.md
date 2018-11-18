## Project Title : Assignment

Instructions:
1. Navigate to "www.amazon.com"
2. Go into "Best sellers in Digital Cameras"
3. Open details of 5-th product
4. Add 8 pieces to the shopping cart (don't accept any other options that are proposed by the e-shop)
5. Check that correct product was added
6. Check that subtotal price sum is correct

## Getting Started

1. Copy the project related files and create a new project in any of the IDE
2. Check if there are any errors and resolve them accordingly i.e., Add the Libraries properly into the project and make sure that all the classes are imported with the required API's 

## Prerequisites

1. Install Selenium standalone server 
2. Set the system property by downloading the gecko. This project is targetted for Firefox browser
3. Properties jars (If login functionality is required then fetching the attribute values from the properties file)


## Deployment and Execution:

1. This project has mainly 4 packages:
    a. com.amazon.AddToCart: Have a class and respective methods which fetches the list of Best Sellers in digital cameras and selects the 5th product specifically and adds 8 pieces of that product to the cart.
    b. com.amazon.FunctionalLibraries: Have general functions deals with login, reading property files, and Logout functionalities.
    c. com.amazon.login: Have initialization of the driver, object creation and execution of the methods in an order.
    d. com.amazon.ObjectRepository: This contains an interface which has details about the static and dynamic locators
    e. com.amazon.Payment: Not implemented yet as it is not there in the requirement.
    f. com.amazon.resources: contains files like excel or property files
2. testng.xml is from where we run the project as TestNG suite
3. test-output contains the results of the project

## Results:

When we run the TestNG suite from the project it will execute the all the required steps which are suggested in "Instructions" and will fetch the sum of the products quantity which has been added to the cart.

* [Hybrid Framework] - The Hybrid framework used
* [TestNG] - Run as a testNG suite

## To Be Done:

1. Need to execute the same with respect to BDD framework
2. Define the functions and calling the test cases in a proper way
3. Output of the project is proper but while closing the session getting errors
4. Integrate Maven for dependency management
## License & Copyright
Kiran Avs


