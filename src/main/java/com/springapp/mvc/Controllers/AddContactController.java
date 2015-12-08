package com.springapp.mvc.Controllers;

import com.springapp.mvc.Model.Account;
import com.springapp.mvc.Model.Contact;
import com.springapp.mvc.Service.ContactService;
import com.springapp.mvc.Service.ContactServiceXMLFile;
import com.springapp.mvc.Service.ContactServiceXMLFileImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/add")
public class AddContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping( method = RequestMethod.POST )
	public String addContact(
			@ModelAttribute("contact")@Valid Contact contact,
			BindingResult result,@RequestParam("account_id") Long loginId, Map map) throws IOException, ClassNotFoundException {

		if (result.hasErrors()) {
			return "addContact";
		}

		contactService.addContact(contact, loginId);
		map.put("usersContactList",contactService.contactListByAccountId(loginId));

		ContactServiceXMLFile xmlFile = new ContactServiceXMLFileImpl();
		xmlFile.addContact(contact);

		return "addContact";

	}



	@RequestMapping(method = RequestMethod.GET)
	public String displayContactForm(ModelMap model, @RequestParam("account_id")Long account_id) {

		model.addAttribute("contact", new Contact());
		model.addAttribute("account_id",account_id);


		return "addContact";

	}




}
