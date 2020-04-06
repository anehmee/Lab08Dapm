package com.codiful.labd;

import java.util.List;

public class ItemGroup {
    private  String headerTitle;
    private List<ItemList>  listItem;

    public ItemGroup() {
    }

    public String getHeaderTitle() {
        return headerTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        this.headerTitle = headerTitle;
    }

    public List<ItemList> getListItem() {
        return listItem;
    }

    public void setListItem(List<ItemList> listItem) {
        this.listItem = listItem;
    }
}
