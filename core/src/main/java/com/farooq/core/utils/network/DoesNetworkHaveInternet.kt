package com.farooq.core.utils.network

import dagger.hilt.android.scopes.ActivityScoped
import timber.log.Timber
import java.io.IOException
import java.net.InetSocketAddress
import javax.inject.Inject
import javax.net.SocketFactory

/**
 * Send a ping to googles primary DNS.
 * If successful, that means we have internet.
 */

@ActivityScoped
class DoesNetworkHaveInternet @Inject constructor(){

    // Make sure to execute this on a background thread.
    fun execute(socketFactory: SocketFactory): Boolean {
        return try {
            Timber.tag(TAG).d("PINGING google.")
            val socket = socketFactory.createSocket() ?: throw IOException("Socket is null.")
            socket.connect(InetSocketAddress("8.8.8.8", 53), 1500)
            socket.close()
            Timber.tag(TAG).d("PING success.")
            true
        }catch (e: IOException) {
            Timber.tag(TAG).e("No internet connection. $e")
            false
        }
    }


    companion object{
        private const val TAG = "NetworkConnection"
    }

}