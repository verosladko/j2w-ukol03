package cz.czechitas.java2webapps.ukol3.controller;

import cz.czechitas.java2webapps.ukol3.entity.People;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
@RequestMapping("/")
public class VizitkaController {

  private final List<People> listOfPeople = List.of(
          new People( "Dita", "Formankova", "dita@czechitas.cz", "+420800123456", "Vaclavske n. 837/11, Praha 1"),
          new People( "Bara", "Buhnova", "bara@czechitas.cz", "+420800123456", "Vaclavske n. 837/11, Praha 1"),
          new People( "Monika", "Ptacnikova", "monika@czechitas.cz", "+420800123456","Vaclavske n. 837/11, Praha 1"),
          new People( "Mirka", "Zatloukalova", "mirka@czechitas.cz", "+420800123456","Vaclavske n. 837/11, Praha 1")
  );

 // @GetMapping("/")
 // public String seznam() {
 //   return "seznam";
//  }

  @GetMapping("/")
  public ModelAndView seznam() {
    ModelAndView modelAndView = new ModelAndView("/");
    modelAndView.addObject("people", listOfPeople);
    return modelAndView;
  }


@GetMapping("/detail/{id}")
  public ModelAndView detail(@PathVariable int id) {
  ModelAndView modelAndView = new ModelAndView("/detail");
  modelAndView.addObject("people", listOfPeople.get(id));
  return modelAndView;
  }

}
