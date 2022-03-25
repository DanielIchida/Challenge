package com.mercadolibre.challenge.domain.events;

import java.util.List;

public interface HumanContract {
    interface OnResponseHumanValidate{
       void onCallback(boolean isMutant);
    }
    interface OnResponseStats{
        void onCallback(int humans,int mutants,double ratio);
    }
    interface OnResponseListDna{
        void onCallBack(List<String> dna);
    }
}
