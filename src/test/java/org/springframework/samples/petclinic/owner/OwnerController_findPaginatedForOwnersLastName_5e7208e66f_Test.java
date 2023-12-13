/*
Test generated by RoostGPT for test java-springboot-unit-testing using AI Type Open AI and AI Model gpt-4-1106-preview

To validate the business logic of the `findPaginatedForOwnersLastName` method, the following test scenarios should be considered:

1. **Valid Last Name with Results**: 
   - Given a valid last name that exists in the database, when the method is called, then it should return a non-empty page of owners with the specified last name.
   - Verify that the returned page contains owners with the correct last name.
   - Verify that the size of the returned page does not exceed the specified page size (5 owners per page).

2. **Valid Last Name with No Results**: 
   - Given a valid last name that does not exist in the database, when the method is called, then it should return an empty page.
   - Verify that the total elements in the returned page are zero.

3. **Pagination**: 
   - Given multiple pages of owners with the same last name, when the method is called with different page numbers, then it should return the correct page with the correct subset of owners.
   - Verify that the page number in the returned page object matches the requested page number (adjusted for zero-based index).
   - Verify that the `Pageable` object has been created with the correct page number and page size.

4. **Invalid Page Number**: 
   - Given an invalid page number (e.g., negative number or zero), when the method is called, then it should handle the error appropriately, possibly defaulting to the first page or throwing an exception.
   - Verify that the appropriate action is taken and the correct page information or error is returned.

5. **Boundary Conditions**: 
   - Test with the page number at the boundary conditions, such as the first and last page.
   - Verify that the first page is correctly handled when the page number is 1 (adjusted for zero-based index).
   - Verify that the last page is correctly handled when the page number is equal to the total number of pages.

6. **Empty Last Name**: 
   - Given an empty last name string, when the method is called, then it should either return all owners disregarding the last name or handle it as an invalid input, based on the business rules.
   - Verify that the correct behavior is implemented and the correct data or error is returned.

7. **Null Last Name**: 
   - Given a null last name, when the method is called, then it should handle it as an invalid input or return all owners, based on the business rules.
   - Verify that the appropriate error handling or data return is implemented.

8. **Case Sensitivity**: 
   - Given a last name with different casing (e.g., "Smith" vs "smith"), when the method is called, then it should verify whether the search is case-sensitive or case-insensitive.
   - Verify that the search behavior is consistent with the business rules.

9. **Special Characters in Last Name**: 
   - Given a last name with special characters or spaces, when the method is called, then it should verify that the method can handle such inputs correctly.
   - Verify that the search returns the correct owners or handles the input as invalid according to the business rules.

10. **Performance and Load**: 
    - Given a large number of requests or a large dataset, when the method is called, then it should verify that the method performs within acceptable time limits and can handle the load.
    - Verify that the system can handle the performance requirements and does not degrade under heavy load.

Each of these scenarios would need to be translated into actual test cases with specific input data and expected outcomes to thoroughly validate the `findPaginatedForOwnersLastName` method in various conditions and edge cases.
*/
package org.springframework.samples.petclinic.owner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class OwnerController_findPaginatedForOwnersLastName_5e7208e66f_Test {

    @Mock
    private OwnerRepository owners;

    @InjectMocks
    private OwnerController ownerController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindPaginatedForOwnersLastName_ValidLastNameWithResults() {
        // Prepare mock data
        int page = 1;
        String lastname = "Smith";
        List<Owner> ownerList = new ArrayList<>();
        ownerList.add(new Owner());
        Page<Owner> expectedPage = new PageImpl<>(ownerList);
        
        // Mock the repository call
        when(owners.findByLastName(lastname, PageRequest.of(page - 1, 5))).thenReturn(expectedPage);
        
        // Execute the method
        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(page, lastname);
        
        // Assertions
        assertFalse(result.isEmpty(), "The result should not be empty");
        assertEquals(lastname, result.getContent().get(0).getLastName(), "Owner last name should match");
        assertTrue(result.getSize() <= 5, "Page size should not exceed 5 owners per page");
    }

    @Test
    public void testFindPaginatedForOwnersLastName_ValidLastNameWithNoResults() {
        // Prepare mock data
        int page = 1;
        String lastname = "Nonexistent";
        Page<Owner> expectedPage = Page.empty();
        
        // Mock the repository call
        when(owners.findByLastName(lastname, PageRequest.of(page - 1, 5))).thenReturn(expectedPage);
        
        // Execute the method
        Page<Owner> result = ownerController.findPaginatedForOwnersLastName(page, lastname);
        
        // Assertions
        assertTrue(result.isEmpty(), "The result should be empty");
        assertEquals(0, result.getTotalElements(), "Total elements should be zero");
    }

    // TODO: Test cases for other scenarios like Pagination, Invalid Page Number, Boundary Conditions, Empty Last Name,
    // Null Last Name, Case Sensitivity, Special Characters in Last Name, Performance and Load.
}
