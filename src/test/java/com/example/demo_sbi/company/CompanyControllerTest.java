package com.example.demo_sbi.company;

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

import com.example.demo_sbi.controller.CompanyController;
import com.example.demo_sbi.service.CompanyService;
@WebMvcTest(CompanyController.class)
public class CompanyControllerTest {
	@Autowired
    private MockMvc mvc;
	
	@Autowired
    private WebApplicationContext webApplicationContext;
	
	@MockBean
	private CompanyService companyService; 
 
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
    	return MockMvcRequestBuilders.put("/company/1").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
		.content("{\"address\": \"台北市中山區中山北路2段31號5樓\",\"name\": \"中華電信公司\"}");
    }
    
    private MockHttpServletRequestBuilder generatePostRequest() {
    	return MockMvcRequestBuilders.post("/company").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
    			.content("{\"address\": \"台北市中山區中山北路2段31號5樓\",\"name\": \"中華電信公司\"}");
    }
}
