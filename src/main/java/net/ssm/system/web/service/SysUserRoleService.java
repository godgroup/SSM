package net.ssm.system.web.service;

import net.ssm.system.web.pojo.SysUserRole;
import net.ssm.system.web.pojo.UserRoleVo;

import java.util.List;

/**
 * Created by Administrator on 2017/11/18.
 */
public interface SysUserRoleService {
    int deleteByPrimaryKey(SysUserRole key);

    int deleteByuid(Long uid);

    int insert(SysUserRole record);

    int insertSelective(SysUserRole record);

    int insertBatch(List<SysUserRole> record);

    UserRoleVo selectSysRoleByuid(Long uid);
}
