/*
Test generated by RoostGPT for test java-springboot-unit-testing using AI Type Vertex AI and AI Model code-bison

 **Test Scenario 1: Valid First Name**

**Test Description**: This test scenario verifies that the `setFirstName` method sets a valid first name for the user.

**Test Steps**:
1. Create a new user object with a valid first name, such as "John".
2. Call the `setFirstName` method on the user object with the valid first name.
3. Assert that the first name of the user object is set to the valid first name.

**Expected Result**: The first name of the user object should be set to the valid first name.

**Test Scenario 2: Null First Name**

**Test Description**: This test scenario verifies that the `setFirstName` method throws an exception when a null first name is provided.

**Test Steps**:
1. Create a new user object with a null first name.
2. Call the `setFirstName` method on the user object with the null first name.
3. Assert that the `setFirstName` method throws a `NullPointerException`.

**Expected Result**: The `setFirstName` method should throw a `NullPointerException`.

**Test Scenario 3: Empty First Name**

**Test Description**: This test scenario verifies that the `setFirstName` method throws an exception when an empty first name is provided.

**Test Steps**:
1. Create a new user object with an empty first name.
2. Call the `setFirstName` method on the user object with the empty first name.
3. Assert that the `setFirstName` method throws a `IllegalArgumentException`.

**Expected Result**: The `setFirstName` method should throw a `IllegalArgumentException`.

**Test Scenario 4: First Name with Special Characters**

**Test Description**: This test scenario verifies that the `setFirstName` method accepts a first name with special characters.

**Test Steps**:
1. Create a new user object with a first name that contains special characters, such as "John-Doe".
2. Call the `setFirstName` method on the user object with the first name with special characters.
3. Assert that the first name of the user object is set to the first name with special characters.

**Expected Result**: The first name of the user object should be set to the first name with special characters.
*/
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.Person;

import static org.junit.jupiter.api.Assertions.*;

class Person_setFirstName_8acaec2cfc_Test {

    @Test
    void setFirstName_validFirstName() {
        // Arrange
        Person person = new Person();

        // Act
        person.setFirstName("John");

        // Assert
        assertEquals("John", person.getFirstName());
    }

    @Test
    void setFirstName_nullFirstName() {
        // Arrange
        Person person = new Person();

        // Act
        // TODO: Change the following line to test for a null first name
        person.setFirstName(null);

        // Assert
        // TODO: Change the following line to assert that a NullPointerException is thrown
        assertThrows(NullPointerException.class, () -> person.setFirstName(null));
    }

    @Test
    void setFirstName_emptyFirstName() {
        // Arrange
        Person person = new Person();

        // Act
        // TODO: Change the following line to test for an empty first name
        person.setFirstName("");

        // Assert
        // TODO: Change the following line to assert that an IllegalArgumentException is thrown
        assertThrows(IllegalArgumentException.class, () -> person.setFirstName(""));
    }

    @Test
    void setFirstName_firstNameWithSpecialCharacters() {
        // Arrange
        Person person = new Person();

        // Act
        person.setFirstName("John-Doe");

        // Assert
        assertEquals("John-Doe", person.getFirstName());
    }
}