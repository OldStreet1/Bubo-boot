package com.bubo.property.mapper;

import java.util.List;
import com.bubo.property.domain.PropertyType;

/**
 * 资产管理类型Mapper接口
 * 
 * @author hongjj
 * @date 2024-03-28
 */
public interface PropertyTypeMapper 
{
    /**
     * 查询资产管理类型
     * 
     * @param id 资产管理类型主键
     * @return 资产管理类型
     */
    public PropertyType selectPropertyTypeById(Long id);

    /**
     * 查询资产管理类型列表
     * 
     * @param propertyType 资产管理类型
     * @return 资产管理类型集合
     */
    public List<PropertyType> selectPropertyTypeList(PropertyType propertyType);

    /**
     * 新增资产管理类型
     * 
     * @param propertyType 资产管理类型
     * @return 结果
     */
    public int insertPropertyType(PropertyType propertyType);

    /**
     * 修改资产管理类型
     * 
     * @param propertyType 资产管理类型
     * @return 结果
     */
    public int updatePropertyType(PropertyType propertyType);

    /**
     * 删除资产管理类型
     * 
     * @param id 资产管理类型主键
     * @return 结果
     */
    public int deletePropertyTypeById(Long id);

    /**
     * 批量删除资产管理类型
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePropertyTypeByIds(Long[] ids);
}
