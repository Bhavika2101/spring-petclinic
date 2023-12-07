/*
Test generated by RoostGPT for test java-springboot-unit-testing using AI Type Vertex AI and AI Model code-bison

 **Test scenarios:**

**1. List owners:**
- Given an empty database, when the user accesses the "/owners" URL, the system should display an empty list of owners.
- Given a database with some owners, when the user accesses the "/owners" URL, the system should display a list of all owners.
- Given a database with some owners, when the user accesses the "/owners" URL with the "lastName" parameter set to a valid last name, the system should display a list of owners with that last name.
- Given a database with some owners, when the user accesses the "/owners" URL with the "lastName" parameter set to an invalid last name, the system should display an empty list of owners.

**2. Show owner details:**
- Given a database with some owners, when the user accesses the "/owners/{ownerId}" URL, the system should display the details of the owner with the specified ID.
- Given a database with some owners, when the user accesses the "/owners/{ownerId}" URL with an invalid owner ID, the system should display a 404 error page.

**3. Create owner:**
- Given an empty database, when the user accesses the "/owners/new" URL, the system should display a form for creating a new owner.
- Given an empty database, when the user submits a valid form for creating a new owner, the system should save the new owner to the database and redirect the user to the "/owners" URL.
- Given an empty database, when the user submits an invalid form for creating a new owner, the system should display the form again with the errors highlighted.

**4. Edit owner:**
- Given a database with some owners, when the user accesses the "/owners/{ownerId}/edit" URL, the system should display a form for editing the owner with the specified ID.
- Given a database with some owners, when the user submits a valid form for editing an owner, the system should save the changes to the database and redirect the user to the "/owners" URL.
- Given a database with some owners, when the user submits an invalid form for editing an owner, the system should display the form again with the errors highlighted.

**5. Delete owner:**
- Given a database with some owners, when the user accesses the "/owners/{ownerId}/delete" URL, the system should display a confirmation page.
- Given a database with some owners, when the user confirms the deletion of an owner, the system should delete the owner from the database and redirect the user to the "/owners" URL.
- Given a database with some owners, when the user cancels the deletion of an owner, the system should redirect the user to the "/owners" URL.
*/
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
public class OwnerController_OwnerController_8b45ad788c_Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testListOwners_EmptyDatabase() throws Exception {
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attributeExists("listOwners"));
    }

    @Test
    public void testListOwners_WithOwners() throws Exception {
        // TODO: Add some owners to the database
        mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attributeExists("listOwners"));
    }

    @Test
    public void testListOwners_WithLastName() throws Exception {
        // TODO: Add some owners with different last names to the database
        mockMvc.perform(get("/owners").param("lastName", "Smith"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attributeExists("listOwners"));
    }

    @Test
    public void testListOwners_WithInvalidLastName() throws Exception {
        mockMvc.perform(get("/owners").param("lastName", "Invalid"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attributeExists("listOwners"));
    }

    @Test
    public void testShowOwnerDetails_WithValidId() throws Exception {
        // TODO: Add an owner with a valid ID to the database
        mockMvc.perform(get("/owners/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attributeExists("owner"));
    }

    @Test
    public void testShowOwnerDetails_WithInvalidId() throws Exception {
        mockMvc.perform(get("/owners/999"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreateOwner_Get() throws Exception {
        mockMvc.perform(get("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));
    }

    @Test
    public void testCreateOwner_Post_ValidForm() throws Exception {
        // TODO: Create a valid owner object
        mockMvc.perform(post("/owners/new")
                .param("firstName", "John")
                .param("lastName", "Smith")
                .param("address", "123 Main Street")
                .param("city", "Anytown")
                .param("telephone", "0123456789"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/owners/1"));
    }

    @Test
    public void testCreateOwner_Post_InvalidForm() throws Exception {
        mockMvc.perform(post("/owners/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeHasErrors("owner"));
    }

    @Test
    public void testEditOwner_Get_WithValidId() throws Exception {
        // TODO: Add an owner with a valid ID to the database
        mockMvc.perform(get("/owners/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeExists("owner"));
    }

    @Test
    public void testEditOwner_Get_WithInvalidId() throws Exception {
        mockMvc.perform(get("/owners/999/edit"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testEditOwner_Post_ValidForm() throws Exception {
        // TODO: Add an owner with a valid ID to the database
        mockMvc.perform(post("/owners/1/edit")
                .param("firstName", "John")
                .param("lastName", "Smith")
                .param("address", "123 Main Street")
                .param("city", "Anytown")
                .param("telephone", "0123456789"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/owners/1"));
    }

    @Test
    public void testEditOwner_Post_InvalidForm() throws Exception {
        // TODO: Add an owner with a valid ID to the database
        mockMvc.perform(post("/owners/1/edit"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/createOrUpdateOwnerForm"))
                .andExpect(model().attributeHasErrors("owner"));
    }

    @Test
    public void testDeleteOwner_Get_WithValidId() throws Exception {
        // TODO: Add an owner with a valid ID to the database
        mockMvc.perform(get("/owners/1/delete"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/deleteOwner"));
    }

    @Test
    public void testDeleteOwner_Get_WithInvalidId() throws Exception {
        mockMvc.perform(get("/owners/999/delete"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDeleteOwner_Post_ConfirmDelete() throws Exception {
        // TODO: Add an owner with a valid ID to the database
        mockMvc.perform(post("/owners/1/delete")
                .param("confirm", "Yes"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/owners"));
    }

    @Test
    public void testDeleteOwner_Post_CancelDelete() throws Exception {
        // TODO: Add an owner with a valid ID to the database
        mockMvc.perform(post("/owners/1/delete")
                .param("confirm", "No"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/owners"));
    }
}
