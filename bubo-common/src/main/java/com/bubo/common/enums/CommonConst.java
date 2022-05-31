package com.bubo.common.enums;

import org.springframework.stereotype.Component;

/**
 * @author: Hongjj
 * @date: 2022/5/30 11:44
 * @desc: 公共常量
 */

@Component
public class CommonConst {

    public enum IS_FLAG {
        YES("1", "是"),
        NO("0", "否");

        IS_FLAG(String itemCode, String itemText) {
            this.itemCode = itemCode;
            this.itemText = itemText;
        }

        public String itemCode;
        public String itemText;

        public String getCode()
        {
            return itemCode;
        }

        public String getInfo()
        {
            return itemText;
        }

    }

}
