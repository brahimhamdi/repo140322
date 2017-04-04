package com.mygglo.mybatis.controller;

import com.mygglo.mybatis.domain.model.Person;
import com.mygglo.mybatis.domain.repository.PersonRepository;
import com.mygglo.mybatis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jgaglo on 04/04/17.
 */
@Controller
public class PersonController {
  @Autowired
  PersonService personService;

  @RequestMapping("/")
  public String index(Model model){
    model.addAttribute("persons",personService.fetchAll());
    return "list";
  }

  @RequestMapping("/data")
  public String populate(){
    personService.populate();
    return "redirect:/";
  }

  @RequestMapping("/del/{id}")
  public String delete(@PathVariable Long id){
    personService.delete(id);
    return "redirect:/";
  }

  @RequestMapping("/view/{id}")
  public String view(@PathVariable Long id,Model model){
    model.addAttribute("person",personService.findById(id));
    return "save";
  }

  @RequestMapping(value = "/save",method = RequestMethod.POST)
  public String save(@ModelAttribute Person person){
    personService.save(person);
    return "redirect:/";
  }
}
