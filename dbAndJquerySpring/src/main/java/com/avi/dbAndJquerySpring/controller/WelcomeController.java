package com.avi.dbAndJquerySpring.controller;

import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WelcomeController {
	
	@Autowired
	private TestDAO testDAO;
	@RequestMapping("/greeting")
	public Long getName(@RequestParam(value="name", defaultValue="World") String a) {
		Long total = testDAO.getData();
		
		return total;
	}

}
