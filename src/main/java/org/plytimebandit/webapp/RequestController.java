package org.plytimebandit.webapp;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@RequestMapping("/")
@EnableWebMvc
public class RequestController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String openRoot(Model model) {
        return "home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView openHome(Model model) {
        return new ModelAndView("home");
    }

    @RequestMapping(value = "/json/{name}", method = RequestMethod.GET,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody JsonData getJson(@PathVariable String name, @RequestParam(required = false) String value, Model model) {
        JsonData jsonData = new JsonData();
        jsonData.setName(name);
        jsonData.setValue(value);

        return jsonData;
    }
}
