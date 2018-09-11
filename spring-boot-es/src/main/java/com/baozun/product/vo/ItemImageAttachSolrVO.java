package com.baozun.product.vo;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.context.annotation.Description;
@Data
@Description("[对外]")
public class ItemImageAttachSolrVO {
    @JsonIgnore
    @JSONField(serialize = false)
    private Long itemId;
    @JsonIgnore
    @JSONField(serialize = false)
    private String tenantCode;//租户ID
    @JsonIgnore
    @JSONField(serialize = false)
    private Integer targetType;
    @JsonIgnore
    @JSONField(serialize = false)
    private Long targetId;
    @JsonIgnore
    @JSONField(serialize = false)
    private Integer relType;
    //媒体类型：1:图片，2：视频，3：文件
    private Integer mediaType;
    //路径
    private String url;
    //缩略图顺序
    private Integer sort;

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ItemImageAttachSolrVO other = (ItemImageAttachSolrVO) obj;
        if (itemId == null) {
            if (other.itemId != null)
                return false;
        } else if (!itemId.equals(other.itemId))
            return false;
        if (mediaType == null) {
            if (other.mediaType != null)
                return false;
        } else if (!mediaType.equals(other.mediaType))
            return false;
        if (relType == null) {
            if (other.relType != null)
                return false;
        } else if (!relType.equals(other.relType))
            return false;
        if (targetId == null) {
            if (other.targetId != null)
                return false;
        } else if (!targetId.equals(other.targetId))
            return false;
        if (targetType == null) {
            if (other.targetType != null)
                return false;
        } else if (!targetType.equals(other.targetType))
            return false;
        if (tenantCode == null) {
            if (other.tenantCode != null)
                return false;
        } else if (!tenantCode.equals(other.tenantCode))
            return false;
        if (url == null) {
            if (other.url != null)
                return false;
        } else if (!url.equals(other.url))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
        result = prime * result + ((mediaType == null) ? 0 : mediaType.hashCode());
        result = prime * result + ((relType == null) ? 0 : relType.hashCode());
        result = prime * result + ((targetId == null) ? 0 : targetId.hashCode());
        result = prime * result + ((targetType == null) ? 0 : targetType.hashCode());
        result = prime * result + ((tenantCode == null) ? 0 : tenantCode.hashCode());
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }


}
