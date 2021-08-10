package com.itheima.service.Impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import com.itheima.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private RoleDao roleDao;

    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> list() {
        return roleDao.finAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
