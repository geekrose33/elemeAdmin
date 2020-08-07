package com.neusoft.view;

public interface BusinessView {
    public void listBusinessAll();

    public void listBusinessInsert(String businessName,String businessPass);

    public void listBusinessSelect(String keyword);

    public void listBusinessDelete();

}
