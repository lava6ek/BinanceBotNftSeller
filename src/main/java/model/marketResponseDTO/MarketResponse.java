package model.marketResponseDTO;

import com.fasterxml.jackson.annotation.*;

public class MarketResponse {
    private String code;
    private Object message;
    private Object messageDetail;
    private Data data;
    private boolean success;

    @JsonProperty("code")
    public String getCode() { return code; }
    @JsonProperty("code")
    public void setCode(String value) { this.code = value; }

    @JsonProperty("message")
    public Object getMessage() { return message; }
    @JsonProperty("message")
    public void setMessage(Object value) { this.message = value; }

    @JsonProperty("messageDetail")
    public Object getMessageDetail() { return messageDetail; }
    @JsonProperty("messageDetail")
    public void setMessageDetail(Object value) { this.messageDetail = value; }

    @JsonProperty("data")
    public Data getData() { return data; }
    @JsonProperty("data")
    public void setData(Data value) { this.data = value; }

    @JsonProperty("success")
    public boolean getSuccess() { return success; }
    @JsonProperty("success")
    public void setSuccess(boolean value) { this.success = value; }
}