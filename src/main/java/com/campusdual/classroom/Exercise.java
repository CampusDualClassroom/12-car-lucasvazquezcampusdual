package com.campusdual.classroom;

public class Exercise {
    public static void main(String[] args) {
        Car car = new Car("Citroën", "Xsara", "Diésel");

        System.out.println("¿Tacómetro en cero? " + car.isTachometerEqualToZero());

        System.out.println("Encender el coche");
        car.start();
        System.out.println(" ¿Tacómetro > 0? " + car.isTachometerGreaterThanZero());

        System.out.println("Intentar encender cuando ya está encendido");
        car.start();

        System.out.println("Apagar el coche estando detenido");
        while (car.speedometer > 0) car.brake();
        car.stop();
        System.out.println(" ¿Tacómetro en cero? " + car.isTachometerEqualToZero());

        System.out.println("Intentar apagar el coche en movimiento");
        car.start();
        car.accelerate(); // se mueve
        car.stop();       // no debería dejarlo

        System.out.println("Acelerar el coche");
        car.accelerate();
        car.accelerate();

        System.out.println("Intentar superar la velocidad máxima");
        for (int i = 0; i < 20; i++) car.accelerate();

        System.out.println("Frenar el coche");
        car.brake();

        System.out.println("Frenar hasta intentar valor negativo");
        for (int i = 0; i < 30; i++) car.brake();

        System.out.println("Girar el volante 20 grados");
        car.turnAngleOfWheels(20);
        System.out.println("   " + car.showSteeringWheelDetail());

        System.out.println("Intentar girar el volante 60 grados");
        car.turnAngleOfWheels(60);
        System.out.println("   " + car.showSteeringWheelDetail());

        System.out.println("Detener y poner marcha atrás");
        while (car.speedometer > 0) car.brake();
        car.setReverse(true);
        System.out.println("   ¿R activada? " + car.isReverse());

        System.out.println("Intentar poner R en movimiento hacia delante");
        car.setReverse(false);
        car.accelerate();
        car.setReverse(true);
        System.out.println(" ¿R activada? " + car.isReverse());

        System.out.println("Estado final --");
        car.showDetails();
    }

}