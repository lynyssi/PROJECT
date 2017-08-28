package com.mirin.tech.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mirin.tech.service.ProjectVo;
import com.mirin.tech.service.ProjectServiceImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class IndexController {
	
	@Autowired
	ProjectServiceImpl pi;
	
	@RequestMapping(value = "/index.do" )
	public String index(HttpServletRequest request, HttpServletResponse response) {
		String pCate = "TECH";
	
		if(request.getParameter("pCate") != null){
			pCate = request.getParameter("pCate").trim();
		}
		 
		ArrayList<ProjectVo> alist = new ArrayList<ProjectVo>();
		
		alist = pi.projListByCate(pCate);
		
		request.setAttribute("alist", alist);


		return "index";
	}
	
}
