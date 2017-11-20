package net.ssm.system.web.service.impl;


import net.ssm.system.web.dao.SysUserRoleMapper;
import net.ssm.system.web.pojo.SysUserRole;
import net.ssm.system.web.pojo.UserRoleVo;
import net.ssm.system.web.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/18.
 */
@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    @Override
    public int insert(SysUserRole record) {
        return 0;
    }

    @Override
    public int insertSelective(SysUserRole record) {
        return 0;
    }

    @Override
    public int deleteByuid(Long uid) {
        return sysUserRoleMapper.deleteByuid(uid);
    }

    @Override
    public int insertBatch(List<SysUserRole> record) {
        return sysUserRoleMapper.insertBatch(record);
    }

    @Override
    public UserRoleVo selectSysRoleByuid(Long uid) {
        return  sysUserRoleMapper.selectSysRoleByuid(uid);
    }

    @Override
    public int deleteByPrimaryKey(SysUserRole key) {
        return 0;
    }
}
