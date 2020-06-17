package com.example.testeandroidhearthstone.network

import okhttp3.Interceptor
import okhttp3.Response

class SupportInterceptor:Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .addHeader("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
            .addHeader("x-rapidapi-key", "7a2d05ed37mshb0c0b7505d57680p16c282jsn1e9775f4eae2")
            .addHeader("useQueryString","true")
            .build()
        return chain.proceed(request)
    }

}