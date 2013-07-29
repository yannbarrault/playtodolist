package controllers;

import models.*;
import play.data.*;
import play.mvc.Controller;
import play.mvc.Result;



public class Application extends Controller {

	static Form<Task> taskForm = Form.form(Task.class);
	
	public static Result index() {
		return redirect(routes.Application.tasks());
		//return ok(index.render("Your new application is ready."));
	}

	public static Result tasks() {
		return ok(views.html.index.render(Task.all(), taskForm));
	}

	public static Result newTask() {
		return TODO;
	}

	public static Result deleteTask(Long id) {
		return TODO;
	}

}
