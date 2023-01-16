package com.jamesvrooney.models;

import com.jamesvrooney.entities.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class SecurityAuthority implements GrantedAuthority {

    private Authority authority;

    @Override
    public String getAuthority() {

        if (authority.isRole()) {
            return "ROLE_" + authority.getName();
        } else {
            return authority.getName();
        }
    }
}
