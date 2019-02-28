package org.pursuit.unit_04_assessment.network;


import org.pursuit.unit_04_assessment.model.EnchinodermList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EchinodermService {
  @GET("JDVila/storybook/master/echinoderms.json")
  Call<EnchinodermList> getEchinoderms();
}
