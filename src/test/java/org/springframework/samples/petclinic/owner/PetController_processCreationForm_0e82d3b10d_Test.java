/*
Test generated by RoostGPT for test java-springboot-unit-testing using AI Type Open AI and AI Model gpt-4-1106-preview

To validate the business logic of the `processCreationForm` function, you should consider creating test scenarios that cover both the happy path (where everything works as intended) and edge cases. Here are some potential test scenarios:

1. **Happy Path Scenario:**
   - Create an Owner without any pets.
   - Create a valid Pet with a name and birth date before the current date.
   - Call `processCreationForm` with the Owner and Pet.
   - Expect no binding result errors.
   - Expect the pet to be added to the owner.
   - Expect a redirect to the owner's information page.

2. **Duplicate Pet Name Scenario:**
   - Create an Owner with an existing Pet named "Fido".
   - Create a new Pet with the name "Fido" and a valid birth date.
   - Call `processCreationForm` with the Owner and new Pet.
   - Expect a binding result error for the Pet name field due to duplication.
   - Expect the pet not to be added to the owner.
   - Expect to return the view for creating or updating a form.

3. **Future Birth Date Scenario:**
   - Create an Owner.
   - Create a Pet with a birth date set in the future.
   - Call `processCreationForm` with the Owner and Pet.
   - Expect a binding result error for the Pet birth date field.
   - Expect the pet not to be added to the owner.
   - Expect to return the view for creating or updating a form.

4. **Blank Pet Name Scenario:**
   - Create an Owner.
   - Create a Pet with a blank name but a valid birth date.
   - Call `processCreationForm` with the Owner and Pet.
   - Expect no errors related to the pet's name (as the method does not explicitly check for blank names, only duplicate names).
   - Expect the pet to be added to the owner.
   - Expect a redirect to the owner's information page.

5. **Binding Result Errors Scenario:**
   - Create an Owner.
   - Create a Pet with a valid name and birth date.
   - Mock BindingResult to have non-field related errors.
   - Call `processCreationForm` with the Owner, Pet, and mocked BindingResult.
   - Expect the pet not to be saved to the owner.
   - Expect to return the view for creating or updating a form.

6. **Valid Pet with Existing Owner Scenario:**
   - Create an Owner with an existing Pet named "Max".
   - Create a new Pet with a different name and a valid birth date.
   - Call `processCreationForm` with the Owner and new Pet.
   - Expect no binding result errors.
   - Expect the new pet to be added to the owner.
   - Expect a redirect to the owner's information page.

7. **Pet Name Case Sensitivity Scenario:**
   - Create an Owner with an existing Pet named "Buddy".
   - Create a new Pet named "buddy" (case-insensitive match) with a valid birth date.
   - Call `processCreationForm` with the Owner and new Pet.
   - Expect a binding result error for the Pet name field due to case-insensitive duplication.
   - Expect the pet not to be added to the owner.
   - Expect to return the view for creating or updating a form.

Remember that in these scenarios, you should also validate that the appropriate methods are called on the Owner object (like `addPet` and `getPet`) and that the `owners` repository is used to save the Owner when there are no errors. Additionally, ensure that the model map is correctly populated with the expected attributes based on the outcome of the form processing.
*/
package org.springframework.samples.petclinic.owner;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class PetController_processCreationForm_0e82d3b10d_Test {

	private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

	@Mock
	private OwnerRepository owners;

	private PetController petController;

	@BeforeEach
	public void setup() {
		owners = mock(OwnerRepository.class);
		petController = new PetController(owners);
	}

	@Test
	public void testHappyPathScenario() {
		Owner owner = new Owner();
		Pet pet = new Pet();
		pet.setName("Buddy");
		pet.setBirthDate(LocalDate.now().minusDays(10));
		BindingResult result = mock(BindingResult.class);
		ModelMap model = new ModelMap();

		when(result.hasErrors()).thenReturn(false);

		String view = petController.processCreationForm(owner, pet, result, model);

		assertEquals("redirect:/owners/{ownerId}", view);
		assertTrue(owner.getPets().contains(pet));
		verify(owners, times(1)).save(owner);
	}

	@Test
	public void testDuplicatePetNameScenario() {
		Owner owner = new Owner();
		Pet pet1 = new Pet();
		pet1.setName("Fido");
		owner.addPet(pet1);

		Pet pet2 = new Pet();
		pet2.setName("Fido");
		pet2.setBirthDate(LocalDate.now().minusDays(10));
		BindingResult result = mock(BindingResult.class);
		ModelMap model = new ModelMap();

		when(result.hasErrors()).thenReturn(true);

		String view = petController.processCreationForm(owner, pet2, result, model);

		assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
		assertFalse(owner.getPets().contains(pet2));
	}

	@Test
	public void testFutureBirthDateScenario() {
		Owner owner = new Owner();
		Pet pet = new Pet();
		pet.setName("Lucky");
		pet.setBirthDate(LocalDate.now().plusDays(10));
		BindingResult result = mock(BindingResult.class);
		ModelMap model = new ModelMap();

		when(result.hasErrors()).thenReturn(true);

		String view = petController.processCreationForm(owner, pet, result, model);

		assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
		assertFalse(owner.getPets().contains(pet));
	}

	@Test
	public void testBlankPetNameScenario() {
		Owner owner = new Owner();
		Pet pet = new Pet();
		pet.setName("");
		pet.setBirthDate(LocalDate.now().minusDays(10));
		BindingResult result = mock(BindingResult.class);
		ModelMap model = new ModelMap();

		when(result.hasErrors()).thenReturn(false);

		String view = petController.processCreationForm(owner, pet, result, model);

		assertEquals("redirect:/owners/{ownerId}", view);
		assertTrue(owner.getPets().contains(pet));
		verify(owners, times(1)).save(owner);
	}

	@Test
	public void testBindingResultErrorsScenario() {
		Owner owner = new Owner();
		Pet pet = new Pet();
		pet.setName("Buster");
		pet.setBirthDate(LocalDate.now().minusDays(10));
		BindingResult result = mock(BindingResult.class);
		ModelMap model = new ModelMap();

		when(result.hasErrors()).thenReturn(true);
		when(result.getAllErrors()).thenReturn(new ArrayList<>()); // Mock non-field
																	// related errors
		when(result.getFieldErrors()).thenReturn(new ArrayList<>());

		String view = petController.processCreationForm(owner, pet, result, model);

		assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
		assertFalse(owner.getPets().contains(pet));
	}

	@Test
	public void testValidPetWithExistingOwnerScenario() {
		Owner owner = new Owner();
		Pet pet1 = new Pet();
		pet1.setName("Max");
		owner.addPet(pet1);

		Pet pet2 = new Pet();
		pet2.setName("Buddy");
		pet2.setBirthDate(LocalDate.now().minusDays(10));
		BindingResult result = mock(BindingResult.class);
		ModelMap model = new ModelMap();

		when(result.hasErrors()).thenReturn(false);

		String view = petController.processCreationForm(owner, pet2, result, model);

		assertEquals("redirect:/owners/{ownerId}", view);
		assertTrue(owner.getPets().contains(pet2));
		verify(owners, times(1)).save(owner);
	}

	@Test
	public void testPetNameCaseSensitivityScenario() {
		Owner owner = new Owner();
		Pet pet1 = new Pet();
		pet1.setName("Buddy");
		owner.addPet(pet1);

		Pet pet2 = new Pet();
		pet2.setName("buddy");
		pet2.setBirthDate(LocalDate.now().minusDays(10));
		BindingResult result = mock(BindingResult.class);
		ModelMap model = new ModelMap();

		when(owner.getPet(pet2.getName(), true)).thenReturn(pet1);
		when(result.hasErrors()).thenReturn(true);

		String view = petController.processCreationForm(owner, pet2, result, model);

		assertEquals(VIEWS_PETS_CREATE_OR_UPDATE_FORM, view);
		assertFalse(owner.getPets().contains(pet2));
		verify(result, times(1)).rejectValue("name", "duplicate", "already exists");
	}

}
