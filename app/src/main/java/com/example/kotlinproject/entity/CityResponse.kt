package com.example.kotlinproject.entity

import java.util.UUID

class CityResponse (
    val id: UUID,
    val name:String,
    val city:String,
    val wifi:Float,
    val seat:Float,
    val quiet:Float,
    val tasty:Float,
    val cheap:Float,
    val music:Float,
    val url:String,
    val address:String,
    val latitude:String,
    val longitude:String,
    val limited_time:String,
    val socket:String,
    val standing_desk:String,
    val mrt:String,
    val open_time:String
)