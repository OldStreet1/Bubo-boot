package com.bubo.common.exception.user;

import com.bubo.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author bubo
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
