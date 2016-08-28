package com.bankofshanghai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnalysisController {

	@RequestMapping("/analysis")
	public String analysis(){
		return "analysis";
	}
	
}
