package com.example.drawermenu

/*

@created in 01/01/2022 - 1:31 PM
@project Drawer Menu
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

sealed class Navigate {

    object Profile : Navigate()

    object Engine : Navigate()

    object Report : Navigate()

    object TimeItem : Navigate()



}