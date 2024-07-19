package com.bubo.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bubo.common.annotation.Excel;
import com.bubo.common.core.domain.BaseEntity;

/**
 * 资产管理类型对象 property_type
 * 
 * @author hongjj
 * @date 2024-03-28
 */
public class PropertyType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 主键 */
    @Excel(name = "主键")
    private String objId;

    /** 父主键ID */
    @Excel(name = "父主键ID")
    private String pid;

    /** 类型名称 */
    @Excel(name = "类型名称")
    private String typeName;

    /** 类型编码 */
    @Excel(name = "类型编码")
    private String typeCode;

    /** 地理类型：标点 mark   区域 grid  线路  line  */
    @Excel(name = "地理类型：标点 mark   区域 grid  线路  line ")
    private String geographyType;

    /** 线的颜色 */
    @Excel(name = "线的颜色")
    private String strokeColour;

    /** 线的宽度 */
    @Excel(name = "线的宽度")
    private String strokeWeight;

    /** 填充颜色 */
    @Excel(name = "填充颜色")
    private String fillColour;

    /** 地图图标 */
    @Excel(name = "地图图标")
    private String mapIcon;

    /** 独管单位ID */
    @Excel(name = "独管单位ID")
    private String dorgId;

    /** 删除标识 */
    @Excel(name = "删除标识")
    private String deleteFlag;

    /** 创建人 */
    @Excel(name = "创建人")
    private String createUser;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setObjId(String objId) 
    {
        this.objId = objId;
    }

    public String getObjId() 
    {
        return objId;
    }
    public void setPid(String pid) 
    {
        this.pid = pid;
    }

    public String getPid() 
    {
        return pid;
    }
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setTypeCode(String typeCode) 
    {
        this.typeCode = typeCode;
    }

    public String getTypeCode() 
    {
        return typeCode;
    }
    public void setGeographyType(String geographyType) 
    {
        this.geographyType = geographyType;
    }

    public String getGeographyType() 
    {
        return geographyType;
    }
    public void setStrokeColour(String strokeColour) 
    {
        this.strokeColour = strokeColour;
    }

    public String getStrokeColour() 
    {
        return strokeColour;
    }
    public void setStrokeWeight(String strokeWeight) 
    {
        this.strokeWeight = strokeWeight;
    }

    public String getStrokeWeight() 
    {
        return strokeWeight;
    }
    public void setFillColour(String fillColour) 
    {
        this.fillColour = fillColour;
    }

    public String getFillColour() 
    {
        return fillColour;
    }
    public void setMapIcon(String mapIcon) 
    {
        this.mapIcon = mapIcon;
    }

    public String getMapIcon() 
    {
        return mapIcon;
    }
    public void setDorgId(String dorgId) 
    {
        this.dorgId = dorgId;
    }

    public String getDorgId() 
    {
        return dorgId;
    }
    public void setDeleteFlag(String deleteFlag) 
    {
        this.deleteFlag = deleteFlag;
    }

    public String getDeleteFlag() 
    {
        return deleteFlag;
    }
    public void setCreateUser(String createUser) 
    {
        this.createUser = createUser;
    }

    public String getCreateUser() 
    {
        return createUser;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("objId", getObjId())
            .append("pid", getPid())
            .append("typeName", getTypeName())
            .append("typeCode", getTypeCode())
            .append("geographyType", getGeographyType())
            .append("strokeColour", getStrokeColour())
            .append("strokeWeight", getStrokeWeight())
            .append("fillColour", getFillColour())
            .append("mapIcon", getMapIcon())
            .append("dorgId", getDorgId())
            .append("deleteFlag", getDeleteFlag())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createUser", getCreateUser())
            .toString();
    }
}
