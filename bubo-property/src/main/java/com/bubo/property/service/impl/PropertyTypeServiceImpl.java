package com.bubo.property.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import cn.hutool.Hutool;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.bubo.common.core.domain.TreeSelect;
import com.bubo.common.core.domain.entity.SysDept;
import com.bubo.common.enums.CommonConst;
import com.bubo.common.utils.DateUtils;
import com.bubo.common.utils.StringUtils;
import com.bubo.common.utils.uuid.IdUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bubo.property.mapper.PropertyTypeMapper;
import com.bubo.property.domain.PropertyType;
import com.bubo.property.service.IPropertyTypeService;

import static com.bubo.common.utils.SecurityUtils.getUserId;

/**
 * 资产管理类型Service业务层处理
 * 
 * @author hongjj
 * @date 2024-03-28
 */
@Service
public class PropertyTypeServiceImpl implements IPropertyTypeService 
{
    @Autowired
    private PropertyTypeMapper propertyTypeMapper;

    /**
     * 查询资产管理类型
     * 
     * @param id 资产管理类型主键
     * @return 资产管理类型
     */
    @Override
    public PropertyType selectPropertyTypeById(Long id)
    {
        return propertyTypeMapper.selectPropertyTypeById(id);
    }

    /**
     * 查询资产管理类型列表
     * 
     * @param propertyType 资产管理类型
     * @return 资产管理类型
     */
    @Override
    public List<PropertyType> selectPropertyTypeList(PropertyType propertyType)
    {
        return propertyTypeMapper.selectPropertyTypeList(propertyType);
    }

    /**
     * 新增资产管理类型
     * 
     * @param propertyType 资产管理类型
     * @return 结果
     */
    @Override
    public int insertPropertyType(PropertyType propertyType)
    {
        PropertyType propertyTypeSelect = new PropertyType();
        propertyTypeSelect.setDeleteFlag(CommonConst.IS_FLAG.NO.itemCode);
        propertyTypeSelect.setTypeName(propertyType.getTypeName());
        List<PropertyType> propertyTypes = propertyTypeMapper.selectPropertyTypeList(propertyTypeSelect);
        if (CollUtil.isNotEmpty(propertyTypes)){
            return 0;
        }
        if (StrUtil.isEmpty(propertyType.getPid())){
            propertyType.setPid(CommonConst.NUM.ZERO.itemCode);
        }
        propertyType.setObjId(IdUtils.simpleUUID());
        propertyType.setCreateTime(DateUtils.getNowDate());
        propertyType.setUpdateTime(DateUtils.getNowDate());
        propertyType.setCreateUser(getUserId().toString());
        propertyType.setDeleteFlag(CommonConst.IS_FLAG.NO.itemCode);
        return propertyTypeMapper.insertPropertyType(propertyType);
    }

    /**
     * 修改资产管理类型
     * 
     * @param propertyType 资产管理类型
     * @return 结果
     */
    @Override
    public int updatePropertyType(PropertyType propertyType)
    {
        propertyType.setUpdateTime(DateUtils.getNowDate());
        return propertyTypeMapper.updatePropertyType(propertyType);
    }

    /**
     * 批量删除资产管理类型
     * 
     * @param ids 需要删除的资产管理类型主键
     * @return 结果
     */
    @Override
    public int deletePropertyTypeByIds(Long[] ids)
    {
        return propertyTypeMapper.deletePropertyTypeByIds(ids);
    }

    /**
     * 删除资产管理类型信息
     * 
     * @param id 资产管理类型主键
     * @return 结果
     */
    @Override
    public int deletePropertyTypeById(Long id)
    {
        return propertyTypeMapper.deletePropertyTypeById(id);
    }

    @Override
    public List<PropertyType> buildTreeSelect(PropertyType propertyType) {
        propertyType.setDeleteFlag(CommonConst.IS_FLAG.NO.itemCode);
        List<PropertyType> propertyTypes = selectPropertyTypeList(propertyType);
        return buildDeptTree(propertyTypes);
    }


    /**
     * 构建前端所需要树结构
     *
     */
    public List<PropertyType> buildDeptTree(List<PropertyType> depts)
    {
        List<PropertyType> returnList = new ArrayList<PropertyType>();
        List<String> tempList = new ArrayList<String>();
        for (PropertyType dept : depts)
        {
            tempList.add(dept.getObjId());
        }
        for (Iterator<PropertyType> iterator = depts.iterator(); iterator.hasNext();)
        {
            PropertyType dept = (PropertyType) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(dept.getPid()))
            {
                recursionFn(depts, dept);
                returnList.add(dept);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = depts;
        }
        return returnList;
    }


    /**
     * 递归列表
     */
    private void recursionFn(List<PropertyType> list, PropertyType t)
    {
        // 得到子节点列表
        List<PropertyType> childList = getChildList(list, t);
        t.setChildren(childList);
        for (PropertyType tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }


    /**
     * 得到子节点列表
     */
    private List<PropertyType> getChildList(List<PropertyType> list, PropertyType t)
    {
        List<PropertyType> tlist = new ArrayList<PropertyType>();
        Iterator<PropertyType> it = list.iterator();
        while (it.hasNext())
        {
            PropertyType n = (PropertyType) it.next();
            if (StringUtils.isNotNull(n.getPid()) && StrUtil.equals(n.getPid(),t.getObjId()))
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<PropertyType> list, PropertyType t)
    {
        return getChildList(list, t).size() > 0;
    }

}
