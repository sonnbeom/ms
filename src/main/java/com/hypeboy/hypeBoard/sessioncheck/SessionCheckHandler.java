package com.hypeboy.hypeBoard.sessioncheck;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class SessionCheckHandler {
    public Authentication getAuthentication(){
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
