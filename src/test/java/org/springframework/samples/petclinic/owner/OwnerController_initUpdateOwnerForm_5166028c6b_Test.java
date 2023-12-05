/*
Test generated by RoostGPT for test java-springboot-unit-testing using AI Type Open AI and AI Model gpt-4

1. Scenario: Check if the function returns the correct view.
   Given the owner ID is valid,
   When the function is called,
   Then it should return the constant VIEWS_OWNER_CREATE_OR_UPDATE_FORM.

2. Scenario: Check if the function handles invalid owner ID.
   Given the owner ID is invalid (i.e., the owner does not exist),
   When the function is called,
   Then it should throw an exception or return an error message.

3. Scenario: Check if the function adds the correct attribute to the model.
   Given the owner ID is valid,
   When the function is called,
   Then the model should contain an attribute with the correct owner data.

4. Scenario: Check if the function handles null owner ID.
   Given the owner ID is null,
   When the function is called,
   Then it should throw an exception or return an error message.

5. Scenario: Check if the function handles negative owner ID.
   Given the owner ID is negative,
   When the function is called,
   Then it should throw an exception or return an error message.

6. Scenario: Check if the function handles owner ID of zero.
   Given the owner ID is zero,
   When the function is called,
   Then it should throw an exception or return an error message.

7. Scenario: Check if the function handles non-integer owner ID.
   Given the owner ID is a non-integer value,
   When the function is called,
   Then it should throw an exception or return an error message.

8. Scenario: Check if the function handles very large owner ID.
   Given the owner ID is a very large number (beyond the range of valid IDs),
   When the function is called,
   Then it should throw an exception or return an error message.
*/
package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

public class OwnerController_initUpdateOwnerForm_5166028c6b_Test {

    private OwnerController ownerController;
    private OwnerRepository owners;
    private Model model;

    @BeforeEach
    public void setup() {
        owners = mock(OwnerRepository.class);
        model = mock(Model.class);
        ownerController = new OwnerController(owners);
    }

    @Test
    public void testInitUpdateOwnerForm_ValidOwnerId() {
        Owner owner = new Owner();
        when(owners.findById(1)).thenReturn(owner);

        String view = ownerController.initUpdateOwnerForm(1, model);

        assertEquals(OwnerController.VIEWS_OWNER_CREATE_OR_UPDATE_FORM, view);
    }

    @Test
    public void testInitUpdateOwnerForm_InvalidOwnerId() {
        when(owners.findById(-1)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ownerController.initUpdateOwnerForm(-1, model);
        });

        assertEquals("Invalid owner ID", exception.getMessage());
    }

    @Test
    public void testInitUpdateOwnerForm_NullOwnerId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ownerController.initUpdateOwnerForm(null, model);
        });

        assertEquals("Invalid owner ID", exception.getMessage());
    }

    @Test
    public void testInitUpdateOwnerForm_NegativeOwnerId() {
        when(owners.findById(-1)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ownerController.initUpdateOwnerForm(-1, model);
        });

        assertEquals("Invalid owner ID", exception.getMessage());
    }

    @Test
    public void testInitUpdateOwnerForm_ZeroOwnerId() {
        when(owners.findById(0)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ownerController.initUpdateOwnerForm(0, model);
        });

        assertEquals("Invalid owner ID", exception.getMessage());
    }

    @Test
    public void testInitUpdateOwnerForm_NonIntegerOwnerId() {
        when(owners.findById("abc")).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ownerController.initUpdateOwnerForm("abc", model);
        });

        assertEquals("Invalid owner ID", exception.getMessage());
    }

    @Test
    public void testInitUpdateOwnerForm_VeryLargeOwnerId() {
        when(owners.findById(Integer.MAX_VALUE)).thenReturn(null);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ownerController.initUpdateOwnerForm(Integer.MAX_VALUE, model);
        });

        assertEquals("Invalid owner ID", exception.getMessage());
    }
}
