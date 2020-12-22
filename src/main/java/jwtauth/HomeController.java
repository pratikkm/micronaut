package jwtauth;

import com.nimbusds.jose.shaded.json.JSONObject;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.annotation.*;
import io.micronaut.security.annotation.Secured;
import io.micronaut.security.rules.SecurityRule;
import io.netty.handler.codec.http.HttpResponseStatus;
import jwtauth.model.Login;
import jwtauth.service.LoginInterfaceImp;

import java.security.Principal;

@Secured(SecurityRule.IS_AUTHENTICATED)
@Controller
public class HomeController {

    private final LoginInterfaceImp loginInterfaceImp;

    public HomeController(LoginInterfaceImp loginInterfaceImp) {
        this.loginInterfaceImp = loginInterfaceImp;
    }

    @Get("/get")
    public String index(Principal principal){
        return principal.getName();

    }

    @Get("/hey")
    public String hello() {
        return "hello";
    }

    @Secured(SecurityRule.IS_ANONYMOUS)
    @Post("/addUser")
    public HttpResponse<String> save(@Body Login login){
        String s = loginInterfaceImp.save(login.getUsername(),login.getPassword());
        return HttpResponse.status(HttpStatus.OK).body("inserted succesfully");
    }


    @Get("/getLogin/{username}")
    public HttpResponse<Login> getLogin(@PathVariable String username){
        Login lg = loginInterfaceImp.getLogin(username);
        System.out.println(lg.getUsername().toString());
        return HttpResponse.status(HttpStatus.OK).body(lg);
    }

}
