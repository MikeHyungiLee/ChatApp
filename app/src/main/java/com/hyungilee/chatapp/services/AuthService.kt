package com.hyungilee.chatapp.services

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.hyungilee.chatapp.utilities.URL_REGISTER
import org.json.JSONObject

object AuthService {

    fun registerUser(context: Context, email: String, password: String, complete: (Boolean)->Unit){

        val url = URL_REGISTER

        val jsonBody = JSONObject()
        jsonBody.put("email", email)
        jsonBody.put("password", password)
        val requestBody = jsonBody.toString()

        val registerRequest = object : StringRequest(Request.Method.POST, url, Response.Listener { _ ->
            complete(true)
        },Response.ErrorListener {
                error -> Log.d("ERROR", "Could not register user: $error")
                complete(false)
        }){
            override fun getBodyContentType(): String {
                //header
                return "application/json; charset=utf-8"
            }

            override fun getBody(): ByteArray {
                return super.getBody()
            }
        }
        Volley.newRequestQueue(context).add(registerRequest)
    }

}