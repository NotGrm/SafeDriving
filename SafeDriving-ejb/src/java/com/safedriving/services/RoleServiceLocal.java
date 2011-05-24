/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import javax.ejb.Local;

/**
 *
 * @author Grm
 */
@Local
public interface RoleServiceLocal {

    public com.safedriving.model.WebSiteRole getById(long id);

    public java.util.List<com.safedriving.model.WebSiteRole> getAll();

    public void refreshWebSiteRole(com.safedriving.model.WebSiteRole role);

    public void removeWebSiteRole(com.safedriving.model.WebSiteRole role);

    public void addWebSiteRole(com.safedriving.model.WebSiteRole role);
    
}
