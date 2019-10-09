package Pumpkin;

import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@RequiredArgsConstructor
public class GrowRate implements Serializable {



        private final StringBuilder effectDescription = new StringBuilder();

        @Setter
        @Getter
        @NonNull
        private Integer growthRate;

        public void addEffectDescription(String description){
            if(effectDescription.length() > 0){
                effectDescription.append("\n");
            }

            effectDescription.append(description);
        }

        public String getEffectDescription(){
            return effectDescription.toString();
        }

        public String toString(){
            return "Growthrate: " + getGrowthRate() +"\n" + getEffectDescription();
        }

    }


