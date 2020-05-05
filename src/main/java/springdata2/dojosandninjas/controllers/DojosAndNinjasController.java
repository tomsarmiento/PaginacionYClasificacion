package springdata2.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springdata2.dojosandninjas.models.Dojo;
import springdata2.dojosandninjas.models.Ninja;
import springdata2.dojosandninjas.services.DojosAndNinjasService;
import springdata2.dojosandninjas.services.PaginationService;

@Controller
public class DojosAndNinjasController {
	private final DojosAndNinjasService srv;
	private final PaginationService pSrv;
	
	public DojosAndNinjasController(DojosAndNinjasService srv, PaginationService pSrv) {
		this.srv = srv;
		this.pSrv = pSrv;
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("dojos", srv.allDojos());
		return "dojosandninjas/home.jsp";
	}
	
	@RequestMapping("/dojos/new")
	public String createDojo(@ModelAttribute Dojo d) {
		return "dojosandninjas/newdojo.jsp";
	}
	
	@RequestMapping(value="dojos/new", method=RequestMethod.POST)
	public String saveDojo(@Valid @ModelAttribute Dojo d, BindingResult rslt) {
		if(rslt.hasErrors()) {
			return "dojosandninjas/newdojo.jsp";
		}
		else {
			srv.createDojo(d);
			return "redirect:/home";
		}
	}
	
	@RequestMapping("ninjas/new")
	public String createNinja(@ModelAttribute Ninja n, Model model) {
		model.addAttribute("dojos", srv.allDojos());
		return "dojosandninjas/newninja.jsp";
	}
	
	@RequestMapping(value="ninjas/new", method=RequestMethod.POST)
	public String saveNinja(@Valid @ModelAttribute Ninja n, BindingResult rslt, Model model) {
		if(rslt.hasErrors()) {
			model.addAttribute("dojos", srv.allDojos());
			return "dojosandninjas/newninja.jsp";
		}
		else {
			srv.createNinja(n);
			return "redirect:/home";
		}
	}
	
	@RequestMapping("dojos")
	public String findDojo(Model model, @RequestParam("name") String name) {
		
		model.addAttribute("dojo", srv.findDojoByName(name));
		return "dojosandninjas/dojo.jsp";
	}
	
	@RequestMapping("/pages/{pageNumber}")
	public String getNinjasPerPage(Model model, @PathVariable("pageNumber") int pageNumber) {
		Page<Ninja> ninjas = pSrv.ninjasPerPage(pageNumber - 1);
		int totalPages = ninjas.getTotalPages();
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("ninjas", ninjas);
		return "dojosandninjas/ninjas.jsp";
	}
}
