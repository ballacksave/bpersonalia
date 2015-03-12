package org.bareng.hr.back.service;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.bareng.hr.back.entity.Organization;
import org.bareng.hr.back.repository.OrganizationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
@Transactional(readOnly = true)
public class MybatisOrganizationService implements OrganizationService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MybatisOrganizationService.class);
    
    private OrganizationRepository organizationRepository;

    @Autowired
    public MybatisOrganizationService(OrganizationRepository organizationRepository) {
        Assert.notNull(organizationRepository, "Organization repository parameter msut not be null");
        this.organizationRepository = organizationRepository;
    }
    
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
        return organizationRepository.findOne(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Organization register(Organization organization) {
        organizationRepository.insert(organization);
        return organization;
    }

    @Override
    public boolean isRegistered(Integer id) {
        return organizationRepository.exists(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void remove(Integer id) {
        organizationRepository.delete(id);
    }
}
