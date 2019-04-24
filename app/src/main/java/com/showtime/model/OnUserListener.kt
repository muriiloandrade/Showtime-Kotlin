package com.showtime.model

interface OnUserListener {

    fun onSuccess(user: User, auth_token: String)

    fun onFailure(msg: String)

}