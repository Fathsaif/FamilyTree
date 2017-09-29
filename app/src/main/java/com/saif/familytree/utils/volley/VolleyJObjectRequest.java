package com.saif.familytree.utils.volley;


import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.saif.familytree.core.constants.ErrorCodes;
import com.saif.familytree.models.BaseDto;
import com.saif.familytree.utils.LoggerUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class VolleyJObjectRequest extends Request<JSONObject> {

    private Response.Listener<JSONObject> listener;
    private Response.ErrorListener errorListener;
    private Map<String, String> params;
    private int mMethod;
    private String mUrl;

    public VolleyJObjectRequest(String url, Map<String, String> params,
                                Response.Listener<JSONObject> reponseListener, Response.ErrorListener errorListener) {
        super(Method.GET, url, errorListener);
        this.listener = reponseListener;
        this.params = params;
        this.mUrl = url;
        this.mMethod = Method.GET;
    }

    public VolleyJObjectRequest(int method, String url, Map<String, String> params,
                                Response.Listener<JSONObject> reponseListener, Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        this.listener = reponseListener;
        this.errorListener = errorListener;
        this.params = params;
        this.mUrl = url;
        this.mMethod = method;
    }


    @Override
    protected Response<JSONObject> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data,
                    HttpHeaderParser.parseCharset(response.headers));
            LoggerUtil.d("RESPONSE_BEFORE : "+ jsonString);
            return Response.success(new JSONObject(jsonString),
                    HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (JSONException je) {
            return Response.error(new ParseError(je));
        }
    }


    @Override
    protected void deliverResponse(JSONObject response) {
        LoggerUtil.d("RESPONSE_AFTER : "+response.toString());

        BaseDto baseDto = BaseDto.fromJson(response.toString());
        if (baseDto.getApiStatus().equals(ErrorCodes.ServerCodes.FAILURE_RESPONSE_CODE) &&
                baseDto.getError().getErrorId().equals(ErrorCodes.ServerCodes.SESSION_KEY_NOT_VALID)
                &&baseDto.getError().getErrorText().equals("Session id is wrong.")) {
            errorListener.onErrorResponse(new VolleyError(String.valueOf(ErrorCodes.API_KEY_NOT_VALID)));
        } else {
            listener.onResponse(response);
        }
    }

    @Override
    public String getUrl() {
        if (mMethod == Method.GET) {
            StringBuilder stringBuilder = new StringBuilder(mUrl);
            Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
            int i = 1;
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();

                String value = null;

                try {
                    value = URLEncoder.encode(entry.getValue(), "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                if (i == 1) {
                    stringBuilder.append("?" + entry.getKey() + "=" + value);
                } else {
                    stringBuilder.append("&" + entry.getKey() + "=" + value);
                }
                iterator.remove(); // avoids a ConcurrentModificationException
                i++;
            }
            mUrl = stringBuilder.toString();
        }
        LoggerUtil.d("URL : " + mUrl);
        return mUrl;
    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> params = new HashMap<String, String>();
        //params.put("Content-Type", "application/x-www-form-urlencoded");
        return params;
    }

    protected Map<String, String> getParams()
            throws AuthFailureError {
        LoggerUtil.d("PARAMS : "+params.toString());
        return params;
    }

    @Override
    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        return super.setRetryPolicy(new DefaultRetryPolicy(
                (int) TimeUnit.SECONDS.toMillis(20),
                0,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
    }
}