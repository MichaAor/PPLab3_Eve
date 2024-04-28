/*
* Primer Parcial      Comisión 3
! IMPORTANTE:
!   ● Crear un proyecto con su Nombre y Apellido (solamente).
!   ● Añadir comentarios a su código, modularice y sea prolijo en la codificación,
!    no sumará puntos pero podría restar.
!   ● Al finalizar, comprimir en un archivo solamente con su apellido para luego
!    subirlo al campus
!   ● No se pide ingreso por teclado de ningún tipo.

? Narrativa: Desarrolle el sistema para una empresa de pedidos de comidas.
?   Los Usuarios registrados en el Sistema, pueden hacer pedidos a diferentes
?    Locales adheridos al Sistema.
?   Los Locales adheridos tienen diferentes platos que ofrecen a sus clientes,
?    los platos obviamente tienen su precio.
?   Cada pedido puede tener diferentes platos, y mas de uno de cada uno de ellos.
?   Los locales tienen diferentes metodos de pago.
?   Se requiere que cada método de pago tenga un porcentaje de recargo que luego
?   será aplicado al total de pedido. No todos los locales necesariamente tienen
?    todos los metodos de pago.
?   El sistema cuenta con dos opciones de entrega, aplicadas a todos los locales,
?    Entrega a Domicilio y Take Away.

*   1) Crear las distintas clases presentes en el texto. Respetar nombres y atributos.
*   2) Para cada clase generar un método ToString donde contenga toda la información
*    de la misma.
*   3) Crear las instancias de pedidos listadas a continuacion, y todas las instancias
*    necesarias, y agregarlas a un ArrayList.
*   ● Un pedido con dos platos diferentes, pagado de contado y entrega a domicilio
*   ● Un pedido con un plato, pagado con tarjeta, y entrega take away
*   4) Según nuestro cliente, la entrega en mostrador o Take Away, es sencilla, el usuario
*    pasa por local donde se hizo el pedido, abona y se retira, pero el Envío a Domicilio,
*    tiene cierta complejidad adicional que debe ser tenida en cuenta, el domicilio de
*    entrega, que podria no ser el propio del Usuario. Una vez entregado el pedido,
*    éste debe quedar marcado en nuestra lista. Aplicar Interfaces para abordar la solución.
*   5) Se solicita un método que al momento de abonar, despliegue los datos del cliente, un
*    detalle del pedido, el total, la forma de pago, el recargo de la misma se existiera, y el
*    nuevo total.
*/

import Model.*;
import Model.Simple.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //exercise3();
        exercise4();
    }

//?                       ╔═══════════════╗
//?                       ║  EJERCICIO 3  ║
//?                       ╚═══════════════╝
    public static void exercise3(){
        System.out.println("\u001B[36m" + "EJERCICIO 3" + "\u001B[0m");

//! Instancio suport para llenar datos.
        Support support = new Support();

//? Generacion de Usuario
        User user = support.generateUser();

//? Preparamos el Local generando comidas y metodos de pago.
        List<Food> menu = support.generateMenu();
        List<PayMethod> payMethods = new ArrayList<>();
        payMethods.add(support.generateBasicMethod());
        payMethods.add(support.generateCardMethod());

//* Local Cargado
        Local local = new Local("El Buen Gusto",menu,payMethods);

//? Realizamos la seleccion del Usuario (comida disponible en el local y metodo de pago).
        List<Food> selectionFoods = new ArrayList<>();
        selectionFoods.add(menu.get((int) (Math.random() * menu.size() - 0)));
        selectionFoods.add(menu.get((int) (Math.random() * menu.size() - 0)));
        PayMethod selectionPay = payMethods.get(0);

        Order order1 = new Order(user, selectionFoods,selectionPay,"Home Delivery");
        System.out.println(order1);

//? Limpiamos y reutilizamos la lista, repitiendo los pasos anteriores
        selectionFoods.clear();
        selectionFoods.add(menu.get((int) (Math.random() * menu.size() - 0)));
        selectionPay = payMethods.get(1);

        Order order2 = new Order(user, selectionFoods,selectionPay,"Take Away");
        System.out.println(order2);
    }


//?                       ╔═══════════════╗
//?                       ║  EJERCICIO 4  ║
//?                       ╚═══════════════╝
    public static void exercise4(){
        System.out.println("\u001B[36m" + "EJERCICIO 4" + "\u001B[0m");

//! Instancio suport para llenar datos.
        Support support = new Support();

//? Generacion de Usuario
        User user = support.generateUser();

//? Preparamos el Local generando comidas y metodos de pago.
        List<Food> menu = support.generateMenu();
        List<PayMethod> payMethods = new ArrayList<>();
        payMethods.add(support.generateBasicMethod());
        payMethods.add(support.generateCardMethod());

//* Local Cargado
        Local local = new Local("El Buen Gusto",menu,payMethods);

//? Realizamos la seleccion del Usuario (comida disponible en el local y metodo de pago).
        List<Food> selectionFoods = new ArrayList<>();
        selectionFoods.add(menu.get((int) (Math.random() * menu.size() - 0)));
        selectionFoods.add(menu.get((int) (Math.random() * menu.size() - 0)));
        PayMethod selectionPay = payMethods.get(0);

        Order order1 = new Order(user, selectionFoods,selectionPay,"Home Delivery");
        System.out.println(order1);

//? Procedemos con la entrega.
        if(order1.getDelivery().compareTo("Home Delivery") == 0){
            local.homeDelivery(order1);
        }else{
            local.takeAway(order1);
        }
    }
}