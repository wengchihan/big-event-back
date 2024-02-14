package com.andre.anno;

import com.andre.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.*;
import java.lang.reflect.Field;

/**
 * ClassName: State
 * Package: com.andre.anno
 * Description:
 *
 * @Author: Andre
 * @Create: 2024/1/8 - 12:00
 * @Version: v1.0
 */
@Documented // 元註解
@Target({ElementType.FIELD}) // 元註解
@Retention(RetentionPolicy.RUNTIME) // 元註解
@Constraint(validatedBy = {StateValidation.class}) // 指定提供校驗規則的類
public @interface State {

    // 提供校驗失敗後的提示訊息
    String message() default "state參數的值只能是已發佈或者草稿";

    // 指定分組
    Class<?>[] groups() default {};

    // 負載 - 獲取到State註解的附加訊息
    Class<? extends Payload>[] payload() default {};
}
