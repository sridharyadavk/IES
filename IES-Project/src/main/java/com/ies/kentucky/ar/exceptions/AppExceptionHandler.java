package com.ies.kentucky.ar.exceptions;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;




@Controller
@ControllerAdvice
public class AppExceptionHandler{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7532526297810295511L;
	
	
	
	@ExceptionHandler(value= NoSSNFoundException.class)	
	public String handleNoSSNFoundException(Model model){
		
		model.addAttribute("error", "Invalid SSN");
		
		return "applicationReg";	
	
}

}
