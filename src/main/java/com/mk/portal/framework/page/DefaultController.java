package com.mk.portal.framework.page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	@RequestMapping(value = "/mohit")
	public String index(Model model) {
		System.out.println("Mohit !!");
		model.addAttribute("pageId","thisIsPageId");
	    return "index";
	}
}
