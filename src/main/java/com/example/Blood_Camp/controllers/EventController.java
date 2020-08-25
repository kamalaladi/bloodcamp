package com.example.Blood_Camp.controllers;


import com.example.Blood_Camp.models.Donor;
import com.example.Blood_Camp.models.Event;

import com.example.Blood_Camp.models.data.EventDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("events")

public class EventController {
    @Autowired
    private EventDao eventDao;

//    @PostMapping //path or route
//    public String viewevent(Model model,Event event,@RequestParam(required = false) int[] eventIds) { // route handler method
//        model.addAttribute("title", "event details");
//        if (eventIds != null) {
//            for (int id : eventIds) {
//                model.addAttribute("events", eventDao.findById(id));
//            }
//        }
//        return "events/view";
//    }

    @GetMapping("create")
    public String displayEventForm(Model model) {
        model.addAttribute("title", " Create Event");
        model.addAttribute(new Event());
        return "events/create";


    }

    @PostMapping("create")
    public String processEventForm(@ModelAttribute @Valid Event newEvent, Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }

        eventDao.save(newEvent);
//        model.addAttribute("title","All donors");
//        model.addAttribute("donors", donorDao.findAll());
        return "redirect:";

    }

//    @GetMapping
//    public String renderviewEventForm(Model model,Event event) {
//        model.addAttribute("events", eventDao.findById(event.getId()));
//
//        return "events/view";
//    }
    @GetMapping("view/{eventId}")
    public String displayViewEmployer(Model model, @PathVariable int eventId){

//        Optional optEmployer = null;
        Optional optEvent = eventDao.findById(eventId);
     if (optEvent.isPresent()) {
            Event event = (Event) optEvent.get();
            model.addAttribute("event", event);
            return "events/view";
        } else {
            return "redirect:../";
    }
}
}


