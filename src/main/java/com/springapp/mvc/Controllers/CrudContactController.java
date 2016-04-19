package com.springapp.mvc.Controllers;

import com.springapp.mvc.Model.Contact;
import com.springapp.mvc.Service.ContactService;
import com.springapp.mvc.Service.ContactServiceXMLFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Map;

@Controller
@RequestMapping("/crud")
public class CrudContactController {

	@Autowired
	private ContactService contactService;

	@Autowired
	private ContactServiceXMLFile contactServiceXMLFile;

	@RequestMapping( method = RequestMethod.POST, value = "/add")
	public String addContact(
			@ModelAttribute("contact")@Valid Contact contact,
			BindingResult result,@RequestParam("account_id") Long loginId, Map map) throws IOException, ClassNotFoundException {

		if (result.hasErrors()) {
			return "addContact";
		}

		contactService.addContact(contact, loginId);

		map.put("account_id", loginId);
		contactServiceXMLFile.addContact(contact);


		return "redirect:/crud";

	}

	@RequestMapping("/delete/{contactId}/{accountId}")
	public String deleteContact(@PathVariable("contactId") Long contactId, @PathVariable("accountId") Long accountId, ModelMap modelMap) {

		try{
			contactService.removeContact(contactId);
			contactServiceXMLFile.removeContact(contactId);

		}
		catch (Exception e){
			System.out.println(e.getStackTrace());
		}

		modelMap.addAttribute("account_id",accountId);

		return "redirect:/crud";
	}



	@RequestMapping(method = RequestMethod.GET)
	public String displayContactForm(ModelMap model, @RequestParam("account_id")Long account_id/*, @RequestParam("success")Boolean success,
									 @RequestParam("userName")String userName*/) {

			model.addAttribute("contact", new Contact());
		//	model.addAttribute("success", success);
			model.addAttribute("usersContactList", contactService.contactListByAccountId(account_id));
			model.addAttribute("account_id", account_id);
		//	model.addAttribute("userName", userName);



		return "addContact";

	}




}
