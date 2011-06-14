/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.WebSiteRole;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface WebSiteRoleServiceLocal {

    void add(WebSiteRole webSiteRole);

    void remove(WebSiteRole webSiteRole);

    void refresh(WebSiteRole webSiteRole);

    List<WebSiteRole> getAll();

    WebSiteRole getById(int id);

    WebSiteRole getByRoleName(String roleName);
    
}
