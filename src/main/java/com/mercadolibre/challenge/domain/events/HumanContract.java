package com.mercadolibre.challenge.domain.events;

public interface HumanContract {
    interface OnResponseHumanValidate{
       void onCallback(boolean isMutant);
    }
    interface OnResponseStats{
        void onCallback(int humans,int mutants,double ratio);
    }
}
