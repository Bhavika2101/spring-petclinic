/*
Test generated by RoostGPT for test pom-test using AI Type Open AI and AI Model gpt-4

Test Scenario 1: Successful update of owner
Description: In this scenario, we'll test the successful update of an owner. We'll provide valid owner details and ensure that there are no binding errors. The expected result is that the owner's details should be saved and should redirect to the owner's details page.

Test Scenario 2: Update owner with binding errors
Description: In this scenario, we'll test the scenario where there are binding errors in the owner object. We'll provide invalid owner details and ensure that there are binding errors. The expected result is that the method should return to the create or update owner form.

Test Scenario 3: Update owner with non-existing ID
Description: In this scenario, we'll test the scenario where the owner ID does not exist in the database. We'll provide an owner object with a non-existing ID and a valid owner object. The expected result is that the method should handle this scenario gracefully, potentially by returning to the create or update owner form.

Test Scenario 4: Update owner with null object
Description: In this scenario, we'll test the scenario where the owner object provided is null. We'll provide a null owner object. The expected result is that the method should handle this scenario gracefully, potentially by returning to the create or update owner form.

Test Scenario 5: Update owner with negative ID
Description: In this scenario, we'll test the scenario where the owner ID provided is negative. We'll provide an owner object with a negative ID and a valid owner object. The expected result is that the method should handle this scenario gracefully, potentially by returning to the create or update owner form.
*/
package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.BindingResult;

public class OwnerController_processUpdateOwnerForm_a228651f5b_Test {

    @Mock
    private BindingResult result;

    @Mock
    private OwnerRepository owners;

    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController(owners);
    }

    @Test
    public void testProcessUpdateOwnerFormSuccess() {
        Owner owner = new Owner();
        owner.setId(1);
        when(result.hasErrors()).thenReturn(false);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);

        verify(owners).save(owner);
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    public void testProcessUpdateOwnerFormHasErrors() {
        Owner owner = new Owner();
        owner.setId(1);
        when(result.hasErrors()).thenReturn(true);

        String view = ownerController.processUpdateOwnerForm(owner, result, 1);

        assertEquals("owners/createOrUpdateOwnerForm", view);
    }

    @Test
    public void testProcessUpdateOwnerFormNonExistingId() {
        Owner owner = new Owner();
        owner.setId(100);
        when(result.hasErrors()).thenReturn(false);

        String view = ownerController.processUpdateOwnerForm(owner, result, 100);

        verify(owners).save(owner);
        assertEquals("redirect:/owners/{ownerId}", view);
    }

    @Test
    public void testProcessUpdateOwnerFormNullOwner() {
        when(result.hasErrors()).thenReturn(false);

        String view = ownerController.processUpdateOwnerForm(null, result, 1);

        assertEquals("owners/createOrUpdateOwnerForm", view);
    }

    @Test
    public void testProcessUpdateOwnerFormNegativeId() {
        Owner owner = new Owner();
        owner.setId(-1);
        when(result.hasErrors()).thenReturn(false);

        String view = ownerController.processUpdateOwnerForm(owner, result, -1);

        assertEquals("owners/createOrUpdateOwnerForm", view);
    }
}
