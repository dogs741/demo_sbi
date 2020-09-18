package com.example.demo_sbi.client;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo_sbi.controller.ClientController;
import com.example.demo_sbi.service.client.ClientService;

@WebMvcTest(ClientController.class)
public class ClientControllerTest {
	@Autowired
    private MockMvc mvc;
	@Autowired
    private WebApplicationContext webApplicationContext;
	@MockBean
	private ClientService clientService; 
 
    @BeforeEach
	public void setup(){
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}
    
    @WithMockUser(username="OPERATOR")
    @Test
    public void operatorEditUnauthorized() throws Exception {
    	mvc.perform(generatePutRequest()).andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }
    
    @WithMockUser(username="MANAGER")
    @Test
    public void managerInsertUnauthorized() throws Exception {
    	mvc.perform(generatePostRequest()).andExpect(MockMvcResultMatchers.status().isUnauthorized());
    }
	
    private MockHttpServletRequestBuilder generatePutRequest() {
    	return MockMvcRequestBuilders.put("/client/1").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
		.content("{\"companyId\": 1,\"email\": \"test@gmail.com.tw\",\"id\": 1,\"name\": \"Jack\",\"phone\": \"0229513267\"}");
    }
    
    private MockHttpServletRequestBuilder generatePostRequest() {
    	return MockMvcRequestBuilders.post("/client").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
    			.content("{\"companyId\": 1,\"email\": \"test@gmail.com.tw\",\"name\": \"Jack\",\"phone\": \"0229513267\"}");
    }
}
