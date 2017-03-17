package com.photoexchange.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.photoexchange.models.Photo;
import com.photoexchange.service.PhotoServiceImpl;
import com.photoexchange.service.UserServiceImpl;


@Controller
@RequestMapping("/photo")
public class PhotoController {
	
	@Autowired
	private PhotoServiceImpl photoService;
	
	@Autowired
	private UserServiceImpl userService;
	
	
	@GetMapping("/add")
	public String addPhotoPage(Model model) {
		model.addAttribute("photoForm", new Photo());
		model.addAttribute("allUsers", userService.getAll());
        return "addPhoto";
	}
	
	@PostMapping("/add")
	public String create(Photo photo, Model model) {
		photoService.create(photo);
		model.addAttribute("photoForm", new Photo());
		model.addAttribute("allUsers", userService.getAll());
		return "addPhoto";
	}
}
