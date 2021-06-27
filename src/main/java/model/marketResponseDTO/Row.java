package model.marketResponseDTO;

import com.fasterxml.jackson.annotation.*;

public class Row {
    private String productID;
    private String title;
    private String coverURL;
    private long tradeType;
    private long nftType;
    private String amount;
    private String currency;
    private long setStartTime;
    private long setEndTime;
    private long timestamp;
    private Long rarity;
    private long status;
    private Owner owner;

    @JsonProperty("productId")
    public String getProductID() { return productID; }
    @JsonProperty("productId")
    public void setProductID(String value) { this.productID = value; }

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("coverUrl")
    public String getCoverURL() { return coverURL; }
    @JsonProperty("coverUrl")
    public void setCoverURL(String value) { this.coverURL = value; }

    @JsonProperty("tradeType")
    public long getTradeType() { return tradeType; }
    @JsonProperty("tradeType")
    public void setTradeType(long value) { this.tradeType = value; }

    @JsonProperty("nftType")
    public long getNftType() { return nftType; }
    @JsonProperty("nftType")
    public void setNftType(long value) { this.nftType = value; }

    @JsonProperty("amount")
    public String getAmount() { return amount; }
    @JsonProperty("amount")
    public void setAmount(String value) { this.amount = value; }

    @JsonProperty("currency")
    public String getCurrency() { return currency; }
    @JsonProperty("currency")
    public void setCurrency(String value) { this.currency = value; }

    @JsonProperty("setStartTime")
    public long getSetStartTime() { return setStartTime; }
    @JsonProperty("setStartTime")
    public void setSetStartTime(long value) { this.setStartTime = value; }

    @JsonProperty("setEndTime")
    public long getSetEndTime() { return setEndTime; }
    @JsonProperty("setEndTime")
    public void setSetEndTime(long value) { this.setEndTime = value; }

    @JsonProperty("timestamp")
    public long getTimestamp() { return timestamp; }
    @JsonProperty("timestamp")
    public void setTimestamp(long value) { this.timestamp = value; }

    @JsonProperty("rarity")
    public Long getRarity() { return rarity; }
    @JsonProperty("rarity")
    public void setRarity(Long value) { this.rarity = value; }

    @JsonProperty("status")
    public long getStatus() { return status; }
    @JsonProperty("status")
    public void setStatus(long value) { this.status = value; }

    @JsonProperty("owner")
    public Owner getOwner() { return owner; }
    @JsonProperty("owner")
    public void setOwner(Owner value) { this.owner = value; }
}
