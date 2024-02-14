package com.andre.validation;

import com.andre.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * ClassName: StateValidation
 * Package: com.andre.validation
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/8 - 12:06
 * @Version: v1.0
 */
public class StateValidation implements ConstraintValidator<State, String> {

    /**
     * @param value   將來要校驗的資料
     * @param context
     * @return 如果返回false, 則校驗失敗, 如果返回true, 則校驗成功
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // 提供校驗規則
        if (value == null) {
            return false;
        }

        if (value.equals("已發佈") || value.equals("草稿")) {
            return true;
        }

        return false;
    }
}
