package net.ssm.system.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.ssm.config.SysConfig;
import net.ssm.system.web.dao.SysMenuMapper;
import net.ssm.system.web.pojo.SysMenu;
import net.ssm.system.web.pojo.menu.Node;
import net.ssm.system.web.service.SysMenuService;

import org.springframework.stereotype.Service;

@Service
public class SysMenuServiceImpl implements SysMenuService {

	@Resource
	private SysMenuMapper sysMenuMapper;
	@Override
	public List<SysMenu> GetMenuList() {
		
		return	sysMenuMapper.selectSysMenuList();
	}
	@Override
	public int insert(SysMenu menu) {
		return	sysMenuMapper.insert(menu);
	}
	@Override
	public SysMenu selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return sysMenuMapper.selectByPrimaryKey(id);
	}
	public int updateByPrimaryKeySelective(SysMenu menu) {
		// TODO Auto-generated method stub
		return sysMenuMapper.updateByPrimaryKeySelective(menu);
	}  
    public List<Node> getNodeList(Long id,Integer type,List<SysMenu> allMenuList)
    {
    	if(allMenuList==null||allMenuList.size()==0)
    	{
    		return null;
    	}
    	List<Node> nodelist = new ArrayList<Node>();//转换为node
		for (SysMenu menu : allMenuList) {
			if(id!=null&& menu.getId()==id)
			{
				continue;//编辑菜单时，菜单树里过滤掉自己的id(自己不能设置父菜单为自己)
			}
			Node node=new Node();
			node.setTitle(menu.getName());
			node.setId(menu.getId());
			node.setName(menu.getName());
			node.setParentid(menu.getParent_id());
			if(type!=null&&type==1)//加载左侧菜单列表时需要设置href,添加菜单时的tres不需要设置href
			{
				if(SysConfig.getContextPath()!=null)
				  node.setHref(SysConfig.getContextPath()+menu.getHref());
				else
					node.setHref(SysConfig.getContextPath() + menu.getHref());
				node.setIcon(menu.getIcon());
			}
			
			nodelist.add(node);
		}
		List<Node> list = new ArrayList<Node>();//递归好的菜单列表
		
		for (Node item : nodelist) {
			if (item.getParentid() == 0) {
				item.setChildren(addchild(item.getId(),nodelist));
				list.add(item);
			}
		}
    	return list;
    }
    public List<Node> getNodeList(Long id,Integer type,List<SysMenu> allMenuList,List<SysMenu> roleMenuList)
    {
    	if(allMenuList==null||allMenuList.size()==0)
    	{
    		return null;
    	}
    	List<Node> nodelist = new ArrayList<Node>();//转换为node
		for (SysMenu menu : allMenuList) {
			if(id!=null&& menu.getId()==id)
			{
				continue;//编辑菜单时，菜单树里过滤掉自己的id(自己不能设置父菜单为自己)
			}
			Node node=new Node();
			node.setTitle(menu.getName());
			node.setId(menu.getId());
			node.setName(menu.getName());
			node.setParentid(menu.getParent_id());
			if(type!=null&&type==1)//加载左侧菜单列表时需要设置href,添加菜单时的tres不需要设置href
			{
				if(SysConfig.getContextPath()!=null)
				  node.setHref(SysConfig.getContextPath()+menu.getHref());
				else
					node.setHref(SysConfig.getContextPath() + menu.getHref());
				node.setIcon(menu.getIcon());
			}
			for (SysMenu roleMenu : roleMenuList) {
				if(roleMenu.getId()==menu.getId())
				{
					node.setChecked(true);
					node.setCheckboxValue(menu.getId());
					break;
				}
			}
			
			nodelist.add(node);
		}
		List<Node> list = new ArrayList<Node>();//递归好的菜单列表
		
		for (Node item : nodelist) {
			if (item.getParentid() == 0) {
				item.setChildren(addchild(item.getId(),nodelist));
				list.add(item);
			}
		}
    	return list;
    }
	/**
	 * 递归查出指定Parentid的子菜单
	 * @param parentId
	 * @param nodelist
	 * @return
	 */
	public List<Node> addchild(Long parentId,List<Node>  nodelist) {
		List<Node> childList = new ArrayList<Node>();//子菜单列表
		for (Node node : nodelist) {
			if (node.getParentid() == parentId) {
			    node.setChildren(addchild(node.getId(), nodelist));
				childList.add(node);
			}
		}
		return childList;
	}
	
}
