/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.ParticipationSession;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ehres
 */
@Local
public interface participationSessionServiceLocal {

    void add(ParticipationSession partSession);

    void remove(ParticipationSession partSession);

    void refresh(ParticipationSession partSession);

    List<ParticipationSession> getByClientId(long id);
    
}
