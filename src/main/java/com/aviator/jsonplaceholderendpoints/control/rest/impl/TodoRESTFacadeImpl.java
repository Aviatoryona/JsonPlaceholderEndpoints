/*
 * Copyright (C) 2020 Aviator
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package com.aviator.jsonplaceholderendpoints.control.rest.impl;

import com.aviator.jsonplaceholderendpoints.boundary.TodoService;
import com.aviator.jsonplaceholderendpoints.control.rest.TodoRESTFacadeI;
import com.aviator.jsonplaceholderendpoints.entity.ToDo;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Aviator
 */
public class TodoRESTFacadeImpl implements TodoRESTFacadeI {

    @EJB
    TodoService todoService;

    @Override
    public long count() {
        return todoService.count();
    }

    @Override
    public List<ToDo> findRange(int[] range) {
        return todoService.findRange(range);
    }

    @Override
    public List<ToDo> findAll() {
        return todoService.findAll();
    }

    @Override
    public ToDo find(Long id) {
        return todoService.find(id);
    }

    @Override
    public boolean remove(Long id) {
        return todoService.remove(id);
    }

    @Override
    public ToDo edit(ToDo entity) {
        return todoService.edit(entity);
    }

    @Override
    public ToDo create(ToDo entity) {
        return todoService.create(entity);
    }

    @Override
    public List<ToDo> getUserToDos(Long userId) {
        return todoService.getUserToDos(userId);
    }

}
