package controllers;

import javax.faces.bean.*;
import javax.faces.context.FacesContext;

import beans.UserModel;

@ManagedBean
@ViewScoped
public class FormController {
	public String onSubmit(UserModel u) {
		FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("usermodel", u);
		return "Response.xhtml";
	}
}
