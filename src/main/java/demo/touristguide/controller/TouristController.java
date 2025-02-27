package demo.touristguide.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import demo.touristguide.model.TouristAttraction;
import demo.touristguide.service.TouristService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService){
        this.touristService = touristService;
    }

    @GetMapping("/attractions")
    public String getAllAttractions(Model model){
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        model.addAttribute("attractions", attractions);
        return "attractionList";
    }

    @GetMapping("/{name}/tags")
    public String getAttractionTags(@PathVariable String name, Model model) {
        TouristAttraction attraction = touristService.getAttractionByName(name);
        model.addAttribute("attraction", attraction);
        return "tags";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {

        TouristAttraction newAttraction = new TouristAttraction("", "", "");
        List<String> cities = touristService.getAllCities();
        List<String> allTags = touristService.getAllTags();

        model.addAttribute("attraction", newAttraction);
        model.addAttribute("cities", cities);
        model.addAttribute("allTags", allTags);

        return "addAttraction";
    }

    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute TouristAttraction attraction) {
        touristService.addAttraction(attraction);
        return "redirect:/attractions";
    }





}