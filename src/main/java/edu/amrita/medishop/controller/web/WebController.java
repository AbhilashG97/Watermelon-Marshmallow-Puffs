package edu.amrita.medishop.controller.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

import edu.amrita.medishop.model.User;
import edu.amrita.medishop.service.ProductService;
import edu.amrita.medishop.service.UserService;
import edu.amrita.medishop.userdetails.PdfUserDetails;

@SessionAttributes({ "currentUser" })
@Controller
public class WebController {

	@Autowired
	public UserService userService;
	
	@Autowired
	public ProductService productService;

	@RequestMapping("/")
	public String showIndexPage(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "index";
	}

	@RequestMapping("/home")
	public String showHomePage(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "index";
	}

	@RequestMapping("/signup")
	public String showSignupPage(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@RequestMapping("/login")
	public String showLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public String loginError(Model model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus session) {
		SecurityContextHolder.getContext().setAuthentication(null);
		session.setComplete();
		return "redirect:/home";
	}

	@RequestMapping(value = "/postLogin", method = RequestMethod.POST)
	public String postLogin(Model model, HttpSession session) {
		// read principal out of security context and set it to session
		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder
				.getContext().getAuthentication();
		validatePrinciple(authentication.getPrincipal());
		User loggedInUser = ((PdfUserDetails) authentication.getPrincipal()).getUserDetails();
		model.addAttribute("currentUser", loggedInUser.getEmail());
		session.setAttribute("userId", loggedInUser.getId());
		return "redirect:/home";
	}

	private void validatePrinciple(Object principal) {
		if (!(principal instanceof PdfUserDetails)) {
			throw new IllegalArgumentException("Principal can not be null!");
		}
	}

	@PostMapping("/doRegister")
	public String registerUserAccount(@ModelAttribute("user") User user, BindingResult result, WebRequest request) {

		if (!result.hasErrors()) {
			userService.saveUser(user);
			return "redirect:/home";
		}

		return "redirect:/login";
	}
}
