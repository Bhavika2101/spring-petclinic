/*
Test generated by RoostGPT for test java-springboot-unit-testing using AI Type Vertex AI and AI Model code-bison

 **Test Scenario 1: Valid Name**
* **Test Objective:** To verify that the `setName` method sets a valid name for the entity.
* **Test Steps:**
  1. Create a new entity with a valid name.
  2. Call the `setName` method on the entity with a valid name.
  3. Assert that the name of the entity is set to the expected value.

**Test Scenario 2: Null Name**
* **Test Objective:** To verify that the `setName` method throws a `NullPointerException` when a null name is passed.
* **Test Steps:**
  1. Create a new entity with a null name.
  2. Call the `setName` method on the entity with a null name.
  3. Assert that a `NullPointerException` is thrown.

**Test Scenario 3: Empty Name**
* **Test Objective:** To verify that the `setName` method throws an `IllegalArgumentException` when an empty name is passed.
* **Test Steps:**
  1. Create a new entity with an empty name.
  2. Call the `setName` method on the entity with an empty name.
  3. Assert that an `IllegalArgumentException` is thrown.

**Test Scenario 4: Name Too Long**
* **Test Objective:** To verify that the `setName` method throws an `IllegalArgumentException` when a name that is too long is passed.
* **Test Steps:**
  1. Create a new entity with a name that is too long.
  2. Call the `setName` method on the entity with a name that is too long.
  3. Assert that an `IllegalArgumentException` is thrown.

**Test Scenario 5: Name with Special Characters**
* **Test Objective:** To verify that the `setName` method sets a valid name for the entity when a name with special characters is passed.
* **Test Steps:**
  1. Create a new entity with a name that contains special characters.
  2. Call the `setName` method on the entity with a name that contains special characters.
  3. Assert that the name of the entity is set to the expected value.
*/
import org.junit.jupiter.api.Test;
import org.springframework.samples.petclinic.model.NamedEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NamedEntity_setName_5d23a892d9_Test {

    @Test
    void testValidName() {
        NamedEntity entity = new NamedEntity();
        entity.setName("Fluffy");
        assertThat(entity.getName()).isEqualTo("Fluffy");
    }

    @Test
    void testNullName() {
        NamedEntity entity = new NamedEntity();
        assertThrows(NullPointerException.class, () -> entity.setName(null));
    }

    @Test
    void testEmptyName() {
        NamedEntity entity = new NamedEntity();
        assertThrows(IllegalArgumentException.class, () -> entity.setName(""));
    }

    @Test
    void testNameTooLong() {
        NamedEntity entity = new NamedEntity();
        assertThrows(IllegalArgumentException.class, () -> entity.setName("This name is too long"));
    }

    @Test
    void testNameWithSpecialCharacters() {
        NamedEntity entity = new NamedEntity();
        entity.setName("Fluffy#1");
        assertThat(entity.getName()).isEqualTo("Fluffy#1");
    }
}