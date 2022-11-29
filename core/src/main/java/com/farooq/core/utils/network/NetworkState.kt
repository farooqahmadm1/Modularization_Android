package com.farooq.core.utils.network


sealed class NetworkState{
    object Available: NetworkState()
    object Poor: NetworkState()
    object Lost: NetworkState()
}