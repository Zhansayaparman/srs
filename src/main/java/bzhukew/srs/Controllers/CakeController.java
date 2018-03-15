package bzhukew.srs.Controllers;

import bzhukew.srs.repozitores.CakeRepozitory;
import models.Cakes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/cakes")


public class CakeController {

    @Autowired
    private CakeRepozitory cakeRepozitory;
    private long a;

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Cakes> allCakes() { return cakeRepozitory.findAll();
    }

    @GetMapping("/all2")
    public String allCakes2(Model model) {
        List<Cakes> cakess = (List<Cakes>) cakeRepozitory.findAll();
        model.addAttribute("cake", cakess);
        return "cakes";
    }
    @RequestMapping("/add")
    public String cakesForm(Model model) {
        model.addAttribute("cake", new Cakes());
        return "cake_add_form";
    }

    @PostMapping("/add")
    public String addCakes(@ModelAttribute Cakes cakes) {
        cakeRepozitory.save(cakes);
        return "redirect:/cake/all2";
    }

    @RequestMapping(value = "/deleteCakes",method = RequestMethod.GET)
    public ModelAndView deleteCakes(@RequestParam("id") long idd){
        cakeRepozitory.deleteById(idd);
        return new ModelAndView("redirect:/cake/all2");
    }
    @PostMapping("/editCakes")
    public String editCakes(@ModelAttribute Cakes cakes) {
        Cakes cakes11 = new Cakes();
        cakes.setCakes_id(a);
        cakes.setCakes_name(cakes.getCakes_name());
        cakes.setCakes_bagasy(cakes.getCakes_bagasy());
        cakeRepozitory.save(cakes);
        return "redirect:/cakes/all2";
    }
    @RequestMapping(value = "/editCakes",method = RequestMethod.GET)
    public ModelAndView editCakes(Model model,@RequestParam("id") long id){
        a=id;
        Optional<Cakes> cakes = (Optional<Cakes>) cakeRepozitory.findById(id);
        model.addAttribute("cakes",cakes);
        return new ModelAndView("inp");
    }
    @RequestMapping("/editCakes")
    public String bookForm2(Model model){
        model.addAttribute("cakes",new Cakes());
        return "inp";
    }

}
