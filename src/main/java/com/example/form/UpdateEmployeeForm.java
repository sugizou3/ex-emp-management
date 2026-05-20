package com.example.form;

import lombok.*;

/**
 * 従業員更新時に使用するフォーム.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UpdateEmployeeForm {
    /**
     * 従業員ID
     */
    private Integer id;
    /**
     * 扶養人数
     */
    private String dependantsCount;
}
