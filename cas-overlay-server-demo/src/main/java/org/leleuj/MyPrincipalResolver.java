package org.leleuj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.principal.Principal;
import org.jasig.cas.authentication.principal.PrincipalResolver;
import org.jasig.cas.authentication.principal.SimplePrincipal;

public class MyPrincipalResolver implements PrincipalResolver {

    @Override
    public Principal resolve(Credential credential) {
        String id = "jle";
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("uid", "uid");
        attributes.put("prenom", "edu,Person,Affiliation");
        List<String> listGroup = new ArrayList<String>();
        listGroup.add("group1");
        listGroup.add("group2");
        attributes.put("groupMembership", listGroup);
        List<String> elem = new ArrayList<String>();
        elem.add("elem1");
        attributes.put("oneElement", elem);
        //Entry<String, Object> entry = attributes.entrySet().iterator().next();
        return new SimplePrincipal(id, attributes);
    }

    @Override
    public boolean supports(Credential credential) {
        return true;
    }
}
