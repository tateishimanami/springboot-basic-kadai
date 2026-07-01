package com.example.springkadaitodo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.service.ToDoService;

@Controller
public class ToDoController {
	private final ToDoService todoService;
	
	public ToDoController(ToDoService todoService) {
		this.todoService = todoService;
	}
	
	@GetMapping("/todo")
	public String showToDo(Model model) {		
		// Serviceを呼び出しtodosテーブルのデータを取得し、modelの中に取得したデータを入れる
		model.addAttribute("todos", todoService.getToDoList());
		
		return "todoView";
	}
}
