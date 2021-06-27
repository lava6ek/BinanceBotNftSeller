package model.marketResponseDTO;

import com.fasterxml.jackson.annotation.*;

public class Owner {
    private String avatarURL;
    private String nickName;

    @JsonProperty("avatarUrl")
    public String getAvatarURL() { return avatarURL; }
    @JsonProperty("avatarUrl")
    public void setAvatarURL(String value) { this.avatarURL = value; }

    @JsonProperty("nickName")
    public String getNickName() { return nickName; }
    @JsonProperty("nickName")
    public void setNickName(String value) { this.nickName = value; }
}
