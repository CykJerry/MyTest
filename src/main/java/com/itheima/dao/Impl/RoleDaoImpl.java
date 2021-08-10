package com.itheima.dao.Impl;

import com.itheima.dao.RoleDao;
import com.itheima.domain.Role;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class RoleDaoImpl implements RoleDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Role> finAll() {
        List<Role> roleList = jdbcTemplate.query("select * from sys_role", new BeanPropertyRowMapper<Role>(Role.class));
        return roleList;
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("insert into sys_role value (null ,?,?)",role.getRoleName(),role.getRoleDesc());
    }

    @Override
    public List<Role> findRoleByUserId(Long id) {
        List<Role> roles = jdbcTemplate.query("select * from sys_user_role ur,sys_role r where ur.roleId=r.id and ur.userId=?", new BeanPropertyRowMapper<Role>(Role.class), id);
        return roles;
    }
}
