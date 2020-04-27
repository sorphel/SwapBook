package com.smallgroup.swapbook.data;

import java.util.Map;

public interface DataManager {

    Map<String, Object> getData();

    void updateData();

    void deleteData();

    void addData();
}
