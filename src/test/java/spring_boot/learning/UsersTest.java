package spring_boot.learning;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

import spring_boot.learning.domain.Users;

/**
* @author DexterPoker
* @date 2017年1月22日-下午3:34:06
**/
@RunWith(SpringRunner.class)
@SpringBootTest
public class UsersTest {
	
	@Autowired WebApplicationContext context;
	
	RestTemplate restTemplate = new RestTemplate();
	
	MockMvc mvc;
	
	@Before
    public void setupMockMvc() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
	
	
	@Test
	public void getUesr() throws Exception{
		String id = "1";
		ObjectMapper mapper = new ObjectMapper();
		String content = mvc.perform(get("/users/"+id)).
						andReturn().
						getResponse().
						getContentAsString();
		Users user = mapper.readValue(content, Users.class);
		assertEquals(id , user.getId()+"");
		
	}
	
	
	@Test
	public void addUser() throws Exception{
		String addContext = "{\"name\":\"zhang11\",\"age\":23,\"password\":\"123\",\"roles\":\"USER\"}";
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
		
		String context = mvc.perform(post("/users").
				content(addContext).
				headers(headers)).
				andDo(print()).
				andReturn().
				getResponse().
				getContentAsString();
		
		JacksonJsonParser parser = new JacksonJsonParser();
		Map<String, Object> map = parser.parseMap(context);
		assertEquals("1001", map.get("respCode"));
	}
	
}
