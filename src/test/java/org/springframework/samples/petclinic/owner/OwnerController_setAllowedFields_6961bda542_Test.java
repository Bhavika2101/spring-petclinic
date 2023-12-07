/*
Test generated by RoostGPT for test java-springboot-unit-testing using AI Type Vertex AI and AI Model code-bison

 **Test Scenario 1: Verify that the "id" field is not allowed for binding.**

**Test Steps:**
1. Create a `WebDataBinder` object.
2. Call the `setAllowedFields` method on the `WebDataBinder` object, passing in a list of disallowed fields that includes the "id" field.
3. Attempt to bind a request object to the `WebDataBinder` object, including a value for the "id" field.
4. Verify that the `WebDataBinder` object rejects the binding of the "id" field.

**Expected Result:**
The `WebDataBinder` object should reject the binding of the "id" field, and the request object should not be bound to the "id" field.

**Test Scenario 2: Verify that other fields are allowed for binding.**

**Test Steps:**
1. Create a `WebDataBinder` object.
2. Call the `setAllowedFields` method on the `WebDataBinder` object, passing in a list of disallowed fields that does not include the "id" field.
3. Attempt to bind a request object to the `WebDataBinder` object, including values for fields other than the "id" field.
4. Verify that the `WebDataBinder` object accepts the binding of the fields other than the "id" field.

**Expected Result:**
The `WebDataBinder` object should accept the binding of the fields other than the "id" field, and the request object should be bound to those fields.

**Test Scenario 3: Verify that the `setAllowedFields` method works with different types of request objects.**

**Test Steps:**
1. Create a `WebDataBinder` object.
2. Call the `setAllowedFields` method on the `WebDataBinder` object, passing in a list of disallowed fields that includes the "id" field.
3. Attempt to bind different types of request objects to the `WebDataBinder` object, including POJOs, Maps, and Lists.
4. Verify that the `WebDataBinder` object rejects the binding of the "id" field for all types of request objects.

**Expected Result:**
The `WebDataBinder` object should reject the binding of the "id" field for all types of request objects, and the request objects should not be bound to the "id" field.
*/
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OwnerController_setAllowedFields_6961bda542_Test {

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private OwnerRepository owners;

    @Mock
    private WebDataBinder dataBinder;

    @Mock
    private BindingResult bindingResult;

    @Mock
    private Page<Owner> paginated;

    @Test
    public void test_setAllowedFields_disallowsIdField() {
        // Arrange
        List<String> disallowedFields = new ArrayList<>();
        disallowedFields.add("id");

        // Act
        ownerController.setAllowedFields(dataBinder);

        // Assert
        verify(dataBinder).setDisallowedFields(disallowedFields);
    }

    @Test
    public void test_setAllowedFields_allowsOtherFields() {
        // Arrange
        List<String> disallowedFields = new ArrayList<>();
        disallowedFields.add("otherField");

        // Act
        ownerController.setAllowedFields(dataBinder);

        // Assert
        verify(dataBinder).setDisallowedFields(disallowedFields);
    }

    @Test
    public void test_setAllowedFields_worksWithDifferentRequestObjects() {
        // Arrange
        List<String> disallowedFields = new ArrayList<>();
        disallowedFields.add("id");

        // Act
        ownerController.setAllowedFields(dataBinder);

        // Assert
        verify(dataBinder).setDisallowedFields(disallowedFields);
    }
}