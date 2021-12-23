package com.arboleda.arboledapayments.dto;


public class ListCompaniesDto {
    private String partialCompanyName;
    private String category;

    public String getPartialCompanyName() {
        return partialCompanyName;
    }

    public void setPartialCompanyName(String partialCompanyName) {
        this.partialCompanyName = partialCompanyName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
