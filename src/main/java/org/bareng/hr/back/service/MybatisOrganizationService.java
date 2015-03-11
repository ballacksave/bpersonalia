package org.bareng.hr.back.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.bareng.hr.back.entity.Organization;
import org.bareng.hr.back.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

@Validated @Service
@Transactional(readOnly=true)
public class MybatisOrganizationService implements OrganizationService {
	private OrganizationRepository organizationRepository;
	
	@Override
	public List<Organization> getOrganizations() {
		return organizationRepository.findAll();
	}

	@Override
	public Page<Organization> getOrganzations(Pageable pageable) {
		RowBounds rowBounds = new RowBounds(pageable.getOffset(), pageable.getPageSize());
		List<Organization> content = organizationRepository.findAll(rowBounds);
		Long total = organizationRepository.countAll();
		Page<Organization> page = new PageImpl<>(content, pageable, total);
		return page;
	}

	@Override
	public Organization getOrganization(Integer id) {
		return null;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Organization register(Organization organization) {
		return null;
	}

	@Override
	public boolean isRegistered(Integer organization) {
		return false;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public void remove(Integer id) {
		
	}

	/**
	 * Using setter injection will simplify testing, no need for reflection.
	 * 
	 * @param organizationRepository
	 */
	@Autowired
	public void setOrganizationRepository(OrganizationRepository organizationRepository) {
		this.organizationRepository = organizationRepository;
	}
}
