package sjsu.cmpe295.controllers

import sjsu.cmpe295.models.User

class UserController {

	def registerUser()
	{	printf("In UserController/registerUSer()")
		
		// capture params
		String firstname = params.fname;
		String lastname= params.lname;
		String email = params.email;
		String password = params.password;
		
		// create user object
		User user = new User();
		
		// fill info
		user.setFirstname(firstname)
		user.setLastname(lastname)
		user.setEmail(email)
		user.setPassword(password)
		
		// commit to database
		user.save(flush:true)
		if(user.getErrors().toString().contains(" 0 "))
		session.username = firstname
		render(view:'/home/index')
	}
	
	def authenticateUser()
	{	
		printf("In UserController/authenticateUser()")
		
		String email = params.email;
		String password = params.password;
		
		// Search in db for user object
		
		User user = User.findByEmailAndPassword(email,password)
		
		if(user != null)
		{	printf("User authenticated")
			session.username = user.getFirstname()
			session.lastname = user.getLastname()
			session.email = user.getEmail()
			render(view:'/home/index')
		}
		else
		{ printf("User not authenticated")	
			render(view:'/error')
		}
	}
	
	def logout()
	{
		printf("In UserController/logout()")
		
		//session.invalidate()
		session.username = null
		session.lastname = null
		session.email = null
		render(view:'/home/index')
	}
}
