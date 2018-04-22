package com.action;

public class SecurityException extends Exception{
	private static final long serialVersionUID = 1L;
public SecurityException() {
	// TODO Auto-generated constructor stub
	super();
   }
   
   private String message;
   public SecurityException(String message){
    this.message = message;
   }
   
   public String getMessage() {
      return message;
   }

}
