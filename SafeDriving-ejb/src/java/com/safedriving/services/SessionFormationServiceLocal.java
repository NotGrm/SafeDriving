/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.Client;
import com.safedriving.model.Personnel;
import com.safedriving.model.SessionFormation;
import java.util.Date;
import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author Grm
 */
@Local
public interface SessionFormationServiceLocal {

    void refresh(SessionFormation session);
    
    SessionFormation getById(long id);

    List<SessionFormation> findAllByIntervenant(Personnel intervenant);

    List<SessionFormation> getFutureSession(Date date);

    List<SessionFormation> findByClient(Client client);
    
}
