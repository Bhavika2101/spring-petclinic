/*
Test generated by RoostGPT for test java-springboot-unit-testing using AI Type Vertex AI and AI Model code-bison

 **Test Scenario 1: Create a new pet with valid data**

* **Given:** A user is logged in and on the "Create Pet" page.
* **When:** The user enters valid data into the form and clicks "Create Pet".
* **Then:** The new pet is created and the user is redirected to the pet's profile page.

**Test Scenario 2: Create a new pet with invalid data**

* **Given:** A user is logged in and on the "Create Pet" page.
* **When:** The user enters invalid data into the form and clicks "Create Pet".
* **Then:** The form is re-displayed with error messages indicating the invalid data.

**Test Scenario 3: Edit an existing pet with valid data**

* **Given:** A user is logged in and on the "Edit Pet" page for an existing pet.
* **When:** The user enters valid data into the form and clicks "Save Pet".
* **Then:** The existing pet is updated with the new data and the user is redirected to the pet's profile page.

**Test Scenario 4: Edit an existing pet with invalid data**

* **Given:** A user is logged in and on the "Edit Pet" page for an existing pet.
* **When:** The user enters invalid data into the form and clicks "Save Pet".
* **Then:** The form is re-displayed with error messages indicating the invalid data.

**Test Scenario 5: Delete an existing pet**

* **Given:** A user is logged in and on the "Pet Profile" page for an existing pet.
* **When:** The user clicks the "Delete Pet" button.
* **Then:** The existing pet is deleted and the user is redirected to the "Pets" page.
*/
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PetController_PetController_2a2536f183_Test {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OwnerRepository owners;

    @Test
    @DisplayName("Test Scenario 1: Create a new pet with valid data")
    void testCreatePetWithValidData() throws Exception {
        // Given
        Pet pet = new Pet();
        pet.setName("Leo");
        pet.setBirthDate(LocalDate.of(2020, 1, 1));
        Owner owner = new Owner();
        owner.setId(1);
        owner.addPet(pet);
        given(owners.findById(anyInt())).willReturn(Optional.of(owner));

        // When
        mockMvc.perform(post("/owners/{ownerId}/pets/new", 1)
                .param("name", "Leo")
                .param("birthDate", "2020-01-01"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/owners/1"));

        // Then
        verify(owners, times(1)).findById(anyInt());
        verify(owners, times(1)).save(any(Owner.class));
    }

    @ParameterizedTest
    @CsvSource({
            "null, 2020-01-01",
            "Leo, null",
            "Leo, 2023-01-01"
    })
    @DisplayName("Test Scenario 2: Create a new pet with invalid data")
    void testCreatePetWithInvalidData(String name, String birthDate) throws Exception {
        // Given
        Owner owner = new Owner();
        owner.setId(1);
        given(owners.findById(anyInt())).willReturn(Optional.of(owner));

        // When
        mockMvc.perform(post("/owners/{ownerId}/pets/new", 1)
                .param("name", name)
                .param("birthDate", birthDate))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeHasFieldErrors("pet", "name", "birthDate"));

        // Then
        verify(owners, times(1)).findById(anyInt());
        verify(owners, times(0)).save(any(Owner.class));
    }

    @Test
    @DisplayName("Test Scenario 3: Edit an existing pet with valid data")
    void testEditPetWithValidData() throws Exception {
        // Given
        Pet pet = new Pet();
        pet.setName("Leo");
        pet.setBirthDate(LocalDate.of(2020, 1, 1));
        Owner owner = new Owner();
        owner.setId(1);
        owner.addPet(pet);
        given(owners.findById(anyInt())).willReturn(Optional.of(owner));

        // When
        mockMvc.perform(post("/owners/{ownerId}/pets/{petId}/edit", 1, 1)
                .param("name", "Leo")
                .param("birthDate", "2020-01-01"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/owners/1"));

        // Then
        verify(owners, times(1)).findById(anyInt());
        verify(owners, times(1)).save(any(Owner.class));
    }

    @ParameterizedTest
    @CsvSource({
            "null, 2020-01-01",
            "Leo, null",
            "Leo, 2023-01-01"
    })
    @DisplayName("Test Scenario 4: Edit an existing pet with invalid data")
    void testEditPetWithInvalidData(String name, String birthDate) throws Exception {
        // Given
        Pet pet = new Pet();
        pet.setName("Leo");
        pet.setBirthDate(LocalDate.of(2020, 1, 1));
        Owner owner = new Owner();
        owner.setId(1);
        owner.addPet(pet);
        given(owners.findById(anyInt())).willReturn(Optional.of(owner));

        // When
        mockMvc.perform(post("/owners/{ownerId}/pets/{petId}/edit", 1, 1)
                .param("name", name)
                .param("birthDate", birthDate))
                .andExpect(status().isOk())
                .andExpect(view().name("pets/createOrUpdatePetForm"))
                .andExpect(model().attributeHasFieldErrors("pet", "name", "birthDate"));

        // Then
        verify(owners, times(1)).findById(anyInt());
        verify(owners, times(0)).save(any(Owner.class));
    }

    @Test
    @DisplayName("Test Scenario 5: Delete an existing pet")
    void testDeletePet() throws Exception {
        // Given
        Pet pet = new Pet();
        pet.setName("Leo");
        pet.setBirthDate(LocalDate.of(2020, 1, 1));
        Owner owner = new Owner();
        owner.setId(1);
        owner.addPet(pet);
        given(owners.findById(anyInt())).willReturn(Optional.of(owner));

        // When
        mockMvc.perform(get("/owners/{ownerId}/pets/{petId}/delete", 1, 1))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/owners/1"));

        // Then
        verify(owners, times(1)).findById(anyInt());
        verify(owners, times(1)).save(any(Owner.class));
    }
}
