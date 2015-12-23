package org.krams.tutorial.controller;

import java.util.List;
import javax.annotation.Resource;
import org.apache.log4j.Logger;
import org.krams.tutorial.domain.Person;
import org.krams.tutorial.domain.Uttara;
import org.krams.tutorial.service.PersonService;
import org.krams.tutorial.service.UttaraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/person"})
public class PersonController
{
    protected static Logger logger = Logger.getLogger("controller");
    @Resource(name="personService")
    private PersonService personService;
    @Resource(name="uttaraService")
    private UttaraService uttaraService;

    @RequestMapping(value={"/persons"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String getPersons(Model model)
    {
        logger.debug("Received request to show all persons");

        List<Person> persons = this.personService.getAll();

        model.addAttribute("persons", persons);

        return "person/personspage";
    }

    @RequestMapping(value={"/personJson"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    @ResponseBody
    public List<Person> getPersonsJson(Model model)
    {
        logger.debug("Received request to show all persons");

        return this.personService.getAll();
    }

    @RequestMapping(value={"/persons/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String getAdd(Model model)
    {
        logger.debug("Received request to show add page");

        model.addAttribute("personAttribute", new Person());

        return "person/addpage";
    }

    @RequestMapping(value={"/persons/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String add(@ModelAttribute("personAttribute") Person person)
    {
        logger.debug("Received request to add new person");

        this.personService.add(person);

        return "redirect:/login/person/persons";
    }

    @RequestMapping(value={"/person/view"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String getEditf(@RequestParam(value="id", required=true) Integer id, Model model)
    {
        logger.debug("Received request to show edit page");

        model.addAttribute("personAttribute", this.personService.get(id));
        Person person = this.personService.get(id);

        return "person/viewpage";
    }

    @RequestMapping(value={"/persons/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String getEdit(@RequestParam("id") Integer personId, Model model)
    {
        logger.debug("Received request to show edit page");

        Person existingPerson = this.personService.get(personId);

        model.addAttribute("personAttribute", existingPerson);

        return "person/editpage";
    }

    @RequestMapping(value={"/persons/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String postEdit(@RequestParam("id") Integer personId, @ModelAttribute("personAttribute") Person person)
    {
        logger.debug("Received request to add update person");

        person.setId(personId);

        this.personService.edit(person);

        return "redirect:/login/person/persons";
    }

    @RequestMapping({"/persons/image"})
    @ResponseBody
    public byte[] showImage(@RequestParam("id") Integer personId)
    {
        byte[] b = this.personService.get(personId).getPhoto();

        return b;
    }

    @RequestMapping(value={"/persons/uttaraJson"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    @ResponseBody
    public List<Uttara> viewUttara(@RequestParam("id") Integer personId, @ModelAttribute("uttaraAttribute") Uttara uttara)
    {
        logger.debug("Received request to add new uttara");

        return this.uttaraService.getAll(personId);
    }
}
