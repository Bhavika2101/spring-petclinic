/*
Test generated by RoostGPT for test java-springboot-unit-testing using AI Type Open AI and AI Model gpt-4-1106-preview

To validate the business logic of the `findPaginatedForOwnersLastName` method, here are several test scenarios that can be considered:

1. **Valid Last Name with Results**:
   - **Given**: A valid `lastname` that exists in the database.
   - **When**: The method is called with a page number that has results.
   - **Then**: The returned `Page<Owner>` should contain a list of `Owner` objects with a size less than or equal to the page size (5 in this case) and should match the given `lastname`.

2. **Valid Last Name with No Results**:
   - **Given**: A valid `lastname` that does not exist in the database.
   - **When**: The method is called with any page number.
   - **Then**: The returned `Page<Owner>` should be empty, indicating that no records match the given `lastname`.

3. **Invalid Last Name**:
   - **Given**: An invalid `lastname` (e.g., null, empty string, or special characters).
   - **When**: The method is called with any page number.
   - **Then**: Depending on the specified behavior, the method should either return an empty `Page<Owner>` or throw a validation exception.

4. **Pagination Boundaries**:
   - **Given**: A valid `lastname` with multiple pages of results.
   - **When**: The method is called with the first page number.
   - **Then**: The returned `Page<Owner>` should contain the first `pageSize` number of `Owner` objects.
   - **And When**: The method is called with a page number beyond the total number of available pages.
   - **Then**: The returned `Page<Owner>` should be empty or throw an appropriate exception if the page number is out of range.

5. **Page Size Consistency**:
   - **Given**: A valid `lastname` with enough results to span multiple pages.
   - **When**: The method is called multiple times with sequential page numbers.
   - **Then**: Each `Page<Owner>` should contain exactly `pageSize` number of `Owner` objects, except possibly the last page, which may have fewer.

6. **Correct Ordering of Results**:
   - **Given**: A valid `lastname` with multiple records in the database.
   - **When**: The method is called.
   - **Then**: The results within the `Page<Owner>` should be ordered as per the default or specified sort order.

7. **Invalid Page Number**:
   - **Given**: A valid `lastname`.
   - **When**: The method is called with an invalid page number (e.g., 0, negative, or non-integer value).
   - **Then**: The method should either adjust the page number to a valid range or throw an appropriate exception.

8. **Concurrency and Caching**:
   - **Given**: A scenario where multiple clients are accessing the same `lastname` concurrently.
   - **When**: The method is called simultaneously by multiple threads.
   - **Then**: The method should handle concurrent access gracefully and return consistent results, taking into account any caching mechanisms that may be in place.

9. **Performance and Load**:
   - **Given**: A high load with many concurrent requests for the same or different `lastname`.
   - **When**: The method is called under load.
   - **Then**: The method should perform within acceptable response times and handle the load without errors.

10. **Integration with Data Layer**:
    - **Given**: The `owners` repository is correctly set up and integrated.
    - **When**: The method is called with a valid `lastname` and page number.
    - **Then**: The method should interact with the data layer correctly and return the expected results without any data access exceptions.

These test scenarios cover various aspects of the method's functionality, including input validation, pagination logic, sorting, concurrency, performance, and integration with the data layer. Each scenario would need to be implemented as a separate test case in your testing framework, ensuring that the `findPaginatedForOwnersLastName` method works correctly under different conditions and inputs.
*/
package org.springframework.samples.petclinic.owner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

public class OwnerController_findPaginatedForOwnersLastName_5e7208e66f_Test {

	@Mock
	private OwnerRepository owners;

	private OwnerController ownerController;

	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
		ownerController = new OwnerController(owners);
	}

	@Test
	public void testFindPaginatedForOwnersLastName_ValidLastNameWithResults() {
		int page = 1;
		String lastname = "Smith";
		int pageSize = 5;
		List<Owner> ownerList = new ArrayList<>();
		for (int i = 0; i < pageSize; i++) {
			Owner owner = mock(Owner.class);
			ownerList.add(owner);
		}
		Page<Owner> expectedPage = new PageImpl<>(ownerList, PageRequest.of(page - 1, pageSize), ownerList.size());

		when(owners.findByLastName(lastname, PageRequest.of(page - 1, pageSize))).thenReturn(expectedPage);

		Page<Owner> actualPage = ownerController.findPaginatedForOwnersLastName(page, lastname);

		assertEquals(expectedPage.getTotalElements(), actualPage.getTotalElements());
		assertEquals(expectedPage.getContent().size(), actualPage.getContent().size());
	}

	@Test
	public void testFindPaginatedForOwnersLastName_ValidLastNameWithNoResults() {
		int page = 1;
		String lastname = "Nonexistent";
		int pageSize = 5;
		Page<Owner> expectedPage = new PageImpl<>(new ArrayList<>(), PageRequest.of(page - 1, pageSize), 0);

		when(owners.findByLastName(lastname, PageRequest.of(page - 1, pageSize))).thenReturn(expectedPage);

		Page<Owner> actualPage = ownerController.findPaginatedForOwnersLastName(page, lastname);

		assertTrue(actualPage.isEmpty());
	}

	// TODO: Add more test cases based on the test scenarios provided.

}
