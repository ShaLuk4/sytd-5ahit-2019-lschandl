package Pumpkin;

import lombok.Getter;

import java.io.Serializable;

public class Environment implements Serializable {
    @Getter
    private Integer daylightRatio;

    public Environment(Integer daylightRatio){


        this.daylightRatio = daylightRatio;
    }

    public Integer getRainRatio(){
        return 100 - this.daylightRatio;
    }



}
