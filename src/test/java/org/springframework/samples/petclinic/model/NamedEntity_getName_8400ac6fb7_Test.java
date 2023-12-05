/*
Test generated by RoostGPT for test java-springboot-unit-testing using AI Type Open AI and AI Model gpt-4

1. Scenario: Check if the function returns the correct name
   - Given that a name is set for the object
   - When the getName() function is called
   - Then it should return the correct name

2. Scenario: Check if the function returns null when no name is set
   - Given that no name is set for the object
   - When the getName() function is called
   - Then it should return null

3. Scenario: Check if the function returns the correct name after the name has been changed
   - Given that a name is set for the object and then changed
   - When the getName() function is called
   - Then it should return the new name

4. Scenario: Check if the function returns the correct name when the name contains special characters
   - Given that a name containing special characters is set for the object
   - When the getName() function is called
   - Then it should return the correct name

5. Scenario: Check if the function returns the correct name when the name contains spaces
   - Given that a name containing spaces is set for the object
   - When the getName() function is called
   - Then it should return the correct name

6. Scenario: Check if the function returns the correct name when the name is a number
   - Given that a name is a number is set for the object
   - When the getName() function is called
   - Then it should return the correct name

7. Scenario: Check if the function returns the correct name when the name is a long string
   - Given that a very long string is set as the name for the object
   - When the getName() function is called
   - Then it should return the correct name

8. Scenario: Check if the function returns the correct name when the name is a single character
   - Given that a single character is set as the name for the object
   - When the getName() function is called
   - Then it should return the correct name

9. Scenario: Check if the function returns the correct name when the name is an empty string
   - Given that an empty string is set as the name for the object
   - When the getName() function is called
   - Then it should return an empty string

10. Scenario: Check if the function returns the correct name when the name is a string with leading or trailing spaces
    - Given that a string with leading or trailing spaces is set as the name for the object
    - When the getName() function is called
    - Then it should return the string with the leading or trailing spaces.
*/
package org.springframework.samples.petclinic.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class NamedEntity_getName_8400ac6fb7_Test {

    private NamedEntity namedEntity;

    @Before
    public void setUp() {
        namedEntity = new NamedEntity();
    }

    @Test
    public void testGetName_WhenNameIsSet() {
        namedEntity.setName("John Doe");
        assertEquals("John Doe", namedEntity.getName());
    }

    @Test
    public void testGetName_WhenNoNameIsSet() {
        assertNull(namedEntity.getName());
    }

    @Test
    public void testGetName_AfterNameChange() {
        namedEntity.setName("John Doe");
        namedEntity.setName("Jane Doe");
        assertEquals("Jane Doe", namedEntity.getName());
    }

    @Test
    public void testGetName_WhenNameContainsSpecialCharacters() {
        namedEntity.setName("@John#Doe!");
        assertEquals("@John#Doe!", namedEntity.getName());
    }

    @Test
    public void testGetName_WhenNameContainsSpaces() {
        namedEntity.setName("John  Doe");
        assertEquals("John  Doe", namedEntity.getName());
    }

    @Test
    public void testGetName_WhenNameIsNumber() {
        namedEntity.setName("12345");
        assertEquals("12345", namedEntity.getName());
    }

    @Test
    public void testGetName_WhenNameIsLongString() {
        String longName = new String(new char[1000]).replace("\0", "a");
        namedEntity.setName(longName);
        assertEquals(longName, namedEntity.getName());
    }

    @Test
    public void testGetName_WhenNameIsSingleCharacter() {
        namedEntity.setName("Z");
        assertEquals("Z", namedEntity.getName());
    }

    @Test
    public void testGetName_WhenNameIsEmptyString() {
        namedEntity.setName("");
        assertEquals("", namedEntity.getName());
    }

    @Test
    public void testGetName_WhenNameIsStringWithLeadingOrTrailingSpaces() {
        namedEntity.setName(" John Doe ");
        assertEquals(" John Doe ", namedEntity.getName());
    }
}
