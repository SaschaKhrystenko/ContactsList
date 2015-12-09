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
@RequestMapping("/crud")
public class CrudContactController {

	@Autowired
	private ContactService contactService;

	@RequestMapping( method = RequestMethod.POST, value = "/add")
	public String addContact(
			@ModelAttribute("contact")@Valid Contact contact,
			BindingResult result,@RequestParam("account_id") Long loginId, Map map) throws IOException, ClassNotFoundException {

		if (result.hasErrors()) {
			return "addContact";
		}

		contactService.addContact(contact, loginId);

		map.put("account_id", loginId);
		ContactServiceXMLFile xmlFile = new ContactServiceXMLFileImpl();
		xmlFile.addContact(contact);

		return "redirect:/crud";

	}

	@RequestMapping("/delete/{contactId}/{accountId}")
	public String deleteContact(@PathVariable("contactId") Long contactId, @PathVariable("accountId") Long accountId, ModelMap modelMap) {

		try{
			contactService.removeContact(contactId);
		}
		catch (Exception e){
			System.out.println(e.getStackTrace());
		}

		modelMap.addAttribute("account_id",accountId);

		return "redirect:/crud";
	}



	@RequestMapping(method = RequestMethod.GET)
	public String displayContactForm(ModelMap model, @RequestParam("account_id")Long account_id) {


		model.addAttribute("contact", new Contact());
		model.addAttribute("usersContactList", contactService.contactListByAccountId(account_id));
		model.addAttribute("account_id",account_id);


		return "addContact";

	}




}
