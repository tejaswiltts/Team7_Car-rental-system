package com.ltts.carrental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ltts.carrental.model.Booking;
import com.ltts.carrental.model.Product;
import com.ltts.carrental.service.BookingService;
import com.ltts.carrental.model.User;
import com.ltts.carrental.repository.UserRepository;

@Controller
public class AppController {
 
    @Autowired
    private ProductService service;

	        @RequestMapping("/index1")
		    public String viewBookingPage(Model model) {
		        List<Product> listProducts = service.listAll();
		        model.addAttribute("listProducts", listProducts);
		        return "index1";
	    }
	        
	        @RequestMapping("/new")
	        public String showNewProductPage(Model model) {
	            Product product = new Product();
	            model.addAttribute("product", product);
	             
	            return "new_product";
	        }
	        @RequestMapping(value = "/save", method = RequestMethod.POST)
	        public String saveProduct(@ModelAttribute("product") Product product) {
	            service.save(product);
	             
	            return "redirect:/index1";
	        }

	        @RequestMapping("/edit/{id}")
	        public ModelAndView showEditProductPage(@PathVariable(name = "id") long id) {
	            ModelAndView mav = new ModelAndView("edit_product");
	            Product product = service.get(id);
	            mav.addObject("product", product);
	             
	            return mav;
	        }
	        
	        @RequestMapping("/delete/{id}")
	        public String deleteProduct(@PathVariable(name = "id") int id) {
	            service.delete(id);
	            return "redirect:/index1";       
	        }
	
	
	
	        @Autowired
	        private BookingService service1;
	    	    
	    	    @RequestMapping("/index2")
	    	    public String viewHomePage(Model model) {
	    	            List<Booking> listBooking = service1.listAll();
	    	            model.addAttribute("listBooking", listBooking);
	    	        return "index2";
	    	    }
	        
	    	    @RequestMapping("/new2")
	            public String showNewBookingPage(Model model) {
	              Booking booking = new Booking();
	                model.addAttribute("booking", booking);
	                 
	                return "new_booking";
	            }
	            @RequestMapping(value = "/save2", method = RequestMethod.POST)
	            public String saveBooking(@ModelAttribute("booking") Booking booking) {
	                service1.save(booking);
	                 
	                return "redirect:/index2";
	            }

	            @RequestMapping("/edit2/{Id}")
	            public ModelAndView showEditBookingPage(@PathVariable(name = "Id") long Id) {
	                ModelAndView mav = new ModelAndView("edit_booking");
	               Booking booking = service1.get(Id);
	                mav.addObject("booking", booking);
	                 
	                return mav;
	            }
	            
	            @RequestMapping("/delete2/{Id}")
	            public String deleteBooking(@PathVariable(name = "Id") int Id) {
	                service1.delete(Id);
	                return "redirect:/index2";       
	            }
				/*
				 * @RequestMapping("/price") public String showBookingPage(Model model) {
				 * 
				 * return "display"; }
				 * 
				 * 
				 * @RequestMapping("/cal") public String showResultPage(Model model) {
				 * 
				 * return "display"; }
				 */
	            
	    	    
	        
	
	        @Autowired
	    	private UserRepository userRepo;
		
		@GetMapping("/")
		public String viewHomePage() {
			return "index";
		}
		
		@GetMapping("/register")
		public String showRegistrationForm(Model model) {
			model.addAttribute("user", new User());
			
			return "signup_form";
		}
		
		@PostMapping("/process_register")
		public String processRegister(User user) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			
			userRepo.save(user);
			
			return "register_success";
		}
		
		@GetMapping("/users")
		public String listUsers(Model model) {
			List<User> listUsers = userRepo.findAll();
			model.addAttribute("listUsers", listUsers);
			
			return "users";
		}
	}