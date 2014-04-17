class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
		
		"/rest/$sku?"(controller: "rest", parseRequest: true) {
			action = [GET: "getProperties"]
		}
		
		"/rest/user/$sku?"(controller: "rest", parseRequest: true) {
			action = [GET: "getUser", PUT: "registerUser"]
		}
		
		name register: "/register"(view:"/home/register")
		name logout: "/logout"(view:"/home/logout")
	}
}
