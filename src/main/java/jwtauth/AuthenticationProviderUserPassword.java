package jwtauth;

import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.*;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import jwtauth.model.Login;
import jwtauth.service.LoginInterfaceImp;
import org.reactivestreams.Publisher;

import javax.inject.Singleton;
import java.util.ArrayList;

@Singleton
public class AuthenticationProviderUserPassword implements AuthenticationProvider {

    private final LoginInterfaceImp loginInterfaceImp;



    public AuthenticationProviderUserPassword(LoginInterfaceImp loginInterfaceImp) {
        this.loginInterfaceImp = loginInterfaceImp;
    }

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?,?> authenticationRequest){
        System.out.println("In");

        System.out.println(loginInterfaceImp.getLogin(authenticationRequest.getIdentity().toString()).getPassword().toString());
        System.out.println(loginInterfaceImp.getLogin(authenticationRequest.getIdentity().toString()).getUsername());
        return Flowable.create(emitter -> {
            if(authenticationRequest.getIdentity().equals(loginInterfaceImp.getLogin(authenticationRequest.getIdentity().toString()).getUsername()) &&
            authenticationRequest.getSecret().equals(loginInterfaceImp.getLogin(authenticationRequest.getIdentity().toString()).getPassword().toString())){
                emitter.onNext(new UserDetails((String) authenticationRequest.getIdentity(),new ArrayList<>()));
                emitter.onComplete();

            }else {
                emitter.onError(new AuthenticationException(new AuthenticationFailed()));
            }
        } , BackpressureStrategy.ERROR) ;
    }
}
