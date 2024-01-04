/*
Test generated by RoostGPT for test pom-test using AI Type Open AI and AI Model gpt-4

1. **Happy Path Scenario**: Validate the function with a valid ownerId that exists in the database. The function should return the correct owner object without any error.

2. **Owner Not Found Scenario**: Pass an ownerId that does not exist in the database. The function should throw an IllegalArgumentException with the message "Owner ID not found: " + ownerId.

3. **Negative OwnerId Scenario**: Pass a negative ownerId. Depending on business logic, this could either throw an IllegalArgumentException or return null.

4. **Zero OwnerId Scenario**: Pass zero as ownerId. Depending on business logic, this could either throw an IllegalArgumentException or return null.

5. **Owner Id as Null Scenario**: Pass null as ownerId. It should throw a NullPointerException or IllegalArgumentException depending upon how the method handles this.

6. **Large OwnerId Scenario**: Pass a very large ownerId that could potentially exist in the database. The function should either return the correct owner object or throw an IllegalArgumentException if such an id does not exist.

7. **Boundary Scenario**: If there's a limit on the ownerId in the database, test with ownerId values just below, at, and just above the limit. The function should behave correctly according to the defined business rules for these cases.

8. **Concurrent Access Scenario**: Call the function concurrently from multiple threads with the same valid ownerId. The function should return the correct owner object without any race conditions or inconsistencies.

9. **Data Integrity Scenario**: After retrieving the Owner object, verify that all the data fields of the returned object match with the database records for the given ownerId.

10. **Database Connection Failure Scenario**: Simulate a database connection failure and call the function. The function should handle the failure gracefully and not cause the application to crash.
*/
package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PetController_findOwner_0895b41fd2_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private PetController petController;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findOwner_HappyPath() {
        Owner testOwner = new Owner();
        Mockito.when(owners.findById(1)).thenReturn(testOwner);

        Owner result = petController.findOwner(1);

        assertEquals(testOwner, result);
        Mockito.verify(owners, Mockito.times(1)).findById(1);
    }

    @Test
    void findOwner_OwnerNotFound() {
        Mockito.when(owners.findById(1)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            petController.findOwner(1);
        });

        String expectedMessage = "Owner ID not found: 1";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        Mockito.verify(owners, Mockito.times(1)).findById(1);
    }

    @Test
    void findOwner_NegativeOwnerId() {
        Mockito.when(owners.findById(-1)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            petController.findOwner(-1);
        });

        String expectedMessage = "Owner ID not found: -1";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        Mockito.verify(owners, Mockito.times(1)).findById(-1);
    }

    @Test
    void findOwner_ZeroOwnerId() {
        Mockito.when(owners.findById(0)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            petController.findOwner(0);
        });

        String expectedMessage = "Owner ID not found: 0";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
        Mockito.verify(owners, Mockito.times(1)).findById(0);
    }
}
