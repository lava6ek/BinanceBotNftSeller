package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MarketRequest {
    private long category;
    private String keyword;
    private String orderBy;
    private long orderType;
    private long page;
    private long rows;

    @JsonProperty("category")
    public long getCategory() { return category; }
    @JsonProperty("category")
    public void setCategory(long value) { this.category = value; }

    @JsonProperty("keyword")
    public String getKeyword() { return keyword; }
    @JsonProperty("keyword")
    public void setKeyword(String value) { this.keyword = value; }

    @JsonProperty("orderBy")
    public String getOrderBy() { return orderBy; }
    @JsonProperty("orderBy")
    public void setOrderBy(String value) { this.orderBy = value; }

    @JsonProperty("orderType")
    public long getOrderType() { return orderType; }
    @JsonProperty("orderType")
    public void setOrderType(long value) { this.orderType = value; }

    @JsonProperty("page")
    public long getPage() { return page; }
    @JsonProperty("page")
    public void setPage(long value) { this.page = value; }

    @JsonProperty("rows")
    public long getRows() { return rows; }
    @JsonProperty("rows")
    public void setRows(long value) { this.rows = value; }
}
