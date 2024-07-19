package com.bubo.system.service.impl;

import java.util.List;
import com.bubo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bubo.system.mapper.PropertyTypeMapper;
import com.bubo.system.domain.PropertyType;
import com.bubo.system.service.IPropertyTypeService;

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
        propertyType.setCreateTime(DateUtils.getNowDate());
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
}
