package fr.esgi.newsfeed.helpers.retrofit;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Ozone on 15/07/2017.
 */

public class AuthenticationInterceptor implements Interceptor {

	private String authToken;

	public AuthenticationInterceptor(String token) {
		this.authToken = token;
	}

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request original = chain.request();

		Request.Builder builder = original.newBuilder()
				.header("Authorization", authToken);

		Request request = builder.build();
		Log.d("ServiceGenerator", String.format("Interceptor request: %s", request.toString()));
		return chain.proceed(request);
	}
}
