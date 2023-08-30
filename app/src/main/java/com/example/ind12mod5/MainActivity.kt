package com.example.ind12mod5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main(){
    val usuarios = mutableListOf<Usuario>()
    println("ingresar cantidad de usuarios")
    val cantidadUsuarios = readln().toInt()
    for(i in 1 .. cantidadUsuarios){
        println("ingresar el nombre")
        var nombre = readln()
        while(!validarNombre(nombre)){
            println("nombre invalido, ingresar un nombre valido")
            nombre = readln()
        }
        var apellido = readln()
        while(!validarApellido(apellido)){
            println("apellido invalido, ingresar un apellido valido")
            apellido = readln()
        }
        var edad = readln().toInt()
        while(!validarEdad(edad)){
            println("edad invalida, ingresar una edad valida")
            edad = readln().toInt()
        }
        var correo = readln()
        while(!validarCorreo(correo)){
            println("correo invalido, ingresar un correo valido")
            correo = readln()
        }
        var sistemaSalud = readln()
        while(!validarSistemaSalud(sistemaSalud)){
            println("sistema de salud invalido, ingresar un sistema de salud valido")
            sistemaSalud = readln()
        }
        val usuario =  Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)
    }
    for(u in usuarios.sortedBy{
            usuario -> usuario.edad
    }){
        println("$u")
    }
}


fun validarNombre(nombre: String) : Boolean{
    return nombre.length in 1..20

}
fun validarApellido(lastName: String): Boolean{
    return lastName.length in 1..20
}

fun validarEdad (age: Int): Boolean{
    return age in 0..150
}

fun validarCorreo(email: String): Boolean{
    return email.length in 10..200 && email.contains('@')
}

fun validarSistemaSalud(sistemaSalud: String): Boolean {
    return sistemaSalud == "Fonasa" || sistemaSalud == "Isapre" || sistemaSalud == "fonasa" || sistemaSalud == "isapre"
}

data class Usuario(var nombre: String, var apellido: String, var edad: Int, var correo: String, var sistemaSalud: String)