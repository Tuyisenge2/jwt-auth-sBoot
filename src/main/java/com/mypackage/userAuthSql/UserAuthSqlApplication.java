// package com.mypackage.userAuthSql;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.web.bind.annotation.PostMapping;

// @SpringBootApplication
// public class UserAuthSqlApplication {

// 	public static void main(String[] args) 
// 	{
// 		SpringApplication.run(UserAuthSqlApplication.class, args);
// 	}

// 	@PostMapping("/home")
// 	public String home(){
// 		return "api v1 home ";
// 	}
// }

package com.mypackage.userAuthSql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class UserAuthSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAuthSqlApplication.class, args);
    }

    // @GetMapping("/api/auth/login")
    // public String home() {
    //     return "api v1 home ";
    // }
}
