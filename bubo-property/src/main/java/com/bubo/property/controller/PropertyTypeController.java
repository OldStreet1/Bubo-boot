package com.bubo.property.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.bubo.common.core.domain.entity.SysDept;
import com.bubo.property.service.IPropertyTypeService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bubo.common.annotation.Log;
import com.bubo.common.core.controller.BaseController;
import com.bubo.common.core.domain.AjaxResult;
import com.bubo.common.enums.BusinessType;
import com.bubo.property.domain.PropertyType;
import com.bubo.common.utils.poi.ExcelUtil;
import com.bubo.common.core.page.TableDataInfo;

/**
 * 资产管理类型Controller
 * 
 * @author hongjj
 * @date 2024-03-28
 */
@RestController
@RequestMapping("/property/type")
public class PropertyTypeController extends BaseController
{
    @Autowired
    private IPropertyTypeService propertyTypeService;

    /**
     * 查询资产管理类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:type:list')")
    @GetMapping("/list")
    public TableDataInfo list(PropertyType propertyType)
    {
        startPage();
        List<PropertyType> list = propertyTypeService.selectPropertyTypeList(propertyType);
        return getDataTable(list);
    }

    /**
     * 导出资产管理类型列表
     */
    @PreAuthorize("@ss.hasPermi('system:type:export')")
    @Log(title = "资产管理类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PropertyType propertyType)
    {
        List<PropertyType> list = propertyTypeService.selectPropertyTypeList(propertyType);
        ExcelUtil<PropertyType> util = new ExcelUtil<PropertyType>(PropertyType.class);
        util.exportExcel(response, list, "资产管理类型数据");
    }

    /**
     * 获取资产管理类型详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:type:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(propertyTypeService.selectPropertyTypeById(id));
    }

    /**
     * 新增资产管理类型
     */
    @PreAuthorize("@ss.hasPermi('system:type:add')")
    @Log(title = "资产管理类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PropertyType propertyType)
    {
        return toAjax(propertyTypeService.insertPropertyType(propertyType));
    }

    /**
     * 修改资产管理类型
     */
    @PreAuthorize("@ss.hasPermi('system:type:edit')")
    @Log(title = "资产管理类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PropertyType propertyType)
    {
        return toAjax(propertyTypeService.updatePropertyType(propertyType));
    }

    /**
     * 删除资产管理类型
     */
    @PreAuthorize("@ss.hasPermi('system:type:remove')")
    @Log(title = "资产管理类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(propertyTypeService.deletePropertyTypeByIds(ids));
    }


    @PostMapping("/treeselect")
    public AjaxResult treeselect(@RequestBody PropertyType propertyType)
    {
        return AjaxResult.success(propertyTypeService.buildTreeSelect(propertyType));
    }
}
