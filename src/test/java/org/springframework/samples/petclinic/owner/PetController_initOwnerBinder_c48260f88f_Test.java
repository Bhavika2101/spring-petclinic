/*
Test generated by RoostGPT for test pom-test using AI Type Open AI and AI Model gpt-4

1. **Scenario: Disallowed Fields Verification**
   
   Description: Verify that the 'id' field is correctly set as a disallowed field. The data binder should not bind any data to the 'id' field.

2. **Scenario: Allowed Fields Verification**
   
   Description: Verify that all fields except 'id' are correctly allowed. The data binder should be able to bind data to any field other than 'id'.

3. **Scenario: Null Data Binder**
   
   Description: Verify the behavior when a null WebDataBinder is passed. The function should throw an appropriate exception or handle the null input gracefully.

4. **Scenario: Empty Data Binder**
   
   Description: Verify the behavior when an empty WebDataBinder is passed. The function should run without errors and 'id' field should be set as disallowed.

5. **Scenario: Data Binder with Pre-existing Disallowed Fields**
   
   Description: Verify the behavior when a WebDataBinder with pre-existing disallowed fields is passed. The function should run without errors and 'id' field should be added to the existing list of disallowed fields.

6. **Scenario: Data Binder with 'id' as Allowed Field**
   
   Description: Verify the behavior when a WebDataBinder with 'id' as an allowed field is passed. After running the function, 'id' should be moved from allowed to disallowed fields.

7. **Scenario: Data Binder with 'id' already as Disallowed Field**
   
   Description: Verify the behavior when a WebDataBinder with 'id' already in the disallowed fields is passed. The function should run without errors and 'id' should remain in the disallowed fields.

8. **Scenario: Multiple Calls to initOwnerBinder**
   
   Description: Verify the behavior when initOwnerBinder is called multiple times on the same WebDataBinder. The function should run without errors and 'id' should remain in the disallowed fields.

9. **Scenario: Thread Safety**
   
   Description: Verify the behavior when initOwnerBinder is called simultaneously from multiple threads. The function should be thread-safe and 'id' should be correctly set as a disallowed field in all cases.
*/
package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BindingResult;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.validation.DataBinder;

public class PetController_initOwnerBinder_c48260f88f_Test {

    @Mock
    private DataBinder dataBinder;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testInitOwnerBinder() {
        PetController petController = new PetController(null);
        petController.initOwnerBinder(dataBinder);
        verify(dataBinder, times(1)).setDisallowedFields("id");
    }

    @Test
    public void testInitOwnerBinderWithNullDataBinder() {
        PetController petController = new PetController(null);
        assertThrows(NullPointerException.class, () -> {
            petController.initOwnerBinder(null);
        });
    }

    @Test
    public void testInitOwnerBinderWithPreExistingDisallowedFields() {
        when(dataBinder.getDisallowedFields()).thenReturn(new String[]{"field1", "field2"});
        PetController petController = new PetController(null);
        petController.initOwnerBinder(dataBinder);
        verify(dataBinder, times(1)).setDisallowedFields(anyString());
    }

    @Test
    public void testInitOwnerBinderWithIdAlreadyDisallowed() {
        when(dataBinder.getDisallowedFields()).thenReturn(new String[]{"id"});
        PetController petController = new PetController(null);
        petController.initOwnerBinder(dataBinder);
        verify(dataBinder, times(1)).setDisallowedFields("id");
    }

    @Test
    public void testInitOwnerBinderCalledMultipleTimes() {
        PetController petController = new PetController(null);
        petController.initOwnerBinder(dataBinder);
        petController.initOwnerBinder(dataBinder);
        verify(dataBinder, times(2)).setDisallowedFields("id");
    }

    // Thread safety test would require a more complex setup and is not included here
}
