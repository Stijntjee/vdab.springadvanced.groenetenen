package be.vdab.groenetenen.controllers;

import be.vdab.groenetenen.domain.Offerte;
import be.vdab.groenetenen.services.OfferteService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("offertes")
@SessionAttributes("offerte") //???
class OfferteController {
    private final OfferteService offerteService;
    //CONSTRUCTORS
    OfferteController(OfferteService offerteService)
    {
        this.offerteService = offerteService;
    }
    @GetMapping("toevoegen")
    public ModelAndView stap1(){
            return new ModelAndView("offerteStap1").addObject(new Offerte());
    }
    @InitBinder("offerte") //FORM NAAR SESSION
    void initBinder(DataBinder dataBinder)
    {
        dataBinder.initDirectFieldAccess();
    }
}
