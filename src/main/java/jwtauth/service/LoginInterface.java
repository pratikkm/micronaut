package jwtauth.service;

import com.sun.source.doctree.SeeTree;
import jwtauth.model.Login;

public interface LoginInterface {

    public String save(String username , String password );

    public Login getLogin(String username);
}
