package org.zerock.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class BoardControllerTests {
	@Setter(onMethod_ = { @Autowired })
	private WebApplicationContext ctx;

	public MockMvc mockMvc;

	@Before
	public void ready() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
		log.info("mockMvc was maked by ready(): "+mockMvc);
	}

	@Test
	public void testList() throws Exception{
		log.info("test1");
		
		log.info(
		mockMvc.perform(
				get("/board/list")
				.param("page", "1")
				)
		.andReturn()
		.getModelAndView()
		.getModel()
		);
	}

	@Test
	public void testRegister() {
		log.info("test2");
		
		try {
			log.info(
			mockMvc.perform(
					post("/board/register")
					.param("title", "titleTest")
					.param("content", "contentTest")
					.param("writer", "writerTest")
					).andReturn().getModelAndView().getModel() );
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
