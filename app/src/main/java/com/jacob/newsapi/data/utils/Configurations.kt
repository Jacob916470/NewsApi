package com.jacob.newsapi.data.utils

class Configurations {

    companion object{
        const val PASSWORD_PATTERN = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!\"#\$%&/()=<>+\\-@?_':;])"
        const val MIN_PASSWORD_LENGTH = 8
        const val MAX_PASSWORD_LENGTH = 16
        const val IMAGE_BASE_URL = "https://"
        /** Generamos un const val "NEWS_API_KEY" la cual almacenara nuestra api key que fue asignada
         * desdes nuestro servidor */
        const val NEWS_API_KEY = "dbdd2e18b7cf4fb7b835132846672043"
    }

    /** Se genera un private val "currentConfiguration" la cual alamcenara nuestra URL
     * en  la cual nos encontramos actualmente */
    private val currentConfiguration = "dev"

    /** Generamos un private val "configuration" que sera igualada a un "mapOf" que nos permitira saber en cual
     * URL estamos navegando */
    private val configuration = mapOf(

    /** Apuntamos nuestro String "dev" hacia nuestra "private data class configuration" la cual crearemos una variable
     * "baseURL" de tipo string la cual guardara nuestras direcciones URL*/

        /** Diferentes ambientes con el cual se pueden realizar pruebas */

        "dev" to Configuration(
            baseURL = "https://newsapi.org/v2/"
        ),
        "qa" to Configuration(
            baseURL = "https://newsapi.org/v2/"
        ),
        "release" to Configuration(
            baseURL = "https://newsapi.org/v2/"
        )
    )

    /** Se crea variable privata tipo var "baseURL" de tipo string la cual sera la encargada de recibir y verificar
     * si nuestra URL es basia o no, de nos serlo ingresara a sus servicios */
    private var baseURL: String = ""

    /** Se crea init parapoder ingresar a los datos*/
    init {
        /** Se crea variable "setCofig" para verificar que no sea nulo y le seteamos nuestra URL*/
        val setConfig = configuration[currentConfiguration]
        setConfig?.baseURL?.let { baseURL = it }
    }

    /** Se crea función en la cual sera de tipo String que nos retorna a la variable "baseURL"
     * la cual traera nuestra información */
    fun getBaseURL(): String = baseURL
}

/** Se crea data class la cual tendra una variable "baseURL" que sera de tipo String la cual sera la encargada
 * de almacenar nuestras URL de los diferentes ambientes */
private data class Configuration(
    val baseURL: String = ""
)