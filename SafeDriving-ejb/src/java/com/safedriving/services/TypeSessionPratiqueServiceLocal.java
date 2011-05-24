/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.TypeSessionPratique;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Grm
 */
@Local
public interface TypeSessionPratiqueServiceLocal {

    void add(TypeSessionPratique type);

    void refresh(TypeSessionPratique type);

    void remove(TypeSessionPratique type);

    List<TypeSessionPratique> getAll();

    TypeSessionPratique getById(long id);

    TypeSessionPratique getByName(String name);
}
