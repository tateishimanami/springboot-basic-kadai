package com.example.springkadaiform.controller;

import jakarta.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
	 @GetMapping("/form")
	    public String showForm(@ModelAttribute ContactForm contactForm) {
	        return "contactFormView";
	    }

	    @PostMapping("/confirm")
	    public String confirm(
	            @Valid @ModelAttribute ContactForm contactForm,
	            BindingResult bindingResult,
	            RedirectAttributes redirectAttributes) {

	        if (bindingResult.hasErrors()) {
	            redirectAttributes.addFlashAttribute("contactForm", contactForm);

	            for (FieldError error : bindingResult.getFieldErrors()) {
	                redirectAttributes.addFlashAttribute(
	                        "error_" + error.getField(),
	                        error.getDefaultMessage()
	                );
	            }

	            return "redirect:/form";
	        }

	        return "confirmView";
	    }
}
