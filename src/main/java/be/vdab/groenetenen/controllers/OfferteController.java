package be.vdab.groenetenen.controllers;

import be.vdab.groenetenen.domain.Offerte;
import be.vdab.groenetenen.services.OfferteService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("offertes")
@SessionAttributes("offerte") //???
class OfferteController {
    private final OfferteService offerteService;
    private static final String REDIRECT_URL_NA_TOEVOEGEN = "redirect:/";
    //CONSTRUCTORS
    OfferteController(OfferteService offerteService)
    {
        this.offerteService = offerteService;
    }

    @InitBinder("offerte") //FORM NAAR SESSION
    void initBinder(DataBinder dataBinder)
    {
        dataBinder.initDirectFieldAccess();
    }

    //MAPPINGS
    @GetMapping("toevoegen")
    public ModelAndView stap1(){
        return new ModelAndView("offerteStap1").addObject(new Offerte());
    }

    @PostMapping("toevoegen")
    public String naarStep2(@Validated(Offerte.Stap1.class) Offerte offerte, Errors errors)
    {
        return errors.hasErrors() ? "offerteStap1" : "offerteStap2";
    }

    @PostMapping(value = "toevoegen", params = "stap1")
    public String naarStap1(Offerte offerte)
    {
        return "offerteStap1";
    }

    @PostMapping(value = "toevoegen", params = "opslaan")
    public String create(@Validated(Offerte.Stap2.class) Offerte offerte, Errors errors, SessionStatus session)
    {
        if (errors.hasErrors())
        {
            return "offerteStap2";
        }
        offerteService.create(offerte);
        session.setComplete();
        return "redirect:/";
    }
}
