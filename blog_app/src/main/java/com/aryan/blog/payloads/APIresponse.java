package com.aryan.blog.payloads;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@NoArgsConstructor 
@AllArgsConstructor
@Setter
public class APIresponse {
	
	private String message;
	private boolean success;

}
