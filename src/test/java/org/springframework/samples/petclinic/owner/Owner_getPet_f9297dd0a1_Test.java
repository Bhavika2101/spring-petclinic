/*
Test generated by RoostGPT for test java-springboot-unit-testing using AI Type Open AI and AI Model gpt-4-1106-preview

Here are some test scenarios to validate the business logic of the `getPet` method:

1. **Positive Test Scenarios:**
   - **Scenario 1: Existing Pet ID**
     - Given a list of pets associated with a person, when `getPet` is called with an ID that exists within that list and the pet is not marked as new, then the method should return the corresponding `Pet` object.
   - **Scenario 2: First Pet in List**
     - Given a list of pets associated with a person, when `getPet` is called with the ID of the first pet in the list and the pet is not marked as new, then the method should return the first `Pet` object.

2. **Negative Test Scenarios:**
   - **Scenario 3: Non-existing Pet ID**
     - Given a list of pets associated with a person, when `getPet` is called with an ID that does not exist within that list, then the method should return `null`.
   - **Scenario 4: New Pet ID**
     - Given a list of pets associated with a person, when `getPet` is called with an ID of a pet that is marked as new, then the method should return `null` even if the ID matches.
   - **Scenario 5: Null ID**
     - Given a list of pets associated with a person, when `getPet` is called with a `null` ID, then the method should handle the `null` appropriately, potentially returning `null` or throwing an IllegalArgumentException.
   - **Scenario 6: Invalid ID Type**
     - Given a list of pets associated with a person, when `getPet` is called with an invalid ID type (e.g., a `String` instead of an `Integer`), then the method should throw a type mismatch exception or similar error if not properly handled.

3. **Boundary Test Scenarios:**
   - **Scenario 7: Empty Pets List**
     - Given a person with an empty list of pets, when `getPet` is called with any ID, then the method should return `null` because there are no pets to search through.
   - **Scenario 8: Large Number of Pets**
     - Given a person with a large number of pets, when `getPet` is called with a valid ID, then the method should return the corresponding `Pet` object without any performance issues or errors.

4. **Data Integrity and Consistency Scenarios:**
   - **Scenario 9: Duplicate Pet IDs**
     - Given a list of pets associated with a person that has duplicate pet IDs (which should not happen in a well-designed system), when `getPet` is called with the duplicated ID, then the method should return the first matching `Pet` object found.
   - **Scenario 10: Pets List with Nulls**
     - Given a list of pets associated with a person that contains `null` elements, when `getPet` is called with a valid ID, then the method should skip the `null` elements and return the correct `Pet` object if it exists.

5. **Concurrency Scenarios:**
   - **Scenario 11: Concurrent Modification**
     - Given a list of pets associated with a person, when `getPet` is called while the list is being modified concurrently, then the method should handle the concurrent modification appropriately, either by returning a consistent result or by throwing a concurrent modification exception.

These scenarios cover a range of possibilities and will help ensure that the `getPet` method is robust, handles edge cases, and adheres to the expected business logic.
*/
package org.springframework.samples.petclinic.owner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Collection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.samples.petclinic.model.Person;

class Owner_getPet_f9297dd0a1_Test {

    private Owner owner;
    private Pet pet1, pet2;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        pet1 = new Pet();
        pet1.setId(1);
        pet1.setName("Buddy");
        pet1.setBirthDate(LocalDate.of(2020, 1, 1));
        pet2 = new Pet();
        pet2.setId(2);
        pet2.setName("Charlie");
        pet2.setBirthDate(LocalDate.of(2019, 1, 1));
        owner.addPet(pet1);
        owner.addPet(pet2);
    }

    @Test
    void testGetPet_withExistingId() {
        Pet foundPet = owner.getPet(1);
        assertNotNull(foundPet);
        assertEquals(pet1.getName(), foundPet.getName());
    }

    @Test
    void testGetPet_withFirstPetInList() {
        Pet foundPet = owner.getPet(1);
        assertNotNull(foundPet);
        assertEquals(pet1, foundPet);
    }

    @Test
    void testGetPet_withNonExistingId() {
        Pet foundPet = owner.getPet(3);
        assertNull(foundPet);
    }

    @Test
    void testGetPet_withNewPetId() {
        Pet newPet = new Pet();
        newPet.setId(3);
        newPet.setName("Daisy");
        newPet.setBirthDate(LocalDate.of(2021, 1, 1));
        // TODO: Mark newPet as new
        owner.addPet(newPet);
        Pet foundPet = owner.getPet(3);
        assertNull(foundPet);
    }

    @Test
    void testGetPet_withNullId() {
        Exception exception = assertThrows(NullPointerException.class, () -> {
            owner.getPet(null);
        });
        String expectedMessage = "Cannot invoke \"Integer.equals(Object)\" because \"compId\" is null";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void testGetPet_withEmptyPetsList() {
        Owner emptyOwner = new Owner();
        Pet foundPet = emptyOwner.getPet(1);
        assertNull(foundPet);
    }

    @Test
    void testGetPet_withLargeNumberOfPets() {
        // Setup owner with a large number of pets
        for (int i = 3; i <= 100; i++) {
            Pet newPet = new Pet();
            newPet.setId(i);
            newPet.setName("Pet" + i);
            newPet.setBirthDate(LocalDate.of(2021, 1, i % 30 + 1));
            owner.addPet(newPet);
        }
        Pet foundPet = owner.getPet(50);
        assertNotNull(foundPet);
        assertEquals("Pet50", foundPet.getName());
    }

    @Test
    void testGetPet_withDuplicatePetIds() {
        Pet duplicatePet = new Pet();
        duplicatePet.setId(1); // Same ID as pet1
        duplicatePet.setName("BuddyDuplicate");
        duplicatePet.setBirthDate(LocalDate.of(2021, 2, 1));
        owner.addPet(duplicatePet);
        Pet foundPet = owner.getPet(1);
        assertNotNull(foundPet);
        assertEquals("Buddy", foundPet.getName());
    }

    @Test
    void testGetPet_withPetsListContainingNulls() {
        owner.getPets().add(null); // Add a null to the list of pets
        Pet foundPet = owner.getPet(2);
        assertNotNull(foundPet);
        assertEquals(pet2.getName(), foundPet.getName());
    }

    // Note: Concurrency scenario tests would typically require a more complex setup
    // and are not included in this example due to the complexity.
}
