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


    public enum NUM {
        ZERO("0", "0"),
        ONE ("1", "1"),
        TWO("2", "2"),
        THREE("3", "3"),
        FOUR("4", "4"),
        FIVE("5", "5"),
        SIX("6", "6"),
        SEVEN("7", "7"),
        EIGHT("8", "8"),
        NINE("9", "9"),
        TEN("10", "10");


        NUM(String itemCode, String itemText) {
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
