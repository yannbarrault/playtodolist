package controllers;

import models.*;
import play.data.*;
import play.mvc.Controller;
import play.mvc.Result;

public class Application extends Controller {

	static Form<Task> taskForm = Form.form(Task.class);

	public static Result index() {
		return redirect(routes.Application.tasks());
		// return ok(index.render("Your new application is ready."));
	}

	public static Result tasks() {
		return ok(views.html.index.render(Task.all(), taskForm));
	}

	public static Result newTask() {
		Form<Task> filledForm = taskForm.bindFromRequest();
		if (filledForm.hasErrors()) {
			return badRequest(views.html.index.render(Task.all(), filledForm));
		} else {
			Task.create(filledForm.get());
			return redirect(routes.Application.tasks());
		}
	}

	public static Result deleteTask(Long id) {
		Task.delete(id);
		return redirect(routes.Application.tasks());
	}

}
