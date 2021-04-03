package com.udaan.machine.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class CommonUtil {

    public static Pageable getPagination(int page, int size){
        return PageRequest.of(page, size);
    }
}
