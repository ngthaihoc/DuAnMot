package com.mycompany.projectone.util;

import com.mycompany.projectone.entity.Account;
import lombok.Builder;


@Builder
public class XAuth {
    public static Account account = Account.builder()
            .accountID(1)
            .username("quanly")
            .password("123")
            .status(1)
            .employeeID(1)
            .build();
}