package com.aviator.jsonplaceholderendpoints.boundary.impl;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.aviator.jsonplaceholderendpoints.boundary.ProjectService;
import com.aviator.jsonplaceholderendpoints.entity.Project;

@Stateless
public class ProjectTaskServiceImpl extends AbstractBeanImpl<Project, Long> implements ProjectService {

  @PersistenceContext(unitName = "pu")
  private EntityManager em;

  public ProjectTaskServiceImpl() {
    super(Project.class);
  }

  @Override
  protected EntityManager getEntityManager() {
    return em;
  }
}