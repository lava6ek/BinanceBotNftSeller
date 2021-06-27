package model.marketResponseDTO;

import com.fasterxml.jackson.annotation.*;

public class Data {
    private long total;
    private Row[] rows;

    @JsonProperty("total")
    public long getTotal() { return total; }
    @JsonProperty("total")
    public void setTotal(long value) { this.total = value; }

    @JsonProperty("rows")
    public Row[] getRows() { return rows; }
    @JsonProperty("rows")
    public void setRows(Row[] value) { this.rows = value; }
}
