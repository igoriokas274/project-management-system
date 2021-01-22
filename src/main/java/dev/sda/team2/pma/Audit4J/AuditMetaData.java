package dev.sda.team2.pma.Audit4J;

import org.apache.commons.lang3.StringUtils;
import org.audit4j.core.MetaData;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

public class AuditMetaData implements MetaData {

    @Override
    public String getActor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            return ((User) authentication.getPrincipal()).getUsername() + " " + getRoles();
        }
        return "anonymous";
    }

    private String getRoles() {

        List<String> roles = new ArrayList<>();
        for (GrantedAuthority authority : SecurityContextHolder.getContext().getAuthentication().getAuthorities()) {
            roles.add(authority.toString());
        }
        if (roles.isEmpty()) {
            return "no role";
        } else
            return "roles=[" + StringUtils.join(roles, ", ") + "]";
    }

    @Override
    public String getOrigin() {
        try {
            return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRemoteAddr();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "unidentified";
    }

}
