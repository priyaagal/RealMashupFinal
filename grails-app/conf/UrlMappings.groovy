class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.${format})?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
		
		
		name logout: "/logout"(view:"/home.register")
		name listings: "/listings"(view:"/home.listings")
	}
}
