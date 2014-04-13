class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
		
		
		name register: "/register"(view:"/home/register")
		name logout: "/logout"(view:"/home/logout")
	}
}
