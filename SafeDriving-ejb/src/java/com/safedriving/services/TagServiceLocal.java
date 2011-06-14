/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.safedriving.services;

import com.safedriving.model.blog.Tag;
import javax.ejb.Local;
import java.util.List;

/**
 *
 * @author Grm
 */
@Local
public interface TagServiceLocal {

    void add(Tag tag);

    List<Tag> getAllTag();
    
}
