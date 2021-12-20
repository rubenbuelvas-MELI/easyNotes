package com.example.easynotes.integration;

import com.example.easynotes.dto.UserTypeDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    private static ObjectWriter writer;

    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    static void initData() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                // fechas
                .registerModule(new JSR310Module())
                .writer()
                .withDefaultPrettyPrinter();
    }

    @Test
    public void testPublicadorDiario() throws Exception {
        //arrange
        long id = 1;

        UserTypeDTO user = new UserTypeDTO(id,"user1","last1", UserTypeDTO.userTypes.PublicadorDiario);

        String expected = writer.writeValueAsString(user);

        mockMvc.perform(get("/api/user/" + id + "/type"))
                .andExpectAll(
                        status().isOk(),
                        content().json(expected),
                        content().contentType(MediaType.APPLICATION_JSON)
                );
    }

    @Test
    public void testPublicadorSemanal() throws Exception {
        //arrange
        long id = 2;

        UserTypeDTO user = new UserTypeDTO(id,"user2","last2", UserTypeDTO.userTypes.PublicadorSemanal);

        String expected = writer.writeValueAsString(user);

        mockMvc.perform(get("/api/user/" + id + "/type"))
                .andExpectAll(
                        status().isOk(),
                        content().json(expected),
                        content().contentType(MediaType.APPLICATION_JSON)
                );
    }

    @Test
    public void testPublicador() throws Exception {
        //arrange
        long id = 3;

        UserTypeDTO user = new UserTypeDTO(id,"user3","last3", UserTypeDTO.userTypes.Publicador);

        String expected = writer.writeValueAsString(user);

        mockMvc.perform(get("/api/user/" + id + "/type"))
                .andExpectAll(
                        status().isOk(),
                        content().json(expected),
                        content().contentType(MediaType.APPLICATION_JSON)
                );
    }

}
