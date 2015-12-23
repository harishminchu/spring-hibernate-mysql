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
@RequestMapping({"uttara"})
public class UttaraController
{
    protected static Logger logger = Logger.getLogger("controller");
    @Resource(name="personService")
    private PersonService personService;
    @Resource(name="uttaraService")
    private UttaraService uttaraService;

    @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String getAdd(@RequestParam("id") Integer personId, Model model)
    {
        logger.debug("Received request to show add page");

        Uttara uttara = new Uttara();
        uttara.setPerson(this.personService.get(personId));

        model.addAttribute("uttaraAttribute", uttara);

        return "uttara/addpage";
    }

    @RequestMapping(value={"/add"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String postAdd(@RequestParam("id") Integer personId, @ModelAttribute("uttaraAttribute") Uttara uttara)
    {
        logger.debug("Received request to add new uttara" + uttara.getImportant());

        this.uttaraService.add(personId, uttara);

        return "redirect:/login/person/persons/edit?id=" + personId;
    }

    @RequestMapping(value={"/delete"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String getDelete(@RequestParam("id") Integer uttaraId)
    {
        logger.debug("Received request to delete uttara");

        this.uttaraService.delete(uttaraId);

        return "redirect:/login/person/persons";
    }

    @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String getEdit(@RequestParam("id") Integer uttaraId, Model model)
    {
        logger.debug("Received request to show edit page");

        Uttara existingUttara = this.uttaraService.get(uttaraId);

        model.addAttribute("uttaraAttribute", existingUttara);

        return "uttara/editpage";
    }

    @RequestMapping(value={"/edit"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public String postEdit(@RequestParam("id") Integer uttaraId, @ModelAttribute("uttaraAttribute") Uttara uttara)
    {
        logger.debug("Received request to add new uttara");

        uttara.setId(uttaraId);

        this.uttaraService.edit(uttara);

        Uttara uttara1 = this.uttaraService.get(uttaraId);

        logger.debug("Received request to  Edit uttara id = " + uttara1.getPerson().getId());

        return "redirect:/login/person/persons/edit?id=" + uttara1.getPerson().getId();
    }

    @RequestMapping(value={"/uttaraJson"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    @ResponseBody
    public List<Uttara> viewUttara(@RequestParam("id") Integer personId, @ModelAttribute("uttaraAttribute") Uttara uttara)
    {
        logger.debug("Received request to add new uttara");

        return this.uttaraService.getAll(personId);
    }

    @RequestMapping(value={"/view"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
    public String viewUttaraEdit(@RequestParam("id") Integer personId, @ModelAttribute("uttaraAttribute") Uttara uttara, Model model)
    {
        logger.debug("Received request to add new uttara");

        model.addAttribute("id", personId);

        return "uttara/viewpage";
    }
}
